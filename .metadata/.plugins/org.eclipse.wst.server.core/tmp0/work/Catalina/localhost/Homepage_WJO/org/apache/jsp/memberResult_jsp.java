/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2024-04-05 10:24:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.web.member.MemberDAO;
import edu.web.member.MemberVO;

public final class memberResult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("edu.web.member.MemberVO");
    _jspx_imports_classes.add("edu.web.member.MemberDAO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

		// TODO : 회원 정보 출력
		// TODO : 회원 수정 버튼 생성(경로 : memberUpdate.jsp)
		// TODO : 회원 탈퇴 버튼 생성(경로 : delete.do)
		
		request.setCharacterEncoding("UTF-8");
	
		String userid = (String) session.getAttribute("userid");
		MemberVO vo = (MemberVO)request.getAttribute("vo");// 이거 문제가 심함
		/*if(userid != null){ // 조건안에 vo가 들어가 있으면 HTML에서 인식을 못하여 작성 자체가 안된다.
			// 근데 논리적으로는 동작이 되면서 vo가 생기기때문에 그렇게 생각한거 같다.
			
			out.println("<h2>"+ userid +"님, 정보 입니다.</h2>");
			
			vo = (MemberVO)request.getAttribute("vo");// 이거 문제가 심함
			System.out.println("뷰");
			System.out.println(vo);
			
		} else {
			out.print("<script>alert('로그인 해주세요!!')</script>");
			out.print("<script>location.href='login.jsp'</script><br>");
		}*/
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<p>아이디 : ");
      out.print(vo.getUserid() );
      out.write("</p>\r\n");
      out.write("	<p>비밀번호 : ");
      out.print(vo.getPassword() );
      out.write("</p>\r\n");
      out.write("	<p>이메일 : ");
      out.print(vo.getEmail() );
      out.write("</p>\r\n");
      out.write("	<p>이메일 수신여부 : ");
      out.print(vo.getEmailAgree() );
      out.write("</p>\r\n");
      out.write("	<p>관심사항 : </p>\r\n");
      out.write("	<p>");
      out.print(vo.getInterestJoin() );
      out.write("</p>\r\n");
      out.write("	<p>핸드폰 : ");
      out.print(vo.getPhone() );
      out.write("</p>\r\n");
      out.write("	<p>자기소개</p>\r\n");
      out.write("	");
      out.print(vo.getIntroduce() );
      out.write("<br>\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"memberUpdate.jsp\" method=\"post\">\r\n");
      out.write("	<input type=\"submit\" value=\"회원수정\">\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"delete.do\" method=\"post\">\r\n");
      out.write("	<input type=\"submit\" value=\"회원탈퇴\">\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"loginResult.jsp\" method=\"post\">\r\n");
      out.write("	<input type='submit' value='뒤로가기'><br>\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	<!-- 장식용 doget 방식 구현은 따로 안해놓음 -->\r\n");
      out.write("	<button onclick=\"location.href='memberUpdate.jsp'\">회원 정보 수정</button>\r\n");
      out.write("	<button onclick=\"location.href='delete.do'\">회원 정보 탈퇴</button>\r\n");
      out.write("	<!-- <button onclick=\"location.href='delete.do'\"> 방식대로 가면 Servlet의 get으로 간다. -->\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
