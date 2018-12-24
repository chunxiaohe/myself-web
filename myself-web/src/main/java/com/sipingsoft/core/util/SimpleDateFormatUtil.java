package com.sipingsoft.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 日期格式 工具类
 * @author HeChunXiao
 * @since 2018-12-24 10:22
 */
public class SimpleDateFormatUtil {


    /**
     * Date 按照给定的格式转换成字符串
     * @param date
     * @param forMatter
     * @return
     */
    public static String dateToString(Date date, String forMatter){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(forMatter);
        return simpleDateFormat.format(date);
    }

    /**
     * String 按照给定的个数转换成日期
     * @param date
     * @param forMatter
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String date,String forMatter) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(forMatter);
        return simpleDateFormat.parse(date);
    }

}
