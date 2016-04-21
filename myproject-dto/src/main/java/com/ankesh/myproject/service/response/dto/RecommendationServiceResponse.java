package com.ankesh.myproject.service.response.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ankesh.myproject.service.dto.MovieDTO;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecommendationServiceResponse {

	@JsonProperty(value="recommendedMovies")
	private List<MovieDTO> movies;
	
	@JsonProperty(value="userName")
	private String userName;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<MovieDTO> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieDTO> movies) {
		this.movies = movies;
	}
	
}
