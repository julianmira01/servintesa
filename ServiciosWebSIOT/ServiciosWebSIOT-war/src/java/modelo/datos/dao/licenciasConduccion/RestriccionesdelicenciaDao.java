package modelo.datos.dao.licenciasConduccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.licenciasConduccion.Restriccionesdelicencia;

import utilidades.Funciones;


public class RestriccionesdelicenciaDao {


	public Restriccionesdelicencia createValueObject() {
		return new Restriccionesdelicencia();
	}

	public Restriccionesdelicencia getObject(Connection conn,String ID_LICENCIAC) throws NotFoundException, SQLException {
		Restriccionesdelicencia valueObject = createValueObject();
		valueObject.setID_LICENCIAC(ID_LICENCIAC);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Restriccionesdelicencia valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM RESTRICCIONESDELICENCIA WHERE (ID_LICENCIAC = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, valueObject.getID_LICENCIAC());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM RESTRICCIONESDELICENCIA ORDER BY ID_LICENCIAC ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Restriccionesdelicencia valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
                
                System.out.println("Valores registro restricciones licencia al crear: ID_LICENCIAC: " + valueObject.getID_LICENCIAC() +
                                    " ID_RESTRICCIONC: " + valueObject.getID_RESTRICCIONC());
                
		try {
			sql = "INSERT INTO RESTRICCIONESDELICENCIA ( ID_RESTRICCIONC, ID_LICENCIAC )"+
			 "VALUES ( ?, ?)";
                    
			stmt = conn.prepareStatement(sql);
                    
				if(!Funciones.EnteroesNulo(valueObject.getID_RESTRICCIONC()))
					stmt.setInt(1, valueObject.getID_RESTRICCIONC());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getID_LICENCIAC(),20))
					stmt.setString(2, valueObject.getID_LICENCIAC());
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


	public void save(Connection conn, Restriccionesdelicencia valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE RESTRICCIONESDELICENCIA SET  ID_RESTRICCIONC = ?, NROREGISTRO = ? WHERE (ID_LICENCIAC= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_RESTRICCIONC()))
					stmt.setInt(1, valueObject.getID_RESTRICCIONC());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getNROREGISTRO()))
					stmt.setInt(2, valueObject.getNROREGISTRO());
				else
					stmt.setNull(2, Types.INTEGER);
				stmt.setString(3, valueObject.getID_LICENCIAC());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Restriccionesdelicencia valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM RESTRICCIONESDELICENCIA WHERE (ID_LICENCIAC = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, valueObject.getID_LICENCIAC());

			int rowcount = databaseUpdate(conn, stmt);
			/*if (rowcount == 0) {
				throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
			}
			if (rowcount > 1) {
				throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
			}*/
		} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public List searchMatching(Connection conn, Restriccionesdelicencia valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM RESTRICCIONESDELICENCIA WHERE 1=1 ");
		if (valueObject.getID_LICENCIAC() != null && !valueObject.getID_LICENCIAC().equals("") && !valueObject.getID_LICENCIAC().equals("")) {
			if (first) { first = false; }
			sql.append("AND ID_LICENCIAC= '").append(valueObject.getID_LICENCIAC()).append("' ");
		}

		if (valueObject.getID_RESTRICCIONC() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_RESTRICCIONC= ").append(valueObject.getID_RESTRICCIONC()).append(" ");
		}

		if (valueObject.getNROREGISTRO() != 0) {
			if (first) { first = false; }
			sql.append("AND NROREGISTRO= ").append(valueObject.getNROREGISTRO()).append(" ");
		}

		sql.append("ORDER BY ID_LICENCIAC ASC ");
                
                System.out.println("Search restricciones Licencia: " + sql);

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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Restriccionesdelicencia valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_LICENCIAC(result.getString("ID_LICENCIAC"));
				valueObject.setID_RESTRICCIONC(result.getInt("ID_RESTRICCIONC"));
				valueObject.setNROREGISTRO(result.getInt("NROREGISTRO"));

			} else {
				throw new NotFoundException("RestriccionesdelicenciaObject Not Found!");
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
					Restriccionesdelicencia temp = createValueObject();

					temp.setID_LICENCIAC(result.getString("ID_LICENCIAC"));
					temp.setID_RESTRICCIONC(result.getInt("ID_RESTRICCIONC"));
					temp.setNROREGISTRO(result.getInt("NROREGISTRO"));
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
