package com.jobsity.talyssondecastro.bowling.score;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.FrameType;
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
public class FinalScore151Tests {

    @Autowired
    private PlayerService playerService;

    private Player john;

    @BeforeAll
    public void loadData() {
        john = new Player("John");
        // Shot 1
        john.addFrame(Frame.builder().shot1(3).shot2(7).build());
        // Shot 2
        john.addFrame(Frame.builder().shot1(6).shot2(3).build());
        // Shot 3
        john.addFrame(Frame.builder().shot1(10).build());
        // Shot 4
        john.addFrame(Frame.builder().shot1(8).shot2(1).build());
        // Shot 5
        john.addFrame(Frame.builder().shot1(10).build());
        // Shot 6
        john.addFrame(Frame.builder().shot1(10).build());
        // Shot 7
        john.addFrame(Frame.builder().shot1(9).shot2(0).build());
        // Shot 8
        john.addFrame(Frame.builder().shot1(7).shot2(3).build());
        // Shot 9
        john.addFrame(Frame.builder().shot1(4).shot2(4).build());
        // Shot 10
        john.addFrame(Frame.builder().frameType(FrameType.LAST).shot1(10).shot2(9).shot3(0).build());

        playerService.processScore(john);
    }

    @Test
    void should_accumulate_151() {
        Assertions.assertEquals(151, john.getFinalScore());
    }

    @Test
    void should_sum_16() {
        Assertions.assertEquals(16, playerService.getFrameSum(john.getFrames(), 0));
    }

    @Test
    void frame_1_should_accumulate_16() {
        Assertions.assertEquals(16, john.getFrames().get(0).getAmount());
    }

    @Test
    void frame_2_should_accumulate_25() {
        Assertions.assertEquals(25, john.getFrames().get(1).getAmount());
    }

    @Test
    void frame_3_should_accumulate_44() {
        Assertions.assertEquals(44, john.getFrames().get(2).getAmount());
    }

    @Test
    void frame_4_should_accumulate_53() {
        Assertions.assertEquals(53, john.getFrames().get(3).getAmount());
    }

    @Test
    void frame_5_should_accumulate_82() {
        Assertions.assertEquals(82, john.getFrames().get(4).getAmount());
    }

    @Test
    void frame_6_should_accumulate_101() {
        Assertions.assertEquals(101, john.getFrames().get(5).getAmount());
    }

    @Test
    void frame_7_should_accumulate_110() {
        Assertions.assertEquals(110, john.getFrames().get(6).getAmount());
    }

    @Test
    void frame_8_should_accumulate_124() {
        Assertions.assertEquals(124, john.getFrames().get(7).getAmount());
    }

    @Test
    void frame_9_should_accumulate_132() {
        Assertions.assertEquals(132, john.getFrames().get(8).getAmount());
    }

    @Test
    void frame_10_should_accumulate_151() {
        Assertions.assertEquals(151, john.getFrames().get(9).getAmount());
    }

}
