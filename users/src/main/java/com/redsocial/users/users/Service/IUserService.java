package com.redsocial.users.users.Service;

import com.redsocial.users.users.Model.Dto.UserDto;
import com.redsocial.users.users.Model.Entity.User;


public interface IUserService {

    User save(UserDto user);
    User findById(Integer id);    
    
}
