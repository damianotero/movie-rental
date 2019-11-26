package com.damian.tutorialsql.logic;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieResults {

    @JsonProperty("Search")
    private List<OmdbMovie> search;

    private String totalResults;

    @JsonProperty("Response")
    private String response;

    public List<OmdbMovie> getSearch() {
        return search;
    }

    public void setSearch(List<OmdbMovie> search) {
        this.search = search;
    }

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
}
