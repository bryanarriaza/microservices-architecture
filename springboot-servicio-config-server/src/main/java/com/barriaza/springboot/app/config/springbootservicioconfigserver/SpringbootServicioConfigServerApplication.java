package com.barriaza.springboot.app.config.springbootservicioconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringbootServicioConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioConfigServerApplication.class, args);
    }

}