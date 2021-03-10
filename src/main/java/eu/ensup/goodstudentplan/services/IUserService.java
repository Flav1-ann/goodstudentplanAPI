package eu.ensup.goodstudentplan.services;


import eu.ensup.goodstudentplan.domain.User;
import eu.ensup.goodstudentplan.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface IUserService {

    ResponseEntity<Set<UserDto>> findAll();

    ResponseEntity<UserDto> findById(long id);

    ResponseEntity<UserDto> updateUser(UserDto userDto);

    ResponseEntity<UserDto> createUser(UserDto userDto);

    ResponseEntity<HttpStatus> deleteUser(long id);

    UserDto convertToDto(User user);

    User convertToEntity(UserDto userDto);
}
