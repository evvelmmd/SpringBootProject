package com.company.backend.api;


import com.company.backend.dto.UserCreateDTO;
import com.company.backend.dto.UserUpdateDTO;
import com.company.backend.dto.UserViewDTO;
import com.company.backend.model.User;
import com.company.backend.service.UserService;
import com.company.backend.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;

//    @GetMapping("v1/users")
//    public String message(){
//        String message  = "salam melekim";
//        return message;
//    }


    @GetMapping("v1/user/{id}")  //get user by id
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id) {
        final UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("v1/user")
    public ResponseEntity<List<UserViewDTO>> getUsers(){
        final List<UserViewDTO> users =  userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("v1/user") //user create
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User Created"));
    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable("id") Long id , @RequestBody UserUpdateDTO userUpdateDTO){
        final UserViewDTO user = userService.updateUser(id,userUpdateDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User Deleted"));
    }

    @GetMapping("v1/user/slice")
    public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable){
        final List<UserViewDTO> users = userService.slice(pageable);
        return ResponseEntity.ok(users);

    }
}
