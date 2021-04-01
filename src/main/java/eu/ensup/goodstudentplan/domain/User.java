package eu.ensup.goodstudentplan.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String sexe;
    private Date birthday;
    private String address;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Product> products;


}
