/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 26-Dec-2022 11:40:35 PM
*/

package com.app.service;

import java.util.List;

import com.app.payloads.UserDTO;

public interface UserService {

	UserDTO registerNewUser(UserDTO userDTO);
	
	UserDTO createUser(UserDTO user);

	UserDTO updateUser(UserDTO user, Integer userId);

	UserDTO getUserById(Integer userId);

	List<UserDTO> getAllUsers();

	void deleteUser(Integer userId);
}
