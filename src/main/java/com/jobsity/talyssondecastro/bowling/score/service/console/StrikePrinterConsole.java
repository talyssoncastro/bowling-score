package com.jobsity.talyssondecastro.bowling.score.service.console;

import com.jobsity.talyssondecastro.bowling.score.config.SeparatorConfiguration;
import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by talyssoncastro on 23/11/2020 1:24 PM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StrikePrinterConsole implements PrinterConsole {

    @NonNull
    private SeparatorConfiguration separatorConfiguration;

    @Override
    public String print(Frame frame) {
        return separatorConfiguration.get() + "X" + separatorConfiguration.get();
    }
}
