package com.example.demo.api.service;

//Esse código define uma classe de serviço, todos os comandos dos métodos estão setadas aqui dentro

import com.example.demo.api.apiModelo.user;
import com.example.demo.api.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private repository userRepository;

    public List<user> findAll() {
        return userRepository.findAll();
    }

    public Optional<user> findById(Long id) {
        return userRepository.findById(id);
    }

    public user save(user user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
