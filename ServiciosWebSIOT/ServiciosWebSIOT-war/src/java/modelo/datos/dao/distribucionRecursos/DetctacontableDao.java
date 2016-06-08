package modelo.datos.dao.distribucionRecursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.distribucionRecursos.Detctacontable;
import utilidades.Funciones;



public class DetctacontableDao {


	public Detctacontable createValueObject() {
		return new Detctacontable();
	}

	public Detctacontable getObject(Connection conn,int ID_DETCTA_CONTABLE) throws NotFoundException, SQLException {
		Detctacontable valueObject = createValueObject();
		valueObject.setID_DETCTA_CONTABLE(ID_DETCTA_CONTABLE);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Detctacontable valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM DETCTA_CONTABLE WHERE (ID_DETCTA_CONTABLE = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DETCTA_CONTABLE());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM DETCTA_CONTABLE ORDER BY ID_DETCTA_CONTABLE ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_DETCTA_CONTABLE) AS RowNumber FROM DETCTA_CONTABLE) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Detctacontable valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO DETCTA_CONTABLE ( ID_DETCTA_CONTABLE,"+
			" ID_CTACONTABLE, ID_ELEMENTOCONTABLE, FORMULA"+
			")"+
			 "VALUES ( ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DETCTA_CONTABLE());
				if(!Funciones.EnteroesNulo(valueObject.getID_CTACONTABLE()))
					stmt.setInt(2, valueObject.getID_CTACONTABLE());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_ELEMENTOCONTABLE()))
					stmt.setInt(3, valueObject.getID_ELEMENTOCONTABLE());
				else
					stmt.setNull(3, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getFORMULA(),1000))
					stmt.setString(4, valueObject.getFORMULA());
				else
					stmt.setNull(4, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Detctacontable valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE DETCTA_CONTABLE SET  ID_CTACONTABLE = ?, ID_ELEMENTOCONTABLE = ?, FORMULA = ?"+
			" WHERE (ID_DETCTA_CONTABLE= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_CTACONTABLE()))
					stmt.setInt(1, valueObject.getID_CTACONTABLE());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_ELEMENTOCONTABLE()))
					stmt.setInt(2, valueObject.getID_ELEMENTOCONTABLE());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getFORMULA(),1000))
					stmt.setString(3, valueObject.getFORMULA());
				else
					stmt.setNull(3, Types.VARCHAR);
				stmt.setInt(4, valueObject.getID_DETCTA_CONTABLE());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Detctacontable valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM DETCTA_CONTABLE WHERE (ID_DETCTA_CONTABLE = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DETCTA_CONTABLE());

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
		String sql = "SELECT count(*) FROM DETCTA_CONTABLE";
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
	public List searchMatching(Connection conn, Detctacontable valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM DETCTA_CONTABLE WHERE 1=1 ");
		if (valueObject.getID_DETCTA_CONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DETCTA_CONTABLE= ").append(valueObject.getID_DETCTA_CONTABLE()).append(" ");
		}

		if (valueObject.getID_CTACONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CTACONTABLE= ").append(valueObject.getID_CTACONTABLE()).append(" ");
		}

		if (valueObject.getID_ELEMENTOCONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ELEMENTOCONTABLE= ").append(valueObject.getID_ELEMENTOCONTABLE()).append(" ");
		}

		if (valueObject.getFORMULA() != null&&!valueObject.getFORMULA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FORMULA= '").append(valueObject.getFORMULA()).append("' ");
		}

		sql.append("ORDER BY ID_DETCTA_CONTABLE ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Detctacontable valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_DETCTA_CONTABLE) AS RowNumber FROM DETCTA_CONTABLE WHERE 1=1 ");
		if (valueObject.getID_DETCTA_CONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DETCTA_CONTABLE= ").append(valueObject.getID_DETCTA_CONTABLE()).append(" ");
		}

		if (valueObject.getID_CTACONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CTACONTABLE= ").append(valueObject.getID_CTACONTABLE()).append(" ");
		}

		if (valueObject.getID_ELEMENTOCONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ELEMENTOCONTABLE= ").append(valueObject.getID_ELEMENTOCONTABLE()).append(" ");
		}

		if (valueObject.getFORMULA() != null&&!valueObject.getFORMULA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FORMULA= '").append(valueObject.getFORMULA()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Detctacontable valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM DETCTA_CONTABLE WHERE 1=1 ");
		if (valueObject.getID_DETCTA_CONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DETCTA_CONTABLE= ").append(valueObject.getID_DETCTA_CONTABLE()).append(" ");
		}

		if (valueObject.getID_CTACONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CTACONTABLE= ").append(valueObject.getID_CTACONTABLE()).append(" ");
		}

		if (valueObject.getID_ELEMENTOCONTABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ELEMENTOCONTABLE= ").append(valueObject.getID_ELEMENTOCONTABLE()).append(" ");
		}

		if (valueObject.getFORMULA() != null&&!valueObject.getFORMULA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FORMULA= '").append(valueObject.getFORMULA()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Detctacontable valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_DETCTA_CONTABLE(result.getInt("ID_DETCTA_CONTABLE"));
				valueObject.setID_CTACONTABLE(result.getInt("ID_CTACONTABLE"));
				valueObject.setID_ELEMENTOCONTABLE(result.getInt("ID_ELEMENTOCONTABLE"));
				valueObject.setFORMULA(result.getString("FORMULA"));

			} else {
				throw new NotFoundException("DetctacontableObject Not Found!");
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
				Detctacontable temp = createValueObject();

				temp.setID_DETCTA_CONTABLE(result.getInt("ID_DETCTA_CONTABLE"));
				temp.setID_CTACONTABLE(result.getInt("ID_CTACONTABLE"));
				temp.setID_ELEMENTOCONTABLE(result.getInt("ID_ELEMENTOCONTABLE"));
				temp.setFORMULA(result.getString("FORMULA"));
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
