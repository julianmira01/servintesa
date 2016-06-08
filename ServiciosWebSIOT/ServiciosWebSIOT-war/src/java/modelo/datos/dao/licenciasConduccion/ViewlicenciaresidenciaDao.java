package modelo.datos.dao.licenciasConduccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.licenciasConduccion.Viewlicenciaresidencia;

import utilidades.Funciones;


public class ViewlicenciaresidenciaDao {


	public Viewlicenciaresidencia createValueObject() {
		return new Viewlicenciaresidencia();
	}

	public Viewlicenciaresidencia getObject(Connection conn,String ID_LICENCIA) throws NotFoundException, SQLException {
		Viewlicenciaresidencia valueObject = createValueObject();
		valueObject.setID_LICENCIA(ID_LICENCIA);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Viewlicenciaresidencia valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM VIEW_LICENCIARESIDENCIA WHERE (ID_LICENCIA = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, valueObject.getID_LICENCIA());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM VIEW_LICENCIARESIDENCIA ORDER BY ID_LICENCIA ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Viewlicenciaresidencia valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO VIEW_LICENCIARESIDENCIA ( ID_PERSONA, TIPOIDENTIFICACION, IDENTIFICACION,"+
			" ID_SUCURSAL, ID_CIUDAD, FECHARESIDENCIA,"+
			" TELEFONO, FAX)"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
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
				if(!Funciones.EnteroesNulo(valueObject.getID_SUCURSAL()))
					stmt.setInt(4, valueObject.getID_SUCURSAL());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_CIUDAD()))
					stmt.setInt(5, valueObject.getID_CIUDAD());
				else
					stmt.setNull(5, Types.INTEGER);
				if(valueObject.getFECHARESIDENCIA() != null && Funciones.esFecha(valueObject.getFECHARESIDENCIA().toString()))
					stmt.setDate(6, new java.sql.Date(java.sql.Date.parse(valueObject.getFECHARESIDENCIA().toString())));
				else
					stmt.setNull(6, Types.DATE);
				if(Funciones.contarCadena(valueObject.getTELEFONO(),10))
					stmt.setString(7, valueObject.getTELEFONO());
				else
					stmt.setNull(7, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFAX(),10))
					stmt.setString(8, valueObject.getFAX());
				else
					stmt.setNull(8, Types.VARCHAR);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Viewlicenciaresidencia valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE VIEW_LICENCIARESIDENCIA SET  ID_PERSONA = ?, TIPOIDENTIFICACION = ?, IDENTIFICACION = ?,"+
			" ID_SUCURSAL = ?, ID_CIUDAD = ?, FECHARESIDENCIA = ?,"+
			" TELEFONO = ?, FAX = ? WHERE (ID_LICENCIA= ?)";
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
				if(!Funciones.EnteroesNulo(valueObject.getID_SUCURSAL()))
					stmt.setInt(4, valueObject.getID_SUCURSAL());
				else
					stmt.setNull(4, Types.INTEGER);
				if(!Funciones.EnteroesNulo(valueObject.getID_CIUDAD()))
					stmt.setInt(5, valueObject.getID_CIUDAD());
				else
					stmt.setNull(5, Types.INTEGER);
				if(valueObject.getFECHARESIDENCIA() != null && Funciones.esFecha(valueObject.getFECHARESIDENCIA().toString()))
					stmt.setDate(6, new java.sql.Date(java.sql.Date.parse(valueObject.getFECHARESIDENCIA().toString())));
				else
					stmt.setNull(6, Types.DATE);
				if(Funciones.contarCadena(valueObject.getTELEFONO(),10))
					stmt.setString(7, valueObject.getTELEFONO());
				else
					stmt.setNull(7, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFAX(),10))
					stmt.setString(8, valueObject.getFAX());
				else
					stmt.setNull(8, Types.VARCHAR);
				stmt.setString(9, valueObject.getID_LICENCIA());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Viewlicenciaresidencia valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM VIEW_LICENCIARESIDENCIA WHERE (ID_LICENCIA = ? )";
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


	public List searchMatching(Connection conn, Viewlicenciaresidencia valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_LICENCIARESIDENCIA WHERE 1=1 ");
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

		if (valueObject.getID_SUCURSAL() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_SUCURSAL= ").append(valueObject.getID_SUCURSAL()).append(" ");
		}

		if (valueObject.getID_CIUDAD() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CIUDAD= ").append(valueObject.getID_CIUDAD()).append(" ");
		}

		if (valueObject.getFECHARESIDENCIA() != null) {
			if (first) { first = false; }
			sql.append("AND FECHARESIDENCIA= '").append(valueObject.getFECHARESIDENCIA()).append("' ");
		}

		if (valueObject.getTELEFONO() != null && !valueObject.getTELEFONO().equals("") && !valueObject.getTELEFONO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TELEFONO= '").append(valueObject.getTELEFONO()).append("' ");
		}

		if (valueObject.getFAX() != null && !valueObject.getFAX().equals("") && !valueObject.getFAX().equals("")) {
			if (first) { first = false; }
			sql.append("AND FAX= '").append(valueObject.getFAX()).append("' ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Viewlicenciaresidencia valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_LICENCIA(result.getString("ID_LICENCIA"));
				valueObject.setID_PERSONA(result.getInt("ID_PERSONA"));
				valueObject.setTIPOIDENTIFICACION(result.getString("TIPOIDENTIFICACION"));
				valueObject.setIDENTIFICACION(result.getString("IDENTIFICACION"));
				valueObject.setID_SUCURSAL(result.getInt("ID_SUCURSAL"));
				valueObject.setID_CIUDAD(result.getInt("ID_CIUDAD"));
				valueObject.setFECHARESIDENCIA(result.getDate("FECHARESIDENCIA"));
				valueObject.setTELEFONO(result.getString("TELEFONO"));
				valueObject.setFAX(result.getString("FAX"));

			} else {
				throw new NotFoundException("ViewlicenciaresidenciaObject Not Found!");
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
					Viewlicenciaresidencia temp = createValueObject();

					temp.setID_LICENCIA(result.getString("ID_LICENCIA"));
					temp.setID_PERSONA(result.getInt("ID_PERSONA"));
					temp.setTIPOIDENTIFICACION(result.getString("TIPOIDENTIFICACION"));
					temp.setIDENTIFICACION(result.getString("IDENTIFICACION"));
					temp.setID_SUCURSAL(result.getInt("ID_SUCURSAL"));
					temp.setID_CIUDAD(result.getInt("ID_CIUDAD"));
					temp.setFECHARESIDENCIA(result.getDate("FECHARESIDENCIA"));
					temp.setTELEFONO(result.getString("TELEFONO"));
					temp.setFAX(result.getString("FAX"));
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
