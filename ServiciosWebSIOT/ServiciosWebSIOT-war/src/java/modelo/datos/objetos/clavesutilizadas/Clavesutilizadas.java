package modelo.datos.objetos.clavesutilizadas;
import java.io.*;

public class Clavesutilizadas implements Cloneable, Serializable {
	 private int ID_CLAVES_UTILIZADAS;
	 private int ID_USUARIO;
	 private String CLAVE;

	public Clavesutilizadas(){

	}

	public Clavesutilizadas(int ID_CLAVES_UTILIZADASIn) {

		this.ID_CLAVES_UTILIZADAS = ID_CLAVES_UTILIZADASIn; 
	}


	public int getID_CLAVES_UTILIZADAS() {
		return this.ID_CLAVES_UTILIZADAS;
	}

	public void  setID_CLAVES_UTILIZADAS(int ID_CLAVES_UTILIZADASIn) {
		this.ID_CLAVES_UTILIZADAS = ID_CLAVES_UTILIZADASIn;
	}

	public int getID_USUARIO() {
		return this.ID_USUARIO;
	}

	public void  setID_USUARIO(int ID_USUARIOIn) {
		this.ID_USUARIO = ID_USUARIOIn;
	}

	public String getCLAVE() {
		return this.CLAVE;
	}

	public void  setCLAVE(String CLAVEIn) {
		this.CLAVE = CLAVEIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_CLAVES_UTILIZADAS: "+this.ID_CLAVES_UTILIZADAS);
		out.append("ID_USUARIO: "+this.ID_USUARIO);
		out.append("CLAVE: "+this.CLAVE);
		return out.toString();
	}
}
