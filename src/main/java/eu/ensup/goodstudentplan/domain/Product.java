package eu.ensup.goodstudentplan.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private String image;
    private int price;
    private Date saleAt;
    private Date buyAt;
    private String category;
    private String subCategory;
    @ManyToOne
    private User Seller;



}
