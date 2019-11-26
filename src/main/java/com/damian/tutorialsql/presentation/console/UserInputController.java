package com.damian.tutorialsql.presentation.console;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserInputController {

    Scanner scanner = new Scanner(System.in);

    public int enterNumber(){
        return Integer.valueOf(scanner.nextLine());
    }

    public String enterText(){
        return scanner.nextLine();
    }

    public double enterDouble(){
        return Double.valueOf(scanner.nextDouble());
    }
}
