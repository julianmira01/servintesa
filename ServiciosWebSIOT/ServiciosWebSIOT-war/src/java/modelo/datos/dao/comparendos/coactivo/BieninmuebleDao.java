package modelo.datos.dao.comparendos.coactivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.coactivo.Bieninmueble;
import utilidades.Funciones;



public class BieninmuebleDao {


	public Bieninmueble createValueObject() {
		return new Bieninmueble();
	}

	public Bieninmueble getObject(Connection conn,int ID_BIENINMUEBLE) throws NotFoundException, SQLException {
		Bieninmueble valueObject = createValueObject();
		valueObject.setID_BIENINMUEBLE(ID_BIENINMUEBLE);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Bieninmueble valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM BIENINMUEBLE WHERE (ID_BIENINMUEBLE = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_BIENINMUEBLE());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM BIENINMUEBLE ORDER BY ID_BIENINMUEBLE ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_BIENINMUEBLE) AS RowNumber FROM BIENINMUEBLE) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Bieninmueble valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO BIENINMUEBLE ( ID_BIENINMUEBLE,"+
			" ID_INFRACTOR, DIRECCION, MATRICULA"+
			")"+
			 "VALUES ( ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_BIENINMUEBLE());
				if(!Funciones.EnteroesNulo(valueObject.getID_INFRACTOR()))
					stmt.setInt(2, valueObject.getID_INFRACTOR());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getDIRECCION(),0))
					stmt.setString(3, valueObject.getDIRECCION());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getMATRICULA(),0))
					stmt.setString(4, valueObject.getMATRICULA());
				else
					stmt.setNull(4, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Bieninmueble valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE BIENINMUEBLE SET  ID_INFRACTOR = ?, DIRECCION = ?, MATRICULA = ?"+
			" WHERE (ID_BIENINMUEBLE= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_INFRACTOR()))
					stmt.setInt(1, valueObject.getID_INFRACTOR());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getDIRECCION(),0))
					stmt.setString(2, valueObject.getDIRECCION());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getMATRICULA(),0))
					stmt.setString(3, valueObject.getMATRICULA());
				else
					stmt.setNull(3, Types.VARCHAR);
				stmt.setInt(4, valueObject.getID_BIENINMUEBLE());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Bieninmueble valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM BIENINMUEBLE WHERE (ID_BIENINMUEBLE = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_BIENINMUEBLE());

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
		String sql = "SELECT count(*) FROM BIENINMUEBLE";
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
	public List searchMatching(Connection conn, Bieninmueble valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM BIENINMUEBLE WHERE 1=1 ");
		if (valueObject.getID_BIENINMUEBLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_BIENINMUEBLE= ").append(valueObject.getID_BIENINMUEBLE()).append(" ");
		}

		if (valueObject.getID_INFRACTOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
		}

		if (valueObject.getDIRECCION() != null&&!valueObject.getDIRECCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DIRECCION= '").append(valueObject.getDIRECCION()).append("' ");
		}

		if (valueObject.getMATRICULA() != null&&!valueObject.getMATRICULA().equals("")) {
			if (first) { first = false; }
			sql.append("AND MATRICULA= '").append(valueObject.getMATRICULA()).append("' ");
		}

		sql.append("ORDER BY ID_BIENINMUEBLE ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Bieninmueble valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_BIENINMUEBLE) AS RowNumber FROM BIENINMUEBLE WHERE 1=1 ");
		if (valueObject.getID_BIENINMUEBLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_BIENINMUEBLE= ").append(valueObject.getID_BIENINMUEBLE()).append(" ");
		}

		if (valueObject.getID_INFRACTOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
		}

		if (valueObject.getDIRECCION() != null&&!valueObject.getDIRECCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DIRECCION= '").append(valueObject.getDIRECCION()).append("' ");
		}

		if (valueObject.getMATRICULA() != null&&!valueObject.getMATRICULA().equals("")) {
			if (first) { first = false; }
			sql.append("AND MATRICULA= '").append(valueObject.getMATRICULA()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Bieninmueble valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM BIENINMUEBLE WHERE 1=1 ");
		if (valueObject.getID_BIENINMUEBLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_BIENINMUEBLE= ").append(valueObject.getID_BIENINMUEBLE()).append(" ");
		}

		if (valueObject.getID_INFRACTOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
		}

		if (valueObject.getDIRECCION() != null&&!valueObject.getDIRECCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DIRECCION= '").append(valueObject.getDIRECCION()).append("' ");
		}

		if (valueObject.getMATRICULA() != null&&!valueObject.getMATRICULA().equals("")) {
			if (first) { first = false; }
			sql.append("AND MATRICULA= '").append(valueObject.getMATRICULA()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Bieninmueble valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_BIENINMUEBLE(result.getInt("ID_BIENINMUEBLE"));
				valueObject.setID_INFRACTOR(result.getInt("ID_INFRACTOR"));
				valueObject.setDIRECCION(result.getString("DIRECCION"));
				valueObject.setMATRICULA(result.getString("MATRICULA"));

			} else {
				throw new NotFoundException("BieninmuebleObject Not Found!");
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
				Bieninmueble temp = createValueObject();

				temp.setID_BIENINMUEBLE(result.getInt("ID_BIENINMUEBLE"));
				temp.setID_INFRACTOR(result.getInt("ID_INFRACTOR"));
				temp.setDIRECCION(result.getString("DIRECCION"));
				temp.setMATRICULA(result.getString("MATRICULA"));
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
