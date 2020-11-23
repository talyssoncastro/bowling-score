package com.jobsity.talyssondecastro.bowling.score;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.domain.Game;
import com.jobsity.talyssondecastro.bowling.score.domain.Player;
import com.jobsity.talyssondecastro.bowling.score.service.GameService;
import com.jobsity.talyssondecastro.bowling.score.service.PlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class BowlingFrameApplicationTests {

	@Autowired
	private GameService gameService;

	@Autowired
	private PlayerService playerService;

	@Test
	void contextLoads() {
	}

	@Test
	void demo1() {
		Player jeff = new Player("Jeff");
		Player john = new Player("John");

		// Shot 1
		jeff.addScore(Frame.builder().shot1(10).build());
		john.addScore(Frame.builder().shot1(3).shot2(7).build());

		// Shot 2
		jeff.addScore(Frame.builder().shot1(7).shot2(3).build());
		john.addScore(Frame.builder().shot1(6).shot2(3).build());

		// Shot 3
		jeff.addScore(Frame.builder().shot1(9).shot2(0).build());
		john.addScore(Frame.builder().shot1(10).build());

		// Shot 4
		jeff.addScore(Frame.builder().shot1(10).build());
		john.addScore(Frame.builder().shot1(8).shot2(1).build());

		// Shot 5
		jeff.addScore(Frame.builder().shot1(0).shot2(8).build());
		john.addScore(Frame.builder().shot1(10).build());

		// Shot 6
		jeff.addScore(Frame.builder().shot1(8).shot2(2).build());
		john.addScore(Frame.builder().shot1(10).build());

		// Shot 7
		jeff.addScore(Frame.builder().shot1(0).shot2(6).build());
		john.addScore(Frame.builder().shot1(9).shot2(0).build());

		// Shot 8
		jeff.addScore(Frame.builder().shot1(10).build());
		john.addScore(Frame.builder().shot1(7).shot2(3).build());

		// Shot 9
		jeff.addScore(Frame.builder().shot1(10).build());
		john.addScore(Frame.builder().shot1(4).shot2(4).build());

		// Shot 10
		jeff.addScore(Frame.builder().shot1(10).shot2(8).shot3(1).build());
		john.addScore(Frame.builder().shot1(10).shot2(9).shot3(0).build());

		Game game = new Game(Arrays.asList(jeff, john));

		playerService.processScore(jeff);
		playerService.processScore(john);

		Assertions.assertEquals(167, jeff.getFinalScore());
		Assertions.assertEquals(151, john.getFinalScore());

	}

	@Test
	void should_accumulate_300() {

		Player carl = new Player("Carl");
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

		Assertions.assertEquals(300, carl.getFinalScore());

	}

	@Test
	void should_acummulate_0() {

		Player zero = new Player("Zero");

		// Shot 1
		zero.addScore(Frame.builder().shot1(0).build());
		// Shot 2
		zero.addScore(Frame.builder().shot1(0).build());
		// Shot 3
		zero.addScore(Frame.builder().shot1(0).build());
		// Shot 4
		zero.addScore(Frame.builder().shot1(0).build());
		// Shot 5
		zero.addScore(Frame.builder().shot1(0).build());
		// Shot 6
		zero.addScore(Frame.builder().shot1(0).build());
		// Shot 7
		zero.addScore(Frame.builder().shot1(0).build());
		// Shot 8
		zero.addScore(Frame.builder().shot1(0).build());
		// Shot 9
		zero.addScore(Frame.builder().shot1(0).build());
		// Shot 10
		zero.addScore(Frame.builder().shot1(0).build());

		playerService.processScore(zero);

		Assertions.assertEquals(0, zero.getFinalScore());

	}

}
