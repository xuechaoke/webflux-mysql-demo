package com.ciao.webfluxmysqldemo.service.impl;

import com.ciao.webfluxmysqldemo.entity.User;
import com.ciao.webfluxmysqldemo.repository.UserRepository;
import com.ciao.webfluxmysqldemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @program: webflux-mysql-demo
 * @author: ciao
 * @description:
 * @create: 2020-06-05 14:52
 **/
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final DatabaseClient databaseClient;
    private final UserRepository userRepository;


    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }
}
