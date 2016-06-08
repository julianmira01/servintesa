package modelo.datos.dao.debidoCobrarImpuesto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.debidoCobrarImpuesto.Viewconsvehiimpuestoslote;

import utilidades.Funciones;



public class ViewconsvehiimpuestosloteDao {


	public Viewconsvehiimpuestoslote createValueObject() {
		return new Viewconsvehiimpuestoslote();
	}

	public Viewconsvehiimpuestoslote getObject(Connection conn,int ID) throws NotFoundException, SQLException {
		Viewconsvehiimpuestoslote valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Viewconsvehiimpuestoslote valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM VIEW_CONS_VEHI_IMPUESTOSLOTE WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM VIEW_CONS_VEHI_IMPUESTOSLOTE ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID) AS RowNumber FROM VIEW_CONS_VEHI_IMPUESTOSLOTE) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Viewconsvehiimpuestoslote valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO VIEW_CONS_VEHI_IMPUESTOSLOTE ( ID,"+
			" PLACA, VIGENCIA, GRUPO_LIQUIDACION,"+
			" CILINDRAJE)"+
			 "VALUES ( ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
				if(Funciones.contarCadena(valueObject.getPLACA(),10))
					stmt.setString(2, valueObject.getPLACA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getVIGENCIA()))
					stmt.setInt(3, valueObject.getVIGENCIA());
				else
					stmt.setNull(3, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getGRUPO_LIQUIDACION(),30))
					stmt.setString(4, valueObject.getGRUPO_LIQUIDACION());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCILINDRAJE(),10))
					stmt.setString(5, valueObject.getCILINDRAJE());
				else
					stmt.setNull(5, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Viewconsvehiimpuestoslote valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE VIEW_CONS_VEHI_IMPUESTOSLOTE SET  PLACA = ?, VIGENCIA = ?, GRUPO_LIQUIDACION = ?,"+
			" CILINDRAJE = ? WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getPLACA(),10))
					stmt.setString(1, valueObject.getPLACA());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getVIGENCIA()))
					stmt.setInt(2, valueObject.getVIGENCIA());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getGRUPO_LIQUIDACION(),30))
					stmt.setString(3, valueObject.getGRUPO_LIQUIDACION());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCILINDRAJE(),10))
					stmt.setString(4, valueObject.getCILINDRAJE());
				else
					stmt.setNull(4, Types.VARCHAR);
				stmt.setInt(5, valueObject.getID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Viewconsvehiimpuestoslote valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM VIEW_CONS_VEHI_IMPUESTOSLOTE WHERE (ID = ? )";
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


	public int countAll(Connection conn) throws SQLException {
		String sql = "SELECT count(*) FROM VIEW_CONS_VEHI_IMPUESTOSLOTE";
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
	public List searchMatching(Connection conn, Viewconsvehiimpuestoslote valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_CONS_VEHI_IMPUESTOSLOTE WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		if (valueObject.getGRUPO_LIQUIDACION() != null&&!valueObject.getGRUPO_LIQUIDACION().equals("")) {
			if (first) { first = false; }
			sql.append("AND GRUPO_LIQUIDACION= '").append(valueObject.getGRUPO_LIQUIDACION()).append("' ");
		}

		if (valueObject.getCILINDRAJE() != null&&!valueObject.getCILINDRAJE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CILINDRAJE= '").append(valueObject.getCILINDRAJE()).append("' ");
		}

		sql.append("ORDER BY ID ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Viewconsvehiimpuestoslote valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID) AS RowNumber FROM VIEW_CONS_VEHI_IMPUESTOSLOTE WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		if (valueObject.getGRUPO_LIQUIDACION() != null&&!valueObject.getGRUPO_LIQUIDACION().equals("")) {
			if (first) { first = false; }
			sql.append("AND GRUPO_LIQUIDACION= '").append(valueObject.getGRUPO_LIQUIDACION()).append("' ");
		}

		if (valueObject.getCILINDRAJE() != null&&!valueObject.getCILINDRAJE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CILINDRAJE= '").append(valueObject.getCILINDRAJE()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Viewconsvehiimpuestoslote valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM VIEW_CONS_VEHI_IMPUESTOSLOTE WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		if (valueObject.getGRUPO_LIQUIDACION() != null&&!valueObject.getGRUPO_LIQUIDACION().equals("")) {
			if (first) { first = false; }
			sql.append("AND GRUPO_LIQUIDACION= '").append(valueObject.getGRUPO_LIQUIDACION()).append("' ");
		}

		if (valueObject.getCILINDRAJE() != null&&!valueObject.getCILINDRAJE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CILINDRAJE= '").append(valueObject.getCILINDRAJE()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Viewconsvehiimpuestoslote valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
				valueObject.setPLACA(result.getString("PLACA"));
				valueObject.setVIGENCIA(result.getInt("VIGENCIA"));
				valueObject.setGRUPO_LIQUIDACION(result.getString("GRUPO_LIQUIDACION"));
				valueObject.setCILINDRAJE(result.getString("CILINDRAJE"));

			} else {
				throw new NotFoundException("ViewconsvehiimpuestosloteObject Not Found!");
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
				Viewconsvehiimpuestoslote temp = createValueObject();

				temp.setID(result.getInt("ID"));
				temp.setPLACA(result.getString("PLACA"));
				temp.setVIGENCIA(result.getInt("VIGENCIA"));
				temp.setGRUPO_LIQUIDACION(result.getString("GRUPO_LIQUIDACION"));
				temp.setCILINDRAJE(result.getString("CILINDRAJE"));
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
