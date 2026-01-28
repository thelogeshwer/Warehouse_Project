package com.warehouse.service;

import com.warehouse.model.User;
import com.warehouse.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public void createUser(User user) {
        userRepo.save(user);
    }
}
