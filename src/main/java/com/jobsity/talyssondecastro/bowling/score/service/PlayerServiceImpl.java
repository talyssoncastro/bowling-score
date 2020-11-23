package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Player;
import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by talyssoncastro on 22/11/2020 9:11 PM.
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Override
    public void processScore(Player player) {

        Integer amount = 0;

        for (int i = 0; i < player.getFrames().size(); i++) {
            Frame frame = player.getFrames().get(i);

            Integer scoreToAdd = getFrameSum(player.getFrames(), i);

            amount += scoreToAdd;

            frame.setAmount(amount);

        }

        player.setFinalScore(amount);

    }

    @Override
    public Integer getFrameSum(List<Frame> frames, Integer index) {

        Frame frame = frames.get(index);

        int scoreToAdd = frame.getSumOfShots();
        int shotsLeft = frame.getShotResult().getNextShotToConsider();
        int nextShotScore = 0;
        int nextIndex = index + 1;
        for (int j = 0; j < frame.getShotResult().getNextShotToConsider() && shotsLeft > 0 && nextIndex < frames.size(); j++) {
            Frame nextFrame = frames.get(nextIndex);

            if (nextFrame.shot1Optional().isPresent()) {
                nextShotScore += nextFrame.getShot1();
                shotsLeft--;
            }

            if (nextFrame.shot2Optional().isPresent() && shotsLeft > 0) {
                nextShotScore += nextFrame.getShot2();
                shotsLeft--;
            }
            if (nextFrame.shot3Optional().isPresent() && shotsLeft > 0) {
                nextShotScore += nextFrame.getShot3();
                shotsLeft--;
            }

            if (shotsLeft > 0) {
                nextIndex++;
            }

        }

        scoreToAdd += nextShotScore;

        return scoreToAdd;

    }
}
