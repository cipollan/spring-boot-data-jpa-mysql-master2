package com.mymagic.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
 
	private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	log.info(this.getClass() + " SecurityConfig.configure "  );
    	
        auth.inMemoryAuthentication()
            .withUser("MioUser").password("{noop}password1").roles("USER")
            .and()
            .withUser("user2").password("{noop}password2").roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
    	log.info(this.getClass() + " SecurityConfig.configure "  );
    	
        http.authorizeRequests()
            .antMatchers("/public/**").permitAll() // Publicly accessible URLs
            .antMatchers("/admin/**").hasRole("ADMIN") // URLs accessible only to users with the "ADMIN" role
            .anyRequest().authenticated() // Any other URLs require authentication
            .and()
            .formLogin(); // Enable form-based login
    }

}

