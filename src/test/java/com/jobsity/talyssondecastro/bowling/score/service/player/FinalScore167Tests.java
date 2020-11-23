package com.jobsity.talyssondecastro.bowling.score.service.player;

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
 * Created by talyssoncastro on 22/11/2020 9:53 PM.
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FinalScore167Tests {

    @Autowired
    private PlayerService playerService;

    private Player jeff;

    @BeforeAll
    public void loadData() {
        jeff = new Player("Jeff");
        // Shot 1
        jeff.addFrame(Frame.builder().shot1(10).build());
        // Shot 2
        jeff.addFrame(Frame.builder().shot1(7).shot2(3).build());
        // Shot 3
        jeff.addFrame(Frame.builder().shot1(9).shot2(0).build());
        // Shot 4
        jeff.addFrame(Frame.builder().shot1(10).build());
        // Shot 5
        jeff.addFrame(Frame.builder().shot1(0).shot2(8).build());
        // Shot 6
        jeff.addFrame(Frame.builder().shot1(8).shot2(2).build());
        // Shot 7
        jeff.addFrame(Frame.builder().shot1(0).shot2(6).build());
        // Shot 8
        jeff.addFrame(Frame.builder().shot1(10).build());
        // Shot 9
        jeff.addFrame(Frame.builder().shot1(10).build());
        // Shot 10
        jeff.addFrame(Frame.builder().frameType(FrameType.LAST).shot1(10).shot2(8).shot3(1).build());

        playerService.processScore(jeff);
    }

    @Test
    void should_accumulate_167() {
        Assertions.assertEquals(167, jeff.getFinalScore());
    }

    @Test
    void should_sum_20() {
        Assertions.assertEquals(20, playerService.getFrameSum(jeff.getFrames(), 0));
    }

    @Test
    void frame_1_should_accumulate_20() {
        Assertions.assertEquals(20, jeff.getFrames().get(0).getAmount());
    }

    @Test
    void frame_2_should_accumulate_39() {
        Assertions.assertEquals(39, jeff.getFrames().get(1).getAmount());
    }

    @Test
    void frame_3_should_accumulate_48() {
        Assertions.assertEquals(48, jeff.getFrames().get(2).getAmount());
    }

    @Test
    void frame_4_should_accumulate_66() {
        Assertions.assertEquals(66, jeff.getFrames().get(3).getAmount());
    }

    @Test
    void frame_5_should_accumulate_74() {
        Assertions.assertEquals(74, jeff.getFrames().get(4).getAmount());
    }

    @Test
    void frame_6_should_accumulate_84() {
        Assertions.assertEquals(84, jeff.getFrames().get(5).getAmount());
    }

    @Test
    void frame_7_should_accumulate_90() {
        Assertions.assertEquals(90, jeff.getFrames().get(6).getAmount());
    }

    @Test
    void frame_8_should_accumulate_120() {
        Assertions.assertEquals(120, jeff.getFrames().get(7).getAmount());
    }

    @Test
    void frame_9_should_accumulate_148() {
        Assertions.assertEquals(148, jeff.getFrames().get(8).getAmount());
    }

    @Test
    void frame_10_should_accumulate_167() {
        Assertions.assertEquals(167, jeff.getFrames().get(9).getAmount());
    }

}
