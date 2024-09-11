package com.kasim.bookstore.service;

import com.kasim.bookstore.model.User;
import com.kasim.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id){
        return Optional.ofNullable(userRepository.getById(id));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.delete(userRepository.getById(id));
    }
}
