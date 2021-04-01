package eu.ensup.goodstudentplan.dto;

import eu.ensup.goodstudentplan.domain.User;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

    private long id;
    private String title;
    private String description;
    private String image;
    private int price;
    private Date saleAt;
    private Date buyAt;
    private String category;
    private String subCategory;
    private User Seller;
}
