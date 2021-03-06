package modelo.datos.dao.radicacion;

import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.radicacion.DetCita;

import utilidades.Funciones;


/**
  * DetCita Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve DetCita object instances.
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



public class DetCitaDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public DetCita createValueObject() {
          return new DetCita();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public DetCita getObject(Connection conn, int ID_DETCITA) throws NotFoundException, SQLException {

          DetCita valueObject = createValueObject();
          valueObject.setID_DETCITA(ID_DETCITA);
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
    public void load(Connection conn, DetCita valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM DETCITA WHERE (ID_DETCITA = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getID_DETCITA()); 

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

          String sql = "SELECT * FROM DETCITA ORDER BY ID_DETCITA ASC ";
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
    public synchronized void create(Connection conn, DetCita valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO DETCITA ( ID_DETCITA, ID_CITA, ID_PERSONA, "
               + "HORACITA, OBSERVACION, ID_USRASIGNA, "
               + "HORAASIGNA, FECHAASIGNA, ESTADO, "
               + "IDUSRTERMINA, FECHATERMINA, HORATERMINA, "
               + "NUMEROCITA, TIPO, PLACACEDULA, "
               + "IDTRAMITEINTERNO, CODTRAMITE, DESCTRAMITE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getID_DETCITA());
               if (!Funciones.EnteroesNulo(valueObject.getID_CITA()))
                  stmt.setInt(2, valueObject.getID_CITA());
               else
                  stmt.setNull(2, Types.INTEGER);
               if (!Funciones.EnteroesNulo(valueObject.getID_PERSONA()))
                  stmt.setInt(3, valueObject.getID_PERSONA());
               else
                  stmt.setNull(3, Types.INTEGER);
               if (Funciones.esTime(valueObject.getHORACITA()))
                  stmt.setTime(4,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORACITA())));
               else
                  stmt.setNull(4, Types.TIME);
               if (Funciones.contarCadena(valueObject.getOBSERVACION(), 500))
                  stmt.setString(5, valueObject.getOBSERVACION());
               else
                  stmt.setNull(5, Types.VARCHAR);
               if (!Funciones.EnteroesNulo(valueObject.getID_USRASIGNA()))
                  stmt.setInt(6, valueObject.getID_USRASIGNA());
               else
                  stmt.setNull(6, Types.INTEGER);
               if (Funciones.esTime(valueObject.getHORAASIGNA()))
                  stmt.setTime(7,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAASIGNA())));
               else
                  stmt.setNull(7, Types.TIME);
               if (Funciones.esFecha(valueObject.getFECHAASIGNA()))
                  stmt.setDate(8,Funciones.convFechaSSQL(valueObject.getFECHAASIGNA()));
               else
                  stmt.setNull(8, Types.DATE);
               if (Funciones.contarCadena(valueObject.getESTADO(), 5))
                  stmt.setString(9, valueObject.getESTADO());
               else
                  stmt.setNull(9, Types.VARCHAR);
               if (!Funciones.EnteroesNulo(valueObject.getIDUSRTERMINA()))
                  stmt.setInt(10, valueObject.getIDUSRTERMINA());
               else
                  stmt.setNull(10, Types.INTEGER);
               if (Funciones.esFecha(valueObject.getFECHATERMINA()))
                  stmt.setDate(11,Funciones.convFechaSSQL(valueObject.getFECHATERMINA()));
               else
                  stmt.setNull(11, Types.DATE);
               if (Funciones.esTime(valueObject.getHORATERMINA()))
                  stmt.setTime(12,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORATERMINA())));
               else
                  stmt.setNull(12, Types.TIME);
               if (!Funciones.EnteroesNulo(valueObject.getNUMEROCITA()))
                  stmt.setInt(13, valueObject.getNUMEROCITA());
               else
                  stmt.setNull(13, Types.INTEGER);
               if (Funciones.contarCadena(valueObject.getTIPO(), 3))
                  stmt.setString(14, valueObject.getTIPO());
               else
                  stmt.setNull(14, Types.VARCHAR);
               if (Funciones.contarCadena(valueObject.getPLACACEDULA(), 15))
                  stmt.setString(15, valueObject.getPLACACEDULA());
               else
                  stmt.setNull(15, Types.VARCHAR);
               if (!Funciones.EnteroesNulo(valueObject.getIDTRAMITEINTERNO()))
                  stmt.setInt(16, valueObject.getIDTRAMITEINTERNO());
               else
                  stmt.setNull(16, Types.INTEGER);
               if (Funciones.contarCadena(valueObject.getCODTRAMITE(), 10))
                  stmt.setString(17, valueObject.getCODTRAMITE());
               else
                  stmt.setNull(17, Types.VARCHAR);
               if (Funciones.contarCadena(valueObject.getDESCTRAMITE(), 150))
                  stmt.setString(18, valueObject.getDESCTRAMITE());
               else
                  stmt.setNull(18, Types.VARCHAR);

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
    public void save(Connection conn, DetCita valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE DETCITA SET ID_CITA = ?, ID_PERSONA = ?, HORACITA = ?, "
               + "OBSERVACION = ?, ID_USRASIGNA = ?, HORAASIGNA = ?, "
               + "FECHAASIGNA = ?, ESTADO = ?, IDUSRTERMINA = ?, "
               + "FECHATERMINA = ?, HORATERMINA = ?, NUMEROCITA = ?, "
               + "TIPO = ?, PLACACEDULA = ?, IDTRAMITEINTERNO = ?, "
               + "CODTRAMITE = ?, DESCTRAMITE = ? WHERE (ID_DETCITA = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID_CITA()); 
              stmt.setInt(2, valueObject.getID_PERSONA()); 
              
              //stmt.setString(3, valueObject.getHORACITA());               
            if (Funciones.esTime(valueObject.getHORACITA()))
               stmt.setTime(3,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORACITA())));
            else
               stmt.setNull(3, Types.TIME);
              
              stmt.setString(4, valueObject.getOBSERVACION()); 
              stmt.setInt(5, valueObject.getID_USRASIGNA()); 
              
              //stmt.setString(6, valueObject.getHORAASIGNA()); 
            if (Funciones.esTime(valueObject.getHORAASIGNA()))
               stmt.setTime(6,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAASIGNA())));
            else
               stmt.setNull(6, Types.TIME);
              
            if (Funciones.esFecha(valueObject.getFECHAASIGNA()))
              stmt.setDate(7, Funciones.convFechaSSQL(valueObject.getFECHAASIGNA()));
            else
              stmt.setNull(7, Types.DATE);
              
              stmt.setString(8, valueObject.getESTADO()); 
              stmt.setInt(9, valueObject.getIDUSRTERMINA()); 
              
            if (Funciones.esFecha(valueObject.getFECHATERMINA()))
              stmt.setDate(10, Funciones.convFechaSSQL(valueObject.getFECHATERMINA()));
            else
              stmt.setNull(10, Types.DATE);
              
              //stmt.setString(11, valueObject.getHORATERMINA()); 
            if (Funciones.esTime(valueObject.getHORATERMINA()))
               stmt.setTime(11,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORATERMINA())));
            else
               stmt.setNull(11, Types.TIME);
              
              stmt.setInt(12, valueObject.getNUMEROCITA()); 
              stmt.setString(13, valueObject.getTIPO()); 
              stmt.setString(14, valueObject.getPLACACEDULA()); 
              stmt.setInt(15, valueObject.getIDTRAMITEINTERNO()); 
              stmt.setString(16, valueObject.getCODTRAMITE()); 
              stmt.setString(17, valueObject.getDESCTRAMITE()); 

              stmt.setInt(18, valueObject.getID_DETCITA()); 

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
    public void delete(Connection conn, DetCita valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM DETCITA WHERE (ID_DETCITA = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID_DETCITA()); 

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

          String sql = "DELETE FROM DETCITA";
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

          String sql = "SELECT count(*) FROM DETCITA";
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
    public List searchMatching(Connection conn, DetCita valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM DETCITA WHERE 1=1 ");

          if (valueObject.getID_DETCITA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_DETCITA = ").append(valueObject.getID_DETCITA()).append(" ");
          }

          if (valueObject.getID_CITA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_CITA = ").append(valueObject.getID_CITA()).append(" ");
          }

          if (valueObject.getID_PERSONA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_PERSONA = ").append(valueObject.getID_PERSONA()).append(" ");
          }

          if (valueObject.getHORACITA() != null) {
              if (first) { first = false; }
              sql.append("AND HORACITA LIKE '").append(valueObject.getHORACITA()).append("%' ");
          }

          if (valueObject.getOBSERVACION() != null) {
              if (first) { first = false; }
              sql.append("AND OBSERVACION LIKE '").append(valueObject.getOBSERVACION()).append("%' ");
          }

          if (valueObject.getID_USRASIGNA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_USRASIGNA = ").append(valueObject.getID_USRASIGNA()).append(" ");
          }

          if (valueObject.getHORAASIGNA() != null) {
              if (first) { first = false; }
              sql.append("AND HORAASIGNA LIKE '").append(valueObject.getHORAASIGNA()).append("%' ");
          }

          if (valueObject.getFECHAASIGNA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAASIGNA LIKE '").append(valueObject.getFECHAASIGNA()).append("%' ");
          }

          if (valueObject.getESTADO() != null) {
              if (first) { first = false; }
              sql.append("AND ESTADO LIKE '").append(valueObject.getESTADO()).append("%' ");
          }

          if (valueObject.getIDUSRTERMINA() != 0) {
              if (first) { first = false; }
              sql.append("AND IDUSRTERMINA = ").append(valueObject.getIDUSRTERMINA()).append(" ");
          }

          if (valueObject.getFECHATERMINA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHATERMINA LIKE '").append(valueObject.getFECHATERMINA()).append("%' ");
          }

          if (valueObject.getHORATERMINA() != null) {
              if (first) { first = false; }
              sql.append("AND HORATERMINA LIKE '").append(valueObject.getHORATERMINA()).append("%' ");
          }

          if (valueObject.getNUMEROCITA() != 0) {
              if (first) { first = false; }
              sql.append("AND NUMEROCITA = ").append(valueObject.getNUMEROCITA()).append(" ");
          }

          if (valueObject.getTIPO() != null) {
              if (first) { first = false; }
              sql.append("AND TIPO LIKE '").append(valueObject.getTIPO()).append("%' ");
          }

          if (valueObject.getPLACACEDULA() != null) {
              if (first) { first = false; }
              sql.append("AND PLACACEDULA LIKE '").append(valueObject.getPLACACEDULA()).append("%' ");
          }

          if (valueObject.getIDTRAMITEINTERNO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDTRAMITEINTERNO = ").append(valueObject.getIDTRAMITEINTERNO()).append(" ");
          }

          if (valueObject.getCODTRAMITE() != null) {
              if (first) { first = false; }
              sql.append("AND CODTRAMITE LIKE '").append(valueObject.getCODTRAMITE()).append("%' ");
          }

          if (valueObject.getDESCTRAMITE() != null) {
              if (first) { first = false; }
              sql.append("AND DESCTRAMITE LIKE '").append(valueObject.getDESCTRAMITE()).append("%' ");
          }


          sql.append("ORDER BY ID_DETCITA ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, DetCita valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setID_DETCITA(result.getInt("ID_DETCITA")); 
                   valueObject.setID_CITA(result.getInt("ID_CITA")); 
                   valueObject.setID_PERSONA(result.getInt("ID_PERSONA")); 
                   valueObject.setHORACITA(result.getString("HORACITA")); 
                   valueObject.setOBSERVACION(result.getString("OBSERVACION")); 
                   valueObject.setID_USRASIGNA(result.getInt("ID_USRASIGNA")); 
                   valueObject.setHORAASIGNA(result.getString("HORAASIGNA")); 
                   valueObject.setFECHAASIGNA(result.getString("FECHAASIGNA")); 
                   valueObject.setESTADO(result.getString("ESTADO")); 
                   valueObject.setIDUSRTERMINA(result.getInt("IDUSRTERMINA")); 
                   valueObject.setFECHATERMINA(result.getString("FECHATERMINA")); 
                   valueObject.setHORATERMINA(result.getString("HORATERMINA")); 
                   valueObject.setNUMEROCITA(result.getInt("NUMEROCITA")); 
                   valueObject.setTIPO(result.getString("TIPO")); 
                   valueObject.setPLACACEDULA(result.getString("PLACACEDULA")); 
                   valueObject.setIDTRAMITEINTERNO(result.getInt("IDTRAMITEINTERNO")); 
                   valueObject.setCODTRAMITE(result.getString("CODTRAMITE")); 
                   valueObject.setDESCTRAMITE(result.getString("DESCTRAMITE")); 

              } else {
                    //System.out.println("DetCita Object Not Found!");
                    throw new NotFoundException("DetCita Object Not Found!");
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
                   DetCita temp = createValueObject();

                   temp.setID_DETCITA(result.getInt("ID_DETCITA")); 
                   temp.setID_CITA(result.getInt("ID_CITA")); 
                   temp.setID_PERSONA(result.getInt("ID_PERSONA")); 
                   temp.setHORACITA(result.getString("HORACITA")); 
                   temp.setOBSERVACION(result.getString("OBSERVACION")); 
                   temp.setID_USRASIGNA(result.getInt("ID_USRASIGNA")); 
                   temp.setHORAASIGNA(result.getString("HORAASIGNA")); 
                   temp.setFECHAASIGNA(result.getString("FECHAASIGNA")); 
                   temp.setESTADO(result.getString("ESTADO")); 
                   temp.setIDUSRTERMINA(result.getInt("IDUSRTERMINA")); 
                   temp.setFECHATERMINA(result.getString("FECHATERMINA")); 
                   temp.setHORATERMINA(result.getString("HORATERMINA")); 
                   temp.setNUMEROCITA(result.getInt("NUMEROCITA")); 
                   temp.setTIPO(result.getString("TIPO")); 
                   temp.setPLACACEDULA(result.getString("PLACACEDULA")); 
                   temp.setIDTRAMITEINTERNO(result.getInt("IDTRAMITEINTERNO")); 
                   temp.setCODTRAMITE(result.getString("CODTRAMITE")); 
                   temp.setDESCTRAMITE(result.getString("DESCTRAMITE")); 

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

        String sql = "SELECT GEN_ID(GEN_DETCITA,1) FROM TRANSITO";
        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;
        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next())
                allRows = result.getInt(1) + 1;
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
        return allRows;
    }


}