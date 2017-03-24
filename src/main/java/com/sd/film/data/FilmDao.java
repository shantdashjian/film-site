package com.sd.film.data;

import java.util.List;

public interface FilmDao {
	Film getFilmById(Integer id);
	List<Film> getFilmsByTitle(String keyword);
	List<Actor> getCast(Integer id);
	Film addFilm(Film film);
	boolean deleteFilm(Integer id);
	Film updateFilm(Film film);

}
