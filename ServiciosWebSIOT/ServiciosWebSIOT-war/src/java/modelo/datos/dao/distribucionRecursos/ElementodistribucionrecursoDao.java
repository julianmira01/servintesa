package modelo.datos.dao.distribucionRecursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.distribucionRecursos.Elementodistribucionrecurso;
import utilidades.Funciones;



public class ElementodistribucionrecursoDao {


	public Elementodistribucionrecurso createValueObject() {
		return new Elementodistribucionrecurso();
	}

	public Elementodistribucionrecurso getObject(Connection conn,int ID_ELEMENTO) throws NotFoundException, SQLException {
		Elementodistribucionrecurso valueObject = createValueObject();
		valueObject.setID_ELEMENTO(ID_ELEMENTO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Elementodistribucionrecurso valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM ELEMENTODISTRIBUCIONRECURSO WHERE (ID_ELEMENTO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_ELEMENTO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM ELEMENTODISTRIBUCIONRECURSO ORDER BY ID_ELEMENTO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_ELEMENTO) AS RowNumber FROM ELEMENTODISTRIBUCIONRECURSO) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Elementodistribucionrecurso valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO ELEMENTODISTRIBUCIONRECURSO ( ID_ELEMENTO,"+
			" COD_ELEMENTO, NOMBREELEMENTO, LIQUIDAR_PORCOMPARENDO"+
			")"+
			 "VALUES ( ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_ELEMENTO());
				if(Funciones.contarCadena(valueObject.getCOD_ELEMENTO(),10))
					stmt.setString(2, valueObject.getCOD_ELEMENTO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBREELEMENTO(),40))
					stmt.setString(3, valueObject.getNOMBREELEMENTO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getLIQUIDAR_PORCOMPARENDO(),1))
					stmt.setString(4, valueObject.getLIQUIDAR_PORCOMPARENDO());
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


	public void save(Connection conn, Elementodistribucionrecurso valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE ELEMENTODISTRIBUCIONRECURSO SET  COD_ELEMENTO = ?, NOMBREELEMENTO = ?, LIQUIDAR_PORCOMPARENDO = ?"+
			" WHERE (ID_ELEMENTO= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getCOD_ELEMENTO(),10))
					stmt.setString(1, valueObject.getCOD_ELEMENTO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBREELEMENTO(),40))
					stmt.setString(2, valueObject.getNOMBREELEMENTO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getLIQUIDAR_PORCOMPARENDO(),1))
					stmt.setString(3, valueObject.getLIQUIDAR_PORCOMPARENDO());
				else
					stmt.setNull(3, Types.VARCHAR);
				stmt.setInt(4, valueObject.getID_ELEMENTO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Elementodistribucionrecurso valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM ELEMENTODISTRIBUCIONRECURSO WHERE (ID_ELEMENTO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_ELEMENTO());

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
		String sql = "SELECT count(*) FROM ELEMENTODISTRIBUCIONRECURSO";
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
	public List searchMatching(Connection conn, Elementodistribucionrecurso valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM ELEMENTODISTRIBUCIONRECURSO WHERE 1=1 ");
		if (valueObject.getID_ELEMENTO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ELEMENTO= ").append(valueObject.getID_ELEMENTO()).append(" ");
		}

		if (valueObject.getCOD_ELEMENTO() != null&&!valueObject.getCOD_ELEMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND COD_ELEMENTO= '").append(valueObject.getCOD_ELEMENTO()).append("' ");
		}

		if (valueObject.getNOMBREELEMENTO() != null&&!valueObject.getNOMBREELEMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBREELEMENTO= '").append(valueObject.getNOMBREELEMENTO()).append("' ");
		}

		if (valueObject.getLIQUIDAR_PORCOMPARENDO() != null&&!valueObject.getLIQUIDAR_PORCOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND LIQUIDAR_PORCOMPARENDO= '").append(valueObject.getLIQUIDAR_PORCOMPARENDO()).append("' ");
		}

		sql.append("ORDER BY ID_ELEMENTO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Elementodistribucionrecurso valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_ELEMENTO) AS RowNumber FROM ELEMENTODISTRIBUCIONRECURSO WHERE 1=1 ");
		if (valueObject.getID_ELEMENTO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ELEMENTO= ").append(valueObject.getID_ELEMENTO()).append(" ");
		}

		if (valueObject.getCOD_ELEMENTO() != null&&!valueObject.getCOD_ELEMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND COD_ELEMENTO= '").append(valueObject.getCOD_ELEMENTO()).append("' ");
		}

		if (valueObject.getNOMBREELEMENTO() != null&&!valueObject.getNOMBREELEMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBREELEMENTO= '").append(valueObject.getNOMBREELEMENTO()).append("' ");
		}

		if (valueObject.getLIQUIDAR_PORCOMPARENDO() != null&&!valueObject.getLIQUIDAR_PORCOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND LIQUIDAR_PORCOMPARENDO= '").append(valueObject.getLIQUIDAR_PORCOMPARENDO()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Elementodistribucionrecurso valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM ELEMENTODISTRIBUCIONRECURSO WHERE 1=1 ");
		if (valueObject.getID_ELEMENTO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_ELEMENTO= ").append(valueObject.getID_ELEMENTO()).append(" ");
		}

		if (valueObject.getCOD_ELEMENTO() != null&&!valueObject.getCOD_ELEMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND COD_ELEMENTO= '").append(valueObject.getCOD_ELEMENTO()).append("' ");
		}

		if (valueObject.getNOMBREELEMENTO() != null&&!valueObject.getNOMBREELEMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBREELEMENTO= '").append(valueObject.getNOMBREELEMENTO()).append("' ");
		}

		if (valueObject.getLIQUIDAR_PORCOMPARENDO() != null&&!valueObject.getLIQUIDAR_PORCOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND LIQUIDAR_PORCOMPARENDO= '").append(valueObject.getLIQUIDAR_PORCOMPARENDO()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Elementodistribucionrecurso valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_ELEMENTO(result.getInt("ID_ELEMENTO"));
				valueObject.setCOD_ELEMENTO(result.getString("COD_ELEMENTO"));
				valueObject.setNOMBREELEMENTO(result.getString("NOMBREELEMENTO"));
				valueObject.setLIQUIDAR_PORCOMPARENDO(result.getString("LIQUIDAR_PORCOMPARENDO"));

			} else {
				throw new NotFoundException("ElementodistribucionrecursoObject Not Found!");
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
				Elementodistribucionrecurso temp = createValueObject();

				temp.setID_ELEMENTO(result.getInt("ID_ELEMENTO"));
				temp.setCOD_ELEMENTO(result.getString("COD_ELEMENTO"));
				temp.setNOMBREELEMENTO(result.getString("NOMBREELEMENTO"));
				temp.setLIQUIDAR_PORCOMPARENDO(result.getString("LIQUIDAR_PORCOMPARENDO"));
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
