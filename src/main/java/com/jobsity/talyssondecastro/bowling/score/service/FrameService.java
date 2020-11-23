package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.FrameType;
import com.jobsity.talyssondecastro.bowling.score.domain.Shot;
import com.jobsity.talyssondecastro.bowling.score.exception.InvalidScoreException;
import com.jobsity.talyssondecastro.bowling.score.exception.MaximumItemsReachedException;

/**
 * Created by talyssoncastro on 23/11/2020 9:34 AM.
 */
public interface FrameService {

    void addShot(Frame frame, Shot shot) throws InvalidScoreException, MaximumItemsReachedException;

    Frame createFrame(Shot shot, FrameType frameType);

}
