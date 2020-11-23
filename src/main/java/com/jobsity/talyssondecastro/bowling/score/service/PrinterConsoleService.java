package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.FrameType;
import com.jobsity.talyssondecastro.bowling.score.domain.ShotResult;
import com.jobsity.talyssondecastro.bowling.score.service.console.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by talyssoncastro on 23/11/2020 4:17 PM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PrinterConsoleService implements PrinterService {

    @NonNull
    private List<PrinterConsole> printersConsole;

    @Override
    public String getScoreToPrint(Frame frame) {

        PrinterConsole printerConsole;

        if (FrameType.LAST.equals(frame.getFrameType())) {
            printerConsole = getInstance(LastFramePrinterConsole.class);
        } else if (ShotResult.SPARE.equals(frame.getShotResult())) {
            printerConsole = getInstance(SparePrinterConsole.class);
        } else if (ShotResult.STRIKE.equals(frame.getShotResult())) {
            printerConsole = getInstance(StrikePrinterConsole.class);
        } else {
            printerConsole = getInstance(NormalPrinterConsole.class);
        }

        return printerConsole.print(frame);
    }

    private PrinterConsole getInstance(Class clazz) {
        for (PrinterConsole printerConsole: printersConsole) {
            if (clazz.equals(printerConsole.getClass())) {
                return printerConsole;
            }
        }

        return null;
    }

}
