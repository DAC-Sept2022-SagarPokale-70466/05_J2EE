/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 06-Dec-2022 4:21:22 PM
*/

package com.app.service;

import pojos.User;

public interface UserService {

//	Add B.L Method for User Validation
	User authenticateUser(String em, String pass);
	
	String signUpUser(String email, String name, String password);
}
