package com.jobsity.talyssondecastro.bowling.score.file;

import com.jobsity.talyssondecastro.bowling.score.config.SeparatorConfiguration;
import com.jobsity.talyssondecastro.bowling.score.controller.DisplayController;
import com.jobsity.talyssondecastro.bowling.score.controller.DisplayControllerImpl;
import com.jobsity.talyssondecastro.bowling.score.controller.FileController;
import com.jobsity.talyssondecastro.bowling.score.domain.Game;
import com.jobsity.talyssondecastro.bowling.score.service.PrinterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

/**
 * Created by talyssoncastro on 23/11/2020 8:45 PM.
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Player3OutputTests {

    @Autowired
    private FileController fileController;

    @Autowired
    private PrinterService printerService;

    @Autowired
    private SeparatorConfiguration separatorConfiguration;

    private DisplayController displayController;

    private PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    public void loadData() {

        standardOut = new PrintStream(outputStreamCaptor);

        displayController = new DisplayControllerImpl(printerService, separatorConfiguration, standardOut);

    }

    @Test
    public void test() throws IOException {

        File inputFile = new ClassPathResource("player3/input.txt").getFile();

        File resultFile = new ClassPathResource("player3/result.txt").getFile();
        String result = new String(Files.readAllBytes(resultFile.toPath()));

        Game game = fileController.readFromFile(inputFile);
        displayController.print(game);

        Assertions.assertEquals(result.trim(), outputStreamCaptor.toString().trim());
    }

}
