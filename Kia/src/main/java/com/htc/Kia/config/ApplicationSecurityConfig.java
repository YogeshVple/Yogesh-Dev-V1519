package com.htc.Kia.config;



import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableAspectJAutoProxy   //enable aop proxy
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {   //user repository.
		//in memory authentication.
		auth.inMemoryAuthentication().withUser("htcuser").password("123Welcome").roles("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("manager").password("welcome").roles("MANAGER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {   //authorization logic
		http.csrf().disable();
		http.authorizeRequests()
		
			.antMatchers("/*").permitAll()
			.antMatchers("/*/*").permitAll()
//			.antMatchers("/song").hasAnyRole("EMPLOYEE", "ADMIN", "MANAGER")
//			.antMatchers("/movie").hasAnyRole("MANAGER", "ADMIN")
//			.antMatchers("/singers").hasAnyRole("EMPLOYEE", "ADMIN", "MANAGER")
//			.antMatchers("/song-singers").hasAnyRole("EMPLOYEE", "ADMIN", "MANAGER")
			.anyRequest().fullyAuthenticated()
			.and().httpBasic();
	}


	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
}


