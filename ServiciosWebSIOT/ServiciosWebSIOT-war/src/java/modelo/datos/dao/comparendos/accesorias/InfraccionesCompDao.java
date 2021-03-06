package modelo.datos.dao.comparendos.accesorias;



import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.accesorias.InfraccionesComp;

import utilidades.Funciones;


/**
  * InfraccionesComp Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve InfraccionesComp object instances.
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



public class InfraccionesCompDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public InfraccionesComp createValueObject() {
          return new InfraccionesComp();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public InfraccionesComp getObject(Connection conn, int ID_INFRACCION) throws NotFoundException, SQLException {

          InfraccionesComp valueObject = createValueObject();
          valueObject.setID_INFRACCION(ID_INFRACCION);
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
    public void load(Connection conn, InfraccionesComp valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM INFRACCIONES WHERE (ID_INFRACCION = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getID_INFRACCION()); 

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

          String sql = "SELECT * FROM INFRACCIONES ORDER BY ID_INFRACCION ASC ";
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
    public synchronized void create(Connection conn, InfraccionesComp valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO INFRACCIONES ( ID_INFRACCION, COD_INFRACCION, NUMEROSALARIO, "
               + "DESCRIPCION, ESTADO, NUEVO_CODIGO, "
               + "FECHADESDE, FECHAHASTA, REPORTARSIMIT, "
               + "NUEVO_CODIGOCORREGIDO, PORCENTAJE_MOROSIDAD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
              
              stmt = conn.prepareStatement(sql);
              
              stmt.setInt(1,valueObject.getID_INFRACCION()); 
              if (Funciones.contarCadena(valueObject.getCOD_INFRACCION(), 5))
                  stmt.setString(2, valueObject.getCOD_INFRACCION()); 
              else
                  stmt.setNull(2, Types.VARCHAR);
              if (!Funciones.DoubleEsNulo(valueObject.getNUMEROSALARIO()))
                  stmt.setDouble(3, valueObject.getNUMEROSALARIO()); 
              else
                  stmt.setNull(3, Types.DOUBLE);
              if (Funciones.contarCadena(valueObject.getDESCRIPCION(), 1200))
                  stmt.setString(4, valueObject.getDESCRIPCION()); 
              else
                  stmt.setNull(4, Types.VARCHAR);
              if (Funciones.contarCadena(valueObject.getESTADO(), 1))
                  stmt.setString(5, valueObject.getESTADO()); 
              else
                  stmt.setNull(5, Types.VARCHAR);
              if (Funciones.contarCadena(valueObject.getNUEVO_CODIGO(), 5))
                  stmt.setString(6, valueObject.getNUEVO_CODIGO()); 
              else
                  stmt.setNull(6, Types.VARCHAR);
              if (Funciones.esFecha(valueObject.getFECHADESDE()))
                  stmt.setDate(7, Funciones.convFechaSSQL(valueObject.getFECHADESDE())); 
              else
                  stmt.setNull(7, Types.DATE);
              if (Funciones.esFecha(valueObject.getFECHAHASTA()))
                  stmt.setDate(8,Funciones.convFechaSSQL(valueObject.getFECHAHASTA())); 
              else
                  stmt.setNull(8, Types.DATE);
              if (Funciones.contarCadena(valueObject.getREPORTARSIMIT(), 1))
                  stmt.setString(9, valueObject.getREPORTARSIMIT()); 
              else
                  stmt.setNull(9, Types.VARCHAR);
              
              if (Funciones.contarCadena(valueObject.getNUEVO_CODIGOCORREGIDO(), 5))
                  stmt.setString(10, valueObject.getNUEVO_CODIGOCORREGIDO());
              else
                  stmt.setNull(10, Types.VARCHAR);
              
              stmt.setInt(11,valueObject.getPORCENTAJE_MOROSIDAD());
              
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
    public void save(Connection conn, InfraccionesComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE INFRACCIONES SET COD_INFRACCION = ?, NUMEROSALARIO = ?, DESCRIPCION = ?, "
               + "ESTADO = ?, NUEVO_CODIGO = ?, FECHADESDE = ?, "
               + "FECHAHASTA = ?, REPORTARSIMIT = ?, NUEVO_CODIGOCORREGIDO = ?, PORCENTAJE_MOROSIDAD = ? WHERE (ID_INFRACCION = ? ) ";
          PreparedStatement stmt = null;

          try {
              
              stmt = conn.prepareStatement(sql);
              if (Funciones.contarCadena(valueObject.getCOD_INFRACCION(), 5))
                stmt.setString(1, valueObject.getCOD_INFRACCION()); 
              else
                stmt.setNull(1, Types.VARCHAR);
              if (!Funciones.DoubleEsNulo(valueObject.getNUMEROSALARIO()))
                stmt.setDouble(2, valueObject.getNUMEROSALARIO()); 
              else
                stmt.setNull(2, Types.DOUBLE);
              if (Funciones.contarCadena(valueObject.getDESCRIPCION(), 1200))
                stmt.setString(3, valueObject.getDESCRIPCION()); 
              else
                stmt.setNull(3, Types.VARCHAR);
              if (Funciones.contarCadena(valueObject.getESTADO(), 1))
                stmt.setString(4, valueObject.getESTADO()); 
              else
                stmt.setNull(4, Types.VARCHAR);
              if (Funciones.contarCadena(valueObject.getNUEVO_CODIGO(), 5))
                stmt.setString(5, valueObject.getNUEVO_CODIGO()); 
              else
                stmt.setNull(5, Types.VARCHAR);
              if (Funciones.esFecha(valueObject.getFECHADESDE()))
                stmt.setDate(6, Funciones.convFechaSSQL(valueObject.getFECHADESDE())); 
              else
                stmt.setNull(6, Types.DATE);
              if (Funciones.esFecha(valueObject.getFECHAHASTA()))
                stmt.setDate(7,Funciones.convFechaSSQL(valueObject.getFECHAHASTA())); 
              else
                stmt.setNull(7, Types.DATE);
              if (Funciones.contarCadena(valueObject.getREPORTARSIMIT(), 1))
                stmt.setString(8, valueObject.getREPORTARSIMIT()); 
              else
                stmt.setNull(8, Types.VARCHAR);
              if (Funciones.contarCadena(valueObject.getNUEVO_CODIGOCORREGIDO(), 5))
                  stmt.setString(9, valueObject.getNUEVO_CODIGOCORREGIDO());
              else
                  stmt.setNull(9, Types.VARCHAR);
              try{
              stmt.setInt(10, valueObject.getPORCENTAJE_MOROSIDAD());
              }catch(Exception exce){stmt.setInt(10, Types.NULL);}
              stmt.setInt(11, valueObject.getID_INFRACCION()); 
                        
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
    public void delete(Connection conn, InfraccionesComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM INFRACCIONES WHERE (ID_INFRACCION = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID_INFRACCION()); 

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

          String sql = "DELETE FROM INFRACCIONES";
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

          String sql = "SELECT count(*) FROM INFRACCIONES";
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
    public List searchMatching(Connection conn, InfraccionesComp valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM INFRACCIONES WHERE 1=1 ");

          if (valueObject.getID_INFRACCION() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_INFRACCION = ").append(valueObject.getID_INFRACCION()).append(" ");
          }

          if (valueObject.getCOD_INFRACCION() != null) {
              if (first) { first = false; }
              sql.append("AND COD_INFRACCION LIKE '").append(valueObject.getCOD_INFRACCION()).append("%' ");
          }

          if (valueObject.getNUMEROSALARIO() != 0) {
              if (first) { first = false; }
              sql.append("AND NUMEROSALARIO = ").append(valueObject.getNUMEROSALARIO()).append(" ");
          }

          if (valueObject.getDESCRIPCION() != null) {
              if (first) { first = false; }
              sql.append("AND DESCRIPCION LIKE '").append(valueObject.getDESCRIPCION()).append("%' ");
          }

          if (valueObject.getESTADO() != null) {
              if (first) { first = false; }
              sql.append("AND ESTADO LIKE '").append(valueObject.getESTADO()).append("%' ");
          }

          if (valueObject.getNUEVO_CODIGO() != null) {
              if (first) { first = false; }
              sql.append("AND NUEVO_CODIGO LIKE '").append(valueObject.getNUEVO_CODIGO()).append("%' ");
          }

          if (valueObject.getFECHADESDE() != null) {
              if (first) { first = false; }
              sql.append("AND FECHADESDE LIKE '").append(valueObject.getFECHADESDE()).append("%' ");
          }

          if (valueObject.getFECHAHASTA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAHASTA LIKE '").append(valueObject.getFECHAHASTA()).append("%' ");
          }

          if (valueObject.getREPORTARSIMIT() != null) {
              if (first) { first = false; }
              sql.append("AND REPORTARSIMIT LIKE '").append(valueObject.getREPORTARSIMIT()).append("%' ");
          }

          if (valueObject.getNUEVO_CODIGOCORREGIDO() != null) {
              if (first) { first = false; }
              sql.append("AND NUEVO_CODIGOCORREGIDO LIKE '").append(valueObject.getNUEVO_CODIGOCORREGIDO()).append("%' ");
          }
          
          if (valueObject.getPORCENTAJE_MOROSIDAD()!= null) {
              if (first) { first = false; }
              sql.append("AND PORCENTAJE_MOROSIDAD LIKE '").append(valueObject.getPORCENTAJE_MOROSIDAD()).append("%' ");
          }

          sql.append("ORDER BY ID_INFRACCION ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, InfraccionesComp valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setID_INFRACCION(result.getInt("ID_INFRACCION")); 
                   valueObject.setCOD_INFRACCION(result.getString("COD_INFRACCION")); 
                   valueObject.setNUMEROSALARIO(result.getDouble("NUMEROSALARIO")); 
                   valueObject.setDESCRIPCION(result.getString("DESCRIPCION")); 
                   valueObject.setESTADO(result.getString("ESTADO")); 
                   valueObject.setNUEVO_CODIGO(result.getString("NUEVO_CODIGO")); 
                   valueObject.setFECHADESDE(result.getString("FECHADESDE")); 
                   valueObject.setFECHAHASTA(result.getString("FECHAHASTA")); 
                   valueObject.setREPORTARSIMIT(result.getString("REPORTARSIMIT")); 
                   valueObject.setNUEVO_CODIGOCORREGIDO(result.getString("NUEVO_CODIGOCORREGIDO")); 
                   valueObject.setPORCENTAJE_MOROSIDAD(result.getInt("PORCENTAJE_MOROSIDAD"));

              } else {
                    //System.out.println("InfraccionesComp Object Not Found!");
                    throw new NotFoundException("InfraccionesComp Object Not Found!");
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
                   InfraccionesComp temp = createValueObject();

                   temp.setID_INFRACCION(result.getInt("ID_INFRACCION")); 
                   temp.setCOD_INFRACCION(result.getString("COD_INFRACCION")); 
                   temp.setNUMEROSALARIO(result.getDouble("NUMEROSALARIO")); 
                   temp.setDESCRIPCION(result.getString("DESCRIPCION")); 
                   temp.setESTADO(result.getString("ESTADO")); 
                   temp.setNUEVO_CODIGO(result.getString("NUEVO_CODIGO")); 
                   temp.setFECHADESDE(result.getString("FECHADESDE")); 
                   temp.setFECHAHASTA(result.getString("FECHAHASTA")); 
                   temp.setREPORTARSIMIT(result.getString("REPORTARSIMIT")); 
                   temp.setNUEVO_CODIGOCORREGIDO(result.getString("NUEVO_CODIGOCORREGIDO"));
                   temp.setPORCENTAJE_MOROSIDAD(result.getInt("PORCENTAJE_MOROSIDAD"));
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


