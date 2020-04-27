package com.knowledgedb.tinyreminder.dao;

import com.knowledgedb.tinyreminder.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
}
