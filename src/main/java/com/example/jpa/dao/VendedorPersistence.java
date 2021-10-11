package com.example.jpa.dao;


import com.example.jpa.entity.SituacaoVendedor;
import com.example.jpa.entity.Vendedor;
import com.example.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.sql.PreparedStatement;
import java.util.List;

public class VendedorPersistence {

    private EntityManager em;

    public VendedorPersistence(){
        em = JPAUtil.getEntityManager();
    }

    public void atualiza(Vendedor vendedor) {

    }

    public List<Vendedor> lista(){
        TypedQuery<Vendedor> qry = em.createQuery("From Vendedor", Vendedor.class);
        return qry.getResultList();
    }


    public Vendedor get(String codigo) {
        return em.find(Vendedor.class, codigo);
    }

    public void insere(Vendedor vendedor) {
        em.getTransaction().begin();
        em.persist(vendedor);
        em.getTransaction().commit();
    }

    public void exclui(String codigo) {

    }


    public void atualizaSituacaoVendedoresEmLote() {
        em.getTransaction().begin();

        List<Vendedor> vendedores = lista();
        vendedores.forEach(v -> {
            v.setSituacao(SituacaoVendedor.INATIVO);
            em.merge(v);
        });

        em.getTransaction().commit();
    }
}
