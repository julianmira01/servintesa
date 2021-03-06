package modelo.datos.dao.comparendos.generales;

import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.generales.InfracionComparendoComp;

import utilidades.Funciones;


/**
  * InfracionComparendoComp Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve InfracionComparendoComp object instances.
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



public class InfracionComparendoCompDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public InfracionComparendoComp createValueObject() {
          return new InfracionComparendoComp();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public InfracionComparendoComp getObject(Connection conn, int ID) throws NotFoundException, SQLException {

          InfracionComparendoComp valueObject = createValueObject();
          valueObject.setID(ID);
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
    public void load(Connection conn, InfracionComparendoComp valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM INFRACCIONCOMPARENDO WHERE (ID = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getID()); 

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

          String sql = "SELECT * FROM INFRACCIONCOMPARENDO ORDER BY ID ASC ";
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
    public synchronized void create(Connection conn, InfracionComparendoComp valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO INFRACCIONCOMPARENDO ( ID, IDCOMPARENDO, IDINFRACCION, "
               + "VALORINFRACCION, IDESTADO, TIPOLIQUIDACION, ID_TIPO_INFRACCION, ID_TIPO_COMPARENDO) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1,valueObject.getID()); 
               if (!Funciones.EnteroesNulo(valueObject.getIDCOMPARENDO()))
                   stmt.setInt(2, valueObject.getIDCOMPARENDO()); 
               else
                   stmt.setNull(2, Types.INTEGER);
               if (!Funciones.EnteroesNulo(valueObject.getIDINFRACCION()))
                   stmt.setInt(3, valueObject.getIDINFRACCION()); 
               else
                   stmt.setNull(3, Types.INTEGER);
               if (!Funciones.DoubleEsNulo(valueObject.getVALORINFRACCION()))
                   stmt.setDouble(4, valueObject.getVALORINFRACCION()); 
               else
                   stmt.setNull(4, Types.DOUBLE);
               if (!Funciones.EnteroesNulo(valueObject.getIDESTADO()))
                   stmt.setInt(5, valueObject.getIDESTADO()); 
               else
                   stmt.setNull(5, Types.INTEGER);
               if (Funciones.contarCadena(valueObject.getTIPOLIQUIDACION(), 1))
                   stmt.setString(6, valueObject.getTIPOLIQUIDACION()); 
               else 
                   stmt.setNull(6, Types.VARCHAR);
              if (!Funciones.EnteroesNulo(valueObject.getID_TIPO_INFRACCION()))
                  stmt.setInt(7, valueObject.getID_TIPO_INFRACCION()); 
              else
                  stmt.setNull(7, Types.INTEGER);
              if (!Funciones.EnteroesNulo(valueObject.getID_TIPO_COMPARENDO()))
                  stmt.setInt(8, valueObject.getID_TIPO_COMPARENDO()); 
              else
                  stmt.setNull(8, Types.INTEGER);
              

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
    public void save(Connection conn, InfracionComparendoComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE INFRACCIONCOMPARENDO SET IDCOMPARENDO = ?, IDINFRACCION = ?, VALORINFRACCION = ?, "
               + "IDESTADO = ?, TIPOLIQUIDACION = ?, ID_TIPO_INFRACCION = ?, ID_TIPO_COMPARENDO = ? WHERE (ID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
            if (!Funciones.EnteroesNulo(valueObject.getIDCOMPARENDO()))
                stmt.setInt(1, valueObject.getIDCOMPARENDO()); 
            else
                stmt.setNull(1, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getIDINFRACCION()))
                stmt.setInt(2, valueObject.getIDINFRACCION()); 
            else
                stmt.setNull(2, Types.INTEGER);
            if (!Funciones.DoubleEsNulo(valueObject.getVALORINFRACCION()))
                stmt.setDouble(3, valueObject.getVALORINFRACCION()); 
            else
                stmt.setNull(3, Types.DOUBLE);
            if (!Funciones.EnteroesNulo(valueObject.getIDESTADO()))
                stmt.setInt(4, valueObject.getIDESTADO()); 
            else
                stmt.setNull(4, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getTIPOLIQUIDACION(), 1))
                stmt.setString(5, valueObject.getTIPOLIQUIDACION()); 
            else 
                stmt.setNull(5, Types.VARCHAR);
              if (!Funciones.EnteroesNulo(valueObject.getID_TIPO_INFRACCION()))
                  stmt.setInt(6, valueObject.getID_TIPO_INFRACCION()); 
              else
                  stmt.setNull(6, Types.INTEGER);    
              if (!Funciones.EnteroesNulo(valueObject.getID_TIPO_COMPARENDO()))
                  stmt.setInt(7, valueObject.getID_TIPO_COMPARENDO()); 
              else
                  stmt.setNull(7, Types.INTEGER);

              stmt.setInt(8, valueObject.getID()); 
              
              
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
    
    public void cambiarEstado(Connection conn, InfracionComparendoComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE INFRACCIONCOMPARENDO SET IDESTADO = ? WHERE (ID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
            
            if (!Funciones.EnteroesNulo(valueObject.getIDESTADO()))
                stmt.setInt(1, valueObject.getIDESTADO()); 
            else
                stmt.setNull(1, Types.INTEGER);
              
            stmt.setInt(2, valueObject.getID()); 

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

    public void cambiarCodigo(Connection conn, InfracionComparendoComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE INFRACCIONCOMPARENDO SET IDINFRACCION = ?, VALORINFRACCION = ? WHERE (ID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
            
            if (!Funciones.EnteroesNulo(valueObject.getIDINFRACCION()))
                stmt.setInt(1, valueObject.getIDINFRACCION()); 
            else
                stmt.setNull(1, Types.INTEGER);
            if (!Funciones.DoubleEsNulo(valueObject.getVALORINFRACCION()))
                stmt.setDouble(2, valueObject.getVALORINFRACCION()); 
            else
                stmt.setNull(2, Types.DOUBLE);  
            stmt.setInt(3, valueObject.getID()); 

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
    public void delete(Connection conn, InfracionComparendoComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM INFRACCIONCOMPARENDO WHERE (ID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID()); 

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

          String sql = "DELETE FROM INFRACCIONCOMPARENDO";
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

          String sql = "SELECT count(*) FROM INFRACCIONCOMPARENDO";
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
    public List searchMatching(Connection conn, InfracionComparendoComp valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM INFRACCIONCOMPARENDO WHERE 1=1 ");

          if (valueObject.getID() != 0) {
              if (first) { first = false; }
              sql.append("AND ID = ").append(valueObject.getID()).append(" ");
          }

          if (valueObject.getIDCOMPARENDO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDCOMPARENDO = ").append(valueObject.getIDCOMPARENDO()).append(" ");
          }

          if (valueObject.getIDINFRACCION() != 0) {
              if (first) { first = false; }
              sql.append("AND IDINFRACCION = ").append(valueObject.getIDINFRACCION()).append(" ");
          }

          if (valueObject.getVALORINFRACCION() != 0) {
              if (first) { first = false; }
              sql.append("AND VALORINFRACCION = ").append(valueObject.getVALORINFRACCION()).append(" ");
          }

          if (valueObject.getIDESTADO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDESTADO = ").append(valueObject.getIDESTADO()).append(" ");
          }

          if (valueObject.getTIPOLIQUIDACION() != null) {
              if (first) { first = false; }
              sql.append("AND TIPOLIQUIDACION LIKE '").append(valueObject.getTIPOLIQUIDACION()).append("%' ");
          }
          
            if (valueObject.getID_TIPO_INFRACCION() != 0) {
                if (first) { first = false; }
                sql.append("AND ID_TIPO_INFRACCION = ").append(valueObject.getID_TIPO_INFRACCION()).append(" ");
            }

        if (valueObject.getID_TIPO_COMPARENDO() != 0) {
            if (first) { first = false; }
            sql.append("AND ID_TIPO_COMPARENDO = ").append(valueObject.getID_TIPO_COMPARENDO()).append(" ");
        }


          sql.append("ORDER BY ID ASC ");
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
    protected void singleQuery(Connection conn, PreparedStatement stmt, InfracionComparendoComp valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setID(result.getInt("ID")); 
                   valueObject.setIDCOMPARENDO(result.getInt("IDCOMPARENDO")); 
                   valueObject.setIDINFRACCION(result.getInt("IDINFRACCION")); 
                   valueObject.setVALORINFRACCION(result.getDouble("VALORINFRACCION")); 
                   valueObject.setIDESTADO(result.getInt("IDESTADO")); 
                   valueObject.setTIPOLIQUIDACION(result.getString("TIPOLIQUIDACION")); 
                  valueObject.setID_TIPO_COMPARENDO(result.getInt("ID_TIPO_COMPARENDO")); 
				  valueObject.setID_TIPO_INFRACCION(result.getInt("ID_TIPO_INFRACCION"));
              } else {
                    //System.out.println("InfracionComparendoComp Object Not Found!");
                    throw new NotFoundException("InfracionComparendoComp Object Not Found!");
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
                   InfracionComparendoComp temp = createValueObject();

                   temp.setID(result.getInt("ID")); 
                   temp.setIDCOMPARENDO(result.getInt("IDCOMPARENDO")); 
                   temp.setIDINFRACCION(result.getInt("IDINFRACCION")); 
                   temp.setVALORINFRACCION(result.getDouble("VALORINFRACCION")); 
                   temp.setIDESTADO(result.getInt("IDESTADO")); 
                   temp.setTIPOLIQUIDACION(result.getString("TIPOLIQUIDACION")); 
                  temp.setID_TIPO_INFRACCION(result.getInt("ID_TIPO_INFRACCION")); 
                  temp.setID_TIPO_COMPARENDO(result.getInt("ID_TIPO_COMPARENDO")); 
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
