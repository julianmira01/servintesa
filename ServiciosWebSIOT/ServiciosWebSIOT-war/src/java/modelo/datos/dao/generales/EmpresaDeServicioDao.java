package modelo.datos.dao.generales;

import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generales.EmpresaDeServicio;


/**
  * EmpresaDeServicio Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve EmpresaDeServicio object instances.
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



public class EmpresaDeServicioDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public EmpresaDeServicio createValueObject() {
          return new EmpresaDeServicio();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public EmpresaDeServicio getObject(Connection conn, int ID_EMPSERVICIO) throws NotFoundException, SQLException {

          EmpresaDeServicio valueObject = createValueObject();
          valueObject.setID_EMPSERVICIO(ID_EMPSERVICIO);
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
    public void load(Connection conn, EmpresaDeServicio valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM EMPRESASDESERVICIO WHERE (ID_EMPSERVICIO = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getID_EMPSERVICIO()); 

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

          String sql = "SELECT * FROM EMPRESASDESERVICIO ORDER BY ID_EMPSERVICIO ASC ";
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
    public synchronized void create(Connection conn, EmpresaDeServicio valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO EMPRESASDESERVICIO ( ID_EMPSERVICIO, NOMBRE, SIGLA, "
               + "DIRECCION, TELEFONO, ID_DOCTO, "
               + "NIT, DIGVERIF, ES_CUPOSTOTAL, "
               + "ES_CUPOSDISP, TOTALCUPOBUSMICRO, ID_DOCTO_RUNT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getID_EMPSERVICIO()); 
               stmt.setString(2, valueObject.getNOMBRE()); 
               stmt.setString(3, valueObject.getSIGLA()); 
               stmt.setString(4, valueObject.getDIRECCION()); 
               stmt.setString(5, valueObject.getTELEFONO()); 
               stmt.setString(6, valueObject.getID_DOCTO()); 
               stmt.setString(7, valueObject.getNIT()); 
               stmt.setInt(8, valueObject.getDIGVERIF()); 
               stmt.setInt(9, valueObject.getES_CUPOSTOTAL()); 
               stmt.setInt(10, valueObject.getES_CUPOSDISP()); 
               stmt.setInt(11, valueObject.getTOTALCUPOBUSMICRO()); 
               stmt.setString(12, valueObject.getID_DOCTO_RUNT()); 

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
    public void save(Connection conn, EmpresaDeServicio valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE EMPRESASDESERVICIO SET NOMBRE = ?, SIGLA = ?, DIRECCION = ?, "
               + "TELEFONO = ?, ID_DOCTO = ?, NIT = ?, "
               + "DIGVERIF = ?, ES_CUPOSTOTAL = ?, ES_CUPOSDISP = ?, "
               + "TOTALCUPOBUSMICRO = ?, ID_DOCTO_RUNT = ? WHERE (ID_EMPSERVICIO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getNOMBRE()); 
              stmt.setString(2, valueObject.getSIGLA()); 
              stmt.setString(3, valueObject.getDIRECCION()); 
              stmt.setString(4, valueObject.getTELEFONO()); 
              stmt.setString(5, valueObject.getID_DOCTO()); 
              stmt.setString(6, valueObject.getNIT()); 
              stmt.setInt(7, valueObject.getDIGVERIF()); 
              stmt.setInt(8, valueObject.getES_CUPOSTOTAL()); 
              stmt.setInt(9, valueObject.getES_CUPOSDISP()); 
              stmt.setInt(10, valueObject.getTOTALCUPOBUSMICRO()); 
              stmt.setString(11, valueObject.getID_DOCTO_RUNT()); 

              stmt.setInt(12, valueObject.getID_EMPSERVICIO()); 

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
    public void delete(Connection conn, EmpresaDeServicio valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM EMPRESASDESERVICIO WHERE (ID_EMPSERVICIO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID_EMPSERVICIO()); 

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

          String sql = "DELETE FROM EMPRESASDESERVICIO";
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

          String sql = "SELECT count(*) FROM EMPRESASDESERVICIO";
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
    public List searchMatching(Connection conn, EmpresaDeServicio valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM EMPRESASDESERVICIO WHERE 1=1 ");

          if (valueObject.getID_EMPSERVICIO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_EMPSERVICIO = ").append(valueObject.getID_EMPSERVICIO()).append(" ");
          }

          if (valueObject.getNOMBRE() != null) {
              if (first) { first = false; }
              sql.append("AND NOMBRE LIKE '").append(valueObject.getNOMBRE()).append("%' ");
          }

          if (valueObject.getSIGLA() != null) {
              if (first) { first = false; }
              sql.append("AND SIGLA LIKE '").append(valueObject.getSIGLA()).append("%' ");
          }

          if (valueObject.getDIRECCION() != null) {
              if (first) { first = false; }
              sql.append("AND DIRECCION LIKE '").append(valueObject.getDIRECCION()).append("%' ");
          }

          if (valueObject.getTELEFONO() != null) {
              if (first) { first = false; }
              sql.append("AND TELEFONO LIKE '").append(valueObject.getTELEFONO()).append("%' ");
          }

          if (valueObject.getID_DOCTO() != null) {
              if (first) { first = false; }
              sql.append("AND ID_DOCTO LIKE '").append(valueObject.getID_DOCTO()).append("%' ");
          }

          if (valueObject.getNIT() != null) {
              if (first) { first = false; }
              sql.append("AND NIT LIKE '").append(valueObject.getNIT()).append("%' ");
          }

          if (valueObject.getDIGVERIF() != 0) {
              if (first) { first = false; }
              sql.append("AND DIGVERIF = ").append(valueObject.getDIGVERIF()).append(" ");
          }

          if (valueObject.getES_CUPOSTOTAL() != 0) {
              if (first) { first = false; }
              sql.append("AND ES_CUPOSTOTAL = ").append(valueObject.getES_CUPOSTOTAL()).append(" ");
          }

          if (valueObject.getES_CUPOSDISP() != 0) {
              if (first) { first = false; }
              sql.append("AND ES_CUPOSDISP = ").append(valueObject.getES_CUPOSDISP()).append(" ");
          }

          if (valueObject.getTOTALCUPOBUSMICRO() != 0) {
              if (first) { first = false; }
              sql.append("AND TOTALCUPOBUSMICRO = ").append(valueObject.getTOTALCUPOBUSMICRO()).append(" ");
          }

          if (valueObject.getID_DOCTO_RUNT() != null) {
              if (first) { first = false; }
              sql.append("AND ID_DOCTO_RUNT LIKE '").append(valueObject.getID_DOCTO_RUNT()).append("%' ");
          }


          sql.append("ORDER BY ID_EMPSERVICIO ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, EmpresaDeServicio valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setID_EMPSERVICIO(result.getInt("ID_EMPSERVICIO")); 
                   valueObject.setNOMBRE(result.getString("NOMBRE")); 
                   valueObject.setSIGLA(result.getString("SIGLA")); 
                   valueObject.setDIRECCION(result.getString("DIRECCION")); 
                   valueObject.setTELEFONO(result.getString("TELEFONO")); 
                   valueObject.setID_DOCTO(result.getString("ID_DOCTO")); 
                   valueObject.setNIT(result.getString("NIT")); 
                   valueObject.setDIGVERIF(result.getInt("DIGVERIF")); 
                   valueObject.setES_CUPOSTOTAL(result.getInt("ES_CUPOSTOTAL")); 
                   valueObject.setES_CUPOSDISP(result.getInt("ES_CUPOSDISP")); 
                   valueObject.setTOTALCUPOBUSMICRO(result.getInt("TOTALCUPOBUSMICRO")); 
                   valueObject.setID_DOCTO_RUNT(result.getString("ID_DOCTO_RUNT")); 

              } else {
                    //System.out.println("EmpresaDeServicio Object Not Found!");
                    throw new NotFoundException("EmpresaDeServicio Object Not Found!");
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
                   EmpresaDeServicio temp = createValueObject();

                   temp.setID_EMPSERVICIO(result.getInt("ID_EMPSERVICIO")); 
                   temp.setNOMBRE(result.getString("NOMBRE")); 
                   temp.setSIGLA(result.getString("SIGLA")); 
                   temp.setDIRECCION(result.getString("DIRECCION")); 
                   temp.setTELEFONO(result.getString("TELEFONO")); 
                   temp.setID_DOCTO(result.getString("ID_DOCTO")); 
                   temp.setNIT(result.getString("NIT")); 
                   temp.setDIGVERIF(result.getInt("DIGVERIF")); 
                   temp.setES_CUPOSTOTAL(result.getInt("ES_CUPOSTOTAL")); 
                   temp.setES_CUPOSDISP(result.getInt("ES_CUPOSDISP")); 
                   temp.setTOTALCUPOBUSMICRO(result.getInt("TOTALCUPOBUSMICRO")); 
                   temp.setID_DOCTO_RUNT(result.getString("ID_DOCTO_RUNT")); 

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
