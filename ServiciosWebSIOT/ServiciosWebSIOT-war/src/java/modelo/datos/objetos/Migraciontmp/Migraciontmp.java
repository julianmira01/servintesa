package modelo.datos.objetos.Migraciontmp;

import java.io.*;

public class Migraciontmp implements Cloneable, Serializable {
	 private int ID_MIGRACION;
	 private String PLACA;
	 private String FECHA_MATRICULA;
	 private int ID_SERVICIO;
	 private String SERVICIO;
	 private int ID_CLASEVEHICULO;
	 private String CLASE_VEHICULO;
	 private int ID_CARROCERIA;
	 private String CARROCERIA;
	 private int MODELO;
	 private String CILINDRAJE;
	 private int ID_COLOR;
	 private String COLOR;
	 private int ID_MARCA;
	 private String MARCA;
	 private int ID_LINEA;
	 private String LINEA;
	 private String MOTOR;
	 private String CHASIS;
	 private String SERIE;
	 private String VIN;
	 private String ANTIGUO_CLASICO;
	 private String POTENCIA;
	 private int PUERTAS;
	 private String PASAJEROS;
	 private String CARGA;
	 private int TIPO_COMBUSTIBLE;
	 private String PESO;
	 private String DISTANCIA_EJES;
	 private int NRO_EJES;
	 private String FECHA_LICENCIA;
	 private String LIC_TRANSITO;
	 private String NIT_IMPORTADOR;
	 private String TIPO_DOCUMENTO;
	 private String DOCUMENTO;
	 private String NOMBRE_PROPIETARIO;
	 private String DIRECCION;
	 private String TELEFONO;
	 private String EMPRESA;
	 private String FECHA_INICIO_PROP;
	 private String ESTADO_PROPIEDAD;
	 private String FECHA_FIN_PROP;
	 private int PORCENTAJE_PROPIEDAD;
	 private String NUM_ACTMANIF;
	 private String FECHA_MANIFIESTO;
	 private int TIPO_PROPIEDAD;

	public Migraciontmp(){

	}

	public Migraciontmp(int ID_MIGRACIONIn) {

		this.ID_MIGRACION = ID_MIGRACIONIn; 
	}


	public int getID_MIGRACION() {
		return this.ID_MIGRACION;
	}

	public void  setID_MIGRACION(int ID_MIGRACIONIn) {
		this.ID_MIGRACION = ID_MIGRACIONIn;
	}

	public String getPLACA() {
		return this.PLACA;
	}

	public void  setPLACA(String PLACAIn) {
		this.PLACA = PLACAIn;
	}

	public String getFECHA_MATRICULA() {
		return this.FECHA_MATRICULA;
	}

	public void  setFECHA_MATRICULA(String FECHA_MATRICULAIn) {
		this.FECHA_MATRICULA = FECHA_MATRICULAIn;
	}

	public int getID_SERVICIO() {
		return this.ID_SERVICIO;
	}

	public void  setID_SERVICIO(int ID_SERVICIOIn) {
		this.ID_SERVICIO = ID_SERVICIOIn;
	}

	public String getSERVICIO() {
		return this.SERVICIO;
	}

	public void  setSERVICIO(String SERVICIOIn) {
		this.SERVICIO = SERVICIOIn;
	}

	public int getID_CLASEVEHICULO() {
		return this.ID_CLASEVEHICULO;
	}

	public void  setID_CLASEVEHICULO(int ID_CLASEVEHICULOIn) {
		this.ID_CLASEVEHICULO = ID_CLASEVEHICULOIn;
	}

	public String getCLASE_VEHICULO() {
		return this.CLASE_VEHICULO;
	}

	public void  setCLASE_VEHICULO(String CLASE_VEHICULOIn) {
		this.CLASE_VEHICULO = CLASE_VEHICULOIn;
	}

	public int getID_CARROCERIA() {
		return this.ID_CARROCERIA;
	}

	public void  setID_CARROCERIA(int ID_CARROCERIAIn) {
		this.ID_CARROCERIA = ID_CARROCERIAIn;
	}

