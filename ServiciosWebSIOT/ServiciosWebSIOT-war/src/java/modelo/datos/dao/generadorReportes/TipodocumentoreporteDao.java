package modelo.datos.dao.generadorReportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generadorReportes.Tipodocumentoreporte;
import utilidades.Funciones;


public class TipodocumentoreporteDao {


	public Tipodocumentoreporte createValueObject() {
		return new Tipodocumentoreporte();
	}

	public Tipodocumentoreporte getObject(Connection conn,int ID) throws NotFoundException, SQLException {
		Tipodocumentoreporte valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Tipodocumentoreporte valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM TIPO_DOCUMENTO_REPORTE WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM TIPO_DOCUMENTO_REPORTE ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Tipodocumentoreporte valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO TIPO_DOCUMENTO_REPORTE ( ID_REPORTES, ID_TIPO_DOCUMENTO)"+
			 "VALUES ( ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_REPORTES()))
					stmt.setInt(1, valueObject.getID_REPORTES());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPO_DOCUMENTO()))
					stmt.setInt(2, valueObject.getID_TIPO_DOCUMENTO());
				else
					stmt.setNull(2, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Tipodocumentoreporte valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE TIPO_DOCUMENTO_REPORTE SET  ID_REPORTES = ?, ID_TIPO_DOCUMENTO = ? WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_REPORTES()))
					stmt.setInt(1, valueObject.getID_REPORTES());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPO_DOCUMENTO()))
					stmt.setInt(2, valueObject.getID_TIPO_DOCUMENTO());
				else
					stmt.setNull(2, Types.INTEGER);
				stmt.setInt(3, valueObject.getID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Tipodocumentoreporte valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM TIPO_DOCUMENTO_REPORTE WHERE (ID = ? )";
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


	public List searchMatching(Connection conn, Tipodocumentoreporte valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM TIPO_DOCUMENTO_REPORTE WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getID_REPORTES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_REPORTES= ").append(valueObject.getID_REPORTES()).append(" ");
		}

		if (valueObject.getID_TIPO_DOCUMENTO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPO_DOCUMENTO= ").append(valueObject.getID_TIPO_DOCUMENTO()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Tipodocumentoreporte valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
				valueObject.setID_REPORTES(result.getInt("ID_REPORTES"));
				valueObject.setID_TIPO_DOCUMENTO(result.getInt("ID_TIPO_DOCUMENTO"));

			} else {
				throw new NotFoundException("TipodocumentoreporteObject Not Found!");
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
					Tipodocumentoreporte temp = createValueObject();

					temp.setID(result.getInt("ID"));
					temp.setID_REPORTES(result.getInt("ID_REPORTES"));
					temp.setID_TIPO_DOCUMENTO(result.getInt("ID_TIPO_DOCUMENTO"));
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
