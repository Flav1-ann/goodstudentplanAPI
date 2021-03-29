package eu.ensup.goodstudentplan.controller;

import eu.ensup.goodstudentplan.dto.AuthenticationResponse;
import eu.ensup.goodstudentplan.dto.LoginRequest;
import eu.ensup.goodstudentplan.dto.RegisterRequest;
import eu.ensup.goodstudentplan.services.AuthServiceImpl;
import eu.ensup.goodstudentplan.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Auth")
public class AuthController {

    @Autowired
    private IAuthService authService;


    @PostMapping("/register")
    public ResponseEntity<HttpStatus> signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }


}