package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Player;
import com.jobsity.talyssondecastro.bowling.score.domain.Frame;

import java.util.List;

/**
 * Created by talyssoncastro on 22/11/2020 9:11 PM.
 */
public interface PlayerService {

    void processScore(Player player);

    Integer getFrameSum(List<Frame> frames, Integer index);

}
