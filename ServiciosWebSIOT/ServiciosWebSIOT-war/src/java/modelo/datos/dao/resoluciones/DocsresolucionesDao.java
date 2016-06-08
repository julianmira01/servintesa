package modelo.datos.dao.resoluciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.objetos.resoluciones.Docsresoluciones;
import utilidades.Funciones;



public class DocsresolucionesDao {


	public Docsresoluciones createValueObject() {
		return new Docsresoluciones();
	}

	public Docsresoluciones getObject(Connection conn,int ID_DOCSRESOLUCIONES) throws SQLException {
		Docsresoluciones valueObject = createValueObject();
		valueObject.setID_DOCSRESOLUCIONES(ID_DOCSRESOLUCIONES);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Docsresoluciones valueObject) throws SQLException {
		String sql = "SELECT * FROM DOCSRESOLUCIONES WHERE (ID_DOCSRESOLUCIONES = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DOCSRESOLUCIONES());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM DOCSRESOLUCIONES ORDER BY ID_DOCSRESOLUCIONES ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_DOCSRESOLUCIONES) AS RowNumber FROM DOCSRESOLUCIONES) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Docsresoluciones valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO DOCSRESOLUCIONES ( ID_DOCSRESOLUCIONES,"+
			" CONTENIDO)"+
			 "VALUES ( ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DOCSRESOLUCIONES());
				if(valueObject.getCONTENIDO()!=null)
					stmt.setString(2, valueObject.getCONTENIDO());
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


	public void save(Connection conn, Docsresoluciones valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE DOCSRESOLUCIONES SET  CONTENIDO = ? WHERE (ID_DOCSRESOLUCIONES= ?)";
			stmt = conn.prepareStatement(sql);
				if(valueObject.getCONTENIDO()!=null)
					stmt.setString(1, valueObject.getCONTENIDO());
				else
					stmt.setNull(1, Types.VARCHAR);
				stmt.setInt(2, valueObject.getID_DOCSRESOLUCIONES());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Docsresoluciones valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM DOCSRESOLUCIONES WHERE (ID_DOCSRESOLUCIONES = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DOCSRESOLUCIONES());

			int rowcount = databaseUpdate(conn, stmt);
			if (rowcount == 0) {
				throw new SQLException();
			}
			if (rowcount > 1) {
				throw new SQLException();
			}
		} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public int countAll(Connection conn) throws SQLException {
		String sql = "SELECT count(*) FROM DOCSRESOLUCIONES";
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
	public List searchMatching(Connection conn, Docsresoluciones valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM DOCSRESOLUCIONES WHERE 1=1 ");
		if (valueObject.getID_DOCSRESOLUCIONES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSRESOLUCIONES= ").append(valueObject.getID_DOCSRESOLUCIONES()).append(" ");
		}

		if (valueObject.getCONTENIDO() != null&&!valueObject.getCONTENIDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND CONTENIDO= '").append(valueObject.getCONTENIDO()).append("' ");
		}

		sql.append("ORDER BY ID_DOCSRESOLUCIONES ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Docsresoluciones valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_DOCSRESOLUCIONES) AS RowNumber FROM DOCSRESOLUCIONES WHERE 1=1 ");
		if (valueObject.getID_DOCSRESOLUCIONES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSRESOLUCIONES= ").append(valueObject.getID_DOCSRESOLUCIONES()).append(" ");
		}

		if (valueObject.getCONTENIDO() != null&&!valueObject.getCONTENIDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND CONTENIDO= '").append(valueObject.getCONTENIDO()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Docsresoluciones valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM DOCSRESOLUCIONES WHERE 1=1 ");
		if (valueObject.getID_DOCSRESOLUCIONES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSRESOLUCIONES= ").append(valueObject.getID_DOCSRESOLUCIONES()).append(" ");
		}

		if (valueObject.getCONTENIDO() != null&&!valueObject.getCONTENIDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND CONTENIDO= '").append(valueObject.getCONTENIDO()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Docsresoluciones valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_DOCSRESOLUCIONES(result.getInt("ID_DOCSRESOLUCIONES"));
				valueObject.setCONTENIDO(result.getString("CONTENIDO"));

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
				Docsresoluciones temp = createValueObject();

				temp.setID_DOCSRESOLUCIONES(result.getInt("ID_DOCSRESOLUCIONES"));
				temp.setCONTENIDO(result.getString("CONTENIDO"));
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
