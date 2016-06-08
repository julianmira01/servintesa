package modelo.datos.dao.comparendos.coactivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.coactivo.Expediente;
import utilidades.Funciones;



public class ExpedienteDao {


	public Expediente createValueObject() {
		return new Expediente();
	}

	public Expediente getObject(Connection conn,int ID_EXPEDIENTE) throws NotFoundException, SQLException {
		Expediente valueObject = createValueObject();
		valueObject.setID_EXPEDIENTE(ID_EXPEDIENTE);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Expediente valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM EXPEDIENTE WHERE (ID_EXPEDIENTE = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_EXPEDIENTE());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EXPEDIENTE ORDER BY ID_EXPEDIENTE ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_EXPEDIENTE) AS RowNumber FROM EXPEDIENTE) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Expediente valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO EXPEDIENTE ( ID_EXPEDIENTE,"+
			" ID_INFRACTOR, ID_RESPONSABLE, FECHACREACION,"+
			" CONSECUTIVO, ESTADO)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_EXPEDIENTE());
				if(!Funciones.EnteroesNulo(valueObject.getID_INFRACTOR()))
					stmt.setInt(2, valueObject.getID_INFRACTOR());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_RESPONSABLE()))
					stmt.setInt(3, valueObject.getID_RESPONSABLE());
				else
					stmt.setNull(3, Types.INTEGER);
				
        /*if(Funciones.contarCadena(valueObject.getFECHACREACION(),30))
					stmt.setString(4, valueObject.getFECHACREACION());
				else
					stmt.setNull(4, Types.VARCHAR);*/
        
			  if (Funciones.esFecha(valueObject.getFECHACREACION()))
			      stmt.setDate(4, Funciones.convFechaSSQL(valueObject.getFECHACREACION()));
			  else
			      stmt.setNull(4, Types.DATE);
        
				if(!Funciones.EnteroesNulo(valueObject.getCONSECUTIVO()))
					stmt.setInt(5, valueObject.getCONSECUTIVO());
				else
					stmt.setNull(5, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getESTADO()))
					stmt.setInt(6, valueObject.getESTADO());
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


	public void save(Connection conn, Expediente valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE EXPEDIENTE SET  ID_INFRACTOR = ?, ID_RESPONSABLE = ?, FECHACREACION = ?,"+
			" CONSECUTIVO = ?, ESTADO = ? WHERE (ID_EXPEDIENTE= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_INFRACTOR()))
					stmt.setInt(1, valueObject.getID_INFRACTOR());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_RESPONSABLE()))
					stmt.setInt(2, valueObject.getID_RESPONSABLE());
				else
					stmt.setNull(2, Types.INTEGER);
				
        /*if(Funciones.contarCadena(valueObject.getFECHACREACION(),30))
					stmt.setString(3, valueObject.getFECHACREACION());
				else
					stmt.setNull(3, Types.VARCHAR);*/
			  
			  if (Funciones.esFecha(valueObject.getFECHACREACION()))
			      stmt.setDate(3, Funciones.convFechaSSQL(valueObject.getFECHACREACION()));
			  else
			      stmt.setNull(3, Types.DATE);
        
				if(!Funciones.EnteroesNulo(valueObject.getCONSECUTIVO()))
					stmt.setInt(4, valueObject.getCONSECUTIVO());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getESTADO()))
					stmt.setInt(5, valueObject.getESTADO());
				else
					stmt.setNull(5, Types.INTEGER);
				stmt.setInt(6, valueObject.getID_EXPEDIENTE());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Expediente valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM EXPEDIENTE WHERE (ID_EXPEDIENTE = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_EXPEDIENTE());

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
		String sql = "SELECT count(*) FROM EXPEDIENTE";
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
	public List searchMatching(Connection conn, Expediente valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM EXPEDIENTE WHERE 1=1 ");
		if (valueObject.getID_EXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTE= ").append(valueObject.getID_EXPEDIENTE()).append(" ");
		}

		if (valueObject.getID_INFRACTOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
		}

		if (valueObject.getID_RESPONSABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_RESPONSABLE= ").append(valueObject.getID_RESPONSABLE()).append(" ");
		}

		if (valueObject.getFECHACREACION() != null&&!valueObject.getFECHACREACION().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHACREACION= '").append(valueObject.getFECHACREACION()).append("' ");
		}

		if (valueObject.getCONSECUTIVO() != 0) {
			if (first) { first = false; }
			sql.append("AND CONSECUTIVO= ").append(valueObject.getCONSECUTIVO()).append(" ");
		}

		if (valueObject.getESTADO() != 0) {
			if (first) { first = false; }
			sql.append("AND ESTADO= ").append(valueObject.getESTADO()).append(" ");
		}

		sql.append("ORDER BY ID_EXPEDIENTE ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	/*public List searchMatching(Connection conn, Expediente valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_EXPEDIENTE) AS RowNumber FROM EXPEDIENTE WHERE 1=1 ");
		if (valueObject.getID_EXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTE= ").append(valueObject.getID_EXPEDIENTE()).append(" ");
		}

		if (valueObject.getID_INFRACTOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
		}

		if (valueObject.getID_RESPONSABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_RESPONSABLE= ").append(valueObject.getID_RESPONSABLE()).append(" ");
		}

		if (valueObject.getFECHACREACION() != null&&!valueObject.getFECHACREACION().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHACREACION= '").append(valueObject.getFECHACREACION()).append("' ");
		}

		if (valueObject.getCONSECUTIVO() != 0) {
			if (first) { first = false; }
			sql.append("AND CONSECUTIVO= ").append(valueObject.getCONSECUTIVO()).append(" ");
		}

		if (valueObject.getESTADO() != 0) {
			if (first) { first = false; }
			sql.append("AND ESTADO= ").append(valueObject.getESTADO()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}*/


	public int countSearchMatching(Connection conn, Expediente valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM EXPEDIENTE WHERE 1=1 ");
		if (valueObject.getID_EXPEDIENTE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EXPEDIENTE= ").append(valueObject.getID_EXPEDIENTE()).append(" ");
		}

		if (valueObject.getID_INFRACTOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
		}

		if (valueObject.getID_RESPONSABLE() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_RESPONSABLE= ").append(valueObject.getID_RESPONSABLE()).append(" ");
		}

		if (valueObject.getFECHACREACION() != null&&!valueObject.getFECHACREACION().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHACREACION= '").append(valueObject.getFECHACREACION()).append("' ");
		}

		if (valueObject.getCONSECUTIVO() != 0) {
			if (first) { first = false; }
			sql.append("AND CONSECUTIVO= ").append(valueObject.getCONSECUTIVO()).append(" ");
		}

		if (valueObject.getESTADO() != 0) {
			if (first) { first = false; }
			sql.append("AND ESTADO= ").append(valueObject.getESTADO()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Expediente valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_EXPEDIENTE(result.getInt("ID_EXPEDIENTE"));
				valueObject.setID_INFRACTOR(result.getInt("ID_INFRACTOR"));
				valueObject.setID_RESPONSABLE(result.getInt("ID_RESPONSABLE"));
				valueObject.setFECHACREACION(result.getString("FECHACREACION"));
				valueObject.setCONSECUTIVO(result.getInt("CONSECUTIVO"));
				valueObject.setESTADO(result.getInt("ESTADO"));

			} else {
				throw new NotFoundException("ExpedienteObject Not Found!");
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
				Expediente temp = createValueObject();

				temp.setID_EXPEDIENTE(result.getInt("ID_EXPEDIENTE"));
				temp.setID_INFRACTOR(result.getInt("ID_INFRACTOR"));
				temp.setID_RESPONSABLE(result.getInt("ID_RESPONSABLE"));
				temp.setFECHACREACION(result.getString("FECHACREACION"));
				temp.setCONSECUTIVO(result.getInt("CONSECUTIVO"));
				temp.setESTADO(result.getInt("ESTADO"));
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

  //NUEVO M-*-TODO EDWIN  
  public String consultarAlertas(Connection conn) throws SQLException {
    String resultado = "";
    
    int contComparendos = 0;
    String fechaIni = "", fechaFin ="";
    int contInfractores = 0;
    
    //PRIMERA CONSULTA -- COMPARENDOS EN LISTA PARA CADUCAR
    String sql = "SELECT\n" + 
    "  --DISTINCT(ID_COMPARENDO)\n" + 
    "  --COUNT(ID_COMPARENDO)\n" + 
    "  COUNT(DISTINCT(view_comparendosresolsancion.ID_COMPARENDO)), MIN(FECHACOMPARENDO) AS FECHA_INI, MAX(FECHACOMPARENDO) AS FECHA_FIN\n" + 
    "  --*\n" + 
    "FROM\n" + 
    "  view_comparendosresolsancion\n" + 
    "WHERE view_comparendosresolsancion.id_estado = 1 or (view_comparendosresolsancion.id_estado = 10 or (view_comparendosresolsancion.id_estado = 11))\n" + 
    "AND CAST((CURRENT_DATE - view_comparendosresolsancion.fechacomparendo) AS INTEGER) - (SELECT COUNT(*)\n" + 
    "                     FROM diasfestivos\n" + 
    "                     WHERE diasfestivos.fecha BETWEEN view_comparendosresolsancion.fechacomparendo AND CURRENT_DATE)>30\n" + 
    "ORDER BY MIN(FECHACOMPARENDO), MAX(FECHACOMPARENDO)";
    
    PreparedStatement stmt = null;
    ResultSet result = null;
    
    try {
      stmt = conn.prepareStatement(sql);
      result = stmt.executeQuery();
      if (result.next())
        contComparendos = result.getInt(0);
        fechaIni = result.getString(1);
        fechaFin = result.getString(2);
    } finally {
      if (result != null)
        result.close();
      if (stmt != null)
        stmt.close();
    }
    
    
    //SEGUNDA CONSULTA -- INFRACTORES EN LISTA PARA PERSUASIVO (CONTEO)    
    String sql2 = "SELECT\n" + 
    "  --DISTINCT(ID_INFRACTOR)\n" + 
    "  --COUNT(ID_INFRACTOR)\n" + 
    "  COUNT(DISTINCT(VIEW_INFRACTOR_COMPARENDO.ID_INFRACTOR))\n" + 
    "  --*\n" + 
    "FROM\n" + 
    "  view_comparendosresolsancion\n" + 
    "JOIN VIEW_INFRACTOR_COMPARENDO ON (view_comparendosresolsancion.id_infractor = view_infractor_comparendo.id_infractor)\n" + 
    "WHERE view_comparendosresolsancion.id_estado = 4\n" + 
    "AND view_comparendosresolsancion.id_comparendo NOT IN (SELECT id_comparendo\n" + 
    "FROM expedientecomparendo)";
        
        PreparedStatement stmt2 = null;
        ResultSet result2 = null;
        
        try {
          stmt2 = conn.prepareStatement(sql2);
          result2 = stmt2.executeQuery();
          if (result2.next())
            contInfractores = result2.getInt(0);        
        } finally {
          if (result2 != null)
            result2.close();
          if (stmt2 != null)
            stmt2.close();
        }
    
    resultado = contComparendos + "," + fechaIni + "," + fechaFin + "," + contInfractores;
    return resultado;
  }
}
