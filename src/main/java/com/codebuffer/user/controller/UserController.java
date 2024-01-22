package com.codebuffer.user.controller;

import com.codebuffer.user.VO.ResponseTemplateVO;
import com.codebuffer.user.entity.User;
import com.codebuffer.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") int userId){
        return userService.getUserWithDepartment(userId);
    }
}
