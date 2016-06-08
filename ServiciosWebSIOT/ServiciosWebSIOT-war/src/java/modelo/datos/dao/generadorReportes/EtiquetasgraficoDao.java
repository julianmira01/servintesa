package modelo.datos.dao.generadorReportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generadorReportes.Etiquetasgrafico;
import utilidades.Funciones;



public class EtiquetasgraficoDao {


	public Etiquetasgrafico createValueObject() {
		return new Etiquetasgrafico();
	}

	public Etiquetasgrafico getObject(Connection conn,int ID) throws NotFoundException, SQLException {
		Etiquetasgrafico valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Etiquetasgrafico valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM ETIQUETAS_GRAFICO WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM ETIQUETAS_GRAFICO ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Etiquetasgrafico valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO ETIQUETAS_GRAFICO ( CAMPO_X, CAMPO_Y)"+
			 "VALUES ( ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getCAMPO_X(),30))
					stmt.setString(1, valueObject.getCAMPO_X());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCAMPO_Y(),30))
					stmt.setString(2, valueObject.getCAMPO_Y());
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


	public void save(Connection conn, Etiquetasgrafico valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE ETIQUETAS_GRAFICO SET  CAMPO_X = ?, CAMPO_Y = ? WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getCAMPO_X(),30))
					stmt.setString(1, valueObject.getCAMPO_X());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCAMPO_Y(),30))
					stmt.setString(2, valueObject.getCAMPO_Y());
				else
					stmt.setNull(2, Types.VARCHAR);
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


	public void delete(Connection conn, Etiquetasgrafico valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM ETIQUETAS_GRAFICO WHERE (ID = ? )";
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


	public List searchMatching(Connection conn, Etiquetasgrafico valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM ETIQUETAS_GRAFICO WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getCAMPO_X() != null && !valueObject.getCAMPO_X().equals("") && !valueObject.getCAMPO_X().equals("")) {
			if (first) { first = false; }
			sql.append("AND CAMPO_X= '").append(valueObject.getCAMPO_X()).append("' ");
		}

		if (valueObject.getCAMPO_Y() != null && !valueObject.getCAMPO_Y().equals("") && !valueObject.getCAMPO_Y().equals("")) {
			if (first) { first = false; }
			sql.append("AND CAMPO_Y= '").append(valueObject.getCAMPO_Y()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Etiquetasgrafico valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
				valueObject.setCAMPO_X(result.getString("CAMPO_X"));
				valueObject.setCAMPO_Y(result.getString("CAMPO_Y"));

			} else {
				throw new NotFoundException("EtiquetasgraficoObject Not Found!");
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
					Etiquetasgrafico temp = createValueObject();

					temp.setID(result.getInt("ID"));
					temp.setCAMPO_X(result.getString("CAMPO_X"));
					temp.setCAMPO_Y(result.getString("CAMPO_Y"));
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
