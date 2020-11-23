package com.jobsity.talyssondecastro.bowling.score.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Created by talyssoncastro on 23/11/2020 1:29 PM.
 */
@Getter
@Setter
@Builder
public class Shot {

    @Range(min = 0, max = 10, message = "Score must be between 0 and 10")
    private Integer score;

    @Getter(AccessLevel.NONE)
    private String representation;

    public String getRepresentation() {
        return representation != null ? representation : score.toString();
    }

}
