package io.github.sopheakboth83.api;

import com.google.inject.Inject;
import com.wadpam.guja.crud.CrudResource;
import io.github.sopheakboth83.dao.DEventDaoBean;
import io.github.sopheakboth83.dao.DHeatDaoBean;
import io.github.sopheakboth83.domain.DEvent;
import io.github.sopheakboth83.domain.DHeat;
import io.github.sopheakboth83.service.TaTramService;

import javax.inject.Singleton;
import javax.ws.rs.Path;

/**
 * Resource / Controller for Event entities.
 */
@Path("api/heats")
@Singleton
public class HeatResource extends CrudResource<DHeat, Long, DHeatDaoBean> {

    private final TaTramService service;

    @Inject
    public HeatResource(DHeatDaoBean dao, TaTramService service) {
        super(dao);
        this.service = service;
    }

}
