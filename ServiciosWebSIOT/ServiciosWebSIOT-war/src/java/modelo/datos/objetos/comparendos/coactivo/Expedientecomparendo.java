package modelo.datos.objetos.comparendos.coactivo;

import java.io.*;

public class Expedientecomparendo implements Cloneable, Serializable {
	 private int ID_EXPEDIENTECOMPARENDO;
	 private int ID_COMPARENDO;
	 private int ID_EXPEDIENTE;

	public Expedientecomparendo(){

	}

	public Expedientecomparendo(int ID_EXPEDIENTECOMPARENDOIn) {

		this.ID_EXPEDIENTECOMPARENDO = ID_EXPEDIENTECOMPARENDOIn; 
	}


	public int getID_EXPEDIENTECOMPARENDO() {
		return this.ID_EXPEDIENTECOMPARENDO;
	}

	public void  setID_EXPEDIENTECOMPARENDO(int ID_EXPEDIENTECOMPARENDOIn) {
		this.ID_EXPEDIENTECOMPARENDO = ID_EXPEDIENTECOMPARENDOIn;
	}

	public int getID_COMPARENDO() {
		return this.ID_COMPARENDO;
	}

	public void  setID_COMPARENDO(int ID_COMPARENDOIn) {
		this.ID_COMPARENDO = ID_COMPARENDOIn;
	}

	public int getID_EXPEDIENTE() {
		return this.ID_EXPEDIENTE;
	}

	public void  setID_EXPEDIENTE(int ID_EXPEDIENTEIn) {
		this.ID_EXPEDIENTE = ID_EXPEDIENTEIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_EXPEDIENTECOMPARENDO: "+this.ID_EXPEDIENTECOMPARENDO);
		out.append("ID_COMPARENDO: "+this.ID_COMPARENDO);
		out.append("ID_EXPEDIENTE: "+this.ID_EXPEDIENTE);
		return out.toString();
	}
}
