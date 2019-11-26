package com.damian.tutorialsql.logic;


import com.damian.tutorialsql.data.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private MovieService movieService;

    public void rentMovie(Rent rent) {
        Date today = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(today.toInstant(),
                ZoneId.systemDefault());
        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
        Date output = Date.from(zdt.toInstant());
        rent.setDate(output);
        Movie movie = movieService.searchById(rent.getMovie_id());
        rent.setPrice(movie.getPrice() * rent.getRentDays());
        rentRepository.rentMovie(rent);
    }

    public List<Rent> getRentsByCustomer(int id) {
        return rentRepository.getRentsByCustomer(id);
    }

    public List<Rent> getRentsOfMovie(int id) {
        return rentRepository.getRentsOfMovie(id);
    }

    public List<Rent> getRents (){
        return rentRepository.getRents();
    }
}
