package board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import page.PageUtil;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10, location = "c:/upload/")
@WebServlet("/board_servlet/*")
public class BoardController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        String contextPath = request.getContextPath();
        BoardDAO dao = new BoardDAO();

        if (url.indexOf("list.do") != -1) {
            int count = dao.count();
            int cur_page = 1;
            if (request.getParameter("cur_page") != null) {
                cur_page = Integer.parseInt(request.getParameter("cur_page"));
            }
            PageUtil page = new PageUtil(count, cur_page);
            int start = page.getPageBegin();
            int end = page.getPageEnd();
            List<BoardDTO> list = dao.list(start, end);
            request.setAttribute("list", list);
            request.setAttribute("page", page);
            RequestDispatcher rd = request.getRequestDispatcher("/board/list.jsp");
            rd.forward(request, response);
        } else if (url.indexOf("insert.do") != -1) {
            BoardDTO dto = new BoardDTO();
            String filename = "-";
            int filesize = 0;
            try {
                for (Part part : request.getParts()) {
                    filename = part.getSubmittedFileName();
                    if (filename != null && !filename.equals("null") && !filename.equals("")) {
                        filesize = (int) part.getSize();
                        part.write(filename);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String writer = request.getParameter("writer");
            String subject = request.getParameter("subject");
            String contents = request.getParameter("contents");
            String passwd = request.getParameter("passwd");
            String ip = request.getRemoteAddr();
            dto.setWriter(writer);
            dto.setSubject(subject);
            dto.setContents(contents);
            dto.setPasswd(passwd);
            dto.setIp(ip);
            if (filename == null || filename.trim().equals("")) {
                filename = "-";
            }
            dto.setFilename(filename);
            dto.setFilesize(filesize);
            dao.insert(dto);
            response.sendRedirect(contextPath + "/board_servlet/list.do");
        } else if (url.indexOf("view.do") != -1) {
            int num = Integer.parseInt(request.getParameter("num"));
            HttpSession session = request.getSession();
            dao.plus_hit(num, session);
            BoardDTO dto = dao.view(num);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("/board/view.jsp");
            rd.forward(request, response);
        } else if (url.indexOf("download.do") != -1) {
            int num = Integer.parseInt(request.getParameter("num"));
            String filename = dao.getFilename(num);
            String path = "c:/upload/" + filename;
            byte[] buffer = new byte[4096];
            FileInputStream fis = new FileInputStream(path);
            String mimeType = getServletContext().getMimeType(path);
            if (mimeType == null) {
                mimeType = "application/octet-stream;charset=UTF-8";
            }
            filename = new String(filename.getBytes("utf-8"), "8859_1");
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            ServletOutputStream out = response.getOutputStream();
            int len;
            while (true) {
                len = fis.read(buffer, 0, buffer.length);
                if (len == -1) {
                    break;
                }
                out.write(buffer, 0, len);
            }
            out.flush();
            out.close();
            fis.close();
            dao.plus_down(num);
        } else if (url.indexOf("insert_comment.do") != -1) {
            BoardCommentDTO dto = new BoardCommentDTO();
            int board_num = Integer.parseInt(request.getParameter("board_num"));
            String writer = request.getParameter("writer");
            String contents = request.getParameter("contents");
            dto.setBoard_num(board_num);
            dto.setWriter(writer);
            dto.setContents(contents);
            dao.insert_comment(dto);
        } else if (url.indexOf("list_comment.do") != -1) {
            int num = Integer.parseInt(request.getParameter("num"));
            List<BoardCommentDTO> list = dao.list_comment(num);
            request.setAttribute("list", list);
            String page = "/board/list_comment.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(page);
            rd.forward(request, response);
        } else if (url.indexOf("check_pwd.do") != -1) {
            int num = Integer.parseInt(request.getParameter("num"));
            String passwd = request.getParameter("passwd");
            String result = dao.check_pwd(num, passwd);
            String page = "";
            if (result != null) {
                page = "/board/edit.jsp";
                request.setAttribute("dto", dao.view(num));
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
            } else {
                page = contextPath + "/board_servlet/view.do?num=" + num + "&message=error";
                response.sendRedirect(page);
            }
        } else if (url.indexOf("update.do") != -1) {
            BoardDTO dto = new BoardDTO();
            String filename = "-";
            int filesize = 0;
            try {
                for (Part part : request.getParts()) {
                    filename = part.getSubmittedFileName();
                    if (filename != null) {
                        filesize = (int) part.getSize();
                        part.write(filename);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String writer = request.getParameter("writer");
            String subject = request.getParameter("subject");
            String contents = request.getParameter("contents");
            String passwd = request.getParameter("passwd");
            String ip = request.getRemoteAddr();
            int num = Integer.parseInt(request.getParameter("num"));
            String delete_file = request.getParameter("delete_file");
            if (delete_file != null && delete_file.equals("on")) {
                String fileName = dao.getFilename(num);
                File f = new File("c:/upload/" + fileName);
                f.delete();
                dto.setNum(num);
                dto.setWriter(writer);
                dto.setSubject(subject);
                dto.setContents(contents);
                dto.setPasswd(passwd);
                dto.setIp(ip);
                dto.setFilename("-");
                dto.setFilesize(0);
                dto.setDown(0);
                dao.update(dto);
                }
            dto.setNum(num);
            dto.setWriter(writer);
            dto.setSubject(subject);
            dto.setContents(contents);
            dto.setPasswd(passwd);
            dto.setIp(ip);
            if (filename == null || filename.trim().equals("")) {
            	BoardDTO dto2 = dao.view(num);
            	String name = dto2.getFilename();
            	int size = dto2.getFilesize();
            	int down = dto2.getDown();
            	dto.setFilename(name);
            	dto.setFilesize(size);
            	dto.setDown(down);
        	} else {
        	    dto.setFilename(filename);
        	    dto.setFilesize(filesize);
        	}
        	String result = dao.check_pwd(num, passwd);
        	if (result != null) {
        	    dao.update(dto);
        	    String page = contextPath + "/board_servlet/list.do";
        	    response.sendRedirect(page);
        	} else {
        	    request.setAttribute("dto", dto);
        	    String page = "/board/edit.jsp?pwd_error=y";
        	    RequestDispatcher rd = request.getRequestDispatcher(page);
        	    rd.forward(request, response);
        	}

    	} else if (url.indexOf("delete.do") != -1) {
    	    int num = Integer.parseInt(request.getParameter("num"));
    	    String passwd = request.getParameter("passwd");
    	    String result = dao.check_pwd(num, passwd);
    	    if (result != null) {
    	        dao.delete(num);
    	        String page = contextPath + "/board_servlet/list.do";
    	        response.sendRedirect(page);
    	    } else {
    	        request.setAttribute("dto", dao.view(num));
    	        String page = "/board/edit.jsp?pwd_error=y";
    	        RequestDispatcher rd = request.getRequestDispatcher(page);
    	        rd.forward(request, response);
    	    }
	    } else if (url.indexOf("input_reply.do") != -1) {
	        int num = Integer.parseInt(request.getParameter("num"));
	        BoardDTO dto = dao.view(num);
	        dto.setContents("===contents===\n" + dto.getContents());
	        request.setAttribute("dto", dto);
	        String page = "/board/reply.jsp";
	        RequestDispatcher rd = request.getRequestDispatcher(page);
	        rd.forward(request, response);
	    } else if (url.indexOf("insert_reply.do") != -1) {
	        int num = 0;
	        if (request.getParameter("num") != null) {
	            num = Integer.parseInt(request.getParameter("num"));
	        }
	        BoardDTO dto = dao.view(num);
	        int group_num = dto.getGroup_num();
	        int re_order = dto.getRe_order() + 1;
	        int re_depth = dto.getRe_depth() + 1;
	        String writer = request.getParameter("writer");
	        String subject = request.getParameter("subject");
	        String contents = request.getParameter("contents");
	        String passwd = request.getParameter("passwd");
	        dto.setWriter(writer);
	        dto.setSubject(subject);
	        dto.setContents(contents);
	        dto.setPasswd(passwd);
	        dto.setGroup_num(group_num);
	        dto.setRe_order(re_order);
	        dto.setRe_depth(re_depth);
	        dto.setFilename("-");
	        dto.setFilesize(0);
	        dto.setDown(0);
	        dao.update_order(group_num, re_order);
	        dao.insert_reply(dto);
	        String page = "/board_servlet/list.do";
	        response.sendRedirect(request.getContextPath() + page);
	    } else if (url.indexOf("search.do") != -1) {
	        String search_option = request.getParameter("search_option");
	        String keyword = request.getParameter("keyword");
	        int count = dao.count(search_option, keyword);
	        int cur_page = 1;
	        if (request.getParameter("cur_page") != null) {
	            cur_page = Integer.parseInt(request.getParameter("cur_page"));
	        }
	        PageUtil page = new PageUtil(count, cur_page);
	        int start = page.getPageBegin();
	        int end = page.getPageEnd();
	        List<BoardDTO> list = dao.list_search(search_option, keyword, start, end);
	        request.setAttribute("list", list);
	        request.setAttribute("search_option", search_option);
	        request.setAttribute("keyword", keyword);
	        request.setAttribute("page", page);
	        RequestDispatcher rd = request.getRequestDispatcher("/board/search.jsp");
	        rd.forward(request, response);
	    }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
}



