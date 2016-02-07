package io.github.sopheakboth83.domain;

import net.sf.mardao.core.GeoLocation;
import net.sf.mardao.core.geo.DLocation;
import net.sf.mardao.domain.AbstractLongEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Entity for Competition Events.
 */
@Entity
public class DEvent extends AbstractLongEntity {

    @Basic
    private String title;

    @Basic
    private Long competitionId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }
}
