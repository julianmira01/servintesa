package modelo.datos.dao.comparendos.liquidacion;


import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.liquidacion.AcuerdosPagoComp;

import utilidades.Funciones;


/**
  * AcuerdosPagoComp Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve AcuerdosPagoComp object instances.
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



public class AcuerdosPagoCompDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public AcuerdosPagoComp createValueObject() {
          return new AcuerdosPagoComp();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public AcuerdosPagoComp getObject(Connection conn, int ID) throws NotFoundException, SQLException {

          AcuerdosPagoComp valueObject = createValueObject();
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
    public void load(Connection conn, AcuerdosPagoComp valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM ACUERDOSPAGO WHERE (ID = ? ) "; 
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

          String sql = "SELECT * FROM ACUERDOSPAGO ORDER BY ID ASC ";
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
    public synchronized void create(Connection conn, AcuerdosPagoComp valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO ACUERDOSPAGO ( ID, NUMERO, DESCRIPCION, "
               + "IDLIQUIDACION, CONCEPTO, FECHA, "
               + "FECHAREGISTRO, HORAREGISTRO, CODEUDOR, "
               + "DOCUMENTOCODEUDOR, NOTA, CONTENIDO, "
               + "TIENERESOLUCION, ID_USUARIO, INTERESFINANCIACION, "
               + "NROCOMP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);
              
              stmt.setInt(1, valueObject.getID()); 
              if(Funciones.contarCadena(valueObject.getNUMERO(), 11))
                stmt.setString(2, valueObject.getNUMERO()); 
              else
                stmt.setNull(2, Types.VARCHAR);
              if(Funciones.contarCadena(valueObject.getDESCRIPCION(), 200))
                stmt.setString(3, valueObject.getDESCRIPCION()); 
              else
                stmt.setNull(3, Types.VARCHAR);
              if(!Funciones.EnteroesNulo(valueObject.getIDLIQUIDACION()))
               stmt.setInt(4, valueObject.getIDLIQUIDACION()); 
              else
               stmt.setNull(4, Types.INTEGER);
              if(Funciones.contarCadena(valueObject.getCONCEPTO(), 40))
                stmt.setString(5, valueObject.getCONCEPTO()); 
              else
                stmt.setNull(5, Types.VARCHAR);
              if(Funciones.esFecha(valueObject.getFECHA()))
                stmt.setDate(6, Funciones.convFechaSSQL(valueObject.getFECHA())); 
              else
                stmt.setNull(6,Types.DATE);
              if(Funciones.esFecha(valueObject.getFECHAREGISTRO()))
                stmt.setDate(7, Funciones.convFechaSSQL(valueObject.getFECHAREGISTRO())); 
              else
                stmt.setNull(7,Types.DATE);
              
              if(Funciones.esTime(valueObject.getHORAREGISTRO()))
                stmt.setTime(8, Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAREGISTRO())));
              else 
                stmt.setNull(8, Types.TIME);                        
              
              if(Funciones.contarCadena(valueObject.getCODEUDOR(), 60))
                stmt.setString(9, valueObject.getCODEUDOR()); 
              else
                stmt.setNull(9, Types.VARCHAR);
              if(Funciones.contarCadena(valueObject.getDOCUMENTOCODEUDOR(), 20))
                stmt.setString(10, valueObject.getDOCUMENTOCODEUDOR()); 
              else
                stmt.setNull(10, Types.VARCHAR);
              if(Funciones.contarCadena(valueObject.getNOTA(), 200))
                stmt.setString(11, valueObject.getNOTA()); 
              else
                stmt.setNull(11, Types.VARCHAR);
              if(Funciones.contarCadena(valueObject.getCONTENIDO(), 1000))
                stmt.setString(12, valueObject.getCONTENIDO()); 
              else
                stmt.setNull(12, Types.VARCHAR);
              if(Funciones.contarCadena(valueObject.getTIENERESOLUCION(), 1))
                stmt.setString(13, valueObject.getTIENERESOLUCION()); 
              else
                stmt.setNull(13, Types.VARCHAR);
              if(!Funciones.EnteroesNulo(valueObject.getID_USUARIO()))
               stmt.setInt(14, valueObject.getID_USUARIO()); 
              else
               stmt.setNull(14, Types.INTEGER);
              if(Funciones.FloatEsNulo(valueObject.getINTERESFINANCIACION()))
               stmt.setFloat(15, valueObject.getINTERESFINANCIACION()); 
              else
               stmt.setNull(15, Types.FLOAT);
              if(Funciones.contarCadena(valueObject.getNROCOMP(), 500))
                stmt.setString(16, valueObject.getNROCOMP()); 
              else
                stmt.setNull(16, Types.VARCHAR);

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
    public void save(Connection conn, AcuerdosPagoComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE ACUERDOSPAGO SET NUMERO = ?, DESCRIPCION = ?, IDLIQUIDACION = ?, "
               + "CONCEPTO = ?, FECHA = ?, FECHAREGISTRO = ?, "
               + "HORAREGISTRO = ?, CODEUDOR = ?, DOCUMENTOCODEUDOR = ?, "
               + "NOTA = ?, CONTENIDO = ?, TIENERESOLUCION = ?, "
               + "ID_USUARIO = ?, INTERESFINANCIACION = ?, NROCOMP = ? WHERE (ID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getNUMERO()); 
              stmt.setString(2, valueObject.getDESCRIPCION()); 
              stmt.setInt(3, valueObject.getIDLIQUIDACION()); 
              stmt.setString(4, valueObject.getCONCEPTO()); 
              
              
            if (Funciones.esFecha(valueObject.getFECHA()))
                stmt.setDate(5, Funciones.convFechaSSQL(valueObject.getFECHA()));
            else
                stmt.setNull(5, Types.DATE);
              
              
            if (Funciones.esFecha(valueObject.getFECHAREGISTRO()))
                stmt.setDate(6, Funciones.convFechaSSQL(valueObject.getFECHAREGISTRO()));
            else
                stmt.setNull(6, Types.DATE);
              
              //stmt.setString(7, valueObject.getHORAREGISTRO());               
              if (Funciones.esTime(valueObject.getHORAREGISTRO()))
              stmt.setTime(7,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAREGISTRO())));
              else
              stmt.setNull(7, Types.TIME);
              
              stmt.setString(8, valueObject.getCODEUDOR()); 
              stmt.setString(9, valueObject.getDOCUMENTOCODEUDOR()); 
              stmt.setString(10, valueObject.getNOTA()); 
              stmt.setString(11, valueObject.getCONTENIDO()); 
              stmt.setString(12, valueObject.getTIENERESOLUCION()); 
              stmt.setInt(13, valueObject.getID_USUARIO()); 
              stmt.setDouble(14, valueObject.getINTERESFINANCIACION()); 
              stmt.setString(15, valueObject.getNROCOMP()); 

              stmt.setInt(16, valueObject.getID()); 

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
    public void delete(Connection conn, AcuerdosPagoComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM ACUERDOSPAGO WHERE (ID = ? ) ";
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

          String sql = "DELETE FROM ACUERDOSPAGO";
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

          String sql = "SELECT count(*) FROM ACUERDOSPAGO";
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
    public List searchMatching(Connection conn, AcuerdosPagoComp valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM ACUERDOSPAGO WHERE 1=1 ");

          if (valueObject.getID() != 0) {
              if (first) { first = false; }
              sql.append("AND ID = ").append(valueObject.getID()).append(" ");
          }

          if (valueObject.getNUMERO() != null) {
              if (first) { first = false; }
              sql.append("AND NUMERO = '").append(valueObject.getNUMERO()).append("' ");
          }

          if (valueObject.getDESCRIPCION() != null) {
              if (first) { first = false; }
              sql.append("AND DESCRIPCION = '").append(valueObject.getDESCRIPCION()).append("' ");
          }

          if (valueObject.getIDLIQUIDACION() != 0) {
              if (first) { first = false; }
              sql.append("AND IDLIQUIDACION = ").append(valueObject.getIDLIQUIDACION()).append(" ");
          }

          if (valueObject.getCONCEPTO() != null) {
              if (first) { first = false; }
              sql.append("AND CONCEPTO = '").append(valueObject.getCONCEPTO()).append("' ");
          }

          if (valueObject.getFECHA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHA = '").append(valueObject.getFECHA()).append("' ");
          }

          if (valueObject.getFECHAREGISTRO() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAREGISTRO = '").append(valueObject.getFECHAREGISTRO()).append("' ");
          }

          if (valueObject.getHORAREGISTRO() != null) {
              if (first) { first = false; }
              sql.append("AND HORAREGISTRO = '").append(valueObject.getHORAREGISTRO()).append("' ");
          }

          if (valueObject.getCODEUDOR() != null) {
              if (first) { first = false; }
              sql.append("AND CODEUDOR = '").append(valueObject.getCODEUDOR()).append("' ");
          }

          if (valueObject.getDOCUMENTOCODEUDOR() != null) {
              if (first) { first = false; }
              sql.append("AND DOCUMENTOCODEUDOR = '").append(valueObject.getDOCUMENTOCODEUDOR()).append("' ");
          }

          if (valueObject.getNOTA() != null) {
              if (first) { first = false; }
              sql.append("AND NOTA = '").append(valueObject.getNOTA()).append("' ");
          }

          if (valueObject.getCONTENIDO() != null) {
              if (first) { first = false; }
              sql.append("AND CONTENIDO = '").append(valueObject.getCONTENIDO()).append("' ");
          }

          if (valueObject.getTIENERESOLUCION() != null) {
              if (first) { first = false; }
              sql.append("AND TIENERESOLUCION = '").append(valueObject.getTIENERESOLUCION()).append("%' ");
          }

          if (valueObject.getID_USUARIO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_USUARIO = ").append(valueObject.getID_USUARIO()).append(" ");
          }

          if (valueObject.getINTERESFINANCIACION() != 0) {
              if (first) { first = false; }
              sql.append("AND INTERESFINANCIACION = ").append(valueObject.getINTERESFINANCIACION()).append(" ");
          }

          if (valueObject.getNROCOMP() != null) {
              if (first) { first = false; }
              sql.append("AND NROCOMP = '").append(valueObject.getNROCOMP()).append("' ");
          }


          sql.append("ORDER BY ID ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, AcuerdosPagoComp valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setID(result.getInt("ID")); 
                   valueObject.setNUMERO(result.getString("NUMERO")); 
                   valueObject.setDESCRIPCION(result.getString("DESCRIPCION")); 
                   valueObject.setIDLIQUIDACION(result.getInt("IDLIQUIDACION")); 
                   valueObject.setCONCEPTO(result.getString("CONCEPTO")); 
                   valueObject.setFECHA(result.getString("FECHA")); 
                   valueObject.setFECHAREGISTRO(result.getString("FECHAREGISTRO")); 
                   valueObject.setHORAREGISTRO(result.getString("HORAREGISTRO")); 
                   valueObject.setCODEUDOR(result.getString("CODEUDOR")); 
                   valueObject.setDOCUMENTOCODEUDOR(result.getString("DOCUMENTOCODEUDOR")); 
                   valueObject.setNOTA(result.getString("NOTA")); 
                   valueObject.setCONTENIDO(result.getString("CONTENIDO")); 
                   valueObject.setTIENERESOLUCION(result.getString("TIENERESOLUCION")); 
                   valueObject.setID_USUARIO(result.getInt("ID_USUARIO")); 
                   valueObject.setINTERESFINANCIACION(result.getFloat("INTERESFINANCIACION")); 
                   valueObject.setNROCOMP(result.getString("NROCOMP")); 

              } else {
                    //System.out.println("AcuerdosPagoComp Object Not Found!");
                    throw new NotFoundException("AcuerdosPagoComp Object Not Found!");
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
                   AcuerdosPagoComp temp = createValueObject();

                   temp.setID(result.getInt("ID")); 
                   temp.setNUMERO(result.getString("NUMERO")); 
                   temp.setDESCRIPCION(result.getString("DESCRIPCION")); 
                   temp.setIDLIQUIDACION(result.getInt("IDLIQUIDACION")); 
                   temp.setCONCEPTO(result.getString("CONCEPTO")); 
                   temp.setFECHA(result.getString("FECHA")); 
                   temp.setFECHAREGISTRO(result.getString("FECHAREGISTRO")); 
                   temp.setHORAREGISTRO(result.getString("HORAREGISTRO")); 
                   temp.setCODEUDOR(result.getString("CODEUDOR")); 
                   temp.setDOCUMENTOCODEUDOR(result.getString("DOCUMENTOCODEUDOR")); 
                   temp.setNOTA(result.getString("NOTA")); 
                   temp.setCONTENIDO(result.getString("CONTENIDO")); 
                   temp.setTIENERESOLUCION(result.getString("TIENERESOLUCION")); 
                   temp.setID_USUARIO(result.getInt("ID_USUARIO")); 
                   temp.setINTERESFINANCIACION(result.getFloat("INTERESFINANCIACION")); 
                   temp.setNROCOMP(result.getString("NROCOMP")); 

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
    
    public List buscarAcuerdosInfractor(Connection conn, String nro_doc,int tipo_doc) throws SQLException {
        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("Select distinct acuerdospago.* " + 
        "from infractor inner join comparendo on (infractor.id_infractor=comparendo.id_infractor)\n" + 
        "inner join infraccioncomparendo on (comparendo.id_comparendo=infraccioncomparendo.idcomparendo)\n" + 
        "inner join datosliquidacion on (infraccioncomparendo.id=datosliquidacion.idinfraccion)\n" + 
        "inner join acuerdospago on (datosliquidacion.idliquidacion=acuerdospago.idliquidacion)\n" + 
        "where infractor.nroidentificacion = '"+nro_doc+ "' and infractor.id_docto = " +tipo_doc+ " ");
        sql.append("ORDER BY acuerdospago.numero ASC ");
        searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));
        return searchResults;
    }
}