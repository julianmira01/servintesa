package modelo.datos.dao.generadorReportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generadorReportes.Reportes;
import utilidades.Funciones;



public class ReportesDao {


	public Reportes createValueObject() {
		return new Reportes();
	}

	public Reportes getObject(Connection conn,int ID) throws NotFoundException, SQLException {
		Reportes valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Reportes valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM REPORTES WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM REPORTES ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Reportes valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO REPORTES ( TITULO, DIRECCION_RUTA, ID_TIPO_GRAFICO,"+
			" ID_SENTENCIA, ID_ETIQUETAS_GRAFICO, ID_BASE_DATOS"+
			")"+
			 "VALUES ( ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getTITULO(),200))
					stmt.setString(1, valueObject.getTITULO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDIRECCION_RUTA(),500))
					stmt.setString(2, valueObject.getDIRECCION_RUTA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPO_GRAFICO()))
					stmt.setInt(3, valueObject.getID_TIPO_GRAFICO());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_SENTENCIA()))
					stmt.setInt(4, valueObject.getID_SENTENCIA());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_ETIQUETAS_GRAFICO()))
					stmt.setInt(5, valueObject.getID_ETIQUETAS_GRAFICO());
				else
					stmt.setNull(5, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_BASE_DATOS()))
					stmt.setInt(6, valueObject.getID_BASE_DATOS());
				else
					stmt.setNull(6, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Reportes valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE REPORTES SET  TITULO = ?, DIRECCION_RUTA = ?, ID_TIPO_GRAFICO = ?,"+
			" ID_SENTENCIA = ?, ID_ETIQUETAS_GRAFICO = ?, ID_BASE_DATOS = ?"+
			" WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getTITULO(),200))
					stmt.setString(1, valueObject.getTITULO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDIRECCION_RUTA(),500))
					stmt.setString(2, valueObject.getDIRECCION_RUTA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPO_GRAFICO()))
					stmt.setInt(3, valueObject.getID_TIPO_GRAFICO());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_SENTENCIA()))
					stmt.setInt(4, valueObject.getID_SENTENCIA());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_ETIQUETAS_GRAFICO()))
					stmt.setInt(5, valueObject.getID_ETIQUETAS_GRAFICO());
				else
					stmt.setNull(5, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_BASE_DATOS()))
					stmt.setInt(6, valueObject.getID_BASE_DATOS());
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


	public void delete(Connection conn, Reportes valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM REPORTES WHERE (ID = ? )";
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


	public List searchMatching(Connection conn, Reportes valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM REPORTES WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getTITULO() != null && !valueObject.getTITULO().equals("") && !valueObject.getTITULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TITULO= '").append(valueObject.getTITULO()).append("' ");
		}

		if (valueObject.getDIRECCION_RUTA() != null && !valueObject.getDIRECCION_RUTA().equals("") && !valueObject.getDIRECCION_RUTA().equals("")) {
			if (first) { first = false; }
			sql.append("AND DIRECCION_RUTA= '").append(valueObject.getDIRECCION_RUTA()).append("' ");
		}

		if (valueObject.getID_TIPO_GRAFICO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPO_GRAFICO= ").append(valueObject.getID_TIPO_GRAFICO()).append(" ");
		}

		if (valueObject.getID_SENTENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_SENTENCIA= ").append(valueObject.getID_SENTENCIA()).append(" ");
		}

		if (valueObject.getID_ETIQUETAS_GRAFICO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ETIQUETAS_GRAFICO= ").append(valueObject.getID_ETIQUETAS_GRAFICO()).append(" ");
		}

		if (valueObject.getID_BASE_DATOS() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_BASE_DATOS= ").append(valueObject.getID_BASE_DATOS()).append(" ");
		}

		sql.append("ORDER BY ID ASC ");

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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Reportes valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
				valueObject.setTITULO(result.getString("TITULO"));
				valueObject.setDIRECCION_RUTA(result.getString("DIRECCION_RUTA"));
				valueObject.setID_TIPO_GRAFICO(result.getInt("ID_TIPO_GRAFICO"));
				valueObject.setID_SENTENCIA(result.getInt("ID_SENTENCIA"));
				valueObject.setID_ETIQUETAS_GRAFICO(result.getInt("ID_ETIQUETAS_GRAFICO"));
				valueObject.setID_BASE_DATOS(result.getInt("ID_BASE_DATOS"));

			} else {
				throw new NotFoundException("ReportesObject Not Found!");
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
				while(result.next()){
					Reportes temp = createValueObject();

					temp.setID(result.getInt("ID"));
					temp.setTITULO(result.getString("TITULO"));
					temp.setDIRECCION_RUTA(result.getString("DIRECCION_RUTA"));
					temp.setID_TIPO_GRAFICO(result.getInt("ID_TIPO_GRAFICO"));
					temp.setID_SENTENCIA(result.getInt("ID_SENTENCIA"));
					temp.setID_ETIQUETAS_GRAFICO(result.getInt("ID_ETIQUETAS_GRAFICO"));
					temp.setID_BASE_DATOS(result.getInt("ID_BASE_DATOS"));
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
