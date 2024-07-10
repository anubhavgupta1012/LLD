package com.org.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    private int id;
    private String name;
    private String number;
    private String password;
}
