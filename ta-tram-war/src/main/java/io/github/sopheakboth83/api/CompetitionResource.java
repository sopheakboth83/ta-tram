package io.github.sopheakboth83.api;

import com.google.inject.Inject;
import com.wadpam.guja.crud.CrudResource;
import io.github.sopheakboth83.dao.DCompetitionDaoBean;
import io.github.sopheakboth83.domain.DCompetition;
import io.github.sopheakboth83.domain.DEvent;
import io.github.sopheakboth83.service.TaTramService;
import net.sf.mardao.core.CursorPage;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Resource / Controller for Competition entities.
 */
@Path("api/competitions")
@Singleton
public class CompetitionResource extends CrudResource<DCompetition, Long, DCompetitionDaoBean> {

    private final TaTramService service;

    @Inject
    public CompetitionResource(DCompetitionDaoBean dao, TaTramService service) {
        super(dao);
        this.service = service;
    }

    @GET
    @Path("{competitionId}/events")
    public CursorPage<DEvent> getEventsByCompetitionId(@PathParam("competitionId") Long competitionId) {
        return service.getEventsByCompetitionId(competitionId);
    }
}
