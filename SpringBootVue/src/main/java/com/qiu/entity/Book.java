package com.qiu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置主键自增
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Float price;
    private Integer pages;
}
