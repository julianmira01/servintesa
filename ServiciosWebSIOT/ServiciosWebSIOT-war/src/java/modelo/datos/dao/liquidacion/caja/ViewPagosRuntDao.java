package modelo.datos.dao.liquidacion.caja;

import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.liquidacion.caja.ViewPagosRunt;

import utilidades.Funciones;


/**
  * ViewPagosRunt Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve ViewPagosRunt object instances.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class ViewPagosRuntDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public ViewPagosRunt createValueObject() {
          return new ViewPagosRunt();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public ViewPagosRunt getObject(Connection conn, String NUMFACTURA) throws NotFoundException, SQLException {

          ViewPagosRunt valueObject = createValueObject();
          valueObject.setNUMFACTURA(NUMFACTURA);
          load(conn, valueObject);
          return valueObject;
    }


    /**
     * load-method. This will load valueObject contents from database using
     * Primary-Key as identifier. Upper layer should use this so that valueObject
     * instance is created and only primary-key should be specified. Then call
     * this method to complete other persistent information. This method will
     * overwrite all other fields except primary-key and possible runtime variables.
     * If load can not find matching row, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be loaded.
     *                     Primary-key field must be set for this to work properly.
     */
    public void load(Connection conn, ViewPagosRunt valueObject) throws NotFoundException, SQLException {

          if (valueObject.getNUMFACTURA() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new NotFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM VIEW_PAGOSRUNT WHERE (NUMFACTURA = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getNUMFACTURA()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              //if (stmt != null)
              //    stmt.close();
          }
    }


    /**
     * LoadAll-method. This will read all contents from database table and
     * build a List containing valueObjects. Please note, that this method
     * will consume huge amounts of resources if table has lot's of rows. 
     * This should only be used when target tables have only small amounts
     * of data.
     *
     * @param conn         This method requires working database connection.
     */
    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM VIEW_PAGOSRUNT ORDER BY NUMFACTURA ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }



    /**
     * create-method. This will create new row in database according to supplied
     * valueObject contents. Make sure that values for all NOT NULL columns are
     * correctly specified. Also, if this table does not use automatic surrogate-keys
     * the primary-key must be specified. After INSERT command this method will 
     * read the generated primary-key back to valueObject if automatic surrogate-keys
     * were used. 
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be created.
     *                     If automatic surrogate-keys are not used the Primary-key 
     *                     field must be set for this to work properly.
     */
    public synchronized void create(Connection conn, ViewPagosRunt valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO VIEW_PAGOSRUNT ( NUMFACTURA, TOTALFACTURA, IDPAGORUNT, "
               + "IDUSUPAGO, FECHAPAGO, HORAFACTURA, VALORMT, "
               + "VALORRUNT, CODUSR, APELLIDOUSR, "
               + "NOMBREUSR, ESTADOFACTURA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getNUMFACTURA()); 
               stmt.setString(2, valueObject.getTOTALFACTURA()); 
               stmt.setInt(3, valueObject.getIDPAGORUNT()); 
               stmt.setInt(4, valueObject.getIDUSUPAGO()); 
               stmt.setString(5, valueObject.getFECHAPAGO()); 
               
               //stmt.setString(6, valueObject.getHORAFACTURA()); 
            if (Funciones.esTime(valueObject.getHORAFACTURA()))
               stmt.setTime(6,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAFACTURA())));
            else
               stmt.setNull(6, Types.TIME);
               
               stmt.setString(7, valueObject.getVALORMT()); 
               stmt.setString(8, valueObject.getVALORRUNT()); 
               stmt.setString(9, valueObject.getCODUSR()); 
               stmt.setString(10, valueObject.getAPELLIDOUSR()); 
               stmt.setString(11, valueObject.getNOMBREUSR()); 
               stmt.setString(12, valueObject.getESTADOFACTURA()); 

               int rowcount = databaseUpdate(conn, stmt);
               if (rowcount != 1) {
                    //System.out.println("PrimaryKey Error when updating DB!");
                    throw new SQLException("PrimaryKey Error when updating DB!");
               }

          } finally {
              if (stmt != null)
                  stmt.close();
          }


    }


    /**
     * save-method. This method will save the current state of valueObject to database.
     * Save can not be used to create new instances in database, so upper layer must
     * make sure that the primary-key is correctly specified. Primary-key will indicate
     * which instance is going to be updated in database. If save can not find matching 
     * row, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be saved.
     *                     Primary-key field must be set for this to work properly.
     */
    public void save(Connection conn, ViewPagosRunt valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE VIEW_PAGOSRUNT SET TOTALFACTURA = ?, IDPAGORUNT = ?, IDUSUPAGO = ?, "
               + "FECHAPAGO = ?, HORAFACTURA = ?, VALORMT = ?, VALORRUNT = ?, "
               + "CODUSR = ?, APELLIDOUSR = ?, NOMBREUSR = ?, "
               + "ESTADOFACTURA = ? WHERE (NUMFACTURA = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getTOTALFACTURA()); 
              stmt.setInt(2, valueObject.getIDPAGORUNT()); 
              stmt.setInt(3, valueObject.getIDUSUPAGO()); 
              stmt.setString(4, valueObject.getFECHAPAGO()); 
              
              //stmt.setString(5, valueObject.getHORAFACTURA());
            if (Funciones.esTime(valueObject.getHORAFACTURA()))
               stmt.setTime(5,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAFACTURA())));
            else
               stmt.setNull(5, Types.TIME);
              
              stmt.setString(6, valueObject.getVALORMT()); 
              stmt.setString(7, valueObject.getVALORRUNT()); 
              stmt.setString(8, valueObject.getCODUSR()); 
              stmt.setString(9, valueObject.getAPELLIDOUSR()); 
              stmt.setString(10, valueObject.getNOMBREUSR()); 
              stmt.setString(11, valueObject.getESTADOFACTURA()); 

              stmt.setString(12, valueObject.getNUMFACTURA()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * delete-method. This method will remove the information from database as identified by
     * by primary-key in supplied valueObject. Once valueObject has been deleted it can not 
     * be restored by calling save. Restoring can only be done using create method but if 
     * database is using automatic surrogate-keys, the resulting object will have different 
     * primary-key than what it was in the deleted object. If delete can not find matching row,
     * NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be deleted.
     *                     Primary-key field must be set for this to work properly.
     */
    public void delete(Connection conn, ViewPagosRunt valueObject) 
          throws NotFoundException, SQLException {

          if (valueObject.getNUMFACTURA() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new NotFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM VIEW_PAGOSRUNT WHERE (NUMFACTURA = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getNUMFACTURA()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be deleted (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * deleteAll-method. This method will remove all information from the table that matches
     * this Dao and ValueObject couple. This should be the most efficient way to clear table.
     * Once deleteAll has been called, no valueObject that has been created before can be 
     * restored by calling save. Restoring can only be done using create method but if database 
     * is using automatic surrogate-keys, the resulting object will have different primary-key 
     * than what it was in the deleted object. (Note, the implementation of this method should
     * be different with different DB backends.)
     *
     * @param conn         This method requires working database connection.
     */
    public void deleteAll(Connection conn) throws SQLException {

          String sql = "DELETE FROM VIEW_PAGOSRUNT";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * coutAll-method. This method will return the number of all rows from table that matches
     * this Dao. The implementation will simply execute "select count(primarykey) from table".
     * If table is empty, the return value is 0. This method should be used before calling
     * loadAll, to make sure table has not too many rows.
     *
     * @param conn         This method requires working database connection.
     */
    public int countAll(Connection conn) throws SQLException {

          String sql = "SELECT count(*) FROM VIEW_PAGOSRUNT";
          PreparedStatement stmt = null;
          ResultSet result = null;
          int allRows = 0;

          try {
              stmt = conn.prepareStatement(sql);
              result = stmt.executeQuery();

              if (result.next())
                  allRows = result.getInt(1);
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
          return allRows;
    }


    /** 
     * searchMatching-Method. This method provides searching capability to 
     * get matching valueObjects from database. It works by searching all 
     * objects that match permanent instance variables of given object.
     * Upper layer should use this by setting some parameters in valueObject
     * and then  call searchMatching. The result will be 0-N objects in a List, 
     * all matching those criteria you specified. Those instance-variables that
     * have NULL values are excluded in search-criteria.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance where search will be based.
     *                     Primary-key field should not be set.
     */
    public List searchMatching(Connection conn, ViewPagosRunt valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_PAGOSRUNT WHERE 1=1 ");

          if (valueObject.getNUMFACTURA() != null) {
              if (first) { first = false; }
              sql.append("AND NUMFACTURA LIKE '").append(valueObject.getNUMFACTURA()).append("%' ");
          }

          if (valueObject.getTOTALFACTURA() != null) {
              if (first) { first = false; }
              sql.append("AND TOTALFACTURA LIKE '").append(valueObject.getTOTALFACTURA()).append("%' ");
          }

          if (valueObject.getIDPAGORUNT() != 0) {
              if (first) { first = false; }
              sql.append("AND IDPAGORUNT = ").append(valueObject.getIDPAGORUNT()).append(" ");
          }

          if (valueObject.getIDUSUPAGO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDUSUPAGO = ").append(valueObject.getIDUSUPAGO()).append(" ");
          }

          if (valueObject.getFECHAPAGO() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAPAGO LIKE '").append(valueObject.getFECHAPAGO()).append("%' ");
          }
          
          if (valueObject.getHORAFACTURA() != null) {
              if (first) { first = false; }
              sql.append("AND HORAFACTURA LIKE '").append(valueObject.getHORAFACTURA()).append("%' ");
          }          

          if (valueObject.getVALORMT() != null) {
              if (first) { first = false; }
              sql.append("AND VALORMT LIKE '").append(valueObject.getVALORMT()).append("%' ");
          }

          if (valueObject.getVALORRUNT() != null) {
              if (first) { first = false; }
              sql.append("AND VALORRUNT LIKE '").append(valueObject.getVALORRUNT()).append("%' ");
          }

          if (valueObject.getCODUSR() != null) {
              if (first) { first = false; }
              sql.append("AND CODUSR LIKE '").append(valueObject.getCODUSR()).append("%' ");
          }

          if (valueObject.getAPELLIDOUSR() != null) {
              if (first) { first = false; }
              sql.append("AND APELLIDOUSR LIKE '").append(valueObject.getAPELLIDOUSR()).append("%' ");
          }

          if (valueObject.getNOMBREUSR() != null) {
              if (first) { first = false; }
              sql.append("AND NOMBREUSR LIKE '").append(valueObject.getNOMBREUSR()).append("%' ");
          }

          if (valueObject.getESTADOFACTURA() != null) {
              if (first) { first = false; }
              sql.append("AND ESTADOFACTURA LIKE '").append(valueObject.getESTADOFACTURA()).append("%' ");
          }


          sql.append("ORDER BY NUMFACTURA ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }


    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }


    /**
     * databaseUpdate-method. This method is a helper method for internal use. It will execute
     * all database handling that will change the information in tables. SELECT queries will
     * not be executed here however. The return value indicates how many rows were affected.
     * This method will also make sure that if cache is used, it will reset when data changes.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     */
    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }



    /**
     * databaseQuery-method. This method is a helper method for internal use. It will execute
     * all database queries that will return only one row. The resultset will be converted
     * to valueObject. If no rows were found, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     * @param valueObject  Class-instance where resulting data will be stored.
     */
    protected void singleQuery(Connection conn, PreparedStatement stmt, ViewPagosRunt valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setNUMFACTURA(result.getString("NUMFACTURA")); 
                   valueObject.setTOTALFACTURA(result.getString("TOTALFACTURA")); 
                   valueObject.setIDPAGORUNT(result.getInt("IDPAGORUNT")); 
                   valueObject.setIDUSUPAGO(result.getInt("IDUSUPAGO")); 
                   valueObject.setFECHAPAGO(result.getString("FECHAPAGO"));
                   valueObject.setHORAFACTURA(result.getString("HORAFACTURA")); 
                   valueObject.setVALORMT(result.getString("VALORMT")); 
                   valueObject.setVALORRUNT(result.getString("VALORRUNT")); 
                   valueObject.setCODUSR(result.getString("CODUSR")); 
                   valueObject.setAPELLIDOUSR(result.getString("APELLIDOUSR")); 
                   valueObject.setNOMBREUSR(result.getString("NOMBREUSR")); 
                   valueObject.setESTADOFACTURA(result.getString("ESTADOFACTURA")); 

              } else {
                    //System.out.println("ViewPagosRunt Object Not Found!");
                    throw new NotFoundException("ViewPagosRunt Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * databaseQuery-method. This method is a helper method for internal use. It will execute
     * all database queries that will return multiple rows. The resultset will be converted
     * to the List of valueObjects. If no rows were found, an empty List will be returned.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     */
    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   ViewPagosRunt temp = createValueObject();

                   temp.setNUMFACTURA(result.getString("NUMFACTURA")); 
                   temp.setTOTALFACTURA(result.getString("TOTALFACTURA")); 
                   temp.setIDPAGORUNT(result.getInt("IDPAGORUNT")); 
                   temp.setIDUSUPAGO(result.getInt("IDUSUPAGO")); 
                   temp.setFECHAPAGO(result.getString("FECHAPAGO"));
                   temp.setHORAFACTURA(result.getString("HORAFACTURA")); 
                   temp.setVALORMT(result.getString("VALORMT")); 
                   temp.setVALORRUNT(result.getString("VALORRUNT")); 
                   temp.setCODUSR(result.getString("CODUSR")); 
                   temp.setAPELLIDOUSR(result.getString("APELLIDOUSR")); 
                   temp.setNOMBREUSR(result.getString("NOMBREUSR")); 
                   temp.setESTADOFACTURA(result.getString("ESTADOFACTURA")); 

                   searchResults.add(temp);
              }

          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }

          return (List)searchResults;
    }

    public List buscarPagosRunt(Connection conn, ViewPagosRunt valueObject, String fechai, String fechaf) throws SQLException {
  
          List searchResults;
  
          boolean first = true;
          
          java.sql.Date fechaini=Funciones.convFechaSSQL(fechai);
          java.sql.Date fechafin=Funciones.convFechaSSQL(fechaf); 
              
          StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_PAGOSRUNT WHERE FECHAPAGO BETWEEN '"+fechaini+"' AND '"+fechafin+"'");
  
          if (valueObject.getNUMFACTURA() != null) {
              if (first) { first = false; }
              sql.append("AND NUMFACTURA LIKE '").append(valueObject.getNUMFACTURA()).append("%' ");
          }
  
          if (valueObject.getTOTALFACTURA() != null) {
              if (first) { first = false; }
              sql.append("AND TOTALFACTURA LIKE '").append(valueObject.getTOTALFACTURA()).append("%' ");
          }
  
          if (valueObject.getIDPAGORUNT() != 0) {
              if (first) { first = false; }
              sql.append("AND IDPAGORUNT = ").append(valueObject.getIDPAGORUNT()).append(" ");
          }
  
          if (valueObject.getIDUSUPAGO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDUSUPAGO = ").append(valueObject.getIDUSUPAGO()).append(" ");
          }
  
          if (valueObject.getFECHAPAGO() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAPAGO = '").append(valueObject.getFECHAPAGO()).append("%' ");
          }
          
          if (valueObject.getHORAFACTURA() != null) {
              if (first) { first = false; }
              sql.append("AND HORAFACTURA = '").append(valueObject.getHORAFACTURA()).append("%' ");
          }          
  
          if (valueObject.getVALORMT() != null) {
              if (first) { first = false; }
              sql.append("AND VALORMT LIKE '").append(valueObject.getVALORMT()).append("%' ");
          }
  
          if (valueObject.getVALORRUNT() != null) {
              if (first) { first = false; }
              sql.append("AND VALORRUNT LIKE '").append(valueObject.getVALORRUNT()).append("%' ");
          }
  
          if (valueObject.getCODUSR() != null) {
              if (first) { first = false; }
              sql.append("AND CODUSR LIKE '").append(valueObject.getCODUSR()).append("%' ");
          }
  
          if (valueObject.getAPELLIDOUSR() != null) {
              if (first) { first = false; }
              sql.append("AND APELLIDOUSR LIKE '").append(valueObject.getAPELLIDOUSR()).append("%' ");
          }
  
          if (valueObject.getNOMBREUSR() != null) {
              if (first) { first = false; }
              sql.append("AND NOMBREUSR LIKE '").append(valueObject.getNOMBREUSR()).append("%' ");
          }
  
          if (valueObject.getESTADOFACTURA() != null) {
              if (first) { first = false; }
              sql.append("AND ESTADOFACTURA LIKE '").append(valueObject.getESTADOFACTURA()).append("%' ");
          }
   
          sql.append("ORDER BY FECHAPAGO, HORAFACTURA DESC ");
  
          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));
  
          return searchResults;
    }

}
