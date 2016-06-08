package modelo.datos.dao.licenciasConduccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.licenciasConduccion.Restricciones;

import utilidades.Funciones;


public class RestriccionesDao {


	public Restricciones createValueObject() {
		return new Restricciones();
	}

	public Restricciones getObject(Connection conn,int ID_RESTRICCIONC) throws NotFoundException, SQLException {
		Restricciones valueObject = createValueObject();
		valueObject.setID_RESTRICCIONC(ID_RESTRICCIONC);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Restricciones valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM RESTRICCIONES WHERE (ID_RESTRICCIONC = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_RESTRICCIONC());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM RESTRICCIONES ORDER BY ID_RESTRICCIONC ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Restricciones valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO RESTRICCIONES ( DESCRIPCION, CODRESTRICCION)"+
			 "VALUES ( ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getDESCRIPCION(),60))
					stmt.setString(1, valueObject.getDESCRIPCION());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCODRESTRICCION(),3))
					stmt.setString(2, valueObject.getCODRESTRICCION());
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


	public void save(Connection conn, Restricciones valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE RESTRICCIONES SET  DESCRIPCION = ?, CODRESTRICCION = ? WHERE (ID_RESTRICCIONC= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getDESCRIPCION(),60))
					stmt.setString(1, valueObject.getDESCRIPCION());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCODRESTRICCION(),3))
					stmt.setString(2, valueObject.getCODRESTRICCION());
				else
					stmt.setNull(2, Types.VARCHAR);
				stmt.setInt(3, valueObject.getID_RESTRICCIONC());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Restricciones valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM RESTRICCIONES WHERE (ID_RESTRICCIONC = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_RESTRICCIONC());

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


	public List searchMatching(Connection conn, Restricciones valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM RESTRICCIONES WHERE 1=1 ");
		if (valueObject.getID_RESTRICCIONC() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_RESTRICCIONC= ").append(valueObject.getID_RESTRICCIONC()).append(" ");
		}

		if (valueObject.getDESCRIPCION() != null && !valueObject.getDESCRIPCION().equals("") && !valueObject.getDESCRIPCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DESCRIPCION= '").append(valueObject.getDESCRIPCION()).append("' ");
		}

		if (valueObject.getCODRESTRICCION() != null && !valueObject.getCODRESTRICCION().equals("") && !valueObject.getCODRESTRICCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND CODRESTRICCION= '").append(valueObject.getCODRESTRICCION()).append("' ");
		}

		sql.append("ORDER BY ID_RESTRICCIONC ASC ");

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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Restricciones valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_RESTRICCIONC(result.getInt("ID_RESTRICCIONC"));
				valueObject.setDESCRIPCION(result.getString("DESCRIPCION"));
				valueObject.setCODRESTRICCION(result.getString("CODRESTRICCION"));

			} else {
				throw new NotFoundException("RestriccionesObject Not Found!");
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
					Restricciones temp = createValueObject();

					temp.setID_RESTRICCIONC(result.getInt("ID_RESTRICCIONC"));
					temp.setDESCRIPCION(result.getString("DESCRIPCION"));
					temp.setCODRESTRICCION(result.getString("CODRESTRICCION"));
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
