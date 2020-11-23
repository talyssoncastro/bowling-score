package com.jobsity.talyssondecastro.bowling.score.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by talyssoncastro on 22/11/2020 6:39 PM.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game {

    Map<String, Player> players;

    public void addPlayer(Player player) {
        if (players == null) {
            players = new HashMap();
        }

        players.put(player.getName(), player);
    }

    public Player getPlayerByName(String name) {
        if (players == null) {
            return null;
        }

        return players.get(name);
    }

}
