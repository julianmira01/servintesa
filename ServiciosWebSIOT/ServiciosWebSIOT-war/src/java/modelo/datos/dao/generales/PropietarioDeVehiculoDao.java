package modelo.datos.dao.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generales.propietarioDeVehiculo.PropietarioDeVehiculo;

import utilidades.Funciones;


/**
  * PropietarioDeVehiculo Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve PropietarioDeVehiculo object instances.
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



public class PropietarioDeVehiculoDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public PropietarioDeVehiculo createValueObject() {
          return new PropietarioDeVehiculo();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public PropietarioDeVehiculo getObject(Connection conn, int ID_PROPVEHICULO) throws NotFoundException, SQLException {

          PropietarioDeVehiculo valueObject = createValueObject();
          valueObject.setID_PROPVEHICULO(ID_PROPVEHICULO);
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
    public void load(Connection conn, PropietarioDeVehiculo valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM PROPIETARIODEVEHICULO WHERE (ID_PROPVEHICULO = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getID_PROPVEHICULO()); 

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

          String sql = "SELECT * FROM PROPIETARIODEVEHICULO ORDER BY ID_PROPVEHICULO ASC ";
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
    public synchronized void 
    create(Connection conn, PropietarioDeVehiculo valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;
          

          try {
               sql = "INSERT INTO PROPIETARIODEVEHICULO ( ID_PROPVEHICULO, PLACA, FECHA, "
               + "ESTADO, ID_PROPIETARIO, EMPPER, "
               + "GEN_LICTRANSITO, ID_VEHICULO, PROPIETARIOACTUAL, "
               + "ID_TIPOPROPIEDAD, PORCENTAJEPROPIEDAD, VENDER, "
               + "PROINDIVISO, PROPIETARIOANTERIOR, FECHAFINPROPIEDAD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);
                
               stmt.setInt(1, valueObject.getID_PROPVEHICULO()); 
               if(Funciones.contarCadena(valueObject.getPLACA(), 7)) 
                stmt.setString(2, valueObject.getPLACA()); 
               else
                stmt.setNull(2, Types.VARCHAR);
               if(Funciones.esFecha(valueObject.getFECHA()))
                stmt.setDate(3, Funciones.convFechaSSQL(valueObject.getFECHA())); 
               else
                stmt.setNull(3, Types.DATE);   
               if(Funciones.contarCadena(valueObject.getESTADO(), 3))
                stmt.setString(4, valueObject.getESTADO()); 
               else
                stmt.setNull(4, Types.VARCHAR);
               if(Funciones.esEntero(String.valueOf(valueObject.getID_PROPIETARIO()))) 
                stmt.setInt(5, valueObject.getID_PROPIETARIO()); 
              else
                stmt.setNull(5, Types.INTEGER);
              if(Funciones.contarCadena(valueObject.getEMPPER(), 4))
                stmt.setString(6, valueObject.getEMPPER()); 
              else
                stmt.setNull(6, Types.VARCHAR);
            if(Funciones.esEntero(String.valueOf(valueObject.getGEN_LICTRANSITO()))) 
             stmt.setInt(7, valueObject.getGEN_LICTRANSITO()); 
            else
             stmt.setNull(7, Types.INTEGER);
            if(Funciones.esEntero(String.valueOf(valueObject.getID_VEHICULO()))) 
             stmt.setInt(8, valueObject.getID_VEHICULO()); 
            else
             stmt.setNull(8, Types.INTEGER);            
            if(Funciones.contarCadena(valueObject.getPROPIETARIOACTUAL(), 3))
              stmt.setString(9, valueObject.getPROPIETARIOACTUAL()); 
            else
              stmt.setNull(9, Types.VARCHAR);   
            if(Funciones.esEntero(String.valueOf(valueObject.getID_TIPOPROPIEDAD()))) 
             stmt.setInt(10, valueObject.getID_TIPOPROPIEDAD()); 
            else
             stmt.setNull(10, Types.INTEGER);            
            if(Funciones.esDouble(String.valueOf(valueObject.getPORCENTAJEPROPIEDAD()))) 
             stmt.setDouble(11, valueObject.getPORCENTAJEPROPIEDAD()); 
            else
             stmt.setNull(11, Types.DOUBLE);            
            if(Funciones.contarCadena(valueObject.getVENDER(), 2))
              stmt.setString(12, valueObject.getVENDER()); 
            else
              stmt.setNull(12, Types.VARCHAR);      
            if(Funciones.contarCadena(valueObject.getPROINDIVISO(), 2))
              stmt.setString(13, valueObject.getPROINDIVISO()); 
            else
              stmt.setNull(13, Types.VARCHAR);
            if(Funciones.contarCadena(valueObject.getPROPIETARIOANTERIOR(), 2))
              stmt.setString(14, valueObject.getPROPIETARIOANTERIOR()); 
            else
              stmt.setNull(14, Types.VARCHAR);   
            if(Funciones.esFecha(valueObject.getFECHAFINPROPIEDAD()))
             stmt.setDate(15, Funciones.convFechaSSQL(valueObject.getFECHAFINPROPIEDAD())); 
            else
             stmt.setNull(15, Types.DATE);
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

    public void activarDesactivar(Connection conn, PropietarioDeVehiculo valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE PROPIETARIODEVEHICULO SET ESTADO = ?, PROPIETARIOACTUAL = ? "
               + " WHERE (ID_PROPVEHICULO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getESTADO()); 
              stmt.setString(2, valueObject.getPROPIETARIOACTUAL()); 
              stmt.setInt(3, valueObject.getID_PROPVEHICULO()); 

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


    public void desvincular(Connection conn, PropietarioDeVehiculo valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE PROPIETARIODEVEHICULO SET PROPIETARIOACTUAL = ?,  VENDER = ?, "
               + "PROPIETARIOANTERIOR = ?, FECHAFINPROPIEDAD = ? WHERE (ID_PROPVEHICULO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setNull(1, Types.VARCHAR);
              //stmt.setString(1,"");
              if(Funciones.contarCadena(valueObject.getVENDER(), 1))
                stmt.setString(2, valueObject.getVENDER()); 
              else
                stmt.setNull(2, Types.VARCHAR);
              stmt.setString(3,"T"); 
              if(Funciones.esFecha(valueObject.getFECHAFINPROPIEDAD()))
                stmt.setDate(4, Funciones.convFechaSSQL(valueObject.getFECHAFINPROPIEDAD())); 
              else
                stmt.setNull(4,Types.DATE);
              stmt.setInt(5, valueObject.getID_PROPVEHICULO()); 

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
    public void save(Connection conn, PropietarioDeVehiculo valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE PROPIETARIODEVEHICULO SET PLACA = ?, FECHA = ?, ESTADO = ?, "
               + "ID_PROPIETARIO = ?, EMPPER = ?, GEN_LICTRANSITO = ?, "
               + "ID_VEHICULO = ?, PROPIETARIOACTUAL = ?, ID_TIPOPROPIEDAD = ?, "
               + "PORCENTAJEPROPIEDAD = ?, VENDER = ?, PROINDIVISO = ?, "
               + "PROPIETARIOANTERIOR = ?, FECHAFINPROPIEDAD = ? WHERE (ID_PROPVEHICULO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              
              if(valueObject.getPLACA()!=null && !valueObject.getPLACA().equals(""))
                 stmt.setString(1, valueObject.getPLACA()); 
              else
                  stmt.setNull(1, Types.NULL); 
              
              if(Funciones.esFecha(valueObject.getFECHA()))
                 stmt.setDate(2, Funciones.convFechaSSQL(valueObject.getFECHA())); 
              else
                  stmt.setNull(2, Types.NULL); 
              
              if(valueObject.getESTADO()!=null && !valueObject.getESTADO().equals(""))
                 stmt.setString(3, valueObject.getESTADO()); 
              else
                  stmt.setNull(3, Types.NULL); 
              
              if(valueObject.getID_PROPIETARIO()!=0)
                 stmt.setInt(4, valueObject.getID_PROPIETARIO()); 
              else
                  stmt.setNull(4, Types.NULL); 
              
              if(valueObject.getEMPPER()!=null && !valueObject.getEMPPER().equals(""))
                  stmt.setString(5, valueObject.getEMPPER()); 
              else
                  stmt.setNull(5, Types.NULL); 
              
              if(valueObject.getGEN_LICTRANSITO()!=0)
                  stmt.setInt(6, valueObject.getGEN_LICTRANSITO()); 
              else
                  stmt.setNull(6, Types.NULL); 
              
              if(valueObject.getID_VEHICULO()!=0)
                stmt.setInt(7, valueObject.getID_VEHICULO()); 
              else
                stmt.setNull(7, Types.NULL); 
              
              if(valueObject.getPROPIETARIOACTUAL()!=null && !valueObject.getPROPIETARIOACTUAL().equals(""))
                 stmt.setString(8, valueObject.getPROPIETARIOACTUAL()); 
              else
                 stmt.setNull(8, Types.NULL); 
              
              if(valueObject.getID_TIPOPROPIEDAD()!=0)
                 stmt.setInt(9, valueObject.getID_TIPOPROPIEDAD()); 
              else
                 stmt.setNull(9, Types.NULL); 
              
              if(valueObject.getPORCENTAJEPROPIEDAD()!=0)
                 stmt.setDouble(10, valueObject.getPORCENTAJEPROPIEDAD()); 
              else
                 stmt.setNull(10, Types.NULL); 
              
              if(valueObject.getVENDER()!=null && !valueObject.getVENDER().equals(""))
                 stmt.setString(11, valueObject.getVENDER()); 
              else
                 stmt.setNull(11,Types.NULL); 
              
              if(valueObject.getPROINDIVISO()!=null && !valueObject.getPROINDIVISO().equals(""))
                 stmt.setString(12, valueObject.getPROINDIVISO()); 
              else
                 stmt.setNull(12, Types.NULL); 
              
              if(valueObject.getPROPIETARIOANTERIOR()!=null && !valueObject.getPROPIETARIOANTERIOR().equals(""))
                 stmt.setString(13, valueObject.getPROPIETARIOANTERIOR()); 
              else
                 stmt.setNull(13, Types.NULL); 
              
              if(Funciones.esFecha(valueObject.getFECHAFINPROPIEDAD()))
                 stmt.setDate(14, Funciones.convFechaSSQL(valueObject.getFECHAFINPROPIEDAD())); 
              else
                 stmt.setNull(14, Types.NULL); 


              stmt.setInt(15, valueObject.getID_PROPVEHICULO()); 

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
    public void delete(Connection conn, PropietarioDeVehiculo valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM PROPIETARIODEVEHICULO WHERE (ID_PROPVEHICULO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID_PROPVEHICULO()); 

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

          String sql = "DELETE FROM PROPIETARIODEVEHICULO";
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

          String sql = "SELECT count(*) FROM PROPIETARIODEVEHICULO";
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
    public List searchMatching(Connection conn, PropietarioDeVehiculo valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM PROPIETARIODEVEHICULO WHERE 1=1 ");

          if (valueObject.getID_PROPVEHICULO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_PROPVEHICULO = ").append(valueObject.getID_PROPVEHICULO()).append(" ");
          }

          if (valueObject.getPLACA() != null) {
              if (first) { first = false; }
              sql.append("AND PLACA = '").append(valueObject.getPLACA()).append("' ");
          }

          if (valueObject.getFECHA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHA = '").append(valueObject.getFECHA()).append("' ");
          }

          if (valueObject.getESTADO() != null) {
              if (first) { first = false; }
              sql.append("AND ESTADO = '").append(valueObject.getESTADO()).append("' ");
          }

          if (valueObject.getID_PROPIETARIO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_PROPIETARIO = ").append(valueObject.getID_PROPIETARIO()).append(" ");
          }

          if (valueObject.getEMPPER() != null) {
              if (first) { first = false; }
              sql.append("AND EMPPER = '").append(valueObject.getEMPPER()).append("' ");
          }

          if (valueObject.getGEN_LICTRANSITO() != 0) {
              if (first) { first = false; }
              sql.append("AND GEN_LICTRANSITO = ").append(valueObject.getGEN_LICTRANSITO()).append(" ");
          }

          if (valueObject.getID_VEHICULO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_VEHICULO = ").append(valueObject.getID_VEHICULO()).append(" ");
          }

          if (valueObject.getPROPIETARIOACTUAL() != null) {
              if (first) { first = false; }
              sql.append("AND PROPIETARIOACTUAL ='").append(valueObject.getPROPIETARIOACTUAL()).append("' ");
          }

          if (valueObject.getID_TIPOPROPIEDAD() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_TIPOPROPIEDAD = ").append(valueObject.getID_TIPOPROPIEDAD()).append(" ");
          }

          if (valueObject.getPORCENTAJEPROPIEDAD() != 0) {
              if (first) { first = false; }
              sql.append("AND PORCENTAJEPROPIEDAD = ").append(valueObject.getPORCENTAJEPROPIEDAD()).append(" ");
          }

          if (valueObject.getVENDER() != null) {
              if (first) { first = false; }
              sql.append("AND VENDER = '").append(valueObject.getVENDER()).append("' ");
          }

          if (valueObject.getPROINDIVISO() != null) {
              if (first) { first = false; }
              sql.append("AND PROINDIVISO = '").append(valueObject.getPROINDIVISO()).append("' ");
          }

          if (valueObject.getPROPIETARIOANTERIOR() != null) {
              if (first) { first = false; }
              sql.append("AND PROPIETARIOANTERIOR = '").append(valueObject.getPROPIETARIOANTERIOR()).append("' ");
          }

          if (valueObject.getFECHAFINPROPIEDAD() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAFINPROPIEDAD = '").append(valueObject.getFECHAFINPROPIEDAD()).append("' ");
          }


          sql.append("ORDER BY FECHA DESC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, PropietarioDeVehiculo valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setID_PROPVEHICULO(result.getInt("ID_PROPVEHICULO")); 
                   valueObject.setPLACA(result.getString("PLACA")); 
                   valueObject.setFECHA(result.getString("FECHA")); 
                   valueObject.setESTADO(result.getString("ESTADO")); 
                   valueObject.setID_PROPIETARIO(result.getInt("ID_PROPIETARIO")); 
                   valueObject.setEMPPER(result.getString("EMPPER")); 
                   valueObject.setGEN_LICTRANSITO(result.getInt("GEN_LICTRANSITO")); 
                   valueObject.setID_VEHICULO(result.getInt("ID_VEHICULO")); 
                   valueObject.setPROPIETARIOACTUAL(result.getString("PROPIETARIOACTUAL")); 
                   valueObject.setID_TIPOPROPIEDAD(result.getInt("ID_TIPOPROPIEDAD")); 
                   valueObject.setPORCENTAJEPROPIEDAD(result.getDouble("PORCENTAJEPROPIEDAD")); 
                   valueObject.setVENDER(result.getString("VENDER")); 
                   valueObject.setPROINDIVISO(result.getString("PROINDIVISO")); 
                   valueObject.setPROPIETARIOANTERIOR(result.getString("PROPIETARIOANTERIOR")); 
                   valueObject.setFECHAFINPROPIEDAD(result.getString("FECHAFINPROPIEDAD")); 

              } else {
                    //System.out.println("PropietarioDeVehiculo Object Not Found!");
                    throw new NotFoundException("PropietarioDeVehiculo Object Not Found!");
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
                   PropietarioDeVehiculo temp = createValueObject();

                   temp.setID_PROPVEHICULO(result.getInt("ID_PROPVEHICULO")); 
                   temp.setPLACA(result.getString("PLACA")); 
                   temp.setFECHA(result.getString("FECHA")); 
                   temp.setESTADO(result.getString("ESTADO")); 
                   temp.setID_PROPIETARIO(result.getInt("ID_PROPIETARIO")); 
                   temp.setEMPPER(result.getString("EMPPER")); 
                   temp.setGEN_LICTRANSITO(result.getInt("GEN_LICTRANSITO")); 
                   temp.setID_VEHICULO(result.getInt("ID_VEHICULO")); 
                   temp.setPROPIETARIOACTUAL(result.getString("PROPIETARIOACTUAL")); 
                   temp.setID_TIPOPROPIEDAD(result.getInt("ID_TIPOPROPIEDAD")); 
                   temp.setPORCENTAJEPROPIEDAD(result.getDouble("PORCENTAJEPROPIEDAD")); 
                   temp.setVENDER(result.getString("VENDER")); 
                   temp.setPROINDIVISO(result.getString("PROINDIVISO")); 
                   temp.setPROPIETARIOANTERIOR(result.getString("PROPIETARIOANTERIOR")); 
                   temp.setFECHAFINPROPIEDAD(result.getString("FECHAFINPROPIEDAD")); 

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