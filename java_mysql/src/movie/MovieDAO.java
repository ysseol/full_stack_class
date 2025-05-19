package movie;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MovieDAO {
	public Connection dbConn() {
		
		Connection conn = null;
		
		try {
			FileInputStream fis = new FileInputStream("c:/work/mysql.prop");
			Properties prop = new Properties();
			prop.load(fis);
			
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, id, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void addMovie(MovieDTO movie) throws SQLException {
		
		String query = "INSERT INTO movies (title, director, genre, release_year) VALUES (?, ?, ?, ?)";
		Connection conn = dbConn();
		
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, movie.getTitle());
			stmt.setString(2, movie.getDirector());
			stmt.setString(3, movie.getGenre());
			stmt.setInt(4, movie.getReleaseYear());
			stmt.executeUpdate();
			System.out.println("Movie added successfully!");
		}
	}
	
	public void updateMovie(MovieDTO movie) throws SQLException {
		Connection conn = dbConn();
		String query = "UPDATE movies SET title = ?, director = ?, genre = ?, release_year = ? WHERE id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, movie.getTitle());
			stmt.setString(2, movie.getDirector());
			stmt.setString(3, movie.getGenre());
			stmt.setInt(4, movie.getReleaseYear());
			stmt.setInt(5, movie.getId());
			stmt.executeUpdate();
			System.out.println("Movie updated successfully!");
		}
	}
	
	public void deleteMovie(int id) throws SQLException {
		Connection conn = dbConn();
		String query = "DELETE FROM movies WHERE id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Movie deleted successfully!");
		}
	}
	
	public List<MovieDTO> getAllMovies() throws SQLException {
		Connection conn = dbConn();
		List<MovieDTO> movies = new ArrayList<>();
		String query = "SELECT * FROM movies";
		
		try (Statement stmt = conn.createStatement();
				
			ResultSet rs = stmt.executeQuery(query)) {
			
			while (rs.next()) {
				MovieDTO movie = new MovieDTO(rs.getInt("id"), 
										rs.getString("title"),
										rs.getString("director"),
										rs.getString("genre"),
										rs.getInt("release_year"));
				movies.add(movie);
			}
		}
		return movies;
	}
	
	public MovieDTO getMovieById(int id) throws SQLException {
		Connection conn = dbConn();
		String query = "SELECT * FROM movies WHERE id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setInt(1, id);
			
			try (ResultSet rs = stmt.executeQuery()) {
				
				if (rs.next()) {
					return new MovieDTO(rs.getInt("id"), 
										rs.getString("title"),
										rs.getString("director"),
										rs.getString("genre"),
										rs.getInt("release_year"));
				}
			}
		}
		return null;
	}
}
