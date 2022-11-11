package com.srs.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author duynt on 3/30/22
 */
public class NumericUtil {
    private static final DecimalFormat dFormatter = new DecimalFormat("#.##");

    static {
        dFormatter.setRoundingMode(RoundingMode.HALF_UP);
        dFormatter.setMinimumFractionDigits(2);
        dFormatter.setMaximumFractionDigits(2);
    }

    public static double sanitize(double number) {
        return Double.parseDouble(dFormatter.format(number));
    }

    public static String sanitizeAsString(double number) {
        return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP).toString();
    }

    public static void main(String[] args) {
        System.out.println(dFormatter.format(2.1));
        System.out.println(sanitize(2.1));
        System.out.println(sanitizeAsString(2.1));
        System.out.println(sanitizeAsString(2.166));
    }
}
