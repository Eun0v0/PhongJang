package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import domain.PhoneCase;
import domain.Payment;
import domain.User;
import java.util.Iterator;
import java.sql.*;

public final class searchPwd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <title>비밀번호 찾기</title>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            //<![CDATA[\r\n");
      out.write("            function initMoving(target, position, topLimit, btmLimit) {\r\n");
      out.write("                if (!target)\r\n");
      out.write("                    return false;\r\n");
      out.write("\r\n");
      out.write("                var obj = target;\r\n");
      out.write("                obj.initTop = position;\r\n");
      out.write("                obj.topLimit = topLimit;\r\n");
      out.write("                obj.bottomLimit = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight) - btmLimit - obj.offsetHeight;\r\n");
      out.write("\r\n");
      out.write("                obj.style.position = \"absolute\";\r\n");
      out.write("                obj.top = obj.initTop;\r\n");
      out.write("                obj.left = obj.initLeft;\r\n");
      out.write("\r\n");
      out.write("                if (typeof (window.pageYOffset) == \"number\") {\t//WebKit\r\n");
      out.write("                    obj.getTop = function () {\r\n");
      out.write("                        return window.pageYOffset;\r\n");
      out.write("                    }\r\n");
      out.write("                } else if (typeof (document.documentElement.scrollTop) == \"number\") {\r\n");
      out.write("                    obj.getTop = function () {\r\n");
      out.write("                        return Math.max(document.documentElement.scrollTop, document.body.scrollTop);\r\n");
      out.write("                    }\r\n");
      out.write("                } else {\r\n");
      out.write("                    obj.getTop = function () {\r\n");
      out.write("                        return 0;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                if (self.innerHeight) {\t//WebKit\r\n");
      out.write("                    obj.getHeight = function () {\r\n");
      out.write("                        return self.innerHeight;\r\n");
      out.write("                    }\r\n");
      out.write("                } else if (document.documentElement.clientHeight) {\r\n");
      out.write("                    obj.getHeight = function () {\r\n");
      out.write("                        return document.documentElement.clientHeight;\r\n");
      out.write("                    }\r\n");
      out.write("                } else {\r\n");
      out.write("                    obj.getHeight = function () {\r\n");
      out.write("                        return 500;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                obj.move = setInterval(function () {\r\n");
      out.write("                    if (obj.initTop > 0) {\r\n");
      out.write("                        pos = obj.getTop() + obj.initTop;\r\n");
      out.write("                    } else {\r\n");
      out.write("                        pos = obj.getTop() + obj.getHeight() + obj.initTop;\r\n");
      out.write("                        //pos = obj.getTop() + obj.getHeight() / 2 - 15;\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    if (pos > obj.bottomLimit)\r\n");
      out.write("                        pos = obj.bottomLimit;\r\n");
      out.write("                    if (pos < obj.topLimit)\r\n");
      out.write("                        pos = obj.topLimit;\r\n");
      out.write("\r\n");
      out.write("                    interval = obj.top - pos;\r\n");
      out.write("                    obj.top = obj.top - interval / 3;\r\n");
      out.write("                    obj.style.top = obj.top + 220 + \"px\";\r\n");
      out.write("                }, 30)\r\n");
      out.write("            }\r\n");
      out.write("            //]]>\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("            #gotop {position: absolute; right: 0px; top: 50px; width: 100px; height: 100px;}\r\n");
      out.write("            a{color:black; text-decoration:none;}\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <table border=\"0px\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                ");
  User user = (User) request.getAttribute("user");
                    if (user == null) { 
      out.write("\r\n");
      out.write("                <td><img src=\"image\\login.jpg\" onClick=\"location.assign('login.jsp')\"></td>\r\n");
      out.write("                <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                        <img src=\"image\\cart.jpg\"></a>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                        <img src=\"image\\order.jpg\"></a>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                        <input type=\"image\" src=\"image\\myPageUp_1.jpg\" name=\"Submit\" value =\"MY PAGE\"></a>\r\n");
      out.write("                </td>\r\n");
      out.write("                ");
 } else {
                    session.setAttribute("user", user);
      out.write("\r\n");
      out.write("                <td><form action=\"logout\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\logout.jpg\" name=\"Submit\" value =\"로그아웃\">\r\n");
      out.write("                    </form> \r\n");
      out.write("                </td>\r\n");
      out.write("                <td><form action=\"cart\" method=\"post\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\cart.jpg\" name=\"Submit\" value =\"장바구니\">\r\n");
      out.write("                    </form> \r\n");
      out.write("                </td>\r\n");
      out.write("\r\n");
      out.write("                <td><form action=\"paymentlist\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\order.jpg\" name=\"Submit\" value =\"주문 목록\">\r\n");
      out.write("                    </form>    \r\n");
      out.write("                </td>\r\n");
      out.write("                <td><form action=\"myPage\" method=\"post\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                        <input type=\"image\" src=\"image\\myPageUp_1.jpg\" name=\"Submit\" value =\"MY PAGE\">\r\n");
      out.write("                    </form>    \r\n");
      out.write("                </td>\r\n");
      out.write("                ");
  }
      out.write("\r\n");
      out.write("                <td><form action=\"IDCheck\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\join.jpg\" name=\"Submit\" value =\"회원가입\">\r\n");
      out.write("                    </form>    \r\n");
      out.write("                </td>\r\n");
      out.write("\r\n");
      out.write("                <td><a href=\"board\\board-list.jsp\"><img src=\"image\\q&a.jpg\"></a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        ");
 if (user != null) {
      out.write("\r\n");
      out.write("    <center> <div align=\"middle\">\r\n");
      out.write("            <form action=\"main\" method=\"post\">\r\n");
      out.write("                <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                <input type=\"image\" src=\"image\\banner.jpg\" name=\"Submit\">\r\n");
      out.write("            </form>\r\n");
      out.write("        </div> </center>\r\n");
      out.write("        ");
 } else {
      out.write("\r\n");
      out.write("    <center> <div align=\"middle\"> <img src=\"image\\banner2.jpg\" onClick=\"location.assign('main.jsp')\"> </div> </center>\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form action =\"search\" method=\"post\">\r\n");
      out.write("        <img src=\"image\\search.png\" height=\"17\" width=\"17\">\r\n");
      out.write("        <input type=\"text\" size=\"16\" name=\"caseName\">\r\n");
      out.write("        <input type=\"submit\" value=\"검색\">\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("    <hr size=\"5\" color=\"black\">\r\n");
      out.write("    <center>   \r\n");
      out.write("        <br><br>\r\n");
      out.write("        <img src=\"image\\searchPwd.jpg\" height=\"60\" width=\"150\"><br>\r\n");
      out.write("        <br>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <form action =\"searchPwd\" method=\"post\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr><td><img src=\"image\\id.JPG\" width=120 height=35\">&nbsp;</td><td>\r\n");
      out.write("                        <input type=\"text\" name=\"userID\" size=\"20\">\r\n");
      out.write("                <tr><td><img src=\"image\\phone.jpg\" width=120 height=35\">&nbsp;</td><td>\r\n");
      out.write("                        <input type=\"text\" name=\"PhoneNum\" size=\"20\">\r\n");
      out.write("            </table>\r\n");
      out.write("            <table><tr>\r\n");
      out.write("                    <td><input type=\"image\" src=\"image\\searchPwdBt.jpg\" width=\"170\" height=\"50\" name=\"Submit\" value =\"searchPwd\">&nbsp;</td>\r\n");
      out.write("                    &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                    <td><input type=\"image\" src=\"image\\back.jpg\" width=\"170\" height=\"50\" onClick=\"location.assign('login.jsp')\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </center>\r\n");
      out.write("    <div id=\"gotop\">\r\n");
      out.write("        <a href=\"#top\"><img src=\"image\\up.jpg\" height=\"35\" width=\"50\"></a><br>\r\n");
      out.write("        <img src=\"image\\cursor1.jpg\" height=\"50\" width=\"50\"> <br>\r\n");
      out.write("        <a href=\"#bottom\"> <img src=\"image\\down.jpg\" height=\"35\" width=\"50\"> </a> \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">initMoving(document.getElementById(\"gotop\"), 50, 50, 50);</script> \r\n");
      out.write("\r\n");
      out.write("    <a href=\"#top\" name=\"bottom\"><img src=\"image\\totop.jpg\" align=\"right\"></a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
