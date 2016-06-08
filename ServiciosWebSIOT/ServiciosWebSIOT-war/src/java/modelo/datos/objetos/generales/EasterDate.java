package modelo.datos.objetos.generales;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;


public class  EasterDate
{
    public void main()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d E");
        Date d;
        for (int year = 0; year < 2120 ;year++ )
        {
            //System.out.println(calcEasterDate(year));
            d = getEasterDate(year);
            System.out.println(sdf.format(d));
        }
    }
 
    public Date getEasterDate(int year)
    {
        int C, G, H, I, J, L, EasterMonth, EasterDay;
        G = year%19 ;
 
        I = (19*G + 15) % 30 ;
        J = (year + (year/ 4) + I) % 7 ;
 
        C = year/ 100;
        H = (C - C/4 - ((8*C+13)/ 25) + 19*G + 15) % 30 ;
        I = H - (H / 28) * (1 - (H/28) * (29/(H+1)) * ((21-G)/11) ) ;
        J = (year + (year/ 4) + I + 2 - C + C/4) % 7 ;
 
        L = I - J ;
        EasterMonth = 3 + ((L + 40) / 44) ;
        EasterDay = L + 28 - 31 * (EasterMonth/ 4) ;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, EasterDay);
        cal.set(Calendar.MONTH, EasterMonth-1);
        cal.set(Calendar.YEAR, year);
 
        return cal.getTime();
    }
 
}
