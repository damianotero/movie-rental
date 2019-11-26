package com.damian.tutorialsql.presentation.console;

import com.damian.tutorialsql.logic.MovieService;
import com.damian.tutorialsql.logic.Rent;
import com.damian.tutorialsql.logic.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class RentMenuController {

    @Autowired
    private MoviesMenuController moviesMenuController;

    @Autowired
    private RentService rentService;

    @Autowired
    private UserInputController userInputController;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MenuTemplate menuTemplate;

    @Autowired
    private CustomerMenuController customerMenuController;



    public void rentMenu() {

        while (true) {

            System.out.print(menuTemplate.createMenu("Pick an option of the list:",
                    asList("1. List all rents",
                            "2. List rents of a specific customer",
                            "3. List rents of a specific movie",
                            "4. Add new Rent",
                            "5. Back to Main Menu")));

            int choice =userInputController.enterNumber();
            switch (choice) {
                case 1:
                    listRents();
                    break;
                case 2:
                    listRentByCustomer();
                    break;
                case 3:
                    listRentsOfMovie();
                    break;
                case 4:
                    addRent();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    private void listRentsOfMovie() {
        System.out.println("Select the Movie ID:");
        moviesMenuController.listMovies();
        List<Rent> rentList = rentService.getRentsOfMovie(userInputController.enterNumber());
        for (Rent rents : rentList) {
            System.out.println(rents.toString());
        }
    }

    private void listRentByCustomer() {
        System.out.println("Select the customer's ID:");
        customerMenuController.listCustomers();
        List<Rent> rentList = rentService.getRentsByCustomer(userInputController.enterNumber());
        for (Rent rents : rentList) {
            System.out.println(rents.toString());
        }
    }

    private void listRents() {
        List<Rent> rentList = rentService.getRents();
        for (Rent rents : rentList) {
            System.out.println(rents.toString());
        }
    }

    private void addRent() {
        Rent rent = new Rent();
        System.out.println("Enter the customer ID:");
        customerMenuController.listCustomers();
        rent.setCustomer_id(userInputController.enterNumber());
        System.out.println("Enter the movie ID");
        moviesMenuController.listMovies();
        rent.setMovie_id(userInputController.enterNumber());
        System.out.println("How many days?");
        rent.setRentDays(userInputController.enterNumber());
        rentService.rentMovie(rent);
        System.out.println("Rent registered.");
    }
}
