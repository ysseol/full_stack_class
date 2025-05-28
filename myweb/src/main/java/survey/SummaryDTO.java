package survey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SummaryDTO {
	private int survey_idx;
	private int num;
	private int sum_num;
	private double rate;
}
