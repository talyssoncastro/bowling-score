package com.jobsity.talyssondecastro.bowling.score.service.player;

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
 * Created by talyssoncastro on 22/11/2020 9:45 PM.
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FinalScore0Tests {

    @Autowired
    private PlayerService playerService;

    private Player zero;

    @BeforeAll
    public void loadData() {
        zero = new Player("Zero");
        // Shot 1
        zero.addFrame(Frame.builder().shot1(0).build());
        // Shot 2
        zero.addFrame(Frame.builder().shot1(0).build());
        // Shot 3
        zero.addFrame(Frame.builder().shot1(0).build());
        // Shot 4
        zero.addFrame(Frame.builder().shot1(0).build());
        // Shot 5
        zero.addFrame(Frame.builder().shot1(0).build());
        // Shot 6
        zero.addFrame(Frame.builder().shot1(0).build());
        // Shot 7
        zero.addFrame(Frame.builder().shot1(0).build());
        // Shot 8
        zero.addFrame(Frame.builder().shot1(0).build());
        // Shot 9
        zero.addFrame(Frame.builder().shot1(0).build());
        // Shot 10
        zero.addFrame(Frame.builder().shot1(0).build());

        playerService.processScore(zero);
    }

    @Test
    void should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFinalScore());
    }

    @Test
    void should_sum_0() {
        Assertions.assertEquals(0, playerService.getFrameSum(zero.getFrames(), 0));
    }

    @Test
    void frame_1_should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFrames().get(0).getAmount());
    }

    @Test
    void frame_2_should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFrames().get(1).getAmount());
    }

    @Test
    void frame_3_should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFrames().get(2).getAmount());
    }

    @Test
    void frame_4_should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFrames().get(3).getAmount());
    }

    @Test
    void frame_5_should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFrames().get(4).getAmount());
    }

    @Test
    void frame_6_should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFrames().get(5).getAmount());
    }

    @Test
    void frame_7_should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFrames().get(6).getAmount());
    }

    @Test
    void frame_8_should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFrames().get(7).getAmount());
    }

    @Test
    void frame_9_should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFrames().get(8).getAmount());
    }

    @Test
    void frame_10_should_accumulate_0() {
        Assertions.assertEquals(0, zero.getFrames().get(9).getAmount());
    }

}
