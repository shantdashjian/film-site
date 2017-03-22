package com.sd.film.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sd.film.data.Film;
import com.sd.film.data.FilmDao;
import com.sd.film.data.FilmDaoDbImpl;

@Controller
public class FilmController {
	private FilmDao dao = new FilmDaoDbImpl();
	
	@RequestMapping(value="home.do")
	public String home(){
		return "home";
	}
	@RequestMapping(value="getTitle.do")
	public ModelAndView getFilmById(Integer id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		Film film = dao.getFilmById(id);
		mv.addObject("film", film);
		mv.addObject("id", id);
		return mv;
	}
	
	@RequestMapping(value="searchFilmsByTitle.do")
	public ModelAndView searchFilmsByTitle(String keyword){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		List<Film> searchResults = dao.getFilmsByTitle(keyword);
		mv.addObject("searchResults", searchResults);
		mv.addObject("keyword", keyword);
		return mv;
	}
}
