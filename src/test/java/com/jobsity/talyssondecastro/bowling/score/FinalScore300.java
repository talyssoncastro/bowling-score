package com.jobsity.talyssondecastro.bowling.score;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.Player;
import com.jobsity.talyssondecastro.bowling.score.service.PlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by talyssoncastro on 22/11/2020 9:30 PM.
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FinalScore300 {

    @Autowired
    private PlayerService playerService;

    private Player carl;

    @BeforeAll
    public void loadData() {
        carl = new Player("Carl");
        // Shot 1
        carl.addScore(Frame.builder().shot1(10).build());
        // Shot 2
        carl.addScore(Frame.builder().shot1(10).build());
        // Shot 3
        carl.addScore(Frame.builder().shot1(10).build());
        // Shot 4
        carl.addScore(Frame.builder().shot1(10).build());
        // Shot 5
        carl.addScore(Frame.builder().shot1(10).build());
        // Shot 6
        carl.addScore(Frame.builder().shot1(10).build());
        // Shot 7
        carl.addScore(Frame.builder().shot1(10).build());
        // Shot 8
        carl.addScore(Frame.builder().shot1(10).build());
        // Shot 9
        carl.addScore(Frame.builder().shot1(10).build());
        // Shot 10
        carl.addScore(Frame.builder().shot1(10).shot2(10).shot3(10).build());

        playerService.processScore(carl);
    }

    @Test
    void should_accumulate_300() {
        Assertions.assertEquals(300, carl.getFinalScore());
    }

    @Test
    void should_sum_30() {
        Assertions.assertEquals(30, playerService.getFrameSum(carl.getFrames(), 0));
    }

    @Test
    void frame_1_should_accumulate_30() {
        Assertions.assertEquals(30, carl.getFrames().get(0).getAmount());
    }

    @Test
    void frame_2_should_accumulate_60() {
        Assertions.assertEquals(60, carl.getFrames().get(1).getAmount());
    }

    @Test
    void frame_3_should_accumulate_90() {
        Assertions.assertEquals(90, carl.getFrames().get(2).getAmount());
    }

    @Test
    void frame_4_should_accumulate_90() {
        Assertions.assertEquals(120, carl.getFrames().get(3).getAmount());
    }

    @Test
    void frame_5_should_accumulate_90() {
        Assertions.assertEquals(150, carl.getFrames().get(4).getAmount());
    }

    @Test
    void frame_6_should_accumulate_90() {
        Assertions.assertEquals(180, carl.getFrames().get(5).getAmount());
    }

    @Test
    void frame_7_should_accumulate_90() {
        Assertions.assertEquals(210, carl.getFrames().get(6).getAmount());
    }

    @Test
    void frame_8_should_accumulate_240() {
        Assertions.assertEquals(240, carl.getFrames().get(7).getAmount());
    }

    @Test
    void frame_9_should_accumulate_270() {
        Assertions.assertEquals(270, carl.getFrames().get(8).getAmount());
    }

    @Test
    void frame_10_should_accumulate_300() {
        Assertions.assertEquals(300, carl.getFrames().get(9).getAmount());
    }

}
