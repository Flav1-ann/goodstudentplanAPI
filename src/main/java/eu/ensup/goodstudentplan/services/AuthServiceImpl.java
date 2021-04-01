package eu.ensup.goodstudentplan.services;

import eu.ensup.goodstudentplan.domain.User;
import eu.ensup.goodstudentplan.dto.AuthenticationResponse;
import eu.ensup.goodstudentplan.dto.LoginRequest;
import eu.ensup.goodstudentplan.dto.RegisterRequest;
import eu.ensup.goodstudentplan.dto.UserDto;
import eu.ensup.goodstudentplan.repository.IUserRepository;
import eu.ensup.goodstudentplan.security.JwtProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private ModelMapper modelMapper;

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail().toLowerCase());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setLastName(registerRequest.getLastName());
        user.setName(registerRequest.getFirstName());
        userRepository.save(user);
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getLogin().toLowerCase(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtProvider.generateToken(authenticate);

        AuthenticationResponse authenticationResponse = null;
        Optional<User> user = userRepository.findByEmail(loginRequest.getLogin().toLowerCase());

        if (user.isPresent()){
            authenticationResponse = convertDataToAuth(user.get());
            authenticationResponse.setAuthenticationToken(authenticationToken);
        }
        return authenticationResponse;
    }
    public AuthenticationResponse convertDataToAuth(User user) {
        return modelMapper.map(user, AuthenticationResponse.class);
    }
}
