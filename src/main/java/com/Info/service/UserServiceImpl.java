package com.Info.service;

import com.Info.model.entity.MyUser;
import com.Info.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<MyUser> getAllUsers() {
        return (List<MyUser>) userRepository.findAll();
    }

    @Override
    public MyUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(MyUser user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    @Override
    public void addUser(String username) {
        MyUser user = new MyUser();
//        user.setUsername(username);
        userRepository.save(user);
    }
}
