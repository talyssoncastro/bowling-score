package com.jobsity.talyssondecastro.bowling.score;

import com.jobsity.talyssondecastro.bowling.score.controller.DisplayController;
import com.jobsity.talyssondecastro.bowling.score.controller.FileControllerImpl;
import com.jobsity.talyssondecastro.bowling.score.domain.Game;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootApplication
public class BowlingScoreApplication implements CommandLineRunner {

	@NonNull
	private FileControllerImpl fileController;

	@NonNull
	private DisplayController displayController;


	public static void main(String[] args) {
		SpringApplication.run(BowlingScoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (args.length < 1) {
			System.err.println("The input file was not provided. The program will shutdown");
			return;
		}

		Game game = fileController.readFromFile(new File(args[0]));
		displayController.print(game);

	}
}
