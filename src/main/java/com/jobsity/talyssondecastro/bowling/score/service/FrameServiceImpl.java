package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.FrameType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by talyssoncastro on 23/11/2020 9:34 AM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FrameServiceImpl implements FrameService {

    @Override
    public void addShot(Frame frame, Integer score) {

        if (isMaximumShotsReached(frame)) {
            throw new RuntimeException("Maximum scores reached");
        }

        frame.addShot(score);

    }

    @Override
    public Frame createFrame(Integer score, FrameType frameType) {

        Frame newFrame = Frame.builder().frameType(frameType).shot1(score).build();

        return newFrame;
    }

    private boolean isMaximumShotsReached(Frame frame) {
        return frame.getShots().size() >= frame.getFrameType().getMaxShots();
    }

}
