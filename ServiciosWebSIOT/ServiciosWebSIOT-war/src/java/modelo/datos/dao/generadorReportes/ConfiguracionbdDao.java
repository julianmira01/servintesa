package modelo.datos.dao.generadorReportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generadorReportes.Configuracionbd;
import utilidades.Funciones;



public class ConfiguracionbdDao {


	public Configuracionbd createValueObject() {
		return new Configuracionbd();
	}

	public Configuracionbd getObject(Connection conn,int ID) throws NotFoundException, SQLException {
		Configuracionbd valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Configuracionbd valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM CONFIGURACION_BD WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM CONFIGURACION_BD ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Configuracionbd valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO CONFIGURACION_BD ( USUARIO, CONTRASENA, RUTA_BD,"+
			" IP_SERVER, PUERTO, INSTANCIA,"+
			" ID_MOTOR_BD)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getUSUARIO(),50))
					stmt.setString(1, valueObject.getUSUARIO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCONTRASENA(),30))
					stmt.setString(2, valueObject.getCONTRASENA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getRUTA_BD(),500))
					stmt.setString(3, valueObject.getRUTA_BD());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getIP_SERVER(),20))
					stmt.setString(4, valueObject.getIP_SERVER());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getPUERTO()))
					stmt.setInt(5, valueObject.getPUERTO());
				else
					stmt.setNull(5, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getINSTANCIA(),30))
					stmt.setString(6, valueObject.getINSTANCIA());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_MOTOR_BD()))
					stmt.setInt(7, valueObject.getID_MOTOR_BD());
				else
					stmt.setNull(7, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Configuracionbd valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE CONFIGURACION_BD SET  USUARIO = ?, CONTRASENA = ?, RUTA_BD = ?,"+
			" IP_SERVER = ?, PUERTO = ?, INSTANCIA = ?,"+
			" ID_MOTOR_BD = ? WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getUSUARIO(),50))
					stmt.setString(1, valueObject.getUSUARIO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCONTRASENA(),30))
					stmt.setString(2, valueObject.getCONTRASENA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getRUTA_BD(),500))
					stmt.setString(3, valueObject.getRUTA_BD());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getIP_SERVER(),20))
					stmt.setString(4, valueObject.getIP_SERVER());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getPUERTO()))
					stmt.setInt(5, valueObject.getPUERTO());
				else
					stmt.setNull(5, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getINSTANCIA(),30))
					stmt.setString(6, valueObject.getINSTANCIA());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_MOTOR_BD()))
					stmt.setInt(7, valueObject.getID_MOTOR_BD());
				else
					stmt.setNull(7, Types.INTEGER);
				stmt.setInt(8, valueObject.getID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Configuracionbd valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM CONFIGURACION_BD WHERE (ID = ? )";
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


	public List searchMatching(Connection conn, Configuracionbd valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM CONFIGURACION_BD WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getUSUARIO() != null && !valueObject.getUSUARIO().equals("") && !valueObject.getUSUARIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND USUARIO= '").append(valueObject.getUSUARIO()).append("' ");
		}

		if (valueObject.getCONTRASENA() != null && !valueObject.getCONTRASENA().equals("") && !valueObject.getCONTRASENA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CONTRASENA= '").append(valueObject.getCONTRASENA()).append("' ");
		}

		if (valueObject.getRUTA_BD() != null && !valueObject.getRUTA_BD().equals("") && !valueObject.getRUTA_BD().equals("")) {
			if (first) { first = false; }
			sql.append("AND RUTA_BD= '").append(valueObject.getRUTA_BD()).append("' ");
		}

		if (valueObject.getIP_SERVER() != null && !valueObject.getIP_SERVER().equals("") && !valueObject.getIP_SERVER().equals("")) {
			if (first) { first = false; }
			sql.append("AND IP_SERVER= '").append(valueObject.getIP_SERVER()).append("' ");
		}

		if (valueObject.getPUERTO() != 0) {
			if (first) { first = false; }
			sql.append("AND PUERTO= ").append(valueObject.getPUERTO()).append(" ");
		}

		if (valueObject.getINSTANCIA() != null && !valueObject.getINSTANCIA().equals("") && !valueObject.getINSTANCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND INSTANCIA= '").append(valueObject.getINSTANCIA()).append("' ");
		}

		if (valueObject.getID_MOTOR_BD() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_MOTOR_BD= ").append(valueObject.getID_MOTOR_BD()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Configuracionbd valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
				valueObject.setUSUARIO(result.getString("USUARIO"));
				valueObject.setCONTRASENA(result.getString("CONTRASENA"));
				valueObject.setRUTA_BD(result.getString("RUTA_BD"));
				valueObject.setIP_SERVER(result.getString("IP_SERVER"));
				valueObject.setPUERTO(result.getInt("PUERTO"));
				valueObject.setINSTANCIA(result.getString("INSTANCIA"));
				valueObject.setID_MOTOR_BD(result.getInt("ID_MOTOR_BD"));

			} else {
				throw new NotFoundException("ConfiguracionbdObject Not Found!");
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
					Configuracionbd temp = createValueObject();

					temp.setID(result.getInt("ID"));
					temp.setUSUARIO(result.getString("USUARIO"));
					temp.setCONTRASENA(result.getString("CONTRASENA"));
					temp.setRUTA_BD(result.getString("RUTA_BD"));
					temp.setIP_SERVER(result.getString("IP_SERVER"));
					temp.setPUERTO(result.getInt("PUERTO"));
					temp.setINSTANCIA(result.getString("INSTANCIA"));
					temp.setID_MOTOR_BD(result.getInt("ID_MOTOR_BD"));
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
