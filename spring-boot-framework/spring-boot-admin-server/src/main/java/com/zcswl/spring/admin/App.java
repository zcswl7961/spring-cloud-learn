package com.zcswl.spring.admin;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot admin
 *
 * @author zhoucg
 * @date 2020-02-27 15:15
 */
@SpringBootApplication
@EnableAdminServer
public class App {

    public static void main(String[] args) {
        SpringApplication.run( App.class, args );
    }
}
