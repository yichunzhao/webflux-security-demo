package com.ynz.security.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableWebFluxSecurity
public class WebFluxSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxSecurityDemoApplication.class, args);
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails test = User.withDefaultPasswordEncoder().username("test").password("test").roles("USER", "ADMIN").build();
        UserDetails ynz = User.withDefaultPasswordEncoder().username("ynz").password("ynz").roles("USER").build();
        List<UserDetails> users = Arrays.asList(test, ynz);
        return new MapReactiveUserDetailsService(users);
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        return httpSecurity.authorizeExchange().pathMatchers("/hello").permitAll()
                .anyExchange().hasRole("ADMIN").and().httpBasic().and().build();
    }

}