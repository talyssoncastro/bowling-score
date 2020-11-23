package com.jobsity.talyssondecastro.bowling.score.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by talyssoncastro on 22/11/2020 5:56 PM.
 */
@Getter
@Setter
public class Frame {

    private List<Shot> shots;

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

    public Optional<Shot> shot1Optional() {
        return shots.size() >= 1 ? Optional.ofNullable(shots.get(0)) : Optional.empty();
    }

    public Optional<Shot> shot2Optional() {
        return shots.size() >= 2 ? Optional.ofNullable(shots.get(1)) : Optional.empty();
    }

    public Optional<Shot> shot3Optional() {
        return shots.size() >= 3 ? Optional.ofNullable(shots.get(2)) : Optional.empty();
    }

    public Integer getScoreSum() {
        return shots.stream().mapToInt(s -> s.getScore()).sum();
    }

    public void addShot(Shot shot) {
        if (shots == null) {
            shots = new ArrayList();
        }

        shots.add(shot);

    }

    public static class Builder {
        private Frame target;

        public Builder() {
            this.target = new Frame();
        }

        public Builder shot1(Shot shot1) {
            target.addShot(shot1);
            return this;
        }

        public Builder shot1(Integer shot1) {
            target.addShot(Shot.builder().score(shot1).build());
            return this;
        }

        public Builder shot2(Shot shot2) {
            target.addShot(shot2);
            return this;
        }

        public Builder shot2(Integer shot2) {
            target.addShot(Shot.builder().score(shot2).build());
            return this;
        }

        public Builder shot3(Shot shot3) {
            target.addShot(shot3);
            return this;
        }

        public Builder shot3(Integer shot3) {
            target.addShot(Shot.builder().score(shot3).build());
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
