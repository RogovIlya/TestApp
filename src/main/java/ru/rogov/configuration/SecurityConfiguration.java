package ru.rogov.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import ru.rogov.service.AuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("root").roles("ADMIN");*/
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{

		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").
		antMatchers("/").permitAll().and().formLogin().loginPage("/authentication").// loginPage по этой урле не будет работать мапинг в контролере
		defaultSuccessUrl("/authentication").
		failureUrl("/authentication?error").
		usernameParameter("login").passwordParameter("password").
		and().logout().logoutSuccessUrl("/logout").and().csrf();
	}
}
