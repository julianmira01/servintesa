package modelo.datos.dao.comparendos.comparenderas;

import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.comparenderas.ViewComparendosInfractor;


/**
  * ViewComparendosInfractor Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve ViewComparendosInfractor object instances.
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



public class ViewComparendosInfractorDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public ViewComparendosInfractor createValueObject() {
          return new ViewComparendosInfractor();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public ViewComparendosInfractor getObject(Connection conn, int IDAGENTE) throws NotFoundException, SQLException {

          ViewComparendosInfractor valueObject = createValueObject();
          valueObject.setIDAGENTE(IDAGENTE);
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
    public void load(Connection conn, ViewComparendosInfractor valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM VIEW_COMPARENDOS_INFRACTOR WHERE (IDAGENTE = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getIDAGENTE()); 

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

          String sql = "SELECT * FROM VIEW_COMPARENDOS_INFRACTOR ORDER BY IDAGENTE ASC ";
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
    public synchronized void create(Connection conn, ViewComparendosInfractor valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO VIEW_COMPARENDOS_INFRACTOR ( IDAGENTE, NOMBRESAGENTE, PAPELLIDOAGEN, "
               + "SAPELLIDOAGEN, IDCOMPARENDERA, ESTADOCOMPARENDERA, "
               + "RANGOINICIAL, RANGOFINAL, IDCOMPARENDO, "
               + "ANUMEROCOMPARENDO, BFECHACOMPARENDO, CIDENTIFICACION, "
               + "DNOMBRESINFRACTOR, EAPELLIDINFRACTOR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getIDAGENTE()); 
               stmt.setString(2, valueObject.getNOMBRESAGENTE()); 
               stmt.setString(3, valueObject.getPAPELLIDOAGEN()); 
               stmt.setString(4, valueObject.getSAPELLIDOAGEN()); 
               stmt.setInt(5, valueObject.getIDCOMPARENDERA()); 
               stmt.setInt(6, valueObject.getESTADOCOMPARENDERA()); 
               stmt.setString(7, valueObject.getRANGOINICIAL()); 
               stmt.setString(8, valueObject.getRANGOFINAL()); 
               stmt.setInt(9, valueObject.getIDCOMPARENDO()); 
               stmt.setString(10, valueObject.getANUMEROCOMPARENDO()); 
               stmt.setString(11, valueObject.getBFECHACOMPARENDO()); 
               stmt.setString(12, valueObject.getCIDENTIFICACION()); 
               stmt.setString(13, valueObject.getDNOMBRESINFRACTOR()); 
               stmt.setString(14, valueObject.getEAPELLIDINFRACTOR()); 

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
    public void save(Connection conn, ViewComparendosInfractor valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE VIEW_COMPARENDOS_INFRACTOR SET NOMBRESAGENTE = ?, PAPELLIDOAGEN = ?, SAPELLIDOAGEN = ?, "
               + "IDCOMPARENDERA = ?, ESTADOCOMPARENDERA = ?, RANGOINICIAL = ?, "
               + "RANGOFINAL = ?, IDCOMPARENDO = ?, ANUMEROCOMPARENDO = ?, "
               + "BFECHACOMPARENDO = ?, CIDENTIFICACION = ?, DNOMBRESINFRACTOR = ?, "
               + "EAPELLIDINFRACTOR = ? WHERE (IDAGENTE = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getNOMBRESAGENTE()); 
              stmt.setString(2, valueObject.getPAPELLIDOAGEN()); 
              stmt.setString(3, valueObject.getSAPELLIDOAGEN()); 
              stmt.setInt(4, valueObject.getIDCOMPARENDERA()); 
              stmt.setInt(5, valueObject.getESTADOCOMPARENDERA()); 
              stmt.setString(6, valueObject.getRANGOINICIAL()); 
              stmt.setString(7, valueObject.getRANGOFINAL()); 
              stmt.setInt(8, valueObject.getIDCOMPARENDO()); 
              stmt.setString(9, valueObject.getANUMEROCOMPARENDO()); 
              stmt.setString(10, valueObject.getBFECHACOMPARENDO()); 
              stmt.setString(11, valueObject.getCIDENTIFICACION()); 
              stmt.setString(12, valueObject.getDNOMBRESINFRACTOR()); 
              stmt.setString(13, valueObject.getEAPELLIDINFRACTOR()); 

              stmt.setInt(14, valueObject.getIDAGENTE()); 

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
    public void delete(Connection conn, ViewComparendosInfractor valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM VIEW_COMPARENDOS_INFRACTOR WHERE (IDAGENTE = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getIDAGENTE()); 

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

          String sql = "DELETE FROM VIEW_COMPARENDOS_INFRACTOR";
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

          String sql = "SELECT count(*) FROM VIEW_COMPARENDOS_INFRACTOR";
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
    public List searchMatching(Connection conn, ViewComparendosInfractor valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_COMPARENDOS_INFRACTOR WHERE 1=1 ");

          if (valueObject.getIDAGENTE() != 0) {
              if (first) { first = false; }
              sql.append("AND IDAGENTE = ").append(valueObject.getIDAGENTE()).append(" ");
          }

          if (valueObject.getNOMBRESAGENTE() != null) {
              if (first) { first = false; }
              sql.append("AND NOMBRESAGENTE = '").append(valueObject.getNOMBRESAGENTE()).append("' ");
          }

          if (valueObject.getPAPELLIDOAGEN() != null) {
              if (first) { first = false; }
              sql.append("AND PAPELLIDOAGEN = '").append(valueObject.getPAPELLIDOAGEN()).append("' ");
          }

          if (valueObject.getSAPELLIDOAGEN() != null) {
              if (first) { first = false; }
              sql.append("AND SAPELLIDOAGEN = '").append(valueObject.getSAPELLIDOAGEN()).append("' ");
          }

          if (valueObject.getIDCOMPARENDERA() != 0) {
              if (first) { first = false; }
              sql.append("AND IDCOMPARENDERA = ").append(valueObject.getIDCOMPARENDERA()).append(" ");
          }

          if (valueObject.getESTADOCOMPARENDERA() != 0) {
              if (first) { first = false; }
              sql.append("AND ESTADOCOMPARENDERA = ").append(valueObject.getESTADOCOMPARENDERA()).append(" ");
          }

          if (valueObject.getRANGOINICIAL() != null) {
              if (first) { first = false; }
              sql.append("AND RANGOINICIAL = '").append(valueObject.getRANGOINICIAL()).append("' ");
          }

          if (valueObject.getRANGOFINAL() != null) {
              if (first) { first = false; }
              sql.append("AND RANGOFINAL = '").append(valueObject.getRANGOFINAL()).append("' ");
          }

          if (valueObject.getIDCOMPARENDO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDCOMPARENDO = ").append(valueObject.getIDCOMPARENDO()).append(" ");
          }

          if (valueObject.getANUMEROCOMPARENDO() != null) {
              if (first) { first = false; }
              sql.append("AND ANUMEROCOMPARENDO = '").append(valueObject.getANUMEROCOMPARENDO()).append("' ");
          }

          if (valueObject.getBFECHACOMPARENDO() != null) {
              if (first) { first = false; }
              sql.append("AND BFECHACOMPARENDO = '").append(valueObject.getBFECHACOMPARENDO()).append("' ");
          }

          if (valueObject.getCIDENTIFICACION() != null) {
              if (first) { first = false; }
              sql.append("AND CIDENTIFICACION = '").append(valueObject.getCIDENTIFICACION()).append("' ");
          }

          if (valueObject.getDNOMBRESINFRACTOR() != null) {
              if (first) { first = false; }
              sql.append("AND DNOMBRESINFRACTOR = '").append(valueObject.getDNOMBRESINFRACTOR()).append("' ");
          }

          if (valueObject.getEAPELLIDINFRACTOR() != null) {
              if (first) { first = false; }
              sql.append("AND EAPELLIDINFRACTOR = '").append(valueObject.getEAPELLIDINFRACTOR()).append("' ");
          }


          sql.append("ORDER BY IDAGENTE ASC ");
          System.out.println(sql);
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
    protected void singleQuery(Connection conn, PreparedStatement stmt, ViewComparendosInfractor valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setIDAGENTE(result.getInt("IDAGENTE")); 
                   valueObject.setNOMBRESAGENTE(result.getString("NOMBRESAGENTE")); 
                   valueObject.setPAPELLIDOAGEN(result.getString("PAPELLIDOAGEN")); 
                   valueObject.setSAPELLIDOAGEN(result.getString("SAPELLIDOAGEN")); 
                   valueObject.setIDCOMPARENDERA(result.getInt("IDCOMPARENDERA")); 
                   valueObject.setESTADOCOMPARENDERA(result.getInt("ESTADOCOMPARENDERA")); 
                   valueObject.setRANGOINICIAL(result.getString("RANGOINICIAL")); 
                   valueObject.setRANGOFINAL(result.getString("RANGOFINAL")); 
                   valueObject.setIDCOMPARENDO(result.getInt("IDCOMPARENDO")); 
                   valueObject.setANUMEROCOMPARENDO(result.getString("ANUMEROCOMPARENDO")); 
                   valueObject.setBFECHACOMPARENDO(result.getString("BFECHACOMPARENDO")); 
                   valueObject.setCIDENTIFICACION(result.getString("CIDENTIFICACION")); 
                   valueObject.setDNOMBRESINFRACTOR(result.getString("DNOMBRESINFRACTOR")); 
                   valueObject.setEAPELLIDINFRACTOR(result.getString("EAPELLIDINFRACTOR")); 

              } else {
                    //System.out.println("ViewComparendosInfractor Object Not Found!");
                    throw new NotFoundException("ViewComparendosInfractor Object Not Found!");
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
                   ViewComparendosInfractor temp = createValueObject();

                   temp.setIDAGENTE(result.getInt("IDAGENTE")); 
                   temp.setNOMBRESAGENTE(result.getString("NOMBRESAGENTE")); 
                   temp.setPAPELLIDOAGEN(result.getString("PAPELLIDOAGEN")); 
                   temp.setSAPELLIDOAGEN(result.getString("SAPELLIDOAGEN")); 
                   temp.setIDCOMPARENDERA(result.getInt("IDCOMPARENDERA")); 
                   temp.setESTADOCOMPARENDERA(result.getInt("ESTADOCOMPARENDERA")); 
                   temp.setRANGOINICIAL(result.getString("RANGOINICIAL")); 
                   temp.setRANGOFINAL(result.getString("RANGOFINAL")); 
                   temp.setIDCOMPARENDO(result.getInt("IDCOMPARENDO")); 
                   temp.setANUMEROCOMPARENDO(result.getString("ANUMEROCOMPARENDO")); 
                   temp.setBFECHACOMPARENDO(result.getString("BFECHACOMPARENDO")); 
                   temp.setCIDENTIFICACION(result.getString("CIDENTIFICACION")); 
                   temp.setDNOMBRESINFRACTOR(result.getString("DNOMBRESINFRACTOR")); 
                   temp.setEAPELLIDINFRACTOR(result.getString("EAPELLIDINFRACTOR")); 

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


}