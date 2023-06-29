package mx.com.ensitech.clientmodule.service;

import java.util.List;

import mx.com.ensitech.clientmodule.entity.Logg;

public interface LoggService {
	void addNewLogg(String token, String path);
	List<Logg> getAllLoggs();
}
