package modelo.datos.objetos.debidoCobrarImpuesto;
import java.io.*;

public class Debidocobrarimpuesto implements Cloneable, Serializable {
	 private int DCI_ID;
	 private int IDVEHICULO;
	 private int LT_ID;
	 private int ID_VIGENCIA;
	 private int DCI_INTERESES;
	 private int DCI_ESTADO;
	 private int DCI_VALOR;
	 private int DCI_TOTAL;

	public Debidocobrarimpuesto(){

	}

	public Debidocobrarimpuesto(int DCI_IDIn) {

		this.DCI_ID = DCI_IDIn; 
	}


	public int getDCI_ID() {
		return this.DCI_ID;
	}

	public void  setDCI_ID(int DCI_IDIn) {
		this.DCI_ID = DCI_IDIn;
	}

	public int getIDVEHICULO() {
		return this.IDVEHICULO;
	}

	public void  setIDVEHICULO(int IDVEHICULOIn) {
		this.IDVEHICULO = IDVEHICULOIn;
	}

	public int getLT_ID() {
		return this.LT_ID;
	}

	public void  setLT_ID(int LT_IDIn) {
		this.LT_ID = LT_IDIn;
	}

	public int getID_VIGENCIA() {
		return this.ID_VIGENCIA;
	}

	public void  setID_VIGENCIA(int ID_VIGENCIAIn) {
		this.ID_VIGENCIA = ID_VIGENCIAIn;
	}

	public int getDCI_INTERESES() {
		return this.DCI_INTERESES;
	}

	public void  setDCI_INTERESES(int DCI_INTERESESIn) {
		this.DCI_INTERESES = DCI_INTERESESIn;
	}

	public int getDCI_ESTADO() {
		return this.DCI_ESTADO;
	}

	public void  setDCI_ESTADO(int DCI_ESTADOIn) {
		this.DCI_ESTADO = DCI_ESTADOIn;
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
		out.append("DCI_ID: "+this.DCI_ID);
		out.append("IDVEHICULO: "+this.IDVEHICULO);
		out.append("LT_ID: "+this.LT_ID);
		out.append("ID_VIGENCIA: "+this.ID_VIGENCIA);
		out.append("DCI_INTERESES: "+this.DCI_INTERESES);
		out.append("DCI_ESTADO: "+this.DCI_ESTADO);
		out.append("DCI_VALOR: "+this.DCI_VALOR);
		out.append("DCI_TOTAL: "+this.DCI_TOTAL);
		return out.toString();
	}
}
