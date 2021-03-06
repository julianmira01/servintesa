package modelo.datos.dao.comparendos.liquidacion.tarifas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.LiquidacionComp;

import utilidades.Funciones;


/**
  * LiquidacionComp Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve LiquidacionComp object instances.
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



public class LiquidacionCompDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public LiquidacionComp createValueObject() {
          return new LiquidacionComp();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public LiquidacionComp getObject(Connection conn, int IDLIQUIDACION) throws NotFoundException, SQLException {

          LiquidacionComp valueObject = createValueObject();
          valueObject.setIDLIQUIDACION(IDLIQUIDACION);
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
    public void load(Connection conn, LiquidacionComp valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM LIQUIDACION WHERE (IDLIQUIDACION = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getIDLIQUIDACION()); 

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

          String sql = "SELECT * FROM LIQUIDACION ORDER BY IDLIQUIDACION ASC ";
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
    public synchronized void create(Connection conn, LiquidacionComp valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO LIQUIDACION ( IDLIQUIDACION, TOTAL, FECHA, "
               + "SALDO, FECHAREGISTRO, HORAREGISTRO, "
               + "IDUSUARIO, ESTADOLIQ, NROCOMP, NUMERO_CERTIFICADO, FECHA_CERTIFICADO, ID_CENTRO) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getIDLIQUIDACION()); 
               stmt.setDouble(2, valueObject.getTOTAL()); 
              
            if (Funciones.esFecha(valueObject.getFECHA()))
                stmt.setDate(3, Funciones.convFechaSSQL(valueObject.getFECHA()));
            else
                stmt.setNull(3, Types.DATE);
              
               stmt.setDouble(4, valueObject.getSALDO()); 
               
            if (Funciones.esFecha(valueObject.getFECHAREGISTRO()))
                stmt.setDate(5, Funciones.convFechaSSQL(valueObject.getFECHAREGISTRO()));
            else
                stmt.setNull(5, Types.DATE);
               
               //stmt.setString(6, valueObject.getHORAREGISTRO());              
            if (Funciones.esTime(valueObject.getHORAREGISTRO()))
              stmt.setTime(6,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAREGISTRO())));
            else
              stmt.setNull(6, Types.TIME);
              
               stmt.setInt(7, valueObject.getIDUSUARIO()); 
               stmt.setString(8, valueObject.getESTADOLIQ()); 
               stmt.setString(9, valueObject.getNROCOMP()); 
               stmt.setString(10, valueObject.getNUMERO_CERTIFICADO());
               stmt.setString(11, valueObject.getFECHA_CERTIFICADO());
               stmt.setInt(12, valueObject.getID_CENTRO());

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
    public void save(Connection conn, LiquidacionComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE LIQUIDACION SET TOTAL = ?, FECHA = ?, SALDO = ?, "
               + "FECHAREGISTRO = ?, HORAREGISTRO = ?, IDUSUARIO = ?, "
               + "ESTADOLIQ = ?, NROCOMP = ?, NUMERO_CERTIFICADO = ?, FECHA_CERTIFICADO = ?, ID_CENTRO = ? WHERE (IDLIQUIDACION = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setDouble(1, valueObject.getTOTAL()); 
              
            if (Funciones.esFecha(valueObject.getFECHA()))
                stmt.setDate(2, Funciones.convFechaSSQL(valueObject.getFECHA()));
            else
                stmt.setNull(2, Types.DATE);
              
              stmt.setDouble(3, valueObject.getSALDO()); 
              
            if (Funciones.esFecha(valueObject.getFECHAREGISTRO()))
                stmt.setDate(4, Funciones.convFechaSSQL(valueObject.getFECHAREGISTRO()));
            else
                stmt.setNull(4, Types.DATE);
              
            if (Funciones.esTime(valueObject.getHORAREGISTRO()))
              stmt.setTime(5,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAREGISTRO())));
            else
              stmt.setNull(5, Types.TIME);
              
              stmt.setInt(6, valueObject.getIDUSUARIO()); 
              stmt.setString(7, valueObject.getESTADOLIQ()); 
              stmt.setString(8, valueObject.getNROCOMP()); 
              stmt.setString(9, valueObject.getNUMERO_CERTIFICADO());
              stmt.setString(10, valueObject.getFECHA_CERTIFICADO());
              stmt.setInt(11, valueObject.getID_CENTRO());
              
              stmt.setInt(12, valueObject.getIDLIQUIDACION()); 

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
    public void delete(Connection conn, LiquidacionComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM LIQUIDACION WHERE (IDLIQUIDACION = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getIDLIQUIDACION()); 

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

          String sql = "DELETE FROM LIQUIDACION";
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

          String sql = "SELECT count(*) FROM LIQUIDACION";
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
    public List searchMatching(Connection conn, LiquidacionComp valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM LIQUIDACION WHERE 1=1 ");

          if (valueObject.getIDLIQUIDACION() != 0) {
              if (first) { first = false; }
              sql.append("AND IDLIQUIDACION = ").append(valueObject.getIDLIQUIDACION()).append(" ");
          }

          if (valueObject.getTOTAL() != 0) {
              if (first) { first = false; }
              sql.append("AND TOTAL = ").append(valueObject.getTOTAL()).append(" ");
          }

          if (valueObject.getFECHA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHA = '").append(valueObject.getFECHA()).append("' ");
          }

          if (valueObject.getSALDO() != 0) {
              if (first) { first = false; }
              sql.append("AND SALDO = ").append(valueObject.getSALDO()).append(" ");
          }

          if (valueObject.getFECHAREGISTRO() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAREGISTRO = '").append(valueObject.getFECHAREGISTRO()).append("' ");
          }

          if (valueObject.getHORAREGISTRO() != null) {
              if (first) { first = false; }
              sql.append("AND HORAREGISTRO = '").append(valueObject.getHORAREGISTRO()).append("' ");
          }

          if (valueObject.getIDUSUARIO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDUSUARIO = ").append(valueObject.getIDUSUARIO()).append(" ");
          }

          if (valueObject.getESTADOLIQ() != null) {
              if (first) { first = false; }
              sql.append("AND ESTADOLIQ = '").append(valueObject.getESTADOLIQ()).append("' ");
          }

          if (valueObject.getNROCOMP() != null) {
              if (first) { first = false; }
              sql.append("AND NROCOMP = '").append(valueObject.getNROCOMP()).append("' ");
          }
          
        if (valueObject.getNUMERO_CERTIFICADO() != null) {
            if (first) { first = false; }
            sql.append("AND NUMERO_CERTIFICADO = ").append(valueObject.getNUMERO_CERTIFICADO()).append(" ");
        }

        if (valueObject.getFECHA_CERTIFICADO() != null) {
            if (first) { first = false; }
            sql.append("AND FECHA_CERTIFICADO LIKE '").append(valueObject.getFECHA_CERTIFICADO()).append("%' ");
        }

        if (valueObject.getID_CENTRO() != 0) {
            if (first) { first = false; }
            sql.append("AND ID_CENTRO = ").append(valueObject.getID_CENTRO()).append(" ");
        }


          sql.append("ORDER BY IDLIQUIDACION ASC ");
          System.out.println("sqlLiquidacion: " + sql);
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
    protected void singleQuery(Connection conn, PreparedStatement stmt, LiquidacionComp valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setIDLIQUIDACION(result.getInt("IDLIQUIDACION")); 
                   valueObject.setTOTAL(result.getFloat("TOTAL")); 
                   valueObject.setFECHA(result.getString("FECHA")); 
                   valueObject.setSALDO(result.getFloat("SALDO")); 
                   valueObject.setFECHAREGISTRO(result.getString("FECHAREGISTRO")); 
                   valueObject.setHORAREGISTRO(result.getString("HORAREGISTRO")); 
                   valueObject.setIDUSUARIO(result.getInt("IDUSUARIO")); 
                   valueObject.setESTADOLIQ(result.getString("ESTADOLIQ")); 
                   valueObject.setNROCOMP(result.getString("NROCOMP")); 
                   valueObject.setNUMERO_CERTIFICADO(result.getString("NUMERO_CERTIFICADO")); 
                   valueObject.setFECHA_CERTIFICADO(result.getString("FECHA_CERTIFICADO")); 
                   valueObject.setID_CENTRO(result.getInt("ID_CENTRO")); 
              } else {
                    //System.out.println("LiquidacionComp Object Not Found!");
                    throw new NotFoundException("LiquidacionComp Object Not Found!");
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
                   LiquidacionComp temp = createValueObject();

                   temp.setIDLIQUIDACION(result.getInt("IDLIQUIDACION")); 
                   temp.setTOTAL(result.getFloat("TOTAL")); 
                   temp.setFECHA(result.getString("FECHA")); 
                   temp.setSALDO(result.getFloat("SALDO")); 
                   temp.setFECHAREGISTRO(result.getString("FECHAREGISTRO")); 
                   temp.setHORAREGISTRO(result.getString("HORAREGISTRO")); 
                   temp.setIDUSUARIO(result.getInt("IDUSUARIO")); 
                   temp.setESTADOLIQ(result.getString("ESTADOLIQ")); 
                   temp.setNROCOMP(result.getString("NROCOMP")); 
                   temp.setNUMERO_CERTIFICADO(result.getString("NUMERO_CERTIFICADO")); 
                   temp.setFECHA_CERTIFICADO(result.getString("FECHA_CERTIFICADO"));
                   temp.setID_CENTRO(result.getInt(result.getInt("ID_CENTRO"))); 
                   
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
    
    public List buscarLiquiInfractor(Connection conn, String nro_doc,int tipo_doc) throws SQLException {
        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("select distinct liquidacion.idliquidacion, liquidacion.total, liquidacion.saldo, liquidacion.fecha " + 
        "from  liquidacion inner join datosliquidacion on (liquidacion.idliquidacion=datosliquidacion.idliquidacion) " + 
        "inner join infraccioncomparendo on (datosliquidacion.idinfraccion=infraccioncomparendo.id) " + 
        "inner join comparendo on (infraccioncomparendo.idcomparendo=comparendo.id_comparendo) " + 
        "inner join infractor on (comparendo.id_infractor=infractor.id_infractor ) " + 
        "where liquidacion.ESTADOLIQ='LIQUIDADO' and infractor.nroidentificacion= '" +nro_doc+"' and " + 
            "infractor.id_docto=" +tipo_doc+ " ");

        sql.append("ORDER BY liquidacion.fecha ASC ");
        // Prevent accidential full table results.
        // Use loadAll if all rows must be returned.
        System.out.println("busLiqui: " + sql);
        searchResults = listLiquid(conn, conn.prepareStatement(sql.toString()));

        return searchResults;
    }

    protected List listLiquid(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();
              while (result.next()) {
                   LiquidacionComp temp = new LiquidacionComp();
                   temp.setIDLIQUIDACION(result.getInt("IDLIQUIDACION")); 
                   temp.setTOTAL(result.getFloat("TOTAL")); 
                   temp.setFECHA(result.getString("FECHA")); 
                   temp.setSALDO(result.getFloat("SALDO")); 
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

