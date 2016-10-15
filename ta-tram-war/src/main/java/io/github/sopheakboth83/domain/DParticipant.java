package io.github.sopheakboth83.domain;

import net.sf.mardao.domain.AbstractLongEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Entity for Competition or Heat Participants.
 */
@Entity
public class DParticipant extends AbstractLongEntity {

    @Basic
    private String displayName;

    @Basic
    private Long userId;

    @Basic
    private Long competitionId;

    @Basic
    private Long heatId;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHeatId() {
        return heatId;
    }

    public void setHeatId(Long heatId) {
        this.heatId = heatId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }
}
