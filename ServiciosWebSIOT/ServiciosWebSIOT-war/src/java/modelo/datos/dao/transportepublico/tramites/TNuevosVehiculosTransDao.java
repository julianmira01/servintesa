package modelo.datos.dao.transportepublico.tramites;

import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.transportepublico.tramites.TNuevosVehiculosTrans;

import utilidades.Funciones;


/**
  * TNuevosVehiculosTrans Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve TNuevosVehiculosTrans object instances.
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



public class TNuevosVehiculosTransDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public TNuevosVehiculosTrans createValueObject() {
          return new TNuevosVehiculosTrans();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public TNuevosVehiculosTrans getObject(Connection conn, int TNV_ID) throws NotFoundException, SQLException {

          TNuevosVehiculosTrans valueObject = createValueObject();
          valueObject.setTNV_ID(TNV_ID);
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
    public void load(Connection conn, TNuevosVehiculosTrans valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM T_NUEVOSVEHICULO WHERE (TNV_ID = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getTNV_ID()); 

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

          String sql = "SELECT * FROM T_NUEVOSVEHICULO ORDER BY TNV_ID ASC ";
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
    public synchronized void create(Connection conn, TNuevosVehiculosTrans valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO T_NUEVOSVEHICULO (TNV_ID, TNV_ID_CVEHICULO, TNV_MARCA, "
               + "TNV_MODELO, TNV_MOTOR, TNV_CHASIS, TNV_PLACA) VALUES (?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getTNV_ID()); 
              
               if(valueObject.getTNV_ID_CVEHICULO()==0)
                   stmt.setNull(2, valueObject.getTNV_ID_CVEHICULO());
               else if (!Funciones.EnteroesNulo(valueObject.getTNV_ID_CVEHICULO())) 
                   stmt.setInt(2, valueObject.getTNV_ID_CVEHICULO()); 
               else
                   stmt.setNull(2, Types.INTEGER); 
              
               if(Funciones.contarCadena(valueObject.getTNV_MARCA(), 20))
                   stmt.setString(3, valueObject.getTNV_MARCA());
               else
                   stmt.setNull(3, Types.VARCHAR); 
                 
               if(Funciones.contarCadena(valueObject.getTNV_MODELO(), 20))
                   stmt.setString(4, valueObject.getTNV_MODELO());
               else
                   stmt.setNull(4, Types.VARCHAR);             
                 
               if(Funciones.contarCadena(valueObject.getTNV_MOTOR(), 25))
                   stmt.setString(5, valueObject.getTNV_MOTOR());
               else
                   stmt.setNull(5, Types.VARCHAR);  
    
               if(Funciones.contarCadena(valueObject.getTNV_CHASIS(), 40))
                   stmt.setString(6, valueObject.getTNV_CHASIS());
               else
                   stmt.setNull(6, Types.VARCHAR); 
              
              if(Funciones.contarCadena(valueObject.getTNV_PLACA(), 7))
                  stmt.setString(7, valueObject.getTNV_PLACA());
              else
                  stmt.setNull(7, Types.VARCHAR); 

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
    public void save(Connection conn, TNuevosVehiculosTrans valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE T_NUEVOSVEHICULO SET TNV_ID_CVEHICULO = ?, TNV_MARCA = ?, TNV_MODELO = ?, "
               + "TNV_MOTOR = ?, TNV_CHASIS = ?, TNV_PLACA = ? WHERE (TNV_ID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              
              if(valueObject.getTNV_ID_CVEHICULO()==0)
                  stmt.setNull(1, valueObject.getTNV_ID_CVEHICULO());
              else if (!Funciones.EnteroesNulo(valueObject.getTNV_ID_CVEHICULO())) 
                  stmt.setInt(1, valueObject.getTNV_ID_CVEHICULO()); 
              else
                  stmt.setNull(1, Types.INTEGER); 
              
              if(Funciones.contarCadena(valueObject.getTNV_MARCA(), 20))
                  stmt.setString(2, valueObject.getTNV_MARCA());
              else
                  stmt.setNull(2, Types.VARCHAR); 
                
              if(Funciones.contarCadena(valueObject.getTNV_MODELO(), 20))
                  stmt.setString(3, valueObject.getTNV_MODELO());
              else
                  stmt.setNull(3, Types.VARCHAR);             
                
              if(Funciones.contarCadena(valueObject.getTNV_MOTOR(), 25))
                  stmt.setString(4, valueObject.getTNV_MOTOR());
              else
                  stmt.setNull(4, Types.VARCHAR);  
              
              if(Funciones.contarCadena(valueObject.getTNV_CHASIS(), 40))
                  stmt.setString(5, valueObject.getTNV_CHASIS());
              else
                  stmt.setNull(5, Types.VARCHAR); 
              
              if(Funciones.contarCadena(valueObject.getTNV_PLACA(), 7))
                  stmt.setString(6, valueObject.getTNV_PLACA());
              else
                  stmt.setNull(6, Types.VARCHAR); 
              

              stmt.setInt(7, valueObject.getTNV_ID()); 

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
    public void delete(Connection conn, TNuevosVehiculosTrans valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM T_NUEVOSVEHICULO WHERE (TNV_ID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getTNV_ID()); 

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

          String sql = "DELETE FROM T_NUEVOSVEHICULO";
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

          String sql = "SELECT count(*) FROM T_NUEVOSVEHICULO";
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
    public List searchMatching(Connection conn, TNuevosVehiculosTrans valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM T_NUEVOSVEHICULO WHERE 1=1 ");

          if (valueObject.getTNV_ID() != 0) {
              if (first) { first = false; }
              sql.append("AND TNV_ID = ").append(valueObject.getTNV_ID()).append(" ");
          }

          if (valueObject.getTNV_ID_CVEHICULO() != 0) {
              if (first) { first = false; }
              sql.append("AND TNV_ID_CVEHICULO = ").append(valueObject.getTNV_ID_CVEHICULO()).append(" ");
          }

          if (valueObject.getTNV_MARCA() != null) {
              if (first) { first = false; }
              sql.append("AND TNV_MARCA = '").append(valueObject.getTNV_MARCA()).append("' ");
          }

          if (valueObject.getTNV_MODELO() != null) {
              if (first) { first = false; }
              sql.append("AND TNV_MODELO = '").append(valueObject.getTNV_MODELO()).append("' ");
          }

          if (valueObject.getTNV_MOTOR() != null) {
              if (first) { first = false; }
              sql.append("AND TNV_MOTOR = '").append(valueObject.getTNV_MOTOR()).append("' ");
          }

          if (valueObject.getTNV_CHASIS() != null) {
              if (first) { first = false; }
              sql.append("AND TNV_CHASIS = '").append(valueObject.getTNV_CHASIS()).append("' ");
          }
          
        if (valueObject.getTNV_PLACA() != null) {
            if (first) { first = false; }
            sql.append("AND TNV_PLACA = '").append(valueObject.getTNV_PLACA()).append("' ");
        }


          sql.append("ORDER BY TNV_ID ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, TNuevosVehiculosTrans valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setTNV_ID(result.getInt("TNV_ID")); 
                   valueObject.setTNV_ID_CVEHICULO(result.getInt("TNV_ID_CVEHICULO")); 
                   valueObject.setTNV_MARCA(result.getString("TNV_MARCA")); 
                   valueObject.setTNV_MODELO(result.getString("TNV_MODELO")); 
                   valueObject.setTNV_MOTOR(result.getString("TNV_MOTOR")); 
                   valueObject.setTNV_CHASIS(result.getString("TNV_CHASIS")); 
                   valueObject.setTNV_PLACA(result.getString("TNV_PLACA"));

              } else {
                    //System.out.println("TNuevosVehiculosTrans Object Not Found!");
                    throw new NotFoundException("TNuevosVehiculosTrans Object Not Found!");
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
                   TNuevosVehiculosTrans temp = createValueObject();

                   temp.setTNV_ID(result.getInt("TNV_ID")); 
                   temp.setTNV_ID_CVEHICULO(result.getInt("TNV_ID_CVEHICULO")); 
                   temp.setTNV_MARCA(result.getString("TNV_MARCA")); 
                   temp.setTNV_MODELO(result.getString("TNV_MODELO")); 
                   temp.setTNV_MOTOR(result.getString("TNV_MOTOR")); 
                   temp.setTNV_CHASIS(result.getString("TNV_CHASIS")); 
                   temp.setTNV_PLACA(result.getString("TNV_PLACA"));

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

    public int getMaxId(Connection conn) throws SQLException {
    
          String sql = "SELECT GEN_ID(GEN_T_NUEVOSVEHICULO_TNV_ID,1) FROM TRANSITO";
          PreparedStatement stmt = null;
          ResultSet result = null;
          int allRows = 0;
          try {
              stmt = conn.prepareStatement(sql);
              result = stmt.executeQuery();
    
              if (result.next())
                  allRows = result.getInt(1)+1;
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
          return allRows;
    }

}

