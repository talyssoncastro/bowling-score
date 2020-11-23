package com.jobsity.talyssondecastro.bowling.score.service.frame;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.Shot;
import com.jobsity.talyssondecastro.bowling.score.exception.InvalidScoreException;
import com.jobsity.talyssondecastro.bowling.score.exception.MaximumItemsReachedException;
import com.jobsity.talyssondecastro.bowling.score.service.FrameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by talyssoncastro on 23/11/2020 5:35 PM.
 */
@SpringBootTest
public class FrameServiceTests {

    @Autowired
    private FrameService frameService;

    @Test
    void should_throw_exception_with_less_score() {

        Frame frame = Frame.builder().shot1(1).build();

        Exception exception = Assertions.assertThrows(InvalidScoreException.class, () -> {
            frameService.addShot(frame, Shot.builder().score(-5).build());
        });
    }

    @Test
    void should_throw_exception_with_greater_score() {

        Frame frame = Frame.builder().shot1(1).build();

        Exception exception = Assertions.assertThrows(InvalidScoreException.class, () -> {
            frameService.addShot(frame, Shot.builder().score(20).build());
        });
    }

    @Test
    void should_throw_exception_with_max_items() throws InvalidScoreException, MaximumItemsReachedException {

        Frame frame = Frame.builder().build();
        for (int i = 0; i < 2; i++) {
            frameService.addShot(frame, Shot.builder().score(5).build());
        }

        Exception exception = Assertions.assertThrows(MaximumItemsReachedException.class, () -> {
            frameService.addShot(frame, Shot.builder().score(3).build());
        });
    }

}
