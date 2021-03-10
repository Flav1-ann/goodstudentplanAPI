package eu.ensup.goodstudentplan.dto;

import lombok.*;

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
    private int size;
}
