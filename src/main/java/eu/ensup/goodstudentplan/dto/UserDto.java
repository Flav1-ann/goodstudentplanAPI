package eu.ensup.goodstudentplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String sexe;
    private Date birthday;
    private String address;

}