	public String getCARROCERIA() {
		return this.CARROCERIA;
	}

	public void  setCARROCERIA(String CARROCERIAIn) {
		this.CARROCERIA = CARROCERIAIn;
	}

	public int getMODELO() {
		return this.MODELO;
	}

	public void  setMODELO(int MODELOIn) {
		this.MODELO = MODELOIn;
	}

	public String getCILINDRAJE() {
		return this.CILINDRAJE;
	}

	public void  setCILINDRAJE(String CILINDRAJEIn) {
		this.CILINDRAJE = CILINDRAJEIn;
	}

	public int getID_COLOR() {
		return this.ID_COLOR;
	}

	public void  setID_COLOR(int ID_COLORIn) {
		this.ID_COLOR = ID_COLORIn;
	}

	public String getCOLOR() {
		return this.COLOR;
	}

	public void  setCOLOR(String COLORIn) {
		this.COLOR = COLORIn;
	}

	public int getID_MARCA() {
		return this.ID_MARCA;
	}

	public void  setID_MARCA(int ID_MARCAIn) {
		this.ID_MARCA = ID_MARCAIn;
	}

	public String getMARCA() {
		return this.MARCA;
	}

	public void  setMARCA(String MARCAIn) {
		this.MARCA = MARCAIn;
	}

	public int getID_LINEA() {
		return this.ID_LINEA;
	}

	public void  setID_LINEA(int ID_LINEAIn) {
		this.ID_LINEA = ID_LINEAIn;
	}

	public String getLINEA() {
		return this.LINEA;
	}

	public void  setLINEA(String LINEAIn) {
		this.LINEA = LINEAIn;
	}

	public String getMOTOR() {
		return this.MOTOR;
	}

	public void  setMOTOR(String MOTORIn) {
		this.MOTOR = MOTORIn;
	}

	public String getCHASIS() {
		return this.CHASIS;
	}

	public void  setCHASIS(String CHASISIn) {
		this.CHASIS = CHASISIn;
	}

	public String getSERIE() {
		return this.SERIE;
	}

	public void  setSERIE(String SERIEIn) {
		this.SERIE = SERIEIn;
	}

	public String getVIN() {
		return this.VIN;
	}

	public void  setVIN(String VINIn) {
		this.VIN = VINIn;
	}

	public String getANTIGUO_CLASICO() {
		return this.ANTIGUO_CLASICO;
	}

	public void  setANTIGUO_CLASICO(String ANTIGUO_CLASICOIn) {
		this.ANTIGUO_CLASICO = ANTIGUO_CLASICOIn;
	}

	public String getPOTENCIA() {
		return this.POTENCIA;
	}

	public void  setPOTENCIA(String POTENCIAIn) {
		this.POTENCIA = POTENCIAIn;
	}

	public int getPUERTAS() {
		return this.PUERTAS;
	}

	public void  setPUERTAS(int PUERTASIn) {
		this.PUERTAS = PUERTASIn;
	}

	public String getPASAJEROS() {
		return this.PASAJEROS;
	}

	public void  setPASAJEROS(String PASAJEROSIn) {
		this.PASAJEROS = PASAJEROSIn;
	}

	public String getCARGA() {
		return this.CARGA;
	}

	public void  setCARGA(String CARGAIn) {
		this.CARGA = CARGAIn;
	}

	public int getTIPO_COMBUSTIBLE() {
		return this.TIPO_COMBUSTIBLE;
	}

	public void  setTIPO_COMBUSTIBLE(int TIPO_COMBUSTIBLEIn) {
		this.TIPO_COMBUSTIBLE = TIPO_COMBUSTIBLEIn;
	}

	public String getPESO() {
		return this.PESO;
	}

	public void  setPESO(String PESOIn) {
		this.PESO = PESOIn;
	}

	public String getDISTANCIA_EJES() {
		return this.DISTANCIA_EJES;
	}

