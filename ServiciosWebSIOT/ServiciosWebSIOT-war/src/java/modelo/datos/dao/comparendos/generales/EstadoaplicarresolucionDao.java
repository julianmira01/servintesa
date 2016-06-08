package modelo.datos.dao.comparendos.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.objetos.comparendos.generales.Estadoaplicarresolucion;
import utilidades.Funciones;



public class EstadoaplicarresolucionDao {


	public Estadoaplicarresolucion createValueObject() {
		return new Estadoaplicarresolucion();
	}

	public Estadoaplicarresolucion getObject(Connection conn,int ID_ESTADOCOMP_RESOLUCION) throws SQLException {
		Estadoaplicarresolucion valueObject = createValueObject();
		valueObject.setID_ESTADOCOMP_RESOLUCION(ID_ESTADOCOMP_RESOLUCION);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Estadoaplicarresolucion valueObject) throws SQLException {
		String sql = "SELECT * FROM ESTADO_APLICAR_RESOLUCION WHERE (ID_ESTADOCOMP_RESOLUCION = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_ESTADOCOMP_RESOLUCION());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM ESTADO_APLICAR_RESOLUCION ORDER BY ID_ESTADOCOMP_RESOLUCION ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_ESTADOCOMP_RESOLUCION) AS RowNumber FROM ESTADO_APLICAR_RESOLUCION) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Estadoaplicarresolucion valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO ESTADO_APLICAR_RESOLUCION ( ID_ESTADOCOMP_RESOLUCION,"+
			" ID_ESTADOCOMPARENDO, ID_TIPORESOLUCION)"+
			 "VALUES ( ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_ESTADOCOMP_RESOLUCION());
				if(!Funciones.EnteroesNulo(valueObject.getID_ESTADOCOMPARENDO()))
					stmt.setInt(2, valueObject.getID_ESTADOCOMPARENDO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPORESOLUCION()))
					stmt.setInt(3, valueObject.getID_TIPORESOLUCION());
				else
					stmt.setNull(3, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Estadoaplicarresolucion valueObject) throws  SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE ESTADO_APLICAR_RESOLUCION SET  ID_ESTADOCOMPARENDO = ?, ID_TIPORESOLUCION = ? WHERE (ID_ESTADOCOMP_RESOLUCION= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_ESTADOCOMPARENDO()))
					stmt.setInt(1, valueObject.getID_ESTADOCOMPARENDO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPORESOLUCION()))
					stmt.setInt(2, valueObject.getID_TIPORESOLUCION());
				else
					stmt.setNull(2, Types.INTEGER);
				stmt.setInt(3, valueObject.getID_ESTADOCOMP_RESOLUCION());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Estadoaplicarresolucion valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM ESTADO_APLICAR_RESOLUCION WHERE (ID_ESTADOCOMP_RESOLUCION = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_ESTADOCOMP_RESOLUCION());

			int rowcount = databaseUpdate(conn, stmt);
			if (rowcount == 0) {
				throw new SQLException();
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
		String sql = "SELECT count(*) FROM ESTADO_APLICAR_RESOLUCION";
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
	public List searchMatching(Connection conn, Estadoaplicarresolucion valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM ESTADO_APLICAR_RESOLUCION WHERE 1=1 ");
		if (valueObject.getID_ESTADOCOMP_RESOLUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOCOMP_RESOLUCION= ").append(valueObject.getID_ESTADOCOMP_RESOLUCION()).append(" ");
		}

		if (valueObject.getID_ESTADOCOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOCOMPARENDO= ").append(valueObject.getID_ESTADOCOMPARENDO()).append(" ");
		}

		if (valueObject.getID_TIPORESOLUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPORESOLUCION= ").append(valueObject.getID_TIPORESOLUCION()).append(" ");
		}

		sql.append("ORDER BY ID_ESTADOCOMP_RESOLUCION ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Estadoaplicarresolucion valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_ESTADOCOMP_RESOLUCION) AS RowNumber FROM ESTADO_APLICAR_RESOLUCION WHERE 1=1 ");
		if (valueObject.getID_ESTADOCOMP_RESOLUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOCOMP_RESOLUCION= ").append(valueObject.getID_ESTADOCOMP_RESOLUCION()).append(" ");
		}

		if (valueObject.getID_ESTADOCOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOCOMPARENDO= ").append(valueObject.getID_ESTADOCOMPARENDO()).append(" ");
		}

		if (valueObject.getID_TIPORESOLUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPORESOLUCION= ").append(valueObject.getID_TIPORESOLUCION()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Estadoaplicarresolucion valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM ESTADO_APLICAR_RESOLUCION WHERE 1=1 ");
		if (valueObject.getID_ESTADOCOMP_RESOLUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOCOMP_RESOLUCION= ").append(valueObject.getID_ESTADOCOMP_RESOLUCION()).append(" ");
		}

		if (valueObject.getID_ESTADOCOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOCOMPARENDO= ").append(valueObject.getID_ESTADOCOMPARENDO()).append(" ");
		}

		if (valueObject.getID_TIPORESOLUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPORESOLUCION= ").append(valueObject.getID_TIPORESOLUCION()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Estadoaplicarresolucion valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_ESTADOCOMP_RESOLUCION(result.getInt("ID_ESTADOCOMP_RESOLUCION"));
				valueObject.setID_ESTADOCOMPARENDO(result.getInt("ID_ESTADOCOMPARENDO"));
				valueObject.setID_TIPORESOLUCION(result.getInt("ID_TIPORESOLUCION"));

			} else {
				throw new SQLException();
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
				Estadoaplicarresolucion temp = createValueObject();

				temp.setID_ESTADOCOMP_RESOLUCION(result.getInt("ID_ESTADOCOMP_RESOLUCION"));
				temp.setID_ESTADOCOMPARENDO(result.getInt("ID_ESTADOCOMPARENDO"));
				temp.setID_TIPORESOLUCION(result.getInt("ID_TIPORESOLUCION"));
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
