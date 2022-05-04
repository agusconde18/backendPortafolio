package com.example.backendPortafolio.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TiposInterface extends JpaRepository<TipoCard, Long> {

    @Override
    List<TipoCard> findAll();

    TipoCard findByDescripcion(String descripcion);
}
