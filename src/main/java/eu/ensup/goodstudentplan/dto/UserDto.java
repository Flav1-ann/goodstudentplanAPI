package eu.ensup.goodstudentplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private long id;

    private String name;

    private String lastName;

    private String email;


}
