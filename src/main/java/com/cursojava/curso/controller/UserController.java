package com.cursojava.curso.controller;


import com.cursojava.curso.dao.UserDao;
import com.cursojava.curso.models.User;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "api/user/{id}")
    public User getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Lucas");
        user.setLastname("Moy");
        user.setEmail("lucas@hotmail.com");
        user.setPhone("4544545");
    return  user;
    }

    @RequestMapping(value = "api/users", method =RequestMethod.GET)
    public List<User> getAllUser(@RequestHeader(value="Authorization") String token) {
        if(!validateToken(token)){
            return null;
        }
       return userDao.getusers();
    }

    private boolean validateToken(String token){
        String idUser = jwtUtil.getKey(token);
        return idUser != null;

    }

    @RequestMapping(value = "api/users", method =RequestMethod.POST)
    public void registerUser(@RequestBody User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash= argon2.hash(1, 1024,1, user.getPassword());
        user.setPassword(hash);
        userDao.registerUser(user);
    }

    @RequestMapping(value = "prueba1")
    public User editUser() {
        User user = new User();
        user.setName("Lucas");
        user.setLastname("Moy");
        user.setEmail("lucas@hotmail.com");
        user.setPhone("4544545");
        return  user;
    }

    @RequestMapping(value = "api/deleteUser/{id}", method = RequestMethod.DELETE)
    public void  deleteUser(@PathVariable Long id, @RequestHeader(value="Authorization") String token) {
        if(!validateToken(token)){
            return;
        }
        userDao.deleteUser(id);
    }


}
