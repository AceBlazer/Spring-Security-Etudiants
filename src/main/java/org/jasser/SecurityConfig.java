package org.jasser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void globalConfig (AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN","PROF");
		auth.inMemoryAuthentication().withUser("prof1").password("{noop}123").roles("PROF");
		auth.inMemoryAuthentication().withUser("etudiant1").password("{noop}123").roles("ETUDIANT");
		auth.inMemoryAuthentication().withUser("scolarite1").password("{noop}123").roles("SCOLARITE");
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http
		.csrf().disable()
			.authorizeRequests()
				.anyRequest()
					.authenticated()
						.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/index.html");
				
	}
}
