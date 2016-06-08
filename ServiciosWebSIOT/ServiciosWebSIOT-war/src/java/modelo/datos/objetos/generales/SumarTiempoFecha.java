package modelo.datos.objetos.generales;

import java.util.Calendar;
import java.util.Date;

public class SumarTiempoFecha {
    public SumarTiempoFecha() {
        super();
    }
    
    public static String sumarDiasHabilesFecha(Calendar fecha, int dias)
    {
        Festivos festivos= new Festivos(fecha.get(Calendar.YEAR));
        for(int i = 0; i<dias;i++)
        {
            fecha.add(Calendar.DAY_OF_MONTH, 1); 
            if(fecha.get(Calendar.DAY_OF_WEEK) == 0 || fecha.get(Calendar.DAY_OF_WEEK) == 6 || festivos.esFestivo(fecha.get(Calendar.DAY_OF_MONTH), fecha.get(Calendar.MONTH)))
                fecha.add(Calendar.DAY_OF_MONTH, -1);    
            String fechaActual = String.valueOf(fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.YEAR));
            if(fechaActual.startsWith("2/31/")|| fechaActual.startsWith("2/30/")||fechaActual.startsWith("2/29/"))
            {
                i--;
                fecha.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
        return fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.YEAR);    
    }
    
    public static String sumarDiasCalendario(Calendar fecha, int dias)
    {
        Festivos festivos= new Festivos(fecha.get(Calendar.YEAR));
        for(int i = 0; i<dias;i++)
        {
            fecha.add(Calendar.DAY_OF_MONTH, 1);
            String fechaActual = String.valueOf(fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.YEAR));
            if(fechaActual.startsWith("2/31/")|| fechaActual.startsWith("2/30/")||fechaActual.startsWith("2/29/"))
            {
                i--;
                fecha.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
        return fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.YEAR);        
    }
    
    public static String restarDiasHabilesFecha(Calendar fecha, int dias)
    {
        int anio = fecha.get(Calendar.YEAR);
        Festivos festivos= new Festivos(anio);
        for(int i = 0; i<dias;i++)
        {
            fecha.add(Calendar.DAY_OF_MONTH, -1); 
            /*if(fecha.get(Calendar.DAY_OF_WEEK) == 0 || fecha.get(Calendar.DAY_OF_WEEK) == 6 || festivos.esFestivo(fecha.get(Calendar.DAY_OF_MONTH), fecha.get(Calendar.MONTH)))
                fecha.add(Calendar.DAY_OF_MONTH, 1);*/    
            String fechaActual = String.valueOf(fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.YEAR));
            if(fechaActual.startsWith("2/31/")|| fechaActual.startsWith("2/30/")||fechaActual.startsWith("2/29/"))
            {
                i--;
                fecha.add(Calendar.DAY_OF_MONTH, -1);
            }
        }
        return fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.YEAR);        
    }
    
    public static String restarDiasCalendario(Calendar fecha, int dias)
    {
        
            Festivos festivos= new Festivos(fecha.get(Calendar.YEAR));
        for(int i = 0; i<dias;i++)
        {
            fecha.add(Calendar.DAY_OF_MONTH, -1);
            String fechaActual = String.valueOf(fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.YEAR));
            if(fechaActual.startsWith("2/31/")|| fechaActual.startsWith("2/30/")||fechaActual.startsWith("2/29/"))
            {
                i--;
                fecha.add(Calendar.DAY_OF_MONTH, -1);
            }
        }
        return fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.YEAR);    
    }
}
