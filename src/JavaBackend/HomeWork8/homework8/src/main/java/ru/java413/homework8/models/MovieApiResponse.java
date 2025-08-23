package ru.java413.homework8.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieApiResponse {
    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("Response")
    private String response;
    @JsonProperty("Search")
    private List<Movie> search;

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<Movie> getSearch() {
        return search;
    }

    public void setSearch(List<Movie> search) {
        this.search = search;
    }
}
