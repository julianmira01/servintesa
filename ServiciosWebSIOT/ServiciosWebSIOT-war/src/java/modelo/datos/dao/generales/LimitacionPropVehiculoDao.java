package modelo.datos.dao.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generales.LimitacionPropVehiculo;

import utilidades.Funciones;


/**
  * LimitacionPropVehiculo Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve LimitacionPropVehiculo object instances.
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



public class LimitacionPropVehiculoDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public LimitacionPropVehiculo createValueObject() {
          return new LimitacionPropVehiculo();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public LimitacionPropVehiculo getObject(Connection conn, int IDLIMITAC_VEHICULO) throws NotFoundException, SQLException {

          LimitacionPropVehiculo valueObject = createValueObject();
          valueObject.setIDLIMITAC_VEHICULO(IDLIMITAC_VEHICULO);
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
    public void load(Connection conn, LimitacionPropVehiculo valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM LIMITACIONPROP_VEHICULO WHERE (IDLIMITAC_VEHICULO = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getIDLIMITAC_VEHICULO()); 

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

          String sql = "SELECT * FROM LIMITACIONPROP_VEHICULO ORDER BY IDLIMITAC_VEHICULO ASC ";
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
    public synchronized void create(Connection conn, LimitacionPropVehiculo valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO LIMITACIONPROP_VEHICULO ( IDLIMITAC_VEHICULO, ID_VEHICULO, ID_LIMITACION, "
               + "FECHARADICA_LIMITACION, HORARADICA_LIMITACION, ACREEDOR, "
               + "IDENTIFICACIONACREEDOR, ID_DOCUMENTO, ID_CIUDADACREEDOR, "
               + "NUMNOTARIA_LIMITACION, IDCIUDAD_NOTARIALIMITAC, FECHAAUTENTICACIONLIMITACION, "
               + "VALORLIMITACION, FECHACANCELALIMITACION, NUMDOCTOCANCELACION, "
               + "NUMNOTARIA_CANCELACION, FECHAAUTENTICACIONCANCELACION, IDCIUDAD_NOTARIACANCELAC, "
               + "ESTADOLIMITACION, ID_RECIBOLIQ, ID_GRADOALERTA, "
               + "ID_TIPO_ALERTA, TIPOPERSONA, DESCRIPCIONAUTORIZACION) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);
               //Funciones.getId_FB(conn, "GEN_LIMITACVEHICULO");
              
              stmt.setInt(1, valueObject.getIDLIMITAC_VEHICULO()); 
              
              if(Funciones.esEntero(String.valueOf(valueObject.getID_VEHICULO())))
                stmt.setInt(2, valueObject.getID_VEHICULO()); 
              else
                  stmt.setNull(2, Types.INTEGER);
              if(Funciones.esEntero(String.valueOf(valueObject.getID_LIMITACION())))
                stmt.setInt(3, valueObject.getID_LIMITACION()); 
              else
                  stmt.setNull(3, Types.INTEGER);
              if(Funciones.esFecha(valueObject.getFECHARADICA_LIMITACION())) 
                stmt.setDate(4, Funciones.convFechaSSQL(valueObject.getFECHARADICA_LIMITACION())); 
              else
                  stmt.setNull(4, Types.DATE);
              
              if(Funciones.esTime(valueObject.getHORARADICA_LIMITACION()))
                stmt.setTime(5, Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORARADICA_LIMITACION()))); 
              else
                  stmt.setNull(5, Types.TIME);
              
              if(Funciones.contarCadena(valueObject.getACREEDOR(), 49))
                stmt.setString(6, valueObject.getACREEDOR()); 
              else
                  stmt.setNull(6, Types.VARCHAR);
              if(Funciones.contarCadena(valueObject.getIDENTIFICACIONACREEDOR(), 14))
                stmt.setString(7, valueObject.getIDENTIFICACIONACREEDOR()); 
              else
                  stmt.setNull(7, Types.VARCHAR);
              if(Funciones.contarCadena(valueObject.getID_DOCUMENTO(), 2))
                stmt.setString(8, valueObject.getID_DOCUMENTO()); 
              else
                  stmt.setNull(8, Types.VARCHAR);
              if(Funciones.esEntero(String.valueOf(valueObject.getID_CIUDADACREEDOR())))
                stmt.setInt(9, valueObject.getID_CIUDADACREEDOR()); 
              else
                  stmt.setNull(9, Types.INTEGER);  
              if(Funciones.contarCadena(valueObject.getNUMNOTARIA_LIMITACION(), 5))
                stmt.setString(10, valueObject.getNUMNOTARIA_LIMITACION()); 
              else
                  stmt.setNull(10, Types.VARCHAR);  
              if(Funciones.esEntero(String.valueOf(valueObject.getIDCIUDAD_NOTARIALIMITAC())))
                stmt.setInt(11, valueObject.getIDCIUDAD_NOTARIALIMITAC()); 
              else
                  stmt.setNull(11, Types.INTEGER);    
              if(Funciones.esFecha(valueObject.getFECHAAUTENTICACIONLIMITACION())) 
                stmt.setDate(12, Funciones.convFechaSSQL(valueObject.getFECHAAUTENTICACIONLIMITACION())); 
              else
                  stmt.setNull(12, Types.DATE);
              if(Funciones.esDouble(String.valueOf(valueObject.getVALORLIMITACION())))
                stmt.setDouble(13, valueObject.getVALORLIMITACION());
              else
                stmt.setNull(13, Types.DOUBLE);
              if(Funciones.esFecha(valueObject.getFECHACANCELALIMITACION())) 
                stmt.setDate(14, Funciones.convFechaSSQL(valueObject.getFECHACANCELALIMITACION())); 
              else
                  stmt.setNull(14, Types.DATE);
              if(Funciones.contarCadena(valueObject.getNUMDOCTOCANCELACION(), 19))
                stmt.setString(15, valueObject.getNUMDOCTOCANCELACION()); 
              else
                  stmt.setNull(15, Types.VARCHAR); 
              if(Funciones.contarCadena(valueObject.getNUMNOTARIA_CANCELACION(), 5))
                stmt.setString(16, valueObject.getNUMNOTARIA_CANCELACION()); 
              else
                  stmt.setNull(16, Types.VARCHAR); 
              if(Funciones.esFecha(valueObject.getFECHAAUTENTICACIONCANCELACION())) 
                stmt.setDate(17, Funciones.convFechaSSQL(valueObject.getFECHAAUTENTICACIONCANCELACION())); 
              else
                  stmt.setNull(17, Types.DATE);
              if(Funciones.esEntero(String.valueOf(valueObject.getIDCIUDAD_NOTARIACANCELAC())))
                stmt.setInt(18, valueObject.getIDCIUDAD_NOTARIACANCELAC()); 
              else
                  stmt.setNull(18, Types.INTEGER);    
              if(Funciones.contarCadena(valueObject.getESTADOLIMITACION(), 2))
                stmt.setString(19, valueObject.getESTADOLIMITACION()); 
              else
                  stmt.setNull(19, Types.VARCHAR); 
              if(Funciones.esEntero(String.valueOf(valueObject.getID_RECIBOLIQ())))
                stmt.setInt(20, valueObject.getID_RECIBOLIQ()); 
              else
                  stmt.setNull(20, Types.INTEGER);    
              if(Funciones.esEntero(String.valueOf(valueObject.getID_GRADOALERTA())))
                stmt.setInt(21, valueObject.getID_GRADOALERTA()); 
              else
                  stmt.setNull(21, Types.INTEGER);    
              if(Funciones.esEntero(String.valueOf(valueObject.getID_TIPO_ALERTA())))
                stmt.setInt(22, valueObject.getID_TIPO_ALERTA()); 
              else
                  stmt.setNull(22, Types.INTEGER);    
              if(Funciones.contarCadena(valueObject.getTIPOPERSONA(), 20))
                stmt.setString(23, valueObject.getTIPOPERSONA()); 
              else
                  stmt.setNull(23, Types.VARCHAR); 
              if(Funciones.contarCadena(valueObject.getDESCRIPCIONAUTORIZACION(), 499))
                stmt.setString(24, valueObject.getDESCRIPCIONAUTORIZACION()); 
              else
                  stmt.setNull(24, Types.VARCHAR);

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
    public void save(Connection conn, LimitacionPropVehiculo valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE LIMITACIONPROP_VEHICULO SET ID_VEHICULO = ?, ID_LIMITACION = ?, FECHARADICA_LIMITACION = ?, "
               + "HORARADICA_LIMITACION = ?, ACREEDOR = ?, IDENTIFICACIONACREEDOR = ?, "
               + "ID_DOCUMENTO = ?, ID_CIUDADACREEDOR = ?, NUMNOTARIA_LIMITACION = ?, "
               + "IDCIUDAD_NOTARIALIMITAC = ?, FECHAAUTENTICACIONLIMITACION = ?, VALORLIMITACION = ?, "
               + "FECHACANCELALIMITACION = ?, NUMDOCTOCANCELACION = ?, NUMNOTARIA_CANCELACION = ?, "
               + "FECHAAUTENTICACIONCANCELACION = ?, IDCIUDAD_NOTARIACANCELAC = ?, ESTADOLIMITACION = ?, "
               + "ID_RECIBOLIQ = ?, ID_GRADOALERTA = ?, ID_TIPO_ALERTA = ?, "
               + "TIPOPERSONA = ?, DESCRIPCIONAUTORIZACION = ? WHERE (IDLIMITAC_VEHICULO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              
              if(Funciones.esEntero(String.valueOf(valueObject.getID_VEHICULO())))
                stmt.setInt(1, valueObject.getID_VEHICULO()); 
              else
                  stmt.setNull(1, Types.INTEGER);
              if(Funciones.esEntero(String.valueOf(valueObject.getID_LIMITACION())))
                stmt.setInt(2, valueObject.getID_LIMITACION()); 
              else
                  stmt.setNull(2, Types.INTEGER);
              if(Funciones.esFecha(valueObject.getFECHARADICA_LIMITACION())) 
                stmt.setDate(3, Funciones.convFechaSSQL(valueObject.getFECHARADICA_LIMITACION())); 
              else
                  stmt.setNull(3, Types.DATE);              
              if(Funciones.esTime(valueObject.getHORARADICA_LIMITACION()))
                  stmt.setTime(4, Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORARADICA_LIMITACION()))); 
              else
                  stmt.setNull(4, Types.TIME);              
              if(Funciones.contarCadena(valueObject.getACREEDOR(), 49))
                stmt.setString(5, valueObject.getACREEDOR()); 
              else
                  stmt.setNull(5, Types.VARCHAR);
              if(Funciones.contarCadena(valueObject.getIDENTIFICACIONACREEDOR(), 14))
                stmt.setString(6, valueObject.getIDENTIFICACIONACREEDOR()); 
              else
                  stmt.setNull(6, Types.VARCHAR);
              if(Funciones.contarCadena(valueObject.getID_DOCUMENTO(), 2))
                stmt.setString(7, valueObject.getID_DOCUMENTO()); 
              else
                  stmt.setNull(7, Types.VARCHAR);
              if(Funciones.esEntero(String.valueOf(valueObject.getID_CIUDADACREEDOR())))
                stmt.setInt(8, valueObject.getID_CIUDADACREEDOR()); 
              else
                  stmt.setNull(8, Types.INTEGER);  
              if(Funciones.contarCadena(valueObject.getNUMNOTARIA_LIMITACION(), 5))
                stmt.setString(9, valueObject.getNUMNOTARIA_LIMITACION()); 
              else
                  stmt.setNull(9, Types.VARCHAR);  
              if(Funciones.esEntero(String.valueOf(valueObject.getIDCIUDAD_NOTARIALIMITAC())))
                stmt.setInt(10, valueObject.getIDCIUDAD_NOTARIALIMITAC()); 
              else
                  stmt.setNull(10, Types.INTEGER);    
              if(Funciones.esFecha(valueObject.getFECHAAUTENTICACIONLIMITACION())) 
                stmt.setDate(11, Funciones.convFechaSSQL(valueObject.getFECHAAUTENTICACIONLIMITACION())); 
              else
                  stmt.setNull(11, Types.DATE);
              if(Funciones.esDouble(String.valueOf(valueObject.getVALORLIMITACION())))
                stmt.setDouble(12, valueObject.getVALORLIMITACION());
              else
                stmt.setNull(12, Types.DOUBLE);
              if(Funciones.esFecha(valueObject.getFECHACANCELALIMITACION())) 
                stmt.setDate(13, Funciones.convFechaSSQL(valueObject.getFECHACANCELALIMITACION())); 
              else
                  stmt.setNull(13, Types.DATE);
              if(Funciones.contarCadena(valueObject.getNUMDOCTOCANCELACION(), 19))
                stmt.setString(14, valueObject.getNUMDOCTOCANCELACION()); 
              else
                  stmt.setNull(14, Types.VARCHAR); 
              if(Funciones.contarCadena(valueObject.getNUMNOTARIA_CANCELACION(), 5))
                stmt.setString(15, valueObject.getNUMNOTARIA_CANCELACION()); 
              else
                  stmt.setNull(15, Types.VARCHAR); 
              if(Funciones.esFecha(valueObject.getFECHAAUTENTICACIONCANCELACION())) 
                stmt.setDate(16, Funciones.convFechaSSQL(valueObject.getFECHAAUTENTICACIONCANCELACION())); 
              else
                  stmt.setNull(16, Types.DATE);
              if(Funciones.esEntero(String.valueOf(valueObject.getIDCIUDAD_NOTARIACANCELAC())))
                stmt.setInt(17, valueObject.getIDCIUDAD_NOTARIACANCELAC()); 
              else
                  stmt.setNull(17, Types.INTEGER);    
              if(Funciones.contarCadena(valueObject.getESTADOLIMITACION(), 2))
                stmt.setString(18, valueObject.getESTADOLIMITACION()); 
              else
                  stmt.setNull(18, Types.VARCHAR); 
              if(Funciones.esEntero(String.valueOf(valueObject.getID_RECIBOLIQ())))
                stmt.setInt(19, valueObject.getID_RECIBOLIQ()); 
              else
                  stmt.setNull(19, Types.INTEGER);    
              if(Funciones.esEntero(String.valueOf(valueObject.getID_GRADOALERTA())))
                stmt.setInt(20, valueObject.getID_GRADOALERTA()); 
              else
                  stmt.setNull(20, Types.INTEGER);    
              if(Funciones.esEntero(String.valueOf(valueObject.getID_TIPO_ALERTA())))
                stmt.setInt(21, valueObject.getID_TIPO_ALERTA()); 
              else
                  stmt.setNull(21, Types.INTEGER);    
              if(Funciones.contarCadena(valueObject.getTIPOPERSONA(), 20))
                stmt.setString(22, valueObject.getTIPOPERSONA()); 
              else
                  stmt.setNull(22, Types.VARCHAR); 
              if(Funciones.contarCadena(valueObject.getDESCRIPCIONAUTORIZACION(), 499))
                stmt.setString(23, valueObject.getDESCRIPCIONAUTORIZACION()); 
              else
                  stmt.setNull(23, Types.VARCHAR);

              stmt.setInt(24, valueObject.getIDLIMITAC_VEHICULO()); 

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
    public void delete(Connection conn, LimitacionPropVehiculo valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM LIMITACIONPROP_VEHICULO WHERE (IDLIMITAC_VEHICULO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getIDLIMITAC_VEHICULO()); 

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

          String sql = "DELETE FROM LIMITACIONPROP_VEHICULO";
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

          String sql = "SELECT count(*) FROM LIMITACIONPROP_VEHICULO";
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
    public List searchMatching(Connection conn, LimitacionPropVehiculo valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM LIMITACIONPROP_VEHICULO WHERE 1=1 ");

          if (valueObject.getIDLIMITAC_VEHICULO() != 0) {
              if (first) { first = false; }
              sql.append("AND IDLIMITAC_VEHICULO = ").append(valueObject.getIDLIMITAC_VEHICULO()).append(" ");
          }

          if (valueObject.getID_VEHICULO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_VEHICULO = ").append(valueObject.getID_VEHICULO()).append(" ");
          }

          if (valueObject.getID_LIMITACION() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_LIMITACION = ").append(valueObject.getID_LIMITACION()).append(" ");
          }

          if (valueObject.getFECHARADICA_LIMITACION() != null) {
              if (first) { first = false; }
              sql.append("AND FECHARADICA_LIMITACION LIKE '").append(valueObject.getFECHARADICA_LIMITACION()).append("%' ");
          }

          if (valueObject.getHORARADICA_LIMITACION() != null) {
              if (first) { first = false; }
              sql.append("AND HORARADICA_LIMITACION LIKE '").append(valueObject.getHORARADICA_LIMITACION()).append("%' ");
          }

          if (valueObject.getACREEDOR() != null) {
              if (first) { first = false; }
              sql.append("AND ACREEDOR LIKE '").append(valueObject.getACREEDOR()).append("%' ");
          }

          if (valueObject.getIDENTIFICACIONACREEDOR() != null) {
              if (first) { first = false; }
              sql.append("AND IDENTIFICACIONACREEDOR LIKE '").append(valueObject.getIDENTIFICACIONACREEDOR()).append("%' ");
          }

          if (valueObject.getID_DOCUMENTO() != null) {
              if (first) { first = false; }
              sql.append("AND ID_DOCUMENTO LIKE '").append(valueObject.getID_DOCUMENTO()).append("%' ");
          }

          if (valueObject.getID_CIUDADACREEDOR() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_CIUDADACREEDOR = ").append(valueObject.getID_CIUDADACREEDOR()).append(" ");
          }

          if (valueObject.getNUMNOTARIA_LIMITACION() != null) {
              if (first) { first = false; }
              sql.append("AND NUMNOTARIA_LIMITACION LIKE '").append(valueObject.getNUMNOTARIA_LIMITACION()).append("%' ");
          }

          if (valueObject.getIDCIUDAD_NOTARIALIMITAC() != 0) {
              if (first) { first = false; }
              sql.append("AND IDCIUDAD_NOTARIALIMITAC = ").append(valueObject.getIDCIUDAD_NOTARIALIMITAC()).append(" ");
          }

          if (valueObject.getFECHAAUTENTICACIONLIMITACION() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAAUTENTICACIONLIMITACION LIKE '").append(valueObject.getFECHAAUTENTICACIONLIMITACION()).append("%' ");
          }

          if (valueObject.getVALORLIMITACION() != 0) {
              if (first) { first = false; }
              sql.append("AND VALORLIMITACION = ").append(valueObject.getVALORLIMITACION()).append(" ");
          }

          if (valueObject.getFECHACANCELALIMITACION() != null) {
              if (first) { first = false; }
              sql.append("AND FECHACANCELALIMITACION LIKE '").append(valueObject.getFECHACANCELALIMITACION()).append("%' ");
          }

          if (valueObject.getNUMDOCTOCANCELACION() != null) {
              if (first) { first = false; }
              sql.append("AND NUMDOCTOCANCELACION LIKE '").append(valueObject.getNUMDOCTOCANCELACION()).append("%' ");
          }

          if (valueObject.getNUMNOTARIA_CANCELACION() != null) {
              if (first) { first = false; }
              sql.append("AND NUMNOTARIA_CANCELACION LIKE '").append(valueObject.getNUMNOTARIA_CANCELACION()).append("%' ");
          }

          if (valueObject.getFECHAAUTENTICACIONCANCELACION() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAAUTENTICACIONCANCELACION LIKE '").append(valueObject.getFECHAAUTENTICACIONCANCELACION()).append("%' ");
          }

          if (valueObject.getIDCIUDAD_NOTARIACANCELAC() != 0) {
              if (first) { first = false; }
              sql.append("AND IDCIUDAD_NOTARIACANCELAC = ").append(valueObject.getIDCIUDAD_NOTARIACANCELAC()).append(" ");
          }

          if (valueObject.getESTADOLIMITACION() != null) {
              if (first) { first = false; }
              sql.append("AND ESTADOLIMITACION LIKE '").append(valueObject.getESTADOLIMITACION()).append("%' ");
          }

          if (valueObject.getID_RECIBOLIQ() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_RECIBOLIQ = ").append(valueObject.getID_RECIBOLIQ()).append(" ");
          }

          if (valueObject.getID_GRADOALERTA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_GRADOALERTA = ").append(valueObject.getID_GRADOALERTA()).append(" ");
          }

          if (valueObject.getID_TIPO_ALERTA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_TIPO_ALERTA = ").append(valueObject.getID_TIPO_ALERTA()).append(" ");
          }

          if (valueObject.getTIPOPERSONA() != null) {
              if (first) { first = false; }
              sql.append("AND TIPOPERSONA LIKE '").append(valueObject.getTIPOPERSONA()).append("%' ");
          }

          if (valueObject.getDESCRIPCIONAUTORIZACION() != null) {
              if (first) { first = false; }
              sql.append("AND DESCRIPCIONAUTORIZACION LIKE '").append(valueObject.getDESCRIPCIONAUTORIZACION()).append("%' ");
          }


          sql.append("ORDER BY IDLIMITAC_VEHICULO ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, LimitacionPropVehiculo valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setIDLIMITAC_VEHICULO(result.getInt("IDLIMITAC_VEHICULO")); 
                   valueObject.setID_VEHICULO(result.getInt("ID_VEHICULO")); 
                   valueObject.setID_LIMITACION(result.getInt("ID_LIMITACION")); 
                   valueObject.setFECHARADICA_LIMITACION(result.getString("FECHARADICA_LIMITACION")); 
                   valueObject.setHORARADICA_LIMITACION(result.getString("HORARADICA_LIMITACION")); 
                   valueObject.setACREEDOR(result.getString("ACREEDOR")); 
                   valueObject.setIDENTIFICACIONACREEDOR(result.getString("IDENTIFICACIONACREEDOR")); 
                   valueObject.setID_DOCUMENTO(result.getString("ID_DOCUMENTO")); 
                   valueObject.setID_CIUDADACREEDOR(result.getInt("ID_CIUDADACREEDOR")); 
                   valueObject.setNUMNOTARIA_LIMITACION(result.getString("NUMNOTARIA_LIMITACION")); 
                   valueObject.setIDCIUDAD_NOTARIALIMITAC(result.getInt("IDCIUDAD_NOTARIALIMITAC")); 
                   valueObject.setFECHAAUTENTICACIONLIMITACION(result.getString("FECHAAUTENTICACIONLIMITACION")); 
                   valueObject.setVALORLIMITACION(result.getDouble("VALORLIMITACION")); 
                   valueObject.setFECHACANCELALIMITACION(result.getString("FECHACANCELALIMITACION")); 
                   valueObject.setNUMDOCTOCANCELACION(result.getString("NUMDOCTOCANCELACION")); 
                   valueObject.setNUMNOTARIA_CANCELACION(result.getString("NUMNOTARIA_CANCELACION")); 
                   valueObject.setFECHAAUTENTICACIONCANCELACION(result.getString("FECHAAUTENTICACIONCANCELACION")); 
                   valueObject.setIDCIUDAD_NOTARIACANCELAC(result.getInt("IDCIUDAD_NOTARIACANCELAC")); 
                   valueObject.setESTADOLIMITACION(result.getString("ESTADOLIMITACION")); 
                   valueObject.setID_RECIBOLIQ(result.getInt("ID_RECIBOLIQ")); 
                   valueObject.setID_GRADOALERTA(result.getInt("ID_GRADOALERTA")); 
                   valueObject.setID_TIPO_ALERTA(result.getInt("ID_TIPO_ALERTA")); 
                   valueObject.setTIPOPERSONA(result.getString("TIPOPERSONA")); 
                   valueObject.setDESCRIPCIONAUTORIZACION(result.getString("DESCRIPCIONAUTORIZACION")); 

              } else {
                    //System.out.println("LimitacionPropVehiculo Object Not Found!");
                    throw new NotFoundException("LimitacionPropVehiculo Object Not Found!");
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
                   LimitacionPropVehiculo temp = createValueObject();

                   temp.setIDLIMITAC_VEHICULO(result.getInt("IDLIMITAC_VEHICULO")); 
                   temp.setID_VEHICULO(result.getInt("ID_VEHICULO")); 
                   temp.setID_LIMITACION(result.getInt("ID_LIMITACION")); 
                   temp.setFECHARADICA_LIMITACION(result.getString("FECHARADICA_LIMITACION")); 
                   temp.setHORARADICA_LIMITACION(result.getString("HORARADICA_LIMITACION")); 
                   temp.setACREEDOR(result.getString("ACREEDOR")); 
                   temp.setIDENTIFICACIONACREEDOR(result.getString("IDENTIFICACIONACREEDOR")); 
                   temp.setID_DOCUMENTO(result.getString("ID_DOCUMENTO")); 
                   temp.setID_CIUDADACREEDOR(result.getInt("ID_CIUDADACREEDOR")); 
                   temp.setNUMNOTARIA_LIMITACION(result.getString("NUMNOTARIA_LIMITACION")); 
                   temp.setIDCIUDAD_NOTARIALIMITAC(result.getInt("IDCIUDAD_NOTARIALIMITAC")); 
                   temp.setFECHAAUTENTICACIONLIMITACION(result.getString("FECHAAUTENTICACIONLIMITACION")); 
                   temp.setVALORLIMITACION(result.getDouble("VALORLIMITACION")); 
                   temp.setFECHACANCELALIMITACION(result.getString("FECHACANCELALIMITACION")); 
                   temp.setNUMDOCTOCANCELACION(result.getString("NUMDOCTOCANCELACION")); 
                   temp.setNUMNOTARIA_CANCELACION(result.getString("NUMNOTARIA_CANCELACION")); 
                   temp.setFECHAAUTENTICACIONCANCELACION(result.getString("FECHAAUTENTICACIONCANCELACION")); 
                   temp.setIDCIUDAD_NOTARIACANCELAC(result.getInt("IDCIUDAD_NOTARIACANCELAC")); 
                   temp.setESTADOLIMITACION(result.getString("ESTADOLIMITACION")); 
                   temp.setID_RECIBOLIQ(result.getInt("ID_RECIBOLIQ")); 
                   temp.setID_GRADOALERTA(result.getInt("ID_GRADOALERTA")); 
                   temp.setID_TIPO_ALERTA(result.getInt("ID_TIPO_ALERTA")); 
                   temp.setTIPOPERSONA(result.getString("TIPOPERSONA")); 
                   temp.setDESCRIPCIONAUTORIZACION(result.getString("DESCRIPCIONAUTORIZACION")); 

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
