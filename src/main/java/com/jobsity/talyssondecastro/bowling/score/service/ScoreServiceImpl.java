package com.jobsity.talyssondecastro.bowling.score.service;

import com.jobsity.talyssondecastro.bowling.score.utils.IntegerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by talyssoncastro on 23/11/2020 1:17 PM.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ScoreServiceImpl implements ScoreService {

    @Override
    public Integer getScoreByInput(String value) {

        Integer score;

        if ("F".equals(value)) {
            score = 0;
        } else if ("X".equals(value)) {
            score = 10;
        } else {
            score = IntegerUtils.parseWithDefault(value, 0);
        }

        return score;
    }

}
