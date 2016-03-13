package ru.rogov.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ru.rogov.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{ 
	static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	@Query(value = "SELECT * FROM USERS as u WHERE u.LOGIN = :login", nativeQuery = true)
	User getUser(@Param("login") String login);
}
