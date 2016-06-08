package modelo.datos.objetos.distribucionRecursos;
import java.io.*;

public class Cuentacontable implements Cloneable, Serializable {
	 private int ID_CTACONTABLE;
	 private String COD_CTACONTABLE;
	 private String NOMBRE_CTACONTABLE;
	 private int VIGENCIA;

	public Cuentacontable(){

	}

	public Cuentacontable(int ID_CTACONTABLEIn) {

		this.ID_CTACONTABLE = ID_CTACONTABLEIn; 
	}


	public int getID_CTACONTABLE() {
		return this.ID_CTACONTABLE;
	}

	public void  setID_CTACONTABLE(int ID_CTACONTABLEIn) {
		this.ID_CTACONTABLE = ID_CTACONTABLEIn;
	}

	public String getCOD_CTACONTABLE() {
		return this.COD_CTACONTABLE;
	}

	public void  setCOD_CTACONTABLE(String COD_CTACONTABLEIn) {
		this.COD_CTACONTABLE = COD_CTACONTABLEIn;
	}

	public String getNOMBRE_CTACONTABLE() {
		return this.NOMBRE_CTACONTABLE;
	}

	public void  setNOMBRE_CTACONTABLE(String NOMBRE_CTACONTABLEIn) {
		this.NOMBRE_CTACONTABLE = NOMBRE_CTACONTABLEIn;
	}

	public int getVIGENCIA() {
		return this.VIGENCIA;
	}

	public void  setVIGENCIA(int VIGENCIAIn) {
		this.VIGENCIA = VIGENCIAIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_CTACONTABLE: "+this.ID_CTACONTABLE);
		out.append("COD_CTACONTABLE: "+this.COD_CTACONTABLE);
		out.append("NOMBRE_CTACONTABLE: "+this.NOMBRE_CTACONTABLE);
		out.append("VIGENCIA: "+this.VIGENCIA);
		return out.toString();
	}
}
