package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.FrameType;
import com.jobsity.talyssondecastro.bowling.score.domain.ShotResult;
import com.jobsity.talyssondecastro.bowling.score.service.console.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by talyssoncastro on 23/11/2020 4:17 PM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PrinterConsoleService implements PrinterService {

    @Override
    public String getScoreToPrint(Frame frame) {

        PrinterConsole printerConsole;

        if (FrameType.LAST.equals(frame.getFrameType())) {
            printerConsole = new LastFramePrinterConsole();
        } else if (ShotResult.SPARE.equals(frame.getShotResult())) {
            printerConsole = new SparePrinterConsole();
        } else if (ShotResult.STRIKE.equals(frame.getShotResult())) {
            printerConsole = new StrikePrinterConsole();
        } else {
            printerConsole = new NormalPrinterConsole();
        }

        return printerConsole.print(frame);
    }

}
