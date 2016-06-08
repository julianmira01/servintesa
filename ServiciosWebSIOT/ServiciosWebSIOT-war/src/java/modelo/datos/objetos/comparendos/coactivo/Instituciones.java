package modelo.datos.objetos.comparendos.coactivo;

import java.io.*;

public class Instituciones implements Cloneable, Serializable {
	 private int ID_INSTITUCION;
	 private String NOMBRE;
	 private String DIRECCION;
	 private int ID_CIUDAD;

	public Instituciones(){

	}

	public Instituciones(int ID_INSTITUCIONIn) {

		this.ID_INSTITUCION = ID_INSTITUCIONIn; 
	}


	public int getID_INSTITUCION() {
		return this.ID_INSTITUCION;
	}

	public void  setID_INSTITUCION(int ID_INSTITUCIONIn) {
		this.ID_INSTITUCION = ID_INSTITUCIONIn;
	}

	public String getNOMBRE() {
		return this.NOMBRE;
	}

	public void  setNOMBRE(String NOMBREIn) {
		this.NOMBRE = NOMBREIn;
	}

	public String getDIRECCION() {
		return this.DIRECCION;
	}

	public void  setDIRECCION(String DIRECCIONIn) {
		this.DIRECCION = DIRECCIONIn;
	}

	public int getID_CIUDAD() {
		return this.ID_CIUDAD;
	}

	public void  setID_CIUDAD(int ID_CIUDADIn) {
		this.ID_CIUDAD = ID_CIUDADIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_INSTITUCION: "+this.ID_INSTITUCION);
		out.append("NOMBRE: "+this.NOMBRE);
		out.append("DIRECCION: "+this.DIRECCION);
		out.append("ID_CIUDAD: "+this.ID_CIUDAD);
		return out.toString();
	}
}
