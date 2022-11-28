package EmployeeDetails.SalarySlipDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationCOnfiguration 
{
	
	AuthenticationManager manager;
	@Autowired
	EmpDetailsService serv;
	
	@Bean
	public WebSecurityCustomizer vinod()
	{
		return(web)->web.ignoring().antMatchers("/maddy/newone");
	}
	
	@Bean
	public PasswordEncoder encrpting()
	{
		return  new BCryptPasswordEncoder();
	}

	
	@Bean
	public SecurityFilterChain secure(HttpSecurity hp) throws Exception
	{
		//hp.authorizeRequests().anyRequest().permitAll();
		//hp.authorizeRequests().anyRequest().authenticated();
		hp.authorizeRequests().antMatchers("/maddy/**").authenticated();
		hp.httpBasic();
		hp.formLogin();
		hp.cors();
		hp.csrf().disable();
		
		AuthenticationManagerBuilder builder=hp.getSharedObject(AuthenticationManagerBuilder.class);
		builder.userDetailsService(serv).passwordEncoder(encrpting());
		manager=builder.build();
		hp.authenticationManager(manager);
		return hp.build();	
	}

}
