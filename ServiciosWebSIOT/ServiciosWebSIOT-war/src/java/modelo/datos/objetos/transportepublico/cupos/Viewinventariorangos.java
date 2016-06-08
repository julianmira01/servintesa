package modelo.datos.objetos.transportepublico.cupos;

import java.io.*;

public class Viewinventariorangos implements Cloneable, Serializable {
	 private int ID_EMPRESA_ASIGNADA;
	 private int ID_TIPOVEHICULO;
	 private String NUMERO_CUPO;
	 private String DISPONIBLE;
	 private String TIPO_VEHICULO;
	 private String NIT_EMPRESA_SERVICIO;
	 private String RAZON_SOCIAL;

	public Viewinventariorangos(){

	}

	public Viewinventariorangos(int ID_EMPRESA_ASIGNADAIn) {

		this.ID_EMPRESA_ASIGNADA = ID_EMPRESA_ASIGNADAIn; 
	}


	public int getID_EMPRESA_ASIGNADA() {
		return this.ID_EMPRESA_ASIGNADA;
	}

	public void  setID_EMPRESA_ASIGNADA(int ID_EMPRESA_ASIGNADAIn) {
		this.ID_EMPRESA_ASIGNADA = ID_EMPRESA_ASIGNADAIn;
	}

	public int getID_TIPOVEHICULO() {
		return this.ID_TIPOVEHICULO;
	}

	public void  setID_TIPOVEHICULO(int ID_TIPOVEHICULOIn) {
		this.ID_TIPOVEHICULO = ID_TIPOVEHICULOIn;
	}

	public String getNUMERO_CUPO() {
		return this.NUMERO_CUPO;
	}

	public void  setNUMERO_CUPO(String NUMERO_CUPOIn) {
		this.NUMERO_CUPO = NUMERO_CUPOIn;
	}

	public String getDISPONIBLE() {
		return this.DISPONIBLE;
	}

	public void  setDISPONIBLE(String DISPONIBLEIn) {
		this.DISPONIBLE = DISPONIBLEIn;
	}

	public String getTIPO_VEHICULO() {
		return this.TIPO_VEHICULO;
	}

	public void  setTIPO_VEHICULO(String TIPO_VEHICULOIn) {
		this.TIPO_VEHICULO = TIPO_VEHICULOIn;
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

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_EMPRESA_ASIGNADA: "+this.ID_EMPRESA_ASIGNADA);
		out.append("ID_TIPOVEHICULO: "+this.ID_TIPOVEHICULO);
		out.append("NUMERO_CUPO: "+this.NUMERO_CUPO);
		out.append("DISPONIBLE: "+this.DISPONIBLE);
		out.append("TIPO_VEHICULO: "+this.TIPO_VEHICULO);
		out.append("NIT_EMPRESA_SERVICIO: "+this.NIT_EMPRESA_SERVICIO);
		out.append("RAZON_SOCIAL: "+this.RAZON_SOCIAL);
		return out.toString();
	}
}
