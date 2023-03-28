package com.generation.blogpessoal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // indica que a Classe é do tipo configuração, ou seja, define uma Classe como fonte de definições de Beans,
@EnableWebSecurity //habilita a segurança de forma Global (toda a aplicação) e sobrescreve os Métodos que irão redefinir as regras de Segurança da sua aplicação.
public class BasicSecurityConfig {

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	            throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	        http
	            .sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and().csrf().disable()
	            .cors();

	        http
	        .authorizeHttpRequests((auth) -> auth
	                .requestMatchers("/usuarios/logar").permitAll()
	                .requestMatchers("/usuarios/cadastrar").permitAll()
	                .requestMatchers(HttpMethod.OPTIONS).permitAll()
	                .anyRequest().authenticated())
	            .httpBasic();

	        return http.build();

	    }
	
	
}
