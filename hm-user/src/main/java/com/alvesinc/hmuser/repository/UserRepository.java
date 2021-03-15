package com.alvesinc.hmuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvesinc.hmuser.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findUserByEmail(String email);
	public User findUserByName(String name);

}
