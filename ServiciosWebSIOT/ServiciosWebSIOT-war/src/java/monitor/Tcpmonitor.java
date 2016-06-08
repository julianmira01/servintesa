/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpmonitor;

import org.apache.axis.utils.tcpmon;

/**
 *
 * @author Ricardo
 */
public class Tcpmonitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
		String[] campos = new String[3]; 
		campos[0]="7777";   //Dejar como está
		//campos[1]="10.10.1.9";   //Cambiar por la ip con que se conectan a la VPN del RUNT
		//campos[1]="190.254.17.40";
		campos[1]="172.20.110.4";
		//campos[1]="10.10.6.9";
		campos[2]="80";  //Probar con este, si no trae información el tcpmonitor, cambiarlo por el puerto que dieron con la ip de la vpn
			
		tcpmon.main(campos); 
		}
}
