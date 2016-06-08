package modelo.datos.dao.comparendos.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.objetos.comparendos.generales.Historialcomparendo;
import utilidades.Funciones;



public class HistorialcomparendoDao {


	public Historialcomparendo createValueObject() {
		return new Historialcomparendo();
	}

	public Historialcomparendo getObject(Connection conn,int ID_HISTORIALCOMPARENDO) throws SQLException {
		Historialcomparendo valueObject = createValueObject();
		valueObject.setID_HISTORIALCOMPARENDO(ID_HISTORIALCOMPARENDO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Historialcomparendo valueObject) throws SQLException {
		String sql = "SELECT * FROM HISTORIALCOMPARENDO WHERE (ID_HISTORIALCOMPARENDO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_HISTORIALCOMPARENDO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM HISTORIALCOMPARENDO ORDER BY ID_HISTORIALCOMPARENDO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_HISTORIALCOMPARENDO) AS RowNumber FROM HISTORIALCOMPARENDO) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Historialcomparendo valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO HISTORIALCOMPARENDO ( ID_HISTORIALCOMPARENDO,"+
			" ID_INFRACCIONCOMPARENDO, ID_PASO, ID_DOCSRESOLUCIONES,"+
			" ID_DOCSACTAS, AVANCEPROCESO, ID_USUARIO,"+
			" FECHA, HORA, IP,"+
			" NOMBREEQUIPO)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_HISTORIALCOMPARENDO());
				if(!Funciones.EnteroesNulo(valueObject.getID_INFRACCIONCOMPARENDO()))
					stmt.setInt(2, valueObject.getID_INFRACCIONCOMPARENDO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_PASO()))
					stmt.setInt(3, valueObject.getID_PASO());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_DOCSRESOLUCIONES()))
					stmt.setInt(4, valueObject.getID_DOCSRESOLUCIONES());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_DOCSACTAS()))
					stmt.setInt(5, valueObject.getID_DOCSACTAS());
				else
					stmt.setNull(5, Types.INTEGER);
				if(!Funciones.DoubleEsNulo(valueObject.getAVANCEPROCESO()))
					stmt.setDouble(6, valueObject.getAVANCEPROCESO());
				else
					stmt.setNull(6, Types.DOUBLE);
				if(!Funciones.EnteroesNulo(valueObject.getID_USUARIO()))
					stmt.setInt(7, valueObject.getID_USUARIO());
				else
					stmt.setNull(7, Types.INTEGER);
        
        				
			  if (Funciones.esFecha(valueObject.getFECHA()))
			      stmt.setDate(8, Funciones.convFechaSSQL(valueObject.getFECHA()));
			  else
			      stmt.setNull(8, Types.DATE);
        
				
        //if(Funciones.contarCadena(valueObject.getHORA(),40))
				//	stmt.setString(9, valueObject.getHORA());
				//else
				//	stmt.setNull(9, Types.VARCHAR);
			  if (Funciones.esTime(valueObject.getHORA()))
			  stmt.setTime(9,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORA())));
			  else
			  stmt.setNull(9, Types.TIME);
        
        
				if(Funciones.contarCadena(valueObject.getIP(),30))
					stmt.setString(10, valueObject.getIP());
				else
					stmt.setNull(10, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBREEQUIPO(),30))
					stmt.setString(11, valueObject.getNOMBREEQUIPO());
				else
					stmt.setNull(11, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Historialcomparendo valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE HISTORIALCOMPARENDO SET  ID_INFRACCIONCOMPARENDO = ?, ID_PASO = ?, ID_DOCSRESOLUCIONES = ?,"+
			" ID_DOCSACTAS = ?, AVANCEPROCESO = ?, ID_USUARIO = ?,"+
			" FECHA = ?, HORA = ?, IP = ?,"+
			" NOMBREEQUIPO = ? WHERE (ID_HISTORIALCOMPARENDO= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_INFRACCIONCOMPARENDO()))
					stmt.setInt(1, valueObject.getID_INFRACCIONCOMPARENDO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_PASO()))
					stmt.setInt(2, valueObject.getID_PASO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_DOCSRESOLUCIONES()))
					stmt.setInt(3, valueObject.getID_DOCSRESOLUCIONES());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_DOCSACTAS()))
					stmt.setInt(4, valueObject.getID_DOCSACTAS());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.DoubleEsNulo(valueObject.getAVANCEPROCESO()))
					stmt.setDouble(5, valueObject.getAVANCEPROCESO());
				else
					stmt.setNull(5, Types.DOUBLE);
				if(!Funciones.EnteroesNulo(valueObject.getID_USUARIO()))
					stmt.setInt(6, valueObject.getID_USUARIO());
				else
					stmt.setNull(6, Types.INTEGER);
				
        
        
			  if (Funciones.esFecha(valueObject.getFECHA()))
			      stmt.setDate(7, Funciones.convFechaSSQL(valueObject.getFECHA()));
			  else
			      stmt.setNull(7, Types.DATE);

				//if(Funciones.contarCadena(valueObject.getHORA(),40))
					//stmt.setString(8, valueObject.getHORA());
				//else
					//stmt.setNull(8, Types.VARCHAR);
			  if (Funciones.esTime(valueObject.getHORA()))
          stmt.setTime(8,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORA())));
			  else
          stmt.setNull(8, Types.TIME);
        
				if(Funciones.contarCadena(valueObject.getIP(),30))
					stmt.setString(9, valueObject.getIP());
				else
					stmt.setNull(9, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBREEQUIPO(),30))
					stmt.setString(10, valueObject.getNOMBREEQUIPO());
				else
					stmt.setNull(10, Types.VARCHAR);
				stmt.setInt(11, valueObject.getID_HISTORIALCOMPARENDO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Historialcomparendo valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM HISTORIALCOMPARENDO WHERE (ID_HISTORIALCOMPARENDO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_HISTORIALCOMPARENDO());

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
		String sql = "SELECT count(*) FROM HISTORIALCOMPARENDO";
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
	public List searchMatching(Connection conn, Historialcomparendo valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM HISTORIALCOMPARENDO WHERE 1=1 ");
		if (valueObject.getID_HISTORIALCOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_HISTORIALCOMPARENDO= ").append(valueObject.getID_HISTORIALCOMPARENDO()).append(" ");
		}

		if (valueObject.getID_INFRACCIONCOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACCIONCOMPARENDO= ").append(valueObject.getID_INFRACCIONCOMPARENDO()).append(" ");
		}

		if (valueObject.getID_PASO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PASO= ").append(valueObject.getID_PASO()).append(" ");
		}

		if (valueObject.getID_DOCSRESOLUCIONES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSRESOLUCIONES= ").append(valueObject.getID_DOCSRESOLUCIONES()).append(" ");
		}

		if (valueObject.getID_DOCSACTAS() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSACTAS= ").append(valueObject.getID_DOCSACTAS()).append(" ");
		}

		if (valueObject.getAVANCEPROCESO() != 0) {
			if (first) { first = false; }
			sql.append("AND AVANCEPROCESO= ").append(valueObject.getAVANCEPROCESO()).append(" ");
		}

		if (valueObject.getID_USUARIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
		}

		if (valueObject.getFECHA() != null&&!valueObject.getFECHA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA= '").append(valueObject.getFECHA()).append("' ");
		}

		if (valueObject.getHORA() != null&&!valueObject.getHORA().equals("")) {
			if (first) { first = false; }
			sql.append("AND HORA= '").append(valueObject.getHORA()).append("' ");
		}

		if (valueObject.getIP() != null&&!valueObject.getIP().equals("")) {
			if (first) { first = false; }
			sql.append("AND IP= '").append(valueObject.getIP()).append("' ");
		}

		if (valueObject.getNOMBREEQUIPO() != null&&!valueObject.getNOMBREEQUIPO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBREEQUIPO= '").append(valueObject.getNOMBREEQUIPO()).append("' ");
		}

		sql.append("ORDER BY ID_HISTORIALCOMPARENDO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Historialcomparendo valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_HISTORIALCOMPARENDO) AS RowNumber FROM HISTORIALCOMPARENDO WHERE 1=1 ");
		if (valueObject.getID_HISTORIALCOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_HISTORIALCOMPARENDO= ").append(valueObject.getID_HISTORIALCOMPARENDO()).append(" ");
		}

		if (valueObject.getID_INFRACCIONCOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACCIONCOMPARENDO= ").append(valueObject.getID_INFRACCIONCOMPARENDO()).append(" ");
		}

		if (valueObject.getID_PASO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PASO= ").append(valueObject.getID_PASO()).append(" ");
		}

		if (valueObject.getID_DOCSRESOLUCIONES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSRESOLUCIONES= ").append(valueObject.getID_DOCSRESOLUCIONES()).append(" ");
		}

		if (valueObject.getID_DOCSACTAS() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSACTAS= ").append(valueObject.getID_DOCSACTAS()).append(" ");
		}

		if (valueObject.getAVANCEPROCESO() != 0) {
			if (first) { first = false; }
			sql.append("AND AVANCEPROCESO= ").append(valueObject.getAVANCEPROCESO()).append(" ");
		}

		if (valueObject.getID_USUARIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
		}

		if (valueObject.getFECHA() != null&&!valueObject.getFECHA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA= '").append(valueObject.getFECHA()).append("' ");
		}

		if (valueObject.getHORA() != null&&!valueObject.getHORA().equals("")) {
			if (first) { first = false; }
			sql.append("AND HORA= '").append(valueObject.getHORA()).append("' ");
		}

		if (valueObject.getIP() != null&&!valueObject.getIP().equals("")) {
			if (first) { first = false; }
			sql.append("AND IP= '").append(valueObject.getIP()).append("' ");
		}

		if (valueObject.getNOMBREEQUIPO() != null&&!valueObject.getNOMBREEQUIPO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBREEQUIPO= '").append(valueObject.getNOMBREEQUIPO()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Historialcomparendo valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM HISTORIALCOMPARENDO WHERE 1=1 ");
		if (valueObject.getID_HISTORIALCOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_HISTORIALCOMPARENDO= ").append(valueObject.getID_HISTORIALCOMPARENDO()).append(" ");
		}

		if (valueObject.getID_INFRACCIONCOMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACCIONCOMPARENDO= ").append(valueObject.getID_INFRACCIONCOMPARENDO()).append(" ");
		}

		if (valueObject.getID_PASO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PASO= ").append(valueObject.getID_PASO()).append(" ");
		}

		if (valueObject.getID_DOCSRESOLUCIONES() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSRESOLUCIONES= ").append(valueObject.getID_DOCSRESOLUCIONES()).append(" ");
		}

		if (valueObject.getID_DOCSACTAS() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DOCSACTAS= ").append(valueObject.getID_DOCSACTAS()).append(" ");
		}

		if (valueObject.getAVANCEPROCESO() != 0) {
			if (first) { first = false; }
			sql.append("AND AVANCEPROCESO= ").append(valueObject.getAVANCEPROCESO()).append(" ");
		}

		if (valueObject.getID_USUARIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_USUARIO= ").append(valueObject.getID_USUARIO()).append(" ");
		}

		if (valueObject.getFECHA() != null&&!valueObject.getFECHA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA= '").append(valueObject.getFECHA()).append("' ");
		}

		if (valueObject.getHORA() != null&&!valueObject.getHORA().equals("")) {
			if (first) { first = false; }
			sql.append("AND HORA= '").append(valueObject.getHORA()).append("' ");
		}

		if (valueObject.getIP() != null&&!valueObject.getIP().equals("")) {
			if (first) { first = false; }
			sql.append("AND IP= '").append(valueObject.getIP()).append("' ");
		}

		if (valueObject.getNOMBREEQUIPO() != null&&!valueObject.getNOMBREEQUIPO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBREEQUIPO= '").append(valueObject.getNOMBREEQUIPO()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Historialcomparendo valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_HISTORIALCOMPARENDO(result.getInt("ID_HISTORIALCOMPARENDO"));
				valueObject.setID_INFRACCIONCOMPARENDO(result.getInt("ID_INFRACCIONCOMPARENDO"));
				valueObject.setID_PASO(result.getInt("ID_PASO"));
				valueObject.setID_DOCSRESOLUCIONES(result.getInt("ID_DOCSRESOLUCIONES"));
				valueObject.setID_DOCSACTAS(result.getInt("ID_DOCSACTAS"));
				valueObject.setAVANCEPROCESO(result.getDouble("AVANCEPROCESO"));
				valueObject.setID_USUARIO(result.getInt("ID_USUARIO"));
				valueObject.setFECHA(result.getString("FECHA"));
				valueObject.setHORA(result.getString("HORA"));
				valueObject.setIP(result.getString("IP"));
				valueObject.setNOMBREEQUIPO(result.getString("NOMBREEQUIPO"));

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
				Historialcomparendo temp = createValueObject();

				temp.setID_HISTORIALCOMPARENDO(result.getInt("ID_HISTORIALCOMPARENDO"));
				temp.setID_INFRACCIONCOMPARENDO(result.getInt("ID_INFRACCIONCOMPARENDO"));
				temp.setID_PASO(result.getInt("ID_PASO"));
				temp.setID_DOCSRESOLUCIONES(result.getInt("ID_DOCSRESOLUCIONES"));
				temp.setID_DOCSACTAS(result.getInt("ID_DOCSACTAS"));
				temp.setAVANCEPROCESO(result.getDouble("AVANCEPROCESO"));
				temp.setID_USUARIO(result.getInt("ID_USUARIO"));
				temp.setFECHA(result.getString("FECHA"));
				temp.setHORA(result.getString("HORA"));
				temp.setIP(result.getString("IP"));
				temp.setNOMBREEQUIPO(result.getString("NOMBREEQUIPO"));
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
