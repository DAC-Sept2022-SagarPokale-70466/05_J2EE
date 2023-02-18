/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 04-Jan-2023 6:26:13 PM
*/

package com.app.payloads;

import lombok.Data;

@Data
public class JwtAuthResponse {
	private String token;
	
	private UserDTO user;
}
