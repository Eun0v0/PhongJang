package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head><title>회원가입</title></head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
  String name = "";
             if (name == null || name.equals("")) { 
      out.write("\r\n");
      out.write("        <img src=\"image\\login.jpg\" onClick=\"location.assign('login.jsp')\">\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("        <img src=\"image\\logout.jpg\" onClick=\"location.assign('logout.jsp')\">\r\n");
      out.write("        ");
  }
      out.write("\r\n");
      out.write("        <a href=\"cart_list.jsp\"><img src=\"image\\cart.jpg\"></a>\r\n");
      out.write("        <a href=\"order_list.jsp\"><img src=\"image\\order.jpg\"></a>\r\n");
      out.write("        <a href=\"join.jsp\"><img src=\"image\\join.jpg\"></a>\r\n");
      out.write("        <a href=\"board\\board-list.jsp\"><img src=\"image\\q&a.jpg\"></a>\r\n");
      out.write("\r\n");
      out.write("    <center> <div align=\"middle\"> <img src=\"image\\banner2.jpg\" onClick=\"location.assign('main.jsp')\"> </div> </center>\r\n");
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
      out.write("</ul></font>");
}
      out.write("\r\n");
      out.write("    <form name =\"join\" action=\"join\" method=\"post\">\r\n");
      out.write("        <center> <br>\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><img src=\"image\\id.JPG\" width=150 height=35\"></td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"userID\" size=\"24\"></td></tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><img src=\"image\\password.JPG\" width=150 height=35\"></td>\r\n");
      out.write("                    <td><input type=\"password\" name=\"password\" size=\"24\"></td></tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><img src=\"image\\name.jpg\" width=150 height=35\"></td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"userName\" size=\"24\"></td></tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><img src=\"image\\phone.jpg\" width=150 height=35\"></td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"phoneNumber\" size=\"24\"></td></tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><img src=\"image\\address.jpg\" width=150 height=35\"></td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"address\" size=\"50\"></td></tr>\r\n");
      out.write("                <tr><td><img src=\"image\\white.jpg\" height = 35></td></tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </center>\r\n");
      out.write("        <center>\r\n");
      out.write("            <input type=\"image\" src=\"image\\loginbutton.jpg\" name=\"Submit\" value =\"Submit\" aline=\"absmiddle\">\r\n");
      out.write("            <input type=\"image\" src=\"image\\clearbutton.jpg\" name=\"Reset\" value =\"Reset\" aline=\"absmiddle\">\r\n");
      out.write("        </center>\r\n");
      out.write("    </form>\r\n");
      out.write("    <form action=\"main.jsp\" method=\"post\">\r\n");
      out.write("        <input type=\"submit\" value=\"main\">\r\n");
      out.write("    </form>\r\n");
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
