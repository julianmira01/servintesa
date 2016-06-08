package modelo.datos.objetos.licenciasConduccion;

import java.io.Serializable;


public class Restricciones implements Cloneable, Serializable {
	private int ID_RESTRICCIONC;
	private String DESCRIPCION;
	private String CODRESTRICCION;

	public Restricciones(){

	}

	public Restricciones(int ID_RESTRICCIONCIn) {

		this.ID_RESTRICCIONC = ID_RESTRICCIONCIn; 
	}


	public int getID_RESTRICCIONC() {
		return this.ID_RESTRICCIONC;
	}

	public void  setID_RESTRICCIONC(int ID_RESTRICCIONCIn) {
		this.ID_RESTRICCIONC = ID_RESTRICCIONCIn;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void  setDESCRIPCION(String DESCRIPCIONIn) {
		this.DESCRIPCION = DESCRIPCIONIn;
	}

	public String getCODRESTRICCION() {
		return this.CODRESTRICCION;
	}

	public void  setCODRESTRICCION(String CODRESTRICCIONIn) {
		this.CODRESTRICCION = CODRESTRICCIONIn;
	}
}
