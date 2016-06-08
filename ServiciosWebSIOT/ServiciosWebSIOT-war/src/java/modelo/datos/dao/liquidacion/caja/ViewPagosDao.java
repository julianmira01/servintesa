package modelo.datos.dao.liquidacion.caja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.liquidacion.caja.ViewPagos;

import utilidades.Funciones;


/**
  * ViewPagos Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve ViewPagos object instances.
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


public class ViewPagosDao {


    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public ViewPagos createValueObject() {
        return new ViewPagos();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database
     * using given Primary-Key as identifier. This method is just a convenience method
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public ViewPagos getObject(Connection conn, String NUMFACTURA) throws NotFoundException, SQLException {

        ViewPagos valueObject = createValueObject();
        valueObject.setNUMFACTURA(NUMFACTURA);
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
    public void load(Connection conn, ViewPagos valueObject) throws NotFoundException, SQLException {

        if (valueObject.getNUMFACTURA() == null) {
            //System.out.println("Can not select without Primary-Key!");
            throw new NotFoundException("Can not select without Primary-Key!");
        }

        String sql = "SELECT * FROM VIEW_PAGOS WHERE (NUMFACTURA = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, valueObject.getNUMFACTURA());

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

        String sql = "SELECT * FROM VIEW_PAGOS ORDER BY NUMFACTURA ASC ";
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
    public synchronized void create(Connection conn, ViewPagos valueObject) throws SQLException {

        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            sql =
"INSERT INTO VIEW_PAGOS ( NUMFACTURA, TOTALFACTURA, IDFACTURA, " + "IDUSRFACTURA, NUMEROCUOTA, ESTADOFACT, " +
  "FECHAFACTURA, HORAFACTURA, IDUSRPAGO, " + "VALORPAGO, FECHAPAGO, IDPAGO, " +
  "IDTIPOPAGO, APELLIDOUSR, NOMBREUSR, " + "TIPOPAGO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, valueObject.getNUMFACTURA());
            stmt.setString(2, valueObject.getTOTALFACTURA());
            stmt.setInt(3, valueObject.getIDFACTURA());
            stmt.setInt(4, valueObject.getIDUSRFACTURA());
            stmt.setInt(5, valueObject.getNUMEROCUOTA());
            stmt.setInt(6, valueObject.getESTADOFACT());
            stmt.setString(7, valueObject.getFECHAFACTURA());
            
            //stmt.setString(8, valueObject.getHORAFACTURA());
          if (Funciones.esTime(valueObject.getHORAFACTURA()))
             stmt.setTime(8,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAFACTURA())));
          else
             stmt.setNull(8, Types.TIME);
            
            stmt.setInt(9, valueObject.getIDUSRPAGO());
            stmt.setString(10, valueObject.getVALORPAGO());
            stmt.setString(11, valueObject.getFECHAPAGO());
            stmt.setInt(12, valueObject.getIDPAGO());
            stmt.setInt(13, valueObject.getIDTIPOPAGO());
            stmt.setString(14, valueObject.getAPELLIDOUSR());
            stmt.setString(15, valueObject.getNOMBREUSR());
            stmt.setString(16, valueObject.getTIPOPAGO());

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
    public void save(Connection conn, ViewPagos valueObject) throws NotFoundException, SQLException {

        String sql =
            "UPDATE VIEW_PAGOS SET TOTALFACTURA = ?, IDFACTURA = ?, IDUSRFACTURA = ?, " + "NUMEROCUOTA = ?, ESTADOFACT = ?, FECHAFACTURA = ?, " +
            "HORAFACTURA = ?, IDUSRPAGO = ?, VALORPAGO = ?, " + "FECHAPAGO = ?, IDPAGO = ?, IDTIPOPAGO = ?, " +
            "APELLIDOUSR = ?, NOMBREUSR = ?, TIPOPAGO = ? WHERE (NUMFACTURA = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, valueObject.getTOTALFACTURA());
            stmt.setInt(2, valueObject.getIDFACTURA());
            stmt.setInt(3, valueObject.getIDUSRFACTURA());
            stmt.setInt(4, valueObject.getNUMEROCUOTA());
            stmt.setInt(5, valueObject.getESTADOFACT());
            stmt.setString(6, valueObject.getFECHAFACTURA());
            
            //stmt.setString(7, valueObject.getHORAFACTURA());
          if (Funciones.esTime(valueObject.getHORAFACTURA()))
             stmt.setTime(7,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORAFACTURA())));
          else
             stmt.setNull(7, Types.TIME);
            
            stmt.setInt(8, valueObject.getIDUSRPAGO());
            stmt.setString(9, valueObject.getVALORPAGO());
            stmt.setString(10, valueObject.getFECHAPAGO());
            stmt.setInt(11, valueObject.getIDPAGO());
            stmt.setInt(12, valueObject.getIDTIPOPAGO());
            stmt.setString(13, valueObject.getAPELLIDOUSR());
            stmt.setString(14, valueObject.getNOMBREUSR());
            stmt.setString(15, valueObject.getTIPOPAGO());

            stmt.setString(16, valueObject.getNUMFACTURA());

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
    public void delete(Connection conn, ViewPagos valueObject) throws NotFoundException, SQLException {

        if (valueObject.getNUMFACTURA() == null) {
            //System.out.println("Can not delete without Primary-Key!");
            throw new NotFoundException("Can not delete without Primary-Key!");
        }

        String sql = "DELETE FROM VIEW_PAGOS WHERE (NUMFACTURA = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, valueObject.getNUMFACTURA());

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

        String sql = "DELETE FROM VIEW_PAGOS";
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

        String sql = "SELECT count(*) FROM VIEW_PAGOS";
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
    public List searchMatching(Connection conn, ViewPagos valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_PAGOS WHERE 1=1 ");

        if (valueObject.getNUMFACTURA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMFACTURA LIKE '").append(valueObject.getNUMFACTURA()).append("%' ");
        }

        if (valueObject.getTOTALFACTURA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND TOTALFACTURA LIKE '").append(valueObject.getTOTALFACTURA()).append("%' ");
        }

        if (valueObject.getIDFACTURA() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDFACTURA = ").append(valueObject.getIDFACTURA()).append(" ");
        }

        if (valueObject.getIDUSRFACTURA() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDUSRFACTURA = ").append(valueObject.getIDUSRFACTURA()).append(" ");
        }

        if (valueObject.getNUMEROCUOTA() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMEROCUOTA = ").append(valueObject.getNUMEROCUOTA()).append(" ");
        }

        if (valueObject.getESTADOFACT() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ESTADOFACT = ").append(valueObject.getESTADOFACT()).append(" ");
        }

        if (valueObject.getFECHAFACTURA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHAFACTURA LIKE '").append(valueObject.getFECHAFACTURA()).append("%' ");
        }

        if (valueObject.getHORAFACTURA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND HORAFACTURA LIKE '").append(valueObject.getHORAFACTURA()).append("%' ");
        }

        if (valueObject.getIDUSRPAGO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDUSRPAGO = ").append(valueObject.getIDUSRPAGO()).append(" ");
        }

        if (valueObject.getVALORPAGO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND VALORPAGO LIKE '").append(valueObject.getVALORPAGO()).append("%' ");
        }

        if (valueObject.getFECHAPAGO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHAPAGO LIKE '").append(valueObject.getFECHAPAGO()).append("%' ");
        }

        if (valueObject.getIDPAGO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDPAGO = ").append(valueObject.getIDPAGO()).append(" ");
        }

        if (valueObject.getIDTIPOPAGO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDTIPOPAGO = ").append(valueObject.getIDTIPOPAGO()).append(" ");
        }

        if (valueObject.getAPELLIDOUSR() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND APELLIDOUSR LIKE '").append(valueObject.getAPELLIDOUSR()).append("%' ");
        }

        if (valueObject.getNOMBREUSR() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND NOMBREUSR LIKE '").append(valueObject.getNOMBREUSR()).append("%' ");
        }

        if (valueObject.getTIPOPAGO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND TIPOPAGO LIKE '").append(valueObject.getTIPOPAGO()).append("%' ");
        }


        sql.append("ORDER BY NUMFACTURA ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt,
                               ViewPagos valueObject) throws NotFoundException, SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                valueObject.setNUMFACTURA(result.getString("NUMFACTURA"));
                valueObject.setTOTALFACTURA(result.getString("TOTALFACTURA"));
                valueObject.setIDFACTURA(result.getInt("IDFACTURA"));
                valueObject.setIDUSRFACTURA(result.getInt("IDUSRFACTURA"));
                valueObject.setNUMEROCUOTA(result.getInt("NUMEROCUOTA"));
                valueObject.setESTADOFACT(result.getInt("ESTADOFACT"));
                valueObject.setFECHAFACTURA(result.getString("FECHAFACTURA"));
                valueObject.setHORAFACTURA(result.getString("HORAFACTURA"));
                valueObject.setIDUSRPAGO(result.getInt("IDUSRPAGO"));
                valueObject.setVALORPAGO(result.getString("VALORPAGO"));
                valueObject.setFECHAPAGO(result.getString("FECHAPAGO"));
                valueObject.setIDPAGO(result.getInt("IDPAGO"));
                valueObject.setIDTIPOPAGO(result.getInt("IDTIPOPAGO"));
                valueObject.setAPELLIDOUSR(result.getString("APELLIDOUSR"));
                valueObject.setNOMBREUSR(result.getString("NOMBREUSR"));
                valueObject.setTIPOPAGO(result.getString("TIPOPAGO"));

            } else {
                //System.out.println("ViewPagos Object Not Found!");
                throw new NotFoundException("ViewPagos Object Not Found!");
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
                ViewPagos temp = createValueObject();

                temp.setNUMFACTURA(result.getString("NUMFACTURA"));
                temp.setTOTALFACTURA(result.getString("TOTALFACTURA"));
                temp.setIDFACTURA(result.getInt("IDFACTURA"));
                temp.setIDUSRFACTURA(result.getInt("IDUSRFACTURA"));
                temp.setNUMEROCUOTA(result.getInt("NUMEROCUOTA"));
                temp.setESTADOFACT(result.getInt("ESTADOFACT"));
                temp.setFECHAFACTURA(result.getString("FECHAFACTURA"));
                temp.setHORAFACTURA(result.getString("HORAFACTURA"));
                temp.setIDUSRPAGO(result.getInt("IDUSRPAGO"));
                temp.setVALORPAGO(result.getString("VALORPAGO"));
                temp.setFECHAPAGO(result.getString("FECHAPAGO"));
                temp.setIDPAGO(result.getInt("IDPAGO"));
                temp.setIDTIPOPAGO(result.getInt("IDTIPOPAGO"));
                temp.setAPELLIDOUSR(result.getString("APELLIDOUSR"));
                temp.setNOMBREUSR(result.getString("NOMBREUSR"));
                temp.setTIPOPAGO(result.getString("TIPOPAGO"));

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

    public List buscarPagos(Connection conn, ViewPagos valueObject, String fechai, String fechaf) throws SQLException {

        List searchResults;

        boolean first = true;

        

        //java.sql.Date fechaini = Funciones.convFechaSSQL(fechai);
        //java.sql.Date fechafin = Funciones.convFechaSSQL(fechaf);

        //StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_PAGOS WHERE FECHAFACTURA BETWEEN '"+fechaini+"' AND '"+fechafin+"' ");
        StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_PAGOS WHERE VIEW_PAGOS.fechapago BETWEEN '" + fechai + "' AND '" +
                             fechaf + "' ");

        if (valueObject.getNUMFACTURA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMFACTURA LIKE '").append(valueObject.getNUMFACTURA()).append("%' ");
        }

        if (valueObject.getTOTALFACTURA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND TOTALFACTURA LIKE '").append(valueObject.getTOTALFACTURA()).append("%' ");
        }

        if (valueObject.getIDFACTURA() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDFACTURA = ").append(valueObject.getIDFACTURA()).append(" ");
        }

        if (valueObject.getIDUSRFACTURA() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDUSRFACTURA = ").append(valueObject.getIDUSRFACTURA()).append(" ");
        }

        if (valueObject.getNUMEROCUOTA() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMEROCUOTA = ").append(valueObject.getNUMEROCUOTA()).append(" ");
        }

        if (valueObject.getESTADOFACT() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ESTADOFACT = ").append(valueObject.getESTADOFACT()).append(" ");
        }

        if (valueObject.getFECHAFACTURA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHAFACTURA = '").append(valueObject.getFECHAFACTURA()).append("%' ");
        }

        if (valueObject.getHORAFACTURA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND HORAFACTURA = '").append(valueObject.getHORAFACTURA()).append("%' ");
        }

        if (valueObject.getIDUSRPAGO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDUSRPAGO = ").append(valueObject.getIDUSRPAGO()).append(" ");
        }

        if (valueObject.getVALORPAGO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND VALORPAGO LIKE '").append(valueObject.getVALORPAGO()).append("%' ");
        }

        if (valueObject.getFECHAPAGO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHAPAGO = '").append(valueObject.getFECHAPAGO()).append("%' ");
        }

        if (valueObject.getIDPAGO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDPAGO = ").append(valueObject.getIDPAGO()).append(" ");
        }

        if (valueObject.getIDTIPOPAGO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDTIPOPAGO = ").append(valueObject.getIDTIPOPAGO()).append(" ");
        }

        if (valueObject.getAPELLIDOUSR() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND APELLIDOUSR LIKE '").append(valueObject.getAPELLIDOUSR()).append("%' ");
        }

        if (valueObject.getNOMBREUSR() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND NOMBREUSR LIKE '").append(valueObject.getNOMBREUSR()).append("%' ");
        }

        if (valueObject.getTIPOPAGO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND TIPOPAGO LIKE '").append(valueObject.getTIPOPAGO()).append("%' ");
        }

        sql.append("ORDER BY FECHAFACTURA, HORAFACTURA DESC ");
        System.out.println("ViewPagosDao: " + sql);

        // Prevent accidential full table results.
        // Use loadAll if all rows must be returned.
        if (first)
            searchResults = new ArrayList();
        else
            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;
    }

}