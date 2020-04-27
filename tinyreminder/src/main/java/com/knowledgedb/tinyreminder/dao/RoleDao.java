package com.knowledgedb.tinyreminder.dao;

import com.knowledgedb.tinyreminder.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
