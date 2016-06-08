package modelo.datos.dao.distribucionRecursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.distribucionRecursos.Cuentacontable;
import utilidades.Funciones;



public class CuentacontableDao {


	public Cuentacontable createValueObject() {
		return new Cuentacontable();
	}

	public Cuentacontable getObject(Connection conn,int ID_CTACONTABLE) throws NotFoundException, SQLException {
		Cuentacontable valueObject = createValueObject();
		valueObject.setID_CTACONTABLE(ID_CTACONTABLE);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Cuentacontable valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM CUENTACONTABLE WHERE (ID_CTACONTABLE = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_CTACONTABLE());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM CUENTACONTABLE ORDER BY ID_CTACONTABLE ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_CTACONTABLE) AS RowNumber FROM CUENTACONTABLE) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Cuentacontable valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO CUENTACONTABLE ( ID_CTACONTABLE,"+
			" COD_CTACONTABLE, NOMBRE_CTACONTABLE, VIGENCIA"+
			")"+
			 "VALUES ( ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_CTACONTABLE());
				if(Funciones.contarCadena(valueObject.getCOD_CTACONTABLE(),10))
					stmt.setString(2, valueObject.getCOD_CTACONTABLE());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBRE_CTACONTABLE(),50))
					stmt.setString(3, valueObject.getNOMBRE_CTACONTABLE());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getVIGENCIA()))
					stmt.setInt(4, valueObject.getVIGENCIA());
				else
					stmt.setNull(4, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Cuentacontable valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE CUENTACONTABLE SET  COD_CTACONTABLE = ?, NOMBRE_CTACONTABLE = ?, VIGENCIA = ?"+
			" WHERE (ID_CTACONTABLE= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getCOD_CTACONTABLE(),10))
					stmt.setString(1, valueObject.getCOD_CTACONTABLE());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBRE_CTACONTABLE(),50))
					stmt.setString(2, valueObject.getNOMBRE_CTACONTABLE());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getVIGENCIA()))
					stmt.setInt(3, valueObject.getVIGENCIA());
				else
					stmt.setNull(3, Types.INTEGER);
				stmt.setInt(4, valueObject.getID_CTACONTABLE());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Cuentacontable valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM CUENTACONTABLE WHERE (ID_CTACONTABLE = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_CTACONTABLE());

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
		String sql = "SELECT count(*) FROM CUENTACONTABLE";
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
	public List searchMatching(Connection conn, Cuentacontable valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM CUENTACONTABLE WHERE 1=1 ");
		if (valueObject.getID_CTACONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CTACONTABLE= ").append(valueObject.getID_CTACONTABLE()).append(" ");
		}

		if (valueObject.getCOD_CTACONTABLE() != null&&!valueObject.getCOD_CTACONTABLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND COD_CTACONTABLE= '").append(valueObject.getCOD_CTACONTABLE()).append("' ");
		}

		if (valueObject.getNOMBRE_CTACONTABLE() != null&&!valueObject.getNOMBRE_CTACONTABLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE_CTACONTABLE= '").append(valueObject.getNOMBRE_CTACONTABLE()).append("' ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		sql.append("ORDER BY ID_CTACONTABLE ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Cuentacontable valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_CTACONTABLE) AS RowNumber FROM CUENTACONTABLE WHERE 1=1 ");
		if (valueObject.getID_CTACONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CTACONTABLE= ").append(valueObject.getID_CTACONTABLE()).append(" ");
		}

		if (valueObject.getCOD_CTACONTABLE() != null&&!valueObject.getCOD_CTACONTABLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND COD_CTACONTABLE= '").append(valueObject.getCOD_CTACONTABLE()).append("' ");
		}

		if (valueObject.getNOMBRE_CTACONTABLE() != null&&!valueObject.getNOMBRE_CTACONTABLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE_CTACONTABLE= '").append(valueObject.getNOMBRE_CTACONTABLE()).append("' ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Cuentacontable valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM CUENTACONTABLE WHERE 1=1 ");
		if (valueObject.getID_CTACONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CTACONTABLE= ").append(valueObject.getID_CTACONTABLE()).append(" ");
		}

		if (valueObject.getCOD_CTACONTABLE() != null&&!valueObject.getCOD_CTACONTABLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND COD_CTACONTABLE= '").append(valueObject.getCOD_CTACONTABLE()).append("' ");
		}

		if (valueObject.getNOMBRE_CTACONTABLE() != null&&!valueObject.getNOMBRE_CTACONTABLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE_CTACONTABLE= '").append(valueObject.getNOMBRE_CTACONTABLE()).append("' ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Cuentacontable valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_CTACONTABLE(result.getInt("ID_CTACONTABLE"));
				valueObject.setCOD_CTACONTABLE(result.getString("COD_CTACONTABLE"));
				valueObject.setNOMBRE_CTACONTABLE(result.getString("NOMBRE_CTACONTABLE"));
				valueObject.setVIGENCIA(result.getInt("VIGENCIA"));

			} else {
				throw new NotFoundException("CuentacontableObject Not Found!");
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
				Cuentacontable temp = createValueObject();

				temp.setID_CTACONTABLE(result.getInt("ID_CTACONTABLE"));
				temp.setCOD_CTACONTABLE(result.getString("COD_CTACONTABLE"));
				temp.setNOMBRE_CTACONTABLE(result.getString("NOMBRE_CTACONTABLE"));
				temp.setVIGENCIA(result.getInt("VIGENCIA"));
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
