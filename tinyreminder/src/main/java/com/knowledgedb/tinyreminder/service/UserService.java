package com.knowledgedb.tinyreminder.service;

import com.knowledgedb.tinyreminder.entity.User;
import com.knowledgedb.tinyreminder.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
