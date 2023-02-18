/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 26-Dec-2022 11:48:29 PM
*/

package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.config.AppConstants;
import com.app.entity.Role;
import com.app.entity.User;
import com.app.excetions.ResourceNotFoundException;
import com.app.payloads.UserDTO;
import com.app.repository.RoleRepo;
import com.app.repository.UserRepo;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo; // Automatically available to use Because we are using JPA

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;
//	---------------------------------------------------------------------------------------------------

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO user, Integer userId) {

		User user1 = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setAbout(user.getAbout());

		User updatedUser = this.userRepo.save(user1);
		UserDTO userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDTO> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "Id", userId));

		this.userRepo.delete(user);
	}

//	------------------------------------------------------------------------------

	private User dtoToUser(UserDTO userDto) {

		User user = this.modelMapper.map(userDto, User.class); // Convert the userDto to User Class

//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());

		return user;
	}

	public UserDTO userToDto(User user) {

		UserDTO userDto = this.modelMapper.map(user, UserDTO.class);

//		UserDTO userDto = new UserDTO();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());

		return userDto;
	}

	@Override
	public UserDTO registerNewUser(UserDTO userDTO) {

		User user = this.modelMapper.map(userDTO, User.class);

//	Encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		// Roles
		Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();

		user.getRoles().add(role);

		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDTO.class);
	}
 
}
