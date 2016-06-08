package modelo.datos.dao.documentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.objetos.documentos.Tipodocgenerar;
import utilidades.Funciones;



public class TipodocgenerarDao {


	public Tipodocgenerar createValueObject() {
		return new Tipodocgenerar();
	}

	public Tipodocgenerar getObject(Connection conn,int ID_TIPODOCGENERAR) throws SQLException {
		Tipodocgenerar valueObject = createValueObject();
		valueObject.setID_TIPODOCGENERAR(ID_TIPODOCGENERAR);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Tipodocgenerar valueObject) throws SQLException {
		String sql = "SELECT * FROM TIPODOCGENERAR WHERE (ID_TIPODOCGENERAR = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_TIPODOCGENERAR());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM TIPODOCGENERAR ORDER BY ID_TIPODOCGENERAR ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_TIPODOCGENERAR) AS RowNumber FROM TIPODOCGENERAR) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Tipodocgenerar valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO TIPODOCGENERAR ( ID_TIPODOCGENERAR,"+
			" DES_TIPODOCGENERAR, PREFIJO)"+
			 "VALUES ( ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_TIPODOCGENERAR());
				if(Funciones.contarCadena(valueObject.getDES_TIPODOCGENERAR(),50))
					stmt.setString(2, valueObject.getDES_TIPODOCGENERAR());
				else
					stmt.setNull(2, Types.VARCHAR);
                    
			        if(Funciones.contarCadena(valueObject.getPREFIJO(),20))
			                stmt.setString(3, valueObject.getPREFIJO());
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


	public void save(Connection conn, Tipodocgenerar valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE TIPODOCGENERAR SET  DES_TIPODOCGENERAR = ?, PREFIJO = ? WHERE (ID_TIPODOCGENERAR= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getDES_TIPODOCGENERAR(),50))
					stmt.setString(1, valueObject.getDES_TIPODOCGENERAR());
				else
					stmt.setNull(1, Types.VARCHAR);
			    if(Funciones.contarCadena(valueObject.getPREFIJO(),20))
			            stmt.setString(2, valueObject.getPREFIJO());
			    else
			            stmt.setNull(2, Types.VARCHAR);
                                
                                stmt.setInt(3, valueObject.getID_TIPODOCGENERAR());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Tipodocgenerar valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM TIPODOCGENERAR WHERE (ID_TIPODOCGENERAR = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_TIPODOCGENERAR());

			int rowcount = databaseUpdate(conn, stmt);
			if (rowcount == 0) {
				throw new SQLException();
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
		String sql = "SELECT count(*) FROM TIPODOCGENERAR";
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
	public List searchMatching(Connection conn, Tipodocgenerar valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM TIPODOCGENERAR WHERE 1=1 ");
		if (valueObject.getID_TIPODOCGENERAR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOCGENERAR= ").append(valueObject.getID_TIPODOCGENERAR()).append(" ");
		}

		if (valueObject.getDES_TIPODOCGENERAR() != null&&!valueObject.getDES_TIPODOCGENERAR().equals("")) {
			if (first) { first = false; }
			sql.append("AND DES_TIPODOCGENERAR= '").append(valueObject.getDES_TIPODOCGENERAR()).append("' ");
		}
                
	    if (valueObject.getPREFIJO() != null&&!valueObject.getPREFIJO().equals("")) {
	            if (first) { first = false; }
	            sql.append("AND PREFIJO= '").append(valueObject.getPREFIJO()).append("' ");
	    }

		sql.append("ORDER BY ID_TIPODOCGENERAR ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Tipodocgenerar valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_TIPODOCGENERAR) AS RowNumber FROM TIPODOCGENERAR WHERE 1=1 ");
		if (valueObject.getID_TIPODOCGENERAR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOCGENERAR= ").append(valueObject.getID_TIPODOCGENERAR()).append(" ");
		}

		if (valueObject.getDES_TIPODOCGENERAR() != null&&!valueObject.getDES_TIPODOCGENERAR().equals("")) {
			if (first) { first = false; }
			sql.append("AND DES_TIPODOCGENERAR= '").append(valueObject.getDES_TIPODOCGENERAR()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Tipodocgenerar valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM TIPODOCGENERAR WHERE 1=1 ");
		if (valueObject.getID_TIPODOCGENERAR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPODOCGENERAR= ").append(valueObject.getID_TIPODOCGENERAR()).append(" ");
		}

		if (valueObject.getDES_TIPODOCGENERAR() != null&&!valueObject.getDES_TIPODOCGENERAR().equals("")) {
			if (first) { first = false; }
			sql.append("AND DES_TIPODOCGENERAR= '").append(valueObject.getDES_TIPODOCGENERAR()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Tipodocgenerar valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_TIPODOCGENERAR(result.getInt("ID_TIPODOCGENERAR"));
				valueObject.setDES_TIPODOCGENERAR(result.getString("DES_TIPODOCGENERAR"));
			        valueObject.setPREFIJO(result.getString("PREFIJO"));


			} else {
				throw new SQLException();
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
				Tipodocgenerar temp = createValueObject();

				temp.setID_TIPODOCGENERAR(result.getInt("ID_TIPODOCGENERAR"));
				temp.setDES_TIPODOCGENERAR(result.getString("DES_TIPODOCGENERAR"));
			        temp.setPREFIJO(result.getString("PREFIJO"));
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
