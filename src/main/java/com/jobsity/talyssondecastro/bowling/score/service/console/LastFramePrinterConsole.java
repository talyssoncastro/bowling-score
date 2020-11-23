package com.jobsity.talyssondecastro.bowling.score.service.console;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;

/**
 * Created by talyssoncastro on 23/11/2020 1:25 PM.
 */
public class LastFramePrinterConsole implements PrinterConsole {

    @Override
    public String print(Frame frame) {
        Boolean hasAllShots = frame.shot1Optional().isPresent() && frame.shot2Optional().isPresent() && frame.shot3Optional().isPresent();
        StringBuilder sb = new StringBuilder();
        sb.append(hasAllShots ? "X" : frame.shot1Optional().get().getRepresentation());
        sb.append("\t");
        frame.shot2Optional().ifPresent( s ->
            sb.append(frame.shot2Optional().get().getRepresentation() + "\t")
        );
        frame.shot3Optional().ifPresent( s ->
            sb.append(frame.shot3Optional().get().getRepresentation() + "\t")
        );
        return sb.toString();
    }
}
