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
				// Peticiones al home ("/"), archivos (index.html) y el contenido
				// del directorio static, no necesitan autenticación
				.requestMatchers("/", "*.*", "/static/**").permitAll()
				// Todo lo demás, necesita estar autenticado
				.anyRequest().authenticated())
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
