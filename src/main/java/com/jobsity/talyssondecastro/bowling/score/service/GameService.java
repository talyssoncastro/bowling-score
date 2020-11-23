package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Game;
import com.jobsity.talyssondecastro.bowling.score.domain.Player;

/**
 * Created by talyssoncastro on 22/11/2020 6:35 PM.
 */
public interface GameService {

    void calculate(Game game);

    void addShot(Player player, Integer score, Boolean isNewFrame);

}
