/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 05-Jan-2023 9:25:35 PM
*/

package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
