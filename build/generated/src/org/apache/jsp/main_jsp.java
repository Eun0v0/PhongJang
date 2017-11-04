package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      util.Status status = null;
      synchronized (request) {
        status = (util.Status) _jspx_page_context.getAttribute("status", PageContext.REQUEST_SCOPE);
        if (status == null){
          status = new util.Status();
          _jspx_page_context.setAttribute("status", status, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head><title>Login</title></head>\n");
      out.write("    <body>\n");
      out.write("        <h2>PhongJang Login</h2>\n");
      out.write("        ");
if ((status != null) && !status.isSuccessful()) {
      out.write("\n");
      out.write("        <font color=\"red\">There were problems processing your request:\n");
      out.write("        <ul>");
Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();
      out.write("\n");
      out.write("            <li>");
      out.print( ex.getMessage());
}
      out.write("</ul></font>");
}
      out.write("\n");
      out.write("        <form action=\"login\" method=\"post\">\n");
      out.write("            <table>\n");
      out.write("                <tr><td>Login Select:</td>\n");
      out.write("                    <td><select name=\"usertype\">\n");
      out.write("                            <option name=\"usertype\" value=\"unknown\">Your Select\n");
      out.write("                            <option name=\"usertype\" value=\"A\">Administrator\n");
      out.write("                            <option name=\"usertype\" value=\"C\">Customer</select></td></tr>\n");
      out.write("                <tr><td>UserID:</td><td>\n");
      out.write("                        <input type=\"text\" name=\"userID\" size=\"24\"></td></tr>\n");
      out.write("                <tr><td>Password:</td><td>\n");
      out.write("                        <input type=\"password\" name=\"password\" size=\"24\"></td></tr></table>\n");
      out.write("            <input type=\"submit\" value=\"Submit\">\n");
      out.write("        </form>\n");
      out.write("        if you have not your ID, you should join to my shopping site!\n");
      out.write("        <form action=\"join.jsp\" method=\"post\">\n");
      out.write("            <input type=\"submit\" value=\"Join\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
