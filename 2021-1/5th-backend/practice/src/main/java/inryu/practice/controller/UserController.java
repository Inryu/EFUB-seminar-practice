package inryu.practice.controller;

import inryu.practice.model.User;
import inryu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//url : localhost:8080/user
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // get localhost:8080/user
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // get localhost:8080/user/testId1
    // get localhost:8080/user/testId2
    @GetMapping("/{userid}")
    public User getUserByUserId(@PathVariable String userid) {
        return userService.getUserByUserId(userid);
    }

    // post localhost:8080/user
    @PostMapping("")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }



    // put localhost:8080/user/testId1
    @PutMapping("/{userid}")
    public void modifyUser(@PathVariable String userid, @RequestBody User user) {
        userService.modifyUser(userid, user);
    }
    //@PathVariable : 중괄호 {userid}를 받는 부분

    // delete localhost:8080/user/userid
    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable String userid) {
        userService.removeUser(userid);
    }
}
