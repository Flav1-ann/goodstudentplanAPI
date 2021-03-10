package eu.ensup.goodstudentplan.services;


import eu.ensup.goodstudentplan.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import eu.ensup.goodstudentplan.domain.User;
import eu.ensup.goodstudentplan.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUserRepository userRepository;

    @Override
    public ResponseEntity<Set<UserDto>> findAll(){
        Iterable<User> userIterable = userRepository.findAll();
        Set<UserDto> userSet = new HashSet<>();
        for (User user: userIterable) {
            userSet.add(convertToDto(user));
        }
        return new ResponseEntity<>(userSet, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> findById(long id){
        Optional<User> queriedUser = userRepository.findById(id);
        return queriedUser.map(user -> new ResponseEntity<>(convertToDto(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UserDto userDto){
        Optional<User> existingUser = userRepository.findById(userDto.getId());
        if(existingUser.isPresent()){
            return new ResponseEntity<>(convertToDto(userRepository.save(convertToEntity(userDto))), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto){
        return new ResponseEntity<>(convertToDto(userRepository.save(convertToEntity(userDto))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteUser(long id){
        Optional<User> toDeleteUser = userRepository.findById(id);
        if (toDeleteUser.isPresent()){
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @Override
    public UserDto convertToDto(User user){
        return  modelMapper.map(user, UserDto.class);
    }

    @Override
    public User convertToEntity(UserDto userDto){
        return  modelMapper.map(userDto, User.class);
    }

}
