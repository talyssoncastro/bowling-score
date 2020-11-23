package com.jobsity.talyssondecastro.bowling.score.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by talyssoncastro on 22/11/2020 5:55 PM.
 */
@Getter
@Setter
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Player {

    @NonNull
    private String name;

    private List<Frame> frames;

    private Integer finalScore;

    public void addScore(Frame frame) {
        if (frames == null) {
            frames = new ArrayList();
        }
        frames.add(frame);
    }

}
