/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 04-Jan-2023 6:36:13 PM
*/

package com.app.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String username;
	private String password;
}

