package modelo.datos.objetos.debidoCobrarImpuesto;

import java.io.*;

public class Registrodebidocobrar implements Cloneable, Serializable {
	 private int RDC_ID;
	 private int IDVEHICULO;
	 private String RDC_ESTADO;
	 private double RDC_VALOR;
	 private int RDC_TOTAL;
	 private int RI_ID;

	public Registrodebidocobrar(){

	}

	public Registrodebidocobrar(int RDC_IDIn) {

		this.RDC_ID = RDC_IDIn; 
	}


	public int getRDC_ID() {
		return this.RDC_ID;
	}

	public void  setRDC_ID(int RDC_IDIn) {
		this.RDC_ID = RDC_IDIn;
	}

	public int getIDVEHICULO() {
		return this.IDVEHICULO;
	}

	public void  setIDVEHICULO(int IDVEHICULOIn) {
		this.IDVEHICULO = IDVEHICULOIn;
	}

	public String getRDC_ESTADO() {
		return this.RDC_ESTADO;
	}

	public void  setRDC_ESTADO(String RDC_ESTADOIn) {
		this.RDC_ESTADO = RDC_ESTADOIn;
	}

	public double getRDC_VALOR() {
		return this.RDC_VALOR;
	}

	public void  setRDC_VALOR(double RDC_VALORIn) {
		this.RDC_VALOR = RDC_VALORIn;
	}

	public int getRDC_TOTAL() {
		return this.RDC_TOTAL;
	}

	public void  setRDC_TOTAL(int RDC_TOTALIn) {
		this.RDC_TOTAL = RDC_TOTALIn;
	}

	public int getRI_ID() {
		return this.RI_ID;
	}

	public void  setRI_ID(int RI_IDIn) {
		this.RI_ID = RI_IDIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("RDC_ID: "+this.RDC_ID);
		out.append("IDVEHICULO: "+this.IDVEHICULO);
		out.append("RDC_ESTADO: "+this.RDC_ESTADO);
		out.append("RDC_VALOR: "+this.RDC_VALOR);
		out.append("RDC_TOTAL: "+this.RDC_TOTAL);
		out.append("RI_ID: "+this.RI_ID);
		return out.toString();
	}
}
