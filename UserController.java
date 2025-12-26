package com.modeling.modeling.controller;

import com.modeling.modeling.model.Department;
import com.modeling.modeling.model.User;
import com.modeling.modeling.service.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServices userService;

    public UserController(UserServices userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getById((id));
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @PutMapping
    public User update(
            @PathVariable Long id,
            @RequestBody User user
    ){
        return userService.update(id,user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "Delete Successfully";

    }


}
