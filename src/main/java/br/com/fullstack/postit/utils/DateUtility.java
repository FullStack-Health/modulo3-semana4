package br.com.fullstack.postit.utils;

import java.time.LocalDateTime;

public class DateUtility {

    private DateUtility() {}

    public static LocalDateTime lastHourOfTheDay(LocalDateTime dateTime) {
        return dateTime.withHour(23).withMinute(59).withSecond(59);
    }
}
