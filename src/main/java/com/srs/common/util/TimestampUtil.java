package com.srs.common.util;

import org.flywaydb.core.internal.util.StringUtils;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author duynt on 3/30/22
 */
public class TimestampUtil {
    public static final ZoneId DEFAULT_ZONE = ZoneId.of("Asia/Manila");
    public static final ZoneOffset DEFAULT_OFFSET = ZoneOffset.of("+08:00");

    public static OffsetDateTime parseDatetimeString(String datetime) {
        return OffsetDateTime.parse(datetime);
    }

    public static OffsetTime parseTimeString(String time) {
        return OffsetTime.parse(time).withSecond(0);
    }

    public static String stringifyDatetime(OffsetDateTime datetime, boolean includeTime) {
        if (datetime == null) {
            return "";
        }

        if (includeTime) {
            var offset = datetime.getOffset().toString().equals("Z")
                    ? "+00:00" : datetime.getOffset().toString();

            return String.format("%s-%s-%sT%s:%s:%s",
                    datetime.getYear(),
                    StringUtils.leftPad(String.valueOf(datetime.getMonthValue()), 2, '0'),
                    StringUtils.leftPad(String.valueOf(datetime.getDayOfMonth()), 2, '0'),
                    StringUtils.leftPad(String.valueOf(datetime.getHour()), 2, '0'),
                    StringUtils.leftPad(String.valueOf(datetime.getMinute()), 2, '0'),
                    StringUtils.leftPad(String.valueOf(datetime.getSecond()), 2, '0') + offset);
        } else {
            return String.format("%s-%s-%s",
                    datetime.getYear(),
                    StringUtils.leftPad(String.valueOf(datetime.getMonthValue()), 2, '0'),
                    StringUtils.leftPad(String.valueOf(datetime.getDayOfMonth()), 2, '0'));
        }
    }

    public static String stringifyTime(OffsetTime time) {
        if (time == null) {
            return "";
        }

        var offset = time.getOffset().toString().equals("Z")
                ? "+00:00" : time.getOffset().toString();

        return String.format("%s:%s:%s",
                StringUtils.leftPad(String.valueOf(time.getHour()), 2, '0'),
                StringUtils.leftPad(String.valueOf(time.getMinute()), 2, '0'),
                StringUtils.leftPad(String.valueOf(time.getSecond()), 2, '0')) + offset;
    }

    public static OffsetDateTime now() {
        return OffsetDateTime.now().withNano(0).withOffsetSameInstant(DEFAULT_OFFSET);
    }

    public static OffsetDateTime nowAtDefaultTimezone() {
        return OffsetDateTime.now().withNano(0);
    }

    public static OffsetDateTime beginningOfDate(OffsetDateTime date) {
        return date.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static OffsetDateTime endOfDate(OffsetDateTime date) {
        return date.withHour(23).withMinute(59).withSecond(59).withNano(0);
    }

    public static boolean isBetween(OffsetDateTime theDate, OffsetDateTime lower, OffsetDateTime upper) {
        return (theDate.isAfter(lower) || theDate.isEqual(lower)) && theDate.isBefore(upper);
    }

    public static OffsetDateTime endOfToday() {
        return endOfDate(now());
    }

    public static OffsetDateTime beginningOfToday() {
        return beginningOfDate(now());
    }

    public static OffsetDateTime getFirstDayOfQuarter(OffsetDateTime date) {
        var month = date.getMonthValue();
        int quarter = (int) Math.ceil(month / 3.0f);

        return beginningOfDate(date
                .withMonth(1 + (quarter - 1) * 3)
                .withDayOfMonth(1))
                .withOffsetSameLocal(TimestampUtil.DEFAULT_OFFSET);
    }

    public static OffsetDateTime getLastDayOfQuarter(OffsetDateTime date) {
        var month = date.getMonthValue();
        var quarter = (int) Math.ceil(month / 3.0f);

        var lastDate = date.withMonth((3 * quarter + 1) % 12)
                .withDayOfMonth(1)
                .minusDays(1)
                .plusYears(quarter == 4 ? 1 : 0);

        return endOfDate(lastDate.withOffsetSameLocal(TimestampUtil.DEFAULT_OFFSET));
    }

    public static OffsetDateTime timeStampToOffsetDateTime(Timestamp timestamp) {
        return OffsetDateTime.ofInstant(timestamp.toInstant(), ZoneId.of("UTC"));
    }

}
