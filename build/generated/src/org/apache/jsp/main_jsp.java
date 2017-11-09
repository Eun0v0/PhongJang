package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import domain.PhoneCase;
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
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=euc-kr");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

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
      out.write("        <title>Phong Jang</title>\n");
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
  String name = "";
            if (name == null || name.equals("")) { 
      out.write("\n");
      out.write("        <img src=\"image\\login.jpg\" onClick=\"location.assign('login.jsp')\">\n");
      out.write("        ");
 } else { 
      out.write("\n");
      out.write("        <img src=\"image\\logout.jpg\" onClick=\"location.assign('logout.jsp')\">\n");
      out.write("        ");
  }
      out.write("\n");
      out.write("        <a href=\"cart.jsp\"><img src=\"image\\cart.jpg\"></a>\n");
      out.write("        <a href=\"order_list.jsp\"><img src=\"image\\order.jpg\"></a>\n");
      out.write("        <a href=\"join.jsp\"><img src=\"image\\join.jpg\"></a>\n");
      out.write("        <a href=\"board\\board-list.jsp\"><img src=\"image\\q&a.jpg\"></a>\n");
      out.write("\n");
      out.write("    <center> <div align=\"middle\"> <img src=\"image\\banner.jpg\" onClick=\"location.assign('main.jsp')\"> </div> </center>\n");
      out.write("\n");
      out.write("    <hr size=\"5\" color=\"black\">\n");
      out.write("    <center>\n");
      out.write("        <a href=\"Top-main.jsp\"><img src=\"image\\top.jpg\" height=\"30\" width=\"120\"></a>\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"30\" width=\"100\">\n");
      out.write("        <a href=\"Bottom-main.jsp\"><img src=\"image\\bottom.jpg\" height=\"30\" width=\"120\"></a>\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"30\" width=\"100\">\n");
      out.write("        <a href=\"Outer-main.jsp\"><img src=\"image\\outer.jpg\" height=\"30\" width=\"120\"></a>\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"30\" width=\"100\">\n");
      out.write("        <a href=\"Sho-main.jsp\"><img src=\"image\\shoes.jpg\" height=\"30\" width=\"120\"></a>\n");
      out.write("        <img src=\"image\\space.jpg\" height=\"30\" width=\"100\">\n");
      out.write("        <a href=\"event.jsp\"><img src=\"image\\event.jpg\" height=\"30\" width=\"120\"></a>\n");
      out.write("    </center>\n");
      out.write("    <hr size=\"5\" color=\"black\">\n");
      out.write("\n");
      out.write("    <br><br>\n");
      out.write("    <font size=\"5\"><center><b>&nbsp;&nbsp;BEST ITEMS<sup><font size=\"1\" color=\"red\">HIT!</font></sup></b></font>\n");
      out.write("        <hr width=\"13%\" size=\"2\" color=\"gray\"></center><br>\n");
      out.write("\n");
      out.write("    <table align=\"center\" width =\"1000\" height=\"600\" cellpadding=\"15\">\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Top-1.jsp\"><img src = \"image\\TOP1.gif\"  alt=\"컨트롤 맨투맨\" title=\"컨트롤 맨투맨\"><br><br>컨트롤 맨투맨(기모)</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_best.png\"><br>\n");
      out.write("            <font size=\"4\"><b>8,500원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Top-2.jsp\"><img src = \"image\\TOP2.gif\"  alt=\"프리즈 체크셔츠\" title=\"프리즈 체크셔츠\"><br><br>프리즈 체크셔츠 | 기모 피치면</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_best.png\"> <img src = \"image\\ic_new.gif\"> <img src = \"image\\ic_sale.gif\"><br>\n");
      out.write("            <font size=\"4\"><b><s>16,000원</s>  → 12,000원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Top-3.jsp\"><img src = \"image\\TOP3.gif\"  alt=\"오레오 폴라티\" title=\"오레오 폴라티\"><br><br>오레오 폴라티 | 목폴라 루즈핏</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_best.png\"> <img src = \"image\\ic_new.gif\">  <img src = \"image\\ic_66size.gif\"><br>\n");
      out.write("            <font size=\"4\"><b>17,000원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Bottom-7.jsp\"><img src = \"image\\BOTTOM7.jpg\"  alt=\"베티 테니스스커트\" title=\"베티 테니스스커트\"><br><br>베티 테니스스커트 | 체크 치마 주름치마\n");
      out.write("                <br><hr size=\"1\" color=\"black\">\n");
      out.write("                <img src = \"image\\ic_best.png\"><br>\n");
      out.write("                <font size=\"4\"><b>16,900원</b></font>\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Bottom-1.jsp\"><img src = \"image\\BOTTOM1.gif\"  alt=\"하모니 스커트\" title=\"하모니 스커트\"><br><br>하모니 스커트 | 모직 치마 H라인</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_best.png\"><br>\n");
      out.write("            <font size=\"4\"><b>8,500원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Bottom-4.jsp\"><img src = \"image\\BOTTOM4.gif\"  alt=\"아몬드봉봉 밴딩슬랙스\" title=\"아몬드봉봉 밴딩슬랙스\"><br><br>아몬드봉봉 밴딩슬랙스 | 면바지 기모바지 배기팬츠</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_best.png\"> <img src = \"image\\ic_66size.gif\"> <img src = \"image\\ic_sale.gif\"> <br>\n");
      out.write("            <font size=\"4\"><b><s>12,000원</s> -> 8,900원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Outer-1.jsp\"><img src = \"image\\OUT1.gif\"  alt=\"교복 떡볶이코트\" title=\"교복 떡볶이코트\"><br><br>(누빔)교복 떡볶이코트 | 크림떡볶이 더블코트 아우터</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_best.png\"> <img src = \"image\\ic_new.gif\"> <img src = \"image\\ic_sale.gif\"> <img src = \"image\\ic_66size.gif\"><br>\n");
      out.write("            <font size=\"4\"><b><s>45,000원</s>  → 35,500원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Outer-2.jsp\"><img src = \"image\\OUT2.gif\"  alt=\"리얼라쿤퍼 롱패딩\" title=\"리얼라쿤퍼 롱패딩\"><br><br>리얼라쿤퍼 롱패딩 | 패딩 아우터 점퍼 야상</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_best.png\"> <img src = \"image\\ic_today1.gif\"> <img src = \"image\\ic_sale.gif\"> <img src = \"image\\ic_66size.gif\"> <br>\n");
      out.write("            <font size=\"4\"><b><s>65,000원</s>  → 52,000원</b></font>\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<br><br>\n");
      out.write("<hr size=\"2\" color=\"gray\"><br><br>\n");
      out.write("<font size=\"5\"><center><b>NEW GOODS</b></font>\n");
      out.write("    <hr width=\"13%\" size=\"2\" color=\"gray\"></center><br>\n");
      out.write("\n");
      out.write("<table align=\"center\" width =\"1000\" height=\"600\" cellpadding=\"15\">\n");
      out.write("    <tr>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Top-2.jsp\"><img src = \"image\\TOP2.gif\"  alt=\"프리즈 체크셔츠\" title=\"프리즈 체크셔츠\"><br><br>프리즈 체크셔츠 | 기모 피치면</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_best.png\"> <img src = \"image\\ic_new.gif\"> <img src = \"image\\ic_sale.gif\"><br>\n");
      out.write("            <font size=\"4\"><b><s>16,000원</s>  → 12,000원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Top-3.jsp\"><img src = \"image\\TOP3.gif\"  alt=\"오레오 폴라티\" title=\"오레오 폴라티\"><br><br>오레오 폴라티 | 목폴라 루즈핏</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_best.png\"> <img src = \"image\\ic_new.gif\">  <img src = \"image\\ic_66size.gif\"><br>\n");
      out.write("            <font size=\"4\"><b>17,000원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Top-4.jsp\"><img src = \"image\\TOP4.gif\"  alt=\"폴인러브 후드\" title=\"폴인러브 후드\"><br><br>폴인러브 후드(기모)</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_new.gif\"> <img src = \"image\\ic_today1.gif\"> <img src = \"image\\ic_66size.gif\"><br>\n");
      out.write("            <font size=\"4\"><b>12,500원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Bottom-2.jsp\"><img src = \"image\\BOTTOM2.gif\"  alt=\"겨울 트레이닝팬츠\" title=\"겨울 트레이닝팬츠\"><br><br>(양기모)겨울 트레이닝팬츠 | 반바지 롤업 팬츠 츄리닝</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_new.gif\"> <img src = \"image\\ic_66size.gif\"> <img src = \"image\\ic_sale.gif\"><br>\n");
      out.write("            <font size=\"4\"><b><s>7,000원</s> -> 5,000원</b></font>\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Bottom-3.jsp\"><img src = \"image\\BOTTOM3.gif\"  alt=\"디오 데님스커트\" title=\"디오 데님스커트\"><br><br>디오 데님스커트 | 치마 청스커트</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_new.gif\"><br>\n");
      out.write("            <font size=\"4\"><b>11,900원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Bottom-6.jsp\"><img src = \"image\\BOTTOM6.gif\"  alt=\"굿모닝 트레이닝팬츠\" title=\"굿모닝 트레이닝팬츠\"><br><br>(기모)굿모닝 트레이닝팬츠 | 츄리닝 조거팬츠 홈웨어\n");
      out.write("                <br><hr size=\"1\" color=\"black\">\n");
      out.write("                <img src=\"image\\ic_new.gif\"> <img src=\"image\\ic_66size.gif\"> <img src=\"image\\ic_sale.gif\"><br>\n");
      out.write("                <font size=\"4\"><b>10,500원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Top-7.jsp\"><img src = \"image\\OUT7.gif\"  alt=\"오토 코트\" title=\"오토 코트\"><br><br>(누빔)오토 코트 | 지퍼점퍼 양털코트 아우터\n");
      out.write("                <br><hr size=\"1\" color=\"black\">\n");
      out.write("                <img src = \"image\\ic_new.gif\"> <img src = \"image\\ic_66size.gif\"><br>\n");
      out.write("                <font size=\"4\"><b>42,900원</b></font>\n");
      out.write("        </td>\n");
      out.write("        <td width=\"25%\">\n");
      out.write("            <a href=\"Top-1.html\"><img src = \"image\\SHO1.jpg\"  alt=\"아이러너 슈즈\" title=\"아이러너 슈즈\"><br><br>아이러너 슈즈 | 스트랩힐</a>\n");
      out.write("            <br><hr size=\"1\" color=\"black\">\n");
      out.write("            <img src = \"image\\ic_new.gif\"><br>\n");
      out.write("            <font size=\"4\"><b>19,500원</b></font>\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<div id=\"gotop\">\n");
      out.write("    <a href=\"#top\"><img src=\"image\\up.jpg\" height=\"35\" width=\"50\"></a><br>\n");
      out.write("    <img src=\"image\\cursor.jpg\" height=\"50\" width=\"50\"> <br>\n");
      out.write("    <a href=\"#bottom\"> <img src=\"image\\down.jpg\" height=\"35\" width=\"50\"> </a> \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">initMoving(document.getElementById(\"gotop\"), 50, 50, 50);</script> \n");
      out.write("\n");
      out.write("<a href=\"#top\" name=\"bottom\"><img src=\"image\\totop.jpg\" align=\"right\"></a>\n");
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
