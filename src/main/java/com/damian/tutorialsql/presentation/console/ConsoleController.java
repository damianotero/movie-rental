package com.damian.tutorialsql.presentation.console;

import com.damian.tutorialsql.logic.CustomerService;
import com.damian.tutorialsql.logic.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
public class ConsoleController {
    @Autowired
    private RentService rentService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MoviesMenuController moviesMenuController;

    @Autowired
    private RentMenuController rentMenuController;

     @Autowired
     private  CustomerMenuController customerMenuController;

     @Autowired
     private UserInputController userInputController;

     @Autowired
     private MenuTemplate menuTemplate;


    public void mainMenu() {
        while (true) {
            System.out.print(menuTemplate.createMenu("Pick an option of the list:",
                    asList("1. Customer menu",
                            "2. Movie manager",
                            "3. Rents",
                            "4. Quit")));

            int choice = userInputController.enterNumber();
            switch (choice) {
                case 1:
                    customerMenuController.customerMenu();
                    break;
                case 2:
                    moviesMenuController.movieMenu();
                    break;
                case 3:
                    rentMenuController.rentMenu();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}
