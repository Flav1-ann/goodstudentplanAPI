package eu.ensup.goodstudentplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationResponse {
    private  int id;
    private String authenticationToken;
    private String name;
    private String lastName;
    private String email;
    private String sexe;
    private Date birthday;
    private String address;
}
