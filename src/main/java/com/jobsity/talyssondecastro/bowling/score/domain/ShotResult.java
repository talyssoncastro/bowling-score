package com.jobsity.talyssondecastro.bowling.score.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by talyssoncastro on 22/11/2020 6:42 PM.
 */
@AllArgsConstructor
@Getter
public enum ShotResult {

    NORMAL(0),
    SPARE(1),
    STRIKE(2);

    private Integer nextShotToConsider;

}
