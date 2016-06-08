package modelo.datos.objetos.generales;

import java.util.Calendar;
import java.util.Date;

public class Festivos 
{
    private Date hoy;
    private boolean[][][] festivos = new boolean[3000][13][32];
    private int ano;
    private int pascua_mes;
    private int pascua_dia;
    private Date FechaPascua;
    
    public Festivos(int anio) 
    {
        super();
        EasterDate ed = new EasterDate();
        ano = anio;
        hoy = new Date();
        
        FechaPascua = ed.getEasterDate(ano);
        pascua_dia=FechaPascua.getDate();
        pascua_mes=FechaPascua.getMonth()+1;
        
        festivos[ano][1][1]   = true;           // Primero de Enero
        festivos[ano][5][1]   = true;           // Dia del Trabajo 1 de Mayo
        festivos[ano][7][20]  = true;           // Independencia 20 de Julio
        festivos[ano][8][7]   = true;           // Batalla de Boyac-*- 7 de Agosto
        festivos[ano][12][8]  = true;           // Maria Inmaculada 8 diciembre (religiosa)
        festivos[ano][12][25] = true;           // Navidad 25 de diciembre
        
        calcula_emiliani(1, 6);                          // Reyes Magos Enero 6
        calcula_emiliani(3, 19);                         // San Jose Marzo 19
        calcula_emiliani(6, 29);                         // San Pedro y San Pablo Junio 29
        calcula_emiliani(8, 15);                         // Asunci-*-n Agosto 15
        calcula_emiliani(10, 12);                        // Descubrimiento de Am-*-rica Oct 12
        calcula_emiliani(11, 1);                         // Todos los santos Nov 1
        calcula_emiliani(11, 11);                        // Independencia de Cartagena Nov 11
		
/*        //otras fechas calculadas a partir de la pascua.
        
        otrasFechasCalculadas(-3,false);			//jueves santo
        otrasFechasCalculadas(-2,false);			//viernes santo
        
        otrasFechasCalculadas(36,true);		//Ascenci-*-n el Se-*-or pascua
        otrasFechasCalculadas(60,true);		//Corpus Cristi
        otrasFechasCalculadas(68,true);		//Sagrado Coraz-*-n
        
        // otras fechas importantes que no son festivos

        otrasFechasCalculadas(-46,false);		// Mi-*-rcoles de Ceniza
        otrasFechasCalculadas(-46,false);		// Mi-*-rcoles de Ceniza
        otrasFechasCalculadas(-48,false);		// Lunes de Carnaval Barranquilla
        otrasFechasCalculadas(-47,false);		// Martes de Carnaval Barranquilla
*/
    }
    
    protected void calcula_emiliani(int mes_festivo, int dia_festivo) 
    {
            // funcion que mueve una fecha diferente a lunes al siguiente lunes en el
            // calendario y se aplica a fechas que estan bajo la ley emiliani
            //global  $y,$dia_festivo,$mes_festivo,$festivo;
            // Extrae el dia de la semana
            // 0 Domingo -*- 6 S-*-bado
        
            Calendar fecha = Calendar.getInstance();
            fecha.set(ano,mes_festivo-1,dia_festivo-1);
            
            int dd = fecha.get(Calendar.DAY_OF_WEEK);
            
            switch (dd) {
            case 0:                                    // Domingo
            dia_festivo = dia_festivo + 1;
            break;
            case 2:                                    // Martes.
            dia_festivo = dia_festivo + 6;
            break;
            case 3:                                    // Mi-*-rcoles
            dia_festivo = dia_festivo + 5;
            break;
            case 4:                                     // Jueves
            dia_festivo = dia_festivo + 4;
            break;
            case 5:                                     // Viernes
            dia_festivo = dia_festivo + 3;
            break;
            case 6:                                     // S-*-bado
            dia_festivo = dia_festivo + 2;
            break;
            }
            
            Calendar fechaInicial = Calendar.getInstance();
            fechaInicial.set(ano,mes_festivo,dia_festivo);
            int mes = fechaInicial.get(Calendar.MONTH);
            int dia = fechaInicial.get(Calendar.DAY_OF_MONTH);
            festivos[ano][mes][dia] = true;
    }
    
    protected void otrasFechasCalculadas(int cantidadDias,boolean siguienteLunes)
    {
        Calendar fechaInicial = Calendar.getInstance();
        fechaInicial.set(ano,pascua_mes,pascua_dia);
        fechaInicial.add(Calendar.DAY_OF_MONTH, cantidadDias);
        int mes_festivo = fechaInicial.get(Calendar.MONTH);
        int dia_festivo = fechaInicial.get(Calendar.DAY_OF_MONTH);
        //int  = mktime(0,0,0,pascua_mes,pascua_dia+cantidadDias,ano);
        //int dia_festivo = mktime(0,0,0,pascua_mes,pascua_dia+cantidadDias,ano);
        
        if (siguienteLunes)
        {
                calcula_emiliani(mes_festivo, dia_festivo);
        }	
        else
        {	
                festivos[ano][mes_festivo][dia_festivo] = true;
        }
    }	
                                                                                                                  
    public boolean esFestivo(int dia, int mes)
    {		
            if (festivos[ano][mes][dia])
            {
                    return true;
            }
            else 
            {
                    return false;
            }
    
    }
}