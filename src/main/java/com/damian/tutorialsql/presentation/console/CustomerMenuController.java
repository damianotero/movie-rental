package com.damian.tutorialsql.presentation.console;

import com.damian.tutorialsql.logic.Customer;
import com.damian.tutorialsql.logic.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class CustomerMenuController {

    @Autowired
    private UserInputController userInputController;

    @Autowired
    private MenuTemplate menuTemplate;

    @Autowired
    private CustomerService customerService;

    public void customerMenu() {

        while (true) {
            System.out.print(menuTemplate.createMenu("Pick an option of the list:",
                    asList("1. List customers",
                            "2. Search Customer",
                            "3. Add a new customer",
                            "4. Delete a customer",
                            "5. Change customer's address",
                            "6. Back to Main Menu")));
            int choice = userInputController.enterNumber();
            switch (choice) {
                case 1:
                    listCustomers();
                    break;
                case 2:
                    searchCustomer();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    changeAddress();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    private void changeAddress() {
        System.out.println("Select the customer's ID to update address:\n");
        listCustomers();
        int id = userInputController.enterNumber();
        System.out.println("Enter the new address:");
        String newAddress = userInputController.enterText();
        customerService.changeAddress(id, newAddress);
        System.out.println("Customer's Address updated!!");
    }

    private void deleteCustomer() {
        System.out.println("Select the customer's ID to delete:");
        System.out.println();
        listCustomers();
        customerService.deleteCustomer(userInputController.enterNumber());
        System.out.println("Customer deleted!");
    }

    private void searchCustomer() {
        List<Customer> customerList;
        System.out.println("Enter the name to search: ");
        customerList = customerService.searchCustomer(userInputController.enterText());
        System.out.println(customerList.size() + " customer(s) founded:");
        for (Customer customers : customerList) {
            System.out.println(customers.toString());
        }
    }

    private void addCustomer() {
        Customer customer = new Customer();
        System.out.println("Enter complete name:");
        customer.setName(userInputController.enterText());
        System.out.println("Enter address");
        customer.setAddress(userInputController.enterText());
        customerService.addCustomer(customer);
        System.out.println("Customer: " + customer.getName() + "successfully added!");
    }

    public void listCustomers() {
        List<Customer> customerList;
        customerList = customerService.getCustomers();
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }
}
