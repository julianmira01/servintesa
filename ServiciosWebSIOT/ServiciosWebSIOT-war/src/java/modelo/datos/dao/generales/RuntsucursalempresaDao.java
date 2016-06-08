package modelo.datos.dao.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generales.Runtsucursalempresa;

import utilidades.Funciones;


public class RuntsucursalempresaDao {


    public Runtsucursalempresa createValueObject() {
        return new Runtsucursalempresa();
    }

    public Runtsucursalempresa getObject(Connection conn, int ID_RUNTSUCURSAL) throws NotFoundException, SQLException {
        Runtsucursalempresa valueObject = createValueObject();
        valueObject.setID_RUNTSUCURSAL(ID_RUNTSUCURSAL);
        load(conn, valueObject);
        return valueObject;
    }

    public void load(Connection conn, Runtsucursalempresa valueObject) throws NotFoundException, SQLException {
        String sql = "SELECT * FROM RUNTSUCURSAL_EMPRESA WHERE (ID_RUNTSUCURSAL = ? )";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_RUNTSUCURSAL());
            singleQuery(conn, stmt, valueObject);
        } finally {

        }
    }


    public List loadAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM RUNTSUCURSAL_EMPRESA ORDER BY ID_RUNTSUCURSAL ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }


    public synchronized void create(Connection conn, Runtsucursalempresa valueObject) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            sql =
