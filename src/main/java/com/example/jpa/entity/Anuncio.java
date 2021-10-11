package com.example.jpa.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name="anuncios")
public class Anuncio {

    @Id
    private String codigo;
    private String titulo;
    private BigDecimal preco;
    @Column(name="data_anuncio")
    private LocalDate dataAnuncio;
    @Column(name="num_vendas")
    private int numeroVendas;

    public Anuncio() {
        // TODO Auto-generated constructor stub
    }

    public Anuncio(String titulo, BigDecimal preco, LocalDate dataAnuncio, int numeroVendas) {
        super();
        this.titulo = titulo;
        this.preco = preco;
        this.dataAnuncio = dataAnuncio;
        this.numeroVendas = numeroVendas;
    }

    public Anuncio(String codigo, String titulo, BigDecimal preco, LocalDate dataAnuncio, int numeroVendas) {
        super();
        this.codigo = codigo;
        this.titulo = titulo;
        this.preco = preco;
        this.dataAnuncio = dataAnuncio;
        this.numeroVendas = numeroVendas;
    }

}
