package com.example.backendPortafolio.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsInterface extends JpaRepository<Card, Long> {

    @Override
    List<Card> findAll();

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteById(Long aLong);



}
