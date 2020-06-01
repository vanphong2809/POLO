package org.apache.jsp.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_currencyCode_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_formatNumber_value_currencyCode_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_formatNumber_value_currencyCode_nobody.release();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Head.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <body class=\"no-skin\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"main-container\" id=\"main-container\">\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    try {\n");
      out.write("                        ace.settings.check('main-container', 'fixed')\n");
      out.write("                    } catch (e) {\n");
      out.write("                    }\n");
      out.write("                </script>\n");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"main-content\">\n");
      out.write("                    <div class=\"main-content-inner\">\n");
      out.write("                        <div class=\"breadcrumbs\" id=\"breadcrumbs\">\n");
      out.write("                            <script type=\"text/javascript\">\n");
      out.write("                                try {\n");
      out.write("                                    ace.settings.check('breadcrumbs', 'fixed')} catch (e) {\n");
      out.write("                                }\n");
      out.write("                            </script>\n");
      out.write("\n");
      out.write("                            <ul class=\"breadcrumb\">\n");
      out.write("                                <li>\n");
      out.write("                                    <i class=\"ace-icon fa fa-home home-icon\"></i>\n");
      out.write("                                    <a href=\"#\">Home</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"active\">Dashboard</li>\n");
      out.write("                            </ul><!-- /.breadcrumb -->\n");
      out.write("\n");
      out.write("                            <div class=\"nav-search\" id=\"nav-search\">\n");
      out.write("                                <form class=\"form-search\">\n");
      out.write("                                    <span class=\"input-icon\">\n");
      out.write("                                        <input type=\"text\" placeholder=\"Search ...\" class=\"nav-search-input\" id=\"nav-search-input\" autocomplete=\"off\" />\n");
      out.write("                                        <i class=\"ace-icon fa fa-search nav-search-icon\"></i>\n");
      out.write("                                    </span>\n");
      out.write("                                </form>\n");
      out.write("                            </div><!-- /.nav-search -->\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"page-content\">\n");
      out.write("\n");
      out.write("                            <div class=\"row\">\n");
      out.write("\n");
      out.write("                                <!-- PAGE CONTENT BEGINS -->\n");
      out.write("\n");
      out.write("                                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                                    <div class=\"panel panel-primary\">\n");
      out.write("                                        <div class=\"panel-heading\">\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-xs-3\">\n");
      out.write("                                                    <i class=\"fa fa-user fa-5x\"></i>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                                    <div class=\"huge\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                                                <div>Số người dùng</div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <a href=\"#\">\n");
      out.write("                                        <div class=\"panel-footer\">\n");
      out.write("                                            <span class=\"pull-left\">View Details</span>\n");
      out.write("                                            <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                            <div class=\"clearfix\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                                <div class=\"panel panel-green\">\n");
      out.write("                                    <div class=\"panel-heading\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-xs-3\">\n");
      out.write("                                                <i class=\"fa fa-tasks fa-5x\"></i>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-xs-9 text-right\">\n");
      out.write("                                                <div class=\"huge\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalFeeback}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                                                <div>Phản hồi mới!</div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <a href=\"#\">\n");
      out.write("                                        <div class=\"panel-footer\">\n");
      out.write("                                            <span class=\"pull-left\">View Details</span>\n");
      out.write("                                            <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                            <div class=\"clearfix\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                                <div class=\"panel panel-yellow\">\n");
      out.write("                                    <div class=\"panel-heading\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-xs-3\">\n");
      out.write("                                                <i class=\"fa fa-shopping-cart fa-5x\"></i>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-xs-9 text-right\">\n");
      out.write("                                                <div class=\"huge\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalOrder}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                                                <div>Đơn hàng mới</div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <a href=\"#\">\n");
      out.write("                                        <div class=\"panel-footer\">\n");
      out.write("                                            <span class=\"pull-left\">View Details</span>\n");
      out.write("                                            <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                            <div class=\"clearfix\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                                <div class=\"panel panel-red\">\n");
      out.write("                                    <div class=\"panel-heading\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-xs-3\">\n");
      out.write("                                                <i class=\"fa fa-support fa-5x\"></i>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-xs-9 text-right\">\n");
      out.write("                                                <div class=\"huge\">");
      if (_jspx_meth_fmt_formatNumber_0(_jspx_page_context))
        return;
      out.write("</div>\n");
      out.write("                                                <div>Doanh thu!</div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <a href=\"#\">\n");
      out.write("                                        <div class=\"panel-footer\">\n");
      out.write("                                            <span class=\"pull-left\">View Details</span>\n");
      out.write("                                            <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                            <div class=\"clearfix\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div><!-- /.row -->\n");
      out.write("                    </div><!-- /.page-content -->\n");
      out.write("                </div>\n");
      out.write("            </div><!-- /.main-content -->\n");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        </div><!-- /.main-container -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
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

  private boolean _jspx_meth_fmt_formatNumber_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_currencyCode_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_0.setParent(null);
    _jspx_th_fmt_formatNumber_0.setCurrencyCode("3");
    _jspx_th_fmt_formatNumber_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalMoney}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_formatNumber_0 = _jspx_th_fmt_formatNumber_0.doStartTag();
    if (_jspx_th_fmt_formatNumber_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_currencyCode_nobody.reuse(_jspx_th_fmt_formatNumber_0);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_currencyCode_nobody.reuse(_jspx_th_fmt_formatNumber_0);
    return false;
  }
}
