package com.research.ovi.springwebsocketserver.util;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;


import java.util.Locale;

public class MomentUtil {

    private MomentUtil() {
    }

    public static String calendar(DateTime dt) {
        StringBuilder sb = new StringBuilder();

        // check difference in days from today, considering just the date (ignoring the hours)
        int days = Days.daysBetween(new LocalDate(), dt.toLocalDate()).getDays();
        if (days == 0) { // today
            sb.append("Today ");
        } else if (days == 1) { // tomorrow
            sb.append("Tomorrow ");
        } else if (days == -1) { // yesterday
            sb.append("Yesterday ");
        } else if (days > 0 && days < 7) { // next week
            sb.append(dt.dayOfWeek().getAsText(Locale.ENGLISH)).append(" ");
        } else if (days < 0 && days > -7) { // last week
            sb.append("Last ").append(dt.dayOfWeek().getAsText(Locale.ENGLISH)).append(" ");
        }

        if (Math.abs(days) < 7) { // difference is less than a week, append current time
            sb.append("at ").append(dt.toString("h:mm a", Locale.ENGLISH));
        } else { // more than a week of difference
            sb.append(dt.toString("M/d/yyyy"));
        }

        return sb.toString();
    }
}
