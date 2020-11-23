package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;

/**
 * Created by talyssoncastro on 23/11/2020 8:49 AM.
 */
public interface ScoreService {

    Integer getScoreByInput(String value);

    String getScoreToPrint(Frame frame);

}
