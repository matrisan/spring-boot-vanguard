package com.matrixboot.vanguard.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * Main
 *
 * @author shishaodong
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootVanguardManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootVanguardManagerApplication.class, args);
    }

}
