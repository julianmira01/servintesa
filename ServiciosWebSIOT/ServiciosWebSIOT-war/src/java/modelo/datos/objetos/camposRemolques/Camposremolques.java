package modelo.datos.objetos.camposRemolques;

import java.io.*;

public class Camposremolques implements Cloneable, Serializable {
    private int ID;
             private int NUM_LLANTAS;
             private String PESO_MAX_CONFIGURACION_1;
             private int ID_VEHICULO;
             private String PESO_MAX_CONFIGURACION_2;
             private int ID_SUBPARTIDA_ARANCELARIA;
             private int ID_TIPO_RODAJE;

            public Camposremolques(){

            }

            public Camposremolques(int IDIn) {

                    this.ID = IDIn; 
            }


            public int getID() {
                    return this.ID;
            }

            public void  setID(int IDIn) {
                    this.ID = IDIn;
            }

            public int getNUM_LLANTAS() {
                    return this.NUM_LLANTAS;
            }

            public void  setNUM_LLANTAS(int NUM_LLANTASIn) {
                    this.NUM_LLANTAS = NUM_LLANTASIn;
            }

            public String getPESO_MAX_CONFIGURACION_1() {
                    return this.PESO_MAX_CONFIGURACION_1;
            }

            public void  setPESO_MAX_CONFIGURACION_1(String PESO_MAX_CONFIGURACION_1In) {
                    this.PESO_MAX_CONFIGURACION_1 = PESO_MAX_CONFIGURACION_1In;
            }

            public int getID_VEHICULO() {
                    return this.ID_VEHICULO;
            }

            public void  setID_VEHICULO(int ID_VEHICULOIn) {
                    this.ID_VEHICULO = ID_VEHICULOIn;
            }

            public String getPESO_MAX_CONFIGURACION_2() {
                    return this.PESO_MAX_CONFIGURACION_2;
            }

            public void  setPESO_MAX_CONFIGURACION_2(String PESO_MAX_CONFIGURACION_2In) {
                    this.PESO_MAX_CONFIGURACION_2 = PESO_MAX_CONFIGURACION_2In;
            }

            public int getID_SUBPARTIDA_ARANCELARIA() {
                    return this.ID_SUBPARTIDA_ARANCELARIA;
            }

            public void  setID_SUBPARTIDA_ARANCELARIA(int ID_SUBPARTIDA_ARANCELARIAIn) {
                    this.ID_SUBPARTIDA_ARANCELARIA = ID_SUBPARTIDA_ARANCELARIAIn;
            }

            public int getID_TIPO_RODAJE() {
                    return this.ID_TIPO_RODAJE;
            }

            public void  setID_TIPO_RODAJE(int ID_TIPO_RODAJEIn) {
                    this.ID_TIPO_RODAJE = ID_TIPO_RODAJEIn;
            }

            public String toString() {
                    StringBuffer out = new StringBuffer();
                    out.append("ID: "+this.ID);
                    out.append("NUM_LLANTAS: "+this.NUM_LLANTAS);
                    out.append("PESO_MAX_CONFIGURACION_1: "+this.PESO_MAX_CONFIGURACION_1);
                    out.append("ID_VEHICULO: "+this.ID_VEHICULO);
                    out.append("PESO_MAX_CONFIGURACION_2: "+this.PESO_MAX_CONFIGURACION_2);
                    out.append("ID_SUBPARTIDA_ARANCELARIA: "+this.ID_SUBPARTIDA_ARANCELARIA);
                    out.append("ID_TIPO_RODAJE: "+this.ID_TIPO_RODAJE);
                    return out.toString();
            }
}
