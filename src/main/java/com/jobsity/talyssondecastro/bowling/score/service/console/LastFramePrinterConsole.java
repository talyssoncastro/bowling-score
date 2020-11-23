package com.jobsity.talyssondecastro.bowling.score.service.console;

import com.jobsity.talyssondecastro.bowling.score.config.SeparatorConfiguration;
import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.Shot;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by talyssoncastro on 23/11/2020 1:25 PM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LastFramePrinterConsole implements PrinterConsole {

    @NonNull
    private SeparatorConfiguration separatorConfiguration;

    @Override
    public String print(Frame frame) {
        StringBuilder sb = new StringBuilder();
        frame.getShots().forEach(s -> {
            sb.append(getRepresentation(s));
            sb.append(separatorConfiguration.get());
        });
//        sb.append(frame.hasAllShots() ? "X" : frame.shot1Optional().get().getRepresentation());
//        frame.shot1Optional().ifPresent( s -> {
//            sb.append(getRepresentation(s));
//            sb.append(separatorConfiguration.get());
//        });
//        sb.append(separatorConfiguration.get());
//        frame.shot2Optional().ifPresent( s -> {
//            sb.append(getRepresentation(s));
//            sb.append(separatorConfiguration.get());
//        });
//        frame.shot3Optional().ifPresent( s -> {
//            sb.append(getRepresentation(s));
//            sb.append(separatorConfiguration.get());
//        });
        return sb.toString();
    }

    private String getRepresentation(Shot shot) {
        return shot.getScore() == 10 ? "X" : shot.getRepresentation();
    }


}
