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

public final class jelly1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>우 젤리젤리♪ 케이스</title>\r\n");
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
      out.write("     \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <table border=\"0px\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            ");
  User user = (User) request.getAttribute("user");
            if (user == null) { 
      out.write("\r\n");
      out.write("            <td><img src=\"image\\login.jpg\" onClick=\"location.assign('login.jsp')\"></td>\r\n");
      out.write("            <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                   <img src=\"image\\cart.jpg\"></a>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                    <img src=\"image\\order.jpg\"></a>\r\n");
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
      out.write("            <td><form action=\"paymentlist\" method=\"post\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\order.jpg\" name=\"Submit\" value =\"주문 목록\">\r\n");
      out.write("                </form>    \r\n");
      out.write("            </td>\r\n");
      out.write("                ");
  }
      out.write("\r\n");
      out.write("            \r\n");
      out.write("                <td><form action=\"myPage\" method=\"post\">\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("                    &nbsp;\r\n");
      out.write("                    <input type=\"image\" src=\"image\\myPageUp_1.jpg\" name=\"Submit\" value =\"MY PAGE\">\r\n");
      out.write("                </form>    \r\n");
      out.write("                </td>\r\n");
      out.write("            <td><a href=\"join.jsp\"><img src=\"image\\join.jpg\"></a></td>\r\n");
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
      out.write("            <form action =\"search.action\" name=\"search\" method=\"search\">\r\n");
      out.write("                <img src=\"image\\search.png\" height=\"17\" width=\"17\">\r\n");
      out.write("                <input type=\"text\" size=\"16\" name=\"keyword\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${keyword}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                <input type=\"button\" value=\"검색\" onClick=\"check()\">\r\n");
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
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <br><br>\r\n");
      out.write("<form name=\"myForm\" method=\"post\">\r\n");
      out.write("<table width=\"1100\" height=\"300\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td><img src=\"image\\BOTTOM1-5.jpg\" width=\"600\" height=\"360\"></td>\r\n");
      out.write("<td width=\"900\">\r\n");
      out.write("<hr size=\"1\"><img src=\"image\\ic_best.png\"><br>\r\n");
      out.write("<label for=\"g_name\">우 젤리젤리♪ 케이스</label>\r\n");
      out.write("<hr size=\"1\"><br>\r\n");
      out.write("<div align=\"left\"><font size=\"2\">구매가</font></div>\r\n");
      out.write("<label for=\"g_price\"><div align=\"right\"><font size=\"4\"><b>13,500원</b></font></div></label>\r\n");
      out.write("<div align=\"left\"><font size=\"2\">핸드폰 기종</font></div>\r\n");
      out.write("<div align=\"right\">\r\n");
      out.write("<input type=\"text\" name=\"phone\" size=\"8\" list=\"phone\">\r\n");
      out.write("<datalist id=\"phone\">\r\n");
      out.write("<option value=\"아이폰 6/6s\"></option>\r\n");
      out.write("<option value=\"아이폰 6+/6s+\"></option>\r\n");
      out.write("<option value=\"아이폰 7\"></option>\r\n");
      out.write("<option value=\"아이폰 7+\"></option>\r\n");
      out.write("<option value=\"아이폰 8\"></option>\r\n");
      out.write("<option value=\"아이폰 8+\"></option>\r\n");
      out.write("</datalist>\r\n");
      out.write("<div align=\"left\"><font size=\"2\">색상</font></div>\r\n");
      out.write("<div align=\"right\">\r\n");
      out.write("<input type=\"text\" name=\"color\" size=\"8\" list=\"color\">\r\n");
      out.write("<datalist id=\"color\">\r\n");
      out.write("<option value=\"화이트\"></option>\r\n");
      out.write("<option value=\"블랙\"></option>\r\n");
      out.write("<option value=\"레드\"></option>\r\n");
      out.write("<option value=\"핑크\"></option>\r\n");
      out.write("<option value=\"옐로우\"></option>\r\n");
      out.write("<option value=\"브라운\"></option>\r\n");
      out.write("</datalist>\r\n");
      out.write("</div>\r\n");
      out.write("<hr size=\"1\">\r\n");
      out.write("<br><center>\r\n");
      out.write("<input type=\"image\" src=\"image\\bt_cartin.jpg\" onClick='mySubmit(1)'>\r\n");
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("<input type=\"image\" src=\"image\\bt_buying.jpg\" onClick='mySubmit(2)'>\r\n");
      out.write("</center>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<hr size=\"1\" width=\"1100\">\r\n");
      out.write("</center>\r\n");
      out.write("<br><br>\r\n");
      out.write("<center><font size=\"4\" face=\"10x10\">\r\n");
      out.write("<font color=\"orange\">*우 젤리젤리♪우 젤리젤리♪우 젤리젤리♪오 마이 럽~~!</font>\r\n");
      out.write("<br><br><b><u>-comment-</u></b><br><br>\r\n");
      out.write("내 맘을 내 맘을 들킬까봐<br>\r\n");
      out.write("또 조심조심 해 oh 보일랑 말랑<br>\r\n");
      out.write("like 젤리처럼 투명한 my heart<br>\r\n");
      out.write("어떻게 숨기질 못해<br>\r\n");
      out.write("<br><br>\r\n");
      out.write("<font size=\"5\"><b>가능한 기종<br><br></b></font>\r\n");
      out.write("<font size=\"4\" color=\"gray\"><b>아이폰 6/6s (plus), 아이폰 7 (plus), 아이폰 8 (plus)</b></font><br><br>\r\n");
      out.write("\r\n");
      out.write("<img src=\"image\\BOTTOM1-1.jpg\">\r\n");
      out.write("\r\n");
      out.write("</center></font>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<hr size=\"2\" color=\"black\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"gotop\">\r\n");
      out.write("    <a href=\"#top\"><img src=\"image\\up.jpg\" height=\"35\" width=\"50\"></a><br>\r\n");
      out.write("    <img src=\"image\\cursor1.jpg\" height=\"50\" width=\"50\"> <br>\r\n");
      out.write("    <a href=\"#bottom\"> <img src=\"image\\down.jpg\" height=\"35\" width=\"50\"> </a> \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">initMoving(document.getElementById(\"gotop\"), 50, 50, 50);</script> \r\n");
      out.write("\r\n");
      out.write("<a href=\"#top\" name=\"bottom\"><img src=\"image\\totop.jpg\" align=\"right\"></a>\r\n");
      out.write("\r\n");
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
