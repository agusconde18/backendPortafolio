package com.example.backendPortafolio.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User, Long> {


    User getByEmailAndPassword(String email,String password);

}
