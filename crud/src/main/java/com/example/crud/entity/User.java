package com.example.crud.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name= "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
}
