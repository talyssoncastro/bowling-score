package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Game;
import com.jobsity.talyssondecastro.bowling.score.domain.Player;
import org.springframework.stereotype.Service;

/**
 * Created by talyssoncastro on 22/11/2020 6:36 PM.
 */
@Service
public class GameServiceImpl implements GameService {

    @Override
    public void calculateScore(Player player) {



    }

    @Override
    public Player winnner(Game game) {

        game.getPlayers().forEach( p -> calculateScore(p));

        return null;
    }
}
