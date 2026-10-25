package com.example.ecomerceelectric.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@Table (name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private long id;

    @Column (nullable = false,length = 40)
    private String nombre;

    @Column (nullable = false,length = 200)
    private String descripcion;

    @Column (nullable = false,length = 20)
    private String codigoSku;

    @Column (nullable = false,length = 200)
    private BigDecimal precio;

    @Column (nullable = false)
    private String imagenUrl;

    @Column (nullable = false,updatable = false)
    private LocalDateTime fechaRegistro;

    private boolean active;

    @PrePersist 
    private void antesdeGuardar(){

        if (fechaRegistro==null) {
            fechaRegistro=LocalDateTime.now();
        }
    }



}
