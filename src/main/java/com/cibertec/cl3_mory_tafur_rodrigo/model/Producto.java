package com.cibertec.cl3_mory_tafur_rodrigo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Table(name = "tbl_productos")
@Entity
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;

    private Integer stock;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

}
