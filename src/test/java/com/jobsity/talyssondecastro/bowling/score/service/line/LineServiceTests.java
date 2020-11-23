package com.jobsity.talyssondecastro.bowling.score.service.line;

import com.jobsity.talyssondecastro.bowling.score.domain.LineData;
import com.jobsity.talyssondecastro.bowling.score.service.LineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by talyssoncastro on 23/11/2020 5:44 PM.
 */
@SpringBootTest
public class LineServiceTests {

    @Autowired
    private LineService lineService;

    @Test
    void should_return_null() {

        LineData result = lineService.process("");

        Assertions.assertNull(result);
    }

    @Test
    void should_has_representation_F() {

        LineData result = lineService.process("John F");

        Assertions.assertEquals("John", result.getName());
        Assertions.assertEquals("F", result.getShot().getRepresentation());
        Assertions.assertEquals(0, result.getShot().getScore());
    }

}
