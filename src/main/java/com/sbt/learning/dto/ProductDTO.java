package com.sbt.learning.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ProductDTO {
    @Length(min=3, max=10, message="Name must be of length between 3-10 characters.")
    private String productName;

    @Length(min=5, max=50, message="Description must be of length between 5-50 characters.")
    private String productDescription;

    @Min(value=1, message = "Price must be non-negative")
    private double productPrice;
}
