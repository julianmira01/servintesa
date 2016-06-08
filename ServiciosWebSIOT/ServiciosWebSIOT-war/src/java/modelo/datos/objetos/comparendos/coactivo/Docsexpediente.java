package modelo.datos.objetos.comparendos.coactivo;

import java.io.*;

public class Docsexpediente implements Cloneable, Serializable {
	 private int ID_DOCSEXPEDIENTE;
	 private int ID_EXPEDIENTE;
	 private int ID_TIPODOC_COBRO;
	 private String FECHA_REGISTRO;
	 private String FECHA_DOCUMENTO;
	 private int CONSECUTIVO;

	public Docsexpediente(){

	}

	public Docsexpediente(int ID_DOCSEXPEDIENTEIn) {

		this.ID_DOCSEXPEDIENTE = ID_DOCSEXPEDIENTEIn; 
	}


	public int getID_DOCSEXPEDIENTE() {
		return this.ID_DOCSEXPEDIENTE;
	}

	public void  setID_DOCSEXPEDIENTE(int ID_DOCSEXPEDIENTEIn) {
		this.ID_DOCSEXPEDIENTE = ID_DOCSEXPEDIENTEIn;
	}

	public int getID_EXPEDIENTE() {
		return this.ID_EXPEDIENTE;
	}

	public void  setID_EXPEDIENTE(int ID_EXPEDIENTEIn) {
		this.ID_EXPEDIENTE = ID_EXPEDIENTEIn;
	}

	public int getID_TIPODOC_COBRO() {
		return this.ID_TIPODOC_COBRO;
	}

	public void  setID_TIPODOC_COBRO(int ID_TIPODOC_COBROIn) {
		this.ID_TIPODOC_COBRO = ID_TIPODOC_COBROIn;
	}

	public String getFECHA_REGISTRO() {
		return this.FECHA_REGISTRO;
	}

	public void  setFECHA_REGISTRO(String FECHA_REGISTROIn) {
		this.FECHA_REGISTRO = FECHA_REGISTROIn;
	}

	public String getFECHA_DOCUMENTO() {
		return this.FECHA_DOCUMENTO;
	}

	public void  setFECHA_DOCUMENTO(String FECHA_DOCUMENTOIn) {
		this.FECHA_DOCUMENTO = FECHA_DOCUMENTOIn;
	}

	public int getCONSECUTIVO() {
		return this.CONSECUTIVO;
	}

	public void  setCONSECUTIVO(int CONSECUTIVOIn) {
		this.CONSECUTIVO = CONSECUTIVOIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_DOCSEXPEDIENTE: "+this.ID_DOCSEXPEDIENTE);
		out.append("ID_EXPEDIENTE: "+this.ID_EXPEDIENTE);
		out.append("ID_TIPODOC_COBRO: "+this.ID_TIPODOC_COBRO);
		out.append("FECHA_REGISTRO: "+this.FECHA_REGISTRO);
		out.append("FECHA_DOCUMENTO: "+this.FECHA_DOCUMENTO);
		out.append("CONSECUTIVO: "+this.CONSECUTIVO);
		return out.toString();
	}
}
