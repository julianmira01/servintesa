package modelo.datos.objetos.debidoCobrarImpuesto;

import java.io.*;

public class Registroimpuesto implements Cloneable, Serializable {
	 private int RI_ID;
	 private double RI_INTERES;
	 private String RI_TIPOIMPUESTO;
	 private String RI_IMPUESTO;
	 private int RI_VIGENCIAS;
	 private int LT_TARIFA;

	public Registroimpuesto(){

	}

	public Registroimpuesto(int RI_IDIn) {

		this.RI_ID = RI_IDIn; 
	}


	public int getRI_ID() {
		return this.RI_ID;
	}

	public void  setRI_ID(int RI_IDIn) {
		this.RI_ID = RI_IDIn;
	}

	public double getRI_INTERES() {
		return this.RI_INTERES;
	}

	public void  setRI_INTERES(double RI_INTERESIn) {
		this.RI_INTERES = RI_INTERESIn;
	}

	public String getRI_TIPOIMPUESTO() {
		return this.RI_TIPOIMPUESTO;
	}

	public void  setRI_TIPOIMPUESTO(String RI_TIPOIMPUESTOIn) {
		this.RI_TIPOIMPUESTO = RI_TIPOIMPUESTOIn;
	}

	public String getRI_IMPUESTO() {
		return this.RI_IMPUESTO;
	}

	public void  setRI_IMPUESTO(String RI_IMPUESTOIn) {
		this.RI_IMPUESTO = RI_IMPUESTOIn;
	}

	public int getRI_VIGENCIAS() {
		return this.RI_VIGENCIAS;
	}

	public void  setRI_VIGENCIAS(int RI_VIGENCIASIn) {
		this.RI_VIGENCIAS = RI_VIGENCIASIn;
	}

	public int getLT_TARIFA() {
		return this.LT_TARIFA;
	}

	public void  setLT_TARIFA(int LT_TARIFAIn) {
		this.LT_TARIFA = LT_TARIFAIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("RI_ID: "+this.RI_ID);
		out.append("RI_INTERES: "+this.RI_INTERES);
		out.append("RI_TIPOIMPUESTO: "+this.RI_TIPOIMPUESTO);
		out.append("RI_IMPUESTO: "+this.RI_IMPUESTO);
		out.append("RI_VIGENCIAS: "+this.RI_VIGENCIAS);
		out.append("LT_TARIFA: "+this.LT_TARIFA);
		return out.toString();
	}
}
