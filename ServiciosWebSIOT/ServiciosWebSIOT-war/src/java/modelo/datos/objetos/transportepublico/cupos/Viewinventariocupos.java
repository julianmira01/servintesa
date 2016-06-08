package modelo.datos.objetos.transportepublico.cupos;

import java.io.*;

public class Viewinventariocupos implements Cloneable, Serializable {
	 private int ID_DETALLERANGOCUPO;
	 private String DISPONIBLE;
	 private String NUMERO_CUPO;
	 private String TIPO_VEHICULO;
	 private String PLACA;
	 private String PROPIETARIO;
	 private String NIT_EMPRESA_SERVICIO;
	 private String RAZON_SOCIAL;
	 private String TARJETA_ACTIVA;
	 private String NUMERO_TARJETA;
	 private String FECHA_VENCIMIENTO;

	public Viewinventariocupos(){

	}

	public Viewinventariocupos(int ID_DETALLERANGOCUPOIn) {

		this.ID_DETALLERANGOCUPO = ID_DETALLERANGOCUPOIn; 
	}


	public int getID_DETALLERANGOCUPO() {
		return this.ID_DETALLERANGOCUPO;
	}

	public void  setID_DETALLERANGOCUPO(int ID_DETALLERANGOCUPOIn) {
		this.ID_DETALLERANGOCUPO = ID_DETALLERANGOCUPOIn;
	}

	public String getDISPONIBLE() {
		return this.DISPONIBLE;
	}

	public void  setDISPONIBLE(String DISPONIBLEIn) {
		this.DISPONIBLE = DISPONIBLEIn;
	}

	public String getNUMERO_CUPO() {
		return this.NUMERO_CUPO;
	}

	public void  setNUMERO_CUPO(String NUMERO_CUPOIn) {
		this.NUMERO_CUPO = NUMERO_CUPOIn;
	}

	public String getTIPO_VEHICULO() {
		return this.TIPO_VEHICULO;
	}

	public void  setTIPO_VEHICULO(String TIPO_VEHICULOIn) {
		this.TIPO_VEHICULO = TIPO_VEHICULOIn;
	}

	public String getPLACA() {
		return this.PLACA;
	}

	public void  setPLACA(String PLACAIn) {
		this.PLACA = PLACAIn;
	}

	public String getPROPIETARIO() {
		return this.PROPIETARIO;
	}

	public void  setPROPIETARIO(String PROPIETARIOIn) {
		this.PROPIETARIO = PROPIETARIOIn;
	}

	public String getNIT_EMPRESA_SERVICIO() {
		return this.NIT_EMPRESA_SERVICIO;
	}

	public void  setNIT_EMPRESA_SERVICIO(String NIT_EMPRESA_SERVICIOIn) {
		this.NIT_EMPRESA_SERVICIO = NIT_EMPRESA_SERVICIOIn;
	}

	public String getRAZON_SOCIAL() {
		return this.RAZON_SOCIAL;
	}

	public void  setRAZON_SOCIAL(String RAZON_SOCIALIn) {
		this.RAZON_SOCIAL = RAZON_SOCIALIn;
	}

	public String getTARJETA_ACTIVA() {
		return this.TARJETA_ACTIVA;
	}

	public void  setTARJETA_ACTIVA(String TARJETA_ACTIVAIn) {
		this.TARJETA_ACTIVA = TARJETA_ACTIVAIn;
	}

	public String getNUMERO_TARJETA() {
		return this.NUMERO_TARJETA;
	}

	public void  setNUMERO_TARJETA(String NUMERO_TARJETAIn) {
		this.NUMERO_TARJETA = NUMERO_TARJETAIn;
	}

	public String getFECHA_VENCIMIENTO() {
		return this.FECHA_VENCIMIENTO;
	}

	public void  setFECHA_VENCIMIENTO(String FECHA_VENCIMIENTOIn) {
		this.FECHA_VENCIMIENTO = FECHA_VENCIMIENTOIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_DETALLERANGOCUPO: "+this.ID_DETALLERANGOCUPO);
		out.append("DISPONIBLE: "+this.DISPONIBLE);
		out.append("NUMERO_CUPO: "+this.NUMERO_CUPO);
		out.append("TIPO_VEHICULO: "+this.TIPO_VEHICULO);
		out.append("PLACA: "+this.PLACA);
		out.append("PROPIETARIO: "+this.PROPIETARIO);
		out.append("NIT_EMPRESA_SERVICIO: "+this.NIT_EMPRESA_SERVICIO);
		out.append("RAZON_SOCIAL: "+this.RAZON_SOCIAL);
		out.append("TARJETA_ACTIVA: "+this.TARJETA_ACTIVA);
		out.append("NUMERO_TARJETA: "+this.NUMERO_TARJETA);
		out.append("FECHA_VENCIMIENTO: "+this.FECHA_VENCIMIENTO);
		return out.toString();
	}
}
