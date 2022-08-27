package com.example.exam_module5.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.Exam.category.Category;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    private Long id;
    private String name;
    private String description;
    private Category category;

    private Long categoryId;
    private String imgUrl;

    public Product(Long id, String name, String description, Category category, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.imgUrl = imgUrl;
    }
}
