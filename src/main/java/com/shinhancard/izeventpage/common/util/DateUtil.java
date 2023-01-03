package com.shinhancard.izeventpage.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    static public String getDate(String format) {

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul")); // 한국시간
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return now.format(dtf);
    }

}
