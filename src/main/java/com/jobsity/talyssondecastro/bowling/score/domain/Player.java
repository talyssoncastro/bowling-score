package com.jobsity.talyssondecastro.bowling.score.domain;

import lombok.*;
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

    @Setter(AccessLevel.NONE)
    private List<Frame> frames;

    private Integer finalScore;

    public void addFrame(Frame frame) {
        if (frames == null) {
            frames = new ArrayList();
        }
        frames.add(frame);
    }

    public Frame lastFrame() {
        if (frames == null || frames.isEmpty()) {
            return null;
        }

        return frames.get(frames.size() - 1);

    }

}
