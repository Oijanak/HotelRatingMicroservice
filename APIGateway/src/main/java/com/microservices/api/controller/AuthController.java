package com.microservices.api.controller;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.api.model.AuthResponse;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@GetMapping("/login")
	public ResponseEntity<AuthResponse> login(@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
			@AuthenticationPrincipal OidcUser user,
			Model model
			){
		
			AuthResponse authresp=new AuthResponse();
			authresp.setUserId(user.getEmail());
			authresp.setAccessToken(client.getAccessToken().getTokenValue());
			authresp.setRefreshToken(client.getRefreshToken().getTokenValue());
			authresp.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
			List<String> authorities= user.getAuthorities().stream().map(grantedAuthority->{
				return grantedAuthority.getAuthority();
			}).collect(Collectors.toList());
			authresp.setAthorities(authorities);
			return new ResponseEntity<>(authresp,HttpStatus.OK);
	}

}
