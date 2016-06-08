package modelo.datos.objetos.debidoCobrarImpuesto;

import java.io.*;

public class Viewregistrodebidocobrar implements Cloneable, Serializable {
	 private int ID;
	 private String PLACA;
	 private String TIPOIMPUESTO;
	 private String IMPUESTO;
	 private int VIGENCIA;
	 private double DCI_INTERESES;
	 private String DCI_ESTADO;
	 private double DCI_VALOR;
	 private int DCI_TOTAL;

	public Viewregistrodebidocobrar(){

	}

	public Viewregistrodebidocobrar(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getPLACA() {
		return this.PLACA;
	}

	public void  setPLACA(String PLACAIn) {
		this.PLACA = PLACAIn;
	}

	public String getTIPOIMPUESTO() {
		return this.TIPOIMPUESTO;
	}

	public void  setTIPOIMPUESTO(String TIPOIMPUESTOIn) {
		this.TIPOIMPUESTO = TIPOIMPUESTOIn;
	}

	public String getIMPUESTO() {
		return this.IMPUESTO;
	}

	public void  setIMPUESTO(String IMPUESTOIn) {
		this.IMPUESTO = IMPUESTOIn;
	}

	public int getVIGENCIA() {
		return this.VIGENCIA;
	}

	public void  setVIGENCIA(int VIGENCIAIn) {
		this.VIGENCIA = VIGENCIAIn;
	}

	public double getDCI_INTERESES() {
		return this.DCI_INTERESES;
	}

	public void  setDCI_INTERESES(double DCI_INTERESESIn) {
		this.DCI_INTERESES = DCI_INTERESESIn;
	}

	public String getDCI_ESTADO() {
		return this.DCI_ESTADO;
	}

	public void  setDCI_ESTADO(String DCI_ESTADOIn) {
		this.DCI_ESTADO = DCI_ESTADOIn;
	}

	public double getDCI_VALOR() {
		return this.DCI_VALOR;
	}

	public void  setDCI_VALOR(double DCI_VALORIn) {
		this.DCI_VALOR = DCI_VALORIn;
	}

	public int getDCI_TOTAL() {
		return this.DCI_TOTAL;
	}

	public void  setDCI_TOTAL(int DCI_TOTALIn) {
		this.DCI_TOTAL = DCI_TOTALIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID: "+this.ID);
		out.append("PLACA: "+this.PLACA);
		out.append("TIPOIMPUESTO: "+this.TIPOIMPUESTO);
		out.append("IMPUESTO: "+this.IMPUESTO);
		out.append("VIGENCIA: "+this.VIGENCIA);
		out.append("DCI_INTERESES: "+this.DCI_INTERESES);
		out.append("DCI_ESTADO: "+this.DCI_ESTADO);
		out.append("DCI_VALOR: "+this.DCI_VALOR);
		out.append("DCI_TOTAL: "+this.DCI_TOTAL);
		return out.toString();
	}
}
