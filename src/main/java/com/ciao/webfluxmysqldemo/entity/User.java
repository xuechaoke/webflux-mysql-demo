package com.ciao.webfluxmysqldemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



@Data
@EqualsAndHashCode(callSuper = false)
@Table("sys_user")
public class User   {
    @Id
    private String id;
    private String username;
    private String password;

}
