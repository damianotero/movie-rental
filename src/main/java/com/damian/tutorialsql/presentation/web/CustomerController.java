package com.damian.tutorialsql.presentation.web;


import com.damian.tutorialsql.logic.Customer;
import com.damian.tutorialsql.logic.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/home")
    public String customerMenu(Model model) {
        return "customer";
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customerList", customerService.getCustomers());
        return "listCustomers";
    }

    @GetMapping("/search")
    public String searchCustomer(Model model, @RequestParam String name) {
        model.addAttribute("customerList", customerService.searchCustomer(name));
        return "listCustomers";
    }


    @GetMapping("/addCustomer")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomerSubmit(@ModelAttribute Customer customer, BindingResult errors, Model model) {
        customerService.addCustomer(customer);
        model.addAttribute("customerList", customerService.getCustomers());
        return "listCustomers";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerList", customerService.getCustomers());
        return "deleteCustomer";
    }

    @PostMapping("/deleteCustomer")
    public String deleteCustomerSubmit(@ModelAttribute Customer customer, BindingResult errors, Model model) {
        customerService.deleteCustomer(customer.getId());
        model.addAttribute("customerList", customerService.getCustomers());
        return "deleteCustomer";
    }

    @GetMapping("/changeCustomerAddress")
    public String changeCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerList", customerService.getCustomers());
        return "changeCustomerAddress";
    }

    @PostMapping("/changeCustomerAddress")
    public String changeCustomerAddressSubmit(@ModelAttribute Customer customer, BindingResult errors, Model model) {
        customerService.changeAddress(customer.getId(), customer.getAddress());
        model.addAttribute("customerList", customerService.getCustomers());
        return "changeCustomerAddress";
    }
}
