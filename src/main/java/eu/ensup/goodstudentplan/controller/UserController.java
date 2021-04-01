package eu.ensup.goodstudentplan.controller;

import eu.ensup.goodstudentplan.dto.UserDto;
import eu.ensup.goodstudentplan.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/findAll")
    public ResponseEntity<Set<UserDto>> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDto> findUserById( @PathVariable int id){
        return userService.findById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@Validated @RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Validated @RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }



}
