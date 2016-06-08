package modelo.datos.dao.comparendos.coactivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.coactivo.Expedientecomparendo;
import utilidades.Funciones;



public class ExpedientecomparendoDao {


	public Expedientecomparendo createValueObject() {
		return new Expedientecomparendo();
	}

	public Expedientecomparendo getObject(Connection conn,int ID_EXPEDIENTECOMPARENDO) throws NotFoundException, SQLException {
		Expedientecomparendo valueObject = createValueObject();
		valueObject.setID_EXPEDIENTECOMPARENDO(ID_EXPEDIENTECOMPARENDO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Expedientecomparendo valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM EXPEDIENTECOMPARENDO WHERE (ID_EXPEDIENTECOMPARENDO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_EXPEDIENTECOMPARENDO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EXPEDIENTECOMPARENDO ORDER BY ID_EXPEDIENTECOMPARENDO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_EXPEDIENTECOMPARENDO) AS RowNumber FROM EXPEDIENTECOMPARENDO) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Expedientecomparendo valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO EXPEDIENTECOMPARENDO ( ID_EXPEDIENTECOMPARENDO,"+
			" ID_COMPARENDO, ID_EXPEDIENTE)"+
			 "VALUES ( ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_EXPEDIENTECOMPARENDO());
				if(!Funciones.EnteroesNulo(valueObject.getID_COMPARENDO()))
					stmt.setInt(2, valueObject.getID_COMPARENDO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_EXPEDIENTE()))
					stmt.setInt(3, valueObject.getID_EXPEDIENTE());
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


	public void save(Connection conn, Expedientecomparendo valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE EXPEDIENTECOMPARENDO SET  ID_COMPARENDO = ?, ID_EXPEDIENTE = ? WHERE (ID_EXPEDIENTECOMPARENDO= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_COMPARENDO()))
					stmt.setInt(1, valueObject.getID_COMPARENDO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_EXPEDIENTE()))
					stmt.setInt(2, valueObject.getID_EXPEDIENTE());
				else
					stmt.setNull(2, Types.INTEGER);
				stmt.setInt(3, valueObject.getID_EXPEDIENTECOMPARENDO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Expedientecomparendo valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM EXPEDIENTECOMPARENDO WHERE (ID_EXPEDIENTECOMPARENDO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_EXPEDIENTECOMPARENDO());

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
		String sql = "SELECT count(*) FROM EXPEDIENTECOMPARENDO";
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
	public List searchMatching(Connection conn, Expedientecomparendo valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM EXPEDIENTECOMPARENDO WHERE 1=1 ");
		if (valueObject.getID_EXPEDIENTECOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTECOMPARENDO= ").append(valueObject.getID_EXPEDIENTECOMPARENDO()).append(" ");
		}

		if (valueObject.getID_COMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
		}

		if (valueObject.getID_EXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTE= ").append(valueObject.getID_EXPEDIENTE()).append(" ");
		}

		sql.append("ORDER BY ID_EXPEDIENTECOMPARENDO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Expedientecomparendo valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_EXPEDIENTECOMPARENDO) AS RowNumber FROM EXPEDIENTECOMPARENDO WHERE 1=1 ");
		if (valueObject.getID_EXPEDIENTECOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTECOMPARENDO= ").append(valueObject.getID_EXPEDIENTECOMPARENDO()).append(" ");
		}

		if (valueObject.getID_COMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
		}

		if (valueObject.getID_EXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTE= ").append(valueObject.getID_EXPEDIENTE()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Expedientecomparendo valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM EXPEDIENTECOMPARENDO WHERE 1=1 ");
		if (valueObject.getID_EXPEDIENTECOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTECOMPARENDO= ").append(valueObject.getID_EXPEDIENTECOMPARENDO()).append(" ");
		}

		if (valueObject.getID_COMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
		}

		if (valueObject.getID_EXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTE= ").append(valueObject.getID_EXPEDIENTE()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Expedientecomparendo valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_EXPEDIENTECOMPARENDO(result.getInt("ID_EXPEDIENTECOMPARENDO"));
				valueObject.setID_COMPARENDO(result.getInt("ID_COMPARENDO"));
				valueObject.setID_EXPEDIENTE(result.getInt("ID_EXPEDIENTE"));

			} else {
				throw new NotFoundException("ExpedientecomparendoObject Not Found!");
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
				Expedientecomparendo temp = createValueObject();

				temp.setID_EXPEDIENTECOMPARENDO(result.getInt("ID_EXPEDIENTECOMPARENDO"));
				temp.setID_COMPARENDO(result.getInt("ID_COMPARENDO"));
				temp.setID_EXPEDIENTE(result.getInt("ID_EXPEDIENTE"));
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
