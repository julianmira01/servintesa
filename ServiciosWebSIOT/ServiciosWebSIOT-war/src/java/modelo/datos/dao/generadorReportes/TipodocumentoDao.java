package modelo.datos.dao.generadorReportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.generadorReportes.Tipodocumento;
import utilidades.Funciones;



public class TipodocumentoDao {


	public Tipodocumento createValueObject() {
		return new Tipodocumento();
	}

	public Tipodocumento getObject(Connection conn,int ID) throws NotFoundException, SQLException {
		Tipodocumento valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Tipodocumento valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM TIPO_DOCUMENTO WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM TIPO_DOCUMENTO ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Tipodocumento valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO TIPO_DOCUMENTO ( EXTENSION_ARCHIVO, CODIGO, TITULO"+
			")"+
			 "VALUES ( ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getEXTENSION_ARCHIVO(),5))
					stmt.setString(1, valueObject.getEXTENSION_ARCHIVO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getCODIGO()))
					stmt.setInt(2, valueObject.getCODIGO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getTITULO(),10))
					stmt.setString(3, valueObject.getTITULO());
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


	public void save(Connection conn, Tipodocumento valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE TIPO_DOCUMENTO SET  EXTENSION_ARCHIVO = ?, CODIGO = ?, TITULO = ?"+
			" WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getEXTENSION_ARCHIVO(),5))
					stmt.setString(1, valueObject.getEXTENSION_ARCHIVO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getCODIGO()))
					stmt.setInt(2, valueObject.getCODIGO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getTITULO(),10))
					stmt.setString(3, valueObject.getTITULO());
				else
					stmt.setNull(3, Types.VARCHAR);
				stmt.setInt(4, valueObject.getID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Tipodocumento valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM TIPO_DOCUMENTO WHERE (ID = ? )";
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


	public List searchMatching(Connection conn, Tipodocumento valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM TIPO_DOCUMENTO WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getEXTENSION_ARCHIVO() != null && !valueObject.getEXTENSION_ARCHIVO().equals("") && !valueObject.getEXTENSION_ARCHIVO().equals("")) {
			if (first) { first = false; }
			sql.append("AND EXTENSION_ARCHIVO= '").append(valueObject.getEXTENSION_ARCHIVO()).append("' ");
		}

		if (valueObject.getCODIGO() != 0) {
			if (first) { first = false; }
			sql.append("AND CODIGO= ").append(valueObject.getCODIGO()).append(" ");
		}

		if (valueObject.getTITULO() != null && !valueObject.getTITULO().equals("") && !valueObject.getTITULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TITULO= '").append(valueObject.getTITULO()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Tipodocumento valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
				valueObject.setEXTENSION_ARCHIVO(result.getString("EXTENSION_ARCHIVO"));
				valueObject.setCODIGO(result.getInt("CODIGO"));
				valueObject.setTITULO(result.getString("TITULO"));

			} else {
				throw new NotFoundException("TipodocumentoObject Not Found!");
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
					Tipodocumento temp = createValueObject();

					temp.setID(result.getInt("ID"));
					temp.setEXTENSION_ARCHIVO(result.getString("EXTENSION_ARCHIVO"));
					temp.setCODIGO(result.getInt("CODIGO"));
					temp.setTITULO(result.getString("TITULO"));
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
