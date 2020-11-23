package com.jobsity.talyssondecastro.bowling.score.controller;

import com.jobsity.talyssondecastro.bowling.score.config.SeparatorConfiguration;
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

    @Autowired
    private SeparatorConfiguration separatorConfiguration;

    private PrintStream printOut = System.out;

    public DisplayControllerImpl() {
        //
    }

    public DisplayControllerImpl(PrinterService printerService, SeparatorConfiguration separatorConfiguration, PrintStream printStream) {
        this.printerService = printerService;
        this.separatorConfiguration = separatorConfiguration;
        this.printOut = printStream;
    }

    @Override
    public void print(Game game) {

        append("Frame", 2);
        for (int i = 1; i <= 10; i++) {
            append(String.valueOf(i), 2);
        }
        breakLine();
        flush();

        // Print player information
        game.getPlayers().forEach((s, player) -> {
            println(player.getName());
            append("Pinfalls", 1);
            player.getFrames().forEach(frame -> {
                append(printerService.getScoreToPrint(frame), 0);
            });
            breakLine();
            append("Score", 2);
            player.getFrames().forEach(frame -> {
                append(String.valueOf(frame.getAmount()), 2);
            });
            breakLine();
            flush();
        });

    }

    private void append(String s, int separatorToAdd) {
        printOut.append(s);
        for (int i = 0; i < separatorToAdd; i++) {
            printOut.append(separatorConfiguration.get());
        }
    }

    private void println(String s) {
        printOut.println(s);
    }

    private void breakLine() {
        printOut.append("\n");
    }

    private void flush() {
        printOut.flush();
    }

}
