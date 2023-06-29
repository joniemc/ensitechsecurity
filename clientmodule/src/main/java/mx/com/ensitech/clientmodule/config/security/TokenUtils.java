package mx.com.ensitech.clientmodule.config.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
public class TokenUtils {

	private final static SecretKey ACCESS_TOKEN_SECRET2 = Keys.secretKeyFor(SignatureAlgorithm.HS256);;
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
	
	public static String createToken(String name, String username) {
		long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS*1_000;
		Date expirationDate = new Date(System.currentTimeMillis()+expirationTime);
		
		Map<String, Object> extra = new HashMap<>();
		extra.put("name", name);
		
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(ACCESS_TOKEN_SECRET2)
				.compact();
	}
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCESS_TOKEN_SECRET2)
					.build()
					.parseClaimsJws(token)
					.getBody();
			
			String username = claims.getSubject();
			
			return new UsernamePasswordAuthenticationToken(username,null,Collections.emptyList());	
		}catch(JwtException jwte) {
			return null;
		}
		
	}
	
	public static String getStringToken(String bearerToken) {
		String token = null;
		if(bearerToken!=null && bearerToken.startsWith("Bearer ")) {
			token = bearerToken.replace("Bearer ", "");
			
		}
		return token;
	}
	
	
	
}
