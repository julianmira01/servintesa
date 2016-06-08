package modelo.datos.objetos.debidoCobrarImpuesto;
import java.io.*;

public class Viewdebidocobrarimpuestos implements Cloneable, Serializable {
	 private int ID;
	 private String PLACA;
	 private String LTNOMBRE;
	 private int VIGENCIA;
	 private int DCI_ESTADO;
	 private int DCI_INTERESES;
	 private int DCI_VALOR;
	 private int DCI_TOTAL;

	public Viewdebidocobrarimpuestos(){

	}

	public Viewdebidocobrarimpuestos(int IDIn) {

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

	public String getLTNOMBRE() {
		return this.LTNOMBRE;
	}

	public void  setLTNOMBRE(String LTNOMBREIn) {
		this.LTNOMBRE = LTNOMBREIn;
	}

	public int getVIGENCIA() {
		return this.VIGENCIA;
	}

	public void  setVIGENCIA(int VIGENCIAIn) {
		this.VIGENCIA = VIGENCIAIn;
	}

	public int getDCI_ESTADO() {
		return this.DCI_ESTADO;
	}

	public void  setDCI_ESTADO(int DCI_ESTADOIn) {
		this.DCI_ESTADO = DCI_ESTADOIn;
	}

	public int getDCI_INTERESES() {
		return this.DCI_INTERESES;
	}

	public void  setDCI_INTERESES(int DCI_INTERESESIn) {
		this.DCI_INTERESES = DCI_INTERESESIn;
	}

	public int getDCI_VALOR() {
		return this.DCI_VALOR;
	}

	public void  setDCI_VALOR(int DCI_VALORIn) {
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
		out.append("LTNOMBRE: "+this.LTNOMBRE);
		out.append("VIGENCIA: "+this.VIGENCIA);
		out.append("DCI_ESTADO: "+this.DCI_ESTADO);
		out.append("DCI_INTERESES: "+this.DCI_INTERESES);
		out.append("DCI_VALOR: "+this.DCI_VALOR);
		out.append("DCI_TOTAL: "+this.DCI_TOTAL);
		return out.toString();
	}
}
