package modelo.datos.dao.liquidacion.caja;

import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.liquidacion.caja.ViewAsobancaria;


/**
  * ViewAsobancaria Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve ViewAsobancaria object instances.
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



public class ViewAsobancariaDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public ViewAsobancaria createValueObject() {
          return new ViewAsobancaria();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public ViewAsobancaria getObject(Connection conn, int IDPAGORUNT) throws NotFoundException, SQLException {

          ViewAsobancaria valueObject = createValueObject();
          valueObject.setIDPAGORUNT(IDPAGORUNT);
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
    public void load(Connection conn, ViewAsobancaria valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM VIEW_ASOBANCARIA WHERE (IDPAGORUNT = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getIDPAGORUNT()); 

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

          String sql = "SELECT * FROM VIEW_ASOBANCARIA ORDER BY IDPAGORUNT ASC ";
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
    public synchronized void create(Connection conn, ViewAsobancaria valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO VIEW_ASOBANCARIA ( IDPAGORUNT, IDFACTURA, FECHASOLICITUD, "
               + "FECHAREGISTRO, FECHAVIGENCIA, TIPOLIQUIDACION, "
               + "TIPOCOMPROBANTEPAGO, VALORMT, VALORRUNT, "
               + "VALORTOTAL, ESTADOLIQUIDACION, FECHAPAGO, "
               + "IDBANCO, IDTIPOMONEDA, NUMAUTORIZACIONBANCO, "
               + "IDUSRPAGO, IDARQUEO, LFNUMRUNT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getIDPAGORUNT()); 
               stmt.setInt(2, valueObject.getIDFACTURA()); 
               stmt.setString(3, valueObject.getFECHASOLICITUD()); 
               stmt.setString(4, valueObject.getFECHAREGISTRO()); 
               stmt.setString(5, valueObject.getFECHAVIGENCIA()); 
               stmt.setString(6, valueObject.getTIPOLIQUIDACION()); 
               stmt.setString(7, valueObject.getTIPOCOMPROBANTEPAGO()); 
               stmt.setDouble(8, valueObject.getVALORMT()); 
               stmt.setDouble(9, valueObject.getVALORRUNT()); 
               stmt.setDouble(10, valueObject.getVALORTOTAL()); 
               stmt.setString(11, valueObject.getESTADOLIQUIDACION()); 
               stmt.setString(12, valueObject.getFECHAPAGO()); 
               stmt.setInt(13, valueObject.getIDBANCO()); 
               stmt.setInt(14, valueObject.getIDTIPOMONEDA()); 
               stmt.setString(15, valueObject.getNUMAUTORIZACIONBANCO()); 
               stmt.setInt(16, valueObject.getIDUSRPAGO()); 
               stmt.setInt(17, valueObject.getIDARQUEO()); 
               stmt.setString(18, valueObject.getLFNUMRUNT()); 

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
    public void save(Connection conn, ViewAsobancaria valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE VIEW_ASOBANCARIA SET IDFACTURA = ?, FECHASOLICITUD = ?, FECHAREGISTRO = ?, "
               + "FECHAVIGENCIA = ?, TIPOLIQUIDACION = ?, TIPOCOMPROBANTEPAGO = ?, "
               + "VALORMT = ?, VALORRUNT = ?, VALORTOTAL = ?, "
               + "ESTADOLIQUIDACION = ?, FECHAPAGO = ?, IDBANCO = ?, "
               + "IDTIPOMONEDA = ?, NUMAUTORIZACIONBANCO = ?, IDUSRPAGO = ?, "
               + "IDARQUEO = ?, LFNUMRUNT = ? WHERE (IDPAGORUNT = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getIDFACTURA()); 
              stmt.setString(2, valueObject.getFECHASOLICITUD()); 
              stmt.setString(3, valueObject.getFECHAREGISTRO()); 
              stmt.setString(4, valueObject.getFECHAVIGENCIA()); 
              stmt.setString(5, valueObject.getTIPOLIQUIDACION()); 
              stmt.setString(6, valueObject.getTIPOCOMPROBANTEPAGO()); 
              stmt.setDouble(7, valueObject.getVALORMT()); 
              stmt.setDouble(8, valueObject.getVALORRUNT()); 
              stmt.setDouble(9, valueObject.getVALORTOTAL()); 
              stmt.setString(10, valueObject.getESTADOLIQUIDACION()); 
              stmt.setString(11, valueObject.getFECHAPAGO()); 
              stmt.setInt(12, valueObject.getIDBANCO()); 
              stmt.setInt(13, valueObject.getIDTIPOMONEDA()); 
              stmt.setString(14, valueObject.getNUMAUTORIZACIONBANCO()); 
              stmt.setInt(15, valueObject.getIDUSRPAGO()); 
              stmt.setInt(16, valueObject.getIDARQUEO()); 
              stmt.setString(17, valueObject.getLFNUMRUNT()); 

              stmt.setInt(18, valueObject.getIDPAGORUNT()); 

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
    public void delete(Connection conn, ViewAsobancaria valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM VIEW_ASOBANCARIA WHERE (IDPAGORUNT = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getIDPAGORUNT()); 

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

          String sql = "DELETE FROM VIEW_ASOBANCARIA";
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

          String sql = "SELECT count(*) FROM VIEW_ASOBANCARIA";
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
    public List searchMatching(Connection conn, ViewAsobancaria valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_ASOBANCARIA WHERE 1=1 ");

          if (valueObject.getIDPAGORUNT() != 0) {
              if (first) { first = false; }
              sql.append("AND IDPAGORUNT = ").append(valueObject.getIDPAGORUNT()).append(" ");
          }

          if (valueObject.getIDFACTURA() != 0) {
              if (first) { first = false; }
              sql.append("AND IDFACTURA = ").append(valueObject.getIDFACTURA()).append(" ");
          }

          if (valueObject.getFECHASOLICITUD() != null) {
              if (first) { first = false; }
              sql.append("AND FECHASOLICITUD = '").append(valueObject.getFECHASOLICITUD()).append("' ");
          }

          if (valueObject.getFECHAREGISTRO() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAREGISTRO = '").append(valueObject.getFECHAREGISTRO()).append("' ");
          }

          if (valueObject.getFECHAVIGENCIA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAVIGENCIA = '").append(valueObject.getFECHAVIGENCIA()).append("' ");
          }

          if (valueObject.getTIPOLIQUIDACION() != null) {
              if (first) { first = false; }
              sql.append("AND TIPOLIQUIDACION = '").append(valueObject.getTIPOLIQUIDACION()).append("' ");
          }

          if (valueObject.getTIPOCOMPROBANTEPAGO() != null) {
              if (first) { first = false; }
              sql.append("AND TIPOCOMPROBANTEPAGO = '").append(valueObject.getTIPOCOMPROBANTEPAGO()).append("' ");
          }

          if (valueObject.getVALORMT() != 0) {
              if (first) { first = false; }
              sql.append("AND VALORMT = ").append(valueObject.getVALORMT()).append(" ");
          }

          if (valueObject.getVALORRUNT() != 0) {
              if (first) { first = false; }
              sql.append("AND VALORRUNT = ").append(valueObject.getVALORRUNT()).append(" ");
          }

          if (valueObject.getVALORTOTAL() != 0) {
              if (first) { first = false; }
              sql.append("AND VALORTOTAL = ").append(valueObject.getVALORTOTAL()).append(" ");
          }

          if (valueObject.getESTADOLIQUIDACION() != null) {
              if (first) { first = false; }
              sql.append("AND ESTADOLIQUIDACION = '").append(valueObject.getESTADOLIQUIDACION()).append("' ");
          }

          if (valueObject.getFECHAPAGO() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAPAGO = '").append(valueObject.getFECHAPAGO()).append("' ");
          }

          if (valueObject.getIDBANCO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDBANCO = ").append(valueObject.getIDBANCO()).append(" ");
          }

          if (valueObject.getIDTIPOMONEDA() != 0) {
              if (first) { first = false; }
              sql.append("AND IDTIPOMONEDA = ").append(valueObject.getIDTIPOMONEDA()).append(" ");
          }

          if (valueObject.getNUMAUTORIZACIONBANCO() != null) {
              if (first) { first = false; }
              sql.append("AND NUMAUTORIZACIONBANCO = '").append(valueObject.getNUMAUTORIZACIONBANCO()).append("' ");
          }

          if (valueObject.getIDUSRPAGO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDUSRPAGO = ").append(valueObject.getIDUSRPAGO()).append(" ");
          }

          if (valueObject.getIDARQUEO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDARQUEO = ").append(valueObject.getIDARQUEO()).append(" ");
          }

          if (valueObject.getLFNUMRUNT() != null) {
              if (first) { first = false; }
              sql.append("AND LFNUMRUNT = '").append(valueObject.getLFNUMRUNT()).append("' ");
          }


          sql.append("ORDER BY IDPAGORUNT ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, ViewAsobancaria valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setIDPAGORUNT(result.getInt("IDPAGORUNT")); 
                   valueObject.setIDFACTURA(result.getInt("IDFACTURA")); 
                   valueObject.setFECHASOLICITUD(result.getString("FECHASOLICITUD")); 
                   valueObject.setFECHAREGISTRO(result.getString("FECHAREGISTRO")); 
                   valueObject.setFECHAVIGENCIA(result.getString("FECHAVIGENCIA")); 
                   valueObject.setTIPOLIQUIDACION(result.getString("TIPOLIQUIDACION")); 
                   valueObject.setTIPOCOMPROBANTEPAGO(result.getString("TIPOCOMPROBANTEPAGO")); 
                   valueObject.setVALORMT(result.getDouble("VALORMT")); 
                   valueObject.setVALORRUNT(result.getDouble("VALORRUNT")); 
                   valueObject.setVALORTOTAL(result.getDouble("VALORTOTAL")); 
                   valueObject.setESTADOLIQUIDACION(result.getString("ESTADOLIQUIDACION")); 
                   valueObject.setFECHAPAGO(result.getString("FECHAPAGO")); 
                   valueObject.setIDBANCO(result.getInt("IDBANCO")); 
                   valueObject.setIDTIPOMONEDA(result.getInt("IDTIPOMONEDA")); 
                   valueObject.setNUMAUTORIZACIONBANCO(result.getString("NUMAUTORIZACIONBANCO")); 
                   valueObject.setIDUSRPAGO(result.getInt("IDUSRPAGO")); 
                   valueObject.setIDARQUEO(result.getInt("IDARQUEO")); 
                   valueObject.setLFNUMRUNT(result.getString("LFNUMRUNT")); 

              } else {
                    //System.out.println("ViewAsobancaria Object Not Found!");
                    throw new NotFoundException("ViewAsobancaria Object Not Found!");
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
                   ViewAsobancaria temp = createValueObject();

                   temp.setIDPAGORUNT(result.getInt("IDPAGORUNT")); 
                   temp.setIDFACTURA(result.getInt("IDFACTURA")); 
                   temp.setFECHASOLICITUD(result.getString("FECHASOLICITUD")); 
                   temp.setFECHAREGISTRO(result.getString("FECHAREGISTRO")); 
                   temp.setFECHAVIGENCIA(result.getString("FECHAVIGENCIA")); 
                   temp.setTIPOLIQUIDACION(result.getString("TIPOLIQUIDACION")); 
                   temp.setTIPOCOMPROBANTEPAGO(result.getString("TIPOCOMPROBANTEPAGO")); 
                   temp.setVALORMT(result.getDouble("VALORMT")); 
                   temp.setVALORRUNT(result.getDouble("VALORRUNT")); 
                   temp.setVALORTOTAL(result.getDouble("VALORTOTAL")); 
                   temp.setESTADOLIQUIDACION(result.getString("ESTADOLIQUIDACION")); 
                   temp.setFECHAPAGO(result.getString("FECHAPAGO")); 
                   temp.setIDBANCO(result.getInt("IDBANCO")); 
                   temp.setIDTIPOMONEDA(result.getInt("IDTIPOMONEDA")); 
                   temp.setNUMAUTORIZACIONBANCO(result.getString("NUMAUTORIZACIONBANCO")); 
                   temp.setIDUSRPAGO(result.getInt("IDUSRPAGO")); 
                   temp.setIDARQUEO(result.getInt("IDARQUEO")); 
                   temp.setLFNUMRUNT(result.getString("LFNUMRUNT")); 

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

    public List loadPlano(Connection conn, String fechai, String fechaf) throws SQLException 
    {  
        String sql = "SELECT * FROM VIEW_ASOBANCARIA WHERE FECHAPAGO BETWEEN '"+fechai+"' and '"+fechaf+"' ORDER BY IDPAGORUNT ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

}
