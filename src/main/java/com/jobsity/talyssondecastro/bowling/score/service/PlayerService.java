package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.Player;
import com.jobsity.talyssondecastro.bowling.score.domain.Shot;
import com.jobsity.talyssondecastro.bowling.score.exception.InvalidScoreException;
import com.jobsity.talyssondecastro.bowling.score.exception.MaximumItemsReachedException;

import java.util.List;

/**
 * Created by talyssoncastro on 22/11/2020 9:11 PM.
 */
public interface PlayerService {

    void processScore(Player player);

    Integer getFrameSum(List<Frame> frames, Integer index);

    void addShot(Player player, Shot shot, Boolean isNewFrame) throws InvalidScoreException, MaximumItemsReachedException;

    Boolean isFrameFinished(Frame frame);

}
