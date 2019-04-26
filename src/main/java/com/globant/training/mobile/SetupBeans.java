package com.globant.training.mobile;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SetupBeans {

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
