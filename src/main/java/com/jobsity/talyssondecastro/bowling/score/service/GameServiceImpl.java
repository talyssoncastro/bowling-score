package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Game;
import com.jobsity.talyssondecastro.bowling.score.domain.Player;
import com.jobsity.talyssondecastro.bowling.score.domain.Shot;
import com.jobsity.talyssondecastro.bowling.score.exception.InvalidScoreException;
import com.jobsity.talyssondecastro.bowling.score.exception.MaximumItemsReachedException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by talyssoncastro on 22/11/2020 6:36 PM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameServiceImpl implements GameService {

    @NonNull
    private PlayerService playerService;

    @Override
    public void calculate(Game game) {
        game.getPlayers().values().stream().collect(Collectors.toList()).forEach(p -> playerService.processScore(p));
    }

    @Override
    public void addShot(Player player, Shot shot, Boolean isNewFrame) throws InvalidScoreException, MaximumItemsReachedException {
        playerService.addShot(player, shot, isNewFrame);
    }
}
