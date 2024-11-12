package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.model.User;
import com.taskmaster.taskmaster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor//a injecao de dependencia sera feita via metodo construtor
//o spring entende que e uma bean controller para uso de requisicoes Rest (baseada em HTTP)
@RestController

//path de acesso ao recurso (controller), ou seja,
//o caminho base dentro dos recursos da controller

@RequestMapping("api/v1/users")//caminho
public class UserController {

    @Autowired
    private final UserService userService; //injecao de dependencia para o service

    //cria usuario no banco
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User user1 = userService.save(user);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(user1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> searchById(@PathVariable Long id){
        User user1 = userService.getById(id);
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/lists")
    public List<User> userList(){
      return userService.getAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        User user1 = userService.getById(id);
        user.setId(id);
        userService.save(user1);
        return ResponseEntity.ok(user1);
    }

}

