package io.github.sopheakboth83.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import net.sf.mardao.core.CursorPage;
import net.sf.mardao.core.filter.Filter;
import net.sf.mardao.core.geo.DLocation;
import net.sf.mardao.dao.AbstractDao;
import net.sf.mardao.dao.Supplier;
import io.github.sopheakboth83.domain.DHeat;


/**
 * The DHeat domain-object specific finders and methods go in this POJO.
 * 
 * Generated on 2016-02-08T19:15:05.306+0100.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class GeneratedDHeatDaoImpl
  extends AbstractDao<DHeat, java.lang.Long> {

  public GeneratedDHeatDaoImpl(Supplier<Object, Object, Object, Object> supplier) {
    super(new DHeatMapper(supplier), supplier);
  }

// ----------------------- Caching -------------------------------------


// ----------------------- field finders -------------------------------
  /**
   * query-by method for field competitionId
   * @param competitionId the specified attribute
   * @return an Iterable of DHeats for the specified competitionId
   */
  public Iterable<DHeat> queryByCompetitionId(java.lang.Long competitionId) {
    return queryByField(null, DHeatMapper.Field.COMPETITIONID.getFieldName(), competitionId);
  }

  /**
   * query-by method for field createdBy
   * @param createdBy the specified attribute
   * @return an Iterable of DHeats for the specified createdBy
   */
  public Iterable<DHeat> queryByCreatedBy(java.lang.String createdBy) {
    return queryByField(null, DHeatMapper.Field.CREATEDBY.getFieldName(), createdBy);
  }

  /**
   * query-by method for field createdDate
   * @param createdDate the specified attribute
   * @return an Iterable of DHeats for the specified createdDate
   */
  public Iterable<DHeat> queryByCreatedDate(java.util.Date createdDate) {
    return queryByField(null, DHeatMapper.Field.CREATEDDATE.getFieldName(), createdDate);
  }

  /**
   * query-by method for field eventId
   * @param eventId the specified attribute
   * @return an Iterable of DHeats for the specified eventId
   */
  public Iterable<DHeat> queryByEventId(java.lang.Long eventId) {
    return queryByField(null, DHeatMapper.Field.EVENTID.getFieldName(), eventId);
  }

  /**
   * query-by method for field title
   * @param title the specified attribute
   * @return an Iterable of DHeats for the specified title
   */
  public Iterable<DHeat> queryByTitle(java.lang.String title) {
    return queryByField(null, DHeatMapper.Field.TITLE.getFieldName(), title);
  }

  /**
   * query-by method for field updatedBy
   * @param updatedBy the specified attribute
   * @return an Iterable of DHeats for the specified updatedBy
   */
  public Iterable<DHeat> queryByUpdatedBy(java.lang.String updatedBy) {
    return queryByField(null, DHeatMapper.Field.UPDATEDBY.getFieldName(), updatedBy);
  }

  /**
   * query-by method for field updatedDate
   * @param updatedDate the specified attribute
   * @return an Iterable of DHeats for the specified updatedDate
   */
  public Iterable<DHeat> queryByUpdatedDate(java.util.Date updatedDate) {
    return queryByField(null, DHeatMapper.Field.UPDATEDDATE.getFieldName(), updatedDate);
  }


// ----------------------- DHeat builder -------------------------------

  public static DHeatMapper.Builder newBuilder() {
    return DHeatMapper.newBuilder();
  }

}
