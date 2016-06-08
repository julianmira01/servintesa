package modelo.datos.dao.comparendos.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.objetos.comparendos.generales.Secuenciaprocesos;

import utilidades.Funciones;



public class SecuenciaprocesosDao {


	public Secuenciaprocesos createValueObject() {
		return new Secuenciaprocesos();
	}

	public Secuenciaprocesos getObject(Connection conn,int ID_SECUENCIAPROCESOS) throws SQLException {
		Secuenciaprocesos valueObject = createValueObject();
		valueObject.setID_SECUENCIAPROCESOS(ID_SECUENCIAPROCESOS);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Secuenciaprocesos valueObject) throws SQLException {
		String sql = "SELECT * FROM SECUENCIAPROCESOS WHERE (ID_SECUENCIAPROCESOS = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_SECUENCIAPROCESOS());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM SECUENCIAPROCESOS ORDER BY ID_SECUENCIAPROCESOS ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_SECUENCIAPROCESOS) AS RowNumber FROM SECUENCIAPROCESOS) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Secuenciaprocesos valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO SECUENCIAPROCESOS ( ID_SECUENCIAPROCESOS,"+
			" ID_PROCESOPADRE, ID_PROCESOHIJO, ID_ESTADOINICIAL,"+
			" ID_ESTADOFINAL, OPCIONAL, CONDICION"+
			")"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_SECUENCIAPROCESOS());
				if(!Funciones.EnteroesNulo(valueObject.getID_PROCESOPADRE()))
					stmt.setInt(2, valueObject.getID_PROCESOPADRE());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_PROCESOHIJO()))
					stmt.setInt(3, valueObject.getID_PROCESOHIJO());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_ESTADOINICIAL()))
					stmt.setInt(4, valueObject.getID_ESTADOINICIAL());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_ESTADOFINAL()))
					stmt.setInt(5, valueObject.getID_ESTADOFINAL());
				else
					stmt.setNull(5, Types.INTEGER);
				if(valueObject.getOPCIONAL()==0 || valueObject.getOPCIONAL()==1)
					stmt.setInt(6, valueObject.getOPCIONAL());
				else
					stmt.setInt(6, 0);
				if(Funciones.contarCadena(valueObject.getCONDICION(),200))
					stmt.setString(7, valueObject.getCONDICION());
				else
					stmt.setNull(7, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Secuenciaprocesos valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE SECUENCIAPROCESOS SET  ID_PROCESOPADRE = ?, ID_PROCESOHIJO = ?, ID_ESTADOINICIAL = ?,"+
			" ID_ESTADOFINAL = ?, OPCIONAL = ?, CONDICION = ?"+
			" WHERE (ID_SECUENCIAPROCESOS= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_PROCESOPADRE()))
					stmt.setInt(1, valueObject.getID_PROCESOPADRE());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_PROCESOHIJO()))
					stmt.setInt(2, valueObject.getID_PROCESOHIJO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_ESTADOINICIAL()))
					stmt.setInt(3, valueObject.getID_ESTADOINICIAL());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_ESTADOFINAL()))
					stmt.setInt(4, valueObject.getID_ESTADOFINAL());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getOPCIONAL()))
					stmt.setInt(5, valueObject.getOPCIONAL());
				else
					stmt.setNull(5, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCONDICION(),200))
					stmt.setString(6, valueObject.getCONDICION());
				else
					stmt.setNull(6, Types.VARCHAR);
				stmt.setInt(7, valueObject.getID_SECUENCIAPROCESOS());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Secuenciaprocesos valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM SECUENCIAPROCESOS WHERE (ID_SECUENCIAPROCESOS = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_SECUENCIAPROCESOS());

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
		String sql = "SELECT count(*) FROM SECUENCIAPROCESOS";
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
	public List searchMatching(Connection conn, Secuenciaprocesos valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM SECUENCIAPROCESOS WHERE 1=1 ");
		if (valueObject.getID_SECUENCIAPROCESOS() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_SECUENCIAPROCESOS= ").append(valueObject.getID_SECUENCIAPROCESOS()).append(" ");
		}

		if (valueObject.getID_PROCESOPADRE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESOPADRE= ").append(valueObject.getID_PROCESOPADRE()).append(" ");
		}

		if (valueObject.getID_PROCESOHIJO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESOHIJO= ").append(valueObject.getID_PROCESOHIJO()).append(" ");
		}

		if (valueObject.getID_ESTADOINICIAL() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOINICIAL= ").append(valueObject.getID_ESTADOINICIAL()).append(" ");
		}

		if (valueObject.getID_ESTADOFINAL() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOFINAL= ").append(valueObject.getID_ESTADOFINAL()).append(" ");
		}

		if (valueObject.getOPCIONAL() != 0) {
			if (first) { first = false; }
			sql.append("AND OPCIONAL= ").append(valueObject.getOPCIONAL()).append(" ");
		}

		if (valueObject.getCONDICION() != null&&!valueObject.getCONDICION().equals("")) {
			if (first) { first = false; }
			sql.append("AND CONDICION= '").append(valueObject.getCONDICION()).append("' ");
		}

		sql.append("ORDER BY ID_SECUENCIAPROCESOS ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Secuenciaprocesos valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_SECUENCIAPROCESOS) AS RowNumber FROM SECUENCIAPROCESOS WHERE 1=1 ");
		if (valueObject.getID_SECUENCIAPROCESOS() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_SECUENCIAPROCESOS= ").append(valueObject.getID_SECUENCIAPROCESOS()).append(" ");
		}

		if (valueObject.getID_PROCESOPADRE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESOPADRE= ").append(valueObject.getID_PROCESOPADRE()).append(" ");
		}

		if (valueObject.getID_PROCESOHIJO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESOHIJO= ").append(valueObject.getID_PROCESOHIJO()).append(" ");
		}

		if (valueObject.getID_ESTADOINICIAL() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOINICIAL= ").append(valueObject.getID_ESTADOINICIAL()).append(" ");
		}

		if (valueObject.getID_ESTADOFINAL() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOFINAL= ").append(valueObject.getID_ESTADOFINAL()).append(" ");
		}

		if (valueObject.getOPCIONAL() != 0) {
			if (first) { first = false; }
			sql.append("AND OPCIONAL= ").append(valueObject.getOPCIONAL()).append(" ");
		}

		if (valueObject.getCONDICION() != null&&!valueObject.getCONDICION().equals("")) {
			if (first) { first = false; }
			sql.append("AND CONDICION= '").append(valueObject.getCONDICION()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Secuenciaprocesos valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM SECUENCIAPROCESOS WHERE 1=1 ");
		if (valueObject.getID_SECUENCIAPROCESOS() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_SECUENCIAPROCESOS= ").append(valueObject.getID_SECUENCIAPROCESOS()).append(" ");
		}

		if (valueObject.getID_PROCESOPADRE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESOPADRE= ").append(valueObject.getID_PROCESOPADRE()).append(" ");
		}

		if (valueObject.getID_PROCESOHIJO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PROCESOHIJO= ").append(valueObject.getID_PROCESOHIJO()).append(" ");
		}

		if (valueObject.getID_ESTADOINICIAL() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOINICIAL= ").append(valueObject.getID_ESTADOINICIAL()).append(" ");
		}

		if (valueObject.getID_ESTADOFINAL() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ESTADOFINAL= ").append(valueObject.getID_ESTADOFINAL()).append(" ");
		}

		if (valueObject.getOPCIONAL() != 0) {
			if (first) { first = false; }
			sql.append("AND OPCIONAL= ").append(valueObject.getOPCIONAL()).append(" ");
		}

		if (valueObject.getCONDICION() != null&&!valueObject.getCONDICION().equals("")) {
			if (first) { first = false; }
			sql.append("AND CONDICION= '").append(valueObject.getCONDICION()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Secuenciaprocesos valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_SECUENCIAPROCESOS(result.getInt("ID_SECUENCIAPROCESOS"));
				valueObject.setID_PROCESOPADRE(result.getInt("ID_PROCESOPADRE"));
				valueObject.setID_PROCESOHIJO(result.getInt("ID_PROCESOHIJO"));
				valueObject.setID_ESTADOINICIAL(result.getInt("ID_ESTADOINICIAL"));
				valueObject.setID_ESTADOFINAL(result.getInt("ID_ESTADOFINAL"));
				valueObject.setOPCIONAL(result.getInt("OPCIONAL"));
				valueObject.setCONDICION(result.getString("CONDICION"));

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
				Secuenciaprocesos temp = createValueObject();

				temp.setID_SECUENCIAPROCESOS(result.getInt("ID_SECUENCIAPROCESOS"));
				temp.setID_PROCESOPADRE(result.getInt("ID_PROCESOPADRE"));
				temp.setID_PROCESOHIJO(result.getInt("ID_PROCESOHIJO"));
				temp.setID_ESTADOINICIAL(result.getInt("ID_ESTADOINICIAL"));
				temp.setID_ESTADOFINAL(result.getInt("ID_ESTADOFINAL"));
				temp.setOPCIONAL(result.getInt("OPCIONAL"));
				temp.setCONDICION(result.getString("CONDICION"));
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
