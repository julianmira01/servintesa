package modelo.datos.dao.liquidador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.liquidador.Fechaimpuesto;
import utilidades.Funciones;



public class FechaimpuestoDao {


	public Fechaimpuesto createValueObject() {
		return new Fechaimpuesto();
	}

	public Fechaimpuesto getObject(Connection conn,int ID_FECHAIMPUESTO) throws NotFoundException, SQLException {
		Fechaimpuesto valueObject = createValueObject();
		valueObject.setID_FECHAIMPUESTO(ID_FECHAIMPUESTO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Fechaimpuesto valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM FECHAIMPUESTO WHERE (ID_FECHAIMPUESTO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_FECHAIMPUESTO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM FECHAIMPUESTO ORDER BY ID_FECHAIMPUESTO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_FECHAIMPUESTO) AS RowNumber FROM FECHAIMPUESTO) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Fechaimpuesto valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO FECHAIMPUESTO ( ID_FECHAIMPUESTO,"+
			" VIGENCIA, FECHLIMITE_PAGO)"+
			 "VALUES ( ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_FECHAIMPUESTO());
				if(!Funciones.EnteroesNulo(valueObject.getVIGENCIA()))
					stmt.setInt(2, valueObject.getVIGENCIA());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getFECHLIMITE_PAGO(),0))
					stmt.setString(3, valueObject.getFECHLIMITE_PAGO());
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


	public void save(Connection conn, Fechaimpuesto valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE FECHAIMPUESTO SET  VIGENCIA = ?, FECHLIMITE_PAGO = ? WHERE (ID_FECHAIMPUESTO= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getVIGENCIA()))
					stmt.setInt(1, valueObject.getVIGENCIA());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getFECHLIMITE_PAGO(),0))
					stmt.setString(2, valueObject.getFECHLIMITE_PAGO());
				else
					stmt.setNull(2, Types.VARCHAR);
				stmt.setInt(3, valueObject.getID_FECHAIMPUESTO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Fechaimpuesto valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM FECHAIMPUESTO WHERE (ID_FECHAIMPUESTO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_FECHAIMPUESTO());

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
		String sql = "SELECT count(*) FROM FECHAIMPUESTO";
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
	public List searchMatching(Connection conn, Fechaimpuesto valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM FECHAIMPUESTO WHERE 1=1 ");
		if (valueObject.getID_FECHAIMPUESTO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_FECHAIMPUESTO= ").append(valueObject.getID_FECHAIMPUESTO()).append(" ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		if (valueObject.getFECHLIMITE_PAGO() != null&&!valueObject.getFECHLIMITE_PAGO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHLIMITE_PAGO= '").append(valueObject.getFECHLIMITE_PAGO()).append("' ");
		}

		sql.append("ORDER BY ID_FECHAIMPUESTO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Fechaimpuesto valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_FECHAIMPUESTO) AS RowNumber FROM FECHAIMPUESTO WHERE 1=1 ");
		if (valueObject.getID_FECHAIMPUESTO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_FECHAIMPUESTO= ").append(valueObject.getID_FECHAIMPUESTO()).append(" ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		if (valueObject.getFECHLIMITE_PAGO() != null&&!valueObject.getFECHLIMITE_PAGO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHLIMITE_PAGO= '").append(valueObject.getFECHLIMITE_PAGO()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Fechaimpuesto valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM FECHAIMPUESTO WHERE 1=1 ");
		if (valueObject.getID_FECHAIMPUESTO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_FECHAIMPUESTO= ").append(valueObject.getID_FECHAIMPUESTO()).append(" ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		if (valueObject.getFECHLIMITE_PAGO() != null&&!valueObject.getFECHLIMITE_PAGO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHLIMITE_PAGO= '").append(valueObject.getFECHLIMITE_PAGO()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Fechaimpuesto valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_FECHAIMPUESTO(result.getInt("ID_FECHAIMPUESTO"));
				valueObject.setVIGENCIA(result.getInt("VIGENCIA"));
				valueObject.setFECHLIMITE_PAGO(result.getString("FECHLIMITE_PAGO"));

			} else {
				throw new NotFoundException("FechaimpuestoObject Not Found!");
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
				Fechaimpuesto temp = createValueObject();

				temp.setID_FECHAIMPUESTO(result.getInt("ID_FECHAIMPUESTO"));
				temp.setVIGENCIA(result.getInt("VIGENCIA"));
				temp.setFECHLIMITE_PAGO(result.getString("FECHLIMITE_PAGO"));
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
