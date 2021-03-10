package eu.ensup.goodstudentplan.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String description;
    private String image;
    private int price;
    private int size;


}
