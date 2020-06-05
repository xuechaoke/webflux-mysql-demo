package com.ciao.webfluxmysqldemo.controller;

import com.ciao.webfluxmysqldemo.entity.Mr;
import com.ciao.webfluxmysqldemo.entity.User;
import com.ciao.webfluxmysqldemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @program: webflux-mysql-demo
 * @author: ciao
 * @description:
 * @create: 2020-06-05 14:57
 **/
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("save")
    public Mono<Mr<User>> save(@RequestBody User user) {
        return Mr.ok(userService.save(user));
    }
}
