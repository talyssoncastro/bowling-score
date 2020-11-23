package com.jobsity.talyssondecastro.bowling.score.controller;

import com.jobsity.talyssondecastro.bowling.score.domain.Game;
import com.jobsity.talyssondecastro.bowling.score.domain.LineData;
import com.jobsity.talyssondecastro.bowling.score.domain.Player;
import com.jobsity.talyssondecastro.bowling.score.exception.InvalidScoreException;
import com.jobsity.talyssondecastro.bowling.score.service.GameService;
import com.jobsity.talyssondecastro.bowling.score.service.LineService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by talyssoncastro on 23/11/2020 12:50 AM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileControllerImpl implements FileController {

    @NonNull
    private GameService gameService;

    @NonNull
    private LineService lineService;

    @Override
    public Game readFromFile(File file) throws IOException {
        Game game = new Game();

        // Open the file using the closeable feature.
        try (FileReader fr = new FileReader(file)) {

            Scanner inFile = new Scanner(fr);

            String lastName = "";

            while (inFile.hasNext()) {

                // Read the line from the file.
                String line = inFile.nextLine();

                LineData lineData = lineService.process(line);

                Boolean isNewFrame = false;
                if (!lastName.equals(lineData.getName())) {
                    lastName = lineData.getName();
                    isNewFrame = true;
                }

                Player player = game.getPlayerByName(lineData.getName());
                if (player == null) {
                    player = new Player(lineData.getName());
                    game.addPlayer(player);
                }

                try {
                    gameService.addShot(player, lineData.getShot(), isNewFrame);
                } catch (InvalidScoreException e) {
                    System.err.println("Score " + lineData.getShot().getScore() + " is not acceptable.");
                    continue;
                }

            }

            gameService.calculate(game);

            return game;

        }
    }
}
