package io.github.sopheakboth83.api;

import com.google.appengine.api.channel.ChannelPresence;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.inject.Inject;
import io.github.sopheakboth83.service.TaTramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;

/**
 * Resource / Controller for Tracking.
 */
@Path("_ah/channel")
@Singleton
public class PresenceResource {

    static final Logger LOGGER = LoggerFactory.getLogger(PresenceResource.class);

    private final TaTramService service;

    @Inject
    public PresenceResource(TaTramService service) {
        this.service = service;
    }

    @POST
    @Path("connected")
    public void channelConnected(@Context HttpServletRequest request) throws IOException {
        ChannelService channelService = ChannelServiceFactory.getChannelService();
        ChannelPresence presence = channelService.parsePresence(request);
        LOGGER.info("CONNECTED clientId={}", presence.clientId());
    }

    @POST
    @Path("disconnected")
    public void channelDisconnected(@Context HttpServletRequest request) throws IOException {
        ChannelService channelService = ChannelServiceFactory.getChannelService();
        ChannelPresence presence = channelService.parsePresence(request);
        LOGGER.info("DISCONNECTED clientId={}", presence.clientId());
    }

}
