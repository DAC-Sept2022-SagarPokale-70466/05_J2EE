/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 26-Dec-2022 11:39:12 PM
*/

package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
	
	
}
