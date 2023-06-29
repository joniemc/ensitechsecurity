package mx.com.ensitech.clientmodule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.ensitech.clientmodule.entity.UserAuth;


@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Integer>{
	Optional<UserAuth> findOneByUsername(String username);
}
