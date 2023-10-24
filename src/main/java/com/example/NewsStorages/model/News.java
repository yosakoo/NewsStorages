package com.example.NewsStorages.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "companyTag", nullable = false)
    private String company_tag;

    @Column(name = "content", nullable = false)
    private String content;
}