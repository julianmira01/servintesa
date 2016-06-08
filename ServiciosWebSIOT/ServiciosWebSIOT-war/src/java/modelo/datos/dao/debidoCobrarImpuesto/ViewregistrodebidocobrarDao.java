package modelo.datos.dao.debidoCobrarImpuesto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.debidoCobrarImpuesto.Viewregistrodebidocobrar;

import utilidades.Funciones;



public class ViewregistrodebidocobrarDao {


	public Viewregistrodebidocobrar createValueObject() {
		return new Viewregistrodebidocobrar();
	}

	public Viewregistrodebidocobrar getObject(Connection conn,int ID) throws NotFoundException, SQLException {
		Viewregistrodebidocobrar valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Viewregistrodebidocobrar valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM VIEW_REGISTRODEBIDOCOBRAR WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM VIEW_REGISTRODEBIDOCOBRAR ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID) AS RowNumber FROM VIEW_REGISTRODEBIDOCOBRAR) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Viewregistrodebidocobrar valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO VIEW_REGISTRODEBIDOCOBRAR ( ID,"+
			" PLACA, TIPOIMPUESTO, IMPUESTO,"+
			" VIGENCIA, DCI_INTERESES, DCI_ESTADO,"+
			" DCI_VALOR, DCI_TOTAL)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
				if(Funciones.contarCadena(valueObject.getPLACA(),10))
					stmt.setString(2, valueObject.getPLACA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTIPOIMPUESTO(),100))
					stmt.setString(3, valueObject.getTIPOIMPUESTO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getIMPUESTO(),100))
					stmt.setString(4, valueObject.getIMPUESTO());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getVIGENCIA()))
					stmt.setInt(5, valueObject.getVIGENCIA());
				else
					stmt.setNull(5, Types.INTEGER);
				if(!Funciones.DoubleEsNulo(valueObject.getDCI_INTERESES()))
					stmt.setDouble(6, valueObject.getDCI_INTERESES());
				else
					stmt.setNull(6, Types.DOUBLE);
				if(Funciones.contarCadena(valueObject.getDCI_ESTADO(),60))
					stmt.setString(7, valueObject.getDCI_ESTADO());
				else
					stmt.setNull(7, Types.VARCHAR);
				if(!Funciones.DoubleEsNulo(valueObject.getDCI_VALOR()))
					stmt.setDouble(8, valueObject.getDCI_VALOR());
				else
					stmt.setNull(8, Types.DOUBLE);
				if(!Funciones.EnteroesNulo(valueObject.getDCI_TOTAL()))
					stmt.setInt(9, valueObject.getDCI_TOTAL());
				else
					stmt.setNull(9, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Viewregistrodebidocobrar valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE VIEW_REGISTRODEBIDOCOBRAR SET  PLACA = ?, TIPOIMPUESTO = ?, IMPUESTO = ?,"+
			" VIGENCIA = ?, DCI_INTERESES = ?, DCI_ESTADO = ?,"+
			" DCI_VALOR = ?, DCI_TOTAL = ? WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getPLACA(),10))
					stmt.setString(1, valueObject.getPLACA());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTIPOIMPUESTO(),100))
					stmt.setString(2, valueObject.getTIPOIMPUESTO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getIMPUESTO(),100))
					stmt.setString(3, valueObject.getIMPUESTO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getVIGENCIA()))
					stmt.setInt(4, valueObject.getVIGENCIA());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.DoubleEsNulo(valueObject.getDCI_INTERESES()))
					stmt.setDouble(5, valueObject.getDCI_INTERESES());
				else
					stmt.setNull(5, Types.DOUBLE);
				if(Funciones.contarCadena(valueObject.getDCI_ESTADO(),60))
					stmt.setString(6, valueObject.getDCI_ESTADO());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(!Funciones.DoubleEsNulo(valueObject.getDCI_VALOR()))
					stmt.setDouble(7, valueObject.getDCI_VALOR());
				else
					stmt.setNull(7, Types.DOUBLE);
				if(!Funciones.EnteroesNulo(valueObject.getDCI_TOTAL()))
					stmt.setInt(8, valueObject.getDCI_TOTAL());
				else
					stmt.setNull(8, Types.INTEGER);
				stmt.setInt(9, valueObject.getID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Viewregistrodebidocobrar valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM VIEW_REGISTRODEBIDOCOBRAR WHERE (ID = ? )";
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


	public int countAll(Connection conn) throws SQLException {
		String sql = "SELECT count(*) FROM VIEW_REGISTRODEBIDOCOBRAR";
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
	public List searchMatching(Connection conn, Viewregistrodebidocobrar valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_REGISTRODEBIDOCOBRAR WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getTIPOIMPUESTO() != null&&!valueObject.getTIPOIMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPOIMPUESTO= '").append(valueObject.getTIPOIMPUESTO()).append("' ");
		}

		if (valueObject.getIMPUESTO() != null&&!valueObject.getIMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND IMPUESTO= '").append(valueObject.getIMPUESTO()).append("' ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		if (valueObject.getDCI_INTERESES() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_INTERESES= ").append(valueObject.getDCI_INTERESES()).append(" ");
		}

		if (valueObject.getDCI_ESTADO() != null&&!valueObject.getDCI_ESTADO().equals("")) {
			if (first) { first = false; }
			sql.append("AND DCI_ESTADO= '").append(valueObject.getDCI_ESTADO()).append("' ");
		}

		if (valueObject.getDCI_VALOR() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_VALOR= ").append(valueObject.getDCI_VALOR()).append(" ");
		}

		if (valueObject.getDCI_TOTAL() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_TOTAL= ").append(valueObject.getDCI_TOTAL()).append(" ");
		}

		sql.append("ORDER BY ID ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Viewregistrodebidocobrar valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID) AS RowNumber FROM VIEW_REGISTRODEBIDOCOBRAR WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getTIPOIMPUESTO() != null&&!valueObject.getTIPOIMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPOIMPUESTO= '").append(valueObject.getTIPOIMPUESTO()).append("' ");
		}

		if (valueObject.getIMPUESTO() != null&&!valueObject.getIMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND IMPUESTO= '").append(valueObject.getIMPUESTO()).append("' ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		if (valueObject.getDCI_INTERESES() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_INTERESES= ").append(valueObject.getDCI_INTERESES()).append(" ");
		}

		if (valueObject.getDCI_ESTADO() != null&&!valueObject.getDCI_ESTADO().equals("")) {
			if (first) { first = false; }
			sql.append("AND DCI_ESTADO= '").append(valueObject.getDCI_ESTADO()).append("' ");
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


	public int countSearchMatching(Connection conn, Viewregistrodebidocobrar valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM VIEW_REGISTRODEBIDOCOBRAR WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getTIPOIMPUESTO() != null&&!valueObject.getTIPOIMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPOIMPUESTO= '").append(valueObject.getTIPOIMPUESTO()).append("' ");
		}

		if (valueObject.getIMPUESTO() != null&&!valueObject.getIMPUESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND IMPUESTO= '").append(valueObject.getIMPUESTO()).append("' ");
		}

		if (valueObject.getVIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND VIGENCIA= ").append(valueObject.getVIGENCIA()).append(" ");
		}

		if (valueObject.getDCI_INTERESES() != 0) {
			if (first) { first = false; }
			sql.append("AND DCI_INTERESES= ").append(valueObject.getDCI_INTERESES()).append(" ");
		}

		if (valueObject.getDCI_ESTADO() != null&&!valueObject.getDCI_ESTADO().equals("")) {
			if (first) { first = false; }
			sql.append("AND DCI_ESTADO= '").append(valueObject.getDCI_ESTADO()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Viewregistrodebidocobrar valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
				valueObject.setPLACA(result.getString("PLACA"));
				valueObject.setTIPOIMPUESTO(result.getString("TIPOIMPUESTO"));
				valueObject.setIMPUESTO(result.getString("IMPUESTO"));
				valueObject.setVIGENCIA(result.getInt("VIGENCIA"));
				valueObject.setDCI_INTERESES(result.getDouble("DCI_INTERESES"));
				valueObject.setDCI_ESTADO(result.getString("DCI_ESTADO"));
				valueObject.setDCI_VALOR(result.getDouble("DCI_VALOR"));
				valueObject.setDCI_TOTAL(result.getInt("DCI_TOTAL"));

			} else {
				throw new NotFoundException("ViewregistrodebidocobrarObject Not Found!");
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
				Viewregistrodebidocobrar temp = createValueObject();

				temp.setID(result.getInt("ID"));
				temp.setPLACA(result.getString("PLACA"));
				temp.setTIPOIMPUESTO(result.getString("TIPOIMPUESTO"));
				temp.setIMPUESTO(result.getString("IMPUESTO"));
				temp.setVIGENCIA(result.getInt("VIGENCIA"));
				temp.setDCI_INTERESES(result.getDouble("DCI_INTERESES"));
				temp.setDCI_ESTADO(result.getString("DCI_ESTADO"));
				temp.setDCI_VALOR(result.getDouble("DCI_VALOR"));
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
