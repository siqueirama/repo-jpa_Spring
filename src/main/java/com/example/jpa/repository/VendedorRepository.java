package com.example.jpa.repository;


import com.example.jpa.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, String> {

    Vendedor findByNome(String nome);
}


