package com.redsocial.users.users.Model.Dao;

import org.springframework.data.repository.CrudRepository;

import com.redsocial.users.users.Model.Entity.User;

public interface UserDao extends CrudRepository<User, Integer> {
    
}
