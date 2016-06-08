package modelo.datos.dao.comparendos.planos;

import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.planos.ViewResFaltantesCarga;

import utilidades.Funciones;


/**
  * ViewResFaltantesCarga Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve ViewResFaltantesCarga object instances.
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



public class ViewResFaltantesCargaDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public ViewResFaltantesCarga createValueObject() {
          return new ViewResFaltantesCarga();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public ViewResFaltantesCarga getObject(Connection conn, String NUMERO) throws NotFoundException, SQLException {

          ViewResFaltantesCarga valueObject = createValueObject();
          valueObject.setNUMERO(NUMERO);
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
    public void load(Connection conn, ViewResFaltantesCarga valueObject) throws NotFoundException, SQLException {

          if (valueObject.getNUMERO() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new NotFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM VIEW_RES_FALTANTES_CARGA WHERE (NUMERO = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getNUMERO()); 

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

          String sql = "SELECT * FROM VIEW_RES_FALTANTES_CARGA ORDER BY NUMERO ASC ";
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
    public synchronized void create(Connection conn, ViewResFaltantesCarga valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO VIEW_RES_FALTANTES_CARGA ( NUMERO, FECHA, CODTIPORESOLUCION, "
               + "NUMEROCOMPARENDO, ID_COMPARENDO, FECHACOMPARENDO, "
               + "POLCA, VALORALCOLEMIA, NROIDENTIFICACION, "
               + "ID_DOCTO, NOMBRES, APELLIDOS, "
               + "DIRECCION, TELEFONO, CODCIUDAD, "
               + "ID_DEPTO, VALORINFRACCION, ID, "
               + "COD_INFRACCION, NUEVO_CODIGO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getNUMERO()); 
               stmt.setString(2, valueObject.getFECHA()); 
               stmt.setString(3, valueObject.getCODTIPORESOLUCION()); 
               stmt.setString(4, valueObject.getNUMEROCOMPARENDO()); 
               stmt.setInt(5, valueObject.getID_COMPARENDO()); 
               stmt.setString(6, valueObject.getFECHACOMPARENDO()); 
               stmt.setString(7, valueObject.getPOLCA()); 
               stmt.setString(8, valueObject.getVALORALCOLEMIA()); 
               stmt.setString(9, valueObject.getNROIDENTIFICACION()); 
               stmt.setString(10, valueObject.getID_DOCTO()); 
               stmt.setString(11, valueObject.getNOMBRES()); 
               stmt.setString(12, valueObject.getAPELLIDOS()); 
               stmt.setString(13, valueObject.getDIRECCION()); 
               stmt.setString(14, valueObject.getTELEFONO()); 
               stmt.setString(15, valueObject.getCODCIUDAD()); 
               stmt.setString(16, valueObject.getID_DEPTO()); 
               stmt.setString(17, valueObject.getVALORINFRACCION()); 
               stmt.setInt(18, valueObject.getID()); 
               stmt.setString(19, valueObject.getCOD_INFRACCION()); 
               stmt.setString(20, valueObject.getNUEVO_CODIGO()); 

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
    public void save(Connection conn, ViewResFaltantesCarga valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE VIEW_RES_FALTANTES_CARGA SET FECHA = ?, CODTIPORESOLUCION = ?, NUMEROCOMPARENDO = ?, "
               + "ID_COMPARENDO = ?, FECHACOMPARENDO = ?, POLCA = ?, "
               + "VALORALCOLEMIA = ?, NROIDENTIFICACION = ?, ID_DOCTO = ?, "
               + "NOMBRES = ?, APELLIDOS = ?, DIRECCION = ?, "
               + "TELEFONO = ?, CODCIUDAD = ?, ID_DEPTO = ?, "
               + "VALORINFRACCION = ?, ID = ?, COD_INFRACCION = ?, "
               + "NUEVO_CODIGO = ? WHERE (NUMERO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getFECHA()); 
              stmt.setString(2, valueObject.getCODTIPORESOLUCION()); 
              stmt.setString(3, valueObject.getNUMEROCOMPARENDO()); 
              stmt.setInt(4, valueObject.getID_COMPARENDO()); 
              stmt.setString(5, valueObject.getFECHACOMPARENDO()); 
              stmt.setString(6, valueObject.getPOLCA()); 
              stmt.setString(7, valueObject.getVALORALCOLEMIA()); 
              stmt.setString(8, valueObject.getNROIDENTIFICACION()); 
              stmt.setString(9, valueObject.getID_DOCTO()); 
              stmt.setString(10, valueObject.getNOMBRES()); 
              stmt.setString(11, valueObject.getAPELLIDOS()); 
              stmt.setString(12, valueObject.getDIRECCION()); 
              stmt.setString(13, valueObject.getTELEFONO()); 
              stmt.setString(14, valueObject.getCODCIUDAD()); 
              stmt.setString(15, valueObject.getID_DEPTO()); 
              stmt.setString(16, valueObject.getVALORINFRACCION()); 
              stmt.setInt(17, valueObject.getID()); 
              stmt.setString(18, valueObject.getCOD_INFRACCION()); 
              stmt.setString(19, valueObject.getNUEVO_CODIGO()); 

              stmt.setString(20, valueObject.getNUMERO()); 

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
    public void delete(Connection conn, ViewResFaltantesCarga valueObject) 
          throws NotFoundException, SQLException {

          if (valueObject.getNUMERO() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new NotFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM VIEW_RES_FALTANTES_CARGA WHERE (NUMERO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getNUMERO()); 

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

          String sql = "DELETE FROM VIEW_RES_FALTANTES_CARGA";
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

          String sql = "SELECT count(*) FROM VIEW_RES_FALTANTES_CARGA";
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
    public List searchMatching(Connection conn, ViewResFaltantesCarga valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_RES_FALTANTES_CARGA WHERE 1=1 ");

          if (valueObject.getNUMERO() != null) {
              if (first) { first = false; }
              sql.append("AND NUMERO = '").append(valueObject.getNUMERO()).append("' ");
          }

          if (valueObject.getFECHA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHA = '").append(valueObject.getFECHA()).append("' ");
          }

          if (valueObject.getCODTIPORESOLUCION() != null) {
              if (first) { first = false; }
              sql.append("AND CODTIPORESOLUCION = '").append(valueObject.getCODTIPORESOLUCION()).append("' ");
          }

          if (valueObject.getNUMEROCOMPARENDO() != null) {
              if (first) { first = false; }
              sql.append("AND NUMEROCOMPARENDO = '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
          }

          if (valueObject.getID_COMPARENDO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_COMPARENDO = ").append(valueObject.getID_COMPARENDO()).append(" ");
          }

          if (valueObject.getFECHACOMPARENDO() != null) {
              if (first) { first = false; }
              sql.append("AND FECHACOMPARENDO = '").append(valueObject.getFECHACOMPARENDO()).append("' ");
          }

          if (valueObject.getPOLCA() != null) {
              if (first) { first = false; }
              sql.append("AND POLCA = '").append(valueObject.getPOLCA()).append("' ");
          }

          if (valueObject.getVALORALCOLEMIA() != null) {
              if (first) { first = false; }
              sql.append("AND VALORALCOLEMIA = '").append(valueObject.getVALORALCOLEMIA()).append("' ");
          }

          if (valueObject.getNROIDENTIFICACION() != null) {
              if (first) { first = false; }
              sql.append("AND NROIDENTIFICACION = '").append(valueObject.getNROIDENTIFICACION()).append("' ");
          }

          if (valueObject.getID_DOCTO() != null) {
              if (first) { first = false; }
              sql.append("AND ID_DOCTO = '").append(valueObject.getID_DOCTO()).append("' ");
          }

          if (valueObject.getNOMBRES() != null) {
              if (first) { first = false; }
              sql.append("AND NOMBRES = '").append(valueObject.getNOMBRES()).append("' ");
          }

          if (valueObject.getAPELLIDOS() != null) {
              if (first) { first = false; }
              sql.append("AND APELLIDOS = '").append(valueObject.getAPELLIDOS()).append("' ");
          }

          if (valueObject.getDIRECCION() != null) {
              if (first) { first = false; }
              sql.append("AND DIRECCION = '").append(valueObject.getDIRECCION()).append("' ");
          }

          if (valueObject.getTELEFONO() != null) {
              if (first) { first = false; }
              sql.append("AND TELEFONO = '").append(valueObject.getTELEFONO()).append("' ");
          }

          if (valueObject.getCODCIUDAD() != null) {
              if (first) { first = false; }
              sql.append("AND CODCIUDAD = '").append(valueObject.getCODCIUDAD()).append("' ");
          }

          if (valueObject.getID_DEPTO() != null) {
              if (first) { first = false; }
              sql.append("AND ID_DEPTO = '").append(valueObject.getID_DEPTO()).append("' ");
          }

          if (valueObject.getVALORINFRACCION() != null) {
              if (first) { first = false; }
              sql.append("AND VALORINFRACCION = '").append(valueObject.getVALORINFRACCION()).append("' ");
          }

          if (valueObject.getID() != 0) {
              if (first) { first = false; }
              sql.append("AND ID = ").append(valueObject.getID()).append(" ");
          }

          if (valueObject.getCOD_INFRACCION() != null) {
              if (first) { first = false; }
              sql.append("AND COD_INFRACCION = '").append(valueObject.getCOD_INFRACCION()).append("' ");
          }

          if (valueObject.getNUEVO_CODIGO() != null) {
              if (first) { first = false; }
              sql.append("AND NUEVO_CODIGO = '").append(valueObject.getNUEVO_CODIGO()).append("' ");
          }
          
          if (valueObject.getNUEVO_CODIGOCORREGIDO() != null) {
              if (first) { first = false; }
              sql.append("AND NUEVO_CODIGOCORREGIDO = '").append(valueObject.getNUEVO_CODIGOCORREGIDO()).append("' ");
          }        
          
          if (valueObject.getIDREPORTECOMPARENDO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDREPORTECOMPARENDO = ").append(valueObject.getIDREPORTECOMPARENDO()).append(" ");
          }


          sql.append("ORDER BY NUMERO ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }


    public List searchMatching2(Connection conn, ViewResFaltantesCarga valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_RES_FALTANTES_CARGA WHERE 1=1 ");

          if (valueObject.getNUMERO() != null) {
              if (first) { first = false; }
              sql.append("AND NUMERO = '").append(valueObject.getNUMERO()).append("' ");
          }

          if (valueObject.getFECHA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHA = '").append(valueObject.getFECHA()).append("' ");
          }

          if (valueObject.getCODTIPORESOLUCION() != null) {
              if (first) { first = false; }
              sql.append("AND CODTIPORESOLUCION = '").append(valueObject.getCODTIPORESOLUCION()).append("' ");
          }

          if (valueObject.getNUMEROCOMPARENDO() != null) {
              if (first) { first = false; }
              sql.append("AND NUMEROCOMPARENDO = '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
          }

          if (valueObject.getID_COMPARENDO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_COMPARENDO = ").append(valueObject.getID_COMPARENDO()).append(" ");
          }

          if (valueObject.getFECHACOMPARENDO() != null) {
              if (first) { first = false; }
              sql.append("AND FECHACOMPARENDO = '").append(valueObject.getFECHACOMPARENDO()).append("' ");
          }

          if (valueObject.getPOLCA() != null) {
              if (first) { first = false; }
              sql.append("AND POLCA = '").append(valueObject.getPOLCA()).append("' ");
          }

          if (valueObject.getVALORALCOLEMIA() != null) {
              if (first) { first = false; }
              sql.append("AND VALORALCOLEMIA = '").append(valueObject.getVALORALCOLEMIA()).append("' ");
          }

          if (valueObject.getNROIDENTIFICACION() != null) {
              if (first) { first = false; }
              sql.append("AND NROIDENTIFICACION = '").append(valueObject.getNROIDENTIFICACION()).append("' ");
          }

          if (valueObject.getID_DOCTO() != null) {
              if (first) { first = false; }
              sql.append("AND ID_DOCTO = '").append(valueObject.getID_DOCTO()).append("' ");
          }

          if (valueObject.getNOMBRES() != null) {
              if (first) { first = false; }
              sql.append("AND NOMBRES = '").append(valueObject.getNOMBRES()).append("' ");
          }

          if (valueObject.getAPELLIDOS() != null) {
              if (first) { first = false; }
              sql.append("AND APELLIDOS = '").append(valueObject.getAPELLIDOS()).append("' ");
          }

          if (valueObject.getDIRECCION() != null) {
              if (first) { first = false; }
              sql.append("AND DIRECCION = '").append(valueObject.getDIRECCION()).append("' ");
          }

          if (valueObject.getTELEFONO() != null) {
              if (first) { first = false; }
              sql.append("AND TELEFONO = '").append(valueObject.getTELEFONO()).append("' ");
          }

          if (valueObject.getCODCIUDAD() != null) {
              if (first) { first = false; }
              sql.append("AND CODCIUDAD = '").append(valueObject.getCODCIUDAD()).append("' ");
          }

          if (valueObject.getID_DEPTO() != null) {
              if (first) { first = false; }
              sql.append("AND ID_DEPTO = '").append(valueObject.getID_DEPTO()).append("' ");
          }

          if (valueObject.getVALORINFRACCION() != null) {
              if (first) { first = false; }
              sql.append("AND VALORINFRACCION = '").append(valueObject.getVALORINFRACCION()).append("' ");
          }

          if (valueObject.getID() != 0) {
              if (first) { first = false; }
              sql.append("AND ID = ").append(valueObject.getID()).append(" ");
          }

          if (valueObject.getCOD_INFRACCION() != null) {
              if (first) { first = false; }
              sql.append("AND COD_INFRACCION <> '").append(valueObject.getCOD_INFRACCION()).append("' ");
          }

          if (valueObject.getNUEVO_CODIGO() != null) {
              if (first) { first = false; }
              sql.append("AND NUEVO_CODIGO <> '").append(valueObject.getNUEVO_CODIGO()).append("' ");
          }
          
          if (valueObject.getNUEVO_CODIGOCORREGIDO() != null) {
              if (first) { first = false; }
              sql.append("AND NUEVO_CODIGOCORREGIDO <> '").append(valueObject.getNUEVO_CODIGOCORREGIDO()).append("' ");
          }        
          
          if (valueObject.getIDREPORTECOMPARENDO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDREPORTECOMPARENDO = ").append(valueObject.getIDREPORTECOMPARENDO()).append(" ");
          }


          sql.append("ORDER BY NUMERO ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, ViewResFaltantesCarga valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setNUMERO(result.getString("NUMERO")); 
                   valueObject.setFECHA(result.getString("FECHA")); 
                   valueObject.setCODTIPORESOLUCION(result.getString("CODTIPORESOLUCION")); 
                   valueObject.setNUMEROCOMPARENDO(result.getString("NUMEROCOMPARENDO")); 
                   valueObject.setID_COMPARENDO(result.getInt("ID_COMPARENDO")); 
                   valueObject.setFECHACOMPARENDO(result.getString("FECHACOMPARENDO")); 
                   valueObject.setPOLCA(result.getString("POLCA")); 
                   valueObject.setVALORALCOLEMIA(result.getString("VALORALCOLEMIA")); 
                   valueObject.setNROIDENTIFICACION(result.getString("NROIDENTIFICACION")); 
                   valueObject.setID_DOCTO(result.getString("ID_DOCTO")); 
                   valueObject.setNOMBRES(result.getString("NOMBRES")); 
                   valueObject.setAPELLIDOS(result.getString("APELLIDOS")); 
                   valueObject.setDIRECCION(result.getString("DIRECCION")); 
                   valueObject.setTELEFONO(result.getString("TELEFONO")); 
                   valueObject.setCODCIUDAD(result.getString("CODCIUDAD")); 
                   valueObject.setID_DEPTO(result.getString("ID_DEPTO")); 
                   valueObject.setVALORINFRACCION(result.getString("VALORINFRACCION")); 
                   valueObject.setID(result.getInt("ID")); 
                   valueObject.setCOD_INFRACCION(result.getString("COD_INFRACCION")); 
                   valueObject.setNUEVO_CODIGO(result.getString("NUEVO_CODIGO")); 
                   valueObject.setNUEVO_CODIGOCORREGIDO(result.getString("NUEVO_CODIGOCORREGIDO")); 
                   valueObject.setIDREPORTECOMPARENDO(result.getInt("IDREPORTECOMPARENDO"));

              } else {
                    //System.out.println("ViewResFaltantesCarga Object Not Found!");
                    throw new NotFoundException("ViewResFaltantesCarga Object Not Found!");
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
                   ViewResFaltantesCarga temp = createValueObject();

                   temp.setNUMERO(result.getString("NUMERO")); 
                   temp.setFECHA(result.getString("FECHA")); 
                   temp.setCODTIPORESOLUCION(result.getString("CODTIPORESOLUCION")); 
                   temp.setNUMEROCOMPARENDO(result.getString("NUMEROCOMPARENDO")); 
                   temp.setID_COMPARENDO(result.getInt("ID_COMPARENDO")); 
                   temp.setFECHACOMPARENDO(result.getString("FECHACOMPARENDO")); 
                   temp.setPOLCA(result.getString("POLCA")); 
                   temp.setVALORALCOLEMIA(result.getString("VALORALCOLEMIA")); 
                   temp.setNROIDENTIFICACION(result.getString("NROIDENTIFICACION")); 
                   temp.setID_DOCTO(result.getString("ID_DOCTO")); 
                   temp.setNOMBRES(result.getString("NOMBRES")); 
                   temp.setAPELLIDOS(result.getString("APELLIDOS")); 
                   temp.setDIRECCION(result.getString("DIRECCION")); 
                   temp.setTELEFONO(result.getString("TELEFONO")); 
                   temp.setCODCIUDAD(result.getString("CODCIUDAD")); 
                   temp.setID_DEPTO(result.getString("ID_DEPTO")); 
                   temp.setVALORINFRACCION(result.getString("VALORINFRACCION")); 
                   temp.setID(result.getInt("ID")); 
                   temp.setCOD_INFRACCION(result.getString("COD_INFRACCION")); 
                   temp.setNUEVO_CODIGO(result.getString("NUEVO_CODIGO")); 
                   temp.setNUEVO_CODIGOCORREGIDO(result.getString("NUEVO_CODIGOCORREGIDO")); 
                   temp.setIDREPORTECOMPARENDO(result.getInt("IDREPORTECOMPARENDO"));

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
    
    public List getResFaltantesCargaPorFechas(Connection conn, ViewResFaltantesCarga valueObject, String fecha1, String fecha2) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_RES_FALTANTES_CARGA WHERE 1=1 ");

          if (first) { first = false; }
          sql.append("AND (FECHA BETWEEN '").append(Funciones.convFechaFormatoMotor(fecha1)).append("' AND '").append(Funciones.convFechaFormatoMotor(fecha2)).append("') ");          
          sql.append("ORDER BY FECHA ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }


}