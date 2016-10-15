package io.github.sopheakboth83;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.wadpam.guja.cache.annotations.CacheAnnotationsModule;
import com.wadpam.guja.config.GujaBaseModule;
import com.wadpam.guja.config.GujaContactModule;
import com.wadpam.guja.config.GujaCoreModule;
import com.wadpam.guja.config.GujaGaeModule;
import com.wadpam.guja.jackson.NonNullObjectMapperProvider;
import com.wadpam.guja.oauth2.api.ConnectionResource;
import com.wadpam.guja.oauth2.dao.DConnectionDaoBean;
import com.wadpam.guja.oauth2.web.OAuth2Filter;
import com.wadpam.guja.oauth2.web.Oauth2ClientAuthenticationFilter;
import com.wadpam.guja.persist.MardaoDatastoreModule;
import com.wadpam.guja.web.CORSFilter;
import io.github.sopheakboth83.api.CompetitionResource;
import io.github.sopheakboth83.api.EventResource;
import io.github.sopheakboth83.api.PresenceResource;
import io.github.sopheakboth83.api.TrackingResource;
import io.github.sopheakboth83.dao.DCompetitionDaoBean;
import io.github.sopheakboth83.dao.DEventDaoBean;
import io.github.sopheakboth83.dao.DHeatDaoBean;
import io.github.sopheakboth83.service.TaTramService;
import net.sf.mardao.dao.DatastoreSupplier;
import net.sf.mardao.dao.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Configure Guice modules and the web context.
 *
 * @author mattiaslevin
 */
public class GujaGuiceServletContextListener extends GuiceServletContextListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(GujaGuiceServletContextListener.class);

  private static final String APP_CONFIG_PROPERTY_FILE = "/WEB-INF/app.properties";

  private Properties getConfigProperties() {
      Properties properties = new Properties();
      try {
          properties.load(getClass().getResourceAsStream(APP_CONFIG_PROPERTY_FILE));
      } catch (IOException e) {
          LOGGER.error("Loading config", e);
      }
      return properties;
  }

  @Override
  protected Injector getInjector() {
      final Properties configProperties = new Properties();
    return Guice.createInjector(
        // bind both authorization server and federated:
        new GujaCoreModule(false, true),
        new GujaBaseModule(),
        new GujaGaeModule(),
        new GujaContactModule(),
        new MardaoDatastoreModule(),
        new CacheAnnotationsModule(),
        new JerseyServletModule() {
          private Properties bindProperties() {
            LOGGER.info("Bind application properties");
            try {
              configProperties.load(getServletContext().getResourceAsStream(APP_CONFIG_PROPERTY_FILE));
              Names.bindProperties(binder(), configProperties);
            } catch (IOException e) {
              LOGGER.error("Failed to load app properties from resource file {} with error {}", APP_CONFIG_PROPERTY_FILE, e);
            }
            return configProperties;
          }

          private void bindDaos() {
            LOGGER.info("Bind daos");

            bind(Supplier.class).to(DatastoreSupplier.class);

            //TODO: Bind your daos here
              bind(DCompetitionDaoBean.class);
              bind(DEventDaoBean.class);
              bind(DHeatDaoBean.class);
          }

          private void bindResources() {
            LOGGER.info("Bind resources");

            //TODO: Bind your resources here
              bind(TaTramService.class);
              bind(CompetitionResource.class);
              bind(EventResource.class);
              bind(TrackingResource.class);
              bind(PresenceResource.class);
          }

          @Override
          protected void configureServlets() {

            // Bindings
            Properties props = bindProperties();
              bind(Properties.class).toInstance(props);

            bindDaos();
            bindResources();

            bind(NonNullObjectMapperProvider.class);
            bind(ObjectMapper.class).toProvider(NonNullObjectMapperProvider.class);

            // Filters
            //filter("/*").through(PersistFilter.class);

            // Enable CORS if running on dev server
            filter("/*").through(CORSFilter.class);
            //filter("/*").through(CORSFilter.class, ImmutableMap.of("alwaysEnabled", "true"));

            filter("/oauth/authorize", "/oauth/refresh", "/oauth/revoke").through(Oauth2ClientAuthenticationFilter.class);

            filter("/api/*").through(OAuth2Filter.class);

            // Servlets
            serve("/*").with(GuiceContainer.class, ImmutableMap.of(
                "jersey.config.server.tracing.type", "ALL",
                "com.sun.jersey.spi.container.ContainerResponseFilters", "com.wadpam.guja.filter.ProtoWrapperFilter",
                "com.sun.jersey.spi.container.ResourceFilters", "com.sun.jersey.api.container.filter.RolesAllowedResourceFilterFactory"
            ));

            // TODO Find a better way to configure Jersey filters (Guice integration does not support Jersey filter configuration here)
          }
        }
    );
  }
}



