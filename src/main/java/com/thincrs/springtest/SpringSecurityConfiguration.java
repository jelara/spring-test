package com.thincrs.springtest;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz
				// Peticiones al API (URLs que comiencen con "/api"),
				// necesitan autenticación.
				.requestMatchers("/api/**").authenticated()
				// Todo lo demás, se puede entrar sin autenticación.
				.anyRequest().permitAll())
		    // Para la autenticación, se utiliza un formulario
		    .formLogin(form -> form.defaultSuccessUrl("/", true).permitAll());
		return http.build();
	}
	
    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        return users;
    }

}
