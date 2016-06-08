package modelo.datos.dao.tramites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.tramites.Runtpersonaapoderado;

import utilidades.Funciones;


public class RuntpersonaapoderadoDao {


    public Runtpersonaapoderado createValueObject() {
        return new Runtpersonaapoderado();
    }

    public Runtpersonaapoderado getObject(Connection conn, int ID_PERSONAAPODERADO) throws NotFoundException,
                                                                                           SQLException {
        Runtpersonaapoderado valueObject = createValueObject();
        valueObject.setID_PERSONAAPODERADO(ID_PERSONAAPODERADO);
        load(conn, valueObject);
        return valueObject;
    }

    public void load(Connection conn, Runtpersonaapoderado valueObject) throws NotFoundException, SQLException {
        String sql = "SELECT * FROM RUNT_PERSONAAPODERADO WHERE (ID_PERSONAAPODERADO = ? )";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_PERSONAAPODERADO());
            singleQuery(conn, stmt, valueObject);
        } finally {

        }
    }


    public List loadAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM RUNT_PERSONAAPODERADO ORDER BY ID_PERSONAAPODERADO ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }


    public synchronized void create(Connection conn, Runtpersonaapoderado valueObject) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            sql =
"INSERT INTO RUNT_PERSONAAPODERADO ( ID_PERSONAAPODERADO," + " ID_RECIBOLIQ, ID_APODERADO, ID_PROPIETARIO," +
  " TIPOPROP, ESTADOPROP)" + "VALUES ( ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_PERSONAAPODERADO());
            if (!Funciones.EnteroesNulo(valueObject.getID_RECIBOLIQ()))
                stmt.setInt(2, valueObject.getID_RECIBOLIQ());
            else
                stmt.setNull(2, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_APODERADO()))
                stmt.setInt(3, valueObject.getID_APODERADO());
            else
                stmt.setNull(3, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_PROPIETARIO()))
                stmt.setInt(4, valueObject.getID_PROPIETARIO());
            else
                stmt.setNull(4, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getTIPOPROP(), 5))
                stmt.setString(5, valueObject.getTIPOPROP());
            else
                stmt.setNull(5, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getESTADOPROP(), 15))
                stmt.setString(6, valueObject.getESTADOPROP());
            else
                stmt.setNull(6, Types.VARCHAR);


            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount != 1) {
                throw new SQLException("PrimaryKey Error when updating DB!");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public void save(Connection conn, Runtpersonaapoderado valueObject) throws NotFoundException, SQLException {
        PreparedStatement stmt = null;
        String sql = "";
        try {
            sql =
"UPDATE RUNT_PERSONAAPODERADO SET  ID_RECIBOLIQ = ?, ID_APODERADO = ?, ID_PROPIETARIO = ?," + " TIPOPROP = ?, ESTADOPROP = ? WHERE (ID_PERSONAAPODERADO= ?)";
            if (!Funciones.EnteroesNulo(valueObject.getID_RECIBOLIQ()))
                stmt.setInt(1, valueObject.getID_RECIBOLIQ());
            else
                stmt.setNull(1, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_APODERADO()))
                stmt.setInt(2, valueObject.getID_APODERADO());
            else
                stmt.setNull(2, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_PROPIETARIO()))
                stmt.setInt(3, valueObject.getID_PROPIETARIO());
            else
                stmt.setNull(3, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getTIPOPROP(), 5))
                stmt.setString(4, valueObject.getTIPOPROP());
            else
                stmt.setNull(4, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getESTADOPROP(), 15))
                stmt.setString(5, valueObject.getESTADOPROP());
            else
                stmt.setNull(5, Types.VARCHAR);
            stmt.setInt(6, valueObject.getID_PERSONAAPODERADO());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public void delete(Connection conn, Runtpersonaapoderado valueObject) throws NotFoundException, SQLException {
        PreparedStatement stmt = null;
        String sql = "";
        try {
            sql = "DELETE FROM RUNT_PERSONAAPODERADO WHERE (ID_PERSONAAPODERADO = ? )";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_PERSONAAPODERADO());

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


    public List searchMatching(Connection conn, Runtpersonaapoderado valueObject) throws SQLException {
        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM RUNT_PERSONAAPODERADO WHERE 1=1 ");
        if (valueObject.getID_PERSONAAPODERADO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_PERSONAAPODERADO= ").append(valueObject.getID_PERSONAAPODERADO()).append(" ");
        }

        if (valueObject.getID_RECIBOLIQ() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_RECIBOLIQ= ").append(valueObject.getID_RECIBOLIQ()).append(" ");
        }

        if (valueObject.getID_APODERADO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_APODERADO= ").append(valueObject.getID_APODERADO()).append(" ");
        }

        if (valueObject.getID_PROPIETARIO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_PROPIETARIO= ").append(valueObject.getID_PROPIETARIO()).append(" ");
        }

        if (valueObject.getTIPOPROP() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND TIPOPROP= '").append(valueObject.getTIPOPROP()).append("' ");
        }

        if (valueObject.getESTADOPROP() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND ESTADOPROP= '").append(valueObject.getESTADOPROP()).append("' ");
        }

        sql.append("ORDER BY ID_PERSONAAPODERADO ASC ");

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
                               Runtpersonaapoderado valueObject) throws NotFoundException, SQLException {

        ResultSet result = null;
        try {
            result = stmt.executeQuery();
            if (result.next()) {

                valueObject.setID_PERSONAAPODERADO(result.getInt("ID_PERSONAAPODERADO"));
                valueObject.setID_RECIBOLIQ(result.getInt("ID_RECIBOLIQ"));
                valueObject.setID_APODERADO(result.getInt("ID_APODERADO"));
                valueObject.setID_PROPIETARIO(result.getInt("ID_PROPIETARIO"));
                valueObject.setTIPOPROP(result.getString("TIPOPROP"));
                valueObject.setESTADOPROP(result.getString("ESTADOPROP"));

            } else {
                throw new NotFoundException("RuntpersonaapoderadoObject Not Found!");
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
                Runtpersonaapoderado temp = createValueObject();

                temp.setID_PERSONAAPODERADO(result.getInt("ID_PERSONAAPODERADO"));
                temp.setID_RECIBOLIQ(result.getInt("ID_RECIBOLIQ"));
                temp.setID_APODERADO(result.getInt("ID_APODERADO"));
                temp.setID_PROPIETARIO(result.getInt("ID_PROPIETARIO"));
                temp.setTIPOPROP(result.getString("TIPOPROP"));
                temp.setESTADOPROP(result.getString("ESTADOPROP"));
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
