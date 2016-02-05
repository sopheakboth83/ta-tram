package io.github.sopheakboth83.domain;

import com.wadpam.guja.oauth2.domain.DUser;
import net.sf.mardao.core.GeoLocation;
import net.sf.mardao.core.geo.DLocation;
import net.sf.mardao.domain.AbstractLongEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Entity for Competition.
 */
@Entity
public class DCompetition extends AbstractLongEntity {

    @Basic
    private String title;

    @Basic
    private Date beginDate;

    @Basic
    private Date endDate;

    @GeoLocation
    private DLocation location;

    @Basic
    private String url;

    @Basic
    private Long adminId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public DLocation getLocation() {
        return location;
    }

    public void setLocation(DLocation location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
