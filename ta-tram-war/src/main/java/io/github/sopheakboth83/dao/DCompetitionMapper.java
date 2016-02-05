package io.github.sopheakboth83.dao;

import java.util.Collection;
import java.util.Date;
import java.nio.ByteBuffer;

import net.sf.mardao.dao.Mapper;
import net.sf.mardao.dao.Supplier;
import net.sf.mardao.domain.AbstractEntityBuilder;
import io.github.sopheakboth83.domain.DCompetition;

/**
 * The DCompetition domain-object specific mapping methods go here.
 *
 * Generated on 2016-02-05T19:52:31.714+0100.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class DCompetitionMapper
  implements Mapper<DCompetition, Long> {

  private final Supplier supplier;

  public enum Field {
    ID("id"),
    ADMINID("adminId"),
    BEGINDATE("beginDate"),
    CREATEDBY("createdBy"),
    CREATEDDATE("createdDate"),
    ENDDATE("endDate"),
    TITLE("title"),
    UPDATEDBY("updatedBy"),
    UPDATEDDATE("updatedDate"),
    URL("url");

    private final String fieldName;

    Field(String fieldName) {
      this.fieldName = fieldName;
    }

    public String getFieldName() {
      return fieldName;
    }
  }

  public DCompetitionMapper(Supplier supplier) {
    this.supplier = supplier;
  }

  @Override
  public Long fromKey(Object key) {
    return supplier.toLongKey(key);
  }

  @Override
  public DCompetition fromReadValue(Object value) {
    final DCompetition entity = new DCompetition();

    // set primary key:
    final Object key = supplier.getKey(value, Field.ID.getFieldName());
    entity.setId(supplier.toLongKey(key));

    // set all fields:
    entity.setAdminId(supplier.getLong(value, Field.ADMINID.getFieldName()));
    entity.setBeginDate(supplier.getDate(value, Field.BEGINDATE.getFieldName()));
    entity.setCreatedBy(supplier.getString(value, Field.CREATEDBY.getFieldName()));
    entity.setCreatedDate(supplier.getDate(value, Field.CREATEDDATE.getFieldName()));
    entity.setEndDate(supplier.getDate(value, Field.ENDDATE.getFieldName()));
    entity.setTitle(supplier.getString(value, Field.TITLE.getFieldName()));
    entity.setUpdatedBy(supplier.getString(value, Field.UPDATEDBY.getFieldName()));
    entity.setUpdatedDate(supplier.getDate(value, Field.UPDATEDDATE.getFieldName()));
    entity.setUrl(supplier.getString(value, Field.URL.getFieldName()));
    return entity;
  }

  @Override
  public String getCreatedByColumnName() {
    return Field.CREATEDBY.getFieldName();
  }

  @Override
  public String getCreatedDateColumnName() {
    return Field.CREATEDDATE.getFieldName();
  }

  @Override
  public String getUpdatedByColumnName() {
    return Field.UPDATEDBY.getFieldName();
  }

  @Override
  public String getUpdatedDateColumnName() {
    return Field.UPDATEDDATE.getFieldName();
  }

  @Override
  public Long getId(DCompetition entity) {
    return entity != null ? entity.getId() : null;
  }

  @Override
  public Object getParentKey(DCompetition entity) {
    return null;
  }

  @Override
  public void setParentKey(DCompetition entity, Object parentKey) {
    // this entity has no parent
  }

  @Override
  public void updateEntityPostWrite(DCompetition entity, Object key, Object value) {
    entity.setId(supplier.toLongKey(key));
    entity.setCreatedBy(supplier.getString(value, Field.CREATEDBY.getFieldName()));
    entity.setCreatedDate(supplier.getDate(value, Field.CREATEDDATE.getFieldName()));
    entity.setUpdatedBy(supplier.getString(value, Field.UPDATEDBY.getFieldName()));
    entity.setUpdatedDate(supplier.getDate(value, Field.UPDATEDDATE.getFieldName()));
}

@Override
  public String getKind() {
    return DCompetition.class.getSimpleName();
  }

  @Override
  public Object toKey(Object parentKey, Long id) {
    return supplier.toKey(parentKey, getKind(), id);
  }

  @Override
  public Object toWriteValue(DCompetition entity) {
    final Long id = getId(entity);
    final Object parentKey = getParentKey(entity);
    final Object value = supplier.createWriteValue(parentKey, getKind(), id);

    // set all fields:
    supplier.setLong(value, Field.ADMINID.getFieldName(), entity.getAdminId());
    supplier.setDate(value, Field.BEGINDATE.getFieldName(), entity.getBeginDate());
    supplier.setString(value, Field.CREATEDBY.getFieldName(), entity.getCreatedBy());
    supplier.setDate(value, Field.CREATEDDATE.getFieldName(), entity.getCreatedDate());
    supplier.setDate(value, Field.ENDDATE.getFieldName(), entity.getEndDate());
    supplier.setString(value, Field.TITLE.getFieldName(), entity.getTitle());
    supplier.setString(value, Field.UPDATEDBY.getFieldName(), entity.getUpdatedBy());
    supplier.setDate(value, Field.UPDATEDDATE.getFieldName(), entity.getUpdatedDate());
    supplier.setString(value, Field.URL.getFieldName(), entity.getUrl());
    return value;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder extends AbstractEntityBuilder<DCompetition> {

    protected Builder() {
      super(new DCompetition());
    }

    public Builder id(Long id) {
      entity.setId(id);
      return this;
    }

    public Builder adminId(Long adminId) {
      entity.setAdminId(adminId);
      return this;
    }

    public Builder beginDate(Date beginDate) {
      entity.setBeginDate(beginDate);
      return this;
    }

    public Builder createdBy(String createdBy) {
      entity.setCreatedBy(createdBy);
      return this;
    }

    public Builder createdDate(Date createdDate) {
      entity.setCreatedDate(createdDate);
      return this;
    }

    public Builder endDate(Date endDate) {
      entity.setEndDate(endDate);
      return this;
    }

    public Builder title(String title) {
      entity.setTitle(title);
      return this;
    }

    public Builder updatedBy(String updatedBy) {
      entity.setUpdatedBy(updatedBy);
      return this;
    }

    public Builder updatedDate(Date updatedDate) {
      entity.setUpdatedDate(updatedDate);
      return this;
    }

    public Builder url(String url) {
      entity.setUrl(url);
      return this;
    }

  }
}
