package modelo.datos.dao.debidoCobrarImpuesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.debidoCobrarImpuesto.Debidocobrarimpuesto;

import utilidades.Funciones;



public class DebidocobrarimpuestoDao {


	public Debidocobrarimpuesto createValueObject() {
		return new Debidocobrarimpuesto();
	}

	public Debidocobrarimpuesto getObject(Connection conn,int DCI_ID) throws NotFoundException, SQLException {
		Debidocobrarimpuesto valueObject = createValueObject();
		valueObject.setDCI_ID(DCI_ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Debidocobrarimpuesto valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM DEBIDOCOBRARIMPUESTO WHERE (DCI_ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getDCI_ID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM DEBIDOCOBRARIMPUESTO ORDER BY DCI_ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY DCI_ID) AS RowNumber FROM DEBIDOCOBRARIMPUESTO) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Debidocobrarimpuesto valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO DEBIDOCOBRARIMPUESTO ( DCI_ID,"+
			" IDVEHICULO, LT_ID, ID_VIGENCIA,"+
			" DCI_INTERESES, DCI_ESTADO, DCI_VALOR,"+
			" DCI_TOTAL)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getDCI_ID());
				if(!Funciones.EnteroesNulo(valueObject.getIDVEHICULO()))
					stmt.setInt(2, valueObject.getIDVEHICULO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getLT_ID()))
					stmt.setInt(3, valueObject.getLT_ID());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_VIGENCIA()))
					stmt.setInt(4, valueObject.getID_VIGENCIA());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getDCI_INTERESES()))
					stmt.setInt(5, valueObject.getDCI_INTERESES());
				else
					stmt.setNull(5, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getDCI_ESTADO()))
					stmt.setInt(6, valueObject.getDCI_ESTADO());
				else
					stmt.setNull(6, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getDCI_VALOR()))
					stmt.setInt(7, valueObject.getDCI_VALOR());
				else
					stmt.setNull(7, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getDCI_TOTAL()))
					stmt.setInt(8, valueObject.getDCI_TOTAL());
				else
					stmt.setNull(8, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Debidocobrarimpuesto valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE DEBIDOCOBRARIMPUESTO SET  IDVEHICULO = ?, LT_ID = ?, ID_VIGENCIA = ?,"+
			" DCI_INTERESES = ?, DCI_ESTADO = ?, DCI_VALOR = ?,"+
			" DCI_TOTAL = ? WHERE (DCI_ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getIDVEHICULO()))
					stmt.setInt(1, valueObject.getIDVEHICULO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getLT_ID()))
					stmt.setInt(2, valueObject.getLT_ID());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_VIGENCIA()))
					stmt.setInt(3, valueObject.getID_VIGENCIA());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getDCI_INTERESES()))
					stmt.setInt(4, valueObject.getDCI_INTERESES());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getDCI_ESTADO()))
					stmt.setInt(5, valueObject.getDCI_ESTADO());
				else
					stmt.setNull(5, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getDCI_VALOR()))
					stmt.setInt(6, valueObject.getDCI_VALOR());
				else
					stmt.setNull(6, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getDCI_TOTAL()))
					stmt.setInt(7, valueObject.getDCI_TOTAL());
				else
					stmt.setNull(7, Types.INTEGER);
				stmt.setInt(8, valueObject.getDCI_ID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Debidocobrarimpuesto valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM DEBIDOCOBRARIMPUESTO WHERE (DCI_ID = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getDCI_ID());

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
		String sql = "SELECT count(*) FROM DEBIDOCOBRARIMPUESTO";
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
	public List searchMatching(Connection conn, Debidocobrarimpuesto valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM DEBIDOCOBRARIMPUESTO WHERE 1=1 ");
		if (valueObject.getDCI_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_ID= ").append(valueObject.getDCI_ID()).append(" ");
		}

		if (valueObject.getIDVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND IDVEHICULO= ").append(valueObject.getIDVEHICULO()).append(" ");
		}

		if (valueObject.getLT_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND LT_ID= ").append(valueObject.getLT_ID()).append(" ");
		}

		if (valueObject.getID_VIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_VIGENCIA= ").append(valueObject.getID_VIGENCIA()).append(" ");
		}

		if (valueObject.getDCI_INTERESES() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_INTERESES= ").append(valueObject.getDCI_INTERESES()).append(" ");
		}

		if (valueObject.getDCI_ESTADO() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_ESTADO= ").append(valueObject.getDCI_ESTADO()).append(" ");
		}

		if (valueObject.getDCI_VALOR() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_VALOR= ").append(valueObject.getDCI_VALOR()).append(" ");
		}

		if (valueObject.getDCI_TOTAL() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_TOTAL= ").append(valueObject.getDCI_TOTAL()).append(" ");
		}

		sql.append("ORDER BY DCI_ID ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Debidocobrarimpuesto valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY DCI_ID) AS RowNumber FROM DEBIDOCOBRARIMPUESTO WHERE 1=1 ");
		if (valueObject.getDCI_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_ID= ").append(valueObject.getDCI_ID()).append(" ");
		}

		if (valueObject.getIDVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND IDVEHICULO= ").append(valueObject.getIDVEHICULO()).append(" ");
		}

		if (valueObject.getLT_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND LT_ID= ").append(valueObject.getLT_ID()).append(" ");
		}

		if (valueObject.getID_VIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_VIGENCIA= ").append(valueObject.getID_VIGENCIA()).append(" ");
		}

		if (valueObject.getDCI_INTERESES() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_INTERESES= ").append(valueObject.getDCI_INTERESES()).append(" ");
		}

		if (valueObject.getDCI_ESTADO() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_ESTADO= ").append(valueObject.getDCI_ESTADO()).append(" ");
		}

		if (valueObject.getDCI_VALOR() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_VALOR= ").append(valueObject.getDCI_VALOR()).append(" ");
		}

		if (valueObject.getDCI_TOTAL() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_TOTAL= ").append(valueObject.getDCI_TOTAL()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Debidocobrarimpuesto valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM DEBIDOCOBRARIMPUESTO WHERE 1=1 ");
		if (valueObject.getDCI_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_ID= ").append(valueObject.getDCI_ID()).append(" ");
		}

		if (valueObject.getIDVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND IDVEHICULO= ").append(valueObject.getIDVEHICULO()).append(" ");
		}

		if (valueObject.getLT_ID() != 0) {
			if (first) { first = false; }
			sql.append("AND LT_ID= ").append(valueObject.getLT_ID()).append(" ");
		}

		if (valueObject.getID_VIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_VIGENCIA= ").append(valueObject.getID_VIGENCIA()).append(" ");
		}

		if (valueObject.getDCI_INTERESES() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_INTERESES= ").append(valueObject.getDCI_INTERESES()).append(" ");
		}

		if (valueObject.getDCI_ESTADO() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_ESTADO= ").append(valueObject.getDCI_ESTADO()).append(" ");
		}

		if (valueObject.getDCI_VALOR() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_VALOR= ").append(valueObject.getDCI_VALOR()).append(" ");
		}

		if (valueObject.getDCI_TOTAL() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_TOTAL= ").append(valueObject.getDCI_TOTAL()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Debidocobrarimpuesto valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setDCI_ID(result.getInt("DCI_ID"));
				valueObject.setIDVEHICULO(result.getInt("IDVEHICULO"));
				valueObject.setLT_ID(result.getInt("LT_ID"));
				valueObject.setID_VIGENCIA(result.getInt("ID_VIGENCIA"));
				valueObject.setDCI_INTERESES(result.getInt("DCI_INTERESES"));
				valueObject.setDCI_ESTADO(result.getInt("DCI_ESTADO"));
				valueObject.setDCI_VALOR(result.getInt("DCI_VALOR"));
				valueObject.setDCI_TOTAL(result.getInt("DCI_TOTAL"));

			} else {
				throw new NotFoundException("DebidocobrarimpuestoObject Not Found!");
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
				Debidocobrarimpuesto temp = createValueObject();

				temp.setDCI_ID(result.getInt("DCI_ID"));
				temp.setIDVEHICULO(result.getInt("IDVEHICULO"));
				temp.setLT_ID(result.getInt("LT_ID"));
				temp.setID_VIGENCIA(result.getInt("ID_VIGENCIA"));
				temp.setDCI_INTERESES(result.getInt("DCI_INTERESES"));
				temp.setDCI_ESTADO(result.getInt("DCI_ESTADO"));
				temp.setDCI_VALOR(result.getInt("DCI_VALOR"));
				temp.setDCI_TOTAL(result.getInt("DCI_TOTAL"));
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
