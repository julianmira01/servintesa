package modelo.datos.dao.generadorReportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generadorReportes.Columnasseleccionadas;
import utilidades.Funciones;



public class ColumnasseleccionadasDao {


	public Columnasseleccionadas createValueObject() {
		return new Columnasseleccionadas();
	}

	public Columnasseleccionadas getObject(Connection conn,int ID) throws NotFoundException, SQLException {
		Columnasseleccionadas valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Columnasseleccionadas valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM COLUMNAS_SELECCIONADAS WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM COLUMNAS_SELECCIONADAS ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Columnasseleccionadas valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO COLUMNAS_SELECCIONADAS ( VALOR_CAMPO, NOMBRE, ID_REPORTES,"+
			" ID_ETIQUETAS_GRAFICO)"+
			 "VALUES ( ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getVALOR_CAMPO(),20))
					stmt.setString(1, valueObject.getVALOR_CAMPO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBRE(),30))
					stmt.setString(2, valueObject.getNOMBRE());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_REPORTES()))
					stmt.setInt(3, valueObject.getID_REPORTES());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_ETIQUETAS_GRAFICO()))
					stmt.setInt(4, valueObject.getID_ETIQUETAS_GRAFICO());
				else
					stmt.setNull(4, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Columnasseleccionadas valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE COLUMNAS_SELECCIONADAS SET  VALOR_CAMPO = ?, NOMBRE = ?, ID_REPORTES = ?,"+
			" ID_ETIQUETAS_GRAFICO = ? WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getVALOR_CAMPO(),20))
					stmt.setString(1, valueObject.getVALOR_CAMPO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBRE(),30))
					stmt.setString(2, valueObject.getNOMBRE());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_REPORTES()))
					stmt.setInt(3, valueObject.getID_REPORTES());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_ETIQUETAS_GRAFICO()))
					stmt.setInt(4, valueObject.getID_ETIQUETAS_GRAFICO());
				else
					stmt.setNull(4, Types.INTEGER);
				stmt.setInt(5, valueObject.getID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Columnasseleccionadas valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM COLUMNAS_SELECCIONADAS WHERE (ID = ? )";
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


	public List searchMatching(Connection conn, Columnasseleccionadas valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM COLUMNAS_SELECCIONADAS WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getVALOR_CAMPO() != null && !valueObject.getVALOR_CAMPO().equals("") && !valueObject.getVALOR_CAMPO().equals("")) {
			if (first) { first = false; }
			sql.append("AND VALOR_CAMPO= '").append(valueObject.getVALOR_CAMPO()).append("' ");
		}

		if (valueObject.getNOMBRE() != null && !valueObject.getNOMBRE().equals("") && !valueObject.getNOMBRE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE= '").append(valueObject.getNOMBRE()).append("' ");
		}

		if (valueObject.getID_REPORTES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_REPORTES= ").append(valueObject.getID_REPORTES()).append(" ");
		}

		if (valueObject.getID_ETIQUETAS_GRAFICO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ETIQUETAS_GRAFICO= ").append(valueObject.getID_ETIQUETAS_GRAFICO()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Columnasseleccionadas valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
				valueObject.setVALOR_CAMPO(result.getString("VALOR_CAMPO"));
				valueObject.setNOMBRE(result.getString("NOMBRE"));
				valueObject.setID_REPORTES(result.getInt("ID_REPORTES"));
				valueObject.setID_ETIQUETAS_GRAFICO(result.getInt("ID_ETIQUETAS_GRAFICO"));

			} else {
				throw new NotFoundException("ColumnasseleccionadasObject Not Found!");
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
					Columnasseleccionadas temp = createValueObject();

					temp.setID(result.getInt("ID"));
					temp.setVALOR_CAMPO(result.getString("VALOR_CAMPO"));
					temp.setNOMBRE(result.getString("NOMBRE"));
					temp.setID_REPORTES(result.getInt("ID_REPORTES"));
					temp.setID_ETIQUETAS_GRAFICO(result.getInt("ID_ETIQUETAS_GRAFICO"));
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
