package com.jobsity.talyssondecastro.bowling.score.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by talyssoncastro on 23/11/2020 12:37 AM.
 */
@AllArgsConstructor
@Getter
public enum FrameType {

    NORMAL(2, 10),
    LAST(3, 30);

    private Integer maxShots;

    private Integer maxScore;

}
