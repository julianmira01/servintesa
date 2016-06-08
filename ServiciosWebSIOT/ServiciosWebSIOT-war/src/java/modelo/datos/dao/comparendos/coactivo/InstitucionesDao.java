package modelo.datos.dao.comparendos.coactivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.coactivo.Instituciones;
import utilidades.Funciones;



public class InstitucionesDao {


	public Instituciones createValueObject() {
		return new Instituciones();
	}

	public Instituciones getObject(Connection conn,int ID_INSTITUCION) throws NotFoundException, SQLException {
		Instituciones valueObject = createValueObject();
		valueObject.setID_INSTITUCION(ID_INSTITUCION);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Instituciones valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM INSTITUCIONES WHERE (ID_INSTITUCION = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_INSTITUCION());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM INSTITUCIONES ORDER BY ID_INSTITUCION ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_INSTITUCION) AS RowNumber FROM INSTITUCIONES) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Instituciones valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO INSTITUCIONES ( ID_INSTITUCION,"+
			" NOMBRE, DIRECCION, ID_CIUDAD"+
			")"+
			 "VALUES ( ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_INSTITUCION());
				if(Funciones.contarCadena(valueObject.getNOMBRE(),0))
					stmt.setString(2, valueObject.getNOMBRE());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDIRECCION(),0))
					stmt.setString(3, valueObject.getDIRECCION());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_CIUDAD()))
					stmt.setInt(4, valueObject.getID_CIUDAD());
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


	public void save(Connection conn, Instituciones valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE INSTITUCIONES SET  NOMBRE = ?, DIRECCION = ?, ID_CIUDAD = ?"+
			" WHERE (ID_INSTITUCION= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getNOMBRE(),0))
					stmt.setString(1, valueObject.getNOMBRE());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDIRECCION(),0))
					stmt.setString(2, valueObject.getDIRECCION());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_CIUDAD()))
					stmt.setInt(3, valueObject.getID_CIUDAD());
				else
					stmt.setNull(3, Types.INTEGER);
				stmt.setInt(4, valueObject.getID_INSTITUCION());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Instituciones valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM INSTITUCIONES WHERE (ID_INSTITUCION = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_INSTITUCION());

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
		String sql = "SELECT count(*) FROM INSTITUCIONES";
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
	public List searchMatching(Connection conn, Instituciones valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM INSTITUCIONES WHERE 1=1 ");
		if (valueObject.getID_INSTITUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INSTITUCION= ").append(valueObject.getID_INSTITUCION()).append(" ");
		}

		if (valueObject.getNOMBRE() != null&&!valueObject.getNOMBRE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE= '").append(valueObject.getNOMBRE()).append("' ");
		}

		if (valueObject.getDIRECCION() != null&&!valueObject.getDIRECCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DIRECCION= '").append(valueObject.getDIRECCION()).append("' ");
		}

		if (valueObject.getID_CIUDAD() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CIUDAD= ").append(valueObject.getID_CIUDAD()).append(" ");
		}

		sql.append("ORDER BY ID_INSTITUCION ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Instituciones valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_INSTITUCION) AS RowNumber FROM INSTITUCIONES WHERE 1=1 ");
		if (valueObject.getID_INSTITUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INSTITUCION= ").append(valueObject.getID_INSTITUCION()).append(" ");
		}

		if (valueObject.getNOMBRE() != null&&!valueObject.getNOMBRE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE= '").append(valueObject.getNOMBRE()).append("' ");
		}

		if (valueObject.getDIRECCION() != null&&!valueObject.getDIRECCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DIRECCION= '").append(valueObject.getDIRECCION()).append("' ");
		}

		if (valueObject.getID_CIUDAD() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CIUDAD= ").append(valueObject.getID_CIUDAD()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Instituciones valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM INSTITUCIONES WHERE 1=1 ");
		if (valueObject.getID_INSTITUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INSTITUCION= ").append(valueObject.getID_INSTITUCION()).append(" ");
		}

		if (valueObject.getNOMBRE() != null&&!valueObject.getNOMBRE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE= '").append(valueObject.getNOMBRE()).append("' ");
		}

		if (valueObject.getDIRECCION() != null&&!valueObject.getDIRECCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DIRECCION= '").append(valueObject.getDIRECCION()).append("' ");
		}

		if (valueObject.getID_CIUDAD() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CIUDAD= ").append(valueObject.getID_CIUDAD()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Instituciones valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_INSTITUCION(result.getInt("ID_INSTITUCION"));
				valueObject.setNOMBRE(result.getString("NOMBRE"));
				valueObject.setDIRECCION(result.getString("DIRECCION"));
				valueObject.setID_CIUDAD(result.getInt("ID_CIUDAD"));

			} else {
				throw new NotFoundException("InstitucionesObject Not Found!");
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
				Instituciones temp = createValueObject();

				temp.setID_INSTITUCION(result.getInt("ID_INSTITUCION"));
				temp.setNOMBRE(result.getString("NOMBRE"));
				temp.setDIRECCION(result.getString("DIRECCION"));
				temp.setID_CIUDAD(result.getInt("ID_CIUDAD"));
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

