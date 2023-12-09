package com.chaintrack.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.gateway.Wallet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class AppConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeHttpRequests(Authorize -> Authorize
				.antMatchers("/api/**").authenticated()
				.anyRequest().permitAll()
				)
		.addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
		.csrf().disable()
		.cors().configurationSource(new CorsConfigurationSource() {
					
					@Override
					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
						
						CorsConfiguration cfg = new CorsConfiguration();
						
						cfg.setAllowedOrigins(Arrays.asList(
								
							"http://localhost:3000", 
								"http://localhost:4000",
								"http://localhost:4200"
								
							)
						);
						//cfg.setAllowedMethods(Arrays.asList("GET", "POST","DELETE","PUT"));
						cfg.setAllowedMethods(Collections.singletonList("*"));
						cfg.setAllowCredentials(true);
						cfg.setAllowedHeaders(Collections.singletonList("*"));
						cfg.setExposedHeaders(Arrays.asList("Authorization"));
						cfg.setMaxAge(3600L);
						return cfg;
						
					}
				})
		.and()
		.httpBasic()
		.and()
		.formLogin();
		
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
