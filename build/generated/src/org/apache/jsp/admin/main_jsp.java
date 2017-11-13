package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import domain.User;
import java.util.ArrayList;
import domain.PhoneCase;

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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Product List</title>\r\n");
      out.write("        ");
 ArrayList<PhoneCase> phoneCases = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");
      out.write("\r\n");
      out.write("        ");
 User user = (User) request.getAttribute("user");
      out.write("\r\n");
      out.write("        ");
 session.setAttribute("user", user);
      out.write("\r\n");
      out.write("        ");
 session.setAttribute("phoneCases", phoneCases);
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h2>Hello, ");
      out.print( user.getName());
      out.write("</h2>\r\n");
      out.write("        <form action=\"paymentlist\" method=\"post\">\r\n");
      out.write("            <input type=\"submit\" value=\"모든 결제내역\">\r\n");
      out.write("        </form>        \r\n");
      out.write("        <table border=\"2px\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th width=\"100\">케이스 ID</th>\r\n");
      out.write("                <th width=\"150\">타입</th>\r\n");
      out.write("                <th width=\"200\">케이스 이름</th>\r\n");
      out.write("                <th width=\"400\">설명</th>\r\n");
      out.write("                <th width=\"150\">가격</th>\r\n");
      out.write("                <th width=\"150\">수정</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

                for (int i = 0; i < phoneCases.size(); i++) {
                    PhoneCase phoneCase = phoneCases.get(i);
            
      out.write(" \r\n");
      out.write("            <tr>\r\n");
      out.write("                <td align=\"center\">");
      out.print(phoneCase.getCaseID());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(phoneCase.getCaseType());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(phoneCase.getCaseName());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(phoneCase.getExplanation());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">$");
      out.print(phoneCase.getPrice());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">\r\n");
      out.write("                    <form action=\"update\" method=\"post\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"caseID\" value=\"");
      out.print(phoneCase.getCaseID());
      out.write("\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"caseType\" value=\"");
      out.print(phoneCase.getCaseType());
      out.write("\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"caseName\" value=\"");
      out.print(phoneCase.getCaseName());
      out.write("\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"explanation\" value=\"");
      out.print(phoneCase.getExplanation());
      out.write("\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"price\" value=\"");
      out.print(phoneCase.getPrice());
      out.write("\">\r\n");
      out.write("                        <input type=\"submit\" value=\"수정\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        \r\n");
      out.write("        <form action=\"create\" method=\"post\">\r\n");
      out.write("            <input type=\"submit\" value=\"새 상품 추가\">\r\n");
      out.write("        </form>\r\n");
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
