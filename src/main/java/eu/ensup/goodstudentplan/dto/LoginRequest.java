package eu.ensup.goodstudentplan.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class LoginRequest {
    private String login;
    private String password;
}