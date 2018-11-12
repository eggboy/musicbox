package io.pivotal.sp1tour.musicbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

@Configuration
public class MusicBoxConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity http) throws Exception {
        http.ignoring().antMatchers("/**");
    }

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}
