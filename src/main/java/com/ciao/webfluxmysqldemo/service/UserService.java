package com.ciao.webfluxmysqldemo.service;

import com.ciao.webfluxmysqldemo.entity.User;
import reactor.core.publisher.Mono;

public interface UserService {

     Mono<User> save(User user);
}
