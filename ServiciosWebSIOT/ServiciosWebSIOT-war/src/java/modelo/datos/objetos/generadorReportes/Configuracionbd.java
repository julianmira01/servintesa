package modelo.datos.objetos.generadorReportes;

import java.io.Serializable;


public class Configuracionbd implements Cloneable, Serializable {
	private int ID;
	private String USUARIO;
	private String CONTRASENA;
	private String RUTA_BD;
	private String IP_SERVER;
	private int PUERTO;
	private String INSTANCIA;
	private int ID_MOTOR_BD;

	public Configuracionbd(){

	}

	public Configuracionbd(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getUSUARIO() {
		return this.USUARIO;
	}

	public void  setUSUARIO(String USUARIOIn) {
		this.USUARIO = USUARIOIn;
	}

	public String getCONTRASENA() {
		return this.CONTRASENA;
	}

	public void  setCONTRASENA(String CONTRASENAIn) {
		this.CONTRASENA = CONTRASENAIn;
	}

	public String getRUTA_BD() {
		return this.RUTA_BD;
	}

	public void  setRUTA_BD(String RUTA_BDIn) {
		this.RUTA_BD = RUTA_BDIn;
	}

	public String getIP_SERVER() {
		return this.IP_SERVER;
	}

	public void  setIP_SERVER(String IP_SERVERIn) {
		this.IP_SERVER = IP_SERVERIn;
	}

	public int getPUERTO() {
		return this.PUERTO;
	}

	public void  setPUERTO(int PUERTOIn) {
		this.PUERTO = PUERTOIn;
	}

	public String getINSTANCIA() {
		return this.INSTANCIA;
	}

	public void  setINSTANCIA(String INSTANCIAIn) {
		this.INSTANCIA = INSTANCIAIn;
	}

	public int getID_MOTOR_BD() {
		return this.ID_MOTOR_BD;
	}

	public void  setID_MOTOR_BD(int ID_MOTOR_BDIn) {
		this.ID_MOTOR_BD = ID_MOTOR_BDIn;
	}
}
