package io.github.sopheakboth83.domain;

import net.sf.mardao.domain.AbstractLongEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Entity for Competition Event Heats.
 */
@Entity
public class DHeat extends AbstractLongEntity {

    @Basic
    private String title;

    @Basic
    private Long competitionId;

    @Basic
    private Long eventId;

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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
