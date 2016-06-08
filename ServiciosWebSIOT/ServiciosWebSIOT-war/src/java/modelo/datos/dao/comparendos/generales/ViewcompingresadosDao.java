package modelo.datos.dao.comparendos.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.generales.Viewcompingresados;

import utilidades.Funciones;



public class ViewcompingresadosDao {


	public Viewcompingresados createValueObject() {
		return new Viewcompingresados();
	}

	public Viewcompingresados getObject(Connection conn,int ID_COMPARENDO) throws NotFoundException, SQLException {
		Viewcompingresados valueObject = createValueObject();
		valueObject.setID_COMPARENDO(ID_COMPARENDO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Viewcompingresados valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM VIEW_COMP_INGRESADOS WHERE (ID_COMPARENDO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_COMPARENDO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM VIEW_COMP_INGRESADOS ORDER BY ID_COMPARENDO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_COMPARENDO) AS RowNumber FROM VIEW_COMP_INGRESADOS) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Viewcompingresados valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO VIEW_COMP_INGRESADOS ( ID_COMPARENDO,"+
			" NUMEROCOMPARENDO, PLACA, ID_INFRACTOR,"+
			" NOMBRES, APELLIDOS, FECHACOMPARENDO,"+
			" ID_AGENTE, PLACAAGENTE, NOMBRES_AGENTE,"+
			" APELL1)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_COMPARENDO());
				if(Funciones.contarCadena(valueObject.getNUMEROCOMPARENDO(),40))
					stmt.setString(2, valueObject.getNUMEROCOMPARENDO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getPLACA(),0))
					stmt.setString(3, valueObject.getPLACA());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_INFRACTOR()))
					stmt.setInt(4, valueObject.getID_INFRACTOR());
				else
					stmt.setNull(4, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNOMBRES(),20))
					stmt.setString(5, valueObject.getNOMBRES());
				else
					stmt.setNull(5, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getAPELLIDOS(),20))
					stmt.setString(6, valueObject.getAPELLIDOS());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHACOMPARENDO(),10))
					stmt.setString(7, valueObject.getFECHACOMPARENDO());
				else
					stmt.setNull(7, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_AGENTE()))
					stmt.setInt(8, valueObject.getID_AGENTE());
				else
					stmt.setNull(8, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getPLACAAGENTE(),20))
					stmt.setString(9, valueObject.getPLACAAGENTE());
				else
					stmt.setNull(9, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBRES_AGENTE(),30))
					stmt.setString(10, valueObject.getNOMBRES_AGENTE());
				else
					stmt.setNull(10, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getAPELL1(),15))
					stmt.setString(11, valueObject.getAPELL1());
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


	public void save(Connection conn, Viewcompingresados valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE VIEW_COMP_INGRESADOS SET  NUMEROCOMPARENDO = ?, PLACA = ?, ID_INFRACTOR = ?,"+
			" NOMBRES = ?, APELLIDOS = ?, FECHACOMPARENDO = ?,"+
			" ID_AGENTE = ?, PLACAAGENTE = ?, NOMBRES_AGENTE = ?,"+
			" APELL1 = ? WHERE (ID_COMPARENDO= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getNUMEROCOMPARENDO(),40))
					stmt.setString(1, valueObject.getNUMEROCOMPARENDO());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getPLACA(),0))
					stmt.setString(2, valueObject.getPLACA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_INFRACTOR()))
					stmt.setInt(3, valueObject.getID_INFRACTOR());
				else
					stmt.setNull(3, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNOMBRES(),20))
					stmt.setString(4, valueObject.getNOMBRES());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getAPELLIDOS(),20))
					stmt.setString(5, valueObject.getAPELLIDOS());
				else
					stmt.setNull(5, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHACOMPARENDO(),10))
					stmt.setString(6, valueObject.getFECHACOMPARENDO());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_AGENTE()))
					stmt.setInt(7, valueObject.getID_AGENTE());
				else
					stmt.setNull(7, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getPLACAAGENTE(),20))
					stmt.setString(8, valueObject.getPLACAAGENTE());
				else
					stmt.setNull(8, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBRES_AGENTE(),30))
					stmt.setString(9, valueObject.getNOMBRES_AGENTE());
				else
					stmt.setNull(9, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getAPELL1(),15))
					stmt.setString(10, valueObject.getAPELL1());
				else
					stmt.setNull(10, Types.VARCHAR);
				stmt.setInt(11, valueObject.getID_COMPARENDO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Viewcompingresados valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM VIEW_COMP_INGRESADOS WHERE (ID_COMPARENDO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_COMPARENDO());

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
		String sql = "SELECT count(*) FROM VIEW_COMP_INGRESADOS";
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
	public List searchMatching(Connection conn, Viewcompingresados valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_COMP_INGRESADOS WHERE 1=1 ");
		if (valueObject.getID_COMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
		}

		if (valueObject.getNUMEROCOMPARENDO() != null&&!valueObject.getNUMEROCOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMEROCOMPARENDO= '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getID_INFRACTOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
		}

		if (valueObject.getNOMBRES() != null&&!valueObject.getNOMBRES().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRES= '").append(valueObject.getNOMBRES()).append("' ");
		}

		if (valueObject.getAPELLIDOS() != null&&!valueObject.getAPELLIDOS().equals("")) {
			if (first) { first = false; }
			sql.append("AND APELLIDOS= '").append(valueObject.getAPELLIDOS()).append("' ");
		}

		if (valueObject.getFECHACOMPARENDO() != null&&!valueObject.getFECHACOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHACOMPARENDO= '").append(valueObject.getFECHACOMPARENDO()).append("' ");
		}

		if (valueObject.getID_AGENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_AGENTE= ").append(valueObject.getID_AGENTE()).append(" ");
		}

		if (valueObject.getPLACAAGENTE() != null&&!valueObject.getPLACAAGENTE().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACAAGENTE= '").append(valueObject.getPLACAAGENTE()).append("' ");
		}

		if (valueObject.getNOMBRES_AGENTE() != null&&!valueObject.getNOMBRES_AGENTE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRES_AGENTE= '").append(valueObject.getNOMBRES_AGENTE()).append("' ");
		}

		if (valueObject.getAPELL1() != null&&!valueObject.getAPELL1().equals("")) {
			if (first) { first = false; }
			sql.append("AND APELL1= '").append(valueObject.getAPELL1()).append("' ");
		}

		sql.append("ORDER BY ID_COMPARENDO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}
        
        
    public List searchMatchingFechas(Connection conn, Viewcompingresados valueObject, String fecha1, String fecha2) throws SQLException {
        List searchResults = null;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_COMP_INGRESADOS WHERE 1=1 ");
        sql.append("AND (FECHACOMPARENDO BETWEEN '").append(fecha1).append("' AND '").append(fecha2).append("')");

        sql.append("ORDER BY ID_COMPARENDO ASC ");

        searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));        
        return searchResults;
    
    }


	public List searchMatching(Connection conn, Viewcompingresados valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_COMPARENDO) AS RowNumber FROM VIEW_COMP_INGRESADOS WHERE 1=1 ");
		if (valueObject.getID_COMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
		}

		if (valueObject.getNUMEROCOMPARENDO() != null&&!valueObject.getNUMEROCOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMEROCOMPARENDO= '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getID_INFRACTOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
		}

		if (valueObject.getNOMBRES() != null&&!valueObject.getNOMBRES().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRES= '").append(valueObject.getNOMBRES()).append("' ");
		}

		if (valueObject.getAPELLIDOS() != null&&!valueObject.getAPELLIDOS().equals("")) {
			if (first) { first = false; }
			sql.append("AND APELLIDOS= '").append(valueObject.getAPELLIDOS()).append("' ");
		}

		if (valueObject.getFECHACOMPARENDO() != null&&!valueObject.getFECHACOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHACOMPARENDO= '").append(valueObject.getFECHACOMPARENDO()).append("' ");
		}

		if (valueObject.getID_AGENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_AGENTE= ").append(valueObject.getID_AGENTE()).append(" ");
		}

		if (valueObject.getPLACAAGENTE() != null&&!valueObject.getPLACAAGENTE().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACAAGENTE= '").append(valueObject.getPLACAAGENTE()).append("' ");
		}

		if (valueObject.getNOMBRES_AGENTE() != null&&!valueObject.getNOMBRES_AGENTE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRES_AGENTE= '").append(valueObject.getNOMBRES_AGENTE()).append("' ");
		}

		if (valueObject.getAPELL1() != null&&!valueObject.getAPELL1().equals("")) {
			if (first) { first = false; }
			sql.append("AND APELL1= '").append(valueObject.getAPELL1()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Viewcompingresados valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM VIEW_COMP_INGRESADOS WHERE 1=1 ");
		if (valueObject.getID_COMPARENDO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
		}

		if (valueObject.getNUMEROCOMPARENDO() != null&&!valueObject.getNUMEROCOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMEROCOMPARENDO= '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getID_INFRACTOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
		}

		if (valueObject.getNOMBRES() != null&&!valueObject.getNOMBRES().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRES= '").append(valueObject.getNOMBRES()).append("' ");
		}

		if (valueObject.getAPELLIDOS() != null&&!valueObject.getAPELLIDOS().equals("")) {
			if (first) { first = false; }
			sql.append("AND APELLIDOS= '").append(valueObject.getAPELLIDOS()).append("' ");
		}

		if (valueObject.getFECHACOMPARENDO() != null&&!valueObject.getFECHACOMPARENDO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHACOMPARENDO= '").append(valueObject.getFECHACOMPARENDO()).append("' ");
		}

		if (valueObject.getID_AGENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_AGENTE= ").append(valueObject.getID_AGENTE()).append(" ");
		}

		if (valueObject.getPLACAAGENTE() != null&&!valueObject.getPLACAAGENTE().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACAAGENTE= '").append(valueObject.getPLACAAGENTE()).append("' ");
		}

		if (valueObject.getNOMBRES_AGENTE() != null&&!valueObject.getNOMBRES_AGENTE().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRES_AGENTE= '").append(valueObject.getNOMBRES_AGENTE()).append("' ");
		}

		if (valueObject.getAPELL1() != null&&!valueObject.getAPELL1().equals("")) {
			if (first) { first = false; }
			sql.append("AND APELL1= '").append(valueObject.getAPELL1()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Viewcompingresados valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_COMPARENDO(result.getInt("ID_COMPARENDO"));
				valueObject.setNUMEROCOMPARENDO(result.getString("NUMEROCOMPARENDO"));
				valueObject.setPLACA(result.getString("PLACA"));
				valueObject.setID_INFRACTOR(result.getInt("ID_INFRACTOR"));
				valueObject.setNOMBRES(result.getString("NOMBRES"));
				valueObject.setAPELLIDOS(result.getString("APELLIDOS"));
				valueObject.setFECHACOMPARENDO(result.getString("FECHACOMPARENDO"));
				valueObject.setID_AGENTE(result.getInt("ID_AGENTE"));
				valueObject.setPLACAAGENTE(result.getString("PLACAAGENTE"));
				valueObject.setNOMBRES_AGENTE(result.getString("NOMBRES_AGENTE"));
				valueObject.setAPELL1(result.getString("APELL1"));

			} else {
				throw new NotFoundException("ViewcompingresadosObject Not Found!");
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
				Viewcompingresados temp = createValueObject();

				temp.setID_COMPARENDO(result.getInt("ID_COMPARENDO"));
				temp.setNUMEROCOMPARENDO(result.getString("NUMEROCOMPARENDO"));
				temp.setPLACA(result.getString("PLACA"));
				temp.setID_INFRACTOR(result.getInt("ID_INFRACTOR"));
				temp.setNOMBRES(result.getString("NOMBRES"));
				temp.setAPELLIDOS(result.getString("APELLIDOS"));
				temp.setFECHACOMPARENDO(result.getString("FECHACOMPARENDO"));
				temp.setID_AGENTE(result.getInt("ID_AGENTE"));
				temp.setPLACAAGENTE(result.getString("PLACAAGENTE"));
				temp.setNOMBRES_AGENTE(result.getString("NOMBRES_AGENTE"));
				temp.setAPELL1(result.getString("APELL1"));
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
