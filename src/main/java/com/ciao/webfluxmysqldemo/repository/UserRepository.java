package com.ciao.webfluxmysqldemo.repository;


import com.ciao.webfluxmysqldemo.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, String> {
}
