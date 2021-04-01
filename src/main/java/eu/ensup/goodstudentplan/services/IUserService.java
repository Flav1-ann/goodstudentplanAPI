package eu.ensup.goodstudentplan.services;


import eu.ensup.goodstudentplan.domain.User;
import eu.ensup.goodstudentplan.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface IUserService {

    ResponseEntity<Set<UserDto>> findAll();

    ResponseEntity<UserDto> findById(int id);


    ResponseEntity<UserDto> updateUser(UserDto userDto);

    ResponseEntity<UserDto> createUser(UserDto userDto);

    ResponseEntity<HttpStatus> deleteUser(int id);


    UserDto convertToDto(User user);

    User convertToEntity(UserDto userDto);
}
