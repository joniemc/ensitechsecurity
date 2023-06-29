package mx.com.ensitech.clientmodule.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ensitech.clientmodule.config.security.TokenUtils;
import mx.com.ensitech.clientmodule.service.LoggService;
import mx.com.ensitech.clientmodule.utils.GeneralParams;
import mx.com.ensitech.proxymodule.pojos.CharacterDetail;
import mx.com.ensitech.proxymodule.service.CharacterService;

@RestController
@RequestMapping("/characters/v1")
public class CharacterController {
	private static final Logger logger = LoggerFactory.getLogger(CharacterController.class);
	@Autowired
	private CharacterService characterService;
	
	@Autowired
	private LoggService loggService;
	
	@GetMapping("get/all")
	public ResponseEntity<List<CharacterDetail>> getAllCharacters(HttpServletRequest request) {
		ResponseEntity<List<CharacterDetail>> response = null;
		try {
			response = ResponseEntity.ok(characterService.getAllCharacters());
		}catch(Exception ex) {
			logger.info(ex.getMessage());
		}
		loggService.addNewLogg(TokenUtils.getStringToken(request.getHeader("Authorization")),GeneralParams.CHARACTER_GET_ALL_PATH);
		
		return response;
	}
	
	@GetMapping("get/byid/{characterId}")
	public ResponseEntity<CharacterDetail> getCharacterById(HttpServletRequest request, @PathVariable("characterId") long characterId) {
		ResponseEntity<CharacterDetail> response = null;
		try {
			response = ResponseEntity.ok(characterService.getCharacterById(characterId));
		}catch(Exception ex) {
			logger.info(ex.getMessage());
		}
		loggService.addNewLogg(TokenUtils.getStringToken(request.getHeader("Authorization")),GeneralParams.CHARACTER_GET_BYID_PATH);
		
		return response;
	}
	
}
