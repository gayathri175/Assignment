package com.example.boot15;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired private UserService svc;

    @GetMapping public List<User> getAll() { return svc.findAll(); }
    @GetMapping("/{id}") public User getOne(@PathVariable Long id) { return svc.findById(id); }
    @PostMapping public User create(@RequestBody User u) { return svc.create(u); }
    @PutMapping("/{id}") public User update(@PathVariable Long id, @RequestBody User u) {
        return svc.update(id, u);
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { svc.delete(id); }
}
