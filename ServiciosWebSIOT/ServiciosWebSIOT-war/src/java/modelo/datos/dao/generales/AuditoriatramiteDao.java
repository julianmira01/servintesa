package modelo.datos.dao.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.objetos.generales.Auditoriatramite;

import utilidades.Funciones;


public class AuditoriatramiteDao {


	public Auditoriatramite createValueObject() {
		return new Auditoriatramite();
	}

	public Auditoriatramite getObject(Connection conn,int ID) throws SQLException {
		Auditoriatramite valueObject = createValueObject();
		valueObject.setID(ID);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Auditoriatramite valueObject) throws  SQLException {
		String sql = "SELECT * FROM AUDITORIATRAMITE WHERE (ID = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM AUDITORIATRAMITE ORDER BY ID ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID) AS RowNumber FROM AUDITORIATRAMITE) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Auditoriatramite valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO AUDITORIATRAMITE (USUARIO, "+
			" TARGET_TRAMITE, PLACA_VEHICULO, CEDULA_PERSONA,"+
			" TRAMITE, FECHA, HORA,"+
			" ACCION, INFO_ADICIONAL,ID)"+
			 " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			
			        if(Funciones.contarCadena(valueObject.getUSUARIO(),100))
			            stmt.setString(1, valueObject.getUSUARIO());
			        else
			            stmt.setNull(1, Types.VARCHAR);
                                if(!Funciones.EnteroesNulo(valueObject.getTARGET_TRAMITE()))
					stmt.setInt(2, valueObject.getTARGET_TRAMITE());
				else
					stmt.setNull(2, Types.INTEGER);                 
                    		if(Funciones.contarCadena(valueObject.getPLACA_VEHICULO(),10))
					stmt.setString(3, valueObject.getPLACA_VEHICULO());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCEDULA_PERSONA(),20))
					stmt.setString(4, valueObject.getCEDULA_PERSONA());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTRAMITE(),1000))
					stmt.setString(5, valueObject.getTRAMITE());
				else
					stmt.setNull(5, Types.VARCHAR);
				if(Funciones.esFecha(valueObject.getFECHA()))
					stmt.setDate(6, Funciones.convFechaSSQL(valueObject.getFECHA()));
				else
					stmt.setNull(6, Types.DATE);
				if(Funciones.esTime((valueObject.getHORA())))
					stmt.setTime(7, Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORA())));
				else
					stmt.setNull(7, Types.TIME);
				if(!Funciones.EnteroesNulo(valueObject.getACCION()))
					stmt.setInt(8, valueObject.getACCION());
				else
					stmt.setNull(8, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getINFO_ADICIONAL(),1000))
					stmt.setString(9, valueObject.getINFO_ADICIONAL());
				else
					stmt.setNull(9, Types.VARCHAR);

                                 stmt.setInt(10, valueObject.getID());   

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Auditoriatramite valueObject) throws  SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE AUDITORIATRAMITE SET  TARGET_TRAMITE = ?, PLACA_VEHICULO = ?, CEDULA_PERSONA = ?,"+
			" TRAMITE = ?, FECHA = ?, HORA = ?,"+
			" ACCION = ?, INFO_ADICIONAL = ? WHERE (ID= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getTARGET_TRAMITE()))
					stmt.setInt(1, valueObject.getTARGET_TRAMITE());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getPLACA_VEHICULO(),10))
					stmt.setString(2, valueObject.getPLACA_VEHICULO());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCEDULA_PERSONA(),20))
					stmt.setString(3, valueObject.getCEDULA_PERSONA());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTRAMITE(),1000))
					stmt.setString(4, valueObject.getTRAMITE());
				else
					stmt.setNull(4, Types.VARCHAR);
				        
			  if (Funciones.esFecha(valueObject.getFECHA()))
			    stmt.setDate(5, Funciones.convFechaSSQL(valueObject.getFECHA()));
			  else
			    stmt.setNull(5, Types.DATE);
        
        //if(Funciones.contarCadena(valueObject.getHORA(),0))
					//stmt.setString(6, valueObject.getHORA());
				//else
					//stmt.setNull(6, Types.VARCHAR);
			  if (Funciones.esTime(valueObject.getHORA()))
			      stmt.setTime(6, Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORA())));
			  else
			      stmt.setNull(6, Types.TIME);
        
				if(!Funciones.EnteroesNulo(valueObject.getACCION()))
					stmt.setInt(7, valueObject.getACCION());
				else
					stmt.setNull(7, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getINFO_ADICIONAL(),1000))
					stmt.setString(8, valueObject.getINFO_ADICIONAL());
				else
					stmt.setNull(8, Types.VARCHAR);
				stmt.setInt(9, valueObject.getID());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
				    throw new SQLException("No se actualizaron filas!)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Auditoriatramite valueObject) throws  SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM AUDITORIATRAMITE WHERE (ID = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID());

			int rowcount = databaseUpdate(conn, stmt);
			if (rowcount == 0) {
			    throw new SQLException("No se borro ninguna fila");
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
		String sql = "SELECT count(*) FROM AUDITORIATRAMITE";
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
	public List searchMatching(Connection conn, Auditoriatramite valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM AUDITORIATRAMITE WHERE 1=1 ");
		               
                
                if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}

	        if (valueObject.getUSUARIO() != null&&!valueObject.getUSUARIO().equals("")) {
	            if (first) { first = false; }
	            sql.append("AND USUARIO= '").append(valueObject.getUSUARIO()).append("' ");
	        }

		if (valueObject.getTARGET_TRAMITE() != 0) {
			if (first) { first = false; }
			sql.append("AND TARGET_TRAMITE= ").append(valueObject.getTARGET_TRAMITE()).append(" ");
		}

		if (valueObject.getPLACA_VEHICULO() != null&&!valueObject.getPLACA_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA_VEHICULO= '").append(valueObject.getPLACA_VEHICULO()).append("' ");
		}

		if (valueObject.getCEDULA_PERSONA() != null&&!valueObject.getCEDULA_PERSONA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CEDULA_PERSONA= '").append(valueObject.getCEDULA_PERSONA()).append("' ");
		}

		if (valueObject.getTRAMITE() != null&&!valueObject.getTRAMITE().equals("")) {
			if (first) { first = false; }
			sql.append("AND TRAMITE LIKE '%").append(valueObject.getTRAMITE()).append("%' ");
		}

		if (valueObject.getFECHA() != null&&!valueObject.getFECHA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA = '").append(valueObject.getFECHA()).append("' ");
		}

		if (valueObject.getHORA() != null&&!valueObject.getHORA().equals("")) {
			if (first) { first = false; }
			sql.append("AND HORA= '").append(valueObject.getHORA()).append("' ");
		}

		if (valueObject.getACCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ACCION= ").append(valueObject.getACCION()).append(" ");
		}

		if (valueObject.getINFO_ADICIONAL() != null&&!valueObject.getINFO_ADICIONAL().equals("")) {
			if (first) { first = false; }
			sql.append("AND INFO_ADICIONAL LIKE '%").append(valueObject.getINFO_ADICIONAL()).append("%' ");
		}

		sql.append("ORDER BY ID ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}

    public List searchMatchingView(Connection conn, Auditoriatramite valueObject) throws SQLException {
            List searchResults;

            boolean first = true;
            StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_AUDITORIATRAMITE WHERE 1=1 ");
                           
            
            if (valueObject.getID() != 0) {
                    if (first) { first = false; }
                    sql.append("AND ID= ").append(valueObject.getID()).append(" ");
            }

            if (valueObject.getUSUARIO() != null&&!valueObject.getUSUARIO().equals("")) {
                if (first) { first = false; }
                sql.append("AND USUARIO= '").append(valueObject.getUSUARIO()).append("' ");
            }

            if (valueObject.getTARGET_TRAMITE() != 0) {
                    if (first) { first = false; }
                    sql.append("AND TARGET_TRAMITE= ").append(valueObject.getTARGET_TRAMITE()).append(" ");
            }

            if (valueObject.getPLACA_VEHICULO() != null&&!valueObject.getPLACA_VEHICULO().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND PLACA_VEHICULO= '").append(valueObject.getPLACA_VEHICULO()).append("' ");
            }

            if (valueObject.getCEDULA_PERSONA() != null&&!valueObject.getCEDULA_PERSONA().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND CEDULA_PERSONA= '").append(valueObject.getCEDULA_PERSONA()).append("' ");
            }

            if (valueObject.getTRAMITE() != null&&!valueObject.getTRAMITE().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND TRAMITE LIKE '%").append(valueObject.getTRAMITE()).append("%' ");
            }

            if (valueObject.getFECHA() != null&&!valueObject.getFECHA().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND FECHA = '").append(valueObject.getFECHA()).append("' ");
            }

            if (valueObject.getHORA() != null&&!valueObject.getHORA().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND HORA= '").append(valueObject.getHORA()).append("' ");
            }

            if (valueObject.getACCION() != 0) {
                    if (first) { first = false; }
                    sql.append("AND ACCION= ").append(valueObject.getACCION()).append(" ");
            }

            if (valueObject.getINFO_ADICIONAL() != null&&!valueObject.getINFO_ADICIONAL().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND INFO_ADICIONAL LIKE '%").append(valueObject.getINFO_ADICIONAL()).append("%' ");
            }

            sql.append("ORDER BY ID ASC ");

            if (first)
                    searchResults = new ArrayList();
            else
                    searchResults = listQueryView(conn, conn.prepareStatement(sql.toString()));

            return searchResults;
    }


	public List searchMatching(Connection conn, Auditoriatramite valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID) AS RowNumber FROM AUDITORIATRAMITE WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}
                
	    if (valueObject.getUSUARIO() != null&&!valueObject.getUSUARIO().equals("")) {
	        if (first) { first = false; }
	        sql.append("AND USUARIO= '").append(valueObject.getUSUARIO()).append("' ");
	    }

		if (valueObject.getTARGET_TRAMITE() != 0) {
			if (first) { first = false; }
			sql.append("AND TARGET_TRAMITE= ").append(valueObject.getTARGET_TRAMITE()).append(" ");
		}

		if (valueObject.getPLACA_VEHICULO() != null&&!valueObject.getPLACA_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA_VEHICULO= '").append(valueObject.getPLACA_VEHICULO()).append("' ");
		}

		if (valueObject.getCEDULA_PERSONA() != null&&!valueObject.getCEDULA_PERSONA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CEDULA_PERSONA= '").append(valueObject.getCEDULA_PERSONA()).append("' ");
		}

		if (valueObject.getTRAMITE() != null&&!valueObject.getTRAMITE().equals("")) {
			if (first) { first = false; }
			sql.append("AND TRAMITE= '").append(valueObject.getTRAMITE()).append("' ");
		}

		if (valueObject.getFECHA() != null&&!valueObject.getFECHA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA= '").append(valueObject.getFECHA()).append("' ");
		}

		if (valueObject.getHORA() != null&&!valueObject.getHORA().equals("")) {
			if (first) { first = false; }
			sql.append("AND HORA= '").append(valueObject.getHORA()).append("' ");
		}

		if (valueObject.getACCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ACCION= ").append(valueObject.getACCION()).append(" ");
		}

		if (valueObject.getINFO_ADICIONAL() != null&&!valueObject.getINFO_ADICIONAL().equals("")) {
			if (first) { first = false; }
			sql.append("AND INFO_ADICIONAL= '").append(valueObject.getINFO_ADICIONAL()).append("' ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}

    
    

	public int countSearchMatching(Connection conn, Auditoriatramite valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM AUDITORIATRAMITE WHERE 1=1 ");
		if (valueObject.getID() != 0) {
			if (first) { first = false; }
			sql.append("AND ID= ").append(valueObject.getID()).append(" ");
		}
                
	    if (valueObject.getUSUARIO() != null&&!valueObject.getUSUARIO().equals("")) {
	        if (first) { first = false; }
	        sql.append("AND USUARIO= '").append(valueObject.getUSUARIO()).append("' ");
	    }

		if (valueObject.getTARGET_TRAMITE() != 0) {
			if (first) { first = false; }
			sql.append("AND TARGET_TRAMITE= ").append(valueObject.getTARGET_TRAMITE()).append(" ");
		}

		if (valueObject.getPLACA_VEHICULO() != null&&!valueObject.getPLACA_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA_VEHICULO= '").append(valueObject.getPLACA_VEHICULO()).append("' ");
		}

		if (valueObject.getCEDULA_PERSONA() != null&&!valueObject.getCEDULA_PERSONA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CEDULA_PERSONA= '").append(valueObject.getCEDULA_PERSONA()).append("' ");
		}

		if (valueObject.getTRAMITE() != null&&!valueObject.getTRAMITE().equals("")) {
			if (first) { first = false; }
			sql.append("AND TRAMITE= '").append(valueObject.getTRAMITE()).append("' ");
		}

		if (valueObject.getFECHA() != null&&!valueObject.getFECHA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA= '").append(valueObject.getFECHA()).append("' ");
		}

		if (valueObject.getHORA() != null&&!valueObject.getHORA().equals("")) {
			if (first) { first = false; }
			sql.append("AND HORA= '").append(valueObject.getHORA()).append("' ");
		}

		if (valueObject.getACCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ACCION= ").append(valueObject.getACCION()).append(" ");
		}

		if (valueObject.getINFO_ADICIONAL() != null&&!valueObject.getINFO_ADICIONAL().equals("")) {
			if (first) { first = false; }
			sql.append("AND INFO_ADICIONAL= '").append(valueObject.getINFO_ADICIONAL()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Auditoriatramite valueObject) throws SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID(result.getInt("ID"));
			        valueObject.setUSUARIO(result.getString("USUARIO"));
				valueObject.setTARGET_TRAMITE(result.getInt("TARGET_TRAMITE"));
				valueObject.setPLACA_VEHICULO(result.getString("PLACA_VEHICULO"));
				valueObject.setCEDULA_PERSONA(result.getString("CEDULA_PERSONA"));
				valueObject.setTRAMITE(result.getString("TRAMITE"));
				valueObject.setFECHA(result.getString("FECHA"));
				valueObject.setHORA(result.getString("HORA"));
				valueObject.setACCION(result.getInt("ACCION"));
				valueObject.setINFO_ADICIONAL(result.getString("INFO_ADICIONAL"));

			} else {
			    throw new SQLException("No hay datos que leer");
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
				Auditoriatramite temp = createValueObject();
                               
				temp.setID(result.getInt("ID"));
			        temp.setUSUARIO(result.getString("USUARIO"));
				temp.setTARGET_TRAMITE(result.getInt("TARGET_TRAMITE"));
				temp.setPLACA_VEHICULO(result.getString("PLACA_VEHICULO"));
				temp.setCEDULA_PERSONA(result.getString("CEDULA_PERSONA"));
				temp.setTRAMITE(result.getString("TRAMITE"));
				temp.setFECHA(result.getString("FECHA"));
				temp.setHORA(result.getString("HORA"));
				temp.setACCION(result.getInt("ACCION"));
				temp.setINFO_ADICIONAL(result.getString("INFO_ADICIONAL"));
				//temp.setNOMBRE(result.getString("NOMBRE"));
                                //temp.setAPELLIDO(result.getString("APELLIDO"));
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

    protected List listQueryView(Connection conn, PreparedStatement stmt) throws SQLException {

            ArrayList searchResults = new ArrayList();
            ResultSet result = null;
            try {
                    result = stmt.executeQuery();
                    while (result.next()) {
                            Auditoriatramite temp = createValueObject();
                           
                            temp.setID(result.getInt("ID"));
                            temp.setUSUARIO(result.getString("USUARIO"));
                            temp.setTARGET_TRAMITE(result.getInt("TARGET_TRAMITE"));
                            temp.setPLACA_VEHICULO(result.getString("PLACA_VEHICULO"));
                            temp.setCEDULA_PERSONA(result.getString("CEDULA_PERSONA"));
                            temp.setTRAMITE(result.getString("TRAMITE"));
                            temp.setFECHA(result.getString("FECHA"));
                            temp.setHORA(result.getString("HORA"));
                            temp.setACCION(result.getInt("ACCION"));
                            temp.setINFO_ADICIONAL(result.getString("INFO_ADICIONAL"));
                            temp.setNOMBRE(result.getString("NOMBRE"));
                            temp.setAPELLIDO(result.getString("APELLIDO"));
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
