package edu.web.member;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginSessionFilter extends HttpFilter implements Filter {
    public LoginSessionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		// 서브릿 기능을 사용할 수 있도록 하는코드 왜이런식으로 되는지는 이해 못함 그냥 사용함
		HttpSession session = req.getSession();
		
		String userid = (String) session.getAttribute("userid");
		if(userid == null) {
			
			// 이동코드
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("login.jsp");
			return; // 필터 종료
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
