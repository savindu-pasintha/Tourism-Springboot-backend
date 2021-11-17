package com.savindupasintha;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication
@Configuration
@EnableWebSecurity
public class DefaultSecurityConfigurations extends WebSecurityConfigurerAdapter{
	//1-default security login page disabled
	protected void configure(HttpSecurity security) throws Exception
    {
     security.httpBasic().disable();
    }
//https://medium.com/javarevisited/all-you-need-to-know-about-spring-security-basics-aea98c680d01
//https://www.toptal.com/spring/spring-security-tutorial

    /*custom username-password
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin")
        .password("{noop}password")
        .roles("USER");
	}
    */
}
