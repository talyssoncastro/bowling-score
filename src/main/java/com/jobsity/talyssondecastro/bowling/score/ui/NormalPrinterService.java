package com.jobsity.talyssondecastro.bowling.score.ui;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;

/**
 * Created by talyssoncastro on 23/11/2020 2:41 PM.
 */
public class NormalPrinterService implements PrinterService {

    @Override
    public String print(Frame frame) {
        return frame.shot1Optional().get().getRepresentation() + "\t" + frame.shot2Optional().get().getRepresentation() + "\t";
    }

}
