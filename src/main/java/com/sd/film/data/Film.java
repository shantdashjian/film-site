package com.sd.film.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Film {
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private Rating rating;
	private Set<SpecialFeatures> specialFeatures;
	private List<Actor> cast;
	
	
	public Film() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getReleaseYear() {
		return releaseYear;
	}


	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}


	public int getLanguageId() {
		return languageId;
	}


	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}


	public int getRentalDuration() {
		return rentalDuration;
	}


	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}


	public double getRentalRate() {
		return rentalRate;
	}


	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public double getReplacementCost() {
		return replacementCost;
	}


	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}


	public Rating getRating() {
		return rating;
	}


	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public void setRating(String rating) {
		this.rating = Rating.valueOf(rating);
	}


	public Set<SpecialFeatures> getSpecialFeatures() {
		return specialFeatures;
	}


	public void setSpecialFeatures(Set<SpecialFeatures> specialFeatures) {
		this.specialFeatures = specialFeatures;
	}


	public List<Actor> getCast() {
		return new ArrayList<>(cast);
	}


	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}


	
	
	
}
