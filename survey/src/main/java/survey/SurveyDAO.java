package survey;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import sqlmap.MybatisManager;

public class SurveyDAO {
	public SurveyDTO view(int survey_idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		SurveyDTO dto = session.selectOne("survey.view", survey_idx);
		session.close();
		return dto;
	}

	public void insert(AnswerDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.insert("survey.insert", dto);
		session.commit();
		session.close();
	}
	
	public List<SummaryDTO> summary(int survey_idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		List<SummaryDTO> items = session.selectList("survey.summary", survey_idx);
		session.close();
		return items;
	}
	
	public String summary_json(int survey_idx) {
		List<SummaryDTO> items = summary(survey_idx);
		JSONArray jArray = new JSONArray();
		
		for (SummaryDTO dto : items) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("survey_idx", dto.getSurvey_idx());
			jsonObj.put("sum_num", dto.getSum_num());
			jsonObj.put("rate", dto.getRate());
			jArray.add(jsonObj);
		}
		
		JSONObject jsonMain = new JSONObject();
		jsonMain.put("sendData", jArray);
		
		return jsonMain.toString();
	}
	
	public String question(int survey_idx) {
		SurveyDTO dto = view(survey_idx);
		
		JSONObject obj = new JSONObject();
		obj.put("survey_idx", dto.getSurvey_idx());
		obj.put("question", dto.getQuestion());
		
		for (int i = 1; i <= 4; i++) {
			String key = "ans" + i;
			String value = switch (i) {
			case 1 -> dto.getAns1();
			case 2 -> dto.getAns2();
			case 3 -> dto.getAns3();
			case 4 -> dto.getAns4();
			default -> null;
			};
			obj.put(key, value);
		}
		
		return obj.toString();
	}
}
