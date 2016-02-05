package io.github.sopheakboth83.service;

import com.google.inject.Inject;
import io.github.sopheakboth83.dao.DCompetitionDaoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class TaTramService {
    static final Logger LOGGER = LoggerFactory.getLogger(TaTramService.class);

    private final DCompetitionDaoBean competitionDao;

    @Inject
    public TaTramService(DCompetitionDaoBean competitionDao) {
        this.competitionDao = competitionDao;
    }


}
