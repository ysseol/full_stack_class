package survey;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SurveyDTO {
	private int survey_idx;
	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private String status;
}
