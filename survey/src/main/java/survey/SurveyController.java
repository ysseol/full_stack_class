package survey;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class SurveyController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String url = request.getRequestURI();
		SurveyDAO dao = new SurveyDAO();
		if (url.indexOf("question.do") != -1) {
			int survey_idx = Integer.parseInt(request.getParameter("survey_idx"));
			String result = dao.question(survey_idx);
			response.getWriter().println(result);
		} else if (url.indexOf("insert.do") != -1) {
			int survey_idx = Integer.parseInt(request.getParameter("survey_idx"));
			int num = Integer.parseInt(request.getParameter("num"));
			AnswerDTO dto = new AnswerDTO();
			dto.setSurvey_idx(survey_idx);
			dto.setNum(num);
			dao.insert(dto);
			response.sendRedirect(path + "/success.jsp");
		} else if (url.indexOf("summary_json.do") != -1) {
			int survey_idx = Integer.parseInt(request.getParameter("survey_idx"));
			String result = dao.summary_json(survey_idx);
			response.getWriter().println(result);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
