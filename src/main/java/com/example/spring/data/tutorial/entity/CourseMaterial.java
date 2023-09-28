package com.example.spring.data.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "CourseMaterial_sequence",
            sequenceName = "CourseMaterial_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "CourseMaterial_sequence")
    private Long courseMaterialId;
    private String url;


    @OneToOne(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    optional = false)
    @JoinColumn
    private Course course;

}
