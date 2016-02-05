package io.github.sopheakboth83.api;

import com.google.inject.Inject;
import com.wadpam.guja.crud.CrudResource;
import io.github.sopheakboth83.dao.DCompetitionDaoBean;
import io.github.sopheakboth83.domain.DCompetition;
import io.github.sopheakboth83.service.TaTramService;

import javax.inject.Singleton;
import javax.ws.rs.Path;

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
}
