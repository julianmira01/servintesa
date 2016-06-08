package modelo.datos.dao.comparendos.centros_atencion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.centros_atencion.Centroatencion;

import utilidades.Funciones;



public class CentroatencionDao {


	public Centroatencion createValueObject() {
		return new Centroatencion();
	}

	public Centroatencion getObject(Connection conn,int ID_CENTRO) throws NotFoundException, SQLException {
		Centroatencion valueObject = createValueObject();
		valueObject.setID_CENTRO(ID_CENTRO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Centroatencion valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM CENTRO_ATENCION WHERE (ID_CENTRO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_CENTRO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM CENTRO_ATENCION ORDER BY ID_CENTRO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_CENTRO) AS RowNumber FROM CENTRO_ATENCION) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Centroatencion valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO CENTRO_ATENCION ( ID_CENTRO,"+
			" NOMBRE_CENTRO)"+
			 "VALUES ( ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_CENTRO());
				if(Funciones.contarCadena(valueObject.getNOMBRE_CENTRO(),100))
					stmt.setString(2, valueObject.getNOMBRE_CENTRO());
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


	public void save(Connection conn, Centroatencion valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE CENTRO_ATENCION SET  NOMBRE_CENTRO = ? WHERE (ID_CENTRO= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getNOMBRE_CENTRO(),100))
					stmt.setString(1, valueObject.getNOMBRE_CENTRO());
				else
					stmt.setNull(1, Types.VARCHAR);
				stmt.setInt(2, valueObject.getID_CENTRO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Centroatencion valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM CENTRO_ATENCION WHERE (ID_CENTRO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_CENTRO());

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
		String sql = "SELECT count(*) FROM CENTRO_ATENCION";
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
	public List searchMatching(Connection conn, Centroatencion valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM CENTRO_ATENCION WHERE 1=1 ");
		if (valueObject.getID_CENTRO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CENTRO= ").append(valueObject.getID_CENTRO()).append(" ");
		}

		if (valueObject.getNOMBRE_CENTRO() != null&&!valueObject.getNOMBRE_CENTRO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE_CENTRO= '").append(valueObject.getNOMBRE_CENTRO()).append("' ");
		}

		sql.append("ORDER BY ID_CENTRO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Centroatencion valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_CENTRO) AS RowNumber FROM CENTRO_ATENCION WHERE 1=1 ");
		if (valueObject.getID_CENTRO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CENTRO= ").append(valueObject.getID_CENTRO()).append(" ");
		}

		if (valueObject.getNOMBRE_CENTRO() != null&&!valueObject.getNOMBRE_CENTRO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE_CENTRO= '").append(valueObject.getNOMBRE_CENTRO()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Centroatencion valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM CENTRO_ATENCION WHERE 1=1 ");
		if (valueObject.getID_CENTRO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CENTRO= ").append(valueObject.getID_CENTRO()).append(" ");
		}

		if (valueObject.getNOMBRE_CENTRO() != null&&!valueObject.getNOMBRE_CENTRO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE_CENTRO= '").append(valueObject.getNOMBRE_CENTRO()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Centroatencion valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_CENTRO(result.getInt("ID_CENTRO"));
				valueObject.setNOMBRE_CENTRO(result.getString("NOMBRE_CENTRO"));

			} else {
				throw new NotFoundException("CentroatencionObject Not Found!");
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
				Centroatencion temp = createValueObject();

				temp.setID_CENTRO(result.getInt("ID_CENTRO"));
				temp.setNOMBRE_CENTRO(result.getString("NOMBRE_CENTRO"));
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
