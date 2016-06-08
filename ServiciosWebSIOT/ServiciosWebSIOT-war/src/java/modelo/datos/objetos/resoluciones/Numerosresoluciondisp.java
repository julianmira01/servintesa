package modelo.datos.objetos.resoluciones;

import java.io.*;

public class Numerosresoluciondisp implements Cloneable, Serializable {
	 private int ID_NUM_RES_DISP;
	 private int ID_VIGENCIA;
	 private int NUMERO;
	 private int DISPONIBLE;

	public Numerosresoluciondisp(){

	}

	public Numerosresoluciondisp(int ID_NUM_RES_DISPIn) {

		this.ID_NUM_RES_DISP = ID_NUM_RES_DISPIn; 
	}


	public int getID_NUM_RES_DISP() {
		return this.ID_NUM_RES_DISP;
	}

	public void  setID_NUM_RES_DISP(int ID_NUM_RES_DISPIn) {
		this.ID_NUM_RES_DISP = ID_NUM_RES_DISPIn;
	}

	public int getID_VIGENCIA() {
		return this.ID_VIGENCIA;
	}

	public void  setID_VIGENCIA(int ID_VIGENCIAIn) {
		this.ID_VIGENCIA = ID_VIGENCIAIn;
	}

	public int getNUMERO() {
		return this.NUMERO;
	}

	public void  setNUMERO(int NUMEROIn) {
		this.NUMERO = NUMEROIn;
	}

	public int getDISPONIBLE() {
		return this.DISPONIBLE;
	}

	public void  setDISPONIBLE(int DISPONIBLEIn) {
		this.DISPONIBLE = DISPONIBLEIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_NUM_RES_DISP: "+this.ID_NUM_RES_DISP);
		out.append("ID_VIGENCIA: "+this.ID_VIGENCIA);
		out.append("NUMERO: "+this.NUMERO);
		out.append("DISPONIBLE: "+this.DISPONIBLE);
		return out.toString();
	}
}