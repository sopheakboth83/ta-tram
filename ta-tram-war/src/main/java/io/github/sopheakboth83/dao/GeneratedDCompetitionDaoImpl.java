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
import io.github.sopheakboth83.domain.DCompetition;


/**
 * The DCompetition domain-object specific finders and methods go in this POJO.
 * 
 * Generated on 2016-02-07T10:10:04.924+0100.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class GeneratedDCompetitionDaoImpl
  extends AbstractDao<DCompetition, java.lang.Long> {

  public GeneratedDCompetitionDaoImpl(Supplier<Object, Object, Object, Object> supplier) {
    super(new DCompetitionMapper(supplier), supplier);
  }

// ----------------------- Caching -------------------------------------


// ----------------------- field finders -------------------------------
  /**
   * query-by method for field adminId
   * @param adminId the specified attribute
   * @return an Iterable of DCompetitions for the specified adminId
   */
  public Iterable<DCompetition> queryByAdminId(java.lang.Long adminId) {
    return queryByField(null, DCompetitionMapper.Field.ADMINID.getFieldName(), adminId);
  }

  /**
   * query-by method for field beginDate
   * @param beginDate the specified attribute
   * @return an Iterable of DCompetitions for the specified beginDate
   */
  public Iterable<DCompetition> queryByBeginDate(java.util.Date beginDate) {
    return queryByField(null, DCompetitionMapper.Field.BEGINDATE.getFieldName(), beginDate);
  }

  /**
   * query-by method for field createdBy
   * @param createdBy the specified attribute
   * @return an Iterable of DCompetitions for the specified createdBy
   */
  public Iterable<DCompetition> queryByCreatedBy(java.lang.String createdBy) {
    return queryByField(null, DCompetitionMapper.Field.CREATEDBY.getFieldName(), createdBy);
  }

  /**
   * query-by method for field createdDate
   * @param createdDate the specified attribute
   * @return an Iterable of DCompetitions for the specified createdDate
   */
  public Iterable<DCompetition> queryByCreatedDate(java.util.Date createdDate) {
    return queryByField(null, DCompetitionMapper.Field.CREATEDDATE.getFieldName(), createdDate);
  }

  /**
   * query-by method for field endDate
   * @param endDate the specified attribute
   * @return an Iterable of DCompetitions for the specified endDate
   */
  public Iterable<DCompetition> queryByEndDate(java.util.Date endDate) {
    return queryByField(null, DCompetitionMapper.Field.ENDDATE.getFieldName(), endDate);
  }

  /**
   * query-by method for field title
   * @param title the specified attribute
   * @return an Iterable of DCompetitions for the specified title
   */
  public Iterable<DCompetition> queryByTitle(java.lang.String title) {
    return queryByField(null, DCompetitionMapper.Field.TITLE.getFieldName(), title);
  }

  /**
   * query-by method for field updatedBy
   * @param updatedBy the specified attribute
   * @return an Iterable of DCompetitions for the specified updatedBy
   */
  public Iterable<DCompetition> queryByUpdatedBy(java.lang.String updatedBy) {
    return queryByField(null, DCompetitionMapper.Field.UPDATEDBY.getFieldName(), updatedBy);
  }

  /**
   * query-by method for field updatedDate
   * @param updatedDate the specified attribute
   * @return an Iterable of DCompetitions for the specified updatedDate
   */
  public Iterable<DCompetition> queryByUpdatedDate(java.util.Date updatedDate) {
    return queryByField(null, DCompetitionMapper.Field.UPDATEDDATE.getFieldName(), updatedDate);
  }

  /**
   * query-by method for field url
   * @param url the specified attribute
   * @return an Iterable of DCompetitions for the specified url
   */
  public Iterable<DCompetition> queryByUrl(java.lang.String url) {
    return queryByField(null, DCompetitionMapper.Field.URL.getFieldName(), url);
  }


// ----------------------- DCompetition builder -------------------------------

  public static DCompetitionMapper.Builder newBuilder() {
    return DCompetitionMapper.newBuilder();
  }

}
