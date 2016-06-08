package modelo.datos.objetos.comparendos.coactivo;

import java.io.*;

public class Bieninmueble implements Cloneable, Serializable {
	 private int ID_BIENINMUEBLE;
	 private int ID_INFRACTOR;
	 private String DIRECCION;
	 private String MATRICULA;

	public Bieninmueble(){

	}

	public Bieninmueble(int ID_BIENINMUEBLEIn) {

		this.ID_BIENINMUEBLE = ID_BIENINMUEBLEIn; 
	}


	public int getID_BIENINMUEBLE() {
		return this.ID_BIENINMUEBLE;
	}

	public void  setID_BIENINMUEBLE(int ID_BIENINMUEBLEIn) {
		this.ID_BIENINMUEBLE = ID_BIENINMUEBLEIn;
	}

	public int getID_INFRACTOR() {
		return this.ID_INFRACTOR;
	}

	public void  setID_INFRACTOR(int ID_INFRACTORIn) {
		this.ID_INFRACTOR = ID_INFRACTORIn;
	}

	public String getDIRECCION() {
		return this.DIRECCION;
	}

	public void  setDIRECCION(String DIRECCIONIn) {
		this.DIRECCION = DIRECCIONIn;
	}

	public String getMATRICULA() {
		return this.MATRICULA;
	}

	public void  setMATRICULA(String MATRICULAIn) {
		this.MATRICULA = MATRICULAIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_BIENINMUEBLE: "+this.ID_BIENINMUEBLE);
		out.append("ID_INFRACTOR: "+this.ID_INFRACTOR);
		out.append("DIRECCION: "+this.DIRECCION);
		out.append("MATRICULA: "+this.MATRICULA);
		return out.toString();
	}
}