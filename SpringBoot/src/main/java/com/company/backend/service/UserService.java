package com.company.backend.service;

import com.company.backend.dto.UserCreateDTO;
import com.company.backend.dto.UserUpdateDTO;
import com.company.backend.dto.UserViewDTO;
import javassist.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserViewDTO getUserById(Long id);

    List<UserViewDTO> getUsers();

    UserViewDTO createUser(UserCreateDTO userCreateDTO);


    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    void deleteUser(Long id);

    List<UserViewDTO> slice(Pageable pageable);
}
