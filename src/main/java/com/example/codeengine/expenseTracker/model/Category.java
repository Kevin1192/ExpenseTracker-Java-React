package com.example.codeengine.expenseTracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="category")
public class Category {


    @Id
    private Long id;

    private String name;


}
