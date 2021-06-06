package com.company.backend.service;

import com.company.backend.dto.UserCreateDTO;
import com.company.backend.dto.UserUpdateDTO;
import com.company.backend.dto.UserViewDTO;
import com.company.backend.exception.NotFoundException;
import com.company.backend.model.User;
import com.company.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserViewDTO getUserById(Long id) throws NotFoundException {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Class  tapilmadi"));

        return UserViewDTO.of(user);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public List<UserViewDTO> getUsers() {

        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository.save(new User(userCreateDTO.getUsername(),userCreateDTO.getFirstName() , userCreateDTO.getLastName()));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user  = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Bu id de user yoxdur."));

        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());

        final User updated = userRepository.save(user);
        return UserViewDTO.of(updated);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        final User user  = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Bu id de user yoxdur."));

        userRepository.deleteById(user.getId());
    }

    @Override
    @Transactional(readOnly = true  , propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> slice(Pageable pageable) {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }
}
