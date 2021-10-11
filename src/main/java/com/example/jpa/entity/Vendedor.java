package com.example.jpa.entity;


import lombok.Data;
import com.example.jpa.entity.SituacaoVendedor;
import javax.persistence.*;
import java.util.List;



@Data
@Entity
@Table(name = "vendedores")
public class Vendedor {

    @Id
    private String codigo;
    private String cpf;
    private String nome;
    @Enumerated(EnumType.STRING)
    private SituacaoVendedor situacao;

    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    public Vendedor() {
        // TODO Auto-generated constructor stub
    }

    public Vendedor(String codigo, String cpf, String nome, List<Endereco> enderecos) {
        super();
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.enderecos = enderecos;
    }

    public Vendedor(String codigo, String cpf, String nome) {
        super();
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Vendedor(String cpf, String nome, List<Endereco> enderecos) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.enderecos = enderecos;
    }

    public Vendedor(String codigo, String cpf, String nome, SituacaoVendedor situacaoVendedor) {
        super();
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        situacao = situacaoVendedor;
    }
    public void setSituacao(SituacaoVendedor situacao) {
        this.situacao = situacao;
    }
    public SituacaoVendedor getSituacao() {
        return situacao;
    }
}