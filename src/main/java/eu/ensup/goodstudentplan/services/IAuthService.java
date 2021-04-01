package eu.ensup.goodstudentplan.services;

import eu.ensup.goodstudentplan.dto.AuthenticationResponse;
import eu.ensup.goodstudentplan.dto.LoginRequest;
import eu.ensup.goodstudentplan.dto.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface IAuthService {
    void signup(RegisterRequest registerRequest);
    String encodePassword(String password);
    AuthenticationResponse login(LoginRequest loginRequest);
}
