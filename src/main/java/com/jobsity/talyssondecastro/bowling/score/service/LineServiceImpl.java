package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.domain.LineData;
import com.jobsity.talyssondecastro.bowling.score.domain.Shot;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by talyssoncastro on 23/11/2020 12:55 AM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LineServiceImpl implements LineService {

    @NonNull
    private ScoreService scoreService;

    @Override
    public LineData process(String line) {

        LineData result = null;

        String[] values = line.split("\\s+");

        // if line has less than 2 elements, it is considered a invalid line
        if (values.length >= 2) {

            String name = values[0];
            String value = values[1];

            Integer score = scoreService.getScoreByInput(value);

            Shot shot = Shot.builder().score(score).representation(value).build();

            result = new LineData(name, shot);

        }

        return result;
    }
}
