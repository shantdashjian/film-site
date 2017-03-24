package com.sd.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statementToGetFilmTitleAndDescription = connection
					.prepareStatement(sqlToGetFilmTitleAndDescription);
			statementToGetFilmTitleAndDescription.setInt(1, id);
			ResultSet resultSetForFilm = statementToGetFilmTitleAndDescription.executeQuery();
			if (resultSetForFilm.next()) {
				film = new Film();
				film.setId(id);
				film.setTitle(resultSetForFilm.getString(1));
				film.setDescription(resultSetForFilm.getString(2));

				film.setCast(getCast(id));
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

	public List<Actor> getCast(Integer id) {
		List<Actor> cast = null;
		String sqlToGetCast = "SELECT actor.first_name, actor.last_name " + "FROM film_actor JOIN actor "
				+ "	ON film_actor.actor_id = actor.id WHERE film_actor.film_id = ?";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statementToGetCast = connection.prepareStatement(sqlToGetCast);
			statementToGetCast.setInt(1, id);
			ResultSet resultSetForCast = statementToGetCast.executeQuery();
			cast = new ArrayList<>();
			while (resultSetForCast.next()) {
				Actor actor = new Actor();
				actor.setFirstName(resultSetForCast.getString(1));
				actor.setLastName(resultSetForCast.getString(2));
				cast.add(actor);
			}
			resultSetForCast.close();
			statementToGetCast.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cast;
	}

	@Override
	public List<Film> getFilmsByTitle(String keyword) {
		List<Film> results = new ArrayList<>();

		String sql = "select id, title, description from film where title LIKE ?";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sql);
			String pattern = "%" + keyword + "%";
			statement.setString(1, pattern);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String description = resultSet.getString(3);
				Film film = new Film();
				film.setId(id);
				film.setTitle(title);
				film.setDescription(description);
				film.setCast(getCast(id));
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

	@Override
	public Film addFilm(Film filmToAdd) {
		Film film = null;
		String sql = "INSERT INTO film (title, description, release_year"
				+ ", language_id, rental_duration, rental_rate, length, replacement_cost)"
				+ " VALUES(?, ?, ?, 1, ?, ?, ?, ?)";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, filmToAdd.getTitle());
			statement.setString(2, filmToAdd.getDescription());
			statement.setInt(3, filmToAdd.getReleaseYear());
			statement.setInt(4, filmToAdd.getRentalDuration());
			statement.setDouble(5, filmToAdd.getRentalRate());
			statement.setInt(6, filmToAdd.getLength());
			statement.setDouble(7, filmToAdd.getReplacementCost());

			statement.execute();
			String sqlToGetLastInsertId = "SELECT last_insert_id()";

			statement = connection.prepareStatement(sqlToGetLastInsertId);
			ResultSet result = statement.executeQuery();
			film = filmToAdd;
			if (result.next()) {
				film.setId(result.getInt(1));

			}
			result.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public boolean deleteFilm(Integer id) {
		
		String sqlDeleteFromFilm = "DELETE from film where id = ?";
		Connection connection = null;
		PreparedStatement statementToDelete = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
			
			statementToDelete = connection.prepareStatement(sqlDeleteFromFilm);
			statementToDelete.setInt(1, id);
			int rowsAffected = statementToDelete.executeUpdate();
			connection.commit();
			statementToDelete.close();
			connection.close();
			if (rowsAffected == 1) {					
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			
		}

	}

	
	@Override
	public Film updateFilm(Film film) {
		String sql = "UPDATE film SET title = ?, description = ?, release_year = ?"
				+ ", rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?"
				+ " WHERE id = ?";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, film.getTitle());
			statement.setString(2, film.getDescription());
			statement.setInt(3, film.getReleaseYear());
			statement.setInt(4, film.getRentalDuration());
			statement.setDouble(5, film.getRentalRate());
			statement.setInt(6, film.getLength());
			statement.setDouble(7, film.getReplacementCost());
			statement.setInt(7, film.getId());

			int numRowsUpdated = statement.executeUpdate();
			statement.close();
			connection.close();
			
			if (numRowsUpdated == 1) {
				return film;
			} else {
				return null;
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
}
