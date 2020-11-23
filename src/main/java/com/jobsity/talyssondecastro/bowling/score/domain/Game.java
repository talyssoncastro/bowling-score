package com.jobsity.talyssondecastro.bowling.score.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by talyssoncastro on 22/11/2020 6:39 PM.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game {

    List<Player> players;

}