"INSERT INTO RUNTSUCURSAL_EMPRESA ( ID_RUNTSUCURSAL," + " RAZON_SOCIAL, SIGLA, CELULAR," + " ID_SUCURSAL, EMPRESA, ID_REPRESENTANTE," +
  " EMAIL, ID_TIPOSOCIEDAD)" + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_RUNTSUCURSAL());
            if (Funciones.contarCadena(valueObject.getRAZON_SOCIAL(), 100))
                stmt.setString(2, valueObject.getRAZON_SOCIAL());
            else
                stmt.setNull(2, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getSIGLA(), 35))
                stmt.setString(3, valueObject.getSIGLA());
            else
                stmt.setNull(3, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getCELULAR(), 50))
                stmt.setString(4, valueObject.getCELULAR());
            else
                stmt.setNull(4, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_SUCURSAL()))
                stmt.setInt(5, valueObject.getID_SUCURSAL());
            else
                stmt.setNull(5, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getEMPRESA()))
                stmt.setInt(6, valueObject.getEMPRESA());
            else
                stmt.setNull(6, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_REPRESENTANTE()))
                stmt.setInt(7, valueObject.getID_REPRESENTANTE());
            else
                stmt.setNull(7, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getEMAIL(), 80))
                stmt.setString(8, valueObject.getEMAIL());
            else
                stmt.setNull(8, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_TIPOSOCIEDAD()))
                stmt.setInt(9, valueObject.getID_TIPOSOCIEDAD());
            else
                stmt.setNull(9, Types.INTEGER);


            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount != 1) {
                throw new SQLException("PrimaryKey Error when updating DB!");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public void save(Connection conn, Runtsucursalempresa valueObject) throws NotFoundException, SQLException {
        PreparedStatement stmt = null;
        String sql = "";
        try {
            sql =
"UPDATE RUNTSUCURSAL_EMPRESA SET  RAZON_SOCIAL = ?, SIGLA = ?, CELULAR = ?," + " ID_SUCURSAL = ?, EMPRESA = ?, ID_REPRESENTANTE = ?," +
  " EMAIL = ?, ID_TIPOSOCIEDAD = ? WHERE (ID_RUNTSUCURSAL= ?)";
            if (Funciones.contarCadena(valueObject.getRAZON_SOCIAL(), 100))
                stmt.setString(1, valueObject.getRAZON_SOCIAL());
            else
                stmt.setNull(1, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getSIGLA(), 35))
                stmt.setString(2, valueObject.getSIGLA());
            else
                stmt.setNull(2, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getCELULAR(), 50))
                stmt.setString(3, valueObject.getCELULAR());
            else
                stmt.setNull(3, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_SUCURSAL()))
                stmt.setInt(4, valueObject.getID_SUCURSAL());
            else
                stmt.setNull(4, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getEMPRESA()))
                stmt.setInt(5, valueObject.getEMPRESA());
            else
                stmt.setNull(5, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_REPRESENTANTE()))
                stmt.setInt(6, valueObject.getID_REPRESENTANTE());
            else
                stmt.setNull(6, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getEMAIL(), 80))
                stmt.setString(7, valueObject.getEMAIL());
            else
                stmt.setNull(7, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_TIPOSOCIEDAD()))
                stmt.setInt(8, valueObject.getID_TIPOSOCIEDAD());
            else
                stmt.setNull(8, Types.INTEGER);
            stmt.setInt(9, valueObject.getID_RUNTSUCURSAL());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public void delete(Connection conn, Runtsucursalempresa valueObject) throws NotFoundException, SQLException {
        PreparedStatement stmt = null;
        String sql = "";
        try {
            sql = "DELETE FROM RUNTSUCURSAL_EMPRESA WHERE (ID_RUNTSUCURSAL = ? )";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_RUNTSUCURSAL());

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


    public List searchMatching(Connection conn, Runtsucursalempresa valueObject) throws SQLException {
        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM RUNTSUCURSAL_EMPRESA WHERE 1=1 ");
        if (valueObject.getID_RUNTSUCURSAL() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_RUNTSUCURSAL= ").append(valueObject.getID_RUNTSUCURSAL()).append(" ");
        }

        if (valueObject.getRAZON_SOCIAL() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND RAZON_SOCIAL= '").append(valueObject.getRAZON_SOCIAL()).append("' ");
        }

        if (valueObject.getSIGLA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND SIGLA= '").append(valueObject.getSIGLA()).append("' ");
        }

        if (valueObject.getCELULAR() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND CELULAR= '").append(valueObject.getCELULAR()).append("' ");
        }

        if (valueObject.getID_SUCURSAL() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_SUCURSAL= ").append(valueObject.getID_SUCURSAL()).append(" ");
        }

        if (valueObject.getEMPRESA() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND EMPRESA= ").append(valueObject.getEMPRESA()).append(" ");
        }

        if (valueObject.getID_REPRESENTANTE() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_REPRESENTANTE= ").append(valueObject.getID_REPRESENTANTE()).append(" ");
        }

        if (valueObject.getEMAIL() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND EMAIL= '").append(valueObject.getEMAIL()).append("' ");
        }

        if (valueObject.getID_TIPOSOCIEDAD() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_TIPOSOCIEDAD= ").append(valueObject.getID_TIPOSOCIEDAD()).append(" ");
        }

        sql.append("ORDER BY ID_RUNTSUCURSAL ASC ");

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
                               Runtsucursalempresa valueObject) throws NotFoundException, SQLException {

        ResultSet result = null;
        try {
            result = stmt.executeQuery();
            if (result.next()) {

                valueObject.setID_RUNTSUCURSAL(result.getInt("ID_RUNTSUCURSAL"));
                valueObject.setRAZON_SOCIAL(result.getString("RAZON_SOCIAL"));
                valueObject.setSIGLA(result.getString("SIGLA"));
                valueObject.setCELULAR(result.getString("CELULAR"));
                valueObject.setID_SUCURSAL(result.getInt("ID_SUCURSAL"));
                valueObject.setEMPRESA(result.getInt("EMPRESA"));
                valueObject.setID_REPRESENTANTE(result.getInt("ID_REPRESENTANTE"));
                valueObject.setEMAIL(result.getString("EMAIL"));
                valueObject.setID_TIPOSOCIEDAD(result.getInt("ID_TIPOSOCIEDAD"));

            } else {
                throw new NotFoundException("RuntsucursalempresaObject Not Found!");
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
                Runtsucursalempresa temp = createValueObject();
    
                temp.setID_RUNTSUCURSAL(result.getInt("ID_RUNTSUCURSAL"));
                temp.setRAZON_SOCIAL(result.getString("RAZON_SOCIAL"));
                temp.setSIGLA(result.getString("SIGLA"));
                temp.setCELULAR(result.getString("CELULAR"));
                temp.setID_SUCURSAL(result.getInt("ID_SUCURSAL"));
                temp.setEMPRESA(result.getInt("EMPRESA"));
                temp.setID_REPRESENTANTE(result.getInt("ID_REPRESENTANTE"));
                temp.setEMAIL(result.getString("EMAIL"));
                temp.setID_TIPOSOCIEDAD(result.getInt("ID_TIPOSOCIEDAD"));
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
