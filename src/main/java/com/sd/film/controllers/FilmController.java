package com.sd.film.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
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
	
	@RequestMapping(value="addFilm.do")
	public String addFilm(){
		return "addfilm";
	}
	
	@RequestMapping(value="createFilm.do")
	public ModelAndView createFilm(Film film){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmaddfilm");
		mv.addObject("film", dao.addFilm(film));
		return mv;
	}
	@RequestMapping(value="deleteFilm.do")
	public ModelAndView deleteFilm(Integer id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmdeletefilm");
		Film film = dao.getFilmById(id);
		mv.addObject("film", film);
		mv.addObject("filmDeleted", dao.deleteFilm(id));		
		return mv;
	}
	@RequestMapping(value="editFilm.do")
	public String editFilm(int id, Model model){
		Film film = dao.getFilmById(id);
		model.addAttribute("film", film);
		return "editfilm";
	}
	
	@RequestMapping(value="updateFilm.do")
	public ModelAndView updateFilm(Film film){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmeditfilm");
		mv.addObject("film", dao.updateFilm(film));
		return mv;
	}
	
}
