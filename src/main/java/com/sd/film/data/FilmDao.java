package com.sd.film.data;

import java.util.List;

public interface FilmDao {
	Film getFilmById(Integer id);

	List<Film> getFilmsByTitle(String keyword);

}
