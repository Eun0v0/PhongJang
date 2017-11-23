package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import domain.PhoneCaseService;
import java.net.URLEncoder;
import java.util.ArrayList;
import domain.PhoneCase;
import domain.Payment;
import domain.User;
import java.util.Iterator;
import java.sql.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
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
      out.write("        <title>퐁장-나만의 폰 공장</title>\r\n");
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
                        session.setAttribute("user", user); 
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
      out.write("\r\n");
      out.write("                ");
  }
      out.write("\r\n");
      out.write("                <td><form action=\"IDCheck\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\join.jpg\" name=\"Submit\" value =\"회원가입\">\r\n");
      out.write("                    </form>    \r\n");
      out.write("                </td>\r\n");
      out.write("\r\n");
      out.write("                <td><form action=\"qnaList\" methoe=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\q&a.jpg\" name=\"Submit\" value=\"Q&A\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                </td>\r\n");
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
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><a href=\"Top-main.jsp\"><img src=\"image\\customCase3.jpg\" height=\"35\" width=\"140\"></a></td>\r\n");
      out.write("                <td><img src=\"image\\space.jpg\" height=\"35\" width=\"80\"></td>\r\n");
      out.write("\r\n");
      out.write("                <td><form action =\"caseTypePage\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\bumperCase2.jpg\" name=\"Submit\" height=\"35\" width=\"140\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"caseType\" value=\"범퍼\">\r\n");
      out.write("                    </form></td>\r\n");
      out.write("                <td><img src=\"image\\space.jpg\" height=\"35\" width=\"80\"></td>\r\n");
      out.write("\r\n");
      out.write("                <td><form action =\"caseTypePage\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\hardCase.jpg\" name=\"Submit\" height=\"35\" width=\"140\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"caseType\" value=\"하드\">\r\n");
      out.write("                    </form></td>\r\n");
      out.write("                <td><img src=\"image\\space.jpg\" height=\"35\" width=\"80\"></td>\r\n");
      out.write("\r\n");
      out.write("                <td><form action =\"caseTypePage\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\jellyCase.jpg\" name=\"Submit\" height=\"35\" width=\"140\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"caseType\" value=\"젤리\">\r\n");
      out.write("                    </form></td>\r\n");
      out.write("                <td><img src=\"image\\space.jpg\" height=\"35\" width=\"80\"></td>\r\n");
      out.write("\r\n");
      out.write("                <td><a href=\"event.jsp\"><img src=\"image\\event_.jpg\" height=\"35\" width=\"140\"></a></td> \r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </center>\r\n");
      out.write("    <hr size=\"5\" color=\"black\">\r\n");
      out.write("\r\n");
      out.write("    <br><br>\r\n");
      out.write("    <font size=\"5\"><center><b>&nbsp;&nbsp;BEST ITEMS<sup><font size=\"1\" color=\"red\">HIT!</font></sup></b></font>\r\n");
      out.write("        <hr width=\"13%\" size=\"2\" color=\"gray\"></center><br>\r\n");
      out.write("\r\n");
      out.write("    <table align=\"center\" width =\"1000\" height=\"400\" cellpadding=\"15\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            ");

                PhoneCaseService phoneCaseService = new PhoneCaseService();
                ArrayList<PhoneCase> phoneCases = phoneCaseService.getAllPhoneCase();
                session.setAttribute("phoneCases", phoneCases);
                if (phoneCases.size() != 0) {
                    for (int i = 0; i < 4; i++) {
                        PhoneCase phoneCase = phoneCases.get(i);
                        int caseID = phoneCase.getCaseID();
                        String caseType = phoneCase.getCaseType();
                        String caseName = phoneCase.getCaseName();
                        String explanation = phoneCase.getExplanation();
                        int price = phoneCase.getPrice();
                        String imgPath = phoneCase.getImg();
            
      out.write("\r\n");
      out.write("            <td width=\"25%\">\r\n");
      out.write("                <a href=\"detailPage?caseID=");
      out.print(caseID);
      out.write("\"><img src = \"image/upload/");
      out.print(imgPath);
      out.write("\" height=\"240\" width=\"280\" alt=\"");
      out.print(caseName);
      out.write("\" title=\"");
      out.print(caseName);
      out.write("\"/><br><br>");
      out.print(caseName);
      out.write('(');
      out.print(caseType);
      out.write(")</a>\r\n");
      out.write("                <br><hr size=\"1\" color=\"black\">\r\n");
      out.write("                <img src = \"image\\ic_best.png\"><br>\r\n");
      out.write("                <font size=\"4\"><b>");
      out.print(price);
      out.write("원</b></font>\r\n");
      out.write("            </td>\r\n");
      out.write("            ");
 }
                }
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("    <br><br>\r\n");
      out.write("    <hr size=\"2\" color=\"gray\"><br><br>\r\n");
      out.write("    <font size=\"5\"><center><b>NEW GOODS</b></font>\r\n");
      out.write("        <hr width=\"13%\" size=\"2\" color=\"gray\"></center><br>\r\n");
      out.write("\r\n");
      out.write("    <table align=\"center\" width =\"1000\" height=\"400\" cellpadding=\"15\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            ");
  for (int j = phoneCases.size() - 1; j >= phoneCases.size() - 4; j--) {
                    PhoneCase phoneCase = phoneCases.get(j);
                    int caseID = phoneCase.getCaseID();
                    String caseType = phoneCase.getCaseType();
                    String caseName = phoneCase.getCaseName();
                    String explanation = phoneCase.getExplanation();
                    int price = phoneCase.getPrice();
                    String imgPath = phoneCase.getImg();
            
      out.write("\r\n");
      out.write("            <td width=\"25%\">\r\n");
      out.write("                <a href=\"detailPage?caseID=");
      out.print(caseID);
      out.write("\"><img src = \"image/upload/");
      out.print(imgPath);
      out.write("\" height=\"240\" width=\"280\" alt=\"");
      out.print(caseName);
      out.write("\" title=\"");
      out.print(caseName);
      out.write("\"/><br><br>");
      out.print(caseName);
      out.write('(');
      out.print(caseType);
      out.write(")</a>\r\n");
      out.write("                <br><hr size=\"1\" color=\"black\">\r\n");
      out.write("                <img src = \"image\\ic_best.png\"><br>\r\n");
      out.write("                <font size=\"4\"><b>");
      out.print(price);
      out.write("원</b></font>\r\n");
      out.write("            </td>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    <table align=\"center\" width =\"1000\" height=\"400\" cellpadding=\"15\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            ");
  if (phoneCases.size ()>=4) {
                    for (int j = phoneCases.size() - 5; j >= phoneCases.size() - 8; j--) {
                        PhoneCase phoneCase = phoneCases.get(j);
                        int caseID = phoneCase.getCaseID();
                        String caseType = phoneCase.getCaseType();
                        String caseName = phoneCase.getCaseName();
                        String explanation = phoneCase.getExplanation();
                        int price = phoneCase.getPrice();
                        String imgPath = phoneCase.getImg();
            
      out.write("\r\n");
      out.write("            <td width=\"25%\">\r\n");
      out.write("                <a href=\"detailPage?caseID=");
      out.print(caseID);
      out.write("\"><img src = \"image/upload/");
      out.print(imgPath);
      out.write("\" height=\"240\" width=\"280\" alt=\"");
      out.print(caseName);
      out.write("\" title=\"");
      out.print(caseName);
      out.write("\"/><br><br>");
      out.print(caseName);
      out.write('(');
      out.print(caseType);
      out.write(")</a>\r\n");
      out.write("                <br><hr size=\"1\" color=\"black\">\r\n");
      out.write("                <img src = \"image\\ic_best.png\"><br>\r\n");
      out.write("                <font size=\"4\"><b>");
      out.print(price);
      out.write("원</b></font>\r\n");
      out.write("            </td>\r\n");
      out.write("            ");
 }
                }
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>    \r\n");
      out.write("    <div id=\"gotop\">\r\n");
      out.write("        <a href=\"#top\"><img src=\"image\\up.jpg\" height=\"35\" width=\"50\"></a><br>\r\n");
      out.write("        <img src=\"image\\cursor1.jpg\" height=\"50\" width=\"50\"> <br>\r\n");
      out.write("        <a href=\"#bottom\"> <img src=\"image\\down.jpg\" height=\"35\" width=\"50\"> </a> \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">initMoving(document.getElementById(\"gotop\"), 50, 50, 50);</script> \r\n");
      out.write("\r\n");
      out.write("    <a href=\"#top\" name=\"bottom\"><img src=\"image\\totop.jpg\" align=\"right\"></a>\r\n");
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
