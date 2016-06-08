package modelo.datos.dao.resoluciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.resoluciones.Vigencias;
import utilidades.Funciones;



public class VigenciasDao {


	public Vigencias createValueObject() {
		return new Vigencias();
	}

	public Vigencias getObject(Connection conn,int ID_VIGENCIA) throws SQLException {
		Vigencias valueObject = createValueObject();
		valueObject.setID_VIGENCIA(ID_VIGENCIA);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Vigencias valueObject) throws SQLException {
		String sql = "SELECT * FROM VIGENCIAS WHERE (ID_VIGENCIA = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_VIGENCIA());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM VIGENCIAS ORDER BY ID_VIGENCIA ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_VIGENCIA) AS RowNumber FROM VIGENCIAS) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Vigencias valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO VIGENCIAS ( ID_VIGENCIA,"+
			" ANO, NUM_RESOLUCION_INICIO)"+
			 "VALUES ( ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_VIGENCIA());
				if(!Funciones.EnteroesNulo(valueObject.getANO()))
					stmt.setInt(2, valueObject.getANO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getNUM_RESOLUCION_INICIO()))
					stmt.setInt(3, valueObject.getNUM_RESOLUCION_INICIO());
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


	public void save(Connection conn, Vigencias valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE VIGENCIAS SET  ANO = ?, NUM_RESOLUCION_INICIO = ? WHERE (ID_VIGENCIA= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getANO()))
					stmt.setInt(1, valueObject.getANO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getNUM_RESOLUCION_INICIO()))
					stmt.setInt(2, valueObject.getNUM_RESOLUCION_INICIO());
				else
					stmt.setNull(2, Types.INTEGER);
				stmt.setInt(3, valueObject.getID_VIGENCIA());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Vigencias valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM VIGENCIAS WHERE (ID_VIGENCIA = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_VIGENCIA());

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
		String sql = "SELECT count(*) FROM VIGENCIAS";
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
	public List searchMatching(Connection conn, Vigencias valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM VIGENCIAS WHERE 1=1 ");
		if (valueObject.getID_VIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_VIGENCIA= ").append(valueObject.getID_VIGENCIA()).append(" ");
		}

		if (valueObject.getANO() != 0) {
			if (first) { first = false; }
			sql.append("AND ANO= ").append(valueObject.getANO()).append(" ");
		}

		if (valueObject.getNUM_RESOLUCION_INICIO() != 0) {
			if (first) { first = false; }
			sql.append("AND NUM_RESOLUCION_INICIO= ").append(valueObject.getNUM_RESOLUCION_INICIO()).append(" ");
		}

		sql.append("ORDER BY ID_VIGENCIA ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Vigencias valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_VIGENCIA) AS RowNumber FROM VIGENCIAS WHERE 1=1 ");
		if (valueObject.getID_VIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_VIGENCIA= ").append(valueObject.getID_VIGENCIA()).append(" ");
		}

		if (valueObject.getANO() != 0) {
			if (first) { first = false; }
			sql.append("AND ANO= ").append(valueObject.getANO()).append(" ");
		}

		if (valueObject.getNUM_RESOLUCION_INICIO() != 0) {
			if (first) { first = false; }
			sql.append("AND NUM_RESOLUCION_INICIO= ").append(valueObject.getNUM_RESOLUCION_INICIO()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Vigencias valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM VIGENCIAS WHERE 1=1 ");
		if (valueObject.getID_VIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_VIGENCIA= ").append(valueObject.getID_VIGENCIA()).append(" ");
		}

		if (valueObject.getANO() != 0) {
			if (first) { first = false; }
			sql.append("AND ANO= ").append(valueObject.getANO()).append(" ");
		}

		if (valueObject.getNUM_RESOLUCION_INICIO() != 0) {
			if (first) { first = false; }
			sql.append("AND NUM_RESOLUCION_INICIO= ").append(valueObject.getNUM_RESOLUCION_INICIO()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Vigencias valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_VIGENCIA(result.getInt("ID_VIGENCIA"));
				valueObject.setANO(result.getInt("ANO"));
				valueObject.setNUM_RESOLUCION_INICIO(result.getInt("NUM_RESOLUCION_INICIO"));

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
				Vigencias temp = createValueObject();

				temp.setID_VIGENCIA(result.getInt("ID_VIGENCIA"));
				temp.setANO(result.getInt("ANO"));
				temp.setNUM_RESOLUCION_INICIO(result.getInt("NUM_RESOLUCION_INICIO"));
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