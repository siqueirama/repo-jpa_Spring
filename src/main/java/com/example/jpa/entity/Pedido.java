package com.example.jpa.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @ManyToMany
    private List<Anuncio> anuncios;

    @Transient
    private BigDecimal valorTotal;


    public Pedido() {
    }

    public Pedido(LocalDate data, List<Anuncio> anuncios) {
        super();
        this.data = data;
        this.anuncios = anuncios;
    }
}
