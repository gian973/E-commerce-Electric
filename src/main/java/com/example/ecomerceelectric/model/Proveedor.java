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
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@Table (name = "proveedor")

public class Proveedor {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false,length = 40)
    private String ruc;

    @Column (nullable = false,length = 200)
    private String razon_social;

    @Column (nullable = false,length = 30)
    private String nombre_contacto;

    @Column (nullable = false,length = 30)
    private String correo;

    @Column (nullable = false,length = 30)
    private String telefono;

    @Column (nullable = false,length = 30)
    private String direccion;

    private boolean activo;

}
