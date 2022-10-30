package com.spring.java.phoneshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "models")
@Data
public class Model {
    @Id
    @SequenceGenerator(
            name = "model_sequence",
            sequenceName = "model_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "model_sequence"
    )
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    // allow to custom name of column
    @JoinColumn(name = "the_brand_id")
    private Brand brand;
}