	public void  setDISTANCIA_EJES(String DISTANCIA_EJESIn) {
		this.DISTANCIA_EJES = DISTANCIA_EJESIn;
	}

	public int getNRO_EJES() {
		return this.NRO_EJES;
	}

	public void  setNRO_EJES(int NRO_EJESIn) {
		this.NRO_EJES = NRO_EJESIn;
	}

	public String getFECHA_LICENCIA() {
		return this.FECHA_LICENCIA;
	}

	public void  setFECHA_LICENCIA(String FECHA_LICENCIAIn) {
		this.FECHA_LICENCIA = FECHA_LICENCIAIn;
	}

	public String getLIC_TRANSITO() {
		return this.LIC_TRANSITO;
	}

	public void  setLIC_TRANSITO(String LIC_TRANSITOIn) {
		this.LIC_TRANSITO = LIC_TRANSITOIn;
	}

	public String getNIT_IMPORTADOR() {
		return this.NIT_IMPORTADOR;
	}

	public void  setNIT_IMPORTADOR(String NIT_IMPORTADORIn) {
		this.NIT_IMPORTADOR = NIT_IMPORTADORIn;
	}

	public String getTIPO_DOCUMENTO() {
		return this.TIPO_DOCUMENTO;
	}

	public void  setTIPO_DOCUMENTO(String TIPO_DOCUMENTOIn) {
		this.TIPO_DOCUMENTO = TIPO_DOCUMENTOIn;
	}

	public String getDOCUMENTO() {
		return this.DOCUMENTO;
	}

	public void  setDOCUMENTO(String DOCUMENTOIn) {
		this.DOCUMENTO = DOCUMENTOIn;
	}

	public String getNOMBRE_PROPIETARIO() {
		return this.NOMBRE_PROPIETARIO;
	}

	public void  setNOMBRE_PROPIETARIO(String NOMBRE_PROPIETARIOIn) {
		this.NOMBRE_PROPIETARIO = NOMBRE_PROPIETARIOIn;
	}

	public String getDIRECCION() {
		return this.DIRECCION;
	}

	public void  setDIRECCION(String DIRECCIONIn) {
		this.DIRECCION = DIRECCIONIn;
	}

	public String getTELEFONO() {
		return this.TELEFONO;
	}

	public void  setTELEFONO(String TELEFONOIn) {
		this.TELEFONO = TELEFONOIn;
	}

	public String getEMPRESA() {
		return this.EMPRESA;
	}

	public void  setEMPRESA(String EMPRESAIn) {
		this.EMPRESA = EMPRESAIn;
	}

	public String getFECHA_INICIO_PROP() {
		return this.FECHA_INICIO_PROP;
	}

	public void  setFECHA_INICIO_PROP(String FECHA_INICIO_PROPIn) {
		this.FECHA_INICIO_PROP = FECHA_INICIO_PROPIn;
	}

	public String getESTADO_PROPIEDAD() {
		return this.ESTADO_PROPIEDAD;
	}

	public void  setESTADO_PROPIEDAD(String ESTADO_PROPIEDADIn) {
		this.ESTADO_PROPIEDAD = ESTADO_PROPIEDADIn;
	}

	public String getFECHA_FIN_PROP() {
		return this.FECHA_FIN_PROP;
	}

	public void  setFECHA_FIN_PROP(String FECHA_FIN_PROPIn) {
		this.FECHA_FIN_PROP = FECHA_FIN_PROPIn;
	}

	public int getPORCENTAJE_PROPIEDAD() {
		return this.PORCENTAJE_PROPIEDAD;
	}

	public void  setPORCENTAJE_PROPIEDAD(int PORCENTAJE_PROPIEDADIn) {
		this.PORCENTAJE_PROPIEDAD = PORCENTAJE_PROPIEDADIn;
	}

	public String getNUM_ACTMANIF() {
		return this.NUM_ACTMANIF;
	}

	public void  setNUM_ACTMANIF(String NUM_ACTMANIFIn) {
		this.NUM_ACTMANIF = NUM_ACTMANIFIn;
	}

