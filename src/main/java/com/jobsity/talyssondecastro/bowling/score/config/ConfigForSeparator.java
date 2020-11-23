package com.jobsity.talyssondecastro.bowling.score.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by talyssoncastro on 23/11/2020 5:50 PM.
 */
@Configuration
public class ConfigForSeparator implements SeparatorConfiguration {

    @Override
    public String get() {
        return "\t";
    }
}
