package modelo.datos.dao.rangos;


import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.rangos.RangosDeplacas;
import modelo.datos.objetos.rangos.RangosLicencias;

import utilidades.Funciones;


/**
  * RangosLicencias Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve RangosLicencias object instances.
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



public class RangosLicenciasDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public RangosLicencias createValueObject() {
          return new RangosLicencias();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public RangosLicencias getObject(Connection conn, int ID_RANGO) throws NotFoundException, SQLException {

          RangosLicencias valueObject = createValueObject();
          valueObject.setID_RANGO(ID_RANGO);
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
    public void load(Connection conn, RangosLicencias valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM RANGOS_LICENCIAS WHERE (ID_RANGO = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getID_RANGO()); 

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

          String sql = "SELECT * FROM RANGOS_LICENCIAS ORDER BY ID_RANGO ASC ";
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
    public synchronized void create(Connection conn, RangosLicencias valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO RANGOS_LICENCIAS ( ID_RANGO, R_INICIAL, R_FINAL, "
               + "FECHARESOLUCION, NUM_RESOLUCION, ID_ESPECIEVENAL, "
               + "ULT_ASIGNADA, DISPONIBLES) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getID_RANGO()); 
              
              if (!Funciones.EnteroesNulo(valueObject.getR_INICIAL()))
                  stmt.setInt(2, valueObject.getR_INICIAL());
              else
                  stmt.setNull(2, Types.INTEGER); 
              if (!Funciones.EnteroesNulo(valueObject.getR_FINAL()))
                  stmt.setInt(3, valueObject.getR_FINAL());
              else
                  stmt.setNull(3, Types.INTEGER); 
              if (Funciones.esFecha(valueObject.getFECHARESOLUCION()))
                  stmt.setDate(4,Funciones.convFechaSSQL(valueObject.getFECHARESOLUCION()));
              else
                  stmt.setNull(4, Types.DATE);            
              if (Funciones.contarCadena(valueObject.getNUM_RESOLUCION(), 10))
                  stmt.setString(5, valueObject.getNUM_RESOLUCION());
              else
                  stmt.setNull(5, Types.VARCHAR);
              if (!Funciones.EnteroesNulo(valueObject.getID_ESPECIEVENAL()))
                  stmt.setInt(6, valueObject.getID_ESPECIEVENAL());
              else
                  stmt.setNull(6, Types.INTEGER); 
              if (!Funciones.EnteroesNulo(valueObject.getULT_ASIGNADA()))
                  stmt.setInt(7, valueObject.getULT_ASIGNADA());
              else
                  stmt.setNull(7, Types.INTEGER); 
              if (!Funciones.EnteroesNulo(valueObject.getDISPONIBLES()))
                  stmt.setInt(8, valueObject.getDISPONIBLES());
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
    public void save(Connection conn, RangosLicencias valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE RANGOS_LICENCIAS SET R_INICIAL = ?, R_FINAL = ?, FECHARESOLUCION = ?, "
               + "NUM_RESOLUCION = ?, ID_ESPECIEVENAL = ?, ULT_ASIGNADA = ?, "
               + "DISPONIBLES = ? WHERE (ID_RANGO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getR_INICIAL()); 
              stmt.setInt(2, valueObject.getR_FINAL()); 
              
            if (Funciones.esFecha(valueObject.getFECHARESOLUCION()))
              stmt.setDate(3, Funciones.convFechaSSQL(valueObject.getFECHARESOLUCION()));
            else
              stmt.setNull(3, Types.DATE);
              
              stmt.setString(4, valueObject.getNUM_RESOLUCION()); 
              stmt.setInt(5, valueObject.getID_ESPECIEVENAL()); 
              stmt.setInt(6, valueObject.getULT_ASIGNADA()); 
              stmt.setInt(7, valueObject.getDISPONIBLES()); 

              stmt.setInt(8, valueObject.getID_RANGO()); 

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
    public void delete(Connection conn, RangosLicencias valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM RANGOS_LICENCIAS WHERE (ID_RANGO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID_RANGO()); 

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

          String sql = "DELETE FROM RANGOS_LICENCIAS";
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

          String sql = "SELECT count(*) FROM RANGOS_LICENCIAS";
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
    public List searchMatching(Connection conn, RangosLicencias valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM RANGOS_LICENCIAS WHERE 1=1 ");

          if (valueObject.getID_RANGO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_RANGO = ").append(valueObject.getID_RANGO()).append(" ");
          }

          if (valueObject.getR_INICIAL() != 0) {
              if (first) { first = false; }
              sql.append("AND R_INICIAL = ").append(valueObject.getR_INICIAL()).append(" ");
          }

          if (valueObject.getR_FINAL() != 0) {
              if (first) { first = false; }
              sql.append("AND R_FINAL = ").append(valueObject.getR_FINAL()).append(" ");
          }

          if (valueObject.getFECHARESOLUCION() != null) {
              if (first) { first = false; }
              sql.append("AND FECHARESOLUCION LIKE '").append(valueObject.getFECHARESOLUCION()).append("%' ");
          }

          if (valueObject.getNUM_RESOLUCION() != null) {
              if (first) { first = false; }
              sql.append("AND NUM_RESOLUCION LIKE '").append(valueObject.getNUM_RESOLUCION()).append("%' ");
          }

          if (valueObject.getID_ESPECIEVENAL() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_ESPECIEVENAL = ").append(valueObject.getID_ESPECIEVENAL()).append(" ");
          }

          if (valueObject.getULT_ASIGNADA() != 0) {
              if (first) { first = false; }
              sql.append("AND ULT_ASIGNADA = ").append(valueObject.getULT_ASIGNADA()).append(" ");
          }

          if (valueObject.getDISPONIBLES() != 0) {
              if (first) { first = false; }
              sql.append("AND DISPONIBLES = ").append(valueObject.getDISPONIBLES()).append(" ");
          }


          sql.append("ORDER BY ID_RANGO ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, RangosLicencias valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setID_RANGO(result.getInt("ID_RANGO")); 
                   valueObject.setR_INICIAL(result.getInt("R_INICIAL")); 
                   valueObject.setR_FINAL(result.getInt("R_FINAL")); 
                   valueObject.setFECHARESOLUCION(result.getString("FECHARESOLUCION")); 
                   valueObject.setNUM_RESOLUCION(result.getString("NUM_RESOLUCION")); 
                   valueObject.setID_ESPECIEVENAL(result.getInt("ID_ESPECIEVENAL")); 
                   valueObject.setULT_ASIGNADA(result.getInt("ULT_ASIGNADA")); 
                   valueObject.setDISPONIBLES(result.getInt("DISPONIBLES")); 

              } else {
                    //System.out.println("RangosLicencias Object Not Found!");
                    throw new NotFoundException("RangosLicencias Object Not Found!");
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
                   RangosLicencias temp = createValueObject();

                   temp.setID_RANGO(result.getInt("ID_RANGO")); 
                   temp.setR_INICIAL(result.getInt("R_INICIAL")); 
                   temp.setR_FINAL(result.getInt("R_FINAL")); 
                   temp.setFECHARESOLUCION(result.getString("FECHARESOLUCION")); 
                   temp.setNUM_RESOLUCION(result.getString("NUM_RESOLUCION")); 
                   temp.setID_ESPECIEVENAL(result.getInt("ID_ESPECIEVENAL")); 
                   temp.setULT_ASIGNADA(result.getInt("ULT_ASIGNADA")); 
                   temp.setDISPONIBLES(result.getInt("DISPONIBLES")); 

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
    
    public void actualizarDisponibles(Connection conn, RangosLicencias valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE RANGOS_LICENCIAS SET DISPONIBLES = ? WHERE (ID_RANGO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              if (!Funciones.EnteroesNulo(valueObject.getDISPONIBLES()))
                  stmt.setInt(1, valueObject.getDISPONIBLES());
              else
                  stmt.setNull(1, Types.INTEGER);
              stmt.setInt(2, valueObject.getID_RANGO()); 

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
    
    public void cambiaDatosRadicacion(Connection conn, RangosLicencias valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE RANGOS_LICENCIAS SET NUM_RESOLUCION = ?, FECHARESOLUCION = ? " +
              "WHERE (ID_RANGO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              if (Funciones.contarCadena(valueObject.getNUM_RESOLUCION(), 10))
                  stmt.setString(1, valueObject.getNUM_RESOLUCION());
              else
                  stmt.setNull(1, Types.VARCHAR);
              if (Funciones.esFecha(valueObject.getFECHARESOLUCION()))
                  stmt.setDate(2,Funciones.convFechaSSQL(valueObject.getFECHARESOLUCION()));
              else
                  stmt.setNull(2, Types.DATE);
              stmt.setInt(3, valueObject.getID_RANGO()); 

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


}