package modelo.datos.objetos.distribucionRecursos;
import java.io.*;

public class Detctacontable implements Cloneable, Serializable {
	 private int ID_DETCTA_CONTABLE;
	 private int ID_CTACONTABLE;
	 private int ID_ELEMENTOCONTABLE;
	 private String FORMULA;

	public Detctacontable(){

	}

	public Detctacontable(int ID_DETCTA_CONTABLEIn) {

		this.ID_DETCTA_CONTABLE = ID_DETCTA_CONTABLEIn; 
	}


	public int getID_DETCTA_CONTABLE() {
		return this.ID_DETCTA_CONTABLE;
	}

	public void  setID_DETCTA_CONTABLE(int ID_DETCTA_CONTABLEIn) {
		this.ID_DETCTA_CONTABLE = ID_DETCTA_CONTABLEIn;
	}

	public int getID_CTACONTABLE() {
		return this.ID_CTACONTABLE;
	}

	public void  setID_CTACONTABLE(int ID_CTACONTABLEIn) {
		this.ID_CTACONTABLE = ID_CTACONTABLEIn;
	}

	public int getID_ELEMENTOCONTABLE() {
		return this.ID_ELEMENTOCONTABLE;
	}

	public void  setID_ELEMENTOCONTABLE(int ID_ELEMENTOCONTABLEIn) {
		this.ID_ELEMENTOCONTABLE = ID_ELEMENTOCONTABLEIn;
	}

	public String getFORMULA() {
		return this.FORMULA;
	}

	public void  setFORMULA(String FORMULAIn) {
		this.FORMULA = FORMULAIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_DETCTA_CONTABLE: "+this.ID_DETCTA_CONTABLE);
		out.append("ID_CTACONTABLE: "+this.ID_CTACONTABLE);
		out.append("ID_ELEMENTOCONTABLE: "+this.ID_ELEMENTOCONTABLE);
		out.append("FORMULA: "+this.FORMULA);
		return out.toString();
	}
}
