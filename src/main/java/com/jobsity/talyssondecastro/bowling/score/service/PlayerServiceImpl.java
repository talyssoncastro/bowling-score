package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.FrameType;
import com.jobsity.talyssondecastro.bowling.score.domain.Player;
import com.jobsity.talyssondecastro.bowling.score.domain.Shot;
import com.jobsity.talyssondecastro.bowling.score.exception.InvalidScoreException;
import com.jobsity.talyssondecastro.bowling.score.exception.MaximumItemsReachedException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by talyssoncastro on 22/11/2020 9:11 PM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlayerServiceImpl implements PlayerService {

    private static final Integer MAX_FRAMES = 10;

    @NonNull
    private FrameService frameService;

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

        int scoreToAdd = frame.getScoreSum();
        int shotsLeft = frame.getShotResult().getNextShotToConsider();
        int nextShotScore = 0;
        int nextIndex = index + 1;
        for (int j = 0; j < frame.getShotResult().getNextShotToConsider() && shotsLeft > 0 && nextIndex < frames.size(); j++) {
            Frame nextFrame = frames.get(nextIndex);

            Optional<Shot> shot1 = nextFrame.shot1Optional();
            if (shot1.isPresent()) {
                nextShotScore += shot1.get().getScore();
                shotsLeft--;
            }

            Optional<Shot> shot2 = nextFrame.shot2Optional();
            if (nextFrame.shot2Optional().isPresent() && shotsLeft > 0) {
                nextShotScore += shot2.get().getScore();

                shotsLeft--;
            }

            Optional<Shot> shot3 = nextFrame.shot3Optional();
            if (nextFrame.shot3Optional().isPresent() && shotsLeft > 0) {
                nextShotScore += shot3.get().getScore();
                shotsLeft--;
            }

            if (shotsLeft > 0) {
                nextIndex++;
            }

        }

        scoreToAdd += nextShotScore;

        return scoreToAdd;

    }

    @Override
    public void addShot(Player player, Shot shot, Boolean isNewFrame) throws InvalidScoreException, MaximumItemsReachedException {

        if (isNewFrame) {
            addNewFrame(player, shot);
        } else {
            frameService.addShot(player.lastFrame(), shot);
        }
    }

    @Override
    public Boolean isFrameFinished(Frame frame) {
        return frameService.isFrameFinished(frame);
    }

    private void addNewFrame(Player player, Shot shot) throws MaximumItemsReachedException {

        if (isMaximumFramesReached(player)) {
            throw new MaximumItemsReachedException("Maximum frames reached");
        }

        Frame createdFrame = frameService.createFrame(shot, isLastButOne(player) ? FrameType.LAST : FrameType.NORMAL);
        player.addFrame(createdFrame);

    }

    private Boolean isMaximumFramesReached(Player player) {
        return player != null && player.getFrames() != null && player.getFrames().size() == MAX_FRAMES;
    }

    private Boolean isLastButOne(Player player) {
        return player != null && player.getFrames() != null && player.getFrames().size() == MAX_FRAMES - 1;
    }

}
