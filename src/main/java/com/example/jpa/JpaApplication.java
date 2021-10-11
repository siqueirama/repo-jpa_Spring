package com.example.jpa;

import com.example.jpa.entity.Endereco;
import com.example.jpa.entity.SituacaoVendedor;
import com.example.jpa.entity.Vendedor;
import com.example.jpa.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    @Autowired
    VendedorRepository vendedorRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Vendedor vendedor = new Vendedor("MLB698","256.894.153-50", "Caio", SituacaoVendedor.ATIVO);//colocar o vendedor
        List<Endereco> endereco = Arrays.asList(new Endereco("01118-888", "logradouro do wagner", "ap 3", 4005, "ES", "Vitória", vendedor));
        vendedor.setEnderecos(endereco);
        vendedorRepository.save(vendedor);
    }

}
