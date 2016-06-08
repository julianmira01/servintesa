package modelo.datos.dao.tramites;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.tramites.TransformacionVehiculo;

import utilidades.Funciones;


/**
  * TransformacionVehiculo Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve TransformacionVehiculo object instances.
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



public class TransformacionVehiculoDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public TransformacionVehiculo createValueObject() {
          return new TransformacionVehiculo();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public TransformacionVehiculo getObject(Connection conn, int IDTRANSF_VEHICULO) throws NotFoundException, SQLException {

          TransformacionVehiculo valueObject = createValueObject();
          valueObject.setIDTRANSF_VEHICULO(IDTRANSF_VEHICULO);
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
    public void load(Connection conn, TransformacionVehiculo valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM TRANSFORMACIONVEHICULO WHERE (IDTRANSF_VEHICULO = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getIDTRANSF_VEHICULO()); 

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

          String sql = "SELECT * FROM TRANSFORMACIONVEHICULO ORDER BY IDTRANSF_VEHICULO ASC ";
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
    public synchronized void create(Connection conn, TransformacionVehiculo valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO TRANSFORMACIONVEHICULO ( IDTRANSF_VEHICULO, IDVEHICULO, IDTIPOTRANSFOR, "
               + "ACTIVO, IDREC_LIQUIDACION, DESCRIPCION, "
               + "ANOTACIONES, ID_RUNTMODELO, NUMFICHATECNICA, "
               + "NUMEROMOTOR, ID_TIPOREPOTENCIACION, ID_COMBUSTIBLE, "
               + "ID_TIPCARROCERIA, FECHAFACVENTAMOTOR, NUMFACTVENTAMOTOR, "
               + "HACECAMBIOMOTOR, TIPINGRESOMOTOR, NUMDECLARIMPORTACION, "
               + "ID_VENDEDORMOTOR, TIPOVENDEDORMOTOR, ID_ANOTACIONTRANSFOR, "
               + "ID_USUARIOEXE, FECHAEXE, HORAEXE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getIDTRANSF_VEHICULO()); 
              
              if(!Funciones.EnteroesNulo(valueObject.getIDVEHICULO()))
               stmt.setInt(2, valueObject.getIDVEHICULO()); 
              else
               stmt.setNull(2, Types.INTEGER);
              if(!Funciones.EnteroesNulo(valueObject.getIDTIPOTRANSFOR()))
               stmt.setInt(3, valueObject.getIDTIPOTRANSFOR()); 
              else
               stmt.setNull(3, Types.INTEGER);
              if(Funciones.contarCadena(valueObject.getACTIVO(), 1))
                stmt.setString(4, valueObject.getACTIVO()); 
              else
                stmt.setNull(4, Types.VARCHAR);             
              if(!Funciones.EnteroesNulo(valueObject.getIDREC_LIQUIDACION()))
               stmt.setInt(5, valueObject.getIDREC_LIQUIDACION()); 
              else
               stmt.setNull(5, Types.INTEGER);
              if(Funciones.contarCadena(valueObject.getDESCRIPCION(),255))
                stmt.setString(6, valueObject.getDESCRIPCION()); 
              else
                stmt.setNull(6, Types.VARCHAR);             
              if(Funciones.contarCadena(valueObject.getANOTACIONES(),255))
                stmt.setString(7, valueObject.getANOTACIONES()); 
              else
                stmt.setNull(7, Types.VARCHAR);             
              if(!Funciones.EnteroesNulo(valueObject.getID_RUNTMODELO()))
               stmt.setInt(8, valueObject.getID_RUNTMODELO()); 
              else
               stmt.setNull(8, Types.INTEGER);
              if(Funciones.contarCadena(valueObject.getNUMFICHATECNICA(),50))
                stmt.setString(9, valueObject.getNUMFICHATECNICA()); 
              else
                stmt.setNull(9, Types.VARCHAR);             
              if(Funciones.contarCadena(valueObject.getNUMEROMOTOR(),40))
                stmt.setString(10, valueObject.getNUMEROMOTOR()); 
              else
                stmt.setNull(10, Types.VARCHAR);             
              if(!Funciones.EnteroesNulo(valueObject.getID_TIPOREPOTENCIACION()))
               stmt.setInt(11, valueObject.getID_TIPOREPOTENCIACION()); 
              else
               stmt.setNull(11, Types.INTEGER);
              if(!Funciones.EnteroesNulo(valueObject.getID_COMBUSTIBLE()))
               stmt.setInt(12, valueObject.getID_COMBUSTIBLE()); 
              else
               stmt.setNull(12, Types.INTEGER);
              if(!Funciones.EnteroesNulo(valueObject.getID_TIPCARROCERIA()))
               stmt.setInt(13, valueObject.getID_TIPCARROCERIA()); 
              else
               stmt.setNull(13, Types.INTEGER);
              if(Funciones.esFecha(valueObject.getFECHAFACVENTAMOTOR()))
               stmt.setDate(14, Funciones.convFechaSSQL(valueObject.getFECHAFACVENTAMOTOR())); 
              else
               stmt.setNull(14,Types.DATE);           
              if(Funciones.contarCadena(valueObject.getNUMFACTVENTAMOTOR(),40))
                stmt.setString(15, valueObject.getNUMFACTVENTAMOTOR()); 
              else
                stmt.setNull(15, Types.VARCHAR);  
              if(Funciones.contarCadena(valueObject.getHACECAMBIOMOTOR(),1))
                stmt.setString(16, valueObject.getHACECAMBIOMOTOR()); 
              else
                stmt.setNull(16, Types.VARCHAR);  
              if(Funciones.contarCadena(valueObject.getTIPINGRESOMOTOR(),20))
                stmt.setString(17, valueObject.getTIPINGRESOMOTOR()); 
              else
                stmt.setNull(17, Types.VARCHAR);  
              if(Funciones.contarCadena(valueObject.getNUMDECLARIMPORTACION(),40))
                stmt.setString(18, valueObject.getNUMDECLARIMPORTACION()); 
              else
                stmt.setNull(18, Types.VARCHAR);  
              if(!Funciones.EnteroesNulo(valueObject.getID_VENDEDORMOTOR()))
               stmt.setInt(19, valueObject.getID_VENDEDORMOTOR()); 
              else
               stmt.setNull(19, Types.INTEGER);
              if(Funciones.contarCadena(valueObject.getTIPOVENDEDORMOTOR(),15))
                stmt.setString(20, valueObject.getTIPOVENDEDORMOTOR()); 
              else
                stmt.setNull(20, Types.VARCHAR);
              if(!Funciones.EnteroesNulo(valueObject.getID_ANOTACIONTRANSFOR()))
               stmt.setInt(21, valueObject.getID_ANOTACIONTRANSFOR()); 
              else
               stmt.setNull(21, Types.INTEGER);
              if(!Funciones.EnteroesNulo(valueObject.getID_USUARIOEXE()))
               stmt.setInt(22, valueObject.getID_USUARIOEXE()); 
              else
               stmt.setNull(22, Types.INTEGER); 
              if(Funciones.esFecha(valueObject.getFECHAEXE()))
               stmt.setDate(23, Funciones.convFechaSSQL(valueObject.getFECHAEXE())); 
              else
               stmt.setNull(23,Types.DATE);
              if(Funciones.esTime(valueObject.getHORAEXE()))
                stmt.setTime(24, Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAEXE())));
              else 
                stmt.setNull(24, Types.TIME);

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
    public void save(Connection conn, TransformacionVehiculo valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE TRANSFORMACIONVEHICULO SET IDVEHICULO = ?, IDTIPOTRANSFOR = ?, ACTIVO = ?, "
               + "IDREC_LIQUIDACION = ?, DESCRIPCION = ?, ANOTACIONES = ?, "
               + "ID_RUNTMODELO = ?, NUMFICHATECNICA = ?, NUMEROMOTOR = ?, "
               + "ID_TIPOREPOTENCIACION = ?, ID_COMBUSTIBLE = ?, ID_TIPCARROCERIA = ?, "
               + "FECHAFACVENTAMOTOR = ?, NUMFACTVENTAMOTOR = ?, HACECAMBIOMOTOR = ?, "
               + "TIPINGRESOMOTOR = ?, NUMDECLARIMPORTACION = ?, ID_VENDEDORMOTOR = ?, "
               + "TIPOVENDEDORMOTOR = ?, ID_ANOTACIONTRANSFOR = ?, ID_USUARIOEXE = ?, "
               + "FECHAEXE = ?, HORAEXE = ? WHERE (IDTRANSF_VEHICULO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getIDVEHICULO()); 
              stmt.setInt(2, valueObject.getIDTIPOTRANSFOR()); 
              stmt.setString(3, valueObject.getACTIVO()); 
              stmt.setInt(4, valueObject.getIDREC_LIQUIDACION()); 
              stmt.setString(5, valueObject.getDESCRIPCION()); 
              stmt.setString(6, valueObject.getANOTACIONES()); 
              stmt.setInt(7, valueObject.getID_RUNTMODELO()); 
              stmt.setString(8, valueObject.getNUMFICHATECNICA()); 
              stmt.setString(9, valueObject.getNUMEROMOTOR()); 
              stmt.setInt(10, valueObject.getID_TIPOREPOTENCIACION()); 
              stmt.setInt(11, valueObject.getID_COMBUSTIBLE()); 
              stmt.setInt(12, valueObject.getID_TIPCARROCERIA()); 
              
            if (Funciones.esFecha(valueObject.getFECHAFACVENTAMOTOR()))
                stmt.setDate(13, Funciones.convFechaSSQL(valueObject.getFECHAFACVENTAMOTOR()));
            else
                stmt.setNull(13, Types.DATE);
              
              stmt.setString(14, valueObject.getNUMFACTVENTAMOTOR()); 
              stmt.setString(15, valueObject.getHACECAMBIOMOTOR()); 
              stmt.setString(16, valueObject.getTIPINGRESOMOTOR()); 
              stmt.setString(17, valueObject.getNUMDECLARIMPORTACION()); 
              stmt.setInt(18, valueObject.getID_VENDEDORMOTOR()); 
              stmt.setString(19, valueObject.getTIPOVENDEDORMOTOR()); 
              stmt.setInt(20, valueObject.getID_ANOTACIONTRANSFOR()); 
              stmt.setInt(21, valueObject.getID_USUARIOEXE()); 
              
            if (Funciones.esFecha(valueObject.getFECHAEXE()))
                stmt.setDate(22, Funciones.convFechaSSQL(valueObject.getFECHAEXE()));
            else
                stmt.setNull(22, Types.DATE);
              
              //stmt.setString(23, valueObject.getHORAEXE());               
            if (Funciones.esTime(valueObject.getHORAEXE()))
                stmt.setTime(23, Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAEXE())));
            else
                stmt.setNull(23, Types.TIME);

              stmt.setInt(24, valueObject.getIDTRANSF_VEHICULO()); 

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
    public void delete(Connection conn, TransformacionVehiculo valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM TRANSFORMACIONVEHICULO WHERE (IDTRANSF_VEHICULO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getIDTRANSF_VEHICULO()); 

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

          String sql = "DELETE FROM TRANSFORMACIONVEHICULO";
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

          String sql = "SELECT count(*) FROM TRANSFORMACIONVEHICULO";
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
    public List searchMatching(Connection conn, TransformacionVehiculo valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM TRANSFORMACIONVEHICULO WHERE 1=1 ");

          if (valueObject.getIDTRANSF_VEHICULO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDTRANSF_VEHICULO = ").append(valueObject.getIDTRANSF_VEHICULO()).append(" ");
          }

          if (valueObject.getIDVEHICULO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDVEHICULO = ").append(valueObject.getIDVEHICULO()).append(" ");
          }

          if (valueObject.getIDTIPOTRANSFOR() != 0) {
              if (first) { first = false; }
              sql.append("AND IDTIPOTRANSFOR = ").append(valueObject.getIDTIPOTRANSFOR()).append(" ");
          }

          if (valueObject.getACTIVO() != null) {
              if (first) { first = false; }
              sql.append("AND ACTIVO = '").append(valueObject.getACTIVO()).append("' ");
          }

          if (valueObject.getIDREC_LIQUIDACION() != 0) {
              if (first) { first = false; }
              sql.append("AND IDREC_LIQUIDACION = ").append(valueObject.getIDREC_LIQUIDACION()).append(" ");
          }

          if (valueObject.getDESCRIPCION() != null) {
              if (first) { first = false; }
              sql.append("AND DESCRIPCION = '").append(valueObject.getDESCRIPCION()).append("' ");
          }

          if (valueObject.getANOTACIONES() != null) {
              if (first) { first = false; }
              sql.append("AND ANOTACIONES = '").append(valueObject.getANOTACIONES()).append("' ");
          }

          if (valueObject.getID_RUNTMODELO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_RUNTMODELO = ").append(valueObject.getID_RUNTMODELO()).append(" ");
          }

          if (valueObject.getNUMFICHATECNICA() != null) {
              if (first) { first = false; }
              sql.append("AND NUMFICHATECNICA = '").append(valueObject.getNUMFICHATECNICA()).append("' ");
          }

          if (valueObject.getNUMEROMOTOR() != null) {
              if (first) { first = false; }
              sql.append("AND NUMEROMOTOR LIKE '").append(valueObject.getNUMEROMOTOR()).append("' ");
          }

          if (valueObject.getID_TIPOREPOTENCIACION() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_TIPOREPOTENCIACION = ").append(valueObject.getID_TIPOREPOTENCIACION()).append(" ");
          }

          if (valueObject.getID_COMBUSTIBLE() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_COMBUSTIBLE = ").append(valueObject.getID_COMBUSTIBLE()).append(" ");
          }

          if (valueObject.getID_TIPCARROCERIA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_TIPCARROCERIA = ").append(valueObject.getID_TIPCARROCERIA()).append(" ");
          }

          if (valueObject.getFECHAFACVENTAMOTOR() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAFACVENTAMOTOR = '").append(valueObject.getFECHAFACVENTAMOTOR()).append("' ");
          }

          if (valueObject.getNUMFACTVENTAMOTOR() != null) {
              if (first) { first = false; }
              sql.append("AND NUMFACTVENTAMOTOR = '").append(valueObject.getNUMFACTVENTAMOTOR()).append("' ");
          }

          if (valueObject.getHACECAMBIOMOTOR() != null) {
              if (first) { first = false; }
              sql.append("AND HACECAMBIOMOTOR = '").append(valueObject.getHACECAMBIOMOTOR()).append("' ");
          }

          if (valueObject.getTIPINGRESOMOTOR() != null) {
              if (first) { first = false; }
              sql.append("AND TIPINGRESOMOTOR = '").append(valueObject.getTIPINGRESOMOTOR()).append("' ");
          }

          if (valueObject.getNUMDECLARIMPORTACION() != null) {
              if (first) { first = false; }
              sql.append("AND NUMDECLARIMPORTACION = '").append(valueObject.getNUMDECLARIMPORTACION()).append("' ");
          }

          if (valueObject.getID_VENDEDORMOTOR() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_VENDEDORMOTOR = ").append(valueObject.getID_VENDEDORMOTOR()).append(" ");
          }

          if (valueObject.getTIPOVENDEDORMOTOR() != null) {
              if (first) { first = false; }
              sql.append("AND TIPOVENDEDORMOTOR = '").append(valueObject.getTIPOVENDEDORMOTOR()).append("' ");
          }

          if (valueObject.getID_ANOTACIONTRANSFOR() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_ANOTACIONTRANSFOR = ").append(valueObject.getID_ANOTACIONTRANSFOR()).append(" ");
          }

          if (valueObject.getID_USUARIOEXE() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_USUARIOEXE = ").append(valueObject.getID_USUARIOEXE()).append(" ");
          }

          if (valueObject.getFECHAEXE() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAEXE = '").append(valueObject.getFECHAEXE()).append("' ");
          }

          if (valueObject.getHORAEXE() != null) {
              if (first) { first = false; }
              sql.append("AND HORAEXE = '").append(valueObject.getHORAEXE()).append("' ");
          }


          sql.append("ORDER BY IDTRANSF_VEHICULO ASC ");
          System.out.println(sql.toString());
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
    protected void singleQuery(Connection conn, PreparedStatement stmt, TransformacionVehiculo valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setIDTRANSF_VEHICULO(result.getInt("IDTRANSF_VEHICULO")); 
                   valueObject.setIDVEHICULO(result.getInt("IDVEHICULO")); 
                   valueObject.setIDTIPOTRANSFOR(result.getInt("IDTIPOTRANSFOR")); 
                   valueObject.setACTIVO(result.getString("ACTIVO")); 
                   valueObject.setIDREC_LIQUIDACION(result.getInt("IDREC_LIQUIDACION")); 
                   valueObject.setDESCRIPCION(result.getString("DESCRIPCION")); 
                   valueObject.setANOTACIONES(result.getString("ANOTACIONES")); 
                   valueObject.setID_RUNTMODELO(result.getInt("ID_RUNTMODELO")); 
                   valueObject.setNUMFICHATECNICA(result.getString("NUMFICHATECNICA")); 
                   valueObject.setNUMEROMOTOR(result.getString("NUMEROMOTOR")); 
                   valueObject.setID_TIPOREPOTENCIACION(result.getInt("ID_TIPOREPOTENCIACION")); 
                   valueObject.setID_COMBUSTIBLE(result.getInt("ID_COMBUSTIBLE")); 
                   valueObject.setID_TIPCARROCERIA(result.getInt("ID_TIPCARROCERIA")); 
                   valueObject.setFECHAFACVENTAMOTOR(result.getString("FECHAFACVENTAMOTOR")); 
                   valueObject.setNUMFACTVENTAMOTOR(result.getString("NUMFACTVENTAMOTOR")); 
                   valueObject.setHACECAMBIOMOTOR(result.getString("HACECAMBIOMOTOR")); 
                   valueObject.setTIPINGRESOMOTOR(result.getString("TIPINGRESOMOTOR")); 
                   valueObject.setNUMDECLARIMPORTACION(result.getString("NUMDECLARIMPORTACION")); 
                   valueObject.setID_VENDEDORMOTOR(result.getInt("ID_VENDEDORMOTOR")); 
                   valueObject.setTIPOVENDEDORMOTOR(result.getString("TIPOVENDEDORMOTOR")); 
                   valueObject.setID_ANOTACIONTRANSFOR(result.getInt("ID_ANOTACIONTRANSFOR")); 
                   valueObject.setID_USUARIOEXE(result.getInt("ID_USUARIOEXE")); 
                   valueObject.setFECHAEXE(result.getString("FECHAEXE")); 
                   valueObject.setHORAEXE(result.getString("HORAEXE")); 

              } else {
                    //System.out.println("TransformacionVehiculo Object Not Found!");
                    throw new NotFoundException("TransformacionVehiculo Object Not Found!");
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
                   TransformacionVehiculo temp = createValueObject();

                   temp.setIDTRANSF_VEHICULO(result.getInt("IDTRANSF_VEHICULO")); 
                   temp.setIDVEHICULO(result.getInt("IDVEHICULO")); 
                   temp.setIDTIPOTRANSFOR(result.getInt("IDTIPOTRANSFOR")); 
                   temp.setACTIVO(result.getString("ACTIVO")); 
                   temp.setIDREC_LIQUIDACION(result.getInt("IDREC_LIQUIDACION")); 
                   temp.setDESCRIPCION(result.getString("DESCRIPCION")); 
                   temp.setANOTACIONES(result.getString("ANOTACIONES")); 
                   temp.setID_RUNTMODELO(result.getInt("ID_RUNTMODELO")); 
                   temp.setNUMFICHATECNICA(result.getString("NUMFICHATECNICA")); 
                   temp.setNUMEROMOTOR(result.getString("NUMEROMOTOR")); 
                   temp.setID_TIPOREPOTENCIACION(result.getInt("ID_TIPOREPOTENCIACION")); 
                   temp.setID_COMBUSTIBLE(result.getInt("ID_COMBUSTIBLE")); 
                   temp.setID_TIPCARROCERIA(result.getInt("ID_TIPCARROCERIA")); 
                   temp.setFECHAFACVENTAMOTOR(result.getString("FECHAFACVENTAMOTOR")); 
                   temp.setNUMFACTVENTAMOTOR(result.getString("NUMFACTVENTAMOTOR")); 
                   temp.setHACECAMBIOMOTOR(result.getString("HACECAMBIOMOTOR")); 
                   temp.setTIPINGRESOMOTOR(result.getString("TIPINGRESOMOTOR")); 
                   temp.setNUMDECLARIMPORTACION(result.getString("NUMDECLARIMPORTACION")); 
                   temp.setID_VENDEDORMOTOR(result.getInt("ID_VENDEDORMOTOR")); 
                   temp.setTIPOVENDEDORMOTOR(result.getString("TIPOVENDEDORMOTOR")); 
                   temp.setID_ANOTACIONTRANSFOR(result.getInt("ID_ANOTACIONTRANSFOR")); 
                   temp.setID_USUARIOEXE(result.getInt("ID_USUARIOEXE")); 
                   temp.setFECHAEXE(result.getString("FECHAEXE")); 
                   temp.setHORAEXE(result.getString("HORAEXE")); 

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
