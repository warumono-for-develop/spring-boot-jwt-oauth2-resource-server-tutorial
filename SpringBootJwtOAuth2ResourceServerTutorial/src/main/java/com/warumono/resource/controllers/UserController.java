package com.warumono.resource.controllers;

import java.security.Principal;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.collect.Maps;
import com.warumono.resource.controllers.interfaces.UserControllerInterface;
import com.warumono.resource.enums.Authority;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController extends AbstractController implements UserControllerInterface
{
	@Override
	public Principal me(Principal principal)
	{
		log.debug("principal : {}", principal);
		
		return principal;
	}

	@Override
	public ResponseEntity<Object> test(@PathVariable String identity)
	{
		log.debug("identity : {}", identity);
		
		Map<String, Object> response = Maps.newHashMap();
		
		if("a".equals(identity))
		{
			response.put("picture", "http://aaa/bbb/a-profile.jpg");
		}
		else
		{
			response.put("picture", "http://xxx/yyy/other-profile.jpg");
		}
		
		response.put("identity", identity);
		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Object> me(Authority authority, String username, String password)
	{
		log.debug("=========== resource");
		log.debug("authority : {}", authority);
		log.debug("username : {}", username);
		log.debug("password : {}", password);
		
		MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
		request.set("username", username);
		request.set("password", password);
		
		UriComponents uri = UriComponentsBuilder.fromPath("https://localhost:8081/user/" + authority).build();
		
		RestTemplate restTemplate = new RestTemplate();
		
		@SuppressWarnings("unchecked")
		Map<String, Object> response = restTemplate.postForObject(uri.toUri(), request, Map.class);
		
		return ResponseEntity.ok(response);
	}
}

