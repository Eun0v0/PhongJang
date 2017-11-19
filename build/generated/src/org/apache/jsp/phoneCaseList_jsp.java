package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import domain.PhoneCase;
import domain.User;

public final class phoneCaseList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>퐁장 상품 목록</title>\r\n");
      out.write("        ");
 ArrayList<PhoneCase> phoneCase = (ArrayList<PhoneCase>) request.getAttribute("phoneCases");
      out.write("\r\n");
      out.write("        ");
 User user = (User) request.getAttribute("user");
      out.write("\r\n");
      out.write("        ");
session.setAttribute("user", user);
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>안녕하세요, ");
      out.print(user.getName());
      out.write("님</h1>\r\n");
      out.write("        <h2>퐁장 상품 목록</h2>\r\n");
      out.write("        <form action=\"search\" method=\"post\">\r\n");
      out.write("            상품 검색 :\r\n");
      out.write("            <input type=\"text\" name=\"caseName\" size=\"24\">\r\n");
      out.write("            <input type=\"submit\" value=\"검색\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <table border=\"2px\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th width=\"100\">케이스 ID</th>\r\n");
      out.write("                <th width=\"150\">케이스 이름</th>\r\n");
      out.write("                <th width=\"200\">타입</th>\r\n");
      out.write("                <th width=\"400\">설명</th>\r\n");
      out.write("                <th width=\"150\">가격</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

                for (int i = 0; i < phoneCase.size(); i++) {
                    PhoneCase phonecase = phoneCase.get(i);
            
      out.write(" \r\n");
      out.write("            <tr>\r\n");
      out.write("                <td align=\"center\">");
      out.print(phonecase.getCaseID());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(phonecase.getCaseName());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(phonecase.getCaseType());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(phonecase.getExplanation());
      out.write("</td>\r\n");
      out.write("                <td align=\"center\">");
      out.print(phonecase.getPrice());
      out.write("원</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        <form action=\"main.jsp\" method=\"post\">\r\n");
      out.write("            <input type=\"submit\" value=\"main\">\r\n");
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
