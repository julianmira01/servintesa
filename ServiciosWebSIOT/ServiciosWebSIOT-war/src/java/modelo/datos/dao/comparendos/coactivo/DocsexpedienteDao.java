package modelo.datos.dao.comparendos.coactivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.coactivo.Docsexpediente;
import utilidades.Funciones;



public class DocsexpedienteDao {


	public Docsexpediente createValueObject() {
		return new Docsexpediente();
	}

	public Docsexpediente getObject(Connection conn,int ID_DOCSEXPEDIENTE) throws NotFoundException, SQLException {
		Docsexpediente valueObject = createValueObject();
		valueObject.setID_DOCSEXPEDIENTE(ID_DOCSEXPEDIENTE);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Docsexpediente valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM DOCSEXPEDIENTE WHERE (ID_DOCSEXPEDIENTE = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DOCSEXPEDIENTE());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM DOCSEXPEDIENTE ORDER BY ID_DOCSEXPEDIENTE ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_DOCSEXPEDIENTE) AS RowNumber FROM DOCSEXPEDIENTE) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Docsexpediente valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO DOCSEXPEDIENTE ( ID_DOCSEXPEDIENTE,"+
			" ID_EXPEDIENTE, ID_TIPODOC_COBRO, FECHA_REGISTRO,"+
			" FECHA_DOCUMENTO, CONSECUTIVO)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DOCSEXPEDIENTE());
				if(!Funciones.EnteroesNulo(valueObject.getID_EXPEDIENTE()))
					stmt.setInt(2, valueObject.getID_EXPEDIENTE());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPODOC_COBRO()))
					stmt.setInt(3, valueObject.getID_TIPODOC_COBRO());
				else
					stmt.setNull(3, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getFECHA_REGISTRO(),30))
					stmt.setString(4, valueObject.getFECHA_REGISTRO());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_DOCUMENTO(),30))
					stmt.setString(5, valueObject.getFECHA_DOCUMENTO());
				else
					stmt.setNull(5, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getCONSECUTIVO()))
					stmt.setInt(6, valueObject.getCONSECUTIVO());
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


	public void save(Connection conn, Docsexpediente valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE DOCSEXPEDIENTE SET  ID_EXPEDIENTE = ?, ID_TIPODOC_COBRO = ?, FECHA_REGISTRO = ?,"+
			" FECHA_DOCUMENTO = ?, CONSECUTIVO = ? WHERE (ID_DOCSEXPEDIENTE= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_EXPEDIENTE()))
					stmt.setInt(1, valueObject.getID_EXPEDIENTE());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPODOC_COBRO()))
					stmt.setInt(2, valueObject.getID_TIPODOC_COBRO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getFECHA_REGISTRO(),30))
					stmt.setString(3, valueObject.getFECHA_REGISTRO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_DOCUMENTO(),30))
					stmt.setString(4, valueObject.getFECHA_DOCUMENTO());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getCONSECUTIVO()))
					stmt.setInt(5, valueObject.getCONSECUTIVO());
				else
					stmt.setNull(5, Types.INTEGER);
				stmt.setInt(6, valueObject.getID_DOCSEXPEDIENTE());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Docsexpediente valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM DOCSEXPEDIENTE WHERE (ID_DOCSEXPEDIENTE = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DOCSEXPEDIENTE());

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
		String sql = "SELECT count(*) FROM DOCSEXPEDIENTE";
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
	public List searchMatching(Connection conn, Docsexpediente valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM DOCSEXPEDIENTE WHERE 1=1 ");
		if (valueObject.getID_DOCSEXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSEXPEDIENTE= ").append(valueObject.getID_DOCSEXPEDIENTE()).append(" ");
		}

		if (valueObject.getID_EXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTE= ").append(valueObject.getID_EXPEDIENTE()).append(" ");
		}

		if (valueObject.getID_TIPODOC_COBRO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOC_COBRO= ").append(valueObject.getID_TIPODOC_COBRO()).append(" ");
		}

		if (valueObject.getFECHA_REGISTRO() != null&&!valueObject.getFECHA_REGISTRO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_REGISTRO= '").append(valueObject.getFECHA_REGISTRO()).append("' ");
		}

		if (valueObject.getFECHA_DOCUMENTO() != null&&!valueObject.getFECHA_DOCUMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_DOCUMENTO= '").append(valueObject.getFECHA_DOCUMENTO()).append("' ");
		}

		if (valueObject.getCONSECUTIVO() != 0) {
			if (first) { first = false; }
			sql.append("AND CONSECUTIVO= ").append(valueObject.getCONSECUTIVO()).append(" ");
		}

		sql.append("ORDER BY ID_DOCSEXPEDIENTE ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Docsexpediente valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_DOCSEXPEDIENTE) AS RowNumber FROM DOCSEXPEDIENTE WHERE 1=1 ");
		if (valueObject.getID_DOCSEXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSEXPEDIENTE= ").append(valueObject.getID_DOCSEXPEDIENTE()).append(" ");
		}

		if (valueObject.getID_EXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTE= ").append(valueObject.getID_EXPEDIENTE()).append(" ");
		}

		if (valueObject.getID_TIPODOC_COBRO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOC_COBRO= ").append(valueObject.getID_TIPODOC_COBRO()).append(" ");
		}

		if (valueObject.getFECHA_REGISTRO() != null&&!valueObject.getFECHA_REGISTRO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_REGISTRO= '").append(valueObject.getFECHA_REGISTRO()).append("' ");
		}

		if (valueObject.getFECHA_DOCUMENTO() != null&&!valueObject.getFECHA_DOCUMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_DOCUMENTO= '").append(valueObject.getFECHA_DOCUMENTO()).append("' ");
		}

		if (valueObject.getCONSECUTIVO() != 0) {
			if (first) { first = false; }
			sql.append("AND CONSECUTIVO= ").append(valueObject.getCONSECUTIVO()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Docsexpediente valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM DOCSEXPEDIENTE WHERE 1=1 ");
		if (valueObject.getID_DOCSEXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSEXPEDIENTE= ").append(valueObject.getID_DOCSEXPEDIENTE()).append(" ");
		}

		if (valueObject.getID_EXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTE= ").append(valueObject.getID_EXPEDIENTE()).append(" ");
		}

		if (valueObject.getID_TIPODOC_COBRO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOC_COBRO= ").append(valueObject.getID_TIPODOC_COBRO()).append(" ");
		}

		if (valueObject.getFECHA_REGISTRO() != null&&!valueObject.getFECHA_REGISTRO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_REGISTRO= '").append(valueObject.getFECHA_REGISTRO()).append("' ");
		}

		if (valueObject.getFECHA_DOCUMENTO() != null&&!valueObject.getFECHA_DOCUMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_DOCUMENTO= '").append(valueObject.getFECHA_DOCUMENTO()).append("' ");
		}

		if (valueObject.getCONSECUTIVO() != 0) {
			if (first) { first = false; }
			sql.append("AND CONSECUTIVO= ").append(valueObject.getCONSECUTIVO()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Docsexpediente valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_DOCSEXPEDIENTE(result.getInt("ID_DOCSEXPEDIENTE"));
				valueObject.setID_EXPEDIENTE(result.getInt("ID_EXPEDIENTE"));
				valueObject.setID_TIPODOC_COBRO(result.getInt("ID_TIPODOC_COBRO"));
				valueObject.setFECHA_REGISTRO(result.getString("FECHA_REGISTRO"));
				valueObject.setFECHA_DOCUMENTO(result.getString("FECHA_DOCUMENTO"));
				valueObject.setCONSECUTIVO(result.getInt("CONSECUTIVO"));

			} else {
				throw new NotFoundException("DocsexpedienteObject Not Found!");
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
				Docsexpediente temp = createValueObject();

				temp.setID_DOCSEXPEDIENTE(result.getInt("ID_DOCSEXPEDIENTE"));
				temp.setID_EXPEDIENTE(result.getInt("ID_EXPEDIENTE"));
				temp.setID_TIPODOC_COBRO(result.getInt("ID_TIPODOC_COBRO"));
				temp.setFECHA_REGISTRO(result.getString("FECHA_REGISTRO"));
				temp.setFECHA_DOCUMENTO(result.getString("FECHA_DOCUMENTO"));
				temp.setCONSECUTIVO(result.getInt("CONSECUTIVO"));
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
