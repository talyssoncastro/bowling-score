package com.jobsity.talyssondecastro.bowling.score.service.console;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;

/**
 * Created by talyssoncastro on 23/11/2020 1:24 PM.
 */
public class StrikePrinterConsole implements PrinterConsole {

    @Override
    public String print(Frame frame) {
        return "\tX\t";
    }
}
