package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import domain.User;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=euc-kr");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      util.Status status = null;
      synchronized (request) {
        status = (util.Status) _jspx_page_context.getAttribute("status", PageContext.REQUEST_SCOPE);
        if (status == null){
          status = new util.Status();
          _jspx_page_context.setAttribute("status", status, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>상품 추가</title>\r\n");
      out.write("        ");
  User user = (User) request.getAttribute("user");
            session.setAttribute("user", user);
      out.write("</head>\r\n");
      out.write("    <body>\r\n");
      out.write("                <table border=\"0px\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            ");
 if (user == null) { 
      out.write("\r\n");
      out.write("            <td><img src=\"image\\login.jpg\" onClick=\"location.assign('login.jsp')\"></td>\r\n");
      out.write("            <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                <input type=\"submit\" value=\"상품 관리\">\r\n");
      out.write("                </a></td>\r\n");
      out.write("            <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                    <img src=\"image\\order.jpg\"></a>\r\n");
      out.write("            </td>\r\n");
      out.write("            \r\n");
      out.write("                ");
 } else { session.setAttribute("user", user); 
      out.write("\r\n");
      out.write("            <td><form action=\"logout\" method=\"post\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\logout.jpg\" name=\"Submit\" value =\"로그아웃\">\r\n");
      out.write("                </form> \r\n");
      out.write("            </td>\r\n");
      out.write("            <td><form action=\"managePhoneCase\" method=\"post\">\r\n");
      out.write("                    <input type=\"submit\" value=\"상품 관리\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </td>\r\n");
      out.write("            \r\n");
      out.write("            <td><form action=\"paymentlist\" method=\"post\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\order.jpg\" name=\"Submit\" value=\"모든 결제내역\">\r\n");
      out.write("                </form> \r\n");
      out.write("            </td>\r\n");
      out.write("            \r\n");
      out.write("                ");
  }
      out.write("\r\n");
      out.write("           \r\n");
      out.write("            <td><a href=\"board\\board-list.jsp\"><img src=\"image\\q&a.jpg\"></a></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("            ");
 if (user != null) { 
      out.write("\r\n");
      out.write("            <center> <div align=\"middle\">\r\n");
      out.write("                <form action=\"main\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\banner.jpg\" name=\"Submit\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div> </center>\r\n");
      out.write("            ");
 } else {
      out.write("\r\n");
      out.write("            <center> <div align=\"middle\"> <img src=\"image\\banner2.jpg\" onClick=\"location.assign('admin/main.jsp')\"> </div> </center>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <form action =\"search\" method=\"post\">\r\n");
      out.write("                <img src=\"image\\search.png\" height=\"17\" width=\"17\">\r\n");
      out.write("                <input type=\"text\" size=\"16\" name=\"caseName\">\r\n");
      out.write("                <input type=\"submit\" value=\"검색\">\r\n");
      out.write("            </form>\r\n");
      out.write("                \r\n");
      out.write("    <hr size=\"5\" color=\"black\">\r\n");
      out.write("    <center>\r\n");
      out.write("        <a href=\"Top-main.jsp\"><img src=\"image\\customCase3.jpg\" height=\"35\" width=\"140\"></a>\r\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"35\" width=\"80\">\r\n");
      out.write("        <a href=\"Bottom-main.jsp\"><img src=\"image\\bumperCase2.jpg\" height=\"35\" width=\"140\"></a>\r\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"35\" width=\"80\">\r\n");
      out.write("        <a href=\"Outer-main.jsp\"><img src=\"image\\hardCase.jpg\" height=\"35\" width=\"140\"></a>\r\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"35\" width=\"80\">\r\n");
      out.write("        <a href=\"Sho-main.jsp\"><img src=\"image\\jellyCase.jpg\" height=\"35\" width=\"140\"></a>\r\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"35\" width=\"80\">\r\n");
      out.write("        <a href=\"event.jsp\"><img src=\"image\\event_.jpg\" height=\"35\" width=\"140\"></a>\r\n");
      out.write("    </center>\r\n");
      out.write("    <hr size=\"5\" color=\"black\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <center> <h2>상품 추가 페이지 입니다.</h2> </center>\r\n");
      out.write("        ");
if ((status != null) && !status.isSuccessful()) {
      out.write("\r\n");
      out.write("        <font color=\"red\">There were problems processing your request:\r\n");
      out.write("        <ul>");
Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();
      out.write("\r\n");
      out.write("            <li>");
      out.print( ex.getMessage());
}
      out.write("</ul></font>");
}
      out.write("\r\n");
      out.write("        <form action=\"createprocess\" method=\"post\">\r\n");
      out.write("            <center>\r\n");
      out.write("            <table width=\"1100\" height=\"300\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"900\">\r\n");
      out.write("                        <hr size=\"1\"><br>\r\n");
      out.write("                        <div align=\"left\"><font size=\"2\">케이스 이름</font></div>\r\n");
      out.write("                        <div align=\"right\"><input type=\"text\" name=\"caseName\" size=\"40\" padding=\"10px\"></div>\r\n");
      out.write("                        <div align=\"left\"><font size=\"2\">케이스 타입</font></div>\r\n");
      out.write("                        <div align=\"right\"><select name=\"caseType\" >\r\n");
      out.write("                                <option name=\"caseType\" value=\"unknown\">-----\r\n");
      out.write("                                <option name=\"caseType\" value=\"젤리\">젤리\r\n");
      out.write("                                <option name=\"caseType\" value=\"하드\">하드\r\n");
      out.write("                                <option name=\"caseType\" value=\"범퍼\">범퍼</select></div>\r\n");
      out.write("                        <div align=\"left\"><font size=\"2\">가격</font></div>\r\n");
      out.write("                        <div align=\"right\"><input type=\"text\" name=\"price\" size=\"10\" padding=\"10px\">원</div>\r\n");
      out.write("                        <div align=\"left\"><font size=\"2\">설명</font></div>\r\n");
      out.write("                        <div align=\"right\"><textarea name=\"explanation\" cols=\"65\" rows=\"4\"></textarea></div>\r\n");
      out.write("\r\n");
      out.write("                        <hr size=\"1\">\r\n");
      out.write("\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("                <table>\r\n");
      out.write("                    <td>\r\n");
      out.write("                    <tr><input type=\"submit\" value=\"Submit\"><input type=\"reset\" value=\"다시쓰기\"> </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            <hr size=\"1\" width=\"1100\">\r\n");
      out.write("            </center>\r\n");
      out.write("        </form>         \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
