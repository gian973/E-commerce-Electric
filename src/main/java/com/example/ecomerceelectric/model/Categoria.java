package com.example.ecomerceelectric.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Setter 
@Getter
@AllArgsConstructor 
@NoArgsConstructor 
@Table (name = "categoria") 

public class Categoria {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id ;

    @Column (nullable = false,length = 40)
    private String nombre;

    @Column (nullable = false,length = 200)
    private String descripcion;

    private boolean active;


}
