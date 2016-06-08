package modelo.datos.dao.transportepublico.cupos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.objetos.transportepublico.cupos.Viewinventariorangos;
import utilidades.Funciones;



public class ViewinventariorangosDao {


	public Viewinventariorangos createValueObject() {
		return new Viewinventariorangos();
	}

	public Viewinventariorangos getObject(Connection conn,int ID_EMPRESA_ASIGNADA) throws SQLException {
		Viewinventariorangos valueObject = createValueObject();
		valueObject.setID_EMPRESA_ASIGNADA(ID_EMPRESA_ASIGNADA);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Viewinventariorangos valueObject) throws SQLException {
		String sql = "SELECT * FROM VIEW_INVENTARIO_RANGOS WHERE (ID_EMPRESA_ASIGNADA = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_EMPRESA_ASIGNADA());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM VIEW_INVENTARIO_RANGOS ORDER BY ID_EMPRESA_ASIGNADA ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_EMPRESA_ASIGNADA) AS RowNumber FROM VIEW_INVENTARIO_RANGOS) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Viewinventariorangos valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO VIEW_INVENTARIO_RANGOS ( ID_EMPRESA_ASIGNADA,"+
			" ID_TIPOVEHICULO, NUMERO_CUPO, DISPONIBLE,"+
			" TIPO_VEHICULO, NIT_EMPRESA_SERVICIO, RAZON_SOCIAL"+
			")"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_EMPRESA_ASIGNADA());
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPOVEHICULO()))
					stmt.setInt(2, valueObject.getID_TIPOVEHICULO());
				else
					stmt.setNull(2, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNUMERO_CUPO(),100))
					stmt.setString(3, valueObject.getNUMERO_CUPO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDISPONIBLE(),100))
					stmt.setString(4, valueObject.getDISPONIBLE());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTIPO_VEHICULO(),100))
					stmt.setString(5, valueObject.getTIPO_VEHICULO());
				else
					stmt.setNull(5, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNIT_EMPRESA_SERVICIO(),100))
					stmt.setString(6, valueObject.getNIT_EMPRESA_SERVICIO());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getRAZON_SOCIAL(),100))
					stmt.setString(7, valueObject.getRAZON_SOCIAL());
				else
					stmt.setNull(7, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Viewinventariorangos valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE VIEW_INVENTARIO_RANGOS SET  ID_TIPOVEHICULO = ?, NUMERO_CUPO = ?, DISPONIBLE = ?,"+
			" TIPO_VEHICULO = ?, NIT_EMPRESA_SERVICIO = ?, RAZON_SOCIAL = ?"+
			" WHERE (ID_EMPRESA_ASIGNADA= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_TIPOVEHICULO()))
					stmt.setInt(1, valueObject.getID_TIPOVEHICULO());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNUMERO_CUPO(),100))
					stmt.setString(2, valueObject.getNUMERO_CUPO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDISPONIBLE(),100))
					stmt.setString(3, valueObject.getDISPONIBLE());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTIPO_VEHICULO(),100))
					stmt.setString(4, valueObject.getTIPO_VEHICULO());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNIT_EMPRESA_SERVICIO(),100))
					stmt.setString(5, valueObject.getNIT_EMPRESA_SERVICIO());
				else
					stmt.setNull(5, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getRAZON_SOCIAL(),100))
					stmt.setString(6, valueObject.getRAZON_SOCIAL());
				else
					stmt.setNull(6, Types.VARCHAR);
				stmt.setInt(7, valueObject.getID_EMPRESA_ASIGNADA());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Viewinventariorangos valueObject) throws  SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM VIEW_INVENTARIO_RANGOS WHERE (ID_EMPRESA_ASIGNADA = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_EMPRESA_ASIGNADA());

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
		String sql = "SELECT count(*) FROM VIEW_INVENTARIO_RANGOS";
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
	public List searchMatching(Connection conn, Viewinventariorangos valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_INVENTARIO_RANGOS WHERE 1=1 ");
		if (valueObject.getID_EMPRESA_ASIGNADA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EMPRESA_ASIGNADA= ").append(valueObject.getID_EMPRESA_ASIGNADA()).append(" ");
		}

		if (valueObject.getID_TIPOVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPOVEHICULO= ").append(valueObject.getID_TIPOVEHICULO()).append(" ");
		}

		if (valueObject.getNUMERO_CUPO() != null&&!valueObject.getNUMERO_CUPO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMERO_CUPO= '").append(valueObject.getNUMERO_CUPO()).append("' ");
		}

		if (valueObject.getDISPONIBLE() != null&&!valueObject.getDISPONIBLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND DISPONIBLE= '").append(valueObject.getDISPONIBLE()).append("' ");
		}

		if (valueObject.getTIPO_VEHICULO() != null&&!valueObject.getTIPO_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPO_VEHICULO= '").append(valueObject.getTIPO_VEHICULO()).append("' ");
		}

		if (valueObject.getNIT_EMPRESA_SERVICIO() != null&&!valueObject.getNIT_EMPRESA_SERVICIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NIT_EMPRESA_SERVICIO= '").append(valueObject.getNIT_EMPRESA_SERVICIO()).append("' ");
		}

		if (valueObject.getRAZON_SOCIAL() != null&&!valueObject.getRAZON_SOCIAL().equals("")) {
			if (first) { first = false; }
			sql.append("AND RAZON_SOCIAL= '").append(valueObject.getRAZON_SOCIAL()).append("' ");
		}

		sql.append("ORDER BY ID_EMPRESA_ASIGNADA ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}

    public List searchMatchingSinRest(Connection conn, Viewinventariorangos valueObject) throws SQLException {
            List searchResults;

            boolean first = true;
            StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_INVENTARIO_RANGOS WHERE 1=1 ");
            if (valueObject.getID_EMPRESA_ASIGNADA() != 0) {
                    if (first) { first = false; }
                    sql.append("AND ID_EMPRESA_ASIGNADA= ").append(valueObject.getID_EMPRESA_ASIGNADA()).append(" ");
            }

            if (valueObject.getID_TIPOVEHICULO() != 0) {
                    if (first) { first = false; }
                    sql.append("AND ID_TIPOVEHICULO= ").append(valueObject.getID_TIPOVEHICULO()).append(" ");
            }

            if (valueObject.getNUMERO_CUPO() != null&&!valueObject.getNUMERO_CUPO().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND NUMERO_CUPO= '").append(valueObject.getNUMERO_CUPO()).append("' ");
            }

            if (valueObject.getDISPONIBLE() != null&&!valueObject.getDISPONIBLE().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND DISPONIBLE= '").append(valueObject.getDISPONIBLE()).append("' ");
            }

            if (valueObject.getTIPO_VEHICULO() != null&&!valueObject.getTIPO_VEHICULO().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND TIPO_VEHICULO= '").append(valueObject.getTIPO_VEHICULO()).append("' ");
            }

            if (valueObject.getNIT_EMPRESA_SERVICIO() != null&&!valueObject.getNIT_EMPRESA_SERVICIO().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND NIT_EMPRESA_SERVICIO= '").append(valueObject.getNIT_EMPRESA_SERVICIO()).append("' ");
            }

            if (valueObject.getRAZON_SOCIAL() != null&&!valueObject.getRAZON_SOCIAL().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND RAZON_SOCIAL= '").append(valueObject.getRAZON_SOCIAL()).append("' ");
            }

            sql.append("ORDER BY RAZON_SOCIAL ASC");
            
            first=false;
            
            if (first)
                    searchResults = new ArrayList();
            else
                    searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

            return searchResults;
    }


	public List searchMatching(Connection conn, Viewinventariorangos valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_EMPRESA_ASIGNADA) AS RowNumber FROM VIEW_INVENTARIO_RANGOS WHERE 1=1 ");
		if (valueObject.getID_EMPRESA_ASIGNADA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EMPRESA_ASIGNADA= ").append(valueObject.getID_EMPRESA_ASIGNADA()).append(" ");
		}

		if (valueObject.getID_TIPOVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPOVEHICULO= ").append(valueObject.getID_TIPOVEHICULO()).append(" ");
		}

		if (valueObject.getNUMERO_CUPO() != null&&!valueObject.getNUMERO_CUPO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMERO_CUPO= '").append(valueObject.getNUMERO_CUPO()).append("' ");
		}

		if (valueObject.getDISPONIBLE() != null&&!valueObject.getDISPONIBLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND DISPONIBLE= '").append(valueObject.getDISPONIBLE()).append("' ");
		}

		if (valueObject.getTIPO_VEHICULO() != null&&!valueObject.getTIPO_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPO_VEHICULO= '").append(valueObject.getTIPO_VEHICULO()).append("' ");
		}

		if (valueObject.getNIT_EMPRESA_SERVICIO() != null&&!valueObject.getNIT_EMPRESA_SERVICIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NIT_EMPRESA_SERVICIO= '").append(valueObject.getNIT_EMPRESA_SERVICIO()).append("' ");
		}

		if (valueObject.getRAZON_SOCIAL() != null&&!valueObject.getRAZON_SOCIAL().equals("")) {
			if (first) { first = false; }
			sql.append("AND RAZON_SOCIAL= '").append(valueObject.getRAZON_SOCIAL()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Viewinventariorangos valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM VIEW_INVENTARIO_RANGOS WHERE 1=1 ");
		if (valueObject.getID_EMPRESA_ASIGNADA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_EMPRESA_ASIGNADA= ").append(valueObject.getID_EMPRESA_ASIGNADA()).append(" ");
		}

		if (valueObject.getID_TIPOVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TIPOVEHICULO= ").append(valueObject.getID_TIPOVEHICULO()).append(" ");
		}

		if (valueObject.getNUMERO_CUPO() != null&&!valueObject.getNUMERO_CUPO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMERO_CUPO= '").append(valueObject.getNUMERO_CUPO()).append("' ");
		}

		if (valueObject.getDISPONIBLE() != null&&!valueObject.getDISPONIBLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND DISPONIBLE= '").append(valueObject.getDISPONIBLE()).append("' ");
		}

		if (valueObject.getTIPO_VEHICULO() != null&&!valueObject.getTIPO_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPO_VEHICULO= '").append(valueObject.getTIPO_VEHICULO()).append("' ");
		}

		if (valueObject.getNIT_EMPRESA_SERVICIO() != null&&!valueObject.getNIT_EMPRESA_SERVICIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NIT_EMPRESA_SERVICIO= '").append(valueObject.getNIT_EMPRESA_SERVICIO()).append("' ");
		}

		if (valueObject.getRAZON_SOCIAL() != null&&!valueObject.getRAZON_SOCIAL().equals("")) {
			if (first) { first = false; }
			sql.append("AND RAZON_SOCIAL= '").append(valueObject.getRAZON_SOCIAL()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Viewinventariorangos valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_EMPRESA_ASIGNADA(result.getInt("ID_EMPRESA_ASIGNADA"));
				valueObject.setID_TIPOVEHICULO(result.getInt("ID_TIPOVEHICULO"));
				valueObject.setNUMERO_CUPO(result.getString("NUMERO_CUPO"));
				valueObject.setDISPONIBLE(result.getString("DISPONIBLE"));
				valueObject.setTIPO_VEHICULO(result.getString("TIPO_VEHICULO"));
				valueObject.setNIT_EMPRESA_SERVICIO(result.getString("NIT_EMPRESA_SERVICIO"));
				valueObject.setRAZON_SOCIAL(result.getString("RAZON_SOCIAL"));

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
				Viewinventariorangos temp = createValueObject();

				temp.setID_EMPRESA_ASIGNADA(result.getInt("ID_EMPRESA_ASIGNADA"));
				temp.setID_TIPOVEHICULO(result.getInt("ID_TIPOVEHICULO"));
				temp.setNUMERO_CUPO(result.getString("NUMERO_CUPO"));
				temp.setDISPONIBLE(result.getString("DISPONIBLE"));
				temp.setTIPO_VEHICULO(result.getString("TIPO_VEHICULO"));
				temp.setNIT_EMPRESA_SERVICIO(result.getString("NIT_EMPRESA_SERVICIO"));
				temp.setRAZON_SOCIAL(result.getString("RAZON_SOCIAL"));
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

