package modelo.datos.dao.licenciasConduccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.licenciasConduccion.Viewlicenciaconduccion;

import utilidades.Funciones;


public class ViewlicenciaconduccionDao {


	public Viewlicenciaconduccion createValueObject() {
		return new Viewlicenciaconduccion();
	}

	public Viewlicenciaconduccion getObject(Connection conn,String ID_LICENCIA) throws NotFoundException, SQLException {
		Viewlicenciaconduccion valueObject = createValueObject();
		valueObject.setID_LICENCIA(ID_LICENCIA);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Viewlicenciaconduccion valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM VIEW_LICENCIACONDUCCION WHERE (ID_LICENCIA = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, valueObject.getID_LICENCIA());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM VIEW_LICENCIACONDUCCION ORDER BY ID_LICENCIA ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Viewlicenciaconduccion valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO VIEW_LICENCIACONDUCCION ( ID_PERSONA, NUMEROLICENCIA, TIPOIDENTIFICACION,"+
			" IDENTIFICACION, FECHATRAMITE, ID_TRAMITEINTERNO,"+
			" CATEGORIA, CODESCUELA, ID_CIUDADPERSONA,"+
			" NROCERTIFICADOESCUELA, CODESPECIEVENAL, NROLICENCIAANTERIOR,"+
			" NROCERTIFICADOMEDICO, NROCONSIGNACION, FECHAVENCIMIENTO)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_PERSONA()))
					stmt.setInt(1, valueObject.getID_PERSONA());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNUMEROLICENCIA(),30))
					stmt.setString(2, valueObject.getNUMEROLICENCIA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTIPOIDENTIFICACION(),2))
					stmt.setString(3, valueObject.getTIPOIDENTIFICACION());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getIDENTIFICACION(),20))
					stmt.setString(4, valueObject.getIDENTIFICACION());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(valueObject.getFECHATRAMITE() != null && Funciones.esFecha(valueObject.getFECHATRAMITE().toString()))
					stmt.setDate(5, new java.sql.Date(java.sql.Date.parse(valueObject.getFECHATRAMITE().toString())));
				else
					stmt.setNull(5, Types.DATE);
				if(!Funciones.EnteroesNulo(valueObject.getID_TRAMITEINTERNO()))
					stmt.setInt(6, valueObject.getID_TRAMITEINTERNO());
				else
					stmt.setNull(6, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCATEGORIA(),10))
					stmt.setString(7, valueObject.getCATEGORIA());
				else
					stmt.setNull(7, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getCODESCUELA()))
					stmt.setInt(8, valueObject.getCODESCUELA());
				else
					stmt.setNull(8, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_CIUDADPERSONA()))
					stmt.setInt(9, valueObject.getID_CIUDADPERSONA());
				else
					stmt.setNull(9, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNROCERTIFICADOESCUELA(),40))
					stmt.setString(10, valueObject.getNROCERTIFICADOESCUELA());
				else
					stmt.setNull(10, Types.VARCHAR);
				if(!Funciones.DoubleEsNulo(valueObject.getCODESPECIEVENAL()))
					stmt.setDouble(11, valueObject.getCODESPECIEVENAL());
				else
					stmt.setNull(11, Types.DOUBLE);
				if(Funciones.contarCadena(valueObject.getNROLICENCIAANTERIOR(),40))
					stmt.setString(12, valueObject.getNROLICENCIAANTERIOR());
				else
					stmt.setNull(12, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNROCERTIFICADOMEDICO(),40))
					stmt.setString(13, valueObject.getNROCERTIFICADOMEDICO());
				else
					stmt.setNull(13, Types.VARCHAR);
                                if(!Funciones.DoubleEsNulo(valueObject.getNROCONSIGNACION()))
			            stmt.setDouble(14, valueObject.getNROCONSIGNACION());
                                else
			            stmt.setNull(14, Types.DOUBLE);
				if(valueObject.getFECHAVENCIMIENTO() != null && Funciones.esFecha(valueObject.getFECHAVENCIMIENTO().toString()))
					stmt.setDate(15, new java.sql.Date(java.sql.Date.parse(valueObject.getFECHAVENCIMIENTO().toString())));
				else
					stmt.setNull(15, Types.DATE);

				int rowcount = databaseUpdate(conn, stmt);
                    
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Viewlicenciaconduccion valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE VIEW_LICENCIACONDUCCION SET  ID_PERSONA = ?, NUMEROLICENCIA = ?, TIPOIDENTIFICACION = ?,"+
			" IDENTIFICACION = ?, FECHATRAMITE = ?, ID_TRAMITEINTERNO = ?,"+
			" CATEGORIA = ?, CODESCUELA = ?, ID_CIUDADPERSONA = ?,"+
			" NROCERTIFICADOESCUELA = ?, CODESPECIEVENAL = ?, NROLICENCIAANTERIOR = ?,"+
			" NROCERTIFICADOMEDICO = ?, NROCONSIGNACION = ?, FECHAVENCIMIENTO = ? WHERE (ID_LICENCIA= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_PERSONA()))
					stmt.setInt(1, valueObject.getID_PERSONA());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNUMEROLICENCIA(),30))
					stmt.setString(2, valueObject.getNUMEROLICENCIA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTIPOIDENTIFICACION(),2))
					stmt.setString(3, valueObject.getTIPOIDENTIFICACION());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getIDENTIFICACION(),20))
					stmt.setString(4, valueObject.getIDENTIFICACION());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(valueObject.getFECHATRAMITE() != null && Funciones.esFecha(valueObject.getFECHATRAMITE().toString()))
					stmt.setDate(5, new java.sql.Date(java.sql.Date.parse(valueObject.getFECHATRAMITE().toString())));
				else
					stmt.setNull(5, Types.DATE);
				if(!Funciones.EnteroesNulo(valueObject.getID_TRAMITEINTERNO()))
					stmt.setInt(6, valueObject.getID_TRAMITEINTERNO());
				else
					stmt.setNull(6, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCATEGORIA(),10))
					stmt.setString(7, valueObject.getCATEGORIA());
				else
					stmt.setNull(7, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getCODESCUELA()))
					stmt.setInt(8, valueObject.getCODESCUELA());
				else
					stmt.setNull(8, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_CIUDADPERSONA()))
					stmt.setInt(9, valueObject.getID_CIUDADPERSONA());
				else
					stmt.setNull(9, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNROCERTIFICADOESCUELA(),40))
					stmt.setString(10, valueObject.getNROCERTIFICADOESCUELA());
				else
					stmt.setNull(10, Types.VARCHAR);
				if(!Funciones.DoubleEsNulo(valueObject.getCODESPECIEVENAL()))
					stmt.setDouble(11, valueObject.getCODESPECIEVENAL());
				else
					stmt.setNull(11, Types.DOUBLE);
				if(Funciones.contarCadena(valueObject.getNROLICENCIAANTERIOR(),40))
					stmt.setString(12, valueObject.getNROLICENCIAANTERIOR());
				else
					stmt.setNull(12, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNROCERTIFICADOMEDICO(),40))
					stmt.setString(13, valueObject.getNROCERTIFICADOMEDICO());
				else
					stmt.setNull(13, Types.VARCHAR);
                                    
                                if(!Funciones.DoubleEsNulo(valueObject.getNROCONSIGNACION()))
			            stmt.setDouble(14, valueObject.getNROCONSIGNACION());
                                else
			            stmt.setNull(14, Types.DOUBLE);    
                                
				if(valueObject.getFECHAVENCIMIENTO() != null && Funciones.esFecha(valueObject.getFECHAVENCIMIENTO().toString()))
					stmt.setDate(15, new java.sql.Date(java.sql.Date.parse(valueObject.getFECHAVENCIMIENTO().toString())));
				else
					stmt.setNull(15, Types.DATE);
				stmt.setString(16, valueObject.getID_LICENCIA());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Viewlicenciaconduccion valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM VIEW_LICENCIACONDUCCION WHERE (ID_LICENCIA = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, valueObject.getID_LICENCIA());

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


	public List searchMatching(Connection conn, Viewlicenciaconduccion valueObject, Date fechaIni, Date fechaFin) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_LICENCIACONDUCCION WHERE 1=1 ");
		if (valueObject.getID_LICENCIA() != null && !valueObject.getID_LICENCIA().equals("") && !valueObject.getID_LICENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND ID_LICENCIA= '").append(valueObject.getID_LICENCIA()).append("' ");
		}

		if (valueObject.getID_PERSONA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PERSONA= ").append(valueObject.getID_PERSONA()).append(" ");
		}

		if (valueObject.getNUMEROLICENCIA() != null && !valueObject.getNUMEROLICENCIA().equals("") && !valueObject.getNUMEROLICENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMEROLICENCIA= '").append(valueObject.getNUMEROLICENCIA()).append("' ");
		}

		if (valueObject.getTIPOIDENTIFICACION() != null && !valueObject.getTIPOIDENTIFICACION().equals("") && !valueObject.getTIPOIDENTIFICACION().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPOIDENTIFICACION= '").append(valueObject.getTIPOIDENTIFICACION()).append("' ");
		}

		if (valueObject.getIDENTIFICACION() != null && !valueObject.getIDENTIFICACION().equals("") && !valueObject.getIDENTIFICACION().equals("")) {
			if (first) { first = false; }
			sql.append("AND IDENTIFICACION= '").append(valueObject.getIDENTIFICACION()).append("' ");
		}
                
        if (fechaIni != null && fechaFin != null) {
            if (first) { first = false; }
            
            java.sql.Date fi = new java.sql.Date(fechaIni.getTime());
            java.sql.Date ff = new java.sql.Date(fechaFin.getTime());
            sql.append("AND FECHATRAMITE BETWEEN ('").append(Funciones.convFechaSQLS(fi)).append("') AND ('").append(Funciones.convFechaSQLS(ff)).append("') ");
        }

		if (valueObject.getFECHATRAMITE() != null) {
			if (first) { first = false; }
		    java.sql.Date fecha = new java.sql.Date(valueObject.getFECHATRAMITE().getTime());
			sql.append("AND FECHATRAMITE= '").append(Funciones.convFechaSQLS(fecha)).append("' ");
		}

		if (valueObject.getID_TRAMITEINTERNO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_TRAMITEINTERNO= ").append(valueObject.getID_TRAMITEINTERNO()).append(" ");
		}

		if (valueObject.getCATEGORIA() != null && !valueObject.getCATEGORIA().equals("") && !valueObject.getCATEGORIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CATEGORIA= '").append(valueObject.getCATEGORIA()).append("' ");
		}

		if (valueObject.getCODESCUELA() != 0) {
			if (first) { first = false; }
			sql.append("AND CODESCUELA= ").append(valueObject.getCODESCUELA()).append(" ");
		}

		if (valueObject.getID_CIUDADPERSONA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CIUDADPERSONA= ").append(valueObject.getID_CIUDADPERSONA()).append(" ");
		}

		if (valueObject.getNROCERTIFICADOESCUELA() != null && !valueObject.getNROCERTIFICADOESCUELA().equals("") && !valueObject.getNROCERTIFICADOESCUELA().equals("")) {
			if (first) { first = false; }
			sql.append("AND NROCERTIFICADOESCUELA= '").append(valueObject.getNROCERTIFICADOESCUELA()).append("' ");
		}

		if (valueObject.getCODESPECIEVENAL() != 0) {
			if (first) { first = false; }
			sql.append("AND CODESPECIEVENAL= ").append(valueObject.getCODESPECIEVENAL()).append(" ");
		}

		if (valueObject.getNROLICENCIAANTERIOR() != null && !valueObject.getNROLICENCIAANTERIOR().equals("") && !valueObject.getNROLICENCIAANTERIOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND NROLICENCIAANTERIOR= '").append(valueObject.getNROLICENCIAANTERIOR()).append("' ");
		}

		if (valueObject.getNROCERTIFICADOMEDICO() != null && !valueObject.getNROCERTIFICADOMEDICO().equals("") && !valueObject.getNROCERTIFICADOMEDICO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NROCERTIFICADOMEDICO= '").append(valueObject.getNROCERTIFICADOMEDICO()).append("' ");
		}
                
                if (valueObject.getNROCONSIGNACION()!= 0) {
	            if (first) { first = false; }
	            sql.append("AND NROCONSIGNACION= ").append(valueObject.getNROCONSIGNACION()).append(" ");
                }

		if (valueObject.getFECHAVENCIMIENTO() != null) {
			if (first) { first = false; }
		    java.sql.Date fecha = new java.sql.Date(valueObject.getFECHAVENCIMIENTO().getTime());
			sql.append("AND FECHAVENCIMIENTO= '").append(Funciones.convFechaSQLS(fecha)).append("' ");
		}

		sql.append("ORDER BY ID_LICENCIA ASC ");
                System.out.println("ViewLicenciasConduccion: " + sql);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}

    public List searchMatchingFechasOK(Connection conn, Viewlicenciaconduccion valueObject, String fechaIni, String fechaFin) throws SQLException {
            List searchResults;

            boolean first = true;
            StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_LICENCIACONDUCCION WHERE 1=1 ");
            if (valueObject.getID_LICENCIA() != null && !valueObject.getID_LICENCIA().equals("") && !valueObject.getID_LICENCIA().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND ID_LICENCIA= '").append(valueObject.getID_LICENCIA()).append("' ");
            }

            if (valueObject.getID_PERSONA() != 0) {
                    if (first) { first = false; }
                    sql.append("AND ID_PERSONA= ").append(valueObject.getID_PERSONA()).append(" ");
            }

            if (valueObject.getNUMEROLICENCIA() != null && !valueObject.getNUMEROLICENCIA().equals("") && !valueObject.getNUMEROLICENCIA().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND NUMEROLICENCIA= '").append(valueObject.getNUMEROLICENCIA()).append("' ");
            }

            if (valueObject.getTIPOIDENTIFICACION() != null && !valueObject.getTIPOIDENTIFICACION().equals("") && !valueObject.getTIPOIDENTIFICACION().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND TIPOIDENTIFICACION= '").append(valueObject.getTIPOIDENTIFICACION()).append("' ");
            }

            if (valueObject.getIDENTIFICACION() != null && !valueObject.getIDENTIFICACION().equals("") && !valueObject.getIDENTIFICACION().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND IDENTIFICACION= '").append(valueObject.getIDENTIFICACION()).append("' ");
            }
            
    if (fechaIni != null && fechaFin != null && !fechaIni.equals("") && !fechaFin.equals("")) {
        if (first) { first = false; }
                
        sql.append("AND FECHATRAMITE BETWEEN ('").append(fechaIni).append("') AND ('").append(fechaFin).append("') ");
    }

            if (valueObject.getFECHATRAMITE() != null) {
                    if (first) { first = false; }
                java.sql.Date fecha = new java.sql.Date(valueObject.getFECHATRAMITE().getTime());
                    sql.append("AND FECHATRAMITE= '").append(Funciones.convFechaSQLS(fecha)).append("' ");
            }

            if (valueObject.getID_TRAMITEINTERNO() != 0) {
                    if (first) { first = false; }
                    sql.append("AND ID_TRAMITEINTERNO= ").append(valueObject.getID_TRAMITEINTERNO()).append(" ");
            }

            if (valueObject.getCATEGORIA() != null && !valueObject.getCATEGORIA().equals("") && !valueObject.getCATEGORIA().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND CATEGORIA= '").append(valueObject.getCATEGORIA()).append("' ");
            }

            if (valueObject.getCODESCUELA() != 0) {
                    if (first) { first = false; }
                    sql.append("AND CODESCUELA= ").append(valueObject.getCODESCUELA()).append(" ");
            }

            if (valueObject.getID_CIUDADPERSONA() != 0) {
                    if (first) { first = false; }
                    sql.append("AND ID_CIUDADPERSONA= ").append(valueObject.getID_CIUDADPERSONA()).append(" ");
            }

            if (valueObject.getNROCERTIFICADOESCUELA() != null && !valueObject.getNROCERTIFICADOESCUELA().equals("") && !valueObject.getNROCERTIFICADOESCUELA().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND NROCERTIFICADOESCUELA= '").append(valueObject.getNROCERTIFICADOESCUELA()).append("' ");
            }

            if (valueObject.getCODESPECIEVENAL() != 0) {
                    if (first) { first = false; }
                    sql.append("AND CODESPECIEVENAL= ").append(valueObject.getCODESPECIEVENAL()).append(" ");
            }

            if (valueObject.getNROLICENCIAANTERIOR() != null && !valueObject.getNROLICENCIAANTERIOR().equals("") && !valueObject.getNROLICENCIAANTERIOR().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND NROLICENCIAANTERIOR= '").append(valueObject.getNROLICENCIAANTERIOR()).append("' ");
            }

            if (valueObject.getNROCERTIFICADOMEDICO() != null && !valueObject.getNROCERTIFICADOMEDICO().equals("") && !valueObject.getNROCERTIFICADOMEDICO().equals("")) {
                    if (first) { first = false; }
                    sql.append("AND NROCERTIFICADOMEDICO= '").append(valueObject.getNROCERTIFICADOMEDICO()).append("' ");
            }
            
            if (valueObject.getNROCONSIGNACION() != 0) {
                if (first) { first = false; }
                sql.append("AND NROCONSIGNACION= ").append(valueObject.getNROCONSIGNACION()).append(" ");
            }
            
            if (valueObject.getFECHAVENCIMIENTO() != null) {
                    if (first) { first = false; }
                java.sql.Date fecha = new java.sql.Date(valueObject.getFECHAVENCIMIENTO().getTime());
                    sql.append("AND FECHAVENCIMIENTO= '").append(Funciones.convFechaSQLS(fecha)).append("' ");
            }

            sql.append("ORDER BY ID_LICENCIA ASC ");
            System.out.println("ViewLicenciasConduccion: " + sql);

            if (first)
                    searchResults = new ArrayList();
            else
                    searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

            return searchResults;
    }




	protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {
		int result = stmt.executeUpdate();
		return result;
	}


	protected void singleQuery(Connection conn, PreparedStatement stmt, Viewlicenciaconduccion valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_LICENCIA(result.getString("ID_LICENCIA"));
				valueObject.setID_PERSONA(result.getInt("ID_PERSONA"));
				valueObject.setNUMEROLICENCIA(result.getString("NUMEROLICENCIA"));
				valueObject.setTIPOIDENTIFICACION(result.getString("TIPOIDENTIFICACION"));
				valueObject.setIDENTIFICACION(result.getString("IDENTIFICACION"));
				valueObject.setFECHATRAMITE(result.getDate("FECHATRAMITE"));
				valueObject.setID_TRAMITEINTERNO(result.getInt("ID_TRAMITEINTERNO"));
				valueObject.setCATEGORIA(result.getString("CATEGORIA"));
				valueObject.setCODESCUELA(result.getInt("CODESCUELA"));
				valueObject.setID_CIUDADPERSONA(result.getInt("ID_CIUDADPERSONA"));
				valueObject.setNROCERTIFICADOESCUELA(result.getString("NROCERTIFICADOESCUELA"));
				valueObject.setCODESPECIEVENAL(result.getDouble("CODESPECIEVENAL"));
				valueObject.setNROLICENCIAANTERIOR(result.getString("NROLICENCIAANTERIOR"));
				valueObject.setNROCERTIFICADOMEDICO(result.getString("NROCERTIFICADOMEDICO"));
                                valueObject.setNROCONSIGNACION(result.getDouble("NROCONSIGNACION"));
				valueObject.setFECHAVENCIMIENTO(result.getDate("FECHAVENCIMIENTO"));

			} else {
				throw new NotFoundException("ViewlicenciaconduccionObject Not Found!");
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
				while(result.next()){
					Viewlicenciaconduccion temp = createValueObject();

					temp.setID_LICENCIA(result.getString("ID_LICENCIA"));
					temp.setID_PERSONA(result.getInt("ID_PERSONA"));
					temp.setNUMEROLICENCIA(result.getString("NUMEROLICENCIA"));
					temp.setTIPOIDENTIFICACION(result.getString("TIPOIDENTIFICACION"));
					temp.setIDENTIFICACION(result.getString("IDENTIFICACION"));
					temp.setFECHATRAMITE(result.getDate("FECHATRAMITE"));
					temp.setID_TRAMITEINTERNO(result.getInt("ID_TRAMITEINTERNO"));
					temp.setCATEGORIA(result.getString("CATEGORIA"));
					temp.setCODESCUELA(result.getInt("CODESCUELA"));
					temp.setID_CIUDADPERSONA(result.getInt("ID_CIUDADPERSONA"));
					temp.setNROCERTIFICADOESCUELA(result.getString("NROCERTIFICADOESCUELA"));
					temp.setCODESPECIEVENAL(result.getDouble("CODESPECIEVENAL"));
					temp.setNROLICENCIAANTERIOR(result.getString("NROLICENCIAANTERIOR"));
					temp.setNROCERTIFICADOMEDICO(result.getString("NROCERTIFICADOMEDICO"));
                                        temp.setNROCONSIGNACION(result.getDouble("NROCONSIGNACION"));
					temp.setFECHAVENCIMIENTO(result.getDate("FECHAVENCIMIENTO"));
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
