package modelo.datos.dao.debidoCobrarImpuesto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;

import modelo.datos.objetos.debidoCobrarImpuesto.Registrodebidocobrar;

import utilidades.Funciones;



public class RegistrodebidocobrarDao {


	public Registrodebidocobrar createValueObject() {
		return new Registrodebidocobrar();
	}

	public Registrodebidocobrar getObject(Connection conn,int RDC_ID) throws NotFoundException, SQLException {
		Registrodebidocobrar valueObject = createValueObject();
		valueObject.setRDC_ID(RDC_ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Registrodebidocobrar valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM REGISTRODEBIDOCOBRAR WHERE (RDC_ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getRDC_ID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM REGISTRODEBIDOCOBRAR ORDER BY RDC_ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY RDC_ID) AS RowNumber FROM REGISTRODEBIDOCOBRAR) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Registrodebidocobrar valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO REGISTRODEBIDOCOBRAR ( RDC_ID,"+
			" IDVEHICULO, RDC_ESTADO, RDC_VALOR,"+
			" RDC_TOTAL, RI_ID)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getRDC_ID());
				if(!Funciones.EnteroesNulo(valueObject.getIDVEHICULO()))
					stmt.setInt(2, valueObject.getIDVEHICULO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getRDC_ESTADO(),60))
					stmt.setString(3, valueObject.getRDC_ESTADO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(!Funciones.DoubleEsNulo(valueObject.getRDC_VALOR()))
					stmt.setDouble(4, valueObject.getRDC_VALOR());
				else
					stmt.setNull(4, Types.DOUBLE);
				if(!Funciones.EnteroesNulo(valueObject.getRDC_TOTAL()))
					stmt.setInt(5, valueObject.getRDC_TOTAL());
				else
					stmt.setNull(5, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getRI_ID()))
					stmt.setInt(6, valueObject.getRI_ID());
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


	public void save(Connection conn, Registrodebidocobrar valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE REGISTRODEBIDOCOBRAR SET  IDVEHICULO = ?, RDC_ESTADO = ?, RDC_VALOR = ?,"+
			" RDC_TOTAL = ?, RI_ID = ? WHERE (RDC_ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getIDVEHICULO()))
					stmt.setInt(1, valueObject.getIDVEHICULO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getRDC_ESTADO(),60))
					stmt.setString(2, valueObject.getRDC_ESTADO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.DoubleEsNulo(valueObject.getRDC_VALOR()))
					stmt.setDouble(3, valueObject.getRDC_VALOR());
				else
					stmt.setNull(3, Types.DOUBLE);
				if(!Funciones.EnteroesNulo(valueObject.getRDC_TOTAL()))
					stmt.setInt(4, valueObject.getRDC_TOTAL());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getRI_ID()))
					stmt.setInt(5, valueObject.getRI_ID());
				else
					stmt.setNull(5, Types.INTEGER);
				stmt.setInt(6, valueObject.getRDC_ID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Registrodebidocobrar valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM REGISTRODEBIDOCOBRAR WHERE (RDC_ID = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getRDC_ID());

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
		String sql = "SELECT count(*) FROM REGISTRODEBIDOCOBRAR";
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
	public List searchMatching(Connection conn, Registrodebidocobrar valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM REGISTRODEBIDOCOBRAR WHERE 1=1 ");
		if (valueObject.getRDC_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND RDC_ID= ").append(valueObject.getRDC_ID()).append(" ");
		}

		if (valueObject.getIDVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND IDVEHICULO= ").append(valueObject.getIDVEHICULO()).append(" ");
		}

		if (valueObject.getRDC_ESTADO() != null&&!valueObject.getRDC_ESTADO().equals("")) {
			if (first) { first = false; }
			sql.append("AND RDC_ESTADO= '").append(valueObject.getRDC_ESTADO()).append("' ");
		}

		if (valueObject.getRDC_VALOR() != 0) {
			if (first) { first = false; }
			sql.append("AND RDC_VALOR= ").append(valueObject.getRDC_VALOR()).append(" ");
		}

		if (valueObject.getRDC_TOTAL() != 0) {
			if (first) { first = false; }
			sql.append("AND RDC_TOTAL= ").append(valueObject.getRDC_TOTAL()).append(" ");
		}

		if (valueObject.getRI_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_ID= ").append(valueObject.getRI_ID()).append(" ");
		}

		sql.append("ORDER BY RDC_ID ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Registrodebidocobrar valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY RDC_ID) AS RowNumber FROM REGISTRODEBIDOCOBRAR WHERE 1=1 ");
		if (valueObject.getRDC_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND RDC_ID= ").append(valueObject.getRDC_ID()).append(" ");
		}

		if (valueObject.getIDVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND IDVEHICULO= ").append(valueObject.getIDVEHICULO()).append(" ");
		}

		if (valueObject.getRDC_ESTADO() != null&&!valueObject.getRDC_ESTADO().equals("")) {
			if (first) { first = false; }
			sql.append("AND RDC_ESTADO= '").append(valueObject.getRDC_ESTADO()).append("' ");
		}

		if (valueObject.getRDC_VALOR() != 0) {
			if (first) { first = false; }
			sql.append("AND RDC_VALOR= ").append(valueObject.getRDC_VALOR()).append(" ");
		}

		if (valueObject.getRDC_TOTAL() != 0) {
			if (first) { first = false; }
			sql.append("AND RDC_TOTAL= ").append(valueObject.getRDC_TOTAL()).append(" ");
		}

		if (valueObject.getRI_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_ID= ").append(valueObject.getRI_ID()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Registrodebidocobrar valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM REGISTRODEBIDOCOBRAR WHERE 1=1 ");
		if (valueObject.getRDC_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND RDC_ID= ").append(valueObject.getRDC_ID()).append(" ");
		}

		if (valueObject.getIDVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND IDVEHICULO= ").append(valueObject.getIDVEHICULO()).append(" ");
		}

		if (valueObject.getRDC_ESTADO() != null&&!valueObject.getRDC_ESTADO().equals("")) {
			if (first) { first = false; }
			sql.append("AND RDC_ESTADO= '").append(valueObject.getRDC_ESTADO()).append("' ");
		}

		if (valueObject.getRDC_VALOR() != 0) {
			if (first) { first = false; }
			sql.append("AND RDC_VALOR= ").append(valueObject.getRDC_VALOR()).append(" ");
		}

		if (valueObject.getRDC_TOTAL() != 0) {
			if (first) { first = false; }
			sql.append("AND RDC_TOTAL= ").append(valueObject.getRDC_TOTAL()).append(" ");
		}

		if (valueObject.getRI_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND RI_ID= ").append(valueObject.getRI_ID()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Registrodebidocobrar valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setRDC_ID(result.getInt("RDC_ID"));
				valueObject.setIDVEHICULO(result.getInt("IDVEHICULO"));
				valueObject.setRDC_ESTADO(result.getString("RDC_ESTADO"));
				valueObject.setRDC_VALOR(result.getDouble("RDC_VALOR"));
				valueObject.setRDC_TOTAL(result.getInt("RDC_TOTAL"));
				valueObject.setRI_ID(result.getInt("RI_ID"));

			} else {
				throw new NotFoundException("RegistrodebidocobrarObject Not Found!");
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
				Registrodebidocobrar temp = createValueObject();

				temp.setRDC_ID(result.getInt("RDC_ID"));
				temp.setIDVEHICULO(result.getInt("IDVEHICULO"));
				temp.setRDC_ESTADO(result.getString("RDC_ESTADO"));
				temp.setRDC_VALOR(result.getDouble("RDC_VALOR"));
				temp.setRDC_TOTAL(result.getInt("RDC_TOTAL"));
				temp.setRI_ID(result.getInt("RI_ID"));
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
