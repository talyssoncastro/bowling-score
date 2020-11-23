package com.jobsity.talyssondecastro.bowling.score.service.console;

import com.jobsity.talyssondecastro.bowling.score.config.SeparatorConfiguration;
import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by talyssoncastro on 23/11/2020 2:41 PM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NormalPrinterConsole implements PrinterConsole {

    @NonNull
    private SeparatorConfiguration separatorConfiguration;

    @Override
    public String print(Frame frame) {
        return frame.shot1Optional().get().getRepresentation() +
                separatorConfiguration.get() +
                frame.shot2Optional().get().getRepresentation() +
                separatorConfiguration.get();
    }

}
