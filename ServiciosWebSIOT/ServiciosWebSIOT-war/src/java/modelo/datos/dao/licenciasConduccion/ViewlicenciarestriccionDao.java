package modelo.datos.dao.licenciasConduccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.licenciasConduccion.Viewlicenciarestriccion;

import utilidades.Funciones;


public class ViewlicenciarestriccionDao {


	public Viewlicenciarestriccion createValueObject() {
		return new Viewlicenciarestriccion();
	}

	public Viewlicenciarestriccion getObject(Connection conn,String ID_LICENCIA) throws NotFoundException, SQLException {
		Viewlicenciarestriccion valueObject = createValueObject();
		valueObject.setID_LICENCIA(ID_LICENCIA);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Viewlicenciarestriccion valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM VIEW_LICENCIARESTRICCION WHERE (ID_LICENCIA = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, valueObject.getID_LICENCIA());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM VIEW_LICENCIARESTRICCION ORDER BY ID_LICENCIA ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Viewlicenciarestriccion valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO VIEW_LICENCIARESTRICCION ( ID_PERSONA, TIPOIDENTIFICACION, IDENTIFICACION,"+
			" NUMEROLICENCIA, ID_RESTRICCION, RESTRICCION,"+
			" CONSECUTIVOREGISTRO)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_PERSONA()))
					stmt.setInt(1, valueObject.getID_PERSONA());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getTIPOIDENTIFICACION(),2))
					stmt.setString(2, valueObject.getTIPOIDENTIFICACION());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getIDENTIFICACION(),20))
					stmt.setString(3, valueObject.getIDENTIFICACION());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNUMEROLICENCIA(),30))
					stmt.setString(4, valueObject.getNUMEROLICENCIA());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_RESTRICCION()))
					stmt.setInt(5, valueObject.getID_RESTRICCION());
				else
					stmt.setNull(5, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getRESTRICCION(),60))
					stmt.setString(6, valueObject.getRESTRICCION());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getCONSECUTIVOREGISTRO()))
					stmt.setInt(7, valueObject.getCONSECUTIVOREGISTRO());
				else
					stmt.setNull(7, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Viewlicenciarestriccion valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE VIEW_LICENCIARESTRICCION SET  ID_PERSONA = ?, TIPOIDENTIFICACION = ?, IDENTIFICACION = ?,"+
			" NUMEROLICENCIA = ?, ID_RESTRICCION = ?, RESTRICCION = ?,"+
			" CONSECUTIVOREGISTRO = ? WHERE (ID_LICENCIA= ?)";
			stmt = conn.prepareStatement(sql);
				if(!Funciones.EnteroesNulo(valueObject.getID_PERSONA()))
					stmt.setInt(1, valueObject.getID_PERSONA());
				else
					stmt.setNull(1, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getTIPOIDENTIFICACION(),2))
					stmt.setString(2, valueObject.getTIPOIDENTIFICACION());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getIDENTIFICACION(),20))
					stmt.setString(3, valueObject.getIDENTIFICACION());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNUMEROLICENCIA(),30))
					stmt.setString(4, valueObject.getNUMEROLICENCIA());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_RESTRICCION()))
					stmt.setInt(5, valueObject.getID_RESTRICCION());
				else
					stmt.setNull(5, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getRESTRICCION(),60))
					stmt.setString(6, valueObject.getRESTRICCION());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getCONSECUTIVOREGISTRO()))
					stmt.setInt(7, valueObject.getCONSECUTIVOREGISTRO());
				else
					stmt.setNull(7, Types.INTEGER);
				stmt.setString(8, valueObject.getID_LICENCIA());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Viewlicenciarestriccion valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM VIEW_LICENCIARESTRICCION WHERE (ID_LICENCIA = ? )";
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


	public List searchMatching(Connection conn, Viewlicenciarestriccion valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_LICENCIARESTRICCION WHERE 1=1 ");
		if (valueObject.getID_LICENCIA() != null && !valueObject.getID_LICENCIA().equals("") && !valueObject.getID_LICENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND ID_LICENCIA= '").append(valueObject.getID_LICENCIA()).append("' ");
		}

		if (valueObject.getID_PERSONA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_PERSONA= ").append(valueObject.getID_PERSONA()).append(" ");
		}

		if (valueObject.getTIPOIDENTIFICACION() != null && !valueObject.getTIPOIDENTIFICACION().equals("") && !valueObject.getTIPOIDENTIFICACION().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPOIDENTIFICACION= '").append(valueObject.getTIPOIDENTIFICACION()).append("' ");
		}

		if (valueObject.getIDENTIFICACION() != null && !valueObject.getIDENTIFICACION().equals("") && !valueObject.getIDENTIFICACION().equals("")) {
			if (first) { first = false; }
			sql.append("AND IDENTIFICACION= '").append(valueObject.getIDENTIFICACION()).append("' ");
		}

		if (valueObject.getNUMEROLICENCIA() != null && !valueObject.getNUMEROLICENCIA().equals("") && !valueObject.getNUMEROLICENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUMEROLICENCIA= '").append(valueObject.getNUMEROLICENCIA()).append("' ");
		}

		if (valueObject.getID_RESTRICCION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_RESTRICCION= ").append(valueObject.getID_RESTRICCION()).append(" ");
		}

		if (valueObject.getRESTRICCION() != null && !valueObject.getRESTRICCION().equals("") && !valueObject.getRESTRICCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND RESTRICCION= '").append(valueObject.getRESTRICCION()).append("' ");
		}

		if (valueObject.getCONSECUTIVOREGISTRO() != 0) {
			if (first) { first = false; }
			sql.append("AND CONSECUTIVOREGISTRO= ").append(valueObject.getCONSECUTIVOREGISTRO()).append(" ");
		}

		sql.append("ORDER BY ID_LICENCIA ASC ");

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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Viewlicenciarestriccion valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_LICENCIA(result.getString("ID_LICENCIA"));
				valueObject.setID_PERSONA(result.getInt("ID_PERSONA"));
				valueObject.setTIPOIDENTIFICACION(result.getString("TIPOIDENTIFICACION"));
				valueObject.setIDENTIFICACION(result.getString("IDENTIFICACION"));
				valueObject.setNUMEROLICENCIA(result.getString("NUMEROLICENCIA"));
				valueObject.setID_RESTRICCION(result.getInt("ID_RESTRICCION"));
				valueObject.setRESTRICCION(result.getString("RESTRICCION"));
				valueObject.setCONSECUTIVOREGISTRO(result.getInt("CONSECUTIVOREGISTRO"));

			} else {
				throw new NotFoundException("ViewlicenciarestriccionObject Not Found!");
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
					Viewlicenciarestriccion temp = createValueObject();

					temp.setID_LICENCIA(result.getString("ID_LICENCIA"));
					temp.setID_PERSONA(result.getInt("ID_PERSONA"));
					temp.setTIPOIDENTIFICACION(result.getString("TIPOIDENTIFICACION"));
					temp.setIDENTIFICACION(result.getString("IDENTIFICACION"));
					temp.setNUMEROLICENCIA(result.getString("NUMEROLICENCIA"));
					temp.setID_RESTRICCION(result.getInt("ID_RESTRICCION"));
					temp.setRESTRICCION(result.getString("RESTRICCION"));
					temp.setCONSECUTIVOREGISTRO(result.getInt("CONSECUTIVOREGISTRO"));
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
