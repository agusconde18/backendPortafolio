package com.example.backendPortafolio;

import com.example.backendPortafolio.User.UserTokenValid;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Config {
    @Bean
    public UserTokenValid creator(){
        return new UserTokenValid();
    }

}
