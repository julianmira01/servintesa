package modelo.datos.dao.tramites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.tramites.RuntRematricula;

import utilidades.Funciones;


/**
  * RuntRematricula Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve RuntRematricula object instances.
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



public class RuntRematriculaDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public RuntRematricula createValueObject() {
          return new RuntRematricula();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public RuntRematricula getObject(Connection conn, int ID_REMATRICULA) throws NotFoundException, SQLException {

          RuntRematricula valueObject = createValueObject();
          valueObject.setID_REMATRICULA(ID_REMATRICULA);
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
    public void load(Connection conn, RuntRematricula valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM RUNT_REMATRICULA WHERE (ID_REMATRICULA = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getID_REMATRICULA()); 

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

          String sql = "SELECT * FROM RUNT_REMATRICULA ORDER BY ID_REMATRICULA ASC ";
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
    public synchronized void create(Connection conn, RuntRematricula valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO RUNT_REMATRICULA ( ID_REMATRICULA, ID_VEHICULOREPOSICION, PLACAVEHREPONE, "
               + "ID_RUNTENTIDADREPORTA, NUMACTA, ID_MUNICIPIOEXPIDEACTA, "
               + "FECHAACTA, ID_IDENTIFICACIONENTREGA, NUMIDENTIFICACIONENTREGA, "
               + "ID_MUNICIPIOENTREGA, NOMBREAQUIENENTREGA, FECHAENTREGA, "
               + "PLACAENTREGA, ID_RUNTTIPOENTREGA, ESTADOENTREGA, "
               + "REALIZACAMBIOCOLOR, ID_COLORCAMBIA, ID_RECIBOLIQ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getID_REMATRICULA()); 
               if(!Funciones.EnteroesNulo(valueObject.getID_VEHICULOREPOSICION()))
                 stmt.setInt(2, valueObject.getID_VEHICULOREPOSICION()); 
               else
                 stmt.setNull(2, Types.INTEGER);
               if(Funciones.contarCadena(valueObject.getPLACAVEHREPONE(), 10))
                 stmt.setString(3, valueObject.getPLACAVEHREPONE()); 
               else
                 stmt.setNull(3, Types.VARCHAR);
               if(!Funciones.EnteroesNulo(valueObject.getID_RUNTENTIDADREPORTA()))
                 stmt.setInt(4, valueObject.getID_RUNTENTIDADREPORTA()); 
               else
                 stmt.setNull(4, Types.INTEGER);
               if(Funciones.contarCadena(valueObject.getNUMACTA(), 30))
                  stmt.setString(5, valueObject.getNUMACTA()); 
               else
                  stmt.setNull(5, Types.VARCHAR);
               if(!Funciones.EnteroesNulo(valueObject.getID_MUNICIPIOEXPIDEACTA()))
                  stmt.setInt(6, valueObject.getID_MUNICIPIOEXPIDEACTA()); 
               else
                  stmt.setNull(6, Types.INTEGER);
               if(Funciones.esFecha(valueObject.getFECHAACTA()))
                  stmt.setDate(7, Funciones.convFechaSSQL(valueObject.getFECHAACTA())); 
               else
                  stmt.setNull(7,Types.DATE);
               if(Funciones.contarCadena(valueObject.getID_IDENTIFICACIONENTREGA(), 5))
                  stmt.setString(8, valueObject.getID_IDENTIFICACIONENTREGA()); 
               else
                  stmt.setNull(8, Types.VARCHAR);
               if(Funciones.contarCadena(valueObject.getNUMIDENTIFICACIONENTREGA(), 50))
                  stmt.setString(9, valueObject.getNUMIDENTIFICACIONENTREGA()); 
               else
                  stmt.setNull(9, Types.VARCHAR);
               if(!Funciones.EnteroesNulo(valueObject.getID_MUNICIPIOENTREGA()))
                  stmt.setInt(10, valueObject.getID_MUNICIPIOENTREGA()); 
               else
                  stmt.setNull(10, Types.INTEGER);
               if(Funciones.contarCadena(valueObject.getNOMBREAQUIENENTREGA(), 150))
                  stmt.setString(11, valueObject.getNOMBREAQUIENENTREGA());
               else
                  stmt.setNull(11, Types.VARCHAR);
               if(Funciones.esFecha(valueObject.getFECHAENTREGA()))
                  stmt.setDate(12, Funciones.convFechaSSQL(valueObject.getFECHAENTREGA())); 
               else
                  stmt.setNull(12,Types.DATE);
               if(Funciones.contarCadena(valueObject.getPLACAENTREGA(), 10))
                  stmt.setString(13, valueObject.getPLACAENTREGA()); 
               else
                  stmt.setNull(13, Types.VARCHAR);                              
               if(!Funciones.EnteroesNulo(valueObject.getID_RUNTTIPOENTREGA()))
                  stmt.setInt(14, valueObject.getID_RUNTTIPOENTREGA());
               else
                  stmt.setNull(14, Types.INTEGER);
               if(Funciones.contarCadena(valueObject.getESTADOENTREGA(), 4000))
                  stmt.setString(15, valueObject.getESTADOENTREGA()); 
               else
                  stmt.setNull(15, Types.VARCHAR); 
               if(Funciones.contarCadena(valueObject.getREALIZACAMBIOCOLOR(), 1))
                  stmt.setString(16, valueObject.getREALIZACAMBIOCOLOR());  
               else
                  stmt.setNull(16, Types.VARCHAR);                                
               if(!Funciones.EnteroesNulo(valueObject.getID_COLORCAMBIA()))
                  stmt.setInt(17, valueObject.getID_COLORCAMBIA());
               else
                  stmt.setNull(17, Types.INTEGER);
               if(!Funciones.EnteroesNulo(valueObject.getID_RECIBOLIQ()))
                  stmt.setInt(18, valueObject.getID_RECIBOLIQ());
               else
                  stmt.setNull(18, Types.INTEGER);

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
    public void save(Connection conn, RuntRematricula valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE RUNT_REMATRICULA SET ID_VEHICULOREPOSICION = ?, PLACAVEHREPONE = ?, ID_RUNTENTIDADREPORTA = ?, "
               + "NUMACTA = ?, ID_MUNICIPIOEXPIDEACTA = ?, FECHAACTA = ?, "
               + "ID_IDENTIFICACIONENTREGA = ?, NUMIDENTIFICACIONENTREGA = ?, ID_MUNICIPIOENTREGA = ?, "
               + "NOMBREAQUIENENTREGA = ?, FECHAENTREGA = ?, PLACAENTREGA = ?, "
               + "ID_RUNTTIPOENTREGA = ?, ESTADOENTREGA = ?, REALIZACAMBIOCOLOR = ?, "
               + "ID_COLORCAMBIA = ?, ID_RECIBOLIQ = ? WHERE (ID_REMATRICULA = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID_VEHICULOREPOSICION()); 
              stmt.setString(2, valueObject.getPLACAVEHREPONE()); 
              stmt.setInt(3, valueObject.getID_RUNTENTIDADREPORTA()); 
              stmt.setString(4, valueObject.getNUMACTA()); 
              stmt.setInt(5, valueObject.getID_MUNICIPIOEXPIDEACTA()); 
              
            if (Funciones.esFecha(valueObject.getFECHAACTA()))
                stmt.setDate(6, Funciones.convFechaSSQL(valueObject.getFECHAACTA()));
            else
                stmt.setNull(6, Types.DATE);
              
              stmt.setString(7, valueObject.getID_IDENTIFICACIONENTREGA()); 
              stmt.setString(8, valueObject.getNUMIDENTIFICACIONENTREGA()); 
              stmt.setInt(9, valueObject.getID_MUNICIPIOENTREGA()); 
              stmt.setString(10, valueObject.getNOMBREAQUIENENTREGA()); 
              
            if (Funciones.esFecha(valueObject.getFECHAENTREGA()))
                stmt.setDate(11, Funciones.convFechaSSQL(valueObject.getFECHAENTREGA()));
            else
                stmt.setNull(11, Types.DATE);
              
              stmt.setString(12, valueObject.getPLACAENTREGA()); 
              stmt.setInt(13, valueObject.getID_RUNTTIPOENTREGA()); 
              stmt.setString(14, valueObject.getESTADOENTREGA()); 
              stmt.setString(15, valueObject.getREALIZACAMBIOCOLOR()); 
              stmt.setInt(16, valueObject.getID_COLORCAMBIA()); 
              stmt.setInt(17, valueObject.getID_RECIBOLIQ()); 

              stmt.setInt(18, valueObject.getID_REMATRICULA()); 

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
    public void delete(Connection conn, RuntRematricula valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM RUNT_REMATRICULA WHERE (ID_REMATRICULA = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID_REMATRICULA()); 

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

          String sql = "DELETE FROM RUNT_REMATRICULA";
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

          String sql = "SELECT count(*) FROM RUNT_REMATRICULA";
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
    public List searchMatching(Connection conn, RuntRematricula valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM RUNT_REMATRICULA WHERE 1=1 ");

          if (valueObject.getID_REMATRICULA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_REMATRICULA = ").append(valueObject.getID_REMATRICULA()).append(" ");
          }

          if (valueObject.getID_VEHICULOREPOSICION() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_VEHICULOREPOSICION = ").append(valueObject.getID_VEHICULOREPOSICION()).append(" ");
          }

          if (valueObject.getPLACAVEHREPONE() != null) {
              if (first) { first = false; }
              sql.append("AND PLACAVEHREPONE LIKE '").append(valueObject.getPLACAVEHREPONE()).append("%' ");
          }

          if (valueObject.getID_RUNTENTIDADREPORTA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_RUNTENTIDADREPORTA = ").append(valueObject.getID_RUNTENTIDADREPORTA()).append(" ");
          }

          if (valueObject.getNUMACTA() != null) {
              if (first) { first = false; }
              sql.append("AND NUMACTA LIKE '").append(valueObject.getNUMACTA()).append("%' ");
          }

          if (valueObject.getID_MUNICIPIOEXPIDEACTA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_MUNICIPIOEXPIDEACTA = ").append(valueObject.getID_MUNICIPIOEXPIDEACTA()).append(" ");
          }

          if (valueObject.getFECHAACTA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAACTA LIKE '").append(valueObject.getFECHAACTA()).append("%' ");
          }

          if (valueObject.getID_IDENTIFICACIONENTREGA() != null) {
              if (first) { first = false; }
              sql.append("AND ID_IDENTIFICACIONENTREGA LIKE '").append(valueObject.getID_IDENTIFICACIONENTREGA()).append("%' ");
          }

          if (valueObject.getNUMIDENTIFICACIONENTREGA() != null) {
              if (first) { first = false; }
              sql.append("AND NUMIDENTIFICACIONENTREGA LIKE '").append(valueObject.getNUMIDENTIFICACIONENTREGA()).append("%' ");
          }

          if (valueObject.getID_MUNICIPIOENTREGA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_MUNICIPIOENTREGA = ").append(valueObject.getID_MUNICIPIOENTREGA()).append(" ");
          }

          if (valueObject.getNOMBREAQUIENENTREGA() != null) {
              if (first) { first = false; }
              sql.append("AND NOMBREAQUIENENTREGA LIKE '").append(valueObject.getNOMBREAQUIENENTREGA()).append("%' ");
          }

          if (valueObject.getFECHAENTREGA() != null) {
              if (first) { first = false; }
              sql.append("AND FECHAENTREGA LIKE '").append(valueObject.getFECHAENTREGA()).append("%' ");
          }

          if (valueObject.getPLACAENTREGA() != null) {
              if (first) { first = false; }
              sql.append("AND PLACAENTREGA LIKE '").append(valueObject.getPLACAENTREGA()).append("%' ");
          }

          if (valueObject.getID_RUNTTIPOENTREGA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_RUNTTIPOENTREGA = ").append(valueObject.getID_RUNTTIPOENTREGA()).append(" ");
          }

          if (valueObject.getESTADOENTREGA() != null) {
              if (first) { first = false; }
              sql.append("AND ESTADOENTREGA LIKE '").append(valueObject.getESTADOENTREGA()).append("%' ");
          }

          if (valueObject.getREALIZACAMBIOCOLOR() != null) {
              if (first) { first = false; }
              sql.append("AND REALIZACAMBIOCOLOR LIKE '").append(valueObject.getREALIZACAMBIOCOLOR()).append("%' ");
          }

          if (valueObject.getID_COLORCAMBIA() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_COLORCAMBIA = ").append(valueObject.getID_COLORCAMBIA()).append(" ");
          }

          if (valueObject.getID_RECIBOLIQ() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_RECIBOLIQ = ").append(valueObject.getID_RECIBOLIQ()).append(" ");
          }


          sql.append("ORDER BY ID_REMATRICULA ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, RuntRematricula valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setID_REMATRICULA(result.getInt("ID_REMATRICULA")); 
                   valueObject.setID_VEHICULOREPOSICION(result.getInt("ID_VEHICULOREPOSICION")); 
                   valueObject.setPLACAVEHREPONE(result.getString("PLACAVEHREPONE")); 
                   valueObject.setID_RUNTENTIDADREPORTA(result.getInt("ID_RUNTENTIDADREPORTA")); 
                   valueObject.setNUMACTA(result.getString("NUMACTA")); 
                   valueObject.setID_MUNICIPIOEXPIDEACTA(result.getInt("ID_MUNICIPIOEXPIDEACTA")); 
                   valueObject.setFECHAACTA(result.getString("FECHAACTA")); 
                   valueObject.setID_IDENTIFICACIONENTREGA(result.getString("ID_IDENTIFICACIONENTREGA")); 
                   valueObject.setNUMIDENTIFICACIONENTREGA(result.getString("NUMIDENTIFICACIONENTREGA")); 
                   valueObject.setID_MUNICIPIOENTREGA(result.getInt("ID_MUNICIPIOENTREGA")); 
                   valueObject.setNOMBREAQUIENENTREGA(result.getString("NOMBREAQUIENENTREGA")); 
                   valueObject.setFECHAENTREGA(result.getString("FECHAENTREGA")); 
                   valueObject.setPLACAENTREGA(result.getString("PLACAENTREGA")); 
                   valueObject.setID_RUNTTIPOENTREGA(result.getInt("ID_RUNTTIPOENTREGA")); 
                   valueObject.setESTADOENTREGA(result.getString("ESTADOENTREGA")); 
                   valueObject.setREALIZACAMBIOCOLOR(result.getString("REALIZACAMBIOCOLOR")); 
                   valueObject.setID_COLORCAMBIA(result.getInt("ID_COLORCAMBIA")); 
                   valueObject.setID_RECIBOLIQ(result.getInt("ID_RECIBOLIQ")); 

              } else {
                    //System.out.println("RuntRematricula Object Not Found!");
                    throw new NotFoundException("RuntRematricula Object Not Found!");
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
                   RuntRematricula temp = createValueObject();

                   temp.setID_REMATRICULA(result.getInt("ID_REMATRICULA")); 
                   temp.setID_VEHICULOREPOSICION(result.getInt("ID_VEHICULOREPOSICION")); 
                   temp.setPLACAVEHREPONE(result.getString("PLACAVEHREPONE")); 
                   temp.setID_RUNTENTIDADREPORTA(result.getInt("ID_RUNTENTIDADREPORTA")); 
                   temp.setNUMACTA(result.getString("NUMACTA")); 
                   temp.setID_MUNICIPIOEXPIDEACTA(result.getInt("ID_MUNICIPIOEXPIDEACTA")); 
                   temp.setFECHAACTA(result.getString("FECHAACTA")); 
                   temp.setID_IDENTIFICACIONENTREGA(result.getString("ID_IDENTIFICACIONENTREGA")); 
                   temp.setNUMIDENTIFICACIONENTREGA(result.getString("NUMIDENTIFICACIONENTREGA")); 
                   temp.setID_MUNICIPIOENTREGA(result.getInt("ID_MUNICIPIOENTREGA")); 
                   temp.setNOMBREAQUIENENTREGA(result.getString("NOMBREAQUIENENTREGA")); 
                   temp.setFECHAENTREGA(result.getString("FECHAENTREGA")); 
                   temp.setPLACAENTREGA(result.getString("PLACAENTREGA")); 
                   temp.setID_RUNTTIPOENTREGA(result.getInt("ID_RUNTTIPOENTREGA")); 
                   temp.setESTADOENTREGA(result.getString("ESTADOENTREGA")); 
                   temp.setREALIZACAMBIOCOLOR(result.getString("REALIZACAMBIOCOLOR")); 
                   temp.setID_COLORCAMBIA(result.getInt("ID_COLORCAMBIA")); 
                   temp.setID_RECIBOLIQ(result.getInt("ID_RECIBOLIQ")); 

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
