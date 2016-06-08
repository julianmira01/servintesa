package modelo.datos.dao.Migraciontmp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.Migraciontmp.Migraciontmp;

import utilidades.Funciones;



public class MigraciontmpDao {


	public Migraciontmp createValueObject() {
		return new Migraciontmp();
	}

	public Migraciontmp getObject(Connection conn,int ID_MIGRACION) throws NotFoundException, SQLException {
		Migraciontmp valueObject = createValueObject();
		valueObject.setID_MIGRACION(ID_MIGRACION);
		load(conn, valueObject);
		return valueObject;
	}

	public void load(Connection conn, Migraciontmp valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM MIGRACION_TMP WHERE (ID_MIGRACION = ? )";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_MIGRACION());
			singleQuery(conn, stmt, valueObject);
		} finally {

		}
	}


	public List loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM MIGRACION_TMP ORDER BY ID_MIGRACION ASC ";
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_MIGRACION) AS RowNumber FROM MIGRACION_TMP) AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup;
		List searchResults = listQuery(conn, conn.prepareStatement(sql));
		return searchResults;
	}


	public synchronized void create(Connection conn, Migraciontmp valueObject) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			sql = "INSERT INTO MIGRACION_TMP ( ID_MIGRACION,"+
			" PLACA, FECHA_MATRICULA, ID_SERVICIO,"+
			" SERVICIO, ID_CLASEVEHICULO, CLASE_VEHICULO,"+
			" ID_CARROCERIA, CARROCERIA, MODELO,"+
			" CILINDRAJE, ID_COLOR, COLOR,"+
			" ID_MARCA, MARCA, ID_LINEA,"+
			" LINEA, MOTOR, CHASIS,"+
			" SERIE, VIN, ANTIGUO_CLASICO,"+
			" POTENCIA, PUERTAS, PASAJEROS,"+
			" CARGA, TIPO_COMBUSTIBLE, PESO,"+
			" DISTANCIA_EJES, NRO_EJES, FECHA_LICENCIA,"+
			" LIC_TRANSITO, NIT_IMPORTADOR, TIPO_DOCUMENTO,"+
			" DOCUMENTO, NOMBRE_PROPIETARIO, DIRECCION,"+
			" TELEFONO, EMPRESA, FECHA_INICIO_PROP,"+
			" ESTADO_PROPIEDAD, FECHA_FIN_PROP, PORCENTAJE_PROPIEDAD,"+
			" NUM_ACTMANIF, FECHA_MANIFIESTO, TIPO_PROPIEDAD"+
			")"+
			 "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_MIGRACION());
				if(Funciones.contarCadena(valueObject.getPLACA(),8))
					stmt.setString(2, valueObject.getPLACA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_MATRICULA(),12))
					stmt.setString(3, valueObject.getFECHA_MATRICULA());
				else
					stmt.setNull(3, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_SERVICIO()))
					stmt.setInt(4, valueObject.getID_SERVICIO());
				else
					stmt.setNull(4, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getSERVICIO(),20))
					stmt.setString(5, valueObject.getSERVICIO());
				else
					stmt.setNull(5, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_CLASEVEHICULO()))
					stmt.setInt(6, valueObject.getID_CLASEVEHICULO());
				else
					stmt.setNull(6, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCLASE_VEHICULO(),20))
					stmt.setString(7, valueObject.getCLASE_VEHICULO());
				else
					stmt.setNull(7, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_CARROCERIA()))
					stmt.setInt(8, valueObject.getID_CARROCERIA());
				else
					stmt.setNull(8, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCARROCERIA(),20))
					stmt.setString(9, valueObject.getCARROCERIA());
				else
					stmt.setNull(9, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getMODELO()))
					stmt.setInt(10, valueObject.getMODELO());
				else
					stmt.setNull(10, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCILINDRAJE(),10))
					stmt.setString(11, valueObject.getCILINDRAJE());
				else
					stmt.setNull(11, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_COLOR()))
					stmt.setInt(12, valueObject.getID_COLOR());
				else
					stmt.setNull(12, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCOLOR(),30))
					stmt.setString(13, valueObject.getCOLOR());
				else
					stmt.setNull(13, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_MARCA()))
					stmt.setInt(14, valueObject.getID_MARCA());
				else
					stmt.setNull(14, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getMARCA(),25))
					stmt.setString(15, valueObject.getMARCA());
				else
					stmt.setNull(15, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_LINEA()))
					stmt.setInt(16, valueObject.getID_LINEA());
				else
					stmt.setNull(16, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getLINEA(),50))
					stmt.setString(17, valueObject.getLINEA());
				else
					stmt.setNull(17, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getMOTOR(),25))
					stmt.setString(18, valueObject.getMOTOR());
				else
					stmt.setNull(18, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCHASIS(),40))
					stmt.setString(19, valueObject.getCHASIS());
				else
					stmt.setNull(19, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getSERIE(),25))
					stmt.setString(20, valueObject.getSERIE());
				else
					stmt.setNull(20, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getVIN(),100))
					stmt.setString(21, valueObject.getVIN());
				else
					stmt.setNull(21, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getANTIGUO_CLASICO(),20))
					stmt.setString(22, valueObject.getANTIGUO_CLASICO());
				else
					stmt.setNull(22, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getPOTENCIA(),10))
					stmt.setString(23, valueObject.getPOTENCIA());
				else
					stmt.setNull(23, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getPUERTAS()))
					stmt.setInt(24, valueObject.getPUERTAS());
				else
					stmt.setNull(24, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getPASAJEROS(),10))
					stmt.setString(25, valueObject.getPASAJEROS());
				else
					stmt.setNull(25, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCARGA(),10))
					stmt.setString(26, valueObject.getCARGA());
				else
					stmt.setNull(26, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getTIPO_COMBUSTIBLE()))
					stmt.setInt(27, valueObject.getTIPO_COMBUSTIBLE());
				else
					stmt.setNull(27, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getPESO(),5))
					stmt.setString(28, valueObject.getPESO());
				else
					stmt.setNull(28, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDISTANCIA_EJES(),10))
					stmt.setString(29, valueObject.getDISTANCIA_EJES());
				else
					stmt.setNull(29, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getNRO_EJES()))
					stmt.setInt(30, valueObject.getNRO_EJES());
				else
					stmt.setNull(30, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getFECHA_LICENCIA(),12))
					stmt.setString(31, valueObject.getFECHA_LICENCIA());
				else
					stmt.setNull(31, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getLIC_TRANSITO(),12))
					stmt.setString(32, valueObject.getLIC_TRANSITO());
				else
					stmt.setNull(32, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNIT_IMPORTADOR(),40))
					stmt.setString(33, valueObject.getNIT_IMPORTADOR());
				else
					stmt.setNull(33, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTIPO_DOCUMENTO(),2))
					stmt.setString(34, valueObject.getTIPO_DOCUMENTO());
				else
					stmt.setNull(34, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDOCUMENTO(),20))
					stmt.setString(35, valueObject.getDOCUMENTO());
				else
					stmt.setNull(35, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBRE_PROPIETARIO(),80))
					stmt.setString(36, valueObject.getNOMBRE_PROPIETARIO());
				else
					stmt.setNull(36, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDIRECCION(),100))
					stmt.setString(37, valueObject.getDIRECCION());
				else
					stmt.setNull(37, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTELEFONO(),15))
					stmt.setString(38, valueObject.getTELEFONO());
				else
					stmt.setNull(38, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getEMPRESA(),100))
					stmt.setString(39, valueObject.getEMPRESA());
				else
					stmt.setNull(39, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_INICIO_PROP(),12))
					stmt.setString(40, valueObject.getFECHA_INICIO_PROP());
				else
					stmt.setNull(40, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getESTADO_PROPIEDAD(),10))
					stmt.setString(41, valueObject.getESTADO_PROPIEDAD());
				else
					stmt.setNull(41, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_FIN_PROP(),12))
					stmt.setString(42, valueObject.getFECHA_FIN_PROP());
				else
					stmt.setNull(42, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getPORCENTAJE_PROPIEDAD()))
					stmt.setInt(43, valueObject.getPORCENTAJE_PROPIEDAD());
				else
					stmt.setNull(43, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNUM_ACTMANIF(),30))
					stmt.setString(44, valueObject.getNUM_ACTMANIF());
				else
					stmt.setNull(44, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_MANIFIESTO(),12))
					stmt.setString(45, valueObject.getFECHA_MANIFIESTO());
				else
					stmt.setNull(45, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getTIPO_PROPIEDAD()))
					stmt.setInt(46, valueObject.getTIPO_PROPIEDAD());
				else
					stmt.setNull(46, Types.INTEGER);



				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount != 1) {
					throw new SQLException("PrimaryKey Error when updating DB!");
				}
			} finally {
				if (stmt != null)
					stmt.close();
			}
	}


	public void save(Connection conn, Migraciontmp valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "UPDATE MIGRACION_TMP SET  PLACA = ?, FECHA_MATRICULA = ?, ID_SERVICIO = ?,"+
			" SERVICIO = ?, ID_CLASEVEHICULO = ?, CLASE_VEHICULO = ?,"+
			" ID_CARROCERIA = ?, CARROCERIA = ?, MODELO = ?,"+
			" CILINDRAJE = ?, ID_COLOR = ?, COLOR = ?,"+
			" ID_MARCA = ?, MARCA = ?, ID_LINEA = ?,"+
			" LINEA = ?, MOTOR = ?, CHASIS = ?,"+
			" SERIE = ?, VIN = ?, ANTIGUO_CLASICO = ?,"+
			" POTENCIA = ?, PUERTAS = ?, PASAJEROS = ?,"+
			" CARGA = ?, TIPO_COMBUSTIBLE = ?, PESO = ?,"+
			" DISTANCIA_EJES = ?, NRO_EJES = ?, FECHA_LICENCIA = ?,"+
			" LIC_TRANSITO = ?, NIT_IMPORTADOR = ?, TIPO_DOCUMENTO = ?,"+
			" DOCUMENTO = ?, NOMBRE_PROPIETARIO = ?, DIRECCION = ?,"+
			" TELEFONO = ?, EMPRESA = ?, FECHA_INICIO_PROP = ?,"+
			" ESTADO_PROPIEDAD = ?, FECHA_FIN_PROP = ?, PORCENTAJE_PROPIEDAD = ?,"+
			" NUM_ACTMANIF = ?, FECHA_MANIFIESTO = ?, TIPO_PROPIEDAD = ?"+
			" WHERE (ID_MIGRACION= ?)";
			stmt = conn.prepareStatement(sql);
				if(Funciones.contarCadena(valueObject.getPLACA(),8))
					stmt.setString(1, valueObject.getPLACA());
				else
					stmt.setNull(1, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_MATRICULA(),12))
					stmt.setString(2, valueObject.getFECHA_MATRICULA());
				else
					stmt.setNull(2, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_SERVICIO()))
					stmt.setInt(3, valueObject.getID_SERVICIO());
				else
					stmt.setNull(3, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getSERVICIO(),20))
					stmt.setString(4, valueObject.getSERVICIO());
				else
					stmt.setNull(4, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_CLASEVEHICULO()))
					stmt.setInt(5, valueObject.getID_CLASEVEHICULO());
				else
					stmt.setNull(5, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCLASE_VEHICULO(),20))
					stmt.setString(6, valueObject.getCLASE_VEHICULO());
				else
					stmt.setNull(6, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_CARROCERIA()))
					stmt.setInt(7, valueObject.getID_CARROCERIA());
				else
					stmt.setNull(7, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCARROCERIA(),20))
					stmt.setString(8, valueObject.getCARROCERIA());
				else
					stmt.setNull(8, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getMODELO()))
					stmt.setInt(9, valueObject.getMODELO());
				else
					stmt.setNull(9, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCILINDRAJE(),10))
					stmt.setString(10, valueObject.getCILINDRAJE());
				else
					stmt.setNull(10, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_COLOR()))
					stmt.setInt(11, valueObject.getID_COLOR());
				else
					stmt.setNull(11, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getCOLOR(),30))
					stmt.setString(12, valueObject.getCOLOR());
				else
					stmt.setNull(12, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_MARCA()))
					stmt.setInt(13, valueObject.getID_MARCA());
				else
					stmt.setNull(13, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getMARCA(),25))
					stmt.setString(14, valueObject.getMARCA());
				else
					stmt.setNull(14, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getID_LINEA()))
					stmt.setInt(15, valueObject.getID_LINEA());
				else
					stmt.setNull(15, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getLINEA(),50))
					stmt.setString(16, valueObject.getLINEA());
				else
					stmt.setNull(16, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getMOTOR(),25))
					stmt.setString(17, valueObject.getMOTOR());
				else
					stmt.setNull(17, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCHASIS(),40))
					stmt.setString(18, valueObject.getCHASIS());
				else
					stmt.setNull(18, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getSERIE(),25))
					stmt.setString(19, valueObject.getSERIE());
				else
					stmt.setNull(19, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getVIN(),100))
					stmt.setString(20, valueObject.getVIN());
				else
					stmt.setNull(20, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getANTIGUO_CLASICO(),20))
					stmt.setString(21, valueObject.getANTIGUO_CLASICO());
				else
					stmt.setNull(21, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getPOTENCIA(),10))
					stmt.setString(22, valueObject.getPOTENCIA());
				else
					stmt.setNull(22, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getPUERTAS()))
					stmt.setInt(23, valueObject.getPUERTAS());
				else
					stmt.setNull(23, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getPASAJEROS(),10))
					stmt.setString(24, valueObject.getPASAJEROS());
				else
					stmt.setNull(24, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getCARGA(),10))
					stmt.setString(25, valueObject.getCARGA());
				else
					stmt.setNull(25, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getTIPO_COMBUSTIBLE()))
					stmt.setInt(26, valueObject.getTIPO_COMBUSTIBLE());
				else
					stmt.setNull(26, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getPESO(),5))
					stmt.setString(27, valueObject.getPESO());
				else
					stmt.setNull(27, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDISTANCIA_EJES(),10))
					stmt.setString(28, valueObject.getDISTANCIA_EJES());
				else
					stmt.setNull(28, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getNRO_EJES()))
					stmt.setInt(29, valueObject.getNRO_EJES());
				else
					stmt.setNull(29, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getFECHA_LICENCIA(),12))
					stmt.setString(30, valueObject.getFECHA_LICENCIA());
				else
					stmt.setNull(30, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getLIC_TRANSITO(),12))
					stmt.setString(31, valueObject.getLIC_TRANSITO());
				else
					stmt.setNull(31, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNIT_IMPORTADOR(),40))
					stmt.setString(32, valueObject.getNIT_IMPORTADOR());
				else
					stmt.setNull(32, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTIPO_DOCUMENTO(),2))
					stmt.setString(33, valueObject.getTIPO_DOCUMENTO());
				else
					stmt.setNull(33, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDOCUMENTO(),20))
					stmt.setString(34, valueObject.getDOCUMENTO());
				else
					stmt.setNull(34, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getNOMBRE_PROPIETARIO(),80))
					stmt.setString(35, valueObject.getNOMBRE_PROPIETARIO());
				else
					stmt.setNull(35, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getDIRECCION(),100))
					stmt.setString(36, valueObject.getDIRECCION());
				else
					stmt.setNull(36, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getTELEFONO(),15))
					stmt.setString(37, valueObject.getTELEFONO());
				else
					stmt.setNull(37, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getEMPRESA(),100))
					stmt.setString(38, valueObject.getEMPRESA());
				else
					stmt.setNull(38, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_INICIO_PROP(),12))
					stmt.setString(39, valueObject.getFECHA_INICIO_PROP());
				else
					stmt.setNull(39, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getESTADO_PROPIEDAD(),10))
					stmt.setString(40, valueObject.getESTADO_PROPIEDAD());
				else
					stmt.setNull(40, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_FIN_PROP(),12))
					stmt.setString(41, valueObject.getFECHA_FIN_PROP());
				else
					stmt.setNull(41, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getPORCENTAJE_PROPIEDAD()))
					stmt.setInt(42, valueObject.getPORCENTAJE_PROPIEDAD());
				else
					stmt.setNull(42, Types.INTEGER);
				if(Funciones.contarCadena(valueObject.getNUM_ACTMANIF(),30))
					stmt.setString(43, valueObject.getNUM_ACTMANIF());
				else
					stmt.setNull(43, Types.VARCHAR);
				if(Funciones.contarCadena(valueObject.getFECHA_MANIFIESTO(),12))
					stmt.setString(44, valueObject.getFECHA_MANIFIESTO());
				else
					stmt.setNull(44, Types.VARCHAR);
				if(!Funciones.EnteroesNulo(valueObject.getTIPO_PROPIEDAD()))
					stmt.setInt(45, valueObject.getTIPO_PROPIEDAD());
				else
					stmt.setNull(45, Types.INTEGER);
				stmt.setInt(46, valueObject.getID_MIGRACION());

				int rowcount = databaseUpdate(conn, stmt);
				if (rowcount == 0) {
					throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
				}
			} finally {
				if (stmt != null)
					stmt.close();
		}
	}


	public void delete(Connection conn, Migraciontmp valueObject) throws NotFoundException, SQLException {
		PreparedStatement stmt = null;
		String sql = "";
		try {
			sql = "DELETE FROM MIGRACION_TMP WHERE (ID_MIGRACION = ? )";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getID_MIGRACION());

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
		String sql = "SELECT count(*) FROM MIGRACION_TMP";
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
	public List searchMatching(Connection conn, Migraciontmp valueObject) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM MIGRACION_TMP WHERE 1=1 ");
		if (valueObject.getID_MIGRACION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_MIGRACION= ").append(valueObject.getID_MIGRACION()).append(" ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getFECHA_MATRICULA() != null&&!valueObject.getFECHA_MATRICULA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_MATRICULA= '").append(valueObject.getFECHA_MATRICULA()).append("' ");
		}

		if (valueObject.getID_SERVICIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_SERVICIO= ").append(valueObject.getID_SERVICIO()).append(" ");
		}

		if (valueObject.getSERVICIO() != null&&!valueObject.getSERVICIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND SERVICIO= '").append(valueObject.getSERVICIO()).append("' ");
		}

		if (valueObject.getID_CLASEVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CLASEVEHICULO= ").append(valueObject.getID_CLASEVEHICULO()).append(" ");
		}

		if (valueObject.getCLASE_VEHICULO() != null&&!valueObject.getCLASE_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND CLASE_VEHICULO= '").append(valueObject.getCLASE_VEHICULO()).append("' ");
		}

		if (valueObject.getID_CARROCERIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CARROCERIA= ").append(valueObject.getID_CARROCERIA()).append(" ");
		}

		if (valueObject.getCARROCERIA() != null&&!valueObject.getCARROCERIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CARROCERIA= '").append(valueObject.getCARROCERIA()).append("' ");
		}

		if (valueObject.getMODELO() != 0) {
			if (first) { first = false; }
			sql.append("AND MODELO= ").append(valueObject.getMODELO()).append(" ");
		}

		if (valueObject.getCILINDRAJE() != null&&!valueObject.getCILINDRAJE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CILINDRAJE= '").append(valueObject.getCILINDRAJE()).append("' ");
		}

		if (valueObject.getID_COLOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COLOR= ").append(valueObject.getID_COLOR()).append(" ");
		}

		if (valueObject.getCOLOR() != null&&!valueObject.getCOLOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND COLOR= '").append(valueObject.getCOLOR()).append("' ");
		}

		if (valueObject.getID_MARCA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_MARCA= ").append(valueObject.getID_MARCA()).append(" ");
		}

		if (valueObject.getMARCA() != null&&!valueObject.getMARCA().equals("")) {
			if (first) { first = false; }
			sql.append("AND MARCA= '").append(valueObject.getMARCA()).append("' ");
		}

		if (valueObject.getID_LINEA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_LINEA= ").append(valueObject.getID_LINEA()).append(" ");
		}

		if (valueObject.getLINEA() != null&&!valueObject.getLINEA().equals("")) {
			if (first) { first = false; }
			sql.append("AND LINEA= '").append(valueObject.getLINEA()).append("' ");
		}

		if (valueObject.getMOTOR() != null&&!valueObject.getMOTOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND MOTOR= '").append(valueObject.getMOTOR()).append("' ");
		}

		if (valueObject.getCHASIS() != null&&!valueObject.getCHASIS().equals("")) {
			if (first) { first = false; }
			sql.append("AND CHASIS= '").append(valueObject.getCHASIS()).append("' ");
		}

		if (valueObject.getSERIE() != null&&!valueObject.getSERIE().equals("")) {
			if (first) { first = false; }
			sql.append("AND SERIE= '").append(valueObject.getSERIE()).append("' ");
		}

		if (valueObject.getVIN() != null&&!valueObject.getVIN().equals("")) {
			if (first) { first = false; }
			sql.append("AND VIN= '").append(valueObject.getVIN()).append("' ");
		}

		if (valueObject.getANTIGUO_CLASICO() != null&&!valueObject.getANTIGUO_CLASICO().equals("")) {
			if (first) { first = false; }
			sql.append("AND ANTIGUO_CLASICO= '").append(valueObject.getANTIGUO_CLASICO()).append("' ");
		}

		if (valueObject.getPOTENCIA() != null&&!valueObject.getPOTENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND POTENCIA= '").append(valueObject.getPOTENCIA()).append("' ");
		}

		if (valueObject.getPUERTAS() != 0) {
			if (first) { first = false; }
			sql.append("AND PUERTAS= ").append(valueObject.getPUERTAS()).append(" ");
		}

		if (valueObject.getPASAJEROS() != null&&!valueObject.getPASAJEROS().equals("")) {
			if (first) { first = false; }
			sql.append("AND PASAJEROS= '").append(valueObject.getPASAJEROS()).append("' ");
		}

		if (valueObject.getCARGA() != null&&!valueObject.getCARGA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CARGA= '").append(valueObject.getCARGA()).append("' ");
		}

		if (valueObject.getTIPO_COMBUSTIBLE() != 0) {
			if (first) { first = false; }
			sql.append("AND TIPO_COMBUSTIBLE= ").append(valueObject.getTIPO_COMBUSTIBLE()).append(" ");
		}

		if (valueObject.getPESO() != null&&!valueObject.getPESO().equals("")) {
			if (first) { first = false; }
			sql.append("AND PESO= '").append(valueObject.getPESO()).append("' ");
		}

		if (valueObject.getDISTANCIA_EJES() != null&&!valueObject.getDISTANCIA_EJES().equals("")) {
			if (first) { first = false; }
			sql.append("AND DISTANCIA_EJES= '").append(valueObject.getDISTANCIA_EJES()).append("' ");
		}

		if (valueObject.getNRO_EJES() != 0) {
			if (first) { first = false; }
			sql.append("AND NRO_EJES= ").append(valueObject.getNRO_EJES()).append(" ");
		}

		if (valueObject.getFECHA_LICENCIA() != null&&!valueObject.getFECHA_LICENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_LICENCIA= '").append(valueObject.getFECHA_LICENCIA()).append("' ");
		}

		if (valueObject.getLIC_TRANSITO() != null&&!valueObject.getLIC_TRANSITO().equals("")) {
			if (first) { first = false; }
			sql.append("AND LIC_TRANSITO= '").append(valueObject.getLIC_TRANSITO()).append("' ");
		}

		if (valueObject.getNIT_IMPORTADOR() != null&&!valueObject.getNIT_IMPORTADOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND NIT_IMPORTADOR= '").append(valueObject.getNIT_IMPORTADOR()).append("' ");
		}

		if (valueObject.getTIPO_DOCUMENTO() != null&&!valueObject.getTIPO_DOCUMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPO_DOCUMENTO= '").append(valueObject.getTIPO_DOCUMENTO()).append("' ");
		}

		if (valueObject.getDOCUMENTO() != null&&!valueObject.getDOCUMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND DOCUMENTO= '").append(valueObject.getDOCUMENTO()).append("' ");
		}

		if (valueObject.getNOMBRE_PROPIETARIO() != null&&!valueObject.getNOMBRE_PROPIETARIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE_PROPIETARIO= '").append(valueObject.getNOMBRE_PROPIETARIO()).append("' ");
		}

		if (valueObject.getDIRECCION() != null&&!valueObject.getDIRECCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DIRECCION= '").append(valueObject.getDIRECCION()).append("' ");
		}

		if (valueObject.getTELEFONO() != null&&!valueObject.getTELEFONO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TELEFONO= '").append(valueObject.getTELEFONO()).append("' ");
		}

		if (valueObject.getEMPRESA() != null&&!valueObject.getEMPRESA().equals("")) {
			if (first) { first = false; }
			sql.append("AND EMPRESA= '").append(valueObject.getEMPRESA()).append("' ");
		}

		if (valueObject.getFECHA_INICIO_PROP() != null&&!valueObject.getFECHA_INICIO_PROP().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_INICIO_PROP= '").append(valueObject.getFECHA_INICIO_PROP()).append("' ");
		}

		if (valueObject.getESTADO_PROPIEDAD() != null&&!valueObject.getESTADO_PROPIEDAD().equals("")) {
			if (first) { first = false; }
			sql.append("AND ESTADO_PROPIEDAD= '").append(valueObject.getESTADO_PROPIEDAD()).append("' ");
		}

		if (valueObject.getFECHA_FIN_PROP() != null&&!valueObject.getFECHA_FIN_PROP().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_FIN_PROP= '").append(valueObject.getFECHA_FIN_PROP()).append("' ");
		}

		if (valueObject.getPORCENTAJE_PROPIEDAD() != 0) {
			if (first) { first = false; }
			sql.append("AND PORCENTAJE_PROPIEDAD= ").append(valueObject.getPORCENTAJE_PROPIEDAD()).append(" ");
		}

		if (valueObject.getNUM_ACTMANIF() != null&&!valueObject.getNUM_ACTMANIF().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUM_ACTMANIF= '").append(valueObject.getNUM_ACTMANIF()).append("' ");
		}

		if (valueObject.getFECHA_MANIFIESTO() != null&&!valueObject.getFECHA_MANIFIESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_MANIFIESTO= '").append(valueObject.getFECHA_MANIFIESTO()).append("' ");
		}

		if (valueObject.getTIPO_PROPIEDAD() != 0) {
			if (first) { first = false; }
			sql.append("AND TIPO_PROPIEDAD= ").append(valueObject.getTIPO_PROPIEDAD()).append(" ");
		}

		sql.append("ORDER BY ID_MIGRACION ASC ");

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public List searchMatching(Connection conn, Migraciontmp valueObject, int limiteInf, int limiteSup) throws SQLException {
		List searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_MIGRACION) AS RowNumber FROM MIGRACION_TMP WHERE 1=1 ");
		if (valueObject.getID_MIGRACION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_MIGRACION= ").append(valueObject.getID_MIGRACION()).append(" ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getFECHA_MATRICULA() != null&&!valueObject.getFECHA_MATRICULA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_MATRICULA= '").append(valueObject.getFECHA_MATRICULA()).append("' ");
		}

		if (valueObject.getID_SERVICIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_SERVICIO= ").append(valueObject.getID_SERVICIO()).append(" ");
		}

		if (valueObject.getSERVICIO() != null&&!valueObject.getSERVICIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND SERVICIO= '").append(valueObject.getSERVICIO()).append("' ");
		}

		if (valueObject.getID_CLASEVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CLASEVEHICULO= ").append(valueObject.getID_CLASEVEHICULO()).append(" ");
		}

		if (valueObject.getCLASE_VEHICULO() != null&&!valueObject.getCLASE_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND CLASE_VEHICULO= '").append(valueObject.getCLASE_VEHICULO()).append("' ");
		}

		if (valueObject.getID_CARROCERIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CARROCERIA= ").append(valueObject.getID_CARROCERIA()).append(" ");
		}

		if (valueObject.getCARROCERIA() != null&&!valueObject.getCARROCERIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CARROCERIA= '").append(valueObject.getCARROCERIA()).append("' ");
		}

		if (valueObject.getMODELO() != 0) {
			if (first) { first = false; }
			sql.append("AND MODELO= ").append(valueObject.getMODELO()).append(" ");
		}

		if (valueObject.getCILINDRAJE() != null&&!valueObject.getCILINDRAJE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CILINDRAJE= '").append(valueObject.getCILINDRAJE()).append("' ");
		}

		if (valueObject.getID_COLOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COLOR= ").append(valueObject.getID_COLOR()).append(" ");
		}

		if (valueObject.getCOLOR() != null&&!valueObject.getCOLOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND COLOR= '").append(valueObject.getCOLOR()).append("' ");
		}

		if (valueObject.getID_MARCA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_MARCA= ").append(valueObject.getID_MARCA()).append(" ");
		}

		if (valueObject.getMARCA() != null&&!valueObject.getMARCA().equals("")) {
			if (first) { first = false; }
			sql.append("AND MARCA= '").append(valueObject.getMARCA()).append("' ");
		}

		if (valueObject.getID_LINEA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_LINEA= ").append(valueObject.getID_LINEA()).append(" ");
		}

		if (valueObject.getLINEA() != null&&!valueObject.getLINEA().equals("")) {
			if (first) { first = false; }
			sql.append("AND LINEA= '").append(valueObject.getLINEA()).append("' ");
		}

		if (valueObject.getMOTOR() != null&&!valueObject.getMOTOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND MOTOR= '").append(valueObject.getMOTOR()).append("' ");
		}

		if (valueObject.getCHASIS() != null&&!valueObject.getCHASIS().equals("")) {
			if (first) { first = false; }
			sql.append("AND CHASIS= '").append(valueObject.getCHASIS()).append("' ");
		}

		if (valueObject.getSERIE() != null&&!valueObject.getSERIE().equals("")) {
			if (first) { first = false; }
			sql.append("AND SERIE= '").append(valueObject.getSERIE()).append("' ");
		}

		if (valueObject.getVIN() != null&&!valueObject.getVIN().equals("")) {
			if (first) { first = false; }
			sql.append("AND VIN= '").append(valueObject.getVIN()).append("' ");
		}

		if (valueObject.getANTIGUO_CLASICO() != null&&!valueObject.getANTIGUO_CLASICO().equals("")) {
			if (first) { first = false; }
			sql.append("AND ANTIGUO_CLASICO= '").append(valueObject.getANTIGUO_CLASICO()).append("' ");
		}

		if (valueObject.getPOTENCIA() != null&&!valueObject.getPOTENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND POTENCIA= '").append(valueObject.getPOTENCIA()).append("' ");
		}

		if (valueObject.getPUERTAS() != 0) {
			if (first) { first = false; }
			sql.append("AND PUERTAS= ").append(valueObject.getPUERTAS()).append(" ");
		}

		if (valueObject.getPASAJEROS() != null&&!valueObject.getPASAJEROS().equals("")) {
			if (first) { first = false; }
			sql.append("AND PASAJEROS= '").append(valueObject.getPASAJEROS()).append("' ");
		}

		if (valueObject.getCARGA() != null&&!valueObject.getCARGA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CARGA= '").append(valueObject.getCARGA()).append("' ");
		}

		if (valueObject.getTIPO_COMBUSTIBLE() != 0) {
			if (first) { first = false; }
			sql.append("AND TIPO_COMBUSTIBLE= ").append(valueObject.getTIPO_COMBUSTIBLE()).append(" ");
		}

		if (valueObject.getPESO() != null&&!valueObject.getPESO().equals("")) {
			if (first) { first = false; }
			sql.append("AND PESO= '").append(valueObject.getPESO()).append("' ");
		}

		if (valueObject.getDISTANCIA_EJES() != null&&!valueObject.getDISTANCIA_EJES().equals("")) {
			if (first) { first = false; }
			sql.append("AND DISTANCIA_EJES= '").append(valueObject.getDISTANCIA_EJES()).append("' ");
		}

		if (valueObject.getNRO_EJES() != 0) {
			if (first) { first = false; }
			sql.append("AND NRO_EJES= ").append(valueObject.getNRO_EJES()).append(" ");
		}

		if (valueObject.getFECHA_LICENCIA() != null&&!valueObject.getFECHA_LICENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_LICENCIA= '").append(valueObject.getFECHA_LICENCIA()).append("' ");
		}

		if (valueObject.getLIC_TRANSITO() != null&&!valueObject.getLIC_TRANSITO().equals("")) {
			if (first) { first = false; }
			sql.append("AND LIC_TRANSITO= '").append(valueObject.getLIC_TRANSITO()).append("' ");
		}

		if (valueObject.getNIT_IMPORTADOR() != null&&!valueObject.getNIT_IMPORTADOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND NIT_IMPORTADOR= '").append(valueObject.getNIT_IMPORTADOR()).append("' ");
		}

		if (valueObject.getTIPO_DOCUMENTO() != null&&!valueObject.getTIPO_DOCUMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPO_DOCUMENTO= '").append(valueObject.getTIPO_DOCUMENTO()).append("' ");
		}

		if (valueObject.getDOCUMENTO() != null&&!valueObject.getDOCUMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND DOCUMENTO= '").append(valueObject.getDOCUMENTO()).append("' ");
		}

		if (valueObject.getNOMBRE_PROPIETARIO() != null&&!valueObject.getNOMBRE_PROPIETARIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE_PROPIETARIO= '").append(valueObject.getNOMBRE_PROPIETARIO()).append("' ");
		}

		if (valueObject.getDIRECCION() != null&&!valueObject.getDIRECCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DIRECCION= '").append(valueObject.getDIRECCION()).append("' ");
		}

		if (valueObject.getTELEFONO() != null&&!valueObject.getTELEFONO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TELEFONO= '").append(valueObject.getTELEFONO()).append("' ");
		}

		if (valueObject.getEMPRESA() != null&&!valueObject.getEMPRESA().equals("")) {
			if (first) { first = false; }
			sql.append("AND EMPRESA= '").append(valueObject.getEMPRESA()).append("' ");
		}

		if (valueObject.getFECHA_INICIO_PROP() != null&&!valueObject.getFECHA_INICIO_PROP().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_INICIO_PROP= '").append(valueObject.getFECHA_INICIO_PROP()).append("' ");
		}

		if (valueObject.getESTADO_PROPIEDAD() != null&&!valueObject.getESTADO_PROPIEDAD().equals("")) {
			if (first) { first = false; }
			sql.append("AND ESTADO_PROPIEDAD= '").append(valueObject.getESTADO_PROPIEDAD()).append("' ");
		}

		if (valueObject.getFECHA_FIN_PROP() != null&&!valueObject.getFECHA_FIN_PROP().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_FIN_PROP= '").append(valueObject.getFECHA_FIN_PROP()).append("' ");
		}

		if (valueObject.getPORCENTAJE_PROPIEDAD() != 0) {
			if (first) { first = false; }
			sql.append("AND PORCENTAJE_PROPIEDAD= ").append(valueObject.getPORCENTAJE_PROPIEDAD()).append(" ");
		}

		if (valueObject.getNUM_ACTMANIF() != null&&!valueObject.getNUM_ACTMANIF().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUM_ACTMANIF= '").append(valueObject.getNUM_ACTMANIF()).append("' ");
		}

		if (valueObject.getFECHA_MANIFIESTO() != null&&!valueObject.getFECHA_MANIFIESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_MANIFIESTO= '").append(valueObject.getFECHA_MANIFIESTO()).append("' ");
		}

		if (valueObject.getTIPO_PROPIEDAD() != 0) {
			if (first) { first = false; }
			sql.append("AND TIPO_PROPIEDAD= ").append(valueObject.getTIPO_PROPIEDAD()).append(" ");
		}

		sql.append(") AS CONSULTA WHERE RowNumber >="+ limiteInf +" AND RowNumber <="+ limiteSup);

		if (first)
			searchResults = new ArrayList();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}


	public int countSearchMatching(Connection conn, Migraciontmp valueObject) throws SQLException {
		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM MIGRACION_TMP WHERE 1=1 ");
		if (valueObject.getID_MIGRACION() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_MIGRACION= ").append(valueObject.getID_MIGRACION()).append(" ");
		}

		if (valueObject.getPLACA() != null&&!valueObject.getPLACA().equals("")) {
			if (first) { first = false; }
			sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
		}

		if (valueObject.getFECHA_MATRICULA() != null&&!valueObject.getFECHA_MATRICULA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_MATRICULA= '").append(valueObject.getFECHA_MATRICULA()).append("' ");
		}

		if (valueObject.getID_SERVICIO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_SERVICIO= ").append(valueObject.getID_SERVICIO()).append(" ");
		}

		if (valueObject.getSERVICIO() != null&&!valueObject.getSERVICIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND SERVICIO= '").append(valueObject.getSERVICIO()).append("' ");
		}

		if (valueObject.getID_CLASEVEHICULO() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CLASEVEHICULO= ").append(valueObject.getID_CLASEVEHICULO()).append(" ");
		}

		if (valueObject.getCLASE_VEHICULO() != null&&!valueObject.getCLASE_VEHICULO().equals("")) {
			if (first) { first = false; }
			sql.append("AND CLASE_VEHICULO= '").append(valueObject.getCLASE_VEHICULO()).append("' ");
		}

		if (valueObject.getID_CARROCERIA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_CARROCERIA= ").append(valueObject.getID_CARROCERIA()).append(" ");
		}

		if (valueObject.getCARROCERIA() != null&&!valueObject.getCARROCERIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CARROCERIA= '").append(valueObject.getCARROCERIA()).append("' ");
		}

		if (valueObject.getMODELO() != 0) {
			if (first) { first = false; }
			sql.append("AND MODELO= ").append(valueObject.getMODELO()).append(" ");
		}

		if (valueObject.getCILINDRAJE() != null&&!valueObject.getCILINDRAJE().equals("")) {
			if (first) { first = false; }
			sql.append("AND CILINDRAJE= '").append(valueObject.getCILINDRAJE()).append("' ");
		}

		if (valueObject.getID_COLOR() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_COLOR= ").append(valueObject.getID_COLOR()).append(" ");
		}

		if (valueObject.getCOLOR() != null&&!valueObject.getCOLOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND COLOR= '").append(valueObject.getCOLOR()).append("' ");
		}

		if (valueObject.getID_MARCA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_MARCA= ").append(valueObject.getID_MARCA()).append(" ");
		}

		if (valueObject.getMARCA() != null&&!valueObject.getMARCA().equals("")) {
			if (first) { first = false; }
			sql.append("AND MARCA= '").append(valueObject.getMARCA()).append("' ");
		}

		if (valueObject.getID_LINEA() != 0) {
			if (first) { first = false; }
			sql.append("AND ID_LINEA= ").append(valueObject.getID_LINEA()).append(" ");
		}

		if (valueObject.getLINEA() != null&&!valueObject.getLINEA().equals("")) {
			if (first) { first = false; }
			sql.append("AND LINEA= '").append(valueObject.getLINEA()).append("' ");
		}

		if (valueObject.getMOTOR() != null&&!valueObject.getMOTOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND MOTOR= '").append(valueObject.getMOTOR()).append("' ");
		}

		if (valueObject.getCHASIS() != null&&!valueObject.getCHASIS().equals("")) {
			if (first) { first = false; }
			sql.append("AND CHASIS= '").append(valueObject.getCHASIS()).append("' ");
		}

		if (valueObject.getSERIE() != null&&!valueObject.getSERIE().equals("")) {
			if (first) { first = false; }
			sql.append("AND SERIE= '").append(valueObject.getSERIE()).append("' ");
		}

		if (valueObject.getVIN() != null&&!valueObject.getVIN().equals("")) {
			if (first) { first = false; }
			sql.append("AND VIN= '").append(valueObject.getVIN()).append("' ");
		}

		if (valueObject.getANTIGUO_CLASICO() != null&&!valueObject.getANTIGUO_CLASICO().equals("")) {
			if (first) { first = false; }
			sql.append("AND ANTIGUO_CLASICO= '").append(valueObject.getANTIGUO_CLASICO()).append("' ");
		}

		if (valueObject.getPOTENCIA() != null&&!valueObject.getPOTENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND POTENCIA= '").append(valueObject.getPOTENCIA()).append("' ");
		}

		if (valueObject.getPUERTAS() != 0) {
			if (first) { first = false; }
			sql.append("AND PUERTAS= ").append(valueObject.getPUERTAS()).append(" ");
		}

		if (valueObject.getPASAJEROS() != null&&!valueObject.getPASAJEROS().equals("")) {
			if (first) { first = false; }
			sql.append("AND PASAJEROS= '").append(valueObject.getPASAJEROS()).append("' ");
		}

		if (valueObject.getCARGA() != null&&!valueObject.getCARGA().equals("")) {
			if (first) { first = false; }
			sql.append("AND CARGA= '").append(valueObject.getCARGA()).append("' ");
		}

		if (valueObject.getTIPO_COMBUSTIBLE() != 0) {
			if (first) { first = false; }
			sql.append("AND TIPO_COMBUSTIBLE= ").append(valueObject.getTIPO_COMBUSTIBLE()).append(" ");
		}

		if (valueObject.getPESO() != null&&!valueObject.getPESO().equals("")) {
			if (first) { first = false; }
			sql.append("AND PESO= '").append(valueObject.getPESO()).append("' ");
		}

		if (valueObject.getDISTANCIA_EJES() != null&&!valueObject.getDISTANCIA_EJES().equals("")) {
			if (first) { first = false; }
			sql.append("AND DISTANCIA_EJES= '").append(valueObject.getDISTANCIA_EJES()).append("' ");
		}

		if (valueObject.getNRO_EJES() != 0) {
			if (first) { first = false; }
			sql.append("AND NRO_EJES= ").append(valueObject.getNRO_EJES()).append(" ");
		}

		if (valueObject.getFECHA_LICENCIA() != null&&!valueObject.getFECHA_LICENCIA().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_LICENCIA= '").append(valueObject.getFECHA_LICENCIA()).append("' ");
		}

		if (valueObject.getLIC_TRANSITO() != null&&!valueObject.getLIC_TRANSITO().equals("")) {
			if (first) { first = false; }
			sql.append("AND LIC_TRANSITO= '").append(valueObject.getLIC_TRANSITO()).append("' ");
		}

		if (valueObject.getNIT_IMPORTADOR() != null&&!valueObject.getNIT_IMPORTADOR().equals("")) {
			if (first) { first = false; }
			sql.append("AND NIT_IMPORTADOR= '").append(valueObject.getNIT_IMPORTADOR()).append("' ");
		}

		if (valueObject.getTIPO_DOCUMENTO() != null&&!valueObject.getTIPO_DOCUMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TIPO_DOCUMENTO= '").append(valueObject.getTIPO_DOCUMENTO()).append("' ");
		}

		if (valueObject.getDOCUMENTO() != null&&!valueObject.getDOCUMENTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND DOCUMENTO= '").append(valueObject.getDOCUMENTO()).append("' ");
		}

		if (valueObject.getNOMBRE_PROPIETARIO() != null&&!valueObject.getNOMBRE_PROPIETARIO().equals("")) {
			if (first) { first = false; }
			sql.append("AND NOMBRE_PROPIETARIO= '").append(valueObject.getNOMBRE_PROPIETARIO()).append("' ");
		}

		if (valueObject.getDIRECCION() != null&&!valueObject.getDIRECCION().equals("")) {
			if (first) { first = false; }
			sql.append("AND DIRECCION= '").append(valueObject.getDIRECCION()).append("' ");
		}

		if (valueObject.getTELEFONO() != null&&!valueObject.getTELEFONO().equals("")) {
			if (first) { first = false; }
			sql.append("AND TELEFONO= '").append(valueObject.getTELEFONO()).append("' ");
		}

		if (valueObject.getEMPRESA() != null&&!valueObject.getEMPRESA().equals("")) {
			if (first) { first = false; }
			sql.append("AND EMPRESA= '").append(valueObject.getEMPRESA()).append("' ");
		}

		if (valueObject.getFECHA_INICIO_PROP() != null&&!valueObject.getFECHA_INICIO_PROP().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_INICIO_PROP= '").append(valueObject.getFECHA_INICIO_PROP()).append("' ");
		}

		if (valueObject.getESTADO_PROPIEDAD() != null&&!valueObject.getESTADO_PROPIEDAD().equals("")) {
			if (first) { first = false; }
			sql.append("AND ESTADO_PROPIEDAD= '").append(valueObject.getESTADO_PROPIEDAD()).append("' ");
		}

		if (valueObject.getFECHA_FIN_PROP() != null&&!valueObject.getFECHA_FIN_PROP().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_FIN_PROP= '").append(valueObject.getFECHA_FIN_PROP()).append("' ");
		}

		if (valueObject.getPORCENTAJE_PROPIEDAD() != 0) {
			if (first) { first = false; }
			sql.append("AND PORCENTAJE_PROPIEDAD= ").append(valueObject.getPORCENTAJE_PROPIEDAD()).append(" ");
		}

		if (valueObject.getNUM_ACTMANIF() != null&&!valueObject.getNUM_ACTMANIF().equals("")) {
			if (first) { first = false; }
			sql.append("AND NUM_ACTMANIF= '").append(valueObject.getNUM_ACTMANIF()).append("' ");
		}

		if (valueObject.getFECHA_MANIFIESTO() != null&&!valueObject.getFECHA_MANIFIESTO().equals("")) {
			if (first) { first = false; }
			sql.append("AND FECHA_MANIFIESTO= '").append(valueObject.getFECHA_MANIFIESTO()).append("' ");
		}

		if (valueObject.getTIPO_PROPIEDAD() != 0) {
			if (first) { first = false; }
			sql.append("AND TIPO_PROPIEDAD= ").append(valueObject.getTIPO_PROPIEDAD()).append(" ");
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


	protected void singleQuery(Connection conn, PreparedStatement stmt, Migraciontmp valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;
		try {
			result = stmt.executeQuery();
			if (result.next()) {

				valueObject.setID_MIGRACION(result.getInt("ID_MIGRACION"));
				valueObject.setPLACA(result.getString("PLACA"));
				valueObject.setFECHA_MATRICULA(result.getString("FECHA_MATRICULA"));
				valueObject.setID_SERVICIO(result.getInt("ID_SERVICIO"));
				valueObject.setSERVICIO(result.getString("SERVICIO"));
				valueObject.setID_CLASEVEHICULO(result.getInt("ID_CLASEVEHICULO"));
				valueObject.setCLASE_VEHICULO(result.getString("CLASE_VEHICULO"));
				valueObject.setID_CARROCERIA(result.getInt("ID_CARROCERIA"));
				valueObject.setCARROCERIA(result.getString("CARROCERIA"));
				valueObject.setMODELO(result.getInt("MODELO"));
				valueObject.setCILINDRAJE(result.getString("CILINDRAJE"));
				valueObject.setID_COLOR(result.getInt("ID_COLOR"));
				valueObject.setCOLOR(result.getString("COLOR"));
				valueObject.setID_MARCA(result.getInt("ID_MARCA"));
				valueObject.setMARCA(result.getString("MARCA"));
				valueObject.setID_LINEA(result.getInt("ID_LINEA"));
				valueObject.setLINEA(result.getString("LINEA"));
				valueObject.setMOTOR(result.getString("MOTOR"));
				valueObject.setCHASIS(result.getString("CHASIS"));
				valueObject.setSERIE(result.getString("SERIE"));
				valueObject.setVIN(result.getString("VIN"));
				valueObject.setANTIGUO_CLASICO(result.getString("ANTIGUO_CLASICO"));
				valueObject.setPOTENCIA(result.getString("POTENCIA"));
				valueObject.setPUERTAS(result.getInt("PUERTAS"));
				valueObject.setPASAJEROS(result.getString("PASAJEROS"));
				valueObject.setCARGA(result.getString("CARGA"));
				valueObject.setTIPO_COMBUSTIBLE(result.getInt("TIPO_COMBUSTIBLE"));
				valueObject.setPESO(result.getString("PESO"));
				valueObject.setDISTANCIA_EJES(result.getString("DISTANCIA_EJES"));
				valueObject.setNRO_EJES(result.getInt("NRO_EJES"));
				valueObject.setFECHA_LICENCIA(result.getString("FECHA_LICENCIA"));
				valueObject.setLIC_TRANSITO(result.getString("LIC_TRANSITO"));
				valueObject.setNIT_IMPORTADOR(result.getString("NIT_IMPORTADOR"));
				valueObject.setTIPO_DOCUMENTO(result.getString("TIPO_DOCUMENTO"));
				valueObject.setDOCUMENTO(result.getString("DOCUMENTO"));
				valueObject.setNOMBRE_PROPIETARIO(result.getString("NOMBRE_PROPIETARIO"));
				valueObject.setDIRECCION(result.getString("DIRECCION"));
				valueObject.setTELEFONO(result.getString("TELEFONO"));
				valueObject.setEMPRESA(result.getString("EMPRESA"));
				valueObject.setFECHA_INICIO_PROP(result.getString("FECHA_INICIO_PROP"));
				valueObject.setESTADO_PROPIEDAD(result.getString("ESTADO_PROPIEDAD"));
				valueObject.setFECHA_FIN_PROP(result.getString("FECHA_FIN_PROP"));
				valueObject.setPORCENTAJE_PROPIEDAD(result.getInt("PORCENTAJE_PROPIEDAD"));
				valueObject.setNUM_ACTMANIF(result.getString("NUM_ACTMANIF"));
				valueObject.setFECHA_MANIFIESTO(result.getString("FECHA_MANIFIESTO"));
				valueObject.setTIPO_PROPIEDAD(result.getInt("TIPO_PROPIEDAD"));

			} else {
				throw new NotFoundException("MigraciontmpObject Not Found!");
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
				Migraciontmp temp = createValueObject();

				temp.setID_MIGRACION(result.getInt("ID_MIGRACION"));
				temp.setPLACA(result.getString("PLACA"));
				temp.setFECHA_MATRICULA(result.getString("FECHA_MATRICULA"));
				temp.setID_SERVICIO(result.getInt("ID_SERVICIO"));
				temp.setSERVICIO(result.getString("SERVICIO"));
				temp.setID_CLASEVEHICULO(result.getInt("ID_CLASEVEHICULO"));
				temp.setCLASE_VEHICULO(result.getString("CLASE_VEHICULO"));
				temp.setID_CARROCERIA(result.getInt("ID_CARROCERIA"));
				temp.setCARROCERIA(result.getString("CARROCERIA"));
				temp.setMODELO(result.getInt("MODELO"));
				temp.setCILINDRAJE(result.getString("CILINDRAJE"));
				temp.setID_COLOR(result.getInt("ID_COLOR"));
				temp.setCOLOR(result.getString("COLOR"));
				temp.setID_MARCA(result.getInt("ID_MARCA"));
				temp.setMARCA(result.getString("MARCA"));
				temp.setID_LINEA(result.getInt("ID_LINEA"));
				temp.setLINEA(result.getString("LINEA"));
				temp.setMOTOR(result.getString("MOTOR"));
				temp.setCHASIS(result.getString("CHASIS"));
				temp.setSERIE(result.getString("SERIE"));
				temp.setVIN(result.getString("VIN"));
				temp.setANTIGUO_CLASICO(result.getString("ANTIGUO_CLASICO"));
				temp.setPOTENCIA(result.getString("POTENCIA"));
				temp.setPUERTAS(result.getInt("PUERTAS"));
				temp.setPASAJEROS(result.getString("PASAJEROS"));
				temp.setCARGA(result.getString("CARGA"));
				temp.setTIPO_COMBUSTIBLE(result.getInt("TIPO_COMBUSTIBLE"));
				temp.setPESO(result.getString("PESO"));
				temp.setDISTANCIA_EJES(result.getString("DISTANCIA_EJES"));
				temp.setNRO_EJES(result.getInt("NRO_EJES"));
				temp.setFECHA_LICENCIA(result.getString("FECHA_LICENCIA"));
				temp.setLIC_TRANSITO(result.getString("LIC_TRANSITO"));
				temp.setNIT_IMPORTADOR(result.getString("NIT_IMPORTADOR"));
				temp.setTIPO_DOCUMENTO(result.getString("TIPO_DOCUMENTO"));
				temp.setDOCUMENTO(result.getString("DOCUMENTO"));
				temp.setNOMBRE_PROPIETARIO(result.getString("NOMBRE_PROPIETARIO"));
				temp.setDIRECCION(result.getString("DIRECCION"));
				temp.setTELEFONO(result.getString("TELEFONO"));
				temp.setEMPRESA(result.getString("EMPRESA"));
				temp.setFECHA_INICIO_PROP(result.getString("FECHA_INICIO_PROP"));
				temp.setESTADO_PROPIEDAD(result.getString("ESTADO_PROPIEDAD"));
				temp.setFECHA_FIN_PROP(result.getString("FECHA_FIN_PROP"));
				temp.setPORCENTAJE_PROPIEDAD(result.getInt("PORCENTAJE_PROPIEDAD"));
				temp.setNUM_ACTMANIF(result.getString("NUM_ACTMANIF"));
				temp.setFECHA_MANIFIESTO(result.getString("FECHA_MANIFIESTO"));
				temp.setTIPO_PROPIEDAD(result.getInt("TIPO_PROPIEDAD"));
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
