package modelo.datos.objetos.liquidador;

import java.io.*;
import java.io.Serializable;

public class Fechaimpuesto implements Cloneable, Serializable {
	 private int ID_FECHAIMPUESTO;
	 private int VIGENCIA;
	 private String FECHLIMITE_PAGO;

	public Fechaimpuesto(){

	}

	public Fechaimpuesto(int ID_FECHAIMPUESTOIn) {

		this.ID_FECHAIMPUESTO = ID_FECHAIMPUESTOIn; 
	}


	public int getID_FECHAIMPUESTO() {
		return this.ID_FECHAIMPUESTO;
	}

	public void  setID_FECHAIMPUESTO(int ID_FECHAIMPUESTOIn) {
		this.ID_FECHAIMPUESTO = ID_FECHAIMPUESTOIn;
	}

	public int getVIGENCIA() {
		return this.VIGENCIA;
	}

	public void  setVIGENCIA(int VIGENCIAIn) {
		this.VIGENCIA = VIGENCIAIn;
	}

	public String getFECHLIMITE_PAGO() {
		return this.FECHLIMITE_PAGO;
	}

	public void  setFECHLIMITE_PAGO(String FECHLIMITE_PAGOIn) {
		this.FECHLIMITE_PAGO = FECHLIMITE_PAGOIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_FECHAIMPUESTO: "+this.ID_FECHAIMPUESTO);
		out.append("VIGENCIA: "+this.VIGENCIA);
		out.append("FECHLIMITE_PAGO: "+this.FECHLIMITE_PAGO);
		return out.toString();
	}
}
