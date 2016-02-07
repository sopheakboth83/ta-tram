package io.github.sopheakboth83.api;

import com.google.inject.Inject;
import com.wadpam.guja.crud.CrudResource;
import io.github.sopheakboth83.dao.DEventDaoBean;
import io.github.sopheakboth83.domain.DEvent;
import io.github.sopheakboth83.service.TaTramService;

import javax.inject.Singleton;
import javax.ws.rs.Path;

/**
 * Resource / Controller for Event entities.
 */
@Path("api/events")
@Singleton
public class EventResource extends CrudResource<DEvent, Long, DEventDaoBean> {

    private final TaTramService service;

    @Inject
    public EventResource(DEventDaoBean dao, TaTramService service) {
        super(dao);
        this.service = service;
    }

}
