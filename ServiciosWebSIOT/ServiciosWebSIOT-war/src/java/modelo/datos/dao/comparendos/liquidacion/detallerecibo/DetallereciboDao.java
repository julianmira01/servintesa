package modelo.datos.dao.comparendos.liquidacion.detallerecibo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.dao.comparendos.liquidacion.detallerecibo.DetallereciboDao;
import modelo.datos.objetos.comparendos.liquidacion.detallerecibo.Detallerecibo;
import utilidades.Funciones;



public class DetallereciboDao {


	public Detallerecibo createValueObject() {
		return new Detallerecibo();
	}

	public Detallerecibo getObject(Connection conn,int ID_DETALLE_RECIBO) throws NotFoundException, SQLException {
		Detallerecibo valueObject = createValueObject();
		valueObject.setID_DETALLE_RECIBO(ID_DETALLE_RECIBO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Detallerecibo valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM DETALLE_RECIBO WHERE (ID_DETALLE_RECIBO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DETALLE_RECIBO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM DETALLE_RECIBO ORDER BY ID_DETALLE_RECIBO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_DETALLE_RECIBO) AS RowNumber FROM DETALLE_RECIBO) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Detallerecibo valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO DETALLE_RECIBO ( ID_DETALLE_RECIBO,"+
			" ID_RECIBO, ID_COMPARENDO, NUMEROCOMPARENDO,"+
			" VALOR, NUM_RESOLUCION)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DETALLE_RECIBO());
				if(!Funciones.EnteroesNulo(valueObject.getID_RECIBO()))
					stmt.setInt(2, valueObject.getID_RECIBO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_COMPARENDO()))
					stmt.setInt(3, valueObject.getID_COMPARENDO());
				else
					stmt.setNull(3, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNUMEROCOMPARENDO(),40))
					stmt.setString(4, valueObject.getNUMEROCOMPARENDO());
				else
					stmt.setNull(4, Types.VARCHAR);

				stmt.setString(5, valueObject.getVALOR());

				if(Funciones.contarCadena(valueObject. getNUM_RESOLUCION(),10))
					stmt.setString(6, valueObject.getNUM_RESOLUCION());
				else
					stmt.setNull(6, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Detallerecibo valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE DETALLE_RECIBO SET  ID_RECIBO = ?, ID_COMPARENDO = ?, NUMEROCOMPARENDO = ?,"+
			" VALOR = ?, NUM_RESOLUCION = ? WHERE (ID_DETALLE_RECIBO= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_RECIBO()))
					stmt.setInt(1, valueObject.getID_RECIBO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_COMPARENDO()))
					stmt.setInt(2, valueObject.getID_COMPARENDO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNUMEROCOMPARENDO(),40))
					stmt.setString(3, valueObject.getNUMEROCOMPARENDO());
				else
					stmt.setNull(3, Types.VARCHAR);

				stmt.setString(4, valueObject.getVALOR());

				if(Funciones.contarCadena(valueObject.getNUM_RESOLUCION(),10))
					stmt.setString(5, valueObject.getNUM_RESOLUCION());
				else
					stmt.setNull(5, Types.VARCHAR);
				stmt.setInt(6, valueObject.getID_DETALLE_RECIBO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Detallerecibo valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM DETALLE_RECIBO WHERE (ID_DETALLE_RECIBO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DETALLE_RECIBO());

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
		String sql = "SELECT count(*) FROM DETALLE_RECIBO";
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
	public List searchMatching(Connection conn, Detallerecibo valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM DETALLE_RECIBO WHERE 1=1 ");
		if (valueObject.getID_DETALLE_RECIBO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DETALLE_RECIBO= ").append(valueObject.getID_DETALLE_RECIBO()).append(" ");
		}

		if (valueObject.getID_RECIBO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_RECIBO= ").append(valueObject.getID_RECIBO()).append(" ");
		}

		if (valueObject.getID_COMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
		}

		if (valueObject.getNUMEROCOMPARENDO() != null&&!valueObject.getNUMEROCOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMEROCOMPARENDO= '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
		}

		if (valueObject.getVALOR() != null&&!valueObject.getVALOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND VALOR= '").append(valueObject.getVALOR()).append("' ");
		}

		if (valueObject.getNUM_RESOLUCION() != null&&!valueObject.getNUM_RESOLUCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUM_RESOLUCION= '").append(valueObject.getNUM_RESOLUCION()).append("' ");
		}

		sql.append("ORDER BY ID_DETALLE_RECIBO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Detallerecibo valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_DETALLE_RECIBO) AS RowNumber FROM DETALLE_RECIBO WHERE 1=1 ");
		if (valueObject.getID_DETALLE_RECIBO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DETALLE_RECIBO= ").append(valueObject.getID_DETALLE_RECIBO()).append(" ");
		}

		if (valueObject.getID_RECIBO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_RECIBO= ").append(valueObject.getID_RECIBO()).append(" ");
		}

		if (valueObject.getID_COMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
		}

		if (valueObject.getNUMEROCOMPARENDO() != null&&!valueObject.getNUMEROCOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMEROCOMPARENDO= '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
		}

		if (valueObject.getVALOR() != null&&!valueObject.getVALOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND VALOR= '").append(valueObject.getVALOR()).append("' ");
		}

		if (valueObject.getNUM_RESOLUCION() != null&&!valueObject.getNUM_RESOLUCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUM_RESOLUCION= '").append(valueObject.getNUM_RESOLUCION()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Detallerecibo valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM DETALLE_RECIBO WHERE 1=1 ");
		if (valueObject.getID_DETALLE_RECIBO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DETALLE_RECIBO= ").append(valueObject.getID_DETALLE_RECIBO()).append(" ");
		}

		if (valueObject.getID_RECIBO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_RECIBO= ").append(valueObject.getID_RECIBO()).append(" ");
		}

		if (valueObject.getID_COMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
		}

		if (valueObject.getNUMEROCOMPARENDO() != null&&!valueObject.getNUMEROCOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMEROCOMPARENDO= '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
		}

		if (valueObject.getVALOR() != null&&!valueObject.getVALOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND VALOR= '").append(valueObject.getVALOR()).append("' ");
		}

		if (valueObject.getNUM_RESOLUCION() != null&&!valueObject.getNUM_RESOLUCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUM_RESOLUCION= '").append(valueObject.getNUM_RESOLUCION()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Detallerecibo valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_DETALLE_RECIBO(result.getInt("ID_DETALLE_RECIBO"));
				valueObject.setID_RECIBO(result.getInt("ID_RECIBO"));
				valueObject.setID_COMPARENDO(result.getInt("ID_COMPARENDO"));
				valueObject.setNUMEROCOMPARENDO(result.getString("NUMEROCOMPARENDO"));
				valueObject.setVALOR(result.getString("VALOR"));
				valueObject.setNUM_RESOLUCION(result.getString("NUM_RESOLUCION"));

			} else {
				throw new NotFoundException("DetallereciboObject Not Found!");
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
				Detallerecibo temp = createValueObject();

				temp.setID_DETALLE_RECIBO(result.getInt("ID_DETALLE_RECIBO"));
				temp.setID_RECIBO(result.getInt("ID_RECIBO"));
				temp.setID_COMPARENDO(result.getInt("ID_COMPARENDO"));
				temp.setNUMEROCOMPARENDO(result.getString("NUMEROCOMPARENDO"));
				temp.setVALOR(result.getString("VALOR"));
				temp.setNUM_RESOLUCION(result.getString("NUM_RESOLUCION"));
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
