package io.github.sopheakboth83.service;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.inject.Inject;
import io.github.sopheakboth83.dao.DCompetitionDaoBean;
import io.github.sopheakboth83.dao.DEventDaoBean;
import io.github.sopheakboth83.dao.DHeatDaoBean;
import io.github.sopheakboth83.domain.DEvent;
import io.github.sopheakboth83.domain.DHeat;
import net.sf.mardao.core.CursorPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 */
public class TaTramService {
    static final Logger LOGGER = LoggerFactory.getLogger(TaTramService.class);

    private final DCompetitionDaoBean competitionDao;
    private final DEventDaoBean eventDao;
    private final DHeatDaoBean heatDao;

    @Inject
    public TaTramService(DCompetitionDaoBean competitionDao, DEventDaoBean eventDao, DHeatDaoBean heatDao) {
        this.competitionDao = competitionDao;
        this.eventDao = eventDao;
        this.heatDao = heatDao;
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

    public CursorPage<DHeat> getHeatsByEventId(Long eventId) {
        final ArrayList<DHeat> items = new ArrayList<DHeat>();
        for (DHeat item : heatDao.queryByEventId(eventId)) {
            items.add(item);
        }
        final CursorPage<DHeat> page = new CursorPage<DHeat>();
        page.setItems(items);
        page.setTotalSize(items.size());
        return page;
    }

    public String getChannelToken(Long competitionId, Long userId) {
        ChannelService channelService = ChannelServiceFactory.getChannelService();
        String token = channelService.createChannel(getChannelKey(competitionId, userId));
        return token;
    }

    private static String getChannelKey(Long competitionId, Long userId) {
        return competitionId.toString();
    }

    public void updateTracking(Long competitionId, Long timestamp, Integer count) {
        LOGGER.info("New count: {}", count);
        ChannelService channelService = ChannelServiceFactory.getChannelService();

        ChannelMessage channelMessage = new ChannelMessage(getChannelKey(competitionId, null), count.toString());
        channelService.sendMessage(channelMessage);
    }
}
