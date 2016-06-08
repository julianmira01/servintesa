package modelo.datos.dao.debidoCobrarImpuesto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;

import modelo.datos.objetos.debidoCobrarImpuesto.Registroimpuesto;

import utilidades.Funciones;



public class RegistroimpuestoDao {


	public Registroimpuesto createValueObject() {
		return new Registroimpuesto();
	}

	public Registroimpuesto getObject(Connection conn,int RI_ID) throws NotFoundException, SQLException {
		Registroimpuesto valueObject = createValueObject();
		valueObject.setRI_ID(RI_ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Registroimpuesto valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM REGISTRO_IMPUESTO WHERE (RI_ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getRI_ID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM REGISTRO_IMPUESTO ORDER BY RI_ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY RI_ID) AS RowNumber FROM REGISTRO_IMPUESTO) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Registroimpuesto valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO REGISTRO_IMPUESTO ( RI_ID,"+
			" RI_INTERES, RI_TIPOIMPUESTO, RI_IMPUESTO,"+
			" RI_VIGENCIAS, LT_TARIFA)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getRI_ID());
				if(!Funciones.DoubleEsNulo(valueObject.getRI_INTERES()))
					stmt.setDouble(2, valueObject.getRI_INTERES());
				else
					stmt.setNull(2, Types.DOUBLE);
				if(Funciones.contarCadena(valueObject.getRI_TIPOIMPUESTO(),100))
					stmt.setString(3, valueObject.getRI_TIPOIMPUESTO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getRI_IMPUESTO(),100))
					stmt.setString(4, valueObject.getRI_IMPUESTO());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getRI_VIGENCIAS()))
					stmt.setInt(5, valueObject.getRI_VIGENCIAS());
				else
					stmt.setNull(5, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getLT_TARIFA()))
					stmt.setInt(6, valueObject.getLT_TARIFA());
				else
					stmt.setNull(6, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Registroimpuesto valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE REGISTRO_IMPUESTO SET  RI_INTERES = ?, RI_TIPOIMPUESTO = ?, RI_IMPUESTO = ?,"+
			" RI_VIGENCIAS = ?, LT_TARIFA = ? WHERE (RI_ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.DoubleEsNulo(valueObject.getRI_INTERES()))
					stmt.setDouble(1, valueObject.getRI_INTERES());
				else
					stmt.setNull(1, Types.DOUBLE);
				if(Funciones.contarCadena(valueObject.getRI_TIPOIMPUESTO(),100))
					stmt.setString(2, valueObject.getRI_TIPOIMPUESTO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getRI_IMPUESTO(),100))
					stmt.setString(3, valueObject.getRI_IMPUESTO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getRI_VIGENCIAS()))
					stmt.setInt(4, valueObject.getRI_VIGENCIAS());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getLT_TARIFA()))
					stmt.setInt(5, valueObject.getLT_TARIFA());
				else
					stmt.setNull(5, Types.INTEGER);
				stmt.setInt(6, valueObject.getRI_ID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Registroimpuesto valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM REGISTRO_IMPUESTO WHERE (RI_ID = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getRI_ID());

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
		String sql = "SELECT count(*) FROM REGISTRO_IMPUESTO";
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
	public List searchMatching(Connection conn, Registroimpuesto valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM REGISTRO_IMPUESTO WHERE 1=1 ");
		if (valueObject.getRI_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_ID= ").append(valueObject.getRI_ID()).append(" ");
		}

		if (valueObject.getRI_INTERES() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_INTERES= ").append(valueObject.getRI_INTERES()).append(" ");
		}

		if (valueObject.getRI_TIPOIMPUESTO() != null&&!valueObject.getRI_TIPOIMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND RI_TIPOIMPUESTO= '").append(valueObject.getRI_TIPOIMPUESTO()).append("' ");
		}

		if (valueObject.getRI_IMPUESTO() != null&&!valueObject.getRI_IMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND RI_IMPUESTO= '").append(valueObject.getRI_IMPUESTO()).append("' ");
		}

		if (valueObject.getRI_VIGENCIAS() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_VIGENCIAS= ").append(valueObject.getRI_VIGENCIAS()).append(" ");
		}

		if (valueObject.getLT_TARIFA() != 0) {
			if (first) { first = false; }
			sql.append("AND LT_TARIFA= ").append(valueObject.getLT_TARIFA()).append(" ");
		}

		sql.append("ORDER BY RI_ID ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Registroimpuesto valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY RI_ID) AS RowNumber FROM REGISTRO_IMPUESTO WHERE 1=1 ");
		if (valueObject.getRI_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_ID= ").append(valueObject.getRI_ID()).append(" ");
		}

		if (valueObject.getRI_INTERES() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_INTERES= ").append(valueObject.getRI_INTERES()).append(" ");
		}

		if (valueObject.getRI_TIPOIMPUESTO() != null&&!valueObject.getRI_TIPOIMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND RI_TIPOIMPUESTO= '").append(valueObject.getRI_TIPOIMPUESTO()).append("' ");
		}

		if (valueObject.getRI_IMPUESTO() != null&&!valueObject.getRI_IMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND RI_IMPUESTO= '").append(valueObject.getRI_IMPUESTO()).append("' ");
		}

		if (valueObject.getRI_VIGENCIAS() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_VIGENCIAS= ").append(valueObject.getRI_VIGENCIAS()).append(" ");
		}

		if (valueObject.getLT_TARIFA() != 0) {
			if (first) { first = false; }
			sql.append("AND LT_TARIFA= ").append(valueObject.getLT_TARIFA()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Registroimpuesto valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM REGISTRO_IMPUESTO WHERE 1=1 ");
		if (valueObject.getRI_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_ID= ").append(valueObject.getRI_ID()).append(" ");
		}

		if (valueObject.getRI_INTERES() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_INTERES= ").append(valueObject.getRI_INTERES()).append(" ");
		}

		if (valueObject.getRI_TIPOIMPUESTO() != null&&!valueObject.getRI_TIPOIMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND RI_TIPOIMPUESTO= '").append(valueObject.getRI_TIPOIMPUESTO()).append("' ");
		}

		if (valueObject.getRI_IMPUESTO() != null&&!valueObject.getRI_IMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND RI_IMPUESTO= '").append(valueObject.getRI_IMPUESTO()).append("' ");
		}

		if (valueObject.getRI_VIGENCIAS() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_VIGENCIAS= ").append(valueObject.getRI_VIGENCIAS()).append(" ");
		}

		if (valueObject.getLT_TARIFA() != 0) {
			if (first) { first = false; }
			sql.append("AND LT_TARIFA= ").append(valueObject.getLT_TARIFA()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Registroimpuesto valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setRI_ID(result.getInt("RI_ID"));
				valueObject.setRI_INTERES(result.getDouble("RI_INTERES"));
				valueObject.setRI_TIPOIMPUESTO(result.getString("RI_TIPOIMPUESTO"));
				valueObject.setRI_IMPUESTO(result.getString("RI_IMPUESTO"));
				valueObject.setRI_VIGENCIAS(result.getInt("RI_VIGENCIAS"));
				valueObject.setLT_TARIFA(result.getInt("LT_TARIFA"));

			} else {
				throw new NotFoundException("RegistroimpuestoObject Not Found!");
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
				Registroimpuesto temp = createValueObject();

				temp.setRI_ID(result.getInt("RI_ID"));
				temp.setRI_INTERES(result.getDouble("RI_INTERES"));
				temp.setRI_TIPOIMPUESTO(result.getString("RI_TIPOIMPUESTO"));
				temp.setRI_IMPUESTO(result.getString("RI_IMPUESTO"));
				temp.setRI_VIGENCIAS(result.getInt("RI_VIGENCIAS"));
				temp.setLT_TARIFA(result.getInt("LT_TARIFA"));
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
