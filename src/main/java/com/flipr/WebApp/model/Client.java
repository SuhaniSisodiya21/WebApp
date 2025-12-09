package com.flipr.WebApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;     // JSON: "imageUrl"
    private String name;        // JSON: "name"

    @Column(length = 2000)
    private String description; // JSON: "description"

    private String designation; // JSON: "designation"
}
