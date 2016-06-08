package modelo.datos.objetos.comparendos.coactivo;

import java.io.*;

public class Expediente implements Cloneable, Serializable {
	 private int ID_EXPEDIENTE;
	 private int ID_INFRACTOR;
	 private int ID_RESPONSABLE;
	 private String FECHACREACION;
	 private int CONSECUTIVO;
	 private int ESTADO;

	public Expediente(){

	}

	public Expediente(int ID_EXPEDIENTEIn) {

		this.ID_EXPEDIENTE = ID_EXPEDIENTEIn; 
	}


	public int getID_EXPEDIENTE() {
		return this.ID_EXPEDIENTE;
	}

	public void  setID_EXPEDIENTE(int ID_EXPEDIENTEIn) {
		this.ID_EXPEDIENTE = ID_EXPEDIENTEIn;
	}

	public int getID_INFRACTOR() {
		return this.ID_INFRACTOR;
	}

	public void  setID_INFRACTOR(int ID_INFRACTORIn) {
		this.ID_INFRACTOR = ID_INFRACTORIn;
	}

	public int getID_RESPONSABLE() {
		return this.ID_RESPONSABLE;
	}

	public void  setID_RESPONSABLE(int ID_RESPONSABLEIn) {
		this.ID_RESPONSABLE = ID_RESPONSABLEIn;
	}

	public String getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void  setFECHACREACION(String FECHACREACIONIn) {
		this.FECHACREACION = FECHACREACIONIn;
	}

	public int getCONSECUTIVO() {
		return this.CONSECUTIVO;
	}

	public void  setCONSECUTIVO(int CONSECUTIVOIn) {
		this.CONSECUTIVO = CONSECUTIVOIn;
	}

	public int getESTADO() {
		return this.ESTADO;
	}

	public void  setESTADO(int ESTADOIn) {
		this.ESTADO = ESTADOIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_EXPEDIENTE: "+this.ID_EXPEDIENTE);
		out.append("ID_INFRACTOR: "+this.ID_INFRACTOR);
		out.append("ID_RESPONSABLE: "+this.ID_RESPONSABLE);
		out.append("FECHACREACION: "+this.FECHACREACION);
		out.append("CONSECUTIVO: "+this.CONSECUTIVO);
		out.append("ESTADO: "+this.ESTADO);
		return out.toString();
	}
}
