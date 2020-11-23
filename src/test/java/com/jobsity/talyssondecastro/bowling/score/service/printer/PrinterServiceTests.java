package com.jobsity.talyssondecastro.bowling.score.service.printer;

import com.jobsity.talyssondecastro.bowling.score.domain.Frame;
import com.jobsity.talyssondecastro.bowling.score.service.PrinterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by talyssoncastro on 23/11/2020 5:47 PM.
 */
@SpringBootTest
public class PrinterServiceTests {

    @Autowired
    private PrinterService printerService;

    @Test
    void should_print_x() {

        Frame frame = Frame.builder().shot1(10).build();

        String result = printerService.getScoreToPrint(frame);

        Assertions.assertEquals("\tX\t", result);

    }

    @Test
    void should_print_7_slash() {

        Frame frame = Frame.builder().shot1(7).shot2(3).build();

        String result = printerService.getScoreToPrint(frame);

        Assertions.assertEquals("7\t/\t", result);

    }

    @Test
    void should_print_9_0() {

        Frame frame = Frame.builder().shot1(9).shot2(0).build();

        String result = printerService.getScoreToPrint(frame);

        Assertions.assertEquals("9\t0\t", result);

    }

}
