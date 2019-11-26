package com.damian.tutorialsql.presentation.console;

import com.damian.tutorialsql.logic.Movie;
import com.damian.tutorialsql.logic.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class MoviesMenuController {


    @Autowired
    private MovieService movieService;

    @Autowired
    private MenuTemplate menuTemplate;

    @Autowired
    private UserInputController userInputController;

    @Autowired
    SearchMovieMenuController searchMovieMenuController;

    public void movieMenu() {
        while (true) {
            System.out.print(menuTemplate.createMenu("Pick an option of the list:",
                    asList("1. List the movies",
                            "2. Search movie",
                            "3. Add a movie",
                            "4. Delete Movie",
                            "5. Change movie price",
                            "6. Back")));

            int choice = userInputController.enterNumber();
            switch (choice) {
                case 1:
                    listMovies();
                    break;
                case 2:
                    searchMovieMenuController.searchMovie();
                    break;
                case 3:
                    addMovie();
                    break;
                case 4:
                    deleteMovie();
                    break;
                case 5:
                    changePrice();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("wrong option .. please provide na valid option");
            }
        }
    }


    public void addMovie() {
        Movie movie = new Movie();
        System.out.println("Enter title of the movie:");
        movie.setTitle(userInputController.enterText());
        System.out.println("Enter the main Actor?");
        movie.setMainActor(userInputController.enterText());
        System.out.println("Enter the year of the film?");
        movie.setYear(userInputController.enterNumber());
        System.out.println("Enter the genre");
        movie.setGenre(userInputController.enterText());
        movieService.addMovie(movie);
        System.out.println("The movie: " + movie.toString() + " was successfully added.");
    }

    public void deleteMovie() {
        System.out.println("Enter the ID of the movie to delete:");
        movieService.deleteMovie(userInputController.enterNumber());
        System.out.println("The movie was deleted!");
    }




    public void changePrice() {
        System.out.println("Enter Movie ID:");
        int id = userInputController.enterNumber();
        movieService.searchById(userInputController.enterNumber());
        System.out.println("Enter new price:");
        double price = userInputController.enterDouble();
        movieService.changePrice(id, price);
        System.out.println("Price updated!");
    }

    public void listMovies() {
        List<Movie> movieList = movieService.getMovies();
        searchMovieMenuController.printList(movieList);
    }
}
