package modelo.datos.objetos.generales;

import java.util.Calendar;
import java.util.Date;

public class Class1 {
    public Class1() {
        super();
    }

    public static void main(String[] args) {
        //Class1 class1 = new Class1();
        //Festivos fes = new Festivos(2014);
        //boolean festivo = fes.esFestivo(1,5);
        Date fecha = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(fecha.getYear()+1900,fecha.getMonth(),fecha.getDate());
        Festivos festivo = new Festivos(2014);
        boolean b = festivo.esFestivo(17, 4);
        //String nuevaFecha = SumarTiempoFecha.sumarDiasCalendario(cal, 8);
        String nuevaFecha2 = SumarTiempoFecha.sumarDiasHabilesFecha(cal, 8);
    }
}
