package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.FrameType;
import com.jobsity.talyssondecastro.bowling.score.domain.Shot;
import com.jobsity.talyssondecastro.bowling.score.exception.InvalidScoreException;
import com.jobsity.talyssondecastro.bowling.score.exception.MaximumItemsReachedException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by talyssoncastro on 23/11/2020 9:34 AM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FrameServiceImpl implements FrameService {

    @Override
    public void addShot(Frame frame, Shot shot) throws InvalidScoreException, MaximumItemsReachedException {

        if (isMaximumShotsReached(frame)) {
            throw new MaximumItemsReachedException("Maximum scores reached");
        }

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Shot>> violations = validator.validate(shot);

        for (ConstraintViolation<Shot> violation : violations) {
            throw new InvalidScoreException(violation.getMessage());
        }

        frame.addShot(shot);

    }

    @Override
    public Frame createFrame(Shot shot, FrameType frameType) {

        Frame newFrame = Frame.builder().frameType(frameType).shot1(shot).build();

        return newFrame;
    }

    private boolean isMaximumShotsReached(Frame frame) {
        return frame.getShots().size() >= frame.getFrameType().getMaxShots();
    }

}
