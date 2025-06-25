package com.tenco.blog.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.util.Date;

public class MyDateUtil {

    public static String timestampFormat(Timestamp time){
        // Board 엔티티에 선언된 Timestamp를 Date 객체로 변화
        Date currentData = new Date(time.getTime());
        return DateFormatUtils.format(currentData,"yyyy-MM-dd HH:MM");
    }
}
