package com.jobsity.talyssondecastro.bowling.score.controller;

import com.jobsity.talyssondecastro.bowling.score.domain.Game;
import com.jobsity.talyssondecastro.bowling.score.service.PrinterService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by talyssoncastro on 23/11/2020 1:06 AM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DisplayControllerImpl implements DisplayController {

    @NonNull
    private PrinterService printerService;

    @Override
    public void print(Game game) {

        System.out.append("Frame \t\t");
        for (int i = 1; i <= 10; i++) {
            System.out.append(i + "\t\t");
        }
        System.out.append("\n");
        System.out.flush();

        // Print player name
        game.getPlayers().forEach((s, player) -> {
            System.out.println(player.getName());
            System.out.append("Pinfalls\t");
            player.getFrames().forEach(frame -> {
                System.out.append(printerService.getScoreToPrint(frame));
            });
            System.out.append("\n");
            System.out.append("Score\t\t");
            player.getFrames().forEach(frame -> {
                System.out.append(frame.getAmount() + "\t\t");
            });
            System.out.append("\n");
            System.out.flush();
        });

    }
}
