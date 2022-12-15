/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 06-Dec-2022 4:08:36 PM
*/

package com.app.dao;

import pojos.User;

public interface UserDao {
// Add method for user validation
	User validateUser(String email, String pass);
	
	public String signUpUser(String email, String name, String password);
}