	public String getFECHA_MANIFIESTO() {
		return this.FECHA_MANIFIESTO;
	}

	public void  setFECHA_MANIFIESTO(String FECHA_MANIFIESTOIn) {
		this.FECHA_MANIFIESTO = FECHA_MANIFIESTOIn;
	}

	public int getTIPO_PROPIEDAD() {
		return this.TIPO_PROPIEDAD;
	}

	public void  setTIPO_PROPIEDAD(int TIPO_PROPIEDADIn) {
		this.TIPO_PROPIEDAD = TIPO_PROPIEDADIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_MIGRACION: "+this.ID_MIGRACION);
		out.append("PLACA: "+this.PLACA);
		out.append("FECHA_MATRICULA: "+this.FECHA_MATRICULA);
		out.append("ID_SERVICIO: "+this.ID_SERVICIO);
		out.append("SERVICIO: "+this.SERVICIO);
		out.append("ID_CLASEVEHICULO: "+this.ID_CLASEVEHICULO);
		out.append("CLASE_VEHICULO: "+this.CLASE_VEHICULO);
		out.append("ID_CARROCERIA: "+this.ID_CARROCERIA);
		out.append("CARROCERIA: "+this.CARROCERIA);
		out.append("MODELO: "+this.MODELO);
		out.append("CILINDRAJE: "+this.CILINDRAJE);
		out.append("ID_COLOR: "+this.ID_COLOR);
		out.append("COLOR: "+this.COLOR);
		out.append("ID_MARCA: "+this.ID_MARCA);
		out.append("MARCA: "+this.MARCA);
		out.append("ID_LINEA: "+this.ID_LINEA);
		out.append("LINEA: "+this.LINEA);
		out.append("MOTOR: "+this.MOTOR);
		out.append("CHASIS: "+this.CHASIS);
		out.append("SERIE: "+this.SERIE);
		out.append("VIN: "+this.VIN);
		out.append("ANTIGUO_CLASICO: "+this.ANTIGUO_CLASICO);
		out.append("POTENCIA: "+this.POTENCIA);
		out.append("PUERTAS: "+this.PUERTAS);
		out.append("PASAJEROS: "+this.PASAJEROS);
		out.append("CARGA: "+this.CARGA);
		out.append("TIPO_COMBUSTIBLE: "+this.TIPO_COMBUSTIBLE);
		out.append("PESO: "+this.PESO);
		out.append("DISTANCIA_EJES: "+this.DISTANCIA_EJES);
		out.append("NRO_EJES: "+this.NRO_EJES);
		out.append("FECHA_LICENCIA: "+this.FECHA_LICENCIA);
		out.append("LIC_TRANSITO: "+this.LIC_TRANSITO);
		out.append("NIT_IMPORTADOR: "+this.NIT_IMPORTADOR);
		out.append("TIPO_DOCUMENTO: "+this.TIPO_DOCUMENTO);
		out.append("DOCUMENTO: "+this.DOCUMENTO);
		out.append("NOMBRE_PROPIETARIO: "+this.NOMBRE_PROPIETARIO);
		out.append("DIRECCION: "+this.DIRECCION);
		out.append("TELEFONO: "+this.TELEFONO);
		out.append("EMPRESA: "+this.EMPRESA);
		out.append("FECHA_INICIO_PROP: "+this.FECHA_INICIO_PROP);
		out.append("ESTADO_PROPIEDAD: "+this.ESTADO_PROPIEDAD);
		out.append("FECHA_FIN_PROP: "+this.FECHA_FIN_PROP);
		out.append("PORCENTAJE_PROPIEDAD: "+this.PORCENTAJE_PROPIEDAD);
		out.append("NUM_ACTMANIF: "+this.NUM_ACTMANIF);
		out.append("FECHA_MANIFIESTO: "+this.FECHA_MANIFIESTO);
		out.append("TIPO_PROPIEDAD: "+this.TIPO_PROPIEDAD);
		return out.toString();
	}
}
