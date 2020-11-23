package com.jobsity.talyssondecastro.bowling.score.service.score;

import com.jobsity.talyssondecastro.bowling.score.service.ScoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by talyssoncastro on 23/11/2020 5:31 PM.
 */
@SpringBootTest
public class ScoreServiceTests {

    @Autowired
    private ScoreService scoreService;

    @Test
    void should_return_0() {
        Integer result = scoreService.getScoreByInput("F");

        Assertions.assertEquals(0, result);
    }

    @Test
    void should_return_10() {
        Integer result = scoreService.getScoreByInput("X");

        Assertions.assertEquals(10, result);
    }

    @Test
    void should_return_5() {
        Integer result = scoreService.getScoreByInput("5");

        Assertions.assertEquals(5, result);
    }

    @Test
    void should_return_00() {
        Integer result = scoreService.getScoreByInput("Test");

        Assertions.assertEquals(0, result);
    }

}
