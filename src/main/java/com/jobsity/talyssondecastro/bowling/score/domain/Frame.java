package com.jobsity.talyssondecastro.bowling.score.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by talyssoncastro on 22/11/2020 5:56 PM.
 */
@Getter
@Setter
public class Frame {

    private List<Integer> shots;

    private FrameType frameType = FrameType.NORMAL;

    private Integer amount = 0;

    private Frame() {

    }

    private Frame(Frame origin) {
        this.shots = origin.shots;
        this.frameType = origin.frameType;
        this.amount = origin.amount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ShotResult getShotResult() {

        final ShotResult result;

        if (getScoreSum() == frameType.getMaxScore() && shots.size() == 1) {
            result = ShotResult.STRIKE;
        } else if (getScoreSum() == frameType.getMaxScore()) {
            result = ShotResult.SPARE;
        } else {
            result = ShotResult.NORMAL;
        }

        return result;
    }

    public Optional<Integer> shot1Optional() {
        return shots.size() >= 1 ? Optional.ofNullable(shots.get(0)) : Optional.empty();
    }

    public Optional<Integer> shot2Optional() {
        return shots.size() >= 2 ? Optional.ofNullable(shots.get(1)) : Optional.empty();
    }

    public Optional<Integer> shot3Optional() {
        return shots.size() >= 3 ? Optional.ofNullable(shots.get(2)) : Optional.empty();
    }

    public Integer getScoreSum() {
        return shots.stream().reduce(0, Integer::sum);
    }

//    public boolean isFilledUp() {
//        return (shots.size() >= frameType.getMaxShots() || getScoreSum() == frameType.getMaxScore());
//    }

    public void addShot(Integer score) {
        if (shots == null) {
            shots = new ArrayList();
        }

        shots.add(score);

    }

    public static class Builder {
        private Frame target;

        public Builder() {
            this.target = new Frame();
        }

        public Builder shot1(Integer shot1) {
            target.addShot(shot1);
            return this;
        }

        public Builder shot2(Integer shot2) {
            target.addShot(shot2);
            return this;
        }

        public Builder shot3(Integer shot3) {
            target.addShot(shot3);
            return this;
        }

        public Builder frameType(FrameType frameType) {
            target.setFrameType(frameType);
            return this;
        }

        public Frame build() {
            return new Frame(target);
        }
    }

}
