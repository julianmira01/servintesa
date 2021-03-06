package modelo.datos.dao.reportes;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.reportes.Reportetramites;

import utilidades.Funciones;


/**
  * Reportetramites Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve Reportetramites object instances.
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


public class ReportetramitesDao {


    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public Reportetramites createValueObject() {
        return new Reportetramites();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database
     * using given Primary-Key as identifier. This method is just a convenience method
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public Reportetramites getObject(Connection conn, int ID_FACTURA) throws NotFoundException, SQLException {

        Reportetramites valueObject = createValueObject();
        valueObject.setID_FACTURA(ID_FACTURA);
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
    public void load(Connection conn, Reportetramites valueObject) throws NotFoundException, SQLException {

        String sql = "SELECT * FROM REPORTE_TRAMITES WHERE (ID_FACTURA = ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_FACTURA());

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

        String sql = "SELECT * FROM REPORTE_TRAMITES ORDER BY TIPOTRAMITE, TRAMITE, FECHATRAMITE, ESTADO ";
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
    public synchronized void create(Connection conn, Reportetramites valueObject) throws SQLException {

        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;


        try {
            sql =
"INSERT INTO REPORTE_TRAMITES ( ID_FACTURA,ID_TRAMITE,COD_TIPOTRAMITE,TIPOTRAMITE,TRAMITE,FECHATRAMITE, " +
  "ID_ESTADO,ESTADO,FACTURA,VALOR,FECHAPAGO,PLACA,CLASEVEH,MARCAVEH,LINEAVEH,MODELO, COLORVEH, CILINDRAJE,TIPOCARROCERIA, " +
  "CAPACIDAD, CAPACIDADTON, NUMEROMOTOR, NUMEROCHASIS, SERVICIOVEH, NUMERO_CANCELACION, FECHA_CANCELACION, ORG_DESTINO_TRASLADO, " +
"FEC_CAMBIO_SERVICIO, DOCUMENTO, IDENTI_SOLICI, PERSONA_SOLICI, EMAIL_SOLICI,  TEL_SOLICI, DIR_SOLICI, CIUDAD_SOLICI, IDENTI_PROP_PER, " +
"    NOMBRE_PROP_PER, NIT_PROP_EMP, RAZ_SOC_PRO_EMP) " +
" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, valueObject.getID_FACTURA());
            stmt.setInt(2, valueObject.getID_TRAMITE());
            stmt.setString(3, valueObject.getCOD_TIPOTRAMITE());
            stmt.setString(4, valueObject.getTIPOTRAMITE());
            stmt.setString(5, valueObject.getTRAMITE());
            
            if (Funciones.esFecha(valueObject.getFECHATRAMITE()))
              stmt.setDate(6, Funciones.convFechaSSQL(valueObject.getFECHATRAMITE()));
            else
              stmt.setNull(6, Types.DATE);
            
            stmt.setInt(7, valueObject.getID_ESTADO());
            stmt.setString(8, valueObject.getESTADO());
            stmt.setString(9, valueObject.getFACTURA());
            stmt.setDouble(10, valueObject.getVALOR());
            
            if (Funciones.esFecha(valueObject.getFECHAPAGO()))
              stmt.setDate(11, Funciones.convFechaSSQL(valueObject.getFECHAPAGO()));
            else
              stmt.setNull(11, Types.DATE);
            
            stmt.setString(12, valueObject.getPLACA());
            stmt.setString(13, valueObject.getCLASEVEH());
            stmt.setString(14, valueObject.getMARCAVEH());
            stmt.setString(15, valueObject.getLINEAVEH());
            stmt.setString(16, valueObject.getMODELO());
            stmt.setString(17, valueObject.getCOLORVEH());
            stmt.setString(18, valueObject.getCILINDRAJE());
            stmt.setString(19, valueObject.getTIPOCARROCERIA());
            //
            stmt.setString(20, valueObject.getCAPACIDAD());
            stmt.setString(21, valueObject.getCAPACIDADTON());
            
            stmt.setString(22, valueObject.getNUMEROMOTOR());
            stmt.setString(23, valueObject.getNUMEROCHASIS());
            stmt.setString(24, valueObject.getSERVICIOVEH());
            stmt.setString(25, valueObject.getNUMERO_CANCELACION());
            stmt.setString(26, valueObject.getFECHA_CANCELACION());
            stmt.setString(27, valueObject.getORG_DESTINO_TRASLADO());
            stmt.setString(28, valueObject.getFECHA_CANCELACION());
            stmt.setString(29, valueObject.getDOCUMENTO());
            stmt.setString(30, valueObject.getIDENTI_SOLICI());
            stmt.setString(31, valueObject.getPERSONA_SOLICI());
            stmt.setString(32, valueObject.getEMAIL_SOLICI());
            stmt.setString(33, valueObject.getTEL_SOLICI());
            stmt.setString(34, valueObject.getDIR_SOLICI());
            stmt.setString(35, valueObject.getCIUDAD_SOLICI());
            stmt.setString(36, valueObject.getIDENTI_PROP_PER());
            stmt.setString(37, valueObject.getNOMBRE_PROP_PER());
            stmt.setString(38, valueObject.getNIT_PROP_EMP());
            stmt.setString(39, valueObject.getRAZ_SOC_PRO_EMP());
            
            
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
    public void save(Connection conn, Reportetramites valueObject) throws NotFoundException, SQLException {

        /*String sql =
            "UPDATE REPORTE_TRAMITES SET ID_TRAMITE = ?, COD_TIPOTRAMITE = ?, TIPOTRAMITE = ?, " + "TRAMITE = ?, FECHATRAMITE = ?, ID_ESTADO = ?, " +
            "ESTADO = ?, FACTURA = ?, VALOR = ?, " + "FECHAPAGO = ?, PLACA = ?, DOCUMENTO = ?, " +
            "IDENTIFICACION = ?, PERSONA = ? WHERE (ID_FACTURA = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_TRAMITE());
            stmt.setString(2, valueObject.getCOD_TIPOTRAMITE());
            stmt.setString(3, valueObject.getTIPOTRAMITE());
            stmt.setString(4, valueObject.getTRAMITE());
            
          if (Funciones.esFecha(valueObject.getFECHATRAMITE()))
            stmt.setDate(5, Funciones.convFechaSSQL(valueObject.getFECHATRAMITE()));
          else
            stmt.setNull(5, Types.DATE);
            
            stmt.setInt(6, valueObject.getID_ESTADO());
            stmt.setString(7, valueObject.getESTADO());
            stmt.setString(8, valueObject.getFACTURA());
            stmt.setDouble(9, valueObject.getVALOR());
            
          if (Funciones.esFecha(valueObject.getFECHAPAGO()))
            stmt.setDate(10, Funciones.convFechaSSQL(valueObject.getFECHAPAGO()));
          else
            stmt.setNull(10, Types.DATE);
            
            stmt.setString(11, valueObject.getPLACA());
            stmt.setString(12, valueObject.getDOCUMENTO());
            stmt.setString(13, valueObject.getIDENTIFICACION());
            stmt.setString(14, valueObject.getPERSONA());

            stmt.setInt(15, valueObject.getID_FACTURA());

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
        }*/
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
    public void delete(Connection conn, Reportetramites valueObject) throws NotFoundException, SQLException {

        String sql = "DELETE FROM REPORTE_TRAMITES WHERE (ID_FACTURA = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_FACTURA());

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

        String sql = "DELETE FROM REPORTE_TRAMITES";
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

        String sql = "SELECT count(*) FROM REPORTE_TRAMITES";
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
    public List searchMatching(Connection conn, Reportetramites valueObject, String fechaTramiteIni,
                               String fechaTramiteFin, String fechaPagoIni, String fechaPagoFin) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM REPORTE_TRAMITES WHERE 1=1 ");

        if (valueObject.getID_FACTURA() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_FACTURA = ").append(valueObject.getID_FACTURA()).append(" ");
        }

        if (valueObject.getID_TRAMITE() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_TRAMITE = ").append(valueObject.getID_TRAMITE()).append(" ");
        }

        if (valueObject.getCOD_TIPOTRAMITE() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND COD_TIPOTRAMITE = '").append(valueObject.getCOD_TIPOTRAMITE()).append("' ");
        }

        if (valueObject.getTIPOTRAMITE() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND TIPOTRAMITE = '").append(valueObject.getTIPOTRAMITE()).append("' ");
        }

        if (valueObject.getTRAMITE() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND TRAMITE = '").append(valueObject.getTRAMITE()).append("' ");
        }

        if (valueObject.getFECHATRAMITE() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHATRAMITE = '").append(valueObject.getFECHATRAMITE()).append("' ");
        }

        if (valueObject.getID_ESTADO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_ESTADO = ").append(valueObject.getID_ESTADO()).append(" ");
        }

        if (valueObject.getESTADO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND ESTADO = '").append(valueObject.getESTADO()).append("' ");
        }

        if (valueObject.getFACTURA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND FACTURA = '").append(valueObject.getFACTURA()).append("' ");
        }

        if (valueObject.getVALOR() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND VALOR = ").append(valueObject.getVALOR()).append(" ");
        }

        if (valueObject.getFECHAPAGO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHAPAGO = '").append(valueObject.getFECHAPAGO()).append("' ");
        }

        if (valueObject.getPLACA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND PLACA = '").append(valueObject.getPLACA()).append("' ");
        }

        if (valueObject.getDOCUMENTO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND DOCUMENTO = '").append(valueObject.getDOCUMENTO()).append("' ");
        }

        if (fechaTramiteIni != null && !fechaTramiteIni.equals("") && fechaTramiteFin != null &&
            !fechaTramiteFin.equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHATRAMITE BETWEEN '").append(fechaTramiteIni).append("' AND '").append(fechaTramiteFin).append("' ");
        }

        if (fechaPagoIni != null && !fechaPagoIni.equals("") && fechaPagoFin != null &&
            !fechaPagoFin.equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHAPAGO BETWEEN '").append(fechaTramiteIni).append("' AND '").append(fechaTramiteFin).append("' ");
        }


        sql.append("ORDER BY TIPOTRAMITE, TRAMITE, FECHATRAMITE, ESTADO ");

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
                               Reportetramites valueObject) throws NotFoundException, SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                valueObject.setCAPACIDAD(result.getString("CAPACIDAD"));
                valueObject.setCAPACIDADTON(result.getString("CAPACIDADTON"));
                valueObject.setCILINDRAJE(result.getString("CILINDRAJE"));
                valueObject.setCIUDAD_SOLICI(result.getString("CIUDAD_SOLICI"));
                valueObject.setCLASEVEH(result.getString("CLASEVEH"));
                valueObject.setCOD_TIPOTRAMITE(result.getString("COD_TIPOTRAMITE"));
                valueObject.setCOLORVEH(result.getString("COLORVEH"));
                valueObject.setDIR_SOLICI(result.getString("DIR_SOLICI"));
                valueObject.setDOCUMENTO(result.getString("DOCUMENTO"));
                valueObject.setEMAIL_SOLICI(result.getString("EMAIL_SOLICI"));
                valueObject.setESTADO(result.getString("ESTADO"));
                valueObject.setFACTURA(result.getString("FACTURA"));
                valueObject.setFECHAPAGO(result.getString("FECHAPAGO"));
                valueObject.setFECHATRAMITE(result.getString("FECHATRAMITE"));
                valueObject.setFECHA_CANCELACION(result.getString("FECHA_CANCELACION"));
                valueObject.setFEC_CAMBIO_SERVICIO(result.getString("FEC_CAMBIO_SERVICIO"));
                valueObject.setIDENTI_PROP_PER(result.getString("IDENTI_PROP_PER"));
                valueObject.setIDENTI_SOLICI(result.getString("IDENTI_SOLICI"));
                valueObject.setID_ESTADO(result.getInt("ID_ESTADO"));
                valueObject.setID_FACTURA(result.getInt("ID_FACTURA"));
                valueObject.setID_TRAMITE(result.getInt("ID_TRAMITE"));
                valueObject.setLINEAVEH(result.getString("LINEAVEH"));
                valueObject.setMARCAVEH(result.getString("MARCAVEH"));
                valueObject.setMODELO(result.getString("MODELO"));
                valueObject.setNIT_PROP_EMP(result.getString("NIT_PROP_EMP"));
                valueObject.setNOMBRE_PROP_PER(result.getString("NOMBRE_PROP_PER"));
                valueObject.setNUMEROCHASIS(result.getString("NUMEROCHASIS"));
                valueObject.setNUMEROMOTOR(result.getString("NUMEROMOTOR"));
                valueObject.setNUMERO_CANCELACION(result.getString("NUMERO_CANCELACION"));
                valueObject.setORG_DESTINO_TRASLADO(result.getString("ORG_DESTINO_TRASLADO"));
                valueObject.setPERSONA_SOLICI(result.getString("PERSONA_SOLICI"));
                valueObject.setPLACA(result.getString("PLACA"));
                valueObject.setRAZ_SOC_PRO_EMP(result.getString("RAZ_SOC_PRO_EMP"));
                valueObject.setSERVICIOVEH(result.getString("SERVICIOVEH"));
                valueObject.setTEL_SOLICI(result.getString("TEL_SOLICI"));
                valueObject.setTIPOCARROCERIA(result.getString("TIPOCARROCERIA"));
                valueObject.setTIPOTRAMITE(result.getString("TIPOTRAMITE"));
                valueObject.setTRAMITE(result.getString("TRAMITE"));
                valueObject.setVALOR(result.getDouble("VALOR"));


            } else {
                //System.out.println("Reportetramites Object Not Found!");
                throw new NotFoundException("Reportetramites Object Not Found!");
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
                Reportetramites temp = createValueObject();

                temp.setCAPACIDAD(result.getString("CAPACIDAD"));
                temp.setCAPACIDADTON(result.getString("CAPACIDADTON"));
                temp.setCILINDRAJE(result.getString("CILINDRAJE"));
                temp.setCIUDAD_SOLICI(result.getString("CIUDAD_SOLICI"));
                temp.setCLASEVEH(result.getString("CLASEVEH"));
                temp.setCOD_TIPOTRAMITE(result.getString("COD_TIPOTRAMITE"));
                temp.setCOLORVEH(result.getString("COLORVEH"));
                temp.setDIR_SOLICI(result.getString("DIR_SOLICI"));
                temp.setDOCUMENTO(result.getString("DOCUMENTO"));
                temp.setEMAIL_SOLICI(result.getString("EMAIL_SOLICI"));
                temp.setESTADO(result.getString("ESTADO"));
                temp.setFACTURA(result.getString("FACTURA"));
                temp.setFECHAPAGO(result.getString("FECHAPAGO"));
                temp.setFECHATRAMITE(result.getString("FECHATRAMITE"));
                temp.setFECHA_CANCELACION(result.getString("FECHA_CANCELACION"));
                temp.setFEC_CAMBIO_SERVICIO(result.getString("FEC_CAMBIO_SERVICIO"));
                temp.setIDENTI_PROP_PER(result.getString("IDENTI_PROP_PER"));
                temp.setIDENTI_SOLICI(result.getString("IDENTI_SOLICI"));
                temp.setID_ESTADO(result.getInt("ID_ESTADO"));
                temp.setID_FACTURA(result.getInt("ID_FACTURA"));
                temp.setID_TRAMITE(result.getInt("ID_TRAMITE"));
                temp.setLINEAVEH(result.getString("LINEAVEH"));
                temp.setMARCAVEH(result.getString("MARCAVEH"));
                temp.setMODELO(result.getString("MODELO"));
                temp.setNIT_PROP_EMP(result.getString("NIT_PROP_EMP"));
                temp.setNOMBRE_PROP_PER(result.getString("NOMBRE_PROP_PER"));
                temp.setNUMEROCHASIS(result.getString("NUMEROCHASIS"));
                temp.setNUMEROMOTOR(result.getString("NUMEROMOTOR"));
                temp.setNUMERO_CANCELACION(result.getString("NUMERO_CANCELACION"));
                temp.setORG_DESTINO_TRASLADO(result.getString("ORG_DESTINO_TRASLADO"));
                temp.setPERSONA_SOLICI(result.getString("PERSONA_SOLICI"));
                temp.setPLACA(result.getString("PLACA"));
                temp.setRAZ_SOC_PRO_EMP(result.getString("RAZ_SOC_PRO_EMP"));
                temp.setSERVICIOVEH(result.getString("SERVICIOVEH"));
                temp.setTEL_SOLICI(result.getString("TEL_SOLICI"));
                temp.setTIPOCARROCERIA(result.getString("TIPOCARROCERIA"));
                temp.setTIPOTRAMITE(result.getString("TIPOTRAMITE"));
                temp.setTRAMITE(result.getString("TRAMITE"));
                temp.setVALOR(result.getDouble("VALOR"));

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


