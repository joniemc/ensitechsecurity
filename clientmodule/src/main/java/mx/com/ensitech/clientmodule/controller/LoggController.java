package mx.com.ensitech.clientmodule.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ensitech.clientmodule.config.security.TokenUtils;
import mx.com.ensitech.clientmodule.entity.Logg;
import mx.com.ensitech.clientmodule.service.LoggService;
import mx.com.ensitech.clientmodule.utils.GeneralParams;

@RestController
@RequestMapping("/loggs/v1")
public class LoggController {
	private static final Logger logger = LoggerFactory.getLogger(LoggController.class);
	@Autowired
	private LoggService loggService;
	
	@GetMapping("get/all")
	public ResponseEntity<List<Logg>> getAllLoggs(HttpServletRequest request){
		ResponseEntity<List<Logg>> response = null;
		try {
			response = ResponseEntity.ok(loggService.getAllLoggs());
		}catch(Exception ex) {
			logger.info(ex.getMessage());
		}
		loggService.addNewLogg(TokenUtils.getStringToken(request.getHeader("Authorization")),GeneralParams.LOGG_GET_ALL_PATH);
		
		return response;
	}
}
