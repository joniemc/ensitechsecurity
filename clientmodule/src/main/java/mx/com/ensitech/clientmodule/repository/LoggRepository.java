package mx.com.ensitech.clientmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.ensitech.clientmodule.entity.Logg;

@Repository
public interface LoggRepository extends JpaRepository<Logg,Integer>{

}
