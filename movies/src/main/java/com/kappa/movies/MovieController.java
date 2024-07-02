package com.kappa.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(),HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
//        return new ResponseEntity<>(movieService.getSingleMovie(id),HttpStatus.OK);
//    }
//
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String id){
        return new ResponseEntity<>(movieService.getMovieById(id),HttpStatus.OK);
    }
    @PostMapping("/submit")
    public ResponseEntity<Optional<Movie>> getMoviesById(@RequestParam("userString") String id){
        return new ResponseEntity<>(movieService.getMovieById(id),HttpStatus.OK);
    }






}
