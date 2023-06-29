package mx.com.ensitech.clientmodule.service.impl;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import mx.com.ensitech.clientmodule.config.security.TokenUtils;
import mx.com.ensitech.clientmodule.entity.Logg;
import mx.com.ensitech.clientmodule.repository.LoggRepository;
import mx.com.ensitech.clientmodule.service.LoggService;

@Service
public class LoggServiceImpl implements LoggService {
	private static final Logger logger = LoggerFactory.getLogger(LoggServiceImpl.class);
	@Autowired
	private LoggRepository loggRepository;
	
	@Override
	public void addNewLogg(String token, String path) {
		try {
			Logg logg = new Logg();
			logg.setLoggPath(path);
			logg.setUsername(TokenUtils.getAuthentication(token).getName());
			logg.setLoggDate(new Date());
			
			loggRepository.save(logg);
	
		} catch (Exception e) {
			logger.info(e.getMessage());
		}	
	}

	@Override
	public List<Logg> getAllLoggs() {
		List<Logg> loggs = null;
		try {
			loggs = loggRepository.findAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return loggs;
	}

}
