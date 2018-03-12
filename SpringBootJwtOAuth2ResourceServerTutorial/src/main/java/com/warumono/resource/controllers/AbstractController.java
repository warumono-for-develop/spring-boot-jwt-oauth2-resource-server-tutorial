package com.warumono.resource.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractController
{
//	@Value("${security.oauth2.client.client-id}")
//	protected String clientId;
//	
//	@Autowired
//	protected OAuth2RestTemplate oAuth2RestTemplate;
//	
//	@Autowired
//	protected OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails;
//
//	@Autowired
//	protected AccessTokenProvider accessTokenProvider;
//	
//	@Autowired
//	protected TokenStore tokenStore;
//	
//	@Autowired
//	protected ObjectMapper jsonObjectMapper;
//
//	@Autowired
//	protected DefaultTokenServices tokenServices;
//	
//	private String extractAccessToken(@NotNull HttpServletRequest request)
//	{
//		return request.getHeader("authorization").replace("Bearer ", StringUtils.EMPTY);
//	}
//	
//	protected OAuth2AccessToken token(@NotNull String username, @NotNull String password)
//	{
//		log.debug("tokenStore: {}", tokenStore);
//		log.debug("username: {}", username);
//		log.debug("password: {}", password);
//		log.debug("clientId: {}", clientId);
//		
//		oAuth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("username", username);
//		oAuth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("password", password);
//		
////		Collection<OAuth2AccessToken> accessTokens = tokenStore.findTokensByClientIdAndUserName(clientId, username);
////		
////		log.debug("{}", accessTokens);
////		
////		for(OAuth2AccessToken oAuth2AccessToken : accessTokens)
////		{
////			log.debug("{}", oAuth2AccessToken.getTokenType());
////			log.debug("{}", oAuth2AccessToken.getValue());
////		}
//		
//		return oAuth2RestTemplate.getAccessToken();
//	}
//	
////	protected OAuth2RefreshToken refreshtoken(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response)
//	protected OAuth2AccessToken refreshtoken(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response)
//	{
//		log.debug("tokenStore: {}", tokenStore);
//		log.debug("clientId: {}", clientId);
//
////		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
////		OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
////		AccessTokenProvider accessTokenProvider = new ResourceOwnerPasswordAccessTokenProvider();
////		oAuth2RestTemplate.setAccessTokenProvider(accessTokenProvider);
//////		accessTokenProvider.refreshAccessToken(resourceDetails, refreshToken, request)
//
//		
//
////		String a = request.getHeader("authorization");
////		String accessToken = a.replace("Bearer ", StringUtils.EMPTY);
//////		OAuth2AccessToken refreshAccessToken(OAuth2ProtectedResourceDetails resource, OAuth2RefreshToken refreshToken, AccessTokenRequest request) throws UserRedirectRequiredException;
////		OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
////		DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(oAuth2AccessToken);
////		OAuth2RefreshToken oAuth2RefreshToken = token.getRefreshToken();
//////		oAuth2AccessToken = accessTokenProvider.obtainAccessToken(resourceDetails, restTemplate.getOAuth2ClientContext().getAccessTokenRequest());
////		oAuth2AccessToken = accessTokenProvider.refreshAccessToken(oAuth2ProtectedResourceDetails, oAuth2RefreshToken, oAuth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest());
//
//
//		oAuth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("username", "admin@gmail.com");
//		oAuth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("password", "adminpassword");
//		
//		OAuth2AccessToken o = oAuth2RestTemplate.getAccessToken();
////		oAuth2TokenService.setTokenStore(tokenStore);
////		OAuth2AccessToken oAuth2AccessToken = oAuth2TokenService.refreshAccessToken(o.getRefreshToken().getValue(), (TokenRequest)oAuth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest());
//		
//		
////		OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
////		log.debug("{}", oAuth2AccessToken);
////		DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(oAuth2AccessToken);
////		log.debug("{}", token);
////		OAuth2RefreshToken oAuth2RefreshToken = token.getRefreshToken();
////		
////		log.debug("{}", oAuth2RefreshToken);
////		log.debug("{}", oAuth2RefreshToken.getValue());
//		
//		return null;
//	}
//	
//	protected Boolean revoke(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, Principal principal)
//	{
//		String accessToken = extractAccessToken(request);
//		
//		log.debug("tokenStore: {}", tokenStore);
//		log.debug("accessToken: {}", accessToken);
//		log.debug("clientId: {}", clientId);
//		
//		try
//		{
////			log.debug("{}", tokenStore.findTokensByClientId(clientId));
////			tokenStore.findTokensByClientId(clientId).forEach(t -> log.debug("{}", t.getTokenType()));
////			
////			Collection<OAuth2AccessToken> accessTokens = tokenStore.findTokensByClientIdAndUserName(clientId, username);
////
////			log.debug("{}", accessTokens);
////			
////			for(OAuth2AccessToken oAuth2AccessToken : accessTokens)
////			{
////				log.debug("{}", oAuth2AccessToken.getTokenType());
////				log.debug("{}", oAuth2AccessToken.getValue());
////			}
//			
////			tokenServices.revokeToken(username);
//			
////			RemoteTokenServices rts = new RemoteTokenServices();
////			rts.setCheckTokenEndpointUrl("http://localhost/oauth/token");
////			rts.setClientId(clientId);
////			rts.setClientSecret("tongjolimsecret");
////			OAuth2Authentication a = rts.loadAuthentication(accessToken);
////			OAuth2AccessToken o = tokenStore.getAccessToken(a);
////			log.debug("{}", o);
////			tokenServices.revokeToken(o.getValue());
//			
//			
//			OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
////			OAuth2RefreshToken oAuth2RefreshToken = tokenStore.readRefreshToken(username);
//			log.debug("{}", oAuth2AccessToken);
////			log.debug("{}", oAuth2RefreshToken);
//			tokenStore.removeAccessToken(oAuth2AccessToken);
////			tokenStore.removeRefreshToken(oAuth2RefreshToken);
//			
////			SecurityContextHolder.getContext().getAuthentication();
//			SecurityContextHolder.getContext().setAuthentication(null);
//			
//			HttpServletRequest request2 = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//			new SecurityContextLogoutHandler().logout(request2, null, null);
//			
//			
//			
//			
//			OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
//			oAuth2AccessToken.getRefreshToken().getValue();
////		    OAuth2AccessToken accessToken = oAuth2TokenServices.getAccessToken(oAuth2Authentication);
//			tokenServices.revokeToken(oAuth2AccessToken.getValue());
//			tokenStore.removeAccessToken(oAuth2AccessToken);
//		}
//		catch(Exception ignore)
//		{
//			ignore.printStackTrace();
//		}
//		
//		return Boolean.TRUE;
//	}
//	
//	
//	protected <T extends AuditingWithoutIdentityEntity> ResponseEntity<Collection<T>> allright(Collection<T> entities)
//	{
//		return ResponseEntity.ok(entities);
//	}
//	
//	protected <T extends AuditingWithoutIdentityEntity> ResponseEntity<T> allright(T entity)
//	{
//		return ResponseEntity.ok(entity);
//	}
//	
//	protected ResponseEntity<? extends Object> allright(Object entity)
//	{
//		return ResponseEntity.ok(entity);
//	}
//	
//	protected ResponseEntity<Boolean> allright(Boolean bool)
//	{
//		return ResponseEntity.ok(bool);
//	}
//	
//	protected ResponseEntity<String> allright(String str)
//	{
//		return ResponseEntity.ok(str);
//	}
//	
//	protected <T extends AuditingWithoutIdentityEntity> ResponseEntity<T> empty()
//	{
//		return ResponseEntity.ok(null);
//	}
//	
//	protected <T extends AuditingWithoutIdentityEntity> ResponseEntity<Collection<T>> empties()
//	{
//		return ResponseEntity.ok(null);
//	}
//	
//	protected ResponseEntity<Void> devoid()
//	{
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
}
