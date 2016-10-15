package io.github.sopheakboth83.api;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.wadpam.guja.crud.CrudResource;
import io.github.sopheakboth83.dao.DCompetitionDaoBean;
import io.github.sopheakboth83.domain.DCompetition;
import io.github.sopheakboth83.domain.DEvent;
import io.github.sopheakboth83.service.TaTramService;
import net.sf.mardao.core.CursorPage;

import javax.inject.Singleton;
import javax.ws.rs.*;
import java.util.Map;

/**
 * Resource / Controller for Tracking.
 */
@Path("api/track")
@Singleton
public class TrackingResource {

    private final TaTramService service;

    @Inject
    public TrackingResource(TaTramService service) {
        this.service = service;
    }

    @GET
    @Path("{competitionId}/channel/{userId}")
    public Map getChannelToken(@PathParam("competitionId") Long competitionId,
                               @PathParam("userId") Long userId) {
        String token = service.getChannelToken(competitionId, userId);
        return ImmutableMap.of("token", token);
    }

    @POST
    @Path("{competitionId}")
    public void postTracking(@PathParam("competitionId") Long competitionId,
                                           @FormParam("timestamp") Long timestamp,
                                           @FormParam("count") Integer count) {
        service.updateTracking(competitionId, timestamp, count);
    }
}
