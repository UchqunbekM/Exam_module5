package com.example.exam_module5.Product;

import com.example.exam_module5.Category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    private Long id;
    private String name;
    private Integer salary;
    private Category category;

    private Long categoryId;
    private String imgUrl;

    public Product(Long id, String name, Integer salary, Category category, String imgUrl) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.category = category;
        this.imgUrl = imgUrl;
    }
}
