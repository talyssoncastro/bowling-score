package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.FrameType;

/**
 * Created by talyssoncastro on 23/11/2020 9:34 AM.
 */
public interface FrameService {

    void addShot(Frame frame, Integer score);

    Frame createFrame(Integer score, FrameType frameType);

}
