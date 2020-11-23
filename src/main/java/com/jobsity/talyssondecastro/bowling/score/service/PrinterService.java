package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;

/**
 * Created by talyssoncastro on 23/11/2020 4:16 PM.
 */
public interface PrinterService {

    String getScoreToPrint(Frame frame);

}
