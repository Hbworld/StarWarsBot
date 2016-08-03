package hbworld.com.starwarsbot.utils;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Hbworld_new on 8/3/2016.
 */
public class AppUtil {

    public String getDate(String createdOn) {

        String date = null;
        Date date2 = null;
        int iend = createdOn.indexOf("T");

        if (iend != -1) {
            date = createdOn.substring(0, iend);
        }
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat targetFormat = new SimpleDateFormat("dd MMM yyyy",Locale.ENGLISH);
        try {
            date2 = originalFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = targetFormat.format(date2);
        return formattedDate;
    }
}
