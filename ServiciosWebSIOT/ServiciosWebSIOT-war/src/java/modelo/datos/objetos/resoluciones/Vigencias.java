package modelo.datos.objetos.resoluciones;

import java.io.*;

public class Vigencias implements Cloneable, Serializable {
	 private int ID_VIGENCIA;
	 private int ANO;
	 private int NUM_RESOLUCION_INICIO;

	public Vigencias(){

	}

	public Vigencias(int ID_VIGENCIAIn) {

		this.ID_VIGENCIA = ID_VIGENCIAIn; 
	}


	public int getID_VIGENCIA() {
		return this.ID_VIGENCIA;
	}

	public void  setID_VIGENCIA(int ID_VIGENCIAIn) {
		this.ID_VIGENCIA = ID_VIGENCIAIn;
	}

	public int getANO() {
		return this.ANO;
	}

	public void  setANO(int ANOIn) {
		this.ANO = ANOIn;
	}

	public int getNUM_RESOLUCION_INICIO() {
		return this.NUM_RESOLUCION_INICIO;
	}

	public void  setNUM_RESOLUCION_INICIO(int NUM_RESOLUCION_INICIOIn) {
		this.NUM_RESOLUCION_INICIO = NUM_RESOLUCION_INICIOIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_VIGENCIA: "+this.ID_VIGENCIA);
		out.append("ANO: "+this.ANO);
		out.append("NUM_RESOLUCION_INICIO: "+this.NUM_RESOLUCION_INICIO);
		return out.toString();
	}
}