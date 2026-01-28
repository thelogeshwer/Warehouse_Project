package com.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String vendor;

    @Positive
    private int price;

    @Min(1)
    private int stock;
    @NotBlank
    @Pattern(regexp="^[A-Z]{3}$")
    private String currency;
    @NotBlank
    @Pattern(regexp="^https?://.*")
    private String image_url;
    @NotBlank
    private String sku;
}
