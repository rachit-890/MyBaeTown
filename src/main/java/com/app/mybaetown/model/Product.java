package com.app.mybaetown.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Double mrpPrice;
    private Double sellingPrice;
    private int discountPercentage;
    private int quantity;

    @ManyToOne
    private Seller seller;

    @ElementCollection
    private List<String> images=new ArrayList<>();
    private int numRatings;

    @ManyToOne
    private Category category;
    private LocalDate createdAt;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true )
    private List<Review> reviews = new ArrayList<>();

}
