package com.mcp.mymcpserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyMcpServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyMcpServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
