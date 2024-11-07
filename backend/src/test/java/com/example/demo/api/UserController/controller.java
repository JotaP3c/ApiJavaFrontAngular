package com.example.demo.api.UserController;


import com.example.demo.api.apiModelo.user;
import com.example.demo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class controller {

    @Autowired
    private UserService userService;

    //Interprete isso aqui como um read por favor :(

    @GetMapping("/{id}")
    public ResponseEntity<user> getUserById(@PathVariable Long id)
    {
        Optional<user> user = userService.findById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<user> getAllUsers() {
        return userService.findAll();
    }

    //Aqui é para criar o usuário no banco
    @PostMapping
    public user createUser(@RequestBody user user) {
        return userService.save(user);
    }

    //Aqui é para atualizar as informações do usuário, update no crud.
    @PutMapping("/{id}")
    public ResponseEntity<user> updateUser(@PathVariable Long id, @RequestBody user updatedUser)
    {
        Optional<user> user = userService.findById(id);
        if (!user.isEmpty())
        {
            updatedUser.setId(id);
            userService.save(updatedUser);
            return ResponseEntity.ok(updatedUser);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    //Função de deletar do Crud, espero que funcione
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id)
    {
        Optional<user> user = userService.findById(id);
        if(!user.isEmpty())
        {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else
        {
         return ResponseEntity.notFound().build();
        }
    }

}
