package com.example.ecomerceelectric.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
@AllArgsConstructor 
@NoArgsConstructor 
@Table (name = "customer")

public class Cliente {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false,length = 100) 
    private String nombre;

    @Column (nullable = false,length = 100)
    private String apellidos;

    @Column (nullable = false,length = 30)
    private String tipo_documento;

    @Column (nullable = false,length = 14)
    private String numero_documento;

    @Column (nullable = false,length = 100)
    private String correo;

    @Column (nullable = false,length = 30)
    private String telefono;

    @Column (nullable = false,updatable = false)
    @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha_registro;

    private boolean active;

    @PrePersist 
    private void antes(){
        if (fecha_registro==null) {
            fecha_registro= LocalDate.now();
        }
    }



}
