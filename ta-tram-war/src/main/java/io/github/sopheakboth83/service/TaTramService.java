package io.github.sopheakboth83.service;

import com.google.inject.Inject;
import io.github.sopheakboth83.dao.DCompetitionDaoBean;
import io.github.sopheakboth83.dao.DEventDaoBean;
import io.github.sopheakboth83.domain.DEvent;
import net.sf.mardao.core.CursorPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 */
public class TaTramService {
    static final Logger LOGGER = LoggerFactory.getLogger(TaTramService.class);

    private final DCompetitionDaoBean competitionDao;
    private final DEventDaoBean eventDao;

    @Inject
    public TaTramService(DCompetitionDaoBean competitionDao, DEventDaoBean eventDao) {
        this.competitionDao = competitionDao;
        this.eventDao = eventDao;
    }

    public CursorPage<DEvent> getEventsByCompetitionId(Long competitionId) {
        final ArrayList<DEvent> items = new ArrayList<DEvent>();
        for (DEvent item : eventDao.queryByCompetitionId(competitionId)) {
            items.add(item);
        }
        final CursorPage<DEvent> page = new CursorPage<DEvent>();
        page.setItems(items);
        page.setTotalSize(items.size());
        return page;
    }
}
