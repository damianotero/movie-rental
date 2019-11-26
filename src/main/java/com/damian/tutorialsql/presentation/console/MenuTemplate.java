package com.damian.tutorialsql.presentation.console;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuTemplate {

    public String createMenu(String title, List<String> options) {
        StringBuilder menu = new StringBuilder();
        menu.append("\n");
        menu.append("\n");
        menu.append(title + "\n");
        menu.append("\n");

        for (String option : options) {
            menu.append("    " + option + "\n");
        }

        menu.append("\n");
        menu.append("-> ");
        return menu.toString();
    }

}
