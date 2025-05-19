package movie;

public class MovieDTO {
	private int id;
	private String title;
	private String director;
	private String genre;
	private int releaseYear;
	
	public MovieDTO(int id, String title, String director, String genre, int releaseYear) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	public String getGenre() {
		return genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Title=" + title + ", Director=" + director + ", Genre=" + genre
				+ ", Year=" + releaseYear;
	}
}
