package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import domain.User;
import java.net.URLEncoder;
import java.net.URLDecoder;
import domain.Qna;
import java.util.Iterator;

public final class qnaCreate_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">\n");
      out.write("        <title>Q&A 작성하기</title>\n");
      out.write("        ");
 ArrayList<Qna> qnas = (ArrayList<Qna>) request.getAttribute("qnas");
      out.write("\n");
      out.write("        ");
User user = (User) request.getAttribute("user");
      out.write("\n");
      out.write("        ");
session.setAttribute("user", user);
      out.write("\n");
      out.write("        ");
session.setAttribute("qnas", qnas);
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <table border=\"0px\">\n");
      out.write("            <tr>\n");
      out.write("                ");

                    if (user == null) { 
      out.write("\n");
      out.write("                <td><img src=\"image\\login.jpg\" onClick=\"location.assign('login.jsp')\"></td>\n");
      out.write("                <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\n");
      out.write("                        <img src=\"image\\cart.jpg\"></a>\n");
      out.write("                </td>\n");
      out.write("                <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\n");
      out.write("                        <img src=\"image\\order.jpg\"></a>\n");
      out.write("                </td>\n");
      out.write("                <td><a OnClick=\"alert('로그인을 해주세요!')\" style=\"cursor:pointer\">\n");
      out.write("                        &nbsp;\n");
      out.write("                        <input type=\"image\" src=\"image\\myPageUp_1.jpg\" name=\"Submit\" value =\"MY PAGE\"></a>\n");
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
      out.write("\n");
      out.write("                <td><form action=\"paymentlist\" method=\"post\">\n");
      out.write("                        <input type=\"image\" src=\"image\\order.jpg\" name=\"Submit\" value =\"주문 목록\">\n");
      out.write("                    </form>    \n");
      out.write("                </td>\n");
      out.write("                <td><form action=\"myPage\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" name=\"userID\" value=\"");
      out.print(user.getId());
      out.write("\">\n");
      out.write("                        &nbsp;\n");
      out.write("                        <input type=\"image\" src=\"image\\myPageUp_1.jpg\" name=\"Submit\" value =\"MY PAGE\">\n");
      out.write("                    </form>    \n");
      out.write("                </td>\n");
      out.write("                ");
  }
      out.write("\n");
      out.write("                <td><form action=\"IDCheck\" method=\"post\">\n");
      out.write("                        <input type=\"image\" src=\"image\\join.jpg\" name=\"Submit\" value =\"회원가입\">\n");
      out.write("                    </form>    \n");
      out.write("                </td>\n");
      out.write("\n");
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
      out.write("    <form action =\"search\" method=\"post\">\n");
      out.write("        <img src=\"image\\search.png\" height=\"17\" width=\"17\">\n");
      out.write("        <input type=\"text\" size=\"16\" name=\"caseName\">\n");
      out.write("        <input type=\"submit\" value=\"검색\">\n");
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
      out.write("    <center></br></br><img src=\"image\\qnawrite.jpg\"><br></center>\n");
      out.write("    <center>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <td><center><table>\n");
      out.write("                    <tr height=\"1\" bgcolor=\"#ECBFD8\"><td colspan=\"4\"></td></tr>\n");
      out.write("                    <tr height=\"1\" bgcolor=\"#dddddd\"><td colspan=\"4\"></td></tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                        <th width=\"120\" height=\"35\">????</th>\n");
      out.write("                        <td><input name=\"title\" size=\"48\" maxlength=\"100\"></td>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr height=\"1\" bgcolor=\"#dddddd\"><td colspan=\"3\"></td></tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                        <th width=\"120\" height=\"35\">?????</th>\n");
      out.write("                        <td><input name=\"name\" size=\"48\" maxlength=\"50\"></td>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr height=\"1\" bgcolor=\"#dddddd\"><td colspan=\"3\"></td></tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                        <th width=\"60\" height=\"35\">??й??</th>\n");
      out.write("                        <td><input name=\"password\" size=\"48\" maxlength=\"50\"></td>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr height=\"1\" bgcolor=\"#dddddd\"><td colspan=\"3\"></td></tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                        <th width=\"60\" height=\"35\">????</th>\n");
      out.write("                        <td><textarea name=\"memo\" cols=\"50\" rows=\"13\"></textarea></td>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr height=\"1\" bgcolor=\"#dddddd\"><td colspan=\"4\"></td></tr>\n");
      out.write("                    <tr height=\"1\" bgcolor=\"#ECBFD8\"><td colspan=\"4\"></td></tr>\n");
      out.write("                    <tr align=\"center\">\n");
      out.write("                        <td>&nbsp;</td><br>\n");
      out.write("                        <td colspan=\"2\">\n");
      out.write("                            <form action=\"writeQna\" methor=\"post\">\n");
      out.write("                                <input type=\"submit\" value=\"???\">\n");
      out.write("                            </form>\n");
      out.write("                            <input type=button value=\"???\">\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </center></td></tr>\n");
      out.write("        </table>\n");
      out.write("    </center>\n");
      out.write("</body>\n");
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
