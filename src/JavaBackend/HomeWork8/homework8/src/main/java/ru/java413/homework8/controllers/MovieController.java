package ru.java413.homework8.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.java413.homework8.models.Movie;
import ru.java413.homework8.models.MovieApiResponse;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/movie")
public class MovieController {
    private List<Movie> movies;

    public MovieController() {
        movies = new ArrayList<>();
    }

    String baseUrl = "http://www.omdbapi.com/";
    String apiKey = "be8fee90";

    //http://localhost:8080/api/movie/search/Hulk?skip=35&count=18
    @GetMapping("/search/{title}")
    public ResponseEntity<?> getMovie(
            @PathVariable String title,
            @RequestParam(required = false, defaultValue = "0") Integer skip,
            @RequestParam(required = false, defaultValue = "10") Integer count) {
        RestTemplate restTemplate = new RestTemplate();

        String url = baseUrl + "?apiKey=" + apiKey + "&s=" + title + "&page=";


        int newPages = (int) Math.ceil((double) (skip + count) / 10); //добавил приведение к double, иначе не выдавал данные с последней страницы

        //добавление стартовой страницы, затем стартового фильма, если стартовая страница при skip =0 будет равна 0, то переводим запрос на первую страницу
        int startPage = (int) Math.ceil((double) skip / 10);
        if (startPage == 0) {
            startPage = 1;
        }
        int startMovie = skip % 10;


        //первый запрос на стартовую страницу
        System.out.println("Send # " + startPage);
        ResponseEntity<MovieApiResponse> response = restTemplate.getForEntity(url + startPage, MovieApiResponse.class);
        ArrayList<Movie> arr = new ArrayList<>();

        if (response.getStatusCode().is2xxSuccessful()) {
            MovieApiResponse result = response.getBody();
            arr.addAll(result.getSearch());

//            int totalResult = Integer.parseInt(result.getTotalResults());
//            int pages = (int) Math.ceil(totalResult / 10.0);

            for (int i = startPage + 1; i <= newPages; i++) {
                //запросы на оставшиеся страницы после стартовой
                System.out.println("Send # " + i);
                response = restTemplate.getForEntity(url + i, MovieApiResponse.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    result = response.getBody();
                    arr.addAll(result.getSearch());
                }
            }

            result.setSearch(arr.stream().skip(startMovie).limit(count).toList());

            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
