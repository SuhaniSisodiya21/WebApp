package com.flipr.WebApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ must match JSON key: "imageUrl"
    private String imageUrl;

    // ✅ must match JSON key: "name"
    private String name;

    // ✅ must match JSON key: "description"
    @Column(length = 2000)
    private String description;
}
