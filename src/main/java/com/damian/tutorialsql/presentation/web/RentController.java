package com.damian.tutorialsql.presentation.web;


import com.damian.tutorialsql.logic.Rent;
import com.damian.tutorialsql.logic.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rents")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("/listRents")
    public String rentList(Model model) {
        model.addAttribute("rentList", rentService.getRents());
        return "listRents";
    }

    @GetMapping("/newRent")
    public String newRentForm(Model model) {
        model.addAttribute("rent", new Rent());
        return "newRent";
    }

    @PostMapping("/newRent")
    public String newRentSubmit(@ModelAttribute Rent rent, BindingResult errors, Model model) {
        rentService.rentMovie(rent);
        model.addAttribute("rentList", rentService.getRents());
        return "listRents";
    }

    @GetMapping("/search")
    public String searchRent(Model model, @RequestParam int id) {
        model.addAttribute("rentList", rentService.getRentsByCustomer(id));
        return "listRents";
    }
    @GetMapping("/searchByMovie")
    public String searchRentsByMovie(Model model, @RequestParam int id) {
        model.addAttribute("rentList", rentService.getRentsOfMovie(id));
        return "listRents";
    }

}
