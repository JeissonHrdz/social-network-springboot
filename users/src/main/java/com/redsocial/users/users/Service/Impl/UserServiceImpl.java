package com.redsocial.users.users.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.redsocial.users.users.Model.Dao.UserDao;
import com.redsocial.users.users.Model.Dto.UserDto;
import com.redsocial.users.users.Model.Entity.User;
import com.redsocial.users.users.Service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User save(UserDto userDto) {
        User user = User.builder()
                .idUser(userDto.getIdUser())
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .dateRegister(userDto.getDateRegister())
                .password(userDto.getPassword())
                .build();
        return userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

}
