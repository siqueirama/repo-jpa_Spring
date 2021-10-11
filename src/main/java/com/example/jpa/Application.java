package com.example.jpa;

import com.example.jpa.dao.VendedorPersistence;
import com.example.jpa.entity.Anuncio;
import com.example.jpa.entity.Pedido;
import com.example.jpa.repository.PedidoRepository;
import com.example.jpa.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Pedido> pedidosDeHoje = pedidoRepository.getByData(LocalDate.now());

        pedidosDeHoje.forEach(p -> {
            System.out.println(p.getId() + "  " + p.getData().toString());
            List<PedidoRepository.Anuncio> anuncios = pedidoRepository.euQueroOsAnuncios(p.getId());
            anuncios.forEach(a -> System.out.println(a.getCodigo() + " " + a.getTitulo()));
        });
    }

}
