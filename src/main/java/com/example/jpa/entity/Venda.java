package com.example.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estamos informando ao RDBMS que o id será gerado automaticamente
    private Long id;
    private LocalDate data;
    private BigDecimal valorTotal;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento; //a vista ou a prazo

    @ManyToOne
    private Vendedor vendedor;


    public Venda() {
        super();
    }

    public Venda(Long id, LocalDate data, BigDecimal valorTotal, FormaPagamento formaPagamento, Vendedor vendedor) {
        super();
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.vendedor = vendedor;
    }
    public Venda(LocalDate data, BigDecimal valorTotal, FormaPagamento formaPagamento, Vendedor vendedor) {
        super();
        this.data = data;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.vendedor = vendedor;
    }

}
