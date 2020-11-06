package com.example.quizclasssimple.Service;

import com.example.quizclasssimple.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import repository.UserRepository;

import java.util.List;

public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    public List<User> showAll(){return userRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));}
    public List<User> searchByName(String name) {
        return userRepository.findByFullnameSorted(name);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> sort(List<User> list) {
        return userRepository.findByOrderByFullnameAsc();
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public User get(int id) {
        return userRepository.getOne(id);
    }

    public void save(User u) {
        userRepository.save(u);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
