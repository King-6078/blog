package com.example.demo.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class lx {
    @Id
    private Integer id;
    private String name;
    private Integer age;
}
