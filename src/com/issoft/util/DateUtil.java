package com.issoft.util;

import com.issoft.exception.BusinessException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

    private static final String TIME_ZONE = "GMT";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-dd");

    static {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
    }

    public static Date getDate(final String data) {
        try {
            return simpleDateFormat.parse(data);
        } catch (ParseException ex) {
            throw new BusinessException("Could not extract date", ex);
        }
    }

    public static String getString(final Date date) {
        return simpleDateFormat.format(date);
    }
}
