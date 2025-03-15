package org.example.ikm.services;

import org.example.ikm.models.Users;
import org.example.ikm.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    public void save(Users users) {
        usersRepository.save(users);
    }

    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
}