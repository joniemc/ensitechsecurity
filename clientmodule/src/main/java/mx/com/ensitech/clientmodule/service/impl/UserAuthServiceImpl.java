package mx.com.ensitech.clientmodule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ensitech.clientmodule.entity.UserAuth;
import mx.com.ensitech.clientmodule.repository.UserAuthRepository;
import mx.com.ensitech.clientmodule.service.UserAuthService;

@Service
public class UserAuthServiceImpl implements UserAuthService {

	@Autowired
	private UserAuthRepository userAuthRepository;
	
	@Override
	public List<UserAuth> getAllUsers() {
		return userAuthRepository.findAll();
	}

}
