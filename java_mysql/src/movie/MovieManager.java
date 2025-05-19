package movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MovieManager {
	private static MovieDAO dao;
	
	public static void main(String[] args) {
		
		dao = new MovieDAO();
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("\nMovie Management System");
			System.out.println("1. Add movie");
			System.out.println("2. Update Movie");
			System.out.println("3. Delete Movie");
			System.out.println("4. View All Movies");
			System.out.println("5. View Movie by ID");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
				case 1:
					addMovie(scanner);
					break;
				case 2:
					updateMovie(scanner);
					break;
				case 3:
					deleteMovie(scanner);
					break;
				case 4:
					viewAllMovies();
					break;
				case 5:
					viewMovieById(scanner);
					break;
				case 6:
					System.out.println("Exiting this program.");
					return;
				default:
					System.out.println("Invalid choice, please try again.");
			}
		}
	}
	
	private static void addMovie(Scanner scanner) {
		System.out.print("Enter movie title: ");
		String title = scanner.nextLine();
		System.out.print("Enter movie director: ");
		String director = scanner.nextLine();
		System.out.print("Enter movie genre: ");
		String genre = scanner.nextLine();
		System.out.print("Enter movie release year: ");
		int releaseYear = scanner.nextInt();
		scanner.nextLine();
		
		MovieDTO movie = new MovieDTO(0, title, director, genre, releaseYear);
		
		try {
			dao.addMovie(movie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void updateMovie(Scanner scanner) {
		System.out.print("Enter movie ID to update: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new movie title: ");
		String title = scanner.nextLine();
		System.out.println("Enter new movie director: ");
		String director = scanner.nextLine();
		System.out.print("Enter new movie genre: ");
		String genre = scanner.nextLine();
		System.out.print("Enter new movie release year: ");
		int releaseYear = scanner.nextInt();
		scanner.nextLine();
		
		MovieDTO movie = new MovieDTO(id, title, director, genre, releaseYear);
		
		try {
			dao.updateMovie(movie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void deleteMovie(Scanner scanner) {
		System.out.print("Enter movie ID to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		try {
			dao.deleteMovie(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void viewAllMovies() {
		try {
			List<MovieDTO> movies = dao.getAllMovies();
			
			for (MovieDTO movie : movies) {
				System.out.println(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void viewMovieById(Scanner scanner) {
		System.out.print("Enter movie ID to view: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		try {
			MovieDTO movie = dao.getMovieById(id);
			
			if (movie != null) {
				System.out.println(movie);
			} else {
				System.out.println("Movie not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
