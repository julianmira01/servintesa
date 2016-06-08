package modelo.datos.dao.clavesutilizadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.clavesutilizadas.Clavesutilizadas;

import utilidades.Funciones;



public class ClavesutilizadasDao {


	public Clavesutilizadas createValueObject() {
		return new Clavesutilizadas();
	}

	public Clavesutilizadas getObject(Connection conn,int ID_CLAVES_UTILIZADAS) throws NotFoundException, SQLException {
		Clavesutilizadas valueObject = createValueObject();
		valueObject.setID_CLAVES_UTILIZADAS(ID_CLAVES_UTILIZADAS);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Clavesutilizadas valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM CLAVES_UTILIZADAS WHERE (ID_CLAVES_UTILIZADAS = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_CLAVES_UTILIZADAS());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM CLAVES_UTILIZADAS ORDER BY ID_CLAVES_UTILIZADAS ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_CLAVES_UTILIZADAS) AS RowNumber FROM CLAVES_UTILIZADAS) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Clavesutilizadas valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO CLAVES_UTILIZADAS ( ID_CLAVES_UTILIZADAS,"+
			" ID_USUARIO, CLAVE)"+
			 "VALUES ( ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_CLAVES_UTILIZADAS());
				if(!Funciones.EnteroesNulo(valueObject.getID_USUARIO()))
					stmt.setInt(2, valueObject.getID_USUARIO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCLAVE(),500))
					stmt.setString(3, valueObject.getCLAVE());
				else
					stmt.setNull(3, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Clavesutilizadas valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE CLAVES_UTILIZADAS SET  ID_USUARIO = ?, CLAVE = ? WHERE (ID_CLAVES_UTILIZADAS= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_USUARIO()))
					stmt.setInt(1, valueObject.getID_USUARIO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCLAVE(),500))
					stmt.setString(2, valueObject.getCLAVE());
				else
					stmt.setNull(2, Types.VARCHAR);
				stmt.setInt(3, valueObject.getID_CLAVES_UTILIZADAS());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Clavesutilizadas valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM CLAVES_UTILIZADAS WHERE (ID_CLAVES_UTILIZADAS = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_CLAVES_UTILIZADAS());

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
		String sql = "SELECT count(*) FROM CLAVES_UTILIZADAS";
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
	public List searchMatching(Connection conn, Clavesutilizadas valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM CLAVES_UTILIZADAS WHERE 1=1 ");
		if (valueObject.getID_CLAVES_UTILIZADAS() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CLAVES_UTILIZADAS= ").append(valueObject.getID_CLAVES_UTILIZADAS()).append(" ");
		}

		if (valueObject.getID_USUARIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
		}

		if (valueObject.getCLAVE() != null&&!valueObject.getCLAVE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CLAVE= '").append(valueObject.getCLAVE()).append("' ");
		}

		sql.append("ORDER BY ID_CLAVES_UTILIZADAS ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Clavesutilizadas valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_CLAVES_UTILIZADAS) AS RowNumber FROM CLAVES_UTILIZADAS WHERE 1=1 ");
		if (valueObject.getID_CLAVES_UTILIZADAS() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CLAVES_UTILIZADAS= ").append(valueObject.getID_CLAVES_UTILIZADAS()).append(" ");
		}

		if (valueObject.getID_USUARIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
		}

		if (valueObject.getCLAVE() != null&&!valueObject.getCLAVE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CLAVE= '").append(valueObject.getCLAVE()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Clavesutilizadas valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM CLAVES_UTILIZADAS WHERE 1=1 ");
		if (valueObject.getID_CLAVES_UTILIZADAS() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CLAVES_UTILIZADAS= ").append(valueObject.getID_CLAVES_UTILIZADAS()).append(" ");
		}

		if (valueObject.getID_USUARIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
		}

		if (valueObject.getCLAVE() != null&&!valueObject.getCLAVE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CLAVE= '").append(valueObject.getCLAVE()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Clavesutilizadas valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_CLAVES_UTILIZADAS(result.getInt("ID_CLAVES_UTILIZADAS"));
				valueObject.setID_USUARIO(result.getInt("ID_USUARIO"));
				valueObject.setCLAVE(result.getString("CLAVE"));

			} else {
				throw new NotFoundException("ClavesutilizadasObject Not Found!");
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
				Clavesutilizadas temp = createValueObject();

				temp.setID_CLAVES_UTILIZADAS(result.getInt("ID_CLAVES_UTILIZADAS"));
				temp.setID_USUARIO(result.getInt("ID_USUARIO"));
				temp.setCLAVE(result.getString("CLAVE"));
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
