package modelo.datos.objetos.licenciasConduccion;

import java.io.Serializable;


public class Restriccionesdelicencia implements Cloneable, Serializable {
	private String ID_LICENCIAC;
	private int ID_RESTRICCIONC;
	private int NROREGISTRO;

	public Restriccionesdelicencia(){

	}

	public Restriccionesdelicencia(String ID_LICENCIACIn) {

		this.ID_LICENCIAC = ID_LICENCIACIn; 
	}


	public String getID_LICENCIAC() {
		return this.ID_LICENCIAC;
	}

	public void  setID_LICENCIAC(String ID_LICENCIACIn) {
		this.ID_LICENCIAC = ID_LICENCIACIn;
	}

	public int getID_RESTRICCIONC() {
		return this.ID_RESTRICCIONC;
	}

	public void  setID_RESTRICCIONC(int ID_RESTRICCIONCIn) {
		this.ID_RESTRICCIONC = ID_RESTRICCIONCIn;
	}

	public int getNROREGISTRO() {
		return this.NROREGISTRO;
	}

	public void  setNROREGISTRO(int NROREGISTROIn) {
		this.NROREGISTRO = NROREGISTROIn;
	}
}
