import org.joda.time.DateTime;
import java.util.*;
import java.time.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GetTime {

    public String departureTime;

    public static double convertToDouble(String departureTime){

        for(int i =0; i<departureTime.length(); i++){
            if(departureTime.charAt(i)==':') {
                departureTime = departureTime.substring(0, i) +'.'+departureTime.substring(i+1);
            }
        }

        return Double.parseDouble(departureTime);

    }

    public static boolean istimeGood(Double departureTime){

        boolean flag = false;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH.mm");
        DateTime dt = new DateTime();
        int hour = dt.getHourOfDay();

        if((departureTime-hour)<1.0)
            flag = false;
        else if((departureTime-hour)>1.0)
            flag = true;

        return flag;

    }

}
