package ru.geekbrains.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private long cost;

    protected Product() {
    }
}
