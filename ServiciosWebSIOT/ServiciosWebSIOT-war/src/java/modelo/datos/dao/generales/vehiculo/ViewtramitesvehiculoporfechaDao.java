package modelo.datos.dao.generales.vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generales.vehiculo.Viewtramitesvehiculoporfecha;

import utilidades.Funciones;


public class ViewtramitesvehiculoporfechaDao {


    public Viewtramitesvehiculoporfecha createValueObject() {
        return new Viewtramitesvehiculoporfecha();
    }

    public Viewtramitesvehiculoporfecha getObject(Connection conn, int ID_TRAMITEINTERNO) throws NotFoundException,
                                                                                                 SQLException {
        Viewtramitesvehiculoporfecha valueObject = createValueObject();
        valueObject.setID_TRAMITEINTERNO(ID_TRAMITEINTERNO);
        load(conn, valueObject);
        return valueObject;
    }

    public void load(Connection conn, Viewtramitesvehiculoporfecha valueObject) throws NotFoundException,
                                                                                       SQLException {
        String sql = "SELECT * FROM VIEW_TRAMITESVEHICULOPORFECHA WHERE (ID_TRAMITEINTERNO = ? ); ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_TRAMITEINTERNO());
            singleQuery(conn, stmt, valueObject);
        } finally {

        }
    }


    public List loadAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM VIEW_TRAMITESVEHICULOPORFECHA ORDER BY ID_LICTRANSITO ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }


    public synchronized void create(Connection conn, Viewtramitesvehiculoporfecha valueObject) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            sql =
