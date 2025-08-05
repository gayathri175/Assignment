package com.example.boot15;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> findAll() { return repo.findAll(); }
    public User findById(Long id) { return repo.findById(id).orElseThrow(() -> new UserNotFoundException(id)); }
    public User create(User u) { return repo.save(u); }
    public User update(Long id, User u) {
        User existing = findById(id);
        existing.setName(u.getName());
        existing.setAge(u.getAge());
        existing.setSalary(u.getSalary());
        return repo.save(existing);
    }
    public void delete(Long id) { repo.delete(findById(id)); }
}
