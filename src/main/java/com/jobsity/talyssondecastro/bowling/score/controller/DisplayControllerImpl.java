package com.jobsity.talyssondecastro.bowling.score.controller;

import com.jobsity.talyssondecastro.bowling.score.domain.Game;
import com.jobsity.talyssondecastro.bowling.score.service.PrinterService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintStream;

/**
 * Created by talyssoncastro on 23/11/2020 1:06 AM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DisplayControllerImpl implements DisplayController {

    @NonNull
    private PrinterService printerService;

    private PrintStream printOut = System.out;

    public DisplayControllerImpl() {
        //
    }

    public DisplayControllerImpl(PrinterService printerService, PrintStream printStream) {
        this.printerService = printerService;
        this.printOut = printStream;
    }

    @Override
    public void print(Game game) {

        printOut.append("Frame \t\t");
        for (int i = 1; i <= 10; i++) {
            printOut.append(i + "\t\t");
        }
        printOut.append("\n");
        printOut.flush();

        // Print player information
        game.getPlayers().forEach((s, player) -> {
            printOut.println(player.getName());
            printOut.append("Pinfalls\t");
            player.getFrames().forEach(frame -> {
                printOut.append(printerService.getScoreToPrint(frame));
            });
            printOut.append("\n");
            printOut.append("Score\t\t");
            player.getFrames().forEach(frame -> {
                printOut.append(frame.getAmount() + "\t\t");
            });
            printOut.append("\n");
            printOut.flush();
        });

    }
}
