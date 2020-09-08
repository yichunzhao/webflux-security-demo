package com.ynz.security.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.Arrays;

@SpringBootApplication
@EnableWebFluxSecurity
public class WebFluxSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxSecurityDemoApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails test = User.builder().passwordEncoder(passwordEncoder()::encode).username("test")
                .password("test").roles("USER", "ADMIN").build();
        UserDetails ynz = User.builder().passwordEncoder(passwordEncoder()::encode).username("ynz")
                .password("ynz").roles("USER").build();

        return new MapReactiveUserDetailsService(Arrays.asList(test, ynz));
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        return httpSecurity.authorizeExchange().pathMatchers("/hello").permitAll()
                .anyExchange().hasRole("ADMIN")
                .and().httpBasic()
                .and().build();
    }

}
