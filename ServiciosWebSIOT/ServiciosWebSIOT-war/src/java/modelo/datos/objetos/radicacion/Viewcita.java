package modelo.datos.objetos.radicacion;

import java.io.*;

public class Viewcita implements Cloneable, Serializable {
	 private int NUMERO_CITA;
	 private String ESTADO;
	 private String DEPENDENCIA;
	 private String FECHA;

	public Viewcita(){
          super();
	}

	public Viewcita(int NUMERO_CITAIn) {

		this.NUMERO_CITA = NUMERO_CITAIn; 
	}


	public int getNUMERO_CITA() {
		return this.NUMERO_CITA;
	}

	public void  setNUMERO_CITA(int NUMERO_CITAIn) {
		this.NUMERO_CITA = NUMERO_CITAIn;
	}

	public String getESTADO() {
		return this.ESTADO;
	}

	public void  setESTADO(String ESTADOIn) {
		this.ESTADO = ESTADOIn;
	}

	public String getDEPENDENCIA() {
		return this.DEPENDENCIA;
	}

	public void  setDEPENDENCIA(String DEPENDENCIAIn) {
		this.DEPENDENCIA = DEPENDENCIAIn;
	}

	public String getFECHA() {
		return this.FECHA;
	}

	public void  setFECHA(String FECHAIn) {
		this.FECHA = FECHAIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("NUMERO_CITA: "+this.NUMERO_CITA);
		out.append("ESTADO: "+this.ESTADO);
		out.append("DEPENDENCIA: "+this.DEPENDENCIA);
		out.append("FECHA: "+this.FECHA);
		return out.toString();
	}
}

