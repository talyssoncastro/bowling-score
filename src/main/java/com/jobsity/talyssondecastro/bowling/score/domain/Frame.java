package com.jobsity.talyssondecastro.bowling.score.domain;

import lombok.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by talyssoncastro on 22/11/2020 5:56 PM.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Frame {

    private static final Integer MAX_SCORE_PER_CHANCE = 10;

//    @Range(min = 0, max = 10)
    private Integer shot1;

//    @Range(min = 0, max = 10)
    private Integer shot2;

//    @Range(min = 0, max = 10)
    private Integer shot3;

    private Integer amount = 0;

    public ShotResult getShotResult() {

        final ShotResult result;

        if (getSumOfShots() != MAX_SCORE_PER_CHANCE) {
            result = ShotResult.NORMAL;
        } else if (shot2Optional().isPresent()) {
            result = ShotResult.SPARE;
        } else {
            result = ShotResult.STRIKE;
        }

        return result;
    }

    public Optional<Integer> shot1Optional() {
        return Optional.ofNullable(shot1);
    }

    public Optional<Integer> shot2Optional() {
        return Optional.ofNullable(shot2);
    }

    public Optional<Integer> shot3Optional() {

        return Optional.ofNullable(shot3);
    }

    public Integer getSumOfShots() {
        AtomicInteger sum = new AtomicInteger(shot1);
        shot2Optional().ifPresent(s -> sum.addAndGet(s));
        shot3Optional().ifPresent(s -> sum.addAndGet(s));

        return sum.get();
    }

}
