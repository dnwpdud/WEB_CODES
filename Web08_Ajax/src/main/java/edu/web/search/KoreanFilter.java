package edu.web.search;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/KoreanFilter")
public class KoreanFilter extends HttpFilter implements Filter {
       
    
    public KoreanFilter() {
      
    }


	public void destroy() {

	}


	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
