package modelo.datos.dao.privilegios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.privilegios.Privilegios;

import utilidades.Funciones;


public class PrivilegiosDao {


    public Privilegios createValueObject() {
        return new Privilegios();
    }

    public Privilegios getObject(Connection conn, int ID_PRIVILEGIOS) throws NotFoundException, SQLException {
        Privilegios valueObject = createValueObject();
        valueObject.setID_PRIVILEGIOS(ID_PRIVILEGIOS);
        load(conn, valueObject);
        return valueObject;
    }

    public void load(Connection conn, Privilegios valueObject) throws NotFoundException, SQLException {
        String sql = "SELECT * FROM PRIVILEGIOS WHERE (ID_PRIVILEGIOS = ? )";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_PRIVILEGIOS());
            singleQuery(conn, stmt, valueObject);
        } finally {

        }
    }


    public List loadAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM PRIVILEGIOS ORDER BY ID_PRIVILEGIOS ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }


    public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
        String sql =
            "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_PRIVILEGIOS) AS RowNumber FROM PRIVILEGIOS) AS CONSULTA WHERE RowNumber >=" +
            limiteInf + " AND RowNumber <=" + limiteSup;
        List searchResults = listQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }


    public synchronized void create(Connection conn, Privilegios valueObject) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            String[] permi = valueObject.getPERMISO();
            sql =
"INSERT INTO PRIVILEGIOS ( ID_PRIVILEGIOS," + " ID_USUARIO, AUTENTICARUNT, LIQUIDARUNT" + ")" + "VALUES ( ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_PRIVILEGIOS());
            if (!Funciones.EnteroesNulo(valueObject.getID_USUARIO()))
                stmt.setInt(2, valueObject.getID_USUARIO());
            else
                stmt.setNull(2, Types.INTEGER);

            for (int i = 0; i < permi.length; i++) {
                if (Funciones.contarCadena(valueObject.getPERMISO()[i], 2))
                    stmt.setString(i + 3, valueObject.getPERMISO()[i]);
                else
                    stmt.setNull(i + 3, Types.VARCHAR);
            }

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount != 1) {
                throw new SQLException("PrimaryKey Error when updating DB!");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public void save(Connection conn, Privilegios valueObject) throws NotFoundException, SQLException {
        PreparedStatement stmt = null;
        String sql = "";
        try {
            String[] permi = valueObject.getPERMISO();
            sql =
"UPDATE PRIVILEGIOS SET  ID_USUARIO = ?, AUTENTICARUNT = ?, LIQUIDARUNT = ?" + " WHERE (ID_PRIVILEGIOS= ?)";
            stmt = conn.prepareStatement(sql);
            if (!Funciones.EnteroesNulo(valueObject.getID_USUARIO()))
                stmt.setInt(1, valueObject.getID_USUARIO());
            else
                stmt.setNull(1, Types.INTEGER);

            for (int i = 0; i < permi.length; i++) {
                if (Funciones.contarCadena(valueObject.getPERMISO()[i], 2))
                    stmt.setString(i + 2, valueObject.getPERMISO()[i]);
                else
                    stmt.setNull(i + 2, Types.VARCHAR);
            }
            stmt.setInt(4, valueObject.getID_PRIVILEGIOS());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public void delete(Connection conn, Privilegios valueObject) throws NotFoundException, SQLException {
        PreparedStatement stmt = null;
        String sql = "";
        try {
            sql = "DELETE FROM PRIVILEGIOS WHERE (ID_PRIVILEGIOS = ? )";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_PRIVILEGIOS());

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


    public int countAll(Connection conn) throws SQLException {
        String sql = "SELECT count(*) FROM PRIVILEGIOS";
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

    public List searchMatching(Connection conn, Privilegios valueObject) throws SQLException {
        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM PRIVILEGIOS WHERE 1=1 ");
        if (valueObject.getID_PRIVILEGIOS() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_PRIVILEGIOS= ").append(valueObject.getID_PRIVILEGIOS()).append(" ");
        }

        if (valueObject.getID_USUARIO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
        }

        sql.append("ORDER BY ID_PRIVILEGIOS ASC ");

        if (first)
            searchResults = new ArrayList();
        else
            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;
    }


    public List searchMatching(Connection conn, Privilegios valueObject, int limiteInf,
                               int limiteSup) throws SQLException {
        List searchResults;

        boolean first = true;
        StringBuffer sql =
            new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_PRIVILEGIOS) AS RowNumber FROM PRIVILEGIOS WHERE 1=1 ");
        if (valueObject.getID_PRIVILEGIOS() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_PRIVILEGIOS= ").append(valueObject.getID_PRIVILEGIOS()).append(" ");
        }

        if (valueObject.getID_USUARIO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
        }

        sql.append(") AS CONSULTA WHERE RowNumber >=" + limiteInf + " AND RowNumber <=" + limiteSup);

        if (first)
            searchResults = new ArrayList();
        else
            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;
    }


    public int countSearchMatching(Connection conn, Privilegios valueObject) throws SQLException {
        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM PRIVILEGIOS WHERE 1=1 ");
        if (valueObject.getID_PRIVILEGIOS() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_PRIVILEGIOS= ").append(valueObject.getID_PRIVILEGIOS()).append(" ");
        }

        if (valueObject.getID_USUARIO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
        }

        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;
        try {
            stmt = conn.prepareStatement(sql.toString());
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


    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {
        int result = stmt.executeUpdate();
        return result;
    }


    protected void singleQuery(Connection conn, PreparedStatement stmt,
                               Privilegios valueObject) throws NotFoundException, SQLException {

        ResultSet result = null;
        try {
            result = stmt.executeQuery();
            String[] permis = new String[result.getFetchSize()];
            if (result.next()) {
                for (int i = 0; i < result.getFetchSize(); i++) {
                    permis[i] = result.getString(i + 2);
                }
                valueObject.setID_PRIVILEGIOS(result.getInt("ID_PRIVILEGIOS"));
                valueObject.setID_USUARIO(result.getInt("ID_USUARIO"));
                valueObject.setPERMISO(permis);
            } else {
                throw new NotFoundException("PrivilegiosObject Not Found!");
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
            ResultSetMetaData metadatos = result.getMetaData();
            int numcolumnas = metadatos.getColumnCount();
            
            String[] permis = new String[numcolumnas-2];
            while (result.next()) {
                Privilegios temp = createValueObject();

                for (int i = 3; i <= numcolumnas; i++) {
                    permis[i-3] = result.getString(i);
                }
                temp.setID_PRIVILEGIOS(result.getInt("ID_PRIVILEGIOS"));
                temp.setID_USUARIO(result.getInt("ID_USUARIO"));
                temp.setPERMISO(permis);
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

    private int contarResult(ResultSet result) {
        int conteo = 0;
            try {
                while (result.next()) {
                    conteo++;
                }
            } catch (SQLException e) {
            }
        return conteo;
    }

}
