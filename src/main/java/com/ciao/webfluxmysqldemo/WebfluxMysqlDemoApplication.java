package com.ciao.webfluxmysqldemo;

import com.ciao.webfluxmysqldemo.repository.DefaultR2dbcRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories(repositoryBaseClass = DefaultR2dbcRepository.class)
public class WebfluxMysqlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxMysqlDemoApplication.class, args);
    }

}
