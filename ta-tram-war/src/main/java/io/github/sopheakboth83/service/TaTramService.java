package io.github.sopheakboth83.service;

import com.google.inject.Inject;
import com.wadpam.guja.environment.ServerEnvironment;
import com.wadpam.guja.oauth2.api.FactoryResource;
import com.wadpam.guja.oauth2.api.OAuth2FederatedResource;
import com.wadpam.guja.oauth2.dao.DFactoryDaoBean;
import com.wadpam.guja.oauth2.dao.DFactoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 */
public class TaTramService {
    static final Logger LOGGER = LoggerFactory.getLogger(TaTramService.class);
    private final DFactoryDaoBean factoryDao;
    private final OAuth2FederatedResource oAuth2FederatedResource;

    @Inject
    public TaTramService(DFactoryDaoBean factoryDao, ServerEnvironment serverEnvironment, OAuth2FederatedResource oAuth2FederatedResource) {
        this.factoryDao = factoryDao;
        this.oAuth2FederatedResource = oAuth2FederatedResource;
        if (serverEnvironment.isDevEnvironment()) {
            try {
                LOGGER.info("Init, oauth2Resource={}", oAuth2FederatedResource);
                // TODO Move values to a property file
                factoryDao.put(DFactoryMapper.newBuilder()
                        .id(FactoryResource.PROVIDER_ID_FACEBOOK)
                        .baseUrl("https://graph.facebook.com")
                        .clientId("1520767301587499")
                        .clientSecret("e30fdf484c5fcaa28e40acbc8381da4b")
                        .build());
                LOGGER.info("Put facebook factory.");
            } catch (IOException e) {
                LOGGER.error("populating factory", e);
            }
        }

    }


}
