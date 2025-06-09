package recipe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeDTO {
	private String id;
	private String title;
	private String ingredients;
	private String steps;
}
