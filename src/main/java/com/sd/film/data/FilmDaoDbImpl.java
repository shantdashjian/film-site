package com.sd.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

public class FilmDaoDbImpl implements FilmDao {
	private static String url = "jdbc:mysql://localhost:3306/sdvid";
	private String user = "student";
	private String password = "student";

	public FilmDaoDbImpl() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	}

	@Override
	public Film getFilmById(Integer id) {
		Film film = null;

		String sqlToGetFilmTitleAndDescription = "select title, description from film where id = ?";
		String sqlToGetActorsNames = "SELECT actor.first_name, actor.last_name " + "FROM film_actor JOIN actor "
				+ "	ON film_actor.actor_id = actor.id WHERE film_actor.film_id = ?";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statementToGetFilmTitleAndDescription = connection
					.prepareStatement(sqlToGetFilmTitleAndDescription);
			statementToGetFilmTitleAndDescription.setInt(1, id);
			ResultSet resultSetForFilm = statementToGetFilmTitleAndDescription.executeQuery();
			if (resultSetForFilm.next()) {
				film = new Film();
				film.setTitle(resultSetForFilm.getString(1));
				film.setDescription(resultSetForFilm.getString(2));

				PreparedStatement statementToGetActorsNames = connection.prepareStatement(sqlToGetActorsNames);
				statementToGetActorsNames.setInt(1, id);
				ResultSet resultSetForActors = statementToGetActorsNames.executeQuery();
				List<Actor> actors = new ArrayList<>();
				while (resultSetForActors.next()) {
					Actor actor = new Actor();
					actor.setFirstName(resultSetForActors.getString(1));
					actor.setLastName(resultSetForActors.getString(2));
					actors.add(actor);
				}
				film.setActors(actors);

				resultSetForActors.close();
				statementToGetActorsNames.close();
			}
			resultSetForFilm.close();
			statementToGetFilmTitleAndDescription.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> getFilmsByTitle(String keyword) {
		List<Film> results = new ArrayList();

		String sql = "select title, description from film where title LIKE ?";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sql);
			String pattern = "%" + keyword + "%";
			statement.setString(1, pattern);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String title = resultSet.getString(1);
				String description = resultSet.getString(2);
				Film film = new Film();
				film.setTitle(title);
				film.setDescription(description);
				results.add(film);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

}
