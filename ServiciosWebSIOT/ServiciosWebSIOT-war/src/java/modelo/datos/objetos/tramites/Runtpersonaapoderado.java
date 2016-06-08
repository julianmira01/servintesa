package modelo.datos.objetos.tramites;

import java.io.Serializable;

public class Runtpersonaapoderado implements Cloneable, Serializable {
	 private int ID_PERSONAAPODERADO;
	 private int ID_RECIBOLIQ;
	 private int ID_APODERADO;
	 private int ID_PROPIETARIO;
	 private String TIPOPROP;
	 private String ESTADOPROP;

	public Runtpersonaapoderado(){

	}

	public Runtpersonaapoderado(int ID_PERSONAAPODERADOIn) {

		this.ID_PERSONAAPODERADO = ID_PERSONAAPODERADOIn; 
	}


	public int getID_PERSONAAPODERADO() {
		return this.ID_PERSONAAPODERADO;
	}

	public void  setID_PERSONAAPODERADO(int ID_PERSONAAPODERADOIn) {
		this.ID_PERSONAAPODERADO = ID_PERSONAAPODERADOIn;
	}

	public int getID_RECIBOLIQ() {
		return this.ID_RECIBOLIQ;
	}

	public void  setID_RECIBOLIQ(int ID_RECIBOLIQIn) {
		this.ID_RECIBOLIQ = ID_RECIBOLIQIn;
	}

	public int getID_APODERADO() {
		return this.ID_APODERADO;
	}

	public void  setID_APODERADO(int ID_APODERADOIn) {
		this.ID_APODERADO = ID_APODERADOIn;
	}

	public int getID_PROPIETARIO() {
		return this.ID_PROPIETARIO;
	}

	public void  setID_PROPIETARIO(int ID_PROPIETARIOIn) {
		this.ID_PROPIETARIO = ID_PROPIETARIOIn;
	}

	public String getTIPOPROP() {
		return this.TIPOPROP;
	}

	public void  setTIPOPROP(String TIPOPROPIn) {
		this.TIPOPROP = TIPOPROPIn;
	}

	public String getESTADOPROP() {
		return this.ESTADOPROP;
	}

	public void  setESTADOPROP(String ESTADOPROPIn) {
		this.ESTADOPROP = ESTADOPROPIn;
	}
}
