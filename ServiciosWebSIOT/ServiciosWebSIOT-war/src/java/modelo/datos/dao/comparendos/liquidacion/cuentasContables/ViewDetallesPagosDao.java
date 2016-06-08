package modelo.datos.dao.comparendos.liquidacion.cuentasContables;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.ViewDetallesPagos;

import utilidades.Funciones;


/**
  * ViewDetallesPagos Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve ViewDetallesPagos object instances.
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



public class ViewDetallesPagosDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public ViewDetallesPagos createValueObject() {
          return new ViewDetallesPagos();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public ViewDetallesPagos getObject(Connection conn, int IDCUENTACONTABLE) throws NotFoundException, SQLException {

          ViewDetallesPagos valueObject = createValueObject();
          valueObject.setIDCUENTACONTABLE(IDCUENTACONTABLE);
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
    public void load(Connection conn, ViewDetallesPagos valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM ViewDetallesPagos WHERE (IDCUENTACONTABLE = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getIDCUENTACONTABLE()); 

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

          String sql = "SELECT * FROM ViewDetallesPagos ORDER BY IDCUENTACONTABLE ASC ";
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
    public synchronized void create(Connection conn, ViewDetallesPagos valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO ViewDetallesPagos ( IDCUENTACONTABLE, DECOMPARENDO, CODIGOCUENTA, "
               + "NOMBRECUENTA, VIGENCIAINICIAL, VIGENCIAFINAL, "
               + "FILTROPORFECHAS, IDTARIFA, IDCONCEPTO, "
               + "NOMBRECONCEPTO, IDITEM, VALORPAGO, "
               + "FECHAPAGO, VIGENCIA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getIDCUENTACONTABLE()); 
               stmt.setString(2, valueObject.getDECOMPARENDO()); 
               stmt.setString(3, valueObject.getCODIGOCUENTA()); 
               stmt.setString(4, valueObject.getNOMBRECUENTA()); 
               stmt.setInt(5, valueObject.getVIGENCIAINICIAL()); 
               stmt.setInt(6, valueObject.getVIGENCIAFINAL()); 
               stmt.setString(7, valueObject.getFILTROPORFECHAS()); 
               stmt.setInt(8, valueObject.getIDTARIFA()); 
               stmt.setInt(9, valueObject.getIDCONCEPTO()); 
               stmt.setString(10, valueObject.getNOMBRECONCEPTO()); 
               stmt.setInt(11, valueObject.getIDITEM()); 
               stmt.setDouble(12, valueObject.getVALORPAGO()); 
               stmt.setString(13, valueObject.getFECHAPAGO()); 
               stmt.setInt(14, valueObject.getVIGENCIA()); 

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
    public void save(Connection conn, ViewDetallesPagos valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE ViewDetallesPagos SET DECOMPARENDO = ?, CODIGOCUENTA = ?, NOMBRECUENTA = ?, "
               + "VIGENCIAINICIAL = ?, VIGENCIAFINAL = ?, FILTROPORFECHAS = ?, "
               + "IDTARIFA = ?, IDCONCEPTO = ?, NOMBRECONCEPTO = ?, "
               + "IDITEM = ?, VALORPAGO = ?, FECHAPAGO = ?, "
               + "VIGENCIA = ? WHERE (IDCUENTACONTABLE = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getDECOMPARENDO()); 
              stmt.setString(2, valueObject.getCODIGOCUENTA()); 
              stmt.setString(3, valueObject.getNOMBRECUENTA()); 
              stmt.setInt(4, valueObject.getVIGENCIAINICIAL()); 
              stmt.setInt(5, valueObject.getVIGENCIAFINAL()); 
              stmt.setString(6, valueObject.getFILTROPORFECHAS()); 
              stmt.setInt(7, valueObject.getIDTARIFA()); 
              stmt.setInt(8, valueObject.getIDCONCEPTO()); 
              stmt.setString(9, valueObject.getNOMBRECONCEPTO()); 
              stmt.setInt(10, valueObject.getIDITEM()); 
              stmt.setDouble(11, valueObject.getVALORPAGO()); 
              stmt.setString(12, valueObject.getFECHAPAGO()); 
              stmt.setInt(13, valueObject.getVIGENCIA()); 

              stmt.setInt(14, valueObject.getIDCUENTACONTABLE()); 

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
    public void delete(Connection conn, ViewDetallesPagos valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM ViewDetallesPagos WHERE (IDCUENTACONTABLE = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getIDCUENTACONTABLE()); 

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

          String sql = "DELETE FROM ViewDetallesPagos";
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

          String sql = "SELECT count(*) FROM ViewDetallesPagos";
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
    public List searchMatching(Connection conn, ViewDetallesPagos valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM ViewDetallesPagos WHERE 1=1 ");

          if (valueObject.getIDCUENTACONTABLE() != 0) {
              if (first) { first = false; }
              sql.append("AND IDCUENTACONTABLE = ").append(valueObject.getIDCUENTACONTABLE()).append(" ");
          }

          if (valueObject.getDECOMPARENDO() != null) {
              if (first) { first = false; }
              sql.append("AND DECOMPARENDO LIKE '").append(valueObject.getDECOMPARENDO()).append("%' ");
          }

          if (valueObject.getCODIGOCUENTA() != null) {
              if (first) { first = false; }
              sql.append("AND CODIGOCUENTA LIKE '").append(valueObject.getCODIGOCUENTA()).append("%' ");
          }

          if (valueObject.getNOMBRECUENTA() != null) {
              if (first) { first = false; }
              sql.append("AND NOMBRECUENTA LIKE '").append(valueObject.getNOMBRECUENTA()).append("%' ");
          }

          if (valueObject.getVIGENCIAINICIAL() != 0) {
              if (first) { first = false; }
              sql.append("AND VIGENCIAINICIAL = ").append(valueObject.getVIGENCIAINICIAL()).append(" ");
          }

          if (valueObject.getVIGENCIAFINAL() != 0) {
              if (first) { first = false; }
              sql.append("AND VIGENCIAFINAL = ").append(valueObject.getVIGENCIAFINAL()).append(" ");
          }

          if (valueObject.getFILTROPORFECHAS() != null) {
              if (first) { first = false; }
              sql.append("AND FILTROPORFECHAS LIKE '").append(valueObject.getFILTROPORFECHAS()).append("%' ");
          }

          if (valueObject.getIDTARIFA() != 0) {
              if (first) { first = false; }
              sql.append("AND IDTARIFA = ").append(valueObject.getIDTARIFA()).append(" ");
          }

          if (valueObject.getIDCONCEPTO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDCONCEPTO = ").append(valueObject.getIDCONCEPTO()).append(" ");
          }

          if (valueObject.getNOMBRECONCEPTO() != null) {
              if (first) { first = false; }
              sql.append("AND NOMBRECONCEPTO LIKE '").append(valueObject.getNOMBRECONCEPTO()).append("%' ");
          }

          if (valueObject.getIDITEM() != 0) {
              if (first) { first = false; }
              sql.append("AND IDITEM = ").append(valueObject.getIDITEM()).append(" ");
          }

          if (valueObject.getVALORPAGO() != 0) {
              if (first) { first = false; }
              sql.append("AND VALORPAGO = ").append(valueObject.getVALORPAGO()).append(" ");
          }

          if (valueObject.getFECHAPAGO() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAPAGO LIKE '").append(valueObject.getFECHAPAGO()).append("%' ");
          }

          if (valueObject.getVIGENCIA() != 0) {
              if (first) { first = false; }
              sql.append("AND VIGENCIA = ").append(valueObject.getVIGENCIA()).append(" ");
          }


          sql.append("ORDER BY IDCUENTACONTABLE ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, ViewDetallesPagos valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setIDCUENTACONTABLE(result.getInt("IDCUENTACONTABLE")); 
                   valueObject.setDECOMPARENDO(result.getString("DECOMPARENDO")); 
                   valueObject.setCODIGOCUENTA(result.getString("CODIGOCUENTA")); 
                   valueObject.setNOMBRECUENTA(result.getString("NOMBRECUENTA")); 
                   valueObject.setVIGENCIAINICIAL(result.getInt("VIGENCIAINICIAL")); 
                   valueObject.setVIGENCIAFINAL(result.getInt("VIGENCIAFINAL")); 
                   valueObject.setFILTROPORFECHAS(result.getString("FILTROPORFECHAS")); 
                   valueObject.setIDTARIFA(result.getInt("IDTARIFA")); 
                   valueObject.setIDCONCEPTO(result.getInt("IDCONCEPTO")); 
                   valueObject.setNOMBRECONCEPTO(result.getString("NOMBRECONCEPTO")); 
                   valueObject.setIDITEM(result.getInt("IDITEM")); 
                   valueObject.setVALORPAGO(result.getDouble("VALORPAGO")); 
                   valueObject.setFECHAPAGO(result.getString("FECHAPAGO")); 
                   valueObject.setVIGENCIA(result.getInt("VIGENCIA")); 

              } else {
                    //System.out.println("ViewDetallesPagos Object Not Found!");
                    throw new NotFoundException("ViewDetallesPagos Object Not Found!");
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
                   ViewDetallesPagos temp = createValueObject();

                   temp.setIDCUENTACONTABLE(result.getInt("IDCUENTACONTABLE")); 
                   //temp.setDECOMPARENDO(result.getString("DECOMPARENDO")); 
                   temp.setCODIGOCUENTA(result.getString("CODIGOCUENTA")); 
                   temp.setNOMBRECUENTA(result.getString("NOMBRECUENTA")); 
                   temp.setVIGENCIAINICIAL(result.getInt("VIGENCIAINICIAL")); 
                   temp.setVIGENCIAFINAL(result.getInt("VIGENCIAFINAL")); 
                   //temp.setFILTROPORFECHAS(result.getString("FILTROPORFECHAS")); 
                   //temp.setIDTARIFA(result.getInt("IDTARIFA")); 
                   //temp.setIDCONCEPTO(result.getInt("IDCONCEPTO")); 
                   //temp.setNOMBRECONCEPTO(result.getString("NOMBRECONCEPTO")); 
                   //temp.setIDITEM(result.getInt("IDITEM")); 
                   temp.setVALORPAGO(result.getDouble("VALORPAGO")); 
                   //temp.setFECHAPAGO(result.getString("FECHAPAGO")); 
                   //temp.setVIGENCIA(result.getInt("VIGENCIA")); 

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

    public List getTotalesporCuenta(Connection conn) throws SQLException 
    {  
          //String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, (SELECT SUM(VALORPAGO) FROM VIEW_DETALLES_PAGOS WHERE IDCUENTACONTABLE=VDP.IDCUENTACONTABLE) AS VALORPAGO FROM VIEW_DETALLES_PAGOS VDP GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA ORDER BY VDP.CODIGOCUENTA ASC";
        String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, SUM(VALORPAGO) AS VALORPAGO\n" + 
        "FROM VIEW_DETALLES_PAGOS VDP\n" + 
        "GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA\n" + 
        "ORDER BY VDP.CODIGOCUENTA ASC\n";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));
          return searchResults;
    }

    public List TotalesCuentasFechas(Connection conn, String fechai, String fechaf) throws SQLException 
    { 
          Date fechaini,fechafin;
          fechaini=Funciones.convFechaSSQL(fechai);
          fechafin=Funciones.convFechaSSQL(fechaf);
                    
          //String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL, (SELECT SUM(VALORPAGO) FROM VIEW_DETALLES_PAGOS WHERE IDCUENTACONTABLE=VDP.IDCUENTACONTABLE AND FECHAPAGO BETWEEN '"+fechaini+"' AND '"+fechafin+"') AS VALORPAGO FROM VIEW_DETALLES_PAGOS VDP WHERE FILTROPORFECHAS='T' GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL ORDER BY VDP.CODIGOCUENTA ASC";
          String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA,\n" + 
          "VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL, SUM(VALORPAGO) AS VALORPAGO\n" + 
          "FROM VIEW_DETALLES_PAGOS VDP\n" + 
          "WHERE FILTROPORFECHAS='T'\n" + 
          "AND FECHAPAGO BETWEEN '" + fechaini + "' AND '" + fechafin + "'\n" + 
          "GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL\n" + 
          "ORDER BY VDP.CODIGOCUENTA ASC";
          
          List searchResults = listQuery(conn, conn.prepareStatement(sql));
          return searchResults;
    }
    
    
    public List TotalesCuentasFechasTarifas(Connection conn, String fechai, String fechaf) throws SQLException 
    { 
          PreparedStatement stmt;
          Funciones funciones = new Funciones();
                    
          //String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL, (SELECT SUM(VALORPAGO) FROM VIEW_DETALLES_PAGOS WHERE IDCUENTACONTABLE=VDP.IDCUENTACONTABLE AND FECHAPAGO BETWEEN '"+fechaini+"' AND '"+fechafin+"') AS VALORPAGO FROM VIEW_DETALLES_PAGOS VDP WHERE FILTROPORFECHAS='T' GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL ORDER BY VDP.CODIGOCUENTA ASC";
          /*
          String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA,\n" + 
          "VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL, SUM(VALORPAGO) AS VALORPAGO\n" + 
          "FROM VIEW_DETALLES_PAGOS_TARIFAS VDP\n" + 
          "WHERE FILTROPORFECHAS='T'\n" + 
          "AND FECHAPAGO BETWEEN '" + fechaini + "' AND '" + fechafin + "'\n" + 
          "GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL\n" + 
          "ORDER BY VDP.CODIGOCUENTA ASC";
            */
          String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, " + 
          "VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL, SUM(VALORPAGO) AS VALORPAGO " + 
          "FROM VIEW_DETALLES_PAGOS_TARIFAS VDP  " + 
          "WHERE FILTROPORFECHAS='T' " + 
          "AND FECHAPAGO BETWEEN ? AND ? " + 
          "GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL " + 
          "ORDER BY VDP.CODIGOCUENTA ASC";
                 
          stmt = conn.prepareStatement(sql);
           
          if(funciones.esFecha(fechai)){
            stmt.setDate(1, funciones.convFechaSSQL(fechai));         
          }
                               
          if(funciones.esFecha(fechaf))
            stmt.setDate(2, funciones.convFechaSSQL(fechaf));
          
          List searchResults = listQuery(conn, stmt);
          
          return searchResults;
    }
        
    public List TotalesCuentasVigencias(Connection conn) throws SQLException 
    {           
          //String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL, (SELECT SUM(VALORPAGO) FROM VIEW_DETALLES_PAGOS WHERE IDCUENTACONTABLE=VDP.IDCUENTACONTABLE AND VIGENCIA BETWEEN VDP.VIGENCIAINICIAL AND VDP.VIGENCIAFINAL) AS VALORPAGO FROM VIEW_DETALLES_PAGOS VDP WHERE FILTROPORFECHAS='F' GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL ORDER BY VDP.CODIGOCUENTA ASC";
        String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA,\n" + 
        "VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL, SUM(VALORPAGO) AS VALORPAGO\n" + 
        "FROM VIEW_DETALLES_PAGOS VDP\n" + 
        "WHERE FILTROPORFECHAS='F'\n" + 
        "AND VIGENCIA BETWEEN VDP.VIGENCIAINICIAL AND VDP.VIGENCIAFINAL\n" + 
        "GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA,\n" + 
        "VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL\n" + 
        "ORDER BY VDP.CODIGOCUENTA ASC";
          
          List searchResults = listQuery(conn, conn.prepareStatement(sql));
          return searchResults;
    }
    
    public List TotalesCuentasVigenciasTarifas(Connection conn) throws SQLException 
    {           
          //String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL, (SELECT SUM(VALORPAGO) FROM VIEW_DETALLES_PAGOS WHERE IDCUENTACONTABLE=VDP.IDCUENTACONTABLE AND VIGENCIA BETWEEN VDP.VIGENCIAINICIAL AND VDP.VIGENCIAFINAL) AS VALORPAGO FROM VIEW_DETALLES_PAGOS VDP WHERE FILTROPORFECHAS='F' GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA, VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL ORDER BY VDP.CODIGOCUENTA ASC";
        String sql = "SELECT DISTINCT VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA,\n" + 
        "VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL, SUM(VALORPAGO) AS VALORPAGO\n" + 
        "FROM VIEW_DETALLES_PAGOS_TARIFAS VDP\n" + 
        "WHERE FILTROPORFECHAS='F'\n" + 
        "AND VIGENCIA BETWEEN VDP.VIGENCIAINICIAL AND VDP.VIGENCIAFINAL\n" + 
        "GROUP BY VDP.IDCUENTACONTABLE, VDP.CODIGOCUENTA, VDP.NOMBRECUENTA,\n" + 
        "VDP.VIGENCIAINICIAL, VDP.VIGENCIAFINAL\n" + 
        "ORDER BY VDP.CODIGOCUENTA ASC";
          
          List searchResults = listQuery(conn, conn.prepareStatement(sql));
          return searchResults;
    }
    

    public List TotalesConceptoFechas(Connection conn, String fechai, String fechaf) throws SQLException 
    { 
          Date fechaini,fechafin;
          fechaini=Funciones.convFechaSSQL(fechai);
          fechafin=Funciones.convFechaSSQL(fechaf);
          
          //String sql = "SELECT DISTINCT VDP.IDCONCEPTO, VDP.NOMBRECONCEPTO, (SELECT SUM(VALORPAGO) FROM VIEW_DETALLES_PAGOS WHERE IDCONCEPTO=VDP.IDCONCEPTO AND FECHAPAGO BETWEEN '"+fechaini+"' AND '"+fechafin+"') AS VALORPAGO FROM VIEW_DETALLES_PAGOS VDP";
          String sql = "SELECT DISTINCT VDP.IDCONCEPTO, VDP.NOMBRECONCEPTO, SUM(VALORPAGO) AS VALORPAGO\n" + 
          "FROM VIEW_DETALLES_PAGOS VDP\n" + 
          "WHERE FECHAPAGO BETWEEN '" + fechaini + "' AND '" + fechafin + "'\n" + 
          "GROUP BY VDP.IDCONCEPTO, VDP.NOMBRECONCEPTO";
          
          System.out.println("CONCEPTOS POR FECHAS = "+sql);
          
          List searchResults = listQuery(conn, conn.prepareStatement(sql));
          return searchResults;
    }

}
