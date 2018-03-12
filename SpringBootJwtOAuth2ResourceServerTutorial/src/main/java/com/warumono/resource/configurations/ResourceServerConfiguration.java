package com.warumono.resource.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import lombok.extern.slf4j.Slf4j;

@EnableResourceServer
@EnableWebSecurity
@Configuration
@Slf4j
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter
{
	@Value("${security.oauth2.resource.id}")
	private String RESOURCE_ID;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception
	{
		// @formatter:off
		resources
			.resourceId(RESOURCE_ID);
		// @formatter:on
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		// @formatter:off
		http
			.httpBasic()
			.and()
			.csrf().disable()
			.requestMatchers()
				.antMatchers(HttpMethod.GET, "/user/me")
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user/me").permitAll()
//				.anyRequest().authenticated()
				.antMatchers("/**").hasRole("USER")
			.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);;
		// @formatter:on
	}
}
