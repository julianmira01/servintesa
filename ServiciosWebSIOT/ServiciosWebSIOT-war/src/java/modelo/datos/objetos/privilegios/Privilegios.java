package modelo.datos.objetos.privilegios;
import java.io.*;

public class Privilegios implements Cloneable, Serializable {
	 private int ID_PRIVILEGIOS;
	 private int ID_USUARIO;
         private String[] PERMISO;
	 //private String AUTENTICARUNT;
	 //private String LIQUIDARUNT;

	public Privilegios(){

	}

	public Privilegios(int ID_PRIVILEGIOSIn) {

		this.ID_PRIVILEGIOS = ID_PRIVILEGIOSIn; 
	}


	public int getID_PRIVILEGIOS() {
		return this.ID_PRIVILEGIOS;
	}

	public void  setID_PRIVILEGIOS(int ID_PRIVILEGIOSIn) {
		this.ID_PRIVILEGIOS = ID_PRIVILEGIOSIn;
	}

	public int getID_USUARIO() {
		return this.ID_USUARIO;
	}

	public void  setID_USUARIO(int ID_USUARIOIn) {
		this.ID_USUARIO = ID_USUARIOIn;
	}

	public String[] getPERMISO() {
		return this.PERMISO;
	}

	public void  setPERMISO(String[] PERMISOIn) {
		this.PERMISO = PERMISOIn;
	}

	/*public String getLIQUIDARUNT() {
		return this.LIQUIDARUNT;
	}

	public void  setLIQUIDARUNT(String LIQUIDARUNTIn) {
		this.LIQUIDARUNT = LIQUIDARUNTIn;
	}*/

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_PRIVILEGIOS: "+this.ID_PRIVILEGIOS);
		out.append("ID_USUARIO: "+this.ID_USUARIO);
		out.append("PERMISO: "+this.PERMISO);
		return out.toString();
	}
}
