package shop;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin_servlet/*")
public class AdminController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        String path = request.getContextPath();

        if (url.indexOf("login.do") != -1) {
        	
            AdminDAO dao = new AdminDAO();
            String userid = request.getParameter("userid");
            String passwd = request.getParameter("passwd");
            
            MemberDTO dto = new MemberDTO();
            dto.setUserid(userid);
            dto.setPasswd(passwd);
            
            String name = dao.login(dto);

            if (name == null) {
                String page = path + "/shop/admin_login.jsp?message=error";
                response.sendRedirect(page);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("admin_userid", dto.getUserid());
                session.setAttribute("admin_name", name);
                session.setAttribute("userid", userid);
                session.setAttribute("name", name);
                session.setAttribute("result", name + "님 환영합니다.");
                String page = "/shop/admin_result.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
            }
        } else if (url.indexOf("logout.do") != -1) {
            HttpSession session = request.getSession();
            session.invalidate();
            String page = path + "/shop/admin_login.jsp?message=logout";
            response.sendRedirect(page);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
