package com.damian.tutorialsql.presentation;


import com.damian.tutorialsql.presentation.console.MenuTemplate;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuTemplateTest {


    @Test
    public void createMenu_shouldReturnValidMenu() {
       MenuTemplate menuTemplate = new MenuTemplate();

       String menu = menuTemplate.createMenu("Mi titulo", asList("1 - List Movie", "2 - Search Movie"));

       assertThat(menu).isEqualTo("");
    }
}