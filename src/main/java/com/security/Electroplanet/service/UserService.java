package com.security.Electroplanet.service;

import com.security.Electroplanet.IDao.Idao;
import com.security.Electroplanet.Repository.UserRepository;
import com.security.Electroplanet.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements Idao<User> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(User o) {
        return userRepository.save(o);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(User o) {

        userRepository.delete(o);
    }

    @Override
    public void update(User o) {

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
