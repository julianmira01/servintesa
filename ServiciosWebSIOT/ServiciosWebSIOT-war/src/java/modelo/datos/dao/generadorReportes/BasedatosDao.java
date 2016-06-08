package modelo.datos.dao.generadorReportes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generadorReportes.Basedatos;

import utilidades.Funciones;


public class BasedatosDao {


	public Basedatos createValueObject() {
		return new Basedatos();
	}

	public Basedatos getObject(Connection conn,int ID) throws NotFoundException, SQLException {
		Basedatos valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Basedatos valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM BASE_DATOS WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM BASE_DATOS ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Basedatos valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO BASE_DATOS ( DESCRIPCION, TITULO, ID_CONFIGURACION_DB"+
			")"+
			 "VALUES ( ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getDESCRIPCION(),200))
					stmt.setString(1, valueObject.getDESCRIPCION());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTITULO(),50))
					stmt.setString(2, valueObject.getTITULO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_CONFIGURACION_DB()))
					stmt.setInt(3, valueObject.getID_CONFIGURACION_DB());
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


	public void save(Connection conn, Basedatos valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE BASE_DATOS SET  DESCRIPCION = ?, TITULO = ?, ID_CONFIGURACION_DB = ?"+
			" WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getDESCRIPCION(),200))
					stmt.setString(1, valueObject.getDESCRIPCION());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTITULO(),50))
					stmt.setString(2, valueObject.getTITULO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_CONFIGURACION_DB()))
					stmt.setInt(3, valueObject.getID_CONFIGURACION_DB());
				else
					stmt.setNull(3, Types.INTEGER);
				stmt.setInt(4, valueObject.getID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Basedatos valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM BASE_DATOS WHERE (ID = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());

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


	public List searchMatching(Connection conn, Basedatos valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM BASE_DATOS WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getDESCRIPCION() != null && !valueObject.getDESCRIPCION().equals("") && !valueObject.getDESCRIPCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DESCRIPCION= '").append(valueObject.getDESCRIPCION()).append("' ");
		}

		if (valueObject.getTITULO() != null && !valueObject.getTITULO().equals("") && !valueObject.getTITULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TITULO= '").append(valueObject.getTITULO()).append("' ");
		}

		if (valueObject.getID_CONFIGURACION_DB() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CONFIGURACION_DB= ").append(valueObject.getID_CONFIGURACION_DB()).append(" ");
		}

		sql.append("ORDER BY ID ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {
		int result = stmt.executeUpdate();
		return result;
	}


	protected void singleQuery(Connection conn, PreparedStatement stmt, Basedatos valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
				valueObject.setDESCRIPCION(result.getString("DESCRIPCION"));
				valueObject.setTITULO(result.getString("TITULO"));
				valueObject.setID_CONFIGURACION_DB(result.getInt("ID_CONFIGURACION_DB"));

			} else {
				throw new NotFoundException("BasedatosObject Not Found!");
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
				while(result.next()){
					Basedatos temp = createValueObject();

					temp.setID(result.getInt("ID"));
					temp.setDESCRIPCION(result.getString("DESCRIPCION"));
					temp.setTITULO(result.getString("TITULO"));
					temp.setID_CONFIGURACION_DB(result.getInt("ID_CONFIGURACION_DB"));
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
