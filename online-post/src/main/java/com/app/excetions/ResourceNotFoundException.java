/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 27-Dec-2022 12:07:03 AM
*/

package com.app.excetions;

public class ResourceNotFoundException extends RuntimeException {

	String resouceName;
	String fieldName;
	long fieldValue;

	public ResourceNotFoundException(String resouceName, String fieldName, long fieldValue) {
		super(String.format("%s not Found with this name %s : %s", resouceName, fieldName, fieldValue));
		this.resouceName = resouceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
