package com.backenwebmail.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.backenwebmail.entity.ListaDeCorreos;

import java.util.Optional;

public interface ListaDeCorreoRepository extends JpaRepository<ListaDeCorreos, Integer> {
    public Optional<ListaDeCorreos> findByCategoriaCorreo(String categoria);
    public Optional<ListaDeCorreos> findById(Integer id);
}
