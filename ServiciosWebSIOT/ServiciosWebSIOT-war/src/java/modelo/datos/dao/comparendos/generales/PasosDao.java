package modelo.datos.dao.comparendos.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.generales.Pasos;

import utilidades.Funciones;



public class PasosDao {


	public Pasos createValueObject() {
		return new Pasos();
	}

	public Pasos getObject(Connection conn,int ID_PASO) throws SQLException {
		Pasos valueObject = createValueObject();
		valueObject.setID_PASO(ID_PASO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Pasos valueObject) throws SQLException {
		String sql = "SELECT * FROM PASOS WHERE (ID_PASO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_PASO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM PASOS ORDER BY ID_PASO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_PASO) AS RowNumber FROM PASOS) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Pasos valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO PASOS ( ID_PASO,"+
			" ID_PROCESO, ID_PASOPADRE, IDTIPORESOLUCION,"+
			" ID_TIPODOCGENERAR, NOMBRE, FORMULARIO,"+
			" PORCENTAJEAVANCE)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_PASO());
				if(!Funciones.EnteroesNulo(valueObject.getID_PROCESO()))
					stmt.setInt(2, valueObject.getID_PROCESO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_PASOPADRE()))
					stmt.setInt(3, valueObject.getID_PASOPADRE());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getIDTIPORESOLUCION()))
					stmt.setInt(4, valueObject.getIDTIPORESOLUCION());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPODOCGENERAR()))
					stmt.setInt(5, valueObject.getID_TIPODOCGENERAR());
				else
					stmt.setNull(5, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNOMBRE(),50))
					stmt.setString(6, valueObject.getNOMBRE());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFORMULARIO(),50))
					stmt.setString(7, valueObject.getFORMULARIO());
				else
					stmt.setNull(7, Types.VARCHAR);
				if(!Funciones.DoubleEsNulo(valueObject.getPORCENTAJEAVANCE()))
					stmt.setDouble(8, valueObject.getPORCENTAJEAVANCE());
				else
					stmt.setNull(8, Types.DOUBLE);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Pasos valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE PASOS SET  ID_PROCESO = ?, ID_PASOPADRE = ?, IDTIPORESOLUCION = ?,"+
			" ID_TIPODOCGENERAR = ?, NOMBRE = ?, FORMULARIO = ?,"+
			" PORCENTAJEAVANCE = ? WHERE (ID_PASO= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_PROCESO()))
					stmt.setInt(1, valueObject.getID_PROCESO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_PASOPADRE()))
					stmt.setInt(2, valueObject.getID_PASOPADRE());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getIDTIPORESOLUCION()))
					stmt.setInt(3, valueObject.getIDTIPORESOLUCION());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPODOCGENERAR()))
					stmt.setInt(4, valueObject.getID_TIPODOCGENERAR());
				else
					stmt.setNull(4, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNOMBRE(),50))
					stmt.setString(5, valueObject.getNOMBRE());
				else
					stmt.setNull(5, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFORMULARIO(),50))
					stmt.setString(6, valueObject.getFORMULARIO());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(!Funciones.DoubleEsNulo(valueObject.getPORCENTAJEAVANCE()))
					stmt.setDouble(7, valueObject.getPORCENTAJEAVANCE());
				else
					stmt.setNull(7, Types.DOUBLE);
				stmt.setInt(8, valueObject.getID_PASO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Pasos valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM PASOS WHERE (ID_PASO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_PASO());

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
		String sql = "SELECT count(*) FROM PASOS";
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
	public List searchMatching(Connection conn, Pasos valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM PASOS WHERE 1=1 ");
		if (valueObject.getID_PASO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PASO= ").append(valueObject.getID_PASO()).append(" ");
		}

		if (valueObject.getID_PROCESO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESO= ").append(valueObject.getID_PROCESO()).append(" ");
		}

		if (valueObject.getID_PASOPADRE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PASOPADRE= ").append(valueObject.getID_PASOPADRE()).append(" ");
		}

		if (valueObject.getIDTIPORESOLUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND IDTIPORESOLUCION= ").append(valueObject.getIDTIPORESOLUCION()).append(" ");
		}

		if (valueObject.getID_TIPODOCGENERAR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOCGENERAR= ").append(valueObject.getID_TIPODOCGENERAR()).append(" ");
		}

		if (valueObject.getNOMBRE() != null&&!valueObject.getNOMBRE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE= '").append(valueObject.getNOMBRE()).append("' ");
		}

		if (valueObject.getFORMULARIO() != null&&!valueObject.getFORMULARIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FORMULARIO= '").append(valueObject.getFORMULARIO()).append("' ");
		}

		if (valueObject.getPORCENTAJEAVANCE() != 0) {
			if (first) { first = false; }
			sql.append("AND PORCENTAJEAVANCE= ").append(valueObject.getPORCENTAJEAVANCE()).append(" ");
		}

		sql.append("ORDER BY ID_PASO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Pasos valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_PASO) AS RowNumber FROM PASOS WHERE 1=1 ");
		if (valueObject.getID_PASO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PASO= ").append(valueObject.getID_PASO()).append(" ");
		}

		if (valueObject.getID_PROCESO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESO= ").append(valueObject.getID_PROCESO()).append(" ");
		}

		if (valueObject.getID_PASOPADRE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PASOPADRE= ").append(valueObject.getID_PASOPADRE()).append(" ");
		}

		if (valueObject.getIDTIPORESOLUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND IDTIPORESOLUCION= ").append(valueObject.getIDTIPORESOLUCION()).append(" ");
		}

		if (valueObject.getID_TIPODOCGENERAR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOCGENERAR= ").append(valueObject.getID_TIPODOCGENERAR()).append(" ");
		}

		if (valueObject.getNOMBRE() != null&&!valueObject.getNOMBRE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE= '").append(valueObject.getNOMBRE()).append("' ");
		}

		if (valueObject.getFORMULARIO() != null&&!valueObject.getFORMULARIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FORMULARIO= '").append(valueObject.getFORMULARIO()).append("' ");
		}

		if (valueObject.getPORCENTAJEAVANCE() != 0) {
			if (first) { first = false; }
			sql.append("AND PORCENTAJEAVANCE= ").append(valueObject.getPORCENTAJEAVANCE()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Pasos valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM PASOS WHERE 1=1 ");
		if (valueObject.getID_PASO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PASO= ").append(valueObject.getID_PASO()).append(" ");
		}

		if (valueObject.getID_PROCESO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESO= ").append(valueObject.getID_PROCESO()).append(" ");
		}

		if (valueObject.getID_PASOPADRE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PASOPADRE= ").append(valueObject.getID_PASOPADRE()).append(" ");
		}

		if (valueObject.getIDTIPORESOLUCION() != 0) {
			if (first) { first = false; }
			sql.append("AND IDTIPORESOLUCION= ").append(valueObject.getIDTIPORESOLUCION()).append(" ");
		}

		if (valueObject.getID_TIPODOCGENERAR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOCGENERAR= ").append(valueObject.getID_TIPODOCGENERAR()).append(" ");
		}

		if (valueObject.getNOMBRE() != null&&!valueObject.getNOMBRE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE= '").append(valueObject.getNOMBRE()).append("' ");
		}

		if (valueObject.getFORMULARIO() != null&&!valueObject.getFORMULARIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FORMULARIO= '").append(valueObject.getFORMULARIO()).append("' ");
		}

		if (valueObject.getPORCENTAJEAVANCE() != 0) {
			if (first) { first = false; }
			sql.append("AND PORCENTAJEAVANCE= ").append(valueObject.getPORCENTAJEAVANCE()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Pasos valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_PASO(result.getInt("ID_PASO"));
				valueObject.setID_PROCESO(result.getInt("ID_PROCESO"));
				valueObject.setID_PASOPADRE(result.getInt("ID_PASOPADRE"));
				valueObject.setIDTIPORESOLUCION(result.getInt("IDTIPORESOLUCION"));
				valueObject.setID_TIPODOCGENERAR(result.getInt("ID_TIPODOCGENERAR"));
				valueObject.setNOMBRE(result.getString("NOMBRE"));
				valueObject.setFORMULARIO(result.getString("FORMULARIO"));
				valueObject.setPORCENTAJEAVANCE(result.getDouble("PORCENTAJEAVANCE"));

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
				Pasos temp = createValueObject();

				temp.setID_PASO(result.getInt("ID_PASO"));
				temp.setID_PROCESO(result.getInt("ID_PROCESO"));
				temp.setID_PASOPADRE(result.getInt("ID_PASOPADRE"));
				temp.setIDTIPORESOLUCION(result.getInt("IDTIPORESOLUCION"));
				temp.setID_TIPODOCGENERAR(result.getInt("ID_TIPODOCGENERAR"));
				temp.setNOMBRE(result.getString("NOMBRE"));
				temp.setFORMULARIO(result.getString("FORMULARIO"));
				temp.setPORCENTAJEAVANCE(result.getDouble("PORCENTAJEAVANCE"));
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
