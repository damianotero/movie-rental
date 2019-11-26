package com.damian.tutorialsql;

import com.damian.tutorialsql.presentation.console.ConsoleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialsqlApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TutorialsqlApplication.class);

    @Autowired
    private ConsoleController consoleController;

    public static void main(String[] args) {
        SpringApplication.run(TutorialsqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("This executes!");
       // consoleController.mainMenu();
    }


}



