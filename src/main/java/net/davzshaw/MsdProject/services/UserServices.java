package net.davzshaw.MsdProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.davzshaw.MsdProject.entities.User;
import net.davzshaw.MsdProject.repositories.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String email, String password) {
      if (userRepository.findByEmail(email) != null) {
          return null;
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public void updatePreferencesByEmail(String email, String preferences) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setPreferences(preferences);
            userRepository.save(user);
        }
    }

    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }
}
