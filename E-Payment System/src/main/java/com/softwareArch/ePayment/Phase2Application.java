package com.softwareArch.ePayment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Phase2Application {

    public static void main(String[] args) {
        Startup s1 = new Startup();
        //this will initialize the users
        s1.InitializeUsers();
        SpringApplication.run(Phase2Application.class, args);
    }

}
