package modelo.datos.dao.camposRemolques;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.camposRemolques.Camposremolques;

import utilidades.Funciones;



public class CamposremolquesDao {


    public Camposremolques createValueObject() {
                    return new Camposremolques();
            }

            public Camposremolques getObject(Connection conn,int ID) throws NotFoundException, SQLException {
                    Camposremolques valueObject = createValueObject();
                    valueObject.setID(ID);
                    load(conn, valueObject);
                    return valueObject;
            }

            public void load(Connection conn, Camposremolques valueObject) throws NotFoundException, SQLException {
                    String sql = "SELECT * FROM CAMPOS_REMOLQUES WHERE (ID = ? )";
                    PreparedStatement stmt = null;
                    try {
                            stmt = conn.prepareStatement(sql);
                            stmt.setInt(1, valueObject.getID());
                            singleQuery(conn, stmt, valueObject);
                    } finally {

                    }
            }


            public List loadAll(Connection conn) throws SQLException {
                    String sql = "SELECT * FROM CAMPOS_REMOLQUES ORDER BY ID ASC ";
                    List searchResults = listQuery(conn, conn.prepareStatement(sql));
                    return searchResults;
            }


            public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
                    String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID) AS RowNumber FROM CAMPOS_REMOLQUES) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
                    List searchResults = listQuery(conn, conn.prepareStatement(sql));
                    return searchResults;
            }


            public synchronized void create(Connection conn, Camposremolques valueObject) throws SQLException {
                    String sql = "";
                    PreparedStatement stmt = null;
                    ResultSet result = null;
                    try {
                            sql = "INSERT INTO CAMPOS_REMOLQUES ( ID,"+
                            " NUM_LLANTAS, PESO_MAX_CONFIGURACION_1, ID_VEHICULO,"+
                            " PESO_MAX_CONFIGURACION_2, ID_SUBPARTIDA_ARANCELARIA, ID_TIPO_RODAJE"+
                            ")"+
                             "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
                            stmt = conn.prepareStatement(sql);
                            stmt.setInt(1, valueObject.getID());
                                    if(!Funciones.EnteroesNulo(valueObject.getNUM_LLANTAS()))
                                            stmt.setInt(2, valueObject.getNUM_LLANTAS());
                                    else
                                            stmt.setNull(2, Types.INTEGER);
                                    if(Funciones.contarCadena(valueObject.getPESO_MAX_CONFIGURACION_1(),10))
                                            stmt.setString(3, valueObject.getPESO_MAX_CONFIGURACION_1());
                                    else
                                            stmt.setNull(3, Types.VARCHAR);
                                    if(!Funciones.EnteroesNulo(valueObject.getID_VEHICULO()))
                                            stmt.setInt(4, valueObject.getID_VEHICULO());
                                    else
                                            stmt.setNull(4, Types.INTEGER);
                                    if(Funciones.contarCadena(valueObject.getPESO_MAX_CONFIGURACION_2(),10))
                                            stmt.setString(5, valueObject.getPESO_MAX_CONFIGURACION_2());
                                    else
                                            stmt.setNull(5, Types.VARCHAR);
                                    if(!Funciones.EnteroesNulo(valueObject.getID_SUBPARTIDA_ARANCELARIA()))
                                            stmt.setInt(6, valueObject.getID_SUBPARTIDA_ARANCELARIA());
                                    else
                                            stmt.setNull(6, Types.INTEGER);
                                    if(!Funciones.EnteroesNulo(valueObject.getID_TIPO_RODAJE()))
                                            stmt.setInt(7, valueObject.getID_TIPO_RODAJE());
                                    else
                                            stmt.setNull(7, Types.INTEGER);



                                    int rowcount = databaseUpdate(conn, stmt);
                                    if (rowcount != 1) {
                                            throw new SQLException("PrimaryKey Error when updating DB!");
                                    }
                            } finally {
                                    if (stmt != null)
                                            stmt.close();
                            }
            }


            public void save(Connection conn, Camposremolques valueObject) throws NotFoundException, SQLException {
                    PreparedStatement stmt = null;
                    String sql = "";
                    try {
                            sql = "UPDATE CAMPOS_REMOLQUES SET  NUM_LLANTAS = ?, PESO_MAX_CONFIGURACION_1 = ?, ID_VEHICULO = ?,"+
                            " PESO_MAX_CONFIGURACION_2 = ?, ID_SUBPARTIDA_ARANCELARIA = ?, ID_TIPO_RODAJE = ?"+
                            " WHERE (ID= ?)";
                            stmt = conn.prepareStatement(sql);
                                    if(!Funciones.EnteroesNulo(valueObject.getNUM_LLANTAS()))
                                            stmt.setInt(1, valueObject.getNUM_LLANTAS());
                                    else
                                            stmt.setNull(1, Types.INTEGER);
                                    if(Funciones.contarCadena(valueObject.getPESO_MAX_CONFIGURACION_1(),10))
                                            stmt.setString(2, valueObject.getPESO_MAX_CONFIGURACION_1());
                                    else
                                            stmt.setNull(2, Types.VARCHAR);
                                    if(!Funciones.EnteroesNulo(valueObject.getID_VEHICULO()))
                                            stmt.setInt(3, valueObject.getID_VEHICULO());
                                    else
                                            stmt.setNull(3, Types.INTEGER);
                                    if(Funciones.contarCadena(valueObject.getPESO_MAX_CONFIGURACION_2(),10))
                                            stmt.setString(4, valueObject.getPESO_MAX_CONFIGURACION_2());
                                    else
                                            stmt.setNull(4, Types.VARCHAR);
                                    if(!Funciones.EnteroesNulo(valueObject.getID_SUBPARTIDA_ARANCELARIA()))
                                            stmt.setInt(5, valueObject.getID_SUBPARTIDA_ARANCELARIA());
                                    else
                                            stmt.setNull(5, Types.INTEGER);
                                    if(!Funciones.EnteroesNulo(valueObject.getID_TIPO_RODAJE()))
                                            stmt.setInt(6, valueObject.getID_TIPO_RODAJE());
                                    else
                                            stmt.setNull(6, Types.INTEGER);
                                    stmt.setInt(7, valueObject.getID());

                                    int rowcount = databaseUpdate(conn, stmt);
                                    if (rowcount == 0) {
                                            throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
                                    }
                            } finally {
                                    if (stmt != null)
                                            stmt.close();
                    }
            }


            public void delete(Connection conn, Camposremolques valueObject) throws NotFoundException, SQLException {
                    PreparedStatement stmt = null;
                    String sql = "";
                    try {
                            sql = "DELETE FROM CAMPOS_REMOLQUES WHERE (ID = ? )";
                            stmt = conn.prepareStatement(sql);
                            stmt.setInt(1, valueObject.getID());

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
                    String sql = "SELECT count(*) FROM CAMPOS_REMOLQUES";
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
            public List searchMatching(Connection conn, Camposremolques valueObject) throws SQLException {
                    List searchResults;

                    boolean first = true;
                    StringBuffer sql = new StringBuffer("SELECT * FROM CAMPOS_REMOLQUES WHERE 1=1 ");
                    if (valueObject.getID() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID= ").append(valueObject.getID()).append(" ");
                    }

                    if (valueObject.getNUM_LLANTAS() != 0) {
                            if (first) { first = false; }
                            sql.append("AND NUM_LLANTAS= ").append(valueObject.getNUM_LLANTAS()).append(" ");
                    }

                    if (valueObject.getPESO_MAX_CONFIGURACION_1() != null&&!valueObject.getPESO_MAX_CONFIGURACION_1().equals("")) {
                            if (first) { first = false; }
                            sql.append("AND PESO_MAX_CONFIGURACION_1= '").append(valueObject.getPESO_MAX_CONFIGURACION_1()).append("' ");
                    }

                    if (valueObject.getID_VEHICULO() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID_VEHICULO= ").append(valueObject.getID_VEHICULO()).append(" ");
                    }

                    if (valueObject.getPESO_MAX_CONFIGURACION_2() != null&&!valueObject.getPESO_MAX_CONFIGURACION_2().equals("")) {
                            if (first) { first = false; }
                            sql.append("AND PESO_MAX_CONFIGURACION_2= '").append(valueObject.getPESO_MAX_CONFIGURACION_2()).append("' ");
                    }

                    if (valueObject.getID_SUBPARTIDA_ARANCELARIA() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID_SUBPARTIDA_ARANCELARIA= ").append(valueObject.getID_SUBPARTIDA_ARANCELARIA()).append(" ");
                    }

                    if (valueObject.getID_TIPO_RODAJE() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID_TIPO_RODAJE= ").append(valueObject.getID_TIPO_RODAJE()).append(" ");
                    }

                    sql.append("ORDER BY ID ASC ");

                    if (first)
                            searchResults = new ArrayList();
                    else
                            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

                    return searchResults;
            }


            public List searchMatching(Connection conn, Camposremolques valueObject, int limiteInf, int limiteSup) throws SQLException {
                    List searchResults;

                    boolean first = true;
                    StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID) AS RowNumber FROM CAMPOS_REMOLQUES WHERE 1=1 ");
                    if (valueObject.getID() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID= ").append(valueObject.getID()).append(" ");
                    }

                    if (valueObject.getNUM_LLANTAS() != 0) {
                            if (first) { first = false; }
                            sql.append("AND NUM_LLANTAS= ").append(valueObject.getNUM_LLANTAS()).append(" ");
                    }

                    if (valueObject.getPESO_MAX_CONFIGURACION_1() != null&&!valueObject.getPESO_MAX_CONFIGURACION_1().equals("")) {
                            if (first) { first = false; }
                            sql.append("AND PESO_MAX_CONFIGURACION_1= '").append(valueObject.getPESO_MAX_CONFIGURACION_1()).append("' ");
                    }

                    if (valueObject.getID_VEHICULO() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID_VEHICULO= ").append(valueObject.getID_VEHICULO()).append(" ");
                    }

                    if (valueObject.getPESO_MAX_CONFIGURACION_2() != null&&!valueObject.getPESO_MAX_CONFIGURACION_2().equals("")) {
                            if (first) { first = false; }
                            sql.append("AND PESO_MAX_CONFIGURACION_2= '").append(valueObject.getPESO_MAX_CONFIGURACION_2()).append("' ");
                    }

                    if (valueObject.getID_SUBPARTIDA_ARANCELARIA() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID_SUBPARTIDA_ARANCELARIA= ").append(valueObject.getID_SUBPARTIDA_ARANCELARIA()).append(" ");
                    }

                    if (valueObject.getID_TIPO_RODAJE() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID_TIPO_RODAJE= ").append(valueObject.getID_TIPO_RODAJE()).append(" ");
                    }

                    sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

                    if (first)
                            searchResults = new ArrayList();
                    else
                            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

                    return searchResults;
            }


            public int countSearchMatching(Connection conn, Camposremolques valueObject) throws SQLException {
                    boolean first = true;
                    StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM CAMPOS_REMOLQUES WHERE 1=1 ");
                    if (valueObject.getID() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID= ").append(valueObject.getID()).append(" ");
                    }

                    if (valueObject.getNUM_LLANTAS() != 0) {
                            if (first) { first = false; }
                            sql.append("AND NUM_LLANTAS= ").append(valueObject.getNUM_LLANTAS()).append(" ");
                    }

                    if (valueObject.getPESO_MAX_CONFIGURACION_1() != null&&!valueObject.getPESO_MAX_CONFIGURACION_1().equals("")) {
                            if (first) { first = false; }
                            sql.append("AND PESO_MAX_CONFIGURACION_1= '").append(valueObject.getPESO_MAX_CONFIGURACION_1()).append("' ");
                    }

                    if (valueObject.getID_VEHICULO() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID_VEHICULO= ").append(valueObject.getID_VEHICULO()).append(" ");
                    }

                    if (valueObject.getPESO_MAX_CONFIGURACION_2() != null&&!valueObject.getPESO_MAX_CONFIGURACION_2().equals("")) {
                            if (first) { first = false; }
                            sql.append("AND PESO_MAX_CONFIGURACION_2= '").append(valueObject.getPESO_MAX_CONFIGURACION_2()).append("' ");
                    }

                    if (valueObject.getID_SUBPARTIDA_ARANCELARIA() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID_SUBPARTIDA_ARANCELARIA= ").append(valueObject.getID_SUBPARTIDA_ARANCELARIA()).append(" ");
                    }

                    if (valueObject.getID_TIPO_RODAJE() != 0) {
                            if (first) { first = false; }
                            sql.append("AND ID_TIPO_RODAJE= ").append(valueObject.getID_TIPO_RODAJE()).append(" ");
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


            protected void singleQuery(Connection conn, PreparedStatement stmt, Camposremolques valueObject) throws NotFoundException, SQLException {

                    ResultSet result = null;
                    try {
                            result = stmt.executeQuery();
                            if (result.next()) {

                                    valueObject.setID(result.getInt("ID"));
                                    valueObject.setNUM_LLANTAS(result.getInt("NUM_LLANTAS"));
                                    valueObject.setPESO_MAX_CONFIGURACION_1(result.getString("PESO_MAX_CONFIGURACION_1"));
                                    valueObject.setID_VEHICULO(result.getInt("ID_VEHICULO"));
                                    valueObject.setPESO_MAX_CONFIGURACION_2(result.getString("PESO_MAX_CONFIGURACION_2"));
                                    valueObject.setID_SUBPARTIDA_ARANCELARIA(result.getInt("ID_SUBPARTIDA_ARANCELARIA"));
                                    valueObject.setID_TIPO_RODAJE(result.getInt("ID_TIPO_RODAJE"));

                            } else {
                                    throw new NotFoundException("CamposremolquesObject Not Found!");
                            }
                    }finally {
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
                                    Camposremolques temp = createValueObject();

                                    temp.setID(result.getInt("ID"));
                                    temp.setNUM_LLANTAS(result.getInt("NUM_LLANTAS"));
                                    temp.setPESO_MAX_CONFIGURACION_1(result.getString("PESO_MAX_CONFIGURACION_1"));
                                    temp.setID_VEHICULO(result.getInt("ID_VEHICULO"));
                                    temp.setPESO_MAX_CONFIGURACION_2(result.getString("PESO_MAX_CONFIGURACION_2"));
                                    temp.setID_SUBPARTIDA_ARANCELARIA(result.getInt("ID_SUBPARTIDA_ARANCELARIA"));
                                    temp.setID_TIPO_RODAJE(result.getInt("ID_TIPO_RODAJE"));
                                    searchResults.add(temp);
                            }
                    }
                    finally {
                            if (result != null)
                                    result.close();
                            if (stmt != null)
                                    stmt.close();
                    }
                    return (List)searchResults;
            }


}
