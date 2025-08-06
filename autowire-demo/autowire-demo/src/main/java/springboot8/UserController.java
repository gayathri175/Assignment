package springboot8;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public String addUser(@RequestBody User user) {
        return "User received: " + user.getFirstName() + " " + user.getLastName() + ", Age: " + user.getAge();
    }
}
/*http://localhost:8085/users in postman*/