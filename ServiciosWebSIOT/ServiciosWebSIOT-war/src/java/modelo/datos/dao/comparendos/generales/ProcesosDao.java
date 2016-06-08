package modelo.datos.dao.comparendos.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.objetos.comparendos.generales.Procesos;

import utilidades.Funciones;



public class ProcesosDao {


	public Procesos createValueObject() {
		return new Procesos();
	}

	public Procesos getObject(Connection conn,int ID_PROCESO) throws SQLException {
		Procesos valueObject = createValueObject();
		valueObject.setID_PROCESO(ID_PROCESO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Procesos valueObject) throws SQLException {
		String sql = "SELECT * FROM PROCESOS WHERE (ID_PROCESO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_PROCESO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM PROCESOS ORDER BY ID_PROCESO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_PROCESO) AS RowNumber FROM PROCESOS) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Procesos valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO PROCESOS ( ID_PROCESO,"+
			" NOMBRE)"+
			 "VALUES ( ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_PROCESO());
				if(Funciones.contarCadena(valueObject.getNOMBRE(),50))
					stmt.setString(2, valueObject.getNOMBRE());
				else
					stmt.setNull(2, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Procesos valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE PROCESOS SET  NOMBRE = ? WHERE (ID_PROCESO= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getNOMBRE(),50))
					stmt.setString(1, valueObject.getNOMBRE());
				else
					stmt.setNull(1, Types.VARCHAR);
				stmt.setInt(2, valueObject.getID_PROCESO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Procesos valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM PROCESOS WHERE (ID_PROCESO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_PROCESO());

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
		String sql = "SELECT count(*) FROM PROCESOS";
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
	public List searchMatching(Connection conn, Procesos valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM PROCESOS WHERE 1=1 ");
		if (valueObject.getID_PROCESO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESO= ").append(valueObject.getID_PROCESO()).append(" ");
		}

		if (valueObject.getNOMBRE() != null&&!valueObject.getNOMBRE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE= '").append(valueObject.getNOMBRE()).append("' ");
		}

		sql.append("ORDER BY ID_PROCESO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Procesos valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_PROCESO) AS RowNumber FROM PROCESOS WHERE 1=1 ");
		if (valueObject.getID_PROCESO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESO= ").append(valueObject.getID_PROCESO()).append(" ");
		}

		if (valueObject.getNOMBRE() != null&&!valueObject.getNOMBRE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE= '").append(valueObject.getNOMBRE()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Procesos valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM PROCESOS WHERE 1=1 ");
		if (valueObject.getID_PROCESO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESO= ").append(valueObject.getID_PROCESO()).append(" ");
		}

		if (valueObject.getNOMBRE() != null&&!valueObject.getNOMBRE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE= '").append(valueObject.getNOMBRE()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Procesos valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_PROCESO(result.getInt("ID_PROCESO"));
				valueObject.setNOMBRE(result.getString("NOMBRE"));

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
				Procesos temp = createValueObject();

				temp.setID_PROCESO(result.getInt("ID_PROCESO"));
				temp.setNOMBRE(result.getString("NOMBRE"));
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
