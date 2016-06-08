package modelo.datos.objetos.historico_claves;
import java.io.*;

public class Historicoclaves implements Cloneable, Serializable {
	 private int ID_HISTORICO_CLAVES;
	 private int ID_USUARIO;
	 private String CLAVE;
	 private String BLOQUEO;
	 private String FECHA_BLOQUEO;
	 private int INTENTOS_FALLIDOS;

	public Historicoclaves(){

	}

	public Historicoclaves(int ID_HISTORICO_CLAVESIn) {

		this.ID_HISTORICO_CLAVES = ID_HISTORICO_CLAVESIn; 
	}


	public int getID_HISTORICO_CLAVES() {
		return this.ID_HISTORICO_CLAVES;
	}

	public void  setID_HISTORICO_CLAVES(int ID_HISTORICO_CLAVESIn) {
		this.ID_HISTORICO_CLAVES = ID_HISTORICO_CLAVESIn;
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

	public String getBLOQUEO() {
		return this.BLOQUEO;
	}

	public void  setBLOQUEO(String BLOQUEOIn) {
		this.BLOQUEO = BLOQUEOIn;
	}

	public String getFECHA_BLOQUEO() {
		return this.FECHA_BLOQUEO;
	}

	public void  setFECHA_BLOQUEO(String FECHA_BLOQUEOIn) {
		this.FECHA_BLOQUEO = FECHA_BLOQUEOIn;
	}

	public int getINTENTOS_FALLIDOS() {
		return this.INTENTOS_FALLIDOS;
	}

	public void  setINTENTOS_FALLIDOS(int INTENTOS_FALLIDOSIn) {
		this.INTENTOS_FALLIDOS = INTENTOS_FALLIDOSIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_HISTORICO_CLAVES: "+this.ID_HISTORICO_CLAVES);
		out.append("ID_USUARIO: "+this.ID_USUARIO);
		out.append("CLAVE: "+this.CLAVE);
		out.append("BLOQUEO: "+this.BLOQUEO);
		out.append("FECHA_BLOQUEO: "+this.FECHA_BLOQUEO);
		out.append("INTENTOS_FALLIDOS: "+this.INTENTOS_FALLIDOS);
		return out.toString();
	}
}
