package com.jobsity.talyssondecastro.bowling.score.utils;

/**
 * Created by talyssoncastro on 22/11/2020 11:29 PM.
 */
public class IntegerUtils {

    public static int parseWithDefault(String s, int defaultVal) {
        return s.matches("-?\\d+") ? Integer.parseInt(s) : defaultVal;
    }

}
