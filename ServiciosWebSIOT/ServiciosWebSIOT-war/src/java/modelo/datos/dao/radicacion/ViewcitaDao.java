package modelo.datos.dao.radicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.objetos.radicacion.Viewcita;

import utilidades.Funciones;



public class ViewcitaDao {


	public Viewcita createValueObject() {
		return new Viewcita();
	}

	public Viewcita getObject(Connection conn,int NUMERO_CITA) throws  SQLException {
		Viewcita valueObject = createValueObject();
		valueObject.setNUMERO_CITA(NUMERO_CITA);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Viewcita valueObject) throws  SQLException {
		String sql = "SELECT * FROM VIEW_CITA WHERE (NUMERO_CITA = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getNUMERO_CITA());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM VIEW_CITA ORDER BY NUMERO_CITA ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY NUMERO_CITA) AS RowNumber FROM VIEW_CITA) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Viewcita valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO VIEW_CITA ( NUMERO_CITA,"+
			" ESTADO, DEPENDENCIA, FECHA"+
			")"+
			 "VALUES ( ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getNUMERO_CITA());
				if(Funciones.contarCadena(valueObject.getESTADO(),15))
					stmt.setString(2, valueObject.getESTADO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDEPENDENCIA(),50))
					stmt.setString(3, valueObject.getDEPENDENCIA());
				else
					stmt.setNull(3, Types.VARCHAR);
				
        
        
			  if (Funciones.esFecha(valueObject.getFECHA()))
			    stmt.setDate(4, Funciones.convFechaSSQL(valueObject.getFECHA()));
			  else
			    stmt.setNull(4, Types.DATE);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Viewcita valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE VIEW_CITA SET  ESTADO = ?, DEPENDENCIA = ?, FECHA = ?"+
			" WHERE (NUMERO_CITA= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getESTADO(),15))
					stmt.setString(1, valueObject.getESTADO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDEPENDENCIA(),50))
					stmt.setString(2, valueObject.getDEPENDENCIA());
				else
					stmt.setNull(2, Types.VARCHAR);
				
        
			  if (Funciones.esFecha(valueObject.getFECHA()))
			    stmt.setDate(3, Funciones.convFechaSSQL(valueObject.getFECHA()));
			  else
			    stmt.setNull(3, Types.DATE);
        
				stmt.setInt(4, valueObject.getNUMERO_CITA());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Viewcita valueObject) throws  SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM VIEW_CITA WHERE (NUMERO_CITA = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getNUMERO_CITA());

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
		String sql = "SELECT count(*) FROM VIEW_CITA";
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
	public List searchMatching(Connection conn, Viewcita valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_CITA WHERE 1=1 ");
		if (valueObject.getNUMERO_CITA() != 0) {
			if (first) { first = false; }
			sql.append("AND NUMERO_CITA= ").append(valueObject.getNUMERO_CITA()).append(" ");
		}

		if (valueObject.getESTADO() != null&&!valueObject.getESTADO().equals("")) {
			if (first) { first = false; }
			sql.append("AND ESTADO= '").append(valueObject.getESTADO()).append("' ");
		}

		if (valueObject.getDEPENDENCIA() != null&&!valueObject.getDEPENDENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND DEPENDENCIA= '").append(valueObject.getDEPENDENCIA()).append("' ");
		}

		if (valueObject.getFECHA() != null&&!valueObject.getFECHA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA= '").append(valueObject.getFECHA()).append("' ");
		}

		sql.append("ORDER BY NUMERO_CITA ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Viewcita valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY NUMERO_CITA) AS RowNumber FROM VIEW_CITA WHERE 1=1 ");
		if (valueObject.getNUMERO_CITA() != 0) {
			if (first) { first = false; }
			sql.append("AND NUMERO_CITA= ").append(valueObject.getNUMERO_CITA()).append(" ");
		}

		if (valueObject.getESTADO() != null&&!valueObject.getESTADO().equals("")) {
			if (first) { first = false; }
			sql.append("AND ESTADO= '").append(valueObject.getESTADO()).append("' ");
		}

		if (valueObject.getDEPENDENCIA() != null&&!valueObject.getDEPENDENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND DEPENDENCIA= '").append(valueObject.getDEPENDENCIA()).append("' ");
		}

		if (valueObject.getFECHA() != null&&!valueObject.getFECHA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA= '").append(valueObject.getFECHA()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Viewcita valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM VIEW_CITA WHERE 1=1 ");
		if (valueObject.getNUMERO_CITA() != 0) {
			if (first) { first = false; }
			sql.append("AND NUMERO_CITA= ").append(valueObject.getNUMERO_CITA()).append(" ");
		}

		if (valueObject.getESTADO() != null&&!valueObject.getESTADO().equals("")) {
			if (first) { first = false; }
			sql.append("AND ESTADO= '").append(valueObject.getESTADO()).append("' ");
		}

		if (valueObject.getDEPENDENCIA() != null&&!valueObject.getDEPENDENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND DEPENDENCIA= '").append(valueObject.getDEPENDENCIA()).append("' ");
		}

		if (valueObject.getFECHA() != null&&!valueObject.getFECHA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA= '").append(valueObject.getFECHA()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Viewcita valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setNUMERO_CITA(result.getInt("NUMERO_CITA"));
				valueObject.setESTADO(result.getString("ESTADO"));
				valueObject.setDEPENDENCIA(result.getString("DEPENDENCIA"));
				valueObject.setFECHA(result.getString("FECHA"));

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
				Viewcita temp = createValueObject();

				temp.setNUMERO_CITA(result.getInt("NUMERO_CITA"));
				temp.setESTADO(result.getString("ESTADO"));
				temp.setDEPENDENCIA(result.getString("DEPENDENCIA"));
				temp.setFECHA(result.getString("FECHA"));
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
