package modelo.datos.dao.generadorReportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generadorReportes.Motorbd;
import utilidades.Funciones;



public class MotorbdDao {


	public Motorbd createValueObject() {
		return new Motorbd();
	}

	public Motorbd getObject(Connection conn,int ID) throws NotFoundException, SQLException {
		Motorbd valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Motorbd valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM MOTOR_BD WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM MOTOR_BD ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Motorbd valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO MOTOR_BD ( DESCRIPCION, VERSION, TITULO"+
			")"+
			 "VALUES ( ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getDESCRIPCION(),500))
					stmt.setString(1, valueObject.getDESCRIPCION());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getVERSION(),20))
					stmt.setString(2, valueObject.getVERSION());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTITULO(),20))
					stmt.setString(3, valueObject.getTITULO());
				else
					stmt.setNull(3, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Motorbd valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE MOTOR_BD SET  DESCRIPCION = ?, VERSION = ?, TITULO = ?"+
			" WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getDESCRIPCION(),500))
					stmt.setString(1, valueObject.getDESCRIPCION());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getVERSION(),20))
					stmt.setString(2, valueObject.getVERSION());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTITULO(),20))
					stmt.setString(3, valueObject.getTITULO());
				else
					stmt.setNull(3, Types.VARCHAR);
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


	public void delete(Connection conn, Motorbd valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM MOTOR_BD WHERE (ID = ? )";
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


	public List searchMatching(Connection conn, Motorbd valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM MOTOR_BD WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getDESCRIPCION() != null && !valueObject.getDESCRIPCION().equals("") && !valueObject.getDESCRIPCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DESCRIPCION= '").append(valueObject.getDESCRIPCION()).append("' ");
		}

		if (valueObject.getVERSION() != null && !valueObject.getVERSION().equals("") && !valueObject.getVERSION().equals("")) {
			if (first) { first = false; }
			sql.append("AND VERSION= '").append(valueObject.getVERSION()).append("' ");
		}

		if (valueObject.getTITULO() != null && !valueObject.getTITULO().equals("") && !valueObject.getTITULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TITULO= '").append(valueObject.getTITULO()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Motorbd valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
				valueObject.setDESCRIPCION(result.getString("DESCRIPCION"));
				valueObject.setVERSION(result.getString("VERSION"));
				valueObject.setTITULO(result.getString("TITULO"));

			} else {
				throw new NotFoundException("MotorbdObject Not Found!");
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
					Motorbd temp = createValueObject();

					temp.setID(result.getInt("ID"));
					temp.setDESCRIPCION(result.getString("DESCRIPCION"));
					temp.setVERSION(result.getString("VERSION"));
					temp.setTITULO(result.getString("TITULO"));
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
