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

public final class detailPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("<script type =\"text/javascript\" src=\"smarteditor/js/HuskyEZCreator.js\" charset=\"euc-kr\"> </script>\n");
      out.write("<script>\n");
      out.write("    function submitContents(elClickedObj){\n");
      out.write("        oEditors.getById[\"ir1\"].exec(\"UPDATE_CONTENTS_FIELD\", []);\n");
      out.write("        try{\n");
      out.write("            elClickedObj.form.submit();\n");
      out.write("        } catch (e){\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      util.Status status = null;
      synchronized (request) {
        status = (util.Status) _jspx_page_context.getAttribute("status", PageContext.REQUEST_SCOPE);
        if (status == null){
          status = new util.Status();
          _jspx_page_context.setAttribute("status", status, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
 request.setCharacterEncoding("UTF-8"); 
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>우 젤리젤리♪ 케이스</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            //<![CDATA[\n");
      out.write("            function initMoving(target, position, topLimit, btmLimit) {\n");
      out.write("                if (!target)\n");
      out.write("                    return false;\n");
      out.write("\n");
      out.write("                var obj = target;\n");
      out.write("                obj.initTop = position;\n");
      out.write("                obj.topLimit = topLimit;\n");
      out.write("                obj.bottomLimit = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight) - btmLimit - obj.offsetHeight;\n");
      out.write("\n");
      out.write("                obj.style.position = \"absolute\";\n");
      out.write("                obj.top = obj.initTop;\n");
      out.write("                obj.left = obj.initLeft;\n");
      out.write("\n");
      out.write("                if (typeof (window.pageYOffset) == \"number\") {\t//WebKit\n");
      out.write("                    obj.getTop = function () {\n");
      out.write("                        return window.pageYOffset;\n");
      out.write("                    }\n");
      out.write("                } else if (typeof (document.documentElement.scrollTop) == \"number\") {\n");
      out.write("                    obj.getTop = function () {\n");
      out.write("                        return Math.max(document.documentElement.scrollTop, document.body.scrollTop);\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    obj.getTop = function () {\n");
      out.write("                        return 0;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (self.innerHeight) {\t//WebKit\n");
      out.write("                    obj.getHeight = function () {\n");
      out.write("                        return self.innerHeight;\n");
      out.write("                    }\n");
      out.write("                } else if (document.documentElement.clientHeight) {\n");
      out.write("                    obj.getHeight = function () {\n");
      out.write("                        return document.documentElement.clientHeight;\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    obj.getHeight = function () {\n");
      out.write("                        return 500;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                obj.move = setInterval(function () {\n");
      out.write("                    if (obj.initTop > 0) {\n");
      out.write("                        pos = obj.getTop() + obj.initTop;\n");
      out.write("                    } else {\n");
      out.write("                        pos = obj.getTop() + obj.getHeight() + obj.initTop;\n");
      out.write("                        //pos = obj.getTop() + obj.getHeight() / 2 - 15;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    if (pos > obj.bottomLimit)\n");
      out.write("                        pos = obj.bottomLimit;\n");
      out.write("                    if (pos < obj.topLimit)\n");
      out.write("                        pos = obj.topLimit;\n");
      out.write("\n");
      out.write("                    interval = obj.top - pos;\n");
      out.write("                    obj.top = obj.top - interval / 3;\n");
      out.write("                    obj.style.top = obj.top + 220 + \"px\";\n");
      out.write("                }, 30)\n");
      out.write("            }\n");
      out.write("            //]]>\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #gotop {position: absolute; right: 0px; top: 50px; width: 100px; height: 100px;}\n");
      out.write("            a{color:black; text-decoration:none;}\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table border=\"0px\">\n");
      out.write("            <tr>\n");
      out.write("                ");
  User user = (User) request.getAttribute("user");
                    if (user == null) { 
      out.write("\n");
      out.write("                <td><img src=\"image\\login.jpg\" onClick=\"location.assign('login.jsp')\"></td>\n");
      out.write("                <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\n");
      out.write("                        <img src=\"image\\cart.jpg\"></a>\n");
      out.write("                </td>\n");
      out.write("                <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\n");
      out.write("                        <img src=\"image\\order.jpg\"></a>\n");
      out.write("                </td>\n");
      out.write("                ");
 } else {
                    session.setAttribute("user", user);
      out.write("\n");
      out.write("                <td><form action=\"logout\" method=\"post\">\n");
      out.write("                        <input type=\"image\" src=\"image\\logout.jpg\" name=\"Submit\" value =\"로그아웃\">\n");
      out.write("                    </form> \n");
      out.write("                </td>\n");
      out.write("                <td><form action=\"cart\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\n");
      out.write("                        <input type=\"image\" src=\"image\\cart.jpg\" name=\"Submit\" value =\"장바구니\">\n");
      out.write("                    </form> \n");
      out.write("                </td>\n");
      out.write("                <td><form action=\"paymentlist\" method=\"post\">\n");
      out.write("                        <input type=\"image\" src=\"image\\order.jpg\" name=\"Submit\" value =\"주문 목록\">\n");
      out.write("                    </form>    \n");
      out.write("                </td>\n");
      out.write("                ");
  }
      out.write("\n");
      out.write("\n");
      out.write("                <td><form action=\"myPage\" method=\"post\">\n");
      out.write("                        ");
      out.write("\n");
      out.write("                        &nbsp;\n");
      out.write("                        <input type=\"image\" src=\"image\\myPageUp_1.jpg\" name=\"Submit\" value =\"MY PAGE\">\n");
      out.write("                    </form>    \n");
      out.write("                </td>\n");
      out.write("                <td><a href=\"join.jsp\"><img src=\"image\\join.jpg\"></a></td>\n");
      out.write("                <td><a href=\"board\\board-list.jsp\"><img src=\"image\\q&a.jpg\"></a></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        ");
 if (user != null) {
      out.write("\n");
      out.write("    <center> <div align=\"middle\">\n");
      out.write("            <form action=\"main\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\n");
      out.write("                <input type=\"image\" src=\"image\\banner.jpg\" name=\"Submit\">\n");
      out.write("            </form>\n");
      out.write("        </div> </center>\n");
      out.write("        ");
 } else {
      out.write("\n");
      out.write("    <center> <div align=\"middle\"> <img src=\"image\\banner2.jpg\" onClick=\"location.assign('main.jsp')\"> </div> </center>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("\n");
      out.write("    <form action =\"search.action\" name=\"search\" method=\"search\">\n");
      out.write("        <img src=\"image\\search.png\" height=\"17\" width=\"17\">\n");
      out.write("        <input type=\"text\" size=\"16\" name=\"keyword\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${keyword}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("        <input type=\"button\" value=\"검색\" onClick=\"check()\">\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <hr size=\"5\" color=\"black\">\n");
      out.write("    <center>\n");
      out.write("        <a href=\"Top-main.jsp\"><img src=\"image\\customCase3.jpg\" height=\"35\" width=\"140\"></a>\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"35\" width=\"80\">\n");
      out.write("        <a href=\"Bottom-main.jsp\"><img src=\"image\\bumperCase2.jpg\" height=\"35\" width=\"140\"></a>\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"35\" width=\"80\">\n");
      out.write("        <a href=\"Outer-main.jsp\"><img src=\"image\\hardCase.jpg\" height=\"35\" width=\"140\"></a>\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"35\" width=\"80\">\n");
      out.write("        <a href=\"Sho-main.jsp\"><img src=\"image\\jellyCase.jpg\" height=\"35\" width=\"140\"></a>\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"35\" width=\"80\">\n");
      out.write("        <a href=\"event.jsp\"><img src=\"image\\event_.jpg\" height=\"35\" width=\"140\"></a>\n");
      out.write("    </center>\n");
      out.write("    <hr size=\"5\" color=\"black\">\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("    <br><br>\n");
      out.write("    <center>\n");
      out.write("        <h1>케이스 상세 페이지 작성</h1>\n");
      out.write("        <form name=\"myForm\" method=\"post\">\n");
      out.write("            <table width=\"1100\" height=\"300\">\n");
      out.write("                <tr>\n");
      out.write("                    <td width=\"900\">\n");
      out.write("                        <hr size=\"1\"><br>\n");
      out.write("                        <div align=\"left\"><font size=\"2\">케이스 이름</font></div>\n");
      out.write("                        <div align=\"right\"><input type=\"text\" name=\"caseName\" size=\"40\" padding=\"10px\"></div>\n");
      out.write("                        <div align=\"left\"><font size=\"2\">케이스 타입</font></div>\n");
      out.write("                        <div align=\"right\"><select name=\"caseType\" >\n");
      out.write("                                <option name=\"caseType\" value=\"unknown\">-----\n");
      out.write("                                <option name=\"caseType\" value=\"젤리\">젤리\n");
      out.write("                                <option name=\"caseType\" value=\"하드\">하드\n");
      out.write("                                <option name=\"caseType\" value=\"범퍼\">범퍼</select></div>\n");
      out.write("                        <div align=\"left\"><font size=\"2\">가격</font></div>\n");
      out.write("                        <div align=\"right\"><input type=\"text\" name=\"casePrice\" size=\"10\" padding=\"10px\">원</div>\n");
      out.write("\n");
      out.write("                        <hr size=\"1\">\n");
      out.write("                <br><center>\n");
      out.write("                    <input type=\"image\" src=\"image\\bt_cartin.jpg\" onClick='mySubmit(1)'>\n");
      out.write("                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                    <input type=\"image\" src=\"image\\bt_buying.jpg\" onClick='mySubmit(2)'>\n");
      out.write("                </center>\n");
      out.write("                </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        <hr size=\"1\" width=\"1100\">\n");
      out.write("    </center>\n");
      out.write("    <br><br>\n");
      out.write("    <center>\n");
      out.write("        <textarea name=\"ir1\" id=\"ir1\"></textarea>\n");
      out.write("        <div class=\"row text-right\">\n");
      out.write("            <br>\n");
      out.write("            <input type=\"button\" value=\"등록\" onClick=\"submitContents(this)\">\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var oEditors = [];\n");
      out.write("            nhn.husky.EZCreator.createInIFrame({\n");
      out.write("                oAppRef : oEditors,\n");
      out.write("                elPlaceHolder : \"ir1\",\n");
      out.write("                sSkinURI : \"smarteditor/SEditorSkin.html\",\n");
      out.write("                fCreator : \"createSEditor\"\n");
      out.write("            });\n");
      out.write("            </script>\n");
      out.write("    </center>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("    <hr size=\"2\" color=\"black\">\n");
      out.write("\n");
      out.write("    <div id=\"gotop\">\n");
      out.write("        <a href=\"#top\"><img src=\"image\\up.jpg\" height=\"35\" width=\"50\"></a><br>\n");
      out.write("        <img src=\"image\\cursor1.jpg\" height=\"50\" width=\"50\"> <br>\n");
      out.write("        <a href=\"#bottom\"> <img src=\"image\\down.jpg\" height=\"35\" width=\"50\"> </a> \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">initMoving(document.getElementById(\"gotop\"), 50, 50, 50);</script> \n");
      out.write("\n");
      out.write("    <a href=\"#top\" name=\"bottom\"><img src=\"image\\totop.jpg\" align=\"right\"></a>\n");
      out.write("\n");
      out.write("</body>\n");
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
