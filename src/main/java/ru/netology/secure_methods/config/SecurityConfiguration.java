package ru.netology.secure_methods.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Supervisor")
                .password(encoder().encode("supervisor"))
                .roles("READ", "WRITE", "DELETE")
                .and()
                .withUser("Guest")
                .password(encoder().encode("guest"))
                .roles("READ")
                .and()
                .withUser("Katerina")
                .password(encoder().encode("katerina"))
                .roles("READ", "WRITE", "DELETE")
                .and()
                .withUser("Marina")
                .password(encoder().encode("marina"))
                .roles("READ", "WRITE");

    }


}
