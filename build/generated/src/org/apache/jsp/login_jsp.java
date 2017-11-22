package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>로그인</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <table>\r\n");
      out.write("            ");
  String name = "";
                if (name == null || name.equals("")) { 
      out.write("\r\n");
      out.write("            <td><img src=\"image\\login.jpg\" onClick=\"location.assign('login.jsp')\"></td>\r\n");
      out.write("                ");
 } else { 
      out.write("\r\n");
      out.write("            <td><img src=\"image\\logout.jpg\" onClick=\"location.assign('logout.jsp')\"></td>\r\n");
      out.write("                ");
  }
      out.write("\r\n");
      out.write("            <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                    <img src=\"image\\cart.jpg\"></a>\r\n");
      out.write("            </td>\r\n");
      out.write("            \r\n");
      out.write("            <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                    <img src=\"image\\order.jpg\"></a>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                    &nbsp;\r\n");
      out.write("                    <input type=\"image\" src=\"image\\myPageUp_1.jpg\" name=\"Submit\" value =\"MY PAGE\"></a>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td><a href=\"join.jsp\"><img src=\"image\\join.jpg\"></a></td>\r\n");
      out.write("            <td><a href=\"board\\board-list.jsp\"><img src=\"image\\q&a.jpg\"></a></td>\r\n");
      out.write("        </table>\r\n");
      out.write("\r\n");
      out.write("    <center> <div align=\"middle\"> <img src=\"image\\banner2.jpg\" onClick=\"location.assign('main.jsp')\"> </div> </center>\r\n");
      out.write("    <form action =\"search\" method=\"post\">\r\n");
      out.write("        <img src=\"image\\search.png\" height=\"17\" width=\"17\">\r\n");
      out.write("        <input type=\"text\" size=\"16\" name=\"caseName\">\r\n");
      out.write("        <input type=\"submit\" value=\"검색\">\r\n");
      out.write("    </form>\r\n");
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
      out.write("\r\n");
      out.write("    ");
if ((status != null) && !status.isSuccessful()) {
      out.write("\r\n");
      out.write("    <font color=\"red\">There were problems processing your request:\r\n");
      out.write("    <ul>");
Iterator errors = status.getExceptions();
        while (errors.hasNext()) {
            Exception ex = (Exception) errors.next();
      out.write("\r\n");
      out.write("        <li>");
      out.print( ex.getMessage());
}
      out.write("</ul></font>    \r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("    <form action=\"login\" method=\"post\">\r\n");
      out.write("        <center> <br><br>\r\n");
      out.write("            <img src=\"image\\loginTitle.jpg\" height=\"60\" width=\"150\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td> <img src=\"image\\usertype.jpg\" width=150 height=35\"></td>\r\n");
      out.write("                    <td><select name=\"usertype\" >\r\n");
      out.write("                            <option name=\"usertype\" value=\"unknown\">-----\r\n");
      out.write("                            <option name=\"usertype\" value=\"A\">관리자\r\n");
      out.write("                            <option name=\"usertype\" value=\"C\">고객</select></td></tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><img src=\"image\\id.JPG\" width=150 height=35\"></td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"userID\" size=\"40\" padding=\"10px\"></td></tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><img src=\"image\\password.JPG\" width=150 height=35\"></td>\r\n");
      out.write("                    <td><input type=\"password\" name=\"password\" size=\"40\"></td></tr>\r\n");
      out.write("                <tr><td><img src=\"image\\white.jpg\" height = 35></td></tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </center>\r\n");
      out.write("        <center>\r\n");
      out.write("            <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><input type=\"image\" src=\"image\\loginbutton.jpg\" name=\"Submit\" value =\"Submit\" aline=\"absmiddle\"></td>\r\n");
      out.write("                <td><input type=\"image\" src=\"image\\clearbutton.jpg\" name=\"Reset\" value =\"Retry\" aline=\"absmiddle\"></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </center>\r\n");
      out.write("    </form>\r\n");
      out.write("    <center>\r\n");
      out.write("        <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("            <td><input type=\"image\" src=\"image\\searchIDbt2.jpg\" width=\"100\" height=\"30\" onClick=\"location.assign('searchID.jsp')\"></td>\r\n");
      out.write("            <td><input type=\"image\" src=\"image\\searchPwdBt2.jpg\" width=\"100\" height=\"30\" onClick=\"location.assign('searchPwd.jsp')\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("    </center>\r\n");
      out.write("</body>\r\n");
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
