package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import domain.Cart;
import domain.User;
import java.util.Iterator;

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
      out.write("        ");
session.setAttribute("carts", carts);
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <table border=\"0px\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                ");

                    if (user == null) { 
      out.write("\r\n");
      out.write("                <td><img src=\"image\\login.jpg\" onClick=\"location.assign('login.jsp')\"></td>\r\n");
      out.write("                <td><td><a href=\"cart.jsp\"><img src=\"image\\cart.jpg\"></a></td>\r\n");
      out.write("                        ");
 } else {
                            session.setAttribute("user", user);
      out.write("\r\n");
      out.write("               <td><form action=\"logout\" method=\"post\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\logout.jpg\" name=\"Submit\" value =\"로그아웃\">\r\n");
      out.write("                </form> \r\n");
      out.write("                </td>\r\n");
      out.write("                <td><form action=\"cart\" method=\"post\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\cart.jpg\" name=\"Submit\" value =\"장바구니\">\r\n");
      out.write("                    </form> \r\n");
      out.write("                </td>\r\n");
      out.write("                <td><form action=\"paymentlist\" method=\"post\">\r\n");
      out.write("                    <input type=\"image\" src=\"image\\order.jpg\" name=\"Submit\" value =\"주문 목록\">\r\n");
      out.write("                </form>    \r\n");
      out.write("                </td> \r\n");
      out.write("                <td><form action=\"myPage\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                    &nbsp;\r\n");
      out.write("                    <input type=\"image\" src=\"image\\myPageUp_1.jpg\" name=\"Submit\" value =\"MY PAGE\">\r\n");
      out.write("                </form>    \r\n");
      out.write("                </td>\r\n");
      out.write("                  \r\n");
      out.write("            </td>\r\n");
      out.write("                    ");
  }
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <td><a href=\"join.jsp\"><img src=\"image\\join.jpg\"></a></td>\r\n");
      out.write("                <td><a href=\"board\\board-list.jsp\"><img src=\"image\\q&a.jpg\"></a></td>\r\n");
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
      out.write("                ");
 if (user != null) {
      out.write("\r\n");
      out.write("                <td><form action=\"myCase\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\customCase3.jpg\" name=\"Submit\" height=\"35\" width=\"140\">\r\n");
      out.write("                    </form></td>\r\n");
      out.write("                ");
 } else {
      out.write("\r\n");
      out.write("                <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\customCase3.jpg\" name=\"Submit\" height=\"35\" width=\"140\"></a></td>\r\n");
      out.write("                ");
 } 
      out.write("        \r\n");
      out.write("                <td><img src=\"image\\space.jpg\" height=\"35\" width=\"80\"></td>\r\n");
      out.write("                \r\n");
      out.write("                <td><form action =\"caseTypePage\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\bumperCase2.jpg\" name=\"Submit\" height=\"35\" width=\"140\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"caseType\" value=\"범퍼\">\r\n");
      out.write("                    </form></td>\r\n");
      out.write("                <td><img src=\"image\\space.jpg\" height=\"35\" width=\"80\"></td>\r\n");
      out.write("                \r\n");
      out.write("                <td><form action =\"caseTypePage\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\hardCase.jpg\" name=\"Submit\" height=\"35\" width=\"140\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"caseType\" value=\"하드\">\r\n");
      out.write("                    </form></td>\r\n");
      out.write("                <td><img src=\"image\\space.jpg\" height=\"35\" width=\"80\"></td>\r\n");
      out.write("                \r\n");
      out.write("                <td><form action =\"caseTypePage\" method=\"post\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\jellyCase.jpg\" name=\"Submit\" height=\"35\" width=\"140\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"caseType\" value=\"젤리\">\r\n");
      out.write("                    </form></td>\r\n");
      out.write("                <td><img src=\"image\\space.jpg\" height=\"35\" width=\"80\"></td>\r\n");
      out.write("                \r\n");
      out.write("                <td><a href=\"event.jsp\"><img src=\"image\\event_.jpg\" height=\"35\" width=\"140\"></a></td> \r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </center>\r\n");
      out.write("    <hr size=\"5\" color=\"black\">\r\n");
      out.write("\r\n");
      out.write("    <br>\r\n");
      out.write("    <center> <img src=\"image\\shoppingcart.jpg\" width=200 height=60\"> </center>\r\n");
      out.write("    <center> <br>\r\n");
      out.write("    <h2>");
      out.print( user.getName());
      out.write(" 고객님, 장바구니 입니다.</h2>\r\n");
      out.write("\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th width=\"170\" height = \"35\"><img src=\"image\\casename2.jpg\" width=170 height=40\"></th>\r\n");
      out.write("                <th width=\"120\" height = \"35\"><img src=\"image\\color.jpg\" width=120 height=40\"></th>\r\n");
      out.write("                <th width=\"120\" height = \"35\"><img src=\"image\\caseType.jpg\" width=120 height=40\"></th>\r\n");
      out.write("                <th width=\"120\" height = \"35\"><img src=\"image\\phoneKind.jpg\" width=120 height=40\"></th>\r\n");
      out.write("                <th width=\"120\" height = \"35\"><img src=\"image\\amount2.jpg\" width=120 height=40\"></th>\r\n");
      out.write("                <th width=\"120\" height = \"35\"><img src=\"image\\price.jpg\" width=120 height=40\"></th>\r\n");
      out.write("                <th width=\"40\" height = \"35\"><img src=\"image\\blank2.jpg\" width=50 height=40\"></th>\r\n");
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

                if (carts != null) {
                    for (int i = 0; i < carts.size(); i++) {
                        Cart cart = carts.get(i);
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td bgcolor=\"#dcdcdc\" align=\"center\">");
      out.print(cart.getCaseName());
      out.write("</td>\r\n");
      out.write("                <td bgcolor=\"#dcdcdc\" align=\"center\">");
      out.print(cart.getColor());
      out.write("</td>\r\n");
      out.write("                <td bgcolor=\"#dcdcdc\" align=\"center\">");
      out.print(cart.getCaseType());
      out.write("</td>\r\n");
      out.write("                <td bgcolor=\"#dcdcdc\" align=\"center\">");
      out.print(cart.getPhoneType());
      out.write("</td>\r\n");
      out.write("                <td bgcolor=\"#dcdcdc\" align=\"center\">");
      out.print(cart.getNumbers());
      out.write("</td>\r\n");
      out.write("                <td bgcolor=\"#dcdcdc\" align=\"center\">");
      out.print(cart.getPrice());
      out.write("</td>\r\n");
      out.write("                <td bgcolor=\"#dcdcdc\" align =\"center\">\r\n");
      out.write("                    <form action=\"delete\" method=\"post\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"cartID\" value=\"");
      out.print(cart.getCartID());
      out.write("\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\r\n");
      out.write("                        <input type=\"image\" src=\"image\\delete.jpg\" name=\"Submit\" value =\"삭제\" aline=\"absmiddle\">\r\n");
      out.write("                    </form></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
  }
            }
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("    </center>\r\n");
      out.write("    <br>\r\n");
      out.write("    <center>\r\n");
      out.write("        ");
 if(carts.size() == 0) { 
      out.write("\r\n");
      out.write("        <a OnClick=\"alert('결제할 항목이 없습니다!')\" style=\"cursor:pointer\">\r\n");
      out.write("                   <img src=\"image\\paybutton.jpg\"></a>\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("        <form action =\"payment\" methoe=\"post\">\r\n");
      out.write("            <input type=\"image\" src=\"image\\paybutton.jpg\" name=\"submit\" value =\"결제하기\" aline=\"absmiddle\">\r\n");
      out.write("        </form>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
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
