package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import domain.User;
import java.util.ArrayList;

public final class myPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>My Page</title>\r\n");
      out.write("        ");
User user = (User) request.getAttribute("user");
      out.write("\r\n");
      out.write("        ");
session.setAttribute("user", user);
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <table border=\"0px\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            ");

            if (user == null) { 
      out.write("\r\n");
      out.write("            <td><img src=\"image\\login.jpg\" onClick=\"location.assign('login.jsp')\"></td>\r\n");
      out.write("            <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                   <img src=\"image\\cart.jpg\"></a>\r\n");
      out.write("            </td>\r\n");
      out.write("            \r\n");
      out.write("            <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                    <img src=\"image\\order.jpg\"></a>\r\n");
      out.write("            </td>\r\n");
      out.write("            \r\n");
      out.write("            <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                    <input type=\"submit\" value =\"MY PAGE\"></a>\r\n");
      out.write("            </td>\r\n");
      out.write("                ");
 } else { session.setAttribute("user", user); 
      out.write("\r\n");
      out.write("            <td><form action=\"logout\" method=\"post\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\logout.jpg\" name=\"Submit\" value =\"로그아웃\">\r\n");
      out.write("                </form> \r\n");
      out.write("            </td>\r\n");
      out.write("            <td><form action=\"cart\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\cart.jpg\" name=\"Submit\" value =\"장바구니\">\r\n");
      out.write("                </form> \r\n");
      out.write("            </td>\r\n");
      out.write("            \r\n");
      out.write("            <td><form action=\"paymentlist\" method=\"post\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\order.jpg\" name=\"Submit\" value =\"주문 목록\">\r\n");
      out.write("                </form>    \r\n");
      out.write("            </td>\r\n");
      out.write("            <td><form action=\"myPage\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                    <input type=\"submit\" value =\"MY PAGE\">\r\n");
      out.write("                </form>    \r\n");
      out.write("            </td>\r\n");
      out.write("                ");
  }
      out.write("\r\n");
      out.write("            <td><form action=\"IDCheck\" method=\"post\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\join.jpg\" name=\"Submit\" value =\"회원가입\">\r\n");
      out.write("                </form>    \r\n");
      out.write("            </td>\r\n");
      out.write("            \r\n");
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
      out.write("            <center> <div align=\"middle\"> <img src=\"image\\banner2.jpg\" onClick=\"location.assign('main.jsp')\"> </div> </center>\r\n");
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
      out.write("        <img src=\"image\\myPage.JPG\" height=\"35\" width=\"140\">\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr><td><form action=\"paymentlist\" method=\"post\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\order.jpg\" name=\"Submit\" value =\"주문 목록\">\r\n");
      out.write("                </form>    \r\n");
      out.write("                </td>\r\n");
      out.write("                <td> <form action=\"cart\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\cart.jpg\" name=\"Submit\" value =\"장바구니\">\r\n");
      out.write("                </form> </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr><td> <form action=\"MyInfo\" method=\"post\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                        <input type=\"submit\" value =\"MY INFO\">\r\n");
      out.write("                    </form> </td>\r\n");
      out.write("                <td> <input type=\"submit\" value=\"MY BOARD\"></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>  \r\n");
      out.write("    </center>\r\n");
      out.write("        \r\n");
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
