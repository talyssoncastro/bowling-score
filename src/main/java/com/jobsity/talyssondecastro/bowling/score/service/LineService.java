package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.LineData;

/**
 * Created by talyssoncastro on 23/11/2020 12:49 AM.
 */
public interface LineService {

    LineData process(String line);

}
