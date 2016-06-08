package modelo.datos.dao.resoluciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.resoluciones.Numerosresoluciondisp;
import utilidades.Funciones;



public class NumerosresoluciondispDao {


	public Numerosresoluciondisp createValueObject() {
		return new Numerosresoluciondisp();
	}

	public Numerosresoluciondisp getObject(Connection conn,int ID_NUM_RES_DISP) throws NotFoundException, SQLException {
		Numerosresoluciondisp valueObject = createValueObject();
		valueObject.setID_NUM_RES_DISP(ID_NUM_RES_DISP);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Numerosresoluciondisp valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM NUMEROS_RESOLUCION_DISP WHERE (ID_NUM_RES_DISP = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_NUM_RES_DISP());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM NUMEROS_RESOLUCION_DISP ORDER BY ID_NUM_RES_DISP ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_NUM_RES_DISP) AS RowNumber FROM NUMEROS_RESOLUCION_DISP) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Numerosresoluciondisp valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO NUMEROS_RESOLUCION_DISP ( ID_NUM_RES_DISP,"+
			" ID_VIGENCIA, NUMERO, DISPONIBLE"+
			")"+
			 "VALUES ( ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_NUM_RES_DISP());
				if(!Funciones.EnteroesNulo(valueObject.getID_VIGENCIA()))
					stmt.setInt(2, valueObject.getID_VIGENCIA());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getNUMERO()))
					stmt.setInt(3, valueObject.getNUMERO());
				else
					stmt.setNull(3, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getDISPONIBLE()))
					stmt.setInt(4, valueObject.getDISPONIBLE());
				else
					stmt.setNull(4, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Numerosresoluciondisp valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE NUMEROS_RESOLUCION_DISP SET  ID_VIGENCIA = ?, NUMERO = ?, DISPONIBLE = ?"+
			" WHERE (ID_NUM_RES_DISP= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_VIGENCIA()))
					stmt.setInt(1, valueObject.getID_VIGENCIA());
				else
					stmt.setNull(1, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getNUMERO()))
					stmt.setInt(2, valueObject.getNUMERO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getDISPONIBLE()))
					stmt.setInt(3, valueObject.getDISPONIBLE());
				else
					stmt.setNull(3, Types.INTEGER);
				stmt.setInt(4, valueObject.getID_NUM_RES_DISP());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Numerosresoluciondisp valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM NUMEROS_RESOLUCION_DISP WHERE (ID_NUM_RES_DISP = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_NUM_RES_DISP());

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
		String sql = "SELECT count(*) FROM NUMEROS_RESOLUCION_DISP";
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
	public List searchMatching(Connection conn, Numerosresoluciondisp valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM NUMEROS_RESOLUCION_DISP WHERE 1=1 ");
		if (valueObject.getID_NUM_RES_DISP() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_NUM_RES_DISP= ").append(valueObject.getID_NUM_RES_DISP()).append(" ");
		}

		if (valueObject.getID_VIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_VIGENCIA= ").append(valueObject.getID_VIGENCIA()).append(" ");
		}

		if (valueObject.getNUMERO() != 0) {
			if (first) { first = false; }
			sql.append("AND NUMERO= ").append(valueObject.getNUMERO()).append(" ");
		}

		if (valueObject.getDISPONIBLE() != 0) {
			if (first) { first = false; }
			sql.append("AND DISPONIBLE= ").append(valueObject.getDISPONIBLE()).append(" ");
		}

		sql.append("ORDER BY ID_NUM_RES_DISP ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Numerosresoluciondisp valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_NUM_RES_DISP) AS RowNumber FROM NUMEROS_RESOLUCION_DISP WHERE 1=1 ");
		if (valueObject.getID_NUM_RES_DISP() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_NUM_RES_DISP= ").append(valueObject.getID_NUM_RES_DISP()).append(" ");
		}

		if (valueObject.getID_VIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_VIGENCIA= ").append(valueObject.getID_VIGENCIA()).append(" ");
		}

		if (valueObject.getNUMERO() != 0) {
			if (first) { first = false; }
			sql.append("AND NUMERO= ").append(valueObject.getNUMERO()).append(" ");
		}

		if (valueObject.getDISPONIBLE() != 0) {
			if (first) { first = false; }
			sql.append("AND DISPONIBLE= ").append(valueObject.getDISPONIBLE()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Numerosresoluciondisp valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM NUMEROS_RESOLUCION_DISP WHERE 1=1 ");
		if (valueObject.getID_NUM_RES_DISP() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_NUM_RES_DISP= ").append(valueObject.getID_NUM_RES_DISP()).append(" ");
		}

		if (valueObject.getID_VIGENCIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_VIGENCIA= ").append(valueObject.getID_VIGENCIA()).append(" ");
		}

		if (valueObject.getNUMERO() != 0) {
			if (first) { first = false; }
			sql.append("AND NUMERO= ").append(valueObject.getNUMERO()).append(" ");
		}

		if (valueObject.getDISPONIBLE() != 0) {
			if (first) { first = false; }
			sql.append("AND DISPONIBLE= ").append(valueObject.getDISPONIBLE()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Numerosresoluciondisp valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_NUM_RES_DISP(result.getInt("ID_NUM_RES_DISP"));
				valueObject.setID_VIGENCIA(result.getInt("ID_VIGENCIA"));
				valueObject.setNUMERO(result.getInt("NUMERO"));
				valueObject.setDISPONIBLE(result.getInt("DISPONIBLE"));

			} else {
				throw new NotFoundException("NumerosresoluciondispObject Not Found!");
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
				Numerosresoluciondisp temp = createValueObject();

				temp.setID_NUM_RES_DISP(result.getInt("ID_NUM_RES_DISP"));
				temp.setID_VIGENCIA(result.getInt("ID_VIGENCIA"));
				temp.setNUMERO(result.getInt("NUMERO"));
				temp.setDISPONIBLE(result.getInt("DISPONIBLE"));
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

  //NUEVOS 17 - ENE - 2013
  public Numerosresoluciondisp getPrimeroDisponible(Connection conn, int idVigencia) throws NotFoundException, SQLException {      
    
    String sql =  "SELECT * FROM numeros_resolucion_disp " +
                  "WHERE id_vigencia = " + String.valueOf(idVigencia) + " AND numeros_resolucion_disp.numero IN " +
                  "(SELECT MIN(NUMDISP.numero)" +
                  "FROM numeros_resolucion_disp NUMDISP " +
                  "JOIN vigencias VIG ON (NUMDISP.id_vigencia = VIG.id_vigencia) " +
                  "WHERE NUMDISP.disponible = 1 AND NUMDISP.numero >= VIG.num_resolucion_inicio AND VIG.id_vigencia = " + String.valueOf(idVigencia) + ")";
        
    Numerosresoluciondisp objNumResolucion = null;
    try {
      List searchResults = listQuery(conn, conn.prepareStatement(sql));
      if(searchResults!=null && searchResults.size()>0)
        objNumResolucion = (Numerosresoluciondisp)searchResults.get(0);
      
      //PreparedStatement stmt = null;  
      //stmt = conn.prepareStatement(sql);
      //stmt.setInt(1, idVigencia);
      //stmt.setInt(2, idVigencia);
      //singleQuery(conn, stmt, objNumResolucion);
    } finally {
  
    }
    return objNumResolucion;
  }
  
  public Numerosresoluciondisp getUltimoUtilizado(Connection conn, int idVigencia) throws NotFoundException, SQLException {      
      
      String sql =  "SELECT * FROM numeros_resolucion_disp " +
                    "WHERE id_vigencia = " + String.valueOf(idVigencia) + " AND  numeros_resolucion_disp.numero IN " +
                    "(SELECT MAX(NUMDISP.numero) " +
                    "FROM numeros_resolucion_disp NUMDISP " +
                    "JOIN vigencias VIG ON (NUMDISP.id_vigencia = VIG.id_vigencia) " +
                    "WHERE NUMDISP.disponible = 0 AND NUMDISP.numero >= VIG.num_resolucion_inicio AND VIG.id_vigencia = " + String.valueOf(idVigencia) + ") ";
      
      
      Numerosresoluciondisp objNumResolucion = null;
      try {
        List searchResults = listQuery(conn, conn.prepareStatement(sql));
          if(searchResults!=null && searchResults.size()>0)
          objNumResolucion = (Numerosresoluciondisp)searchResults.get(0);
          /*PreparedStatement stmt = null;
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, idVigencia);
          stmt.setInt(2, idVigencia);
          singleQuery(conn, stmt, objNumResolucion);*/
      } finally {
    
      }
      return objNumResolucion;
    }  
}
