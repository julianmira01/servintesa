package modelo.datos.dao.historico_claves;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.historico_claves.Historicoclaves;

import utilidades.Funciones;



public class HistoricoclavesDao {


	public Historicoclaves createValueObject() {
		return new Historicoclaves();
	}

	public Historicoclaves getObject(Connection conn,int ID_HISTORICO_CLAVES) throws NotFoundException, SQLException {
		Historicoclaves valueObject = createValueObject();
		valueObject.setID_HISTORICO_CLAVES(ID_HISTORICO_CLAVES);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Historicoclaves valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM HISTORICO_CLAVES WHERE (ID_HISTORICO_CLAVES = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_HISTORICO_CLAVES());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM HISTORICO_CLAVES ORDER BY ID_HISTORICO_CLAVES ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_HISTORICO_CLAVES) AS RowNumber FROM HISTORICO_CLAVES) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Historicoclaves valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO HISTORICO_CLAVES ( ID_HISTORICO_CLAVES,"+
			" ID_USUARIO, CLAVE, BLOQUEO,"+
			" FECHA_BLOQUEO, INTENTOS_FALLIDOS)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_HISTORICO_CLAVES());
				if(!Funciones.EnteroesNulo(valueObject.getID_USUARIO()))
					stmt.setInt(2, valueObject.getID_USUARIO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCLAVE(),500))
					stmt.setString(3, valueObject.getCLAVE());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getBLOQUEO(),1))
					stmt.setString(4, valueObject.getBLOQUEO());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(Funciones.esFecha(valueObject.getFECHA_BLOQUEO()))
					stmt.setDate(5, Funciones.convFechaSSQL(valueObject.getFECHA_BLOQUEO()));
				else
					stmt.setNull(5, Types.DATE);
				if(!Funciones.EnteroesNulo(valueObject.getINTENTOS_FALLIDOS()))
					stmt.setInt(6, valueObject.getINTENTOS_FALLIDOS());
				else
					stmt.setNull(6, Types.INTEGER);

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Historicoclaves valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE HISTORICO_CLAVES SET  ID_USUARIO = ?, CLAVE = ?, BLOQUEO = ?,"+
			" FECHA_BLOQUEO = ?, INTENTOS_FALLIDOS = ? WHERE (ID_HISTORICO_CLAVES= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_USUARIO()))
					stmt.setInt(1, valueObject.getID_USUARIO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCLAVE(),500))
					stmt.setString(2, valueObject.getCLAVE());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getBLOQUEO(),1))
					stmt.setString(3, valueObject.getBLOQUEO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.esFecha(valueObject.getFECHA_BLOQUEO()))
					stmt.setDate(4, Funciones.convFechaSSQL(valueObject.getFECHA_BLOQUEO()));
				else
					stmt.setNull(4, Types.DATE);
				if(!Funciones.EnteroesNulo(valueObject.getINTENTOS_FALLIDOS()))
					stmt.setInt(5, valueObject.getINTENTOS_FALLIDOS());
				else
					stmt.setNull(5, Types.INTEGER);
				stmt.setInt(6, valueObject.getID_HISTORICO_CLAVES());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Historicoclaves valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM HISTORICO_CLAVES WHERE (ID_HISTORICO_CLAVES = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_HISTORICO_CLAVES());

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
		String sql = "SELECT count(*) FROM HISTORICO_CLAVES";
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
	public List searchMatching(Connection conn, Historicoclaves valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM HISTORICO_CLAVES WHERE 1=1 ");
		if (valueObject.getID_HISTORICO_CLAVES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_HISTORICO_CLAVES= ").append(valueObject.getID_HISTORICO_CLAVES()).append(" ");
		}

		if (valueObject.getID_USUARIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
		}

		if (valueObject.getCLAVE() != null&&!valueObject.getCLAVE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CLAVE= '").append(valueObject.getCLAVE()).append("' ");
		}

		if (valueObject.getBLOQUEO() != null&&!valueObject.getBLOQUEO().equals("")) {
			if (first) { first = false; }
			sql.append("AND BLOQUEO= '").append(valueObject.getBLOQUEO()).append("' ");
		}

		if (valueObject.getFECHA_BLOQUEO() != null&&!valueObject.getFECHA_BLOQUEO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_BLOQUEO= '").append(valueObject.getFECHA_BLOQUEO()).append("' ");
		}

		if (valueObject.getINTENTOS_FALLIDOS() != 0) {
			if (first) { first = false; }
			sql.append("AND INTENTOS_FALLIDOS= ").append(valueObject.getINTENTOS_FALLIDOS()).append(" ");
		}

		sql.append("ORDER BY ID_HISTORICO_CLAVES ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Historicoclaves valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_HISTORICO_CLAVES) AS RowNumber FROM HISTORICO_CLAVES WHERE 1=1 ");
		if (valueObject.getID_HISTORICO_CLAVES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_HISTORICO_CLAVES= ").append(valueObject.getID_HISTORICO_CLAVES()).append(" ");
		}

		if (valueObject.getID_USUARIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
		}

		if (valueObject.getCLAVE() != null&&!valueObject.getCLAVE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CLAVE= '").append(valueObject.getCLAVE()).append("' ");
		}

		if (valueObject.getBLOQUEO() != null&&!valueObject.getBLOQUEO().equals("")) {
			if (first) { first = false; }
			sql.append("AND BLOQUEO= '").append(valueObject.getBLOQUEO()).append("' ");
		}

		if (valueObject.getFECHA_BLOQUEO() != null&&!valueObject.getFECHA_BLOQUEO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_BLOQUEO= '").append(valueObject.getFECHA_BLOQUEO()).append("' ");
		}

		if (valueObject.getINTENTOS_FALLIDOS() != 0) {
			if (first) { first = false; }
			sql.append("AND INTENTOS_FALLIDOS= ").append(valueObject.getINTENTOS_FALLIDOS()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Historicoclaves valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM HISTORICO_CLAVES WHERE 1=1 ");
		if (valueObject.getID_HISTORICO_CLAVES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_HISTORICO_CLAVES= ").append(valueObject.getID_HISTORICO_CLAVES()).append(" ");
		}

		if (valueObject.getID_USUARIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
		}

		if (valueObject.getCLAVE() != null&&!valueObject.getCLAVE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CLAVE= '").append(valueObject.getCLAVE()).append("' ");
		}

		if (valueObject.getBLOQUEO() != null&&!valueObject.getBLOQUEO().equals("")) {
			if (first) { first = false; }
			sql.append("AND BLOQUEO= '").append(valueObject.getBLOQUEO()).append("' ");
		}

		if (valueObject.getFECHA_BLOQUEO() != null&&!valueObject.getFECHA_BLOQUEO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_BLOQUEO= '").append(valueObject.getFECHA_BLOQUEO()).append("' ");
		}

		if (valueObject.getINTENTOS_FALLIDOS() != 0) {
			if (first) { first = false; }
			sql.append("AND INTENTOS_FALLIDOS= ").append(valueObject.getINTENTOS_FALLIDOS()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Historicoclaves valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_HISTORICO_CLAVES(result.getInt("ID_HISTORICO_CLAVES"));
				valueObject.setID_USUARIO(result.getInt("ID_USUARIO"));
				valueObject.setCLAVE(result.getString("CLAVE"));
				valueObject.setBLOQUEO(result.getString("BLOQUEO"));
				valueObject.setFECHA_BLOQUEO(result.getString("FECHA_BLOQUEO"));
				valueObject.setINTENTOS_FALLIDOS(result.getInt("INTENTOS_FALLIDOS"));

			} else {
				throw new NotFoundException("HistoricoclavesObject Not Found!");
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
				Historicoclaves temp = createValueObject();

				temp.setID_HISTORICO_CLAVES(result.getInt("ID_HISTORICO_CLAVES"));
				temp.setID_USUARIO(result.getInt("ID_USUARIO"));
				temp.setCLAVE(result.getString("CLAVE"));
				temp.setBLOQUEO(result.getString("BLOQUEO"));
				temp.setFECHA_BLOQUEO(result.getString("FECHA_BLOQUEO"));
				temp.setINTENTOS_FALLIDOS(result.getInt("INTENTOS_FALLIDOS"));
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
