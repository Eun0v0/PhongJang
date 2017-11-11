package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import domain.Cart;
import domain.User;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>장바구니</title>\r\n");
      out.write("        ");
ArrayList<Cart> carts = (ArrayList<Cart>) request.getAttribute("carts");
      out.write("\r\n");
      out.write("        ");
User user = (User) request.getAttribute("user");
      out.write("\r\n");
      out.write("        ");
session.setAttribute("user", user);
      out.write("\r\n");
      out.write("    </head>\r\n");
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
      out.write("    \r\n");
      out.write("    <br>\r\n");
      out.write("    <center> <img src=\"image\\shoppingcart.jpg\" width=200 height=60\"> </center>\r\n");
      out.write("    <center> <br>\r\n");
      out.write("    <!--<h2>");
      out.print( user.getName());
      out.write(" 고객님, 장바구니 입니다.</h2>-->\r\n");
      out.write("        \r\n");
      out.write("    <table bordercellspacing = 1 cellpadding = 7>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th width=\"125\"><img src=\"image\\number.jpg\" width=125 height=35\"></th>\r\n");
      out.write("            <th width=\"170\">제품명</th>\r\n");
      out.write("            <th width=\"170\">색상</th>\r\n");
      out.write("            <th width=\"120\">수량</th>\r\n");
      out.write("            <th width=\"120\">가격</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

            if (carts != null) {
                for (int i = 0; i < carts.size(); i++) {
                    Cart cart = carts.get(i);
        
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td bgcolor=\"#ffeecc\" align=\"center\">");
      out.print(cart.getCartID());
      out.write("</td>\r\n");
      out.write("            <td align=\"center\">");
      out.print(cart.getCaseName());
      out.write("</td>\r\n");
      out.write("            <td align=\"center\">");
      out.print(cart.getColor());
      out.write("</td>\r\n");
      out.write("            <td align=\"center\">");
      out.print(cart.getNumbers());
      out.write("</td>\r\n");
      out.write("            <td align=\"center\">");
      out.print(cart.getPrice());
      out.write("</td>\r\n");
      out.write("            <td align =\"center\">\r\n");
      out.write("                <form action=\"delete\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"cartID\" value=\"");
      out.print(cart.getCartID());
      out.write("\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                    <input type=\"submit\" value=\"삭제\">\r\n");
      out.write("                </form></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");
  }
                }
      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("    </center>\r\n");
      out.write("    <form action=\"main\" method=\"post\">\r\n");
      out.write("        <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("        <input type=\"submit\" value=\"메인으로\">\r\n");
      out.write("    </form>\r\n");
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