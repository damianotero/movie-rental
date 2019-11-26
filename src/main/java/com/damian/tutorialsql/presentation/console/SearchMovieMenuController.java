package com.damian.tutorialsql.presentation.console;

import com.damian.tutorialsql.logic.Movie;
import com.damian.tutorialsql.logic.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class SearchMovieMenuController {

    @Autowired
    private MenuTemplate menuTemplate;

    @Autowired
    private UserInputController userInputController;

    @Autowired
    private MovieService movieService;

    public void searchMovie() {

        System.out.print(menuTemplate.createMenu("Select the field to search:",
                asList("1. ID",
                        "2. Title",
                        "3. Main Actor",
                        "4. Year",
                        "5. Genre")));

        int choice = userInputController.enterNumber();

        switch (choice) {
            case 1:
                System.out.println("Type the ID:");
                Movie movie = movieService.searchById(userInputController.enterNumber());
                System.out.println(movie.toString());
                break;
            case 2:
                System.out.println("Type the title:");
                List<Movie> movieList = movieService.searchByTitle(userInputController.enterText());
                System.out.println(movieList.size() + " movie(s) founded:");
                printList(movieList);
                break;
            case 3:
                System.out.println("Type the main actor:");
                List<Movie> movieListByActor = movieService.searchByMainActor(userInputController.enterText());
                System.out.println(movieListByActor.size() + " movie(s) founded:");
                printList(movieListByActor);
                break;
            case 4:
                System.out.println("Type the year:");
                movieList = movieService.searchByYear(userInputController.enterNumber());
                System.out.println(movieList.size() + " movie(s) founded:");
                printList(movieList);
                break;
            case 5:
                System.out.println("Type genre:");
                movieList = movieService.searchByGenre(userInputController.enterText());
                System.out.println(movieList.size() + " movie(s) founded:");
                printList(movieList);
                break;
            default:
                break;
        }
    }

    public void printList(List<Movie> movieList) {
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println(movieList.get(i).toString());
        }
    }
}
