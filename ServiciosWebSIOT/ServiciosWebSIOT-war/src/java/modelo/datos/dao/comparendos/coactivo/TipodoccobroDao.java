package modelo.datos.dao.comparendos.coactivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.coactivo.Tipodoccobro;
import utilidades.Funciones;



public class TipodoccobroDao {


	public Tipodoccobro createValueObject() {
		return new Tipodoccobro();
	}

	public Tipodoccobro getObject(Connection conn,int ID_TIPODOC_COBRO) throws NotFoundException, SQLException {
		Tipodoccobro valueObject = createValueObject();
		valueObject.setID_TIPODOC_COBRO(ID_TIPODOC_COBRO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Tipodoccobro valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM TIPODOC_COBRO WHERE (ID_TIPODOC_COBRO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_TIPODOC_COBRO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM TIPODOC_COBRO ORDER BY ID_TIPODOC_COBRO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_TIPODOC_COBRO) AS RowNumber FROM TIPODOC_COBRO) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Tipodoccobro valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO TIPODOC_COBRO ( ID_TIPODOC_COBRO,"+
			" DESCRIPCION)"+
			 "VALUES ( ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_TIPODOC_COBRO());
				if(Funciones.contarCadena(valueObject.getDESCRIPCION(),0))
					stmt.setString(2, valueObject.getDESCRIPCION());
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


	public void save(Connection conn, Tipodoccobro valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE TIPODOC_COBRO SET  DESCRIPCION = ? WHERE (ID_TIPODOC_COBRO= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getDESCRIPCION(),0))
					stmt.setString(1, valueObject.getDESCRIPCION());
				else
					stmt.setNull(1, Types.VARCHAR);
				stmt.setInt(2, valueObject.getID_TIPODOC_COBRO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Tipodoccobro valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM TIPODOC_COBRO WHERE (ID_TIPODOC_COBRO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_TIPODOC_COBRO());

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
		String sql = "SELECT count(*) FROM TIPODOC_COBRO";
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
	public List searchMatching(Connection conn, Tipodoccobro valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM TIPODOC_COBRO WHERE 1=1 ");
		if (valueObject.getID_TIPODOC_COBRO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOC_COBRO= ").append(valueObject.getID_TIPODOC_COBRO()).append(" ");
		}

		if (valueObject.getDESCRIPCION() != null&&!valueObject.getDESCRIPCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DESCRIPCION= '").append(valueObject.getDESCRIPCION()).append("' ");
		}

		sql.append("ORDER BY ID_TIPODOC_COBRO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Tipodoccobro valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_TIPODOC_COBRO) AS RowNumber FROM TIPODOC_COBRO WHERE 1=1 ");
		if (valueObject.getID_TIPODOC_COBRO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOC_COBRO= ").append(valueObject.getID_TIPODOC_COBRO()).append(" ");
		}

		if (valueObject.getDESCRIPCION() != null&&!valueObject.getDESCRIPCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DESCRIPCION= '").append(valueObject.getDESCRIPCION()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Tipodoccobro valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM TIPODOC_COBRO WHERE 1=1 ");
		if (valueObject.getID_TIPODOC_COBRO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOC_COBRO= ").append(valueObject.getID_TIPODOC_COBRO()).append(" ");
		}

		if (valueObject.getDESCRIPCION() != null&&!valueObject.getDESCRIPCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DESCRIPCION= '").append(valueObject.getDESCRIPCION()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Tipodoccobro valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_TIPODOC_COBRO(result.getInt("ID_TIPODOC_COBRO"));
				valueObject.setDESCRIPCION(result.getString("DESCRIPCION"));

			} else {
				throw new NotFoundException("TipodoccobroObject Not Found!");
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
				Tipodoccobro temp = createValueObject();

				temp.setID_TIPODOC_COBRO(result.getInt("ID_TIPODOC_COBRO"));
				temp.setDESCRIPCION(result.getString("DESCRIPCION"));
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

