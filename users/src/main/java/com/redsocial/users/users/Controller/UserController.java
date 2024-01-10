package com.redsocial.users.users.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redsocial.users.users.Exception.ResourceNotFoundException;
import com.redsocial.users.users.Model.Dto.UserDto;
import com.redsocial.users.users.Model.Entity.User;
import com.redsocial.users.users.Model.Payload.MessageResponse;
import com.redsocial.users.users.Service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        User userSave = null;

        try {
            userSave = userService.save(userDto);
            userDto = UserDto.builder()
                    .idUser(userSave.getIdUser())
                    .name(userSave.getName())
                    .lastName(userSave.getLastName())
                    .email(userSave.getEmail())
                    .dateRegister(userSave.getDateRegister())
                    .password(userSave.getPassword())
                    .build();
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Registrado Correcatmente")
                    .object(userDto)
                    .build(),
                    HttpStatus.CREATED);
        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(DTeX.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("/profile/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        System.out.println(id);
      
        if (user == null) {        
            throw new ResourceNotFoundException("user", "id", id);            
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Usuario encontrado")
                        .object(UserDto.builder()
                                .idUser(user.getIdUser())
                                .name(user.getName())
                                .lastName(user.getLastName())
                                .email(user.getEmail())
                                .dateRegister(user.getDateRegister())
                                .password(user.getPassword())
                                .build())
                        .build(),
                HttpStatus.OK);

    }

}
