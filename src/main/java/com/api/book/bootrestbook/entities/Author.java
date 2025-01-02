package com.api.book.bootrestbook.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int authorId;
    private String firstname;
    private String lastname;
    private String language;

    
}
