package com.jobsity.talyssondecastro.bowling.score.ui;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;

/**
 * Created by talyssoncastro on 23/11/2020 1:24 PM.
 */
public class SparePrinterService implements PrinterService {

    @Override
    public String print(Frame frame) {
        return frame.shot1Optional().get().getRepresentation() + "\t/\t";
    }
}
