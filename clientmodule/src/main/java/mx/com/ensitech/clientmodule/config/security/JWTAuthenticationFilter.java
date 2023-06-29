package mx.com.ensitech.clientmodule.config.security;

import mx.com.ensitech.clientmodule.pojos.LoginRequest;
import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
												HttpServletResponse response) throws AuthenticationException{
		LoginRequest loginRequest = new LoginRequest();
		
		try {
			loginRequest = new ObjectMapper().readValue(request.getReader(), LoginRequest.class);
		} catch (IOException e) {
			
		}
		
		UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
				loginRequest.getUsername(),
				loginRequest.getPassword(),
				Collections.emptyList()
				);
		
		return getAuthenticationManager().authenticate(usernamePAT);
	}
	
	@Override
	public void successfulAuthentication(HttpServletRequest request,
										  HttpServletResponse response,
										  FilterChain chain,
										  Authentication authResult) throws IOException, ServletException{
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
		String token = TokenUtils.createToken(userDetails.getUsername(), userDetails.getUsername());
		
		response.addHeader("Authorization", "Bearer "+token);
		response.getWriter().flush();
		
		super.successfulAuthentication(request, response, chain, authResult);
		
	}
}
