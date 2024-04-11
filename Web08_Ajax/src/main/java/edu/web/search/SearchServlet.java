package edu.web.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SearchDAO dao;

    public SearchServlet() {
    	dao = SearchDAOImple.getInsttance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String obj = request.getParameter("obj");
		System.out.println(obj);
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(obj);
			
			String title = (String)jsonObject.get("title");
			System.out.println(title);
			
			if(title.equals("")) {
				dao.selectALL();
				System.out.println(dao.selectALL());
			} else {
				dao.select(title);
				System.out.println(dao.select(title));
			}
		} catch (ParseException e) {
			System.out.println("실패");
			e.printStackTrace();
		}

	}

}
