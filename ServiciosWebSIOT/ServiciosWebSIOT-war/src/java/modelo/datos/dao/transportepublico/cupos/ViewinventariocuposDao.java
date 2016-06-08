package modelo.datos.dao.transportepublico.cupos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.datos.objetos.transportepublico.cupos.Viewinventariocupos;
import utilidades.Funciones;



public class ViewinventariocuposDao {


	public Viewinventariocupos createValueObject() {
		return new Viewinventariocupos();
	}

	public Viewinventariocupos getObject(Connection conn,int ID_DETALLERANGOCUPO) throws SQLException {
		Viewinventariocupos valueObject = createValueObject();
		valueObject.setID_DETALLERANGOCUPO(ID_DETALLERANGOCUPO);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Viewinventariocupos valueObject) throws SQLException {
		String sql = "SELECT * FROM VIEW_INVENTARIO_CUPOS WHERE (ID_DETALLERANGOCUPO = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DETALLERANGOCUPO());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM VIEW_INVENTARIO_CUPOS ORDER BY ID_DETALLERANGOCUPO ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_DETALLERANGOCUPO) AS RowNumber FROM VIEW_INVENTARIO_CUPOS) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Viewinventariocupos valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO VIEW_INVENTARIO_CUPOS ( ID_DETALLERANGOCUPO,"+
			" DISPONIBLE, NUMERO_CUPO, TIPO_VEHICULO,"+
			" PLACA, PROPIETARIO, NIT_EMPRESA_SERVICIO,"+
			" RAZON_SOCIAL, TARJETA_ACTIVA, NUMERO_TARJETA,"+
			" FECHA_VENCIMIENTO)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DETALLERANGOCUPO());
				if(Funciones.contarCadena(valueObject.getDISPONIBLE(),10))
					stmt.setString(2, valueObject.getDISPONIBLE());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNUMERO_CUPO(),40))
					stmt.setString(3, valueObject.getNUMERO_CUPO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTIPO_VEHICULO(),50))
					stmt.setString(4, valueObject.getTIPO_VEHICULO());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getPLACA(),10))
					stmt.setString(5, valueObject.getPLACA());
				else
					stmt.setNull(5, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getPROPIETARIO(),149))
					stmt.setString(6, valueObject.getPROPIETARIO());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNIT_EMPRESA_SERVICIO(),16))
					stmt.setString(7, valueObject.getNIT_EMPRESA_SERVICIO());
				else
					stmt.setNull(7, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getRAZON_SOCIAL(),40))
					stmt.setString(8, valueObject.getRAZON_SOCIAL());
				else
					stmt.setNull(8, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTARJETA_ACTIVA(),16))
					stmt.setString(9, valueObject.getTARJETA_ACTIVA());
				else
					stmt.setNull(9, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNUMERO_TARJETA(),10))
					stmt.setString(10, valueObject.getNUMERO_TARJETA());
				else
					stmt.setNull(10, Types.VARCHAR);
				
        if(Funciones.contarCadena(valueObject.getFECHA_VENCIMIENTO(),40))
					stmt.setString(11, valueObject.getFECHA_VENCIMIENTO());
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


	public void save(Connection conn, Viewinventariocupos valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE VIEW_INVENTARIO_CUPOS SET  DISPONIBLE = ?, NUMERO_CUPO = ?, TIPO_VEHICULO = ?,"+
			" PLACA = ?, PROPIETARIO = ?, NIT_EMPRESA_SERVICIO = ?,"+
			" RAZON_SOCIAL = ?, TARJETA_ACTIVA = ?, NUMERO_TARJETA = ?,"+
			" FECHA_VENCIMIENTO = ? WHERE (ID_DETALLERANGOCUPO= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getDISPONIBLE(),10))
					stmt.setString(1, valueObject.getDISPONIBLE());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNUMERO_CUPO(),40))
					stmt.setString(2, valueObject.getNUMERO_CUPO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTIPO_VEHICULO(),50))
					stmt.setString(3, valueObject.getTIPO_VEHICULO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getPLACA(),10))
					stmt.setString(4, valueObject.getPLACA());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getPROPIETARIO(),149))
					stmt.setString(5, valueObject.getPROPIETARIO());
				else
					stmt.setNull(5, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNIT_EMPRESA_SERVICIO(),16))
					stmt.setString(6, valueObject.getNIT_EMPRESA_SERVICIO());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getRAZON_SOCIAL(),40))
					stmt.setString(7, valueObject.getRAZON_SOCIAL());
				else
					stmt.setNull(7, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTARJETA_ACTIVA(),16))
					stmt.setString(8, valueObject.getTARJETA_ACTIVA());
				else
					stmt.setNull(8, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNUMERO_TARJETA(),10))
					stmt.setString(9, valueObject.getNUMERO_TARJETA());
				else
					stmt.setNull(9, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_VENCIMIENTO(),40))
					stmt.setString(10, valueObject.getFECHA_VENCIMIENTO());
				else
					stmt.setNull(10, Types.VARCHAR);
				stmt.setInt(11, valueObject.getID_DETALLERANGOCUPO());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new SQLException();
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Viewinventariocupos valueObject) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM VIEW_INVENTARIO_CUPOS WHERE (ID_DETALLERANGOCUPO = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_DETALLERANGOCUPO());

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
		String sql = "SELECT count(*) FROM VIEW_INVENTARIO_CUPOS";
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
	public List searchMatching(Connection conn, Viewinventariocupos valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_INVENTARIO_CUPOS WHERE 1=1 ");
		if (valueObject.getID_DETALLERANGOCUPO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DETALLERANGOCUPO= ").append(valueObject.getID_DETALLERANGOCUPO()).append(" ");
		}

		if (valueObject.getDISPONIBLE() != null&&!valueObject.getDISPONIBLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND DISPONIBLE= '").append(valueObject.getDISPONIBLE()).append("' ");
		}

		if (valueObject.getNUMERO_CUPO() != null&&!valueObject.getNUMERO_CUPO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMERO_CUPO= '").append(valueObject.getNUMERO_CUPO()).append("' ");
		}

		if (valueObject.getTIPO_VEHICULO() != null&&!valueObject.getTIPO_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPO_VEHICULO= '").append(valueObject.getTIPO_VEHICULO()).append("' ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getPROPIETARIO() != null&&!valueObject.getPROPIETARIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND PROPIETARIO= '").append(valueObject.getPROPIETARIO()).append("' ");
		}

		if (valueObject.getNIT_EMPRESA_SERVICIO() != null&&!valueObject.getNIT_EMPRESA_SERVICIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NIT_EMPRESA_SERVICIO= '").append(valueObject.getNIT_EMPRESA_SERVICIO()).append("' ");
		}

		if (valueObject.getRAZON_SOCIAL() != null&&!valueObject.getRAZON_SOCIAL().equals("")) {
			if (first) { first = false; }
			sql.append("AND RAZON_SOCIAL= '").append(valueObject.getRAZON_SOCIAL()).append("' ");
		}

		if (valueObject.getTARJETA_ACTIVA() != null&&!valueObject.getTARJETA_ACTIVA().equals("")) {
			if (first) { first = false; }
			sql.append("AND TARJETA_ACTIVA= '").append(valueObject.getTARJETA_ACTIVA()).append("' ");
		}

		if (valueObject.getNUMERO_TARJETA() != null&&!valueObject.getNUMERO_TARJETA().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMERO_TARJETA= '").append(valueObject.getNUMERO_TARJETA()).append("' ");
		}

		if (valueObject.getFECHA_VENCIMIENTO() != null&&!valueObject.getFECHA_VENCIMIENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_VENCIMIENTO= '").append(valueObject.getFECHA_VENCIMIENTO()).append("' ");
		}

		sql.append("ORDER BY ID_DETALLERANGOCUPO ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


    public List searchMatchingSinRest(Connection conn, Viewinventariocupos valueObject) throws SQLException {
            List searchResults;

            boolean first = true;
            StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_INVENTARIO_CUPOS WHERE 1=1 ");
            if (valueObject.getID_DETALLERANGOCUPO() != 0) {
                    if (first) { first = false; }
                    sql.append("AND ID_DETALLERANGOCUPO= ").append(valueObject.getID_DETALLERANGOCUPO()).append(" ");
            }

            if (valueObject.getDISPONIBLE() != null&&!valueObject.getDISPONIBLE().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND DISPONIBLE= '").append(valueObject.getDISPONIBLE()).append("' ");
            }

            if (valueObject.getNUMERO_CUPO() != null&&!valueObject.getNUMERO_CUPO().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND NUMERO_CUPO= '").append(valueObject.getNUMERO_CUPO()).append("' ");
            }

            if (valueObject.getTIPO_VEHICULO() != null&&!valueObject.getTIPO_VEHICULO().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND TIPO_VEHICULO= '").append(valueObject.getTIPO_VEHICULO()).append("' ");
            }

            if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
            }

            if (valueObject.getPROPIETARIO() != null&&!valueObject.getPROPIETARIO().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND PROPIETARIO= '").append(valueObject.getPROPIETARIO()).append("' ");
            }

            if (valueObject.getNIT_EMPRESA_SERVICIO() != null&&!valueObject.getNIT_EMPRESA_SERVICIO().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND NIT_EMPRESA_SERVICIO= '").append(valueObject.getNIT_EMPRESA_SERVICIO()).append("' ");
            }

            if (valueObject.getRAZON_SOCIAL() != null&&!valueObject.getRAZON_SOCIAL().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND RAZON_SOCIAL= '").append(valueObject.getRAZON_SOCIAL()).append("' ");
            }

            if (valueObject.getTARJETA_ACTIVA() != null&&!valueObject.getTARJETA_ACTIVA().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND TARJETA_ACTIVA= '").append(valueObject.getTARJETA_ACTIVA()).append("' ");
            }

            if (valueObject.getNUMERO_TARJETA() != null&&!valueObject.getNUMERO_TARJETA().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND NUMERO_TARJETA= '").append(valueObject.getNUMERO_TARJETA()).append("' ");
            }

            if (valueObject.getFECHA_VENCIMIENTO() != null&&!valueObject.getFECHA_VENCIMIENTO().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND FECHA_VENCIMIENTO= '").append(valueObject.getFECHA_VENCIMIENTO()).append("' ");
            }

            sql.append("ORDER BY RAZON_SOCIAL ASC");
            
            first = false;

            if (first)
                    searchResults = new ArrayList();
            else
                    searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

            return searchResults;
    }



	public List searchMatching(Connection conn, Viewinventariocupos valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_DETALLERANGOCUPO) AS RowNumber FROM VIEW_INVENTARIO_CUPOS WHERE 1=1 ");
		if (valueObject.getID_DETALLERANGOCUPO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DETALLERANGOCUPO= ").append(valueObject.getID_DETALLERANGOCUPO()).append(" ");
		}

		if (valueObject.getDISPONIBLE() != null&&!valueObject.getDISPONIBLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND DISPONIBLE= '").append(valueObject.getDISPONIBLE()).append("' ");
		}

		if (valueObject.getNUMERO_CUPO() != null&&!valueObject.getNUMERO_CUPO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMERO_CUPO= '").append(valueObject.getNUMERO_CUPO()).append("' ");
		}

		if (valueObject.getTIPO_VEHICULO() != null&&!valueObject.getTIPO_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPO_VEHICULO= '").append(valueObject.getTIPO_VEHICULO()).append("' ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getPROPIETARIO() != null&&!valueObject.getPROPIETARIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND PROPIETARIO= '").append(valueObject.getPROPIETARIO()).append("' ");
		}

		if (valueObject.getNIT_EMPRESA_SERVICIO() != null&&!valueObject.getNIT_EMPRESA_SERVICIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NIT_EMPRESA_SERVICIO= '").append(valueObject.getNIT_EMPRESA_SERVICIO()).append("' ");
		}

		if (valueObject.getRAZON_SOCIAL() != null&&!valueObject.getRAZON_SOCIAL().equals("")) {
			if (first) { first = false; }
			sql.append("AND RAZON_SOCIAL= '").append(valueObject.getRAZON_SOCIAL()).append("' ");
		}

		if (valueObject.getTARJETA_ACTIVA() != null&&!valueObject.getTARJETA_ACTIVA().equals("")) {
			if (first) { first = false; }
			sql.append("AND TARJETA_ACTIVA= '").append(valueObject.getTARJETA_ACTIVA()).append("' ");
		}

		if (valueObject.getNUMERO_TARJETA() != null&&!valueObject.getNUMERO_TARJETA().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMERO_TARJETA= '").append(valueObject.getNUMERO_TARJETA()).append("' ");
		}

		if (valueObject.getFECHA_VENCIMIENTO() != null&&!valueObject.getFECHA_VENCIMIENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_VENCIMIENTO= '").append(valueObject.getFECHA_VENCIMIENTO()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Viewinventariocupos valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM VIEW_INVENTARIO_CUPOS WHERE 1=1 ");
		if (valueObject.getID_DETALLERANGOCUPO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_DETALLERANGOCUPO= ").append(valueObject.getID_DETALLERANGOCUPO()).append(" ");
		}

		if (valueObject.getDISPONIBLE() != null&&!valueObject.getDISPONIBLE().equals("")) {
			if (first) { first = false; }
			sql.append("AND DISPONIBLE= '").append(valueObject.getDISPONIBLE()).append("' ");
		}

		if (valueObject.getNUMERO_CUPO() != null&&!valueObject.getNUMERO_CUPO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMERO_CUPO= '").append(valueObject.getNUMERO_CUPO()).append("' ");
		}

		if (valueObject.getTIPO_VEHICULO() != null&&!valueObject.getTIPO_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPO_VEHICULO= '").append(valueObject.getTIPO_VEHICULO()).append("' ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getPROPIETARIO() != null&&!valueObject.getPROPIETARIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND PROPIETARIO= '").append(valueObject.getPROPIETARIO()).append("' ");
		}

		if (valueObject.getNIT_EMPRESA_SERVICIO() != null&&!valueObject.getNIT_EMPRESA_SERVICIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NIT_EMPRESA_SERVICIO= '").append(valueObject.getNIT_EMPRESA_SERVICIO()).append("' ");
		}

		if (valueObject.getRAZON_SOCIAL() != null&&!valueObject.getRAZON_SOCIAL().equals("")) {
			if (first) { first = false; }
			sql.append("AND RAZON_SOCIAL= '").append(valueObject.getRAZON_SOCIAL()).append("' ");
		}

		if (valueObject.getTARJETA_ACTIVA() != null&&!valueObject.getTARJETA_ACTIVA().equals("")) {
			if (first) { first = false; }
			sql.append("AND TARJETA_ACTIVA= '").append(valueObject.getTARJETA_ACTIVA()).append("' ");
		}

		if (valueObject.getNUMERO_TARJETA() != null&&!valueObject.getNUMERO_TARJETA().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMERO_TARJETA= '").append(valueObject.getNUMERO_TARJETA()).append("' ");
		}

		if (valueObject.getFECHA_VENCIMIENTO() != null&&!valueObject.getFECHA_VENCIMIENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_VENCIMIENTO= '").append(valueObject.getFECHA_VENCIMIENTO()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Viewinventariocupos valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_DETALLERANGOCUPO(result.getInt("ID_DETALLERANGOCUPO"));
				valueObject.setDISPONIBLE(result.getString("DISPONIBLE"));
				valueObject.setNUMERO_CUPO(result.getString("NUMERO_CUPO"));
				valueObject.setTIPO_VEHICULO(result.getString("TIPO_VEHICULO"));
				valueObject.setPLACA(result.getString("PLACA"));
				valueObject.setPROPIETARIO(result.getString("PROPIETARIO"));
				valueObject.setNIT_EMPRESA_SERVICIO(result.getString("NIT_EMPRESA_SERVICIO"));
				valueObject.setRAZON_SOCIAL(result.getString("RAZON_SOCIAL"));
				valueObject.setTARJETA_ACTIVA(result.getString("TARJETA_ACTIVA"));
				valueObject.setNUMERO_TARJETA(result.getString("NUMERO_TARJETA"));
				valueObject.setFECHA_VENCIMIENTO(result.getString("FECHA_VENCIMIENTO"));

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
				Viewinventariocupos temp = createValueObject();

				temp.setID_DETALLERANGOCUPO(result.getInt("ID_DETALLERANGOCUPO"));
				temp.setDISPONIBLE(result.getString("DISPONIBLE"));
				temp.setNUMERO_CUPO(result.getString("NUMERO_CUPO"));
				temp.setTIPO_VEHICULO(result.getString("TIPO_VEHICULO"));
				temp.setPLACA(result.getString("PLACA"));
				temp.setPROPIETARIO(result.getString("PROPIETARIO"));
				temp.setNIT_EMPRESA_SERVICIO(result.getString("NIT_EMPRESA_SERVICIO"));
				temp.setRAZON_SOCIAL(result.getString("RAZON_SOCIAL"));
				temp.setTARJETA_ACTIVA(result.getString("TARJETA_ACTIVA"));
				temp.setNUMERO_TARJETA(result.getString("NUMERO_TARJETA"));
				temp.setFECHA_VENCIMIENTO(result.getString("FECHA_VENCIMIENTO"));
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
