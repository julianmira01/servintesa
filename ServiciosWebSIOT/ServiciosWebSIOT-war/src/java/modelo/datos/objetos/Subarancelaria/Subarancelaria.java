package modelo.datos.objetos.Subarancelaria;

import java.io.SerializablePermission;
import java.io.*;

public class Subarancelaria implements Cloneable, Serializable {
	 private int ID;
	 private String ARANCEL;

	public Subarancelaria(){

	}

	public Subarancelaria(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getARANCEL() {
		return this.ARANCEL;
	}

	public void  setARANCEL(String ARANCELIn) {
		this.ARANCEL = ARANCELIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID: "+this.ID);
		out.append("ARANCEL: "+this.ARANCEL);
		return out.toString();
	}
}
