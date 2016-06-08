package modelo.datos.objetos.resoluciones;
import java.io.*;

public class Docsresoluciones implements Cloneable, Serializable {
	 private int ID_DOCSRESOLUCIONES;
	 private String CONTENIDO;

	public Docsresoluciones(){

	}

	public Docsresoluciones(int ID_DOCSRESOLUCIONESIn) {

		this.ID_DOCSRESOLUCIONES = ID_DOCSRESOLUCIONESIn; 
	}


	public int getID_DOCSRESOLUCIONES() {
		return this.ID_DOCSRESOLUCIONES;
	}

	public void  setID_DOCSRESOLUCIONES(int ID_DOCSRESOLUCIONESIn) {
		this.ID_DOCSRESOLUCIONES = ID_DOCSRESOLUCIONESIn;
	}

	public String getCONTENIDO() {
		return this.CONTENIDO;
	}

	public void  setCONTENIDO(String CONTENIDOIn) {
		this.CONTENIDO = CONTENIDOIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_DOCSRESOLUCIONES: "+this.ID_DOCSRESOLUCIONES);
		out.append("CONTENIDO: "+this.CONTENIDO);
		return out.toString();
	}
}
