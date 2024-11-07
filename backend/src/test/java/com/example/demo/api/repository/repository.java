package com.example.demo.api.repository;

import com.example.demo.api.apiModelo.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<user, Long> {
}
/*
    Esse repositório, é a interface do Jpa que está definido na classe user.
     Esse cara fornece os métodos prontos para um crud no user do banco de dados.
 */

