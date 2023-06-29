package mx.com.ensitech.clientmodule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.com.ensitech.clientmodule.entity.UserAuth;
import mx.com.ensitech.clientmodule.repository.UserAuthRepository;
import mx.com.ensitech.clientmodule.config.security.UserDetailsImpl;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	private UserAuthRepository userAuthRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAuth user = userAuthRepository
				.findOneByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("Invalid Credentials"));
		return new UserDetailsImpl(user);
	}

}
