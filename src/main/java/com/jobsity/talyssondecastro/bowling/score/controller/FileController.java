package com.jobsity.talyssondecastro.bowling.score.controller;

import com.jobsity.talyssondecastro.bowling.score.domain.Game;

import java.io.File;
import java.io.IOException;

/**
 * Created by talyssoncastro on 23/11/2020 12:49 AM.
 */
public interface FileController {

    Game readFromFile(File file) throws IOException;

}