"INSERT INTO VIEW_TRAMITESVEHICULOPORFECHA ( CAPACIDADTON, PLACA, ANULADA," + " FECHA, ID_LICTRANSITO, ID_TRAMITEVEH," +
  " NROCONSIGNACION, NIT, ID_CVEHICULO," + " ID_VEHICULO, ID_SERVICIO, ID_COLOR," +
  " ID_COMBUSTIBLE, NUMCONSIGNACIONVEHICULO, DESCRIPCION," + " ID_MODALIDADSERVICIO, ID_TCARROCERIA, GEN_IDTRANSITO," +
  " CAPACIDAD, REPORTAMINISTERIO, NUMRECIBO_LIQUIDACION," + " FECHA_EXP)" +
  "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            if (Funciones.contarCadena(valueObject.getCAPACIDADTON(), 10))
                stmt.setString(1, valueObject.getCAPACIDADTON());
            else
                stmt.setNull(1, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getPLACA(), 10))
                stmt.setString(2, valueObject.getPLACA());
            else
                stmt.setNull(2, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getANULADA(), 2))
                stmt.setString(3, valueObject.getANULADA());
            else
                stmt.setNull(3, Types.VARCHAR);
            if (valueObject.getFECHA() != null)
                stmt.setDate(4, new java.sql.Date(valueObject.getFECHA().getTime()));
            else
                stmt.setNull(4, Types.DATE);
            if (Funciones.contarCadena(valueObject.getID_LICTRANSITO(), 12))
                stmt.setString(5, valueObject.getID_LICTRANSITO());
            else
                stmt.setNull(5, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_TRAMITEVEH()))
                stmt.setInt(6, valueObject.getID_TRAMITEVEH());
            else
                stmt.setNull(6, Types.INTEGER);
            if (!Funciones.DoubleEsNulo(valueObject.getNROCONSIGNACION()))
                stmt.setDouble(7, valueObject.getNROCONSIGNACION());
            else
                stmt.setNull(7, Types.DOUBLE);
            if (Funciones.contarCadena(valueObject.getNIT(), 16))
                stmt.setString(8, valueObject.getNIT());
            else
                stmt.setNull(8, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_CVEHICULO()))
                stmt.setInt(9, valueObject.getID_CVEHICULO());
            else
                stmt.setNull(9, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_VEHICULO()))
                stmt.setInt(10, valueObject.getID_VEHICULO());
            else
                stmt.setNull(10, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_SERVICIO()))
                stmt.setInt(11, valueObject.getID_SERVICIO());
            else
                stmt.setNull(11, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_COLOR()))
                stmt.setInt(12, valueObject.getID_COLOR());
            else
                stmt.setNull(12, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_COMBUSTIBLE()))
                stmt.setInt(13, valueObject.getID_COMBUSTIBLE());
            else
                stmt.setNull(13, Types.INTEGER);
            if (!Funciones.DoubleEsNulo(valueObject.getNUMCONSIGNACIONVEHICULO()))
                stmt.setDouble(14, valueObject.getNUMCONSIGNACIONVEHICULO());
            else
                stmt.setNull(14, Types.DOUBLE);
            if (Funciones.contarCadena(valueObject.getDESCRIPCION(), 20))
                stmt.setString(15, valueObject.getDESCRIPCION());
            else
                stmt.setNull(15, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_MODALIDADSERVICIO()))
                stmt.setInt(16, valueObject.getID_MODALIDADSERVICIO());
            else
                stmt.setNull(16, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_TCARROCERIA()))
                stmt.setInt(17, valueObject.getID_TCARROCERIA());
            else
                stmt.setNull(17, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getGEN_IDTRANSITO()))
                stmt.setInt(18, valueObject.getGEN_IDTRANSITO());
            else
                stmt.setNull(18, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getCAPACIDAD(), 10))
                stmt.setString(19, valueObject.getCAPACIDAD());
            else
                stmt.setNull(19, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getREPORTAMINISTERIO(), 2))
                stmt.setString(20, valueObject.getREPORTAMINISTERIO());
            else
                stmt.setNull(20, Types.VARCHAR);
            if (!Funciones.DoubleEsNulo(valueObject.getNUMRECIBO_LIQUIDACION()))
                stmt.setDouble(21, valueObject.getNUMRECIBO_LIQUIDACION());
            else
                stmt.setNull(21, Types.DOUBLE);
            if (valueObject.getFECHA_EXP() != null)
                stmt.setDate(22, new java.sql.Date(valueObject.getFECHA_EXP().getTime()));
            else
                stmt.setNull(22, Types.DATE);


            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount != 1) {
                throw new SQLException("PrimaryKey Error when updating DB!");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public void save(Connection conn, Viewtramitesvehiculoporfecha valueObject) throws NotFoundException,
                                                                                       SQLException {
        PreparedStatement stmt = null;
        String sql = "";
        try {
            sql =
"UPDATE VIEW_TRAMITESVEHICULOPORFECHA SET  CAPACIDADTON = ?, PLACA = ?, ANULADA = ?," + " FECHA = ?, ID_LICTRANSITO = ?, ID_TRAMITEVEH = ?," +
  " NROCONSIGNACION = ?, NIT = ?, ID_CVEHICULO = ?," + " ID_VEHICULO = ?, ID_SERVICIO = ?, ID_COLOR = ?," +
  " ID_COMBUSTIBLE = ?, NUMCONSIGNACIONVEHICULO = ?, DESCRIPCION = ?," +
  " ID_MODALIDADSERVICIO = ?, ID_TCARROCERIA = ?, GEN_IDTRANSITO = ?," +
  " CAPACIDAD = ?, REPORTAMINISTERIO = ?, NUMRECIBO_LIQUIDACION = ?," + " FECHA_EXP = ? WHERE (ID_TRAMITEINTERNO= ?)";
            stmt = conn.prepareStatement(sql);
            if (Funciones.contarCadena(valueObject.getCAPACIDADTON(), 10))
                stmt.setString(1, valueObject.getCAPACIDADTON());
            else
                stmt.setNull(1, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getPLACA(), 10))
                stmt.setString(2, valueObject.getPLACA());
            else
                stmt.setNull(2, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getANULADA(), 2))
                stmt.setString(3, valueObject.getANULADA());
            else
                stmt.setNull(3, Types.VARCHAR);
            if (valueObject.getFECHA() != null)
                stmt.setDate(4, new java.sql.Date(valueObject.getFECHA().getTime()));
            else
                stmt.setNull(4, Types.DATE);
            if (Funciones.contarCadena(valueObject.getID_LICTRANSITO(), 12))
                stmt.setString(5, valueObject.getID_LICTRANSITO());
            else
                stmt.setNull(5, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_TRAMITEVEH()))
                stmt.setInt(6, valueObject.getID_TRAMITEVEH());
            else
                stmt.setNull(6, Types.INTEGER);
            if (!Funciones.DoubleEsNulo(valueObject.getNROCONSIGNACION()))
                stmt.setDouble(7, valueObject.getNROCONSIGNACION());
            else
                stmt.setNull(7, Types.DOUBLE);
            if (Funciones.contarCadena(valueObject.getNIT(), 16))
                stmt.setString(8, valueObject.getNIT());
            else
                stmt.setNull(8, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_CVEHICULO()))
                stmt.setInt(9, valueObject.getID_CVEHICULO());
            else
                stmt.setNull(9, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_VEHICULO()))
                stmt.setInt(10, valueObject.getID_VEHICULO());
            else
                stmt.setNull(10, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_SERVICIO()))
                stmt.setInt(11, valueObject.getID_SERVICIO());
            else
                stmt.setNull(11, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_COLOR()))
                stmt.setInt(12, valueObject.getID_COLOR());
            else
                stmt.setNull(12, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_COMBUSTIBLE()))
                stmt.setInt(13, valueObject.getID_COMBUSTIBLE());
            else
                stmt.setNull(13, Types.INTEGER);
            if (!Funciones.DoubleEsNulo(valueObject.getNUMCONSIGNACIONVEHICULO()))
                stmt.setDouble(14, valueObject.getNUMCONSIGNACIONVEHICULO());
            else
                stmt.setNull(14, Types.DOUBLE);
            if (Funciones.contarCadena(valueObject.getDESCRIPCION(), 20))
                stmt.setString(15, valueObject.getDESCRIPCION());
            else
                stmt.setNull(15, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_MODALIDADSERVICIO()))
                stmt.setInt(16, valueObject.getID_MODALIDADSERVICIO());
            else
                stmt.setNull(16, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_TCARROCERIA()))
                stmt.setInt(17, valueObject.getID_TCARROCERIA());
            else
                stmt.setNull(17, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getGEN_IDTRANSITO()))
                stmt.setInt(18, valueObject.getGEN_IDTRANSITO());
            else
                stmt.setNull(18, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getCAPACIDAD(), 10))
                stmt.setString(19, valueObject.getCAPACIDAD());
            else
                stmt.setNull(19, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getREPORTAMINISTERIO(), 2))
                stmt.setString(20, valueObject.getREPORTAMINISTERIO());
            else
                stmt.setNull(20, Types.VARCHAR);
            if (!Funciones.DoubleEsNulo(valueObject.getNUMRECIBO_LIQUIDACION()))
                stmt.setDouble(21, valueObject.getNUMRECIBO_LIQUIDACION());
            else
                stmt.setNull(21, Types.DOUBLE);
            if (valueObject.getFECHA_EXP() != null)
                stmt.setDate(22, new java.sql.Date(valueObject.getFECHA_EXP().getTime()));
            else
                stmt.setNull(22, Types.DATE);
            stmt.setInt(23, valueObject.getID_TRAMITEINTERNO());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public void delete(Connection conn, Viewtramitesvehiculoporfecha valueObject) throws NotFoundException,
                                                                                         SQLException {
        PreparedStatement stmt = null;
        String sql = "";
        try {
            sql = "DELETE FROM VIEW_TRAMITESVEHICULOPORFECHA WHERE (ID_TRAMITEINTERNO = ? )";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_TRAMITEINTERNO());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public List searchMatching(Connection conn, Viewtramitesvehiculoporfecha valueObject) throws SQLException {
        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_TRAMITESVEHICULOPORFECHA WHERE 1=1 ");
        if (valueObject.getID_TRAMITEINTERNO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_TRAMITEINTERNO= ").append(valueObject.getID_TRAMITEINTERNO()).append(" ");
        }

        if (valueObject.getCAPACIDADTON() != null && !valueObject.getCAPACIDADTON().equals("") &&
            !valueObject.getCAPACIDADTON().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND CAPACIDADTON= '").append(valueObject.getCAPACIDADTON()).append("' ");
        }

        if (valueObject.getPLACA() != null && !valueObject.getPLACA().equals("") &&
            !valueObject.getPLACA().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
        }

        if (valueObject.getANULADA() != null && !valueObject.getANULADA().equals("") &&
            !valueObject.getANULADA().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND ANULADA= '").append(valueObject.getANULADA()).append("' ");
        }

        if (valueObject.getFECHA() != null) {
            if (first) {
                first = false;
            }

            java.sql.Date fecha = new java.sql.Date(valueObject.getFECHA().getTime());
            sql.append("AND FECHA= '").append(Funciones.convFechaSQLS(fecha)).append("' ");

        }

        if (valueObject.getID_LICTRANSITO() != null && !valueObject.getID_LICTRANSITO().equals("") &&
            !valueObject.getID_LICTRANSITO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_LICTRANSITO= '").append(valueObject.getID_LICTRANSITO()).append("' ");
        }

        if (valueObject.getID_TRAMITEVEH() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_TRAMITEVEH= ").append(valueObject.getID_TRAMITEVEH()).append(" ");
        }

        if (valueObject.getNROCONSIGNACION() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND NROCONSIGNACION= ").append(valueObject.getNROCONSIGNACION()).append(" ");
        }

        if (valueObject.getNIT() != null && !valueObject.getNIT().equals("") && !valueObject.getNIT().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND NIT= '").append(valueObject.getNIT()).append("' ");
        }

        if (valueObject.getID_CVEHICULO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_CVEHICULO= ").append(valueObject.getID_CVEHICULO()).append(" ");
        }

        if (valueObject.getID_VEHICULO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_VEHICULO= ").append(valueObject.getID_VEHICULO()).append(" ");
        }

        if (valueObject.getID_SERVICIO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_SERVICIO= ").append(valueObject.getID_SERVICIO()).append(" ");
        }

        if (valueObject.getID_COLOR() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_COLOR= ").append(valueObject.getID_COLOR()).append(" ");
        }

        if (valueObject.getID_COMBUSTIBLE() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_COMBUSTIBLE= ").append(valueObject.getID_COMBUSTIBLE()).append(" ");
        }

        if (valueObject.getNUMCONSIGNACIONVEHICULO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMCONSIGNACIONVEHICULO= ").append(valueObject.getNUMCONSIGNACIONVEHICULO()).append(" ");
        }

        if (valueObject.getDESCRIPCION() != null && !valueObject.getDESCRIPCION().equals("") &&
            !valueObject.getDESCRIPCION().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND DESCRIPCION= '").append(valueObject.getDESCRIPCION()).append("' ");
        }

        if (valueObject.getID_MODALIDADSERVICIO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_MODALIDADSERVICIO= ").append(valueObject.getID_MODALIDADSERVICIO()).append(" ");
        }

        if (valueObject.getID_TCARROCERIA() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_TCARROCERIA= ").append(valueObject.getID_TCARROCERIA()).append(" ");
        }

        if (valueObject.getGEN_IDTRANSITO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND GEN_IDTRANSITO= ").append(valueObject.getGEN_IDTRANSITO()).append(" ");
        }

        if (valueObject.getCAPACIDAD() != null && !valueObject.getCAPACIDAD().equals("") &&
            !valueObject.getCAPACIDAD().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND CAPACIDAD= '").append(valueObject.getCAPACIDAD()).append("' ");
        }

        if (valueObject.getREPORTAMINISTERIO() != null && !valueObject.getREPORTAMINISTERIO().equals("") &&
            !valueObject.getREPORTAMINISTERIO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND REPORTAMINISTERIO= '").append(valueObject.getREPORTAMINISTERIO()).append("' ");
        }

        if (valueObject.getNUMRECIBO_LIQUIDACION() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMRECIBO_LIQUIDACION= ").append(valueObject.getNUMRECIBO_LIQUIDACION()).append(" ");
        }

        if (valueObject.getFECHA_EXP() != null) {
            if (first) {
                first = false;
            }

            java.sql.Date fecha = new java.sql.Date(valueObject.getFECHA_EXP().getTime());
            sql.append("AND FECHA_EXP= '").append(Funciones.convFechaSQLS(fecha)).append("' ");
        }

        if (valueObject.getGEN_HISTORIAVEHICULO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND GEN_HISTORIAVEHICULO= ").append(valueObject.getGEN_HISTORIAVEHICULO()).append(" ");
        }

        if (valueObject.getGEN_IDLICTRANSITO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND GEN_IDLICTRANSITO= ").append(valueObject.getGEN_IDLICTRANSITO()).append(" ");
        }

        sql.append("ORDER BY ID_LICTRANSITO ASC ");

        if (first)
            searchResults = new ArrayList();
        else
            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;
    }


    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {
        int result = stmt.executeUpdate();
        return result;
    }


    protected void singleQuery(Connection conn, PreparedStatement stmt,
                               Viewtramitesvehiculoporfecha valueObject) throws NotFoundException, SQLException {

        ResultSet result = null;
        try {
            result = stmt.executeQuery();
            if (result.next()) {

                valueObject.setID_TRAMITEINTERNO(result.getInt("ID_TRAMITEINTERNO"));
                valueObject.setCAPACIDADTON(result.getString("CAPACIDADTON"));
                valueObject.setPLACA(result.getString("PLACA"));
                valueObject.setANULADA(result.getString("ANULADA"));
                valueObject.setFECHA(result.getDate("FECHA"));
                valueObject.setID_LICTRANSITO(result.getString("ID_LICTRANSITO"));
                valueObject.setID_TRAMITEVEH(result.getInt("ID_TRAMITEVEH"));
                valueObject.setNROCONSIGNACION(result.getDouble("NROCONSIGNACION"));
                valueObject.setNIT(result.getString("NIT"));
                valueObject.setID_CVEHICULO(result.getInt("ID_CVEHICULO"));
                valueObject.setID_VEHICULO(result.getInt("ID_VEHICULO"));
                valueObject.setID_SERVICIO(result.getInt("ID_SERVICIO"));
                valueObject.setID_COLOR(result.getInt("ID_COLOR"));
                valueObject.setID_COMBUSTIBLE(result.getInt("ID_COMBUSTIBLE"));
                valueObject.setNUMCONSIGNACIONVEHICULO(result.getDouble("NUMCONSIGNACIONVEHICULO"));
                valueObject.setDESCRIPCION(result.getString("DESCRIPCION"));
                valueObject.setID_MODALIDADSERVICIO(result.getInt("ID_MODALIDADSERVICIO"));
                valueObject.setID_TCARROCERIA(result.getInt("ID_TCARROCERIA"));
                valueObject.setGEN_IDTRANSITO(result.getInt("GEN_IDTRANSITO"));
                valueObject.setCAPACIDAD(result.getString("CAPACIDAD"));
                valueObject.setREPORTAMINISTERIO(result.getString("REPORTAMINISTERIO"));
                valueObject.setNUMRECIBO_LIQUIDACION(result.getDouble("NUMRECIBO_LIQUIDACION"));
                valueObject.setFECHA_EXP(result.getDate("FECHA_EXP"));
                valueObject.setGEN_IDLICTRANSITO(result.getInt("GEN_IDLICTRANSITO"));
                valueObject.setGEN_HISTORIAVEHICULO(result.getInt("GEN_HISTORIAVEHICULO"));

            } else {
                throw new NotFoundException("ViewtramitesvehiculoporfechaObject Not Found!");
            }
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
    }


    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;
        try {
            result = stmt.executeQuery();
            while (result.next()) {
                Viewtramitesvehiculoporfecha temp = createValueObject();

                temp.setID_TRAMITEINTERNO(result.getInt("ID_TRAMITEINTERNO"));
                temp.setCAPACIDADTON(result.getString("CAPACIDADTON"));
                temp.setPLACA(result.getString("PLACA"));
                temp.setANULADA(result.getString("ANULADA"));
                temp.setFECHA(result.getDate("FECHA"));
                temp.setID_LICTRANSITO(result.getString("ID_LICTRANSITO"));
                temp.setID_TRAMITEVEH(result.getInt("ID_TRAMITEVEH"));
                temp.setNROCONSIGNACION(result.getDouble("NROCONSIGNACION"));
                temp.setNIT(result.getString("NIT"));
                temp.setID_CVEHICULO(result.getInt("ID_CVEHICULO"));
                temp.setID_VEHICULO(result.getInt("ID_VEHICULO"));
                temp.setID_SERVICIO(result.getInt("ID_SERVICIO"));
                temp.setID_COLOR(result.getInt("ID_COLOR"));
                temp.setID_COMBUSTIBLE(result.getInt("ID_COMBUSTIBLE"));
                temp.setNUMCONSIGNACIONVEHICULO(result.getDouble("NUMCONSIGNACIONVEHICULO"));
                temp.setDESCRIPCION(result.getString("DESCRIPCION"));
                temp.setID_MODALIDADSERVICIO(result.getInt("ID_MODALIDADSERVICIO"));
                temp.setID_TCARROCERIA(result.getInt("ID_TCARROCERIA"));
                temp.setGEN_IDTRANSITO(result.getInt("GEN_IDTRANSITO"));
                temp.setCAPACIDAD(result.getString("CAPACIDAD"));
                temp.setREPORTAMINISTERIO(result.getString("REPORTAMINISTERIO"));
                temp.setNUMRECIBO_LIQUIDACION(result.getDouble("NUMRECIBO_LIQUIDACION"));
                temp.setFECHA_EXP(result.getDate("FECHA_EXP"));
                temp.setGEN_HISTORIAVEHICULO(result.getInt("GEN_HISTORIAVEHICULO"));
                temp.setGEN_IDLICTRANSITO(result.getInt("GEN_IDLICTRANSITO"));
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
