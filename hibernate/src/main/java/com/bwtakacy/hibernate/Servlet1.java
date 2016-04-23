package com.bwtakacy.hibernate;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

@WebServlet("/serv1")
public class Servlet1 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    List<MyMapping> list = this.getSelect();
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h3>データベース一覧</h3>");
    out.println("<table border=1>");
    for (Object obj: list) {
      MyMapping mm = (MyMapping) obj;
      out.println("<tr>");
      out.println("<td>" + mm.getId() + "</td>"); 
      out.println("<td>" + mm.getName() + "</td>"); 
      out.println("<td>" + mm.getMemo() + "</td>"); 
      out.println("</tr>");
    }
    out.println("</table>");
    out.println("</body></html>");
  }

  public List<MyMapping> getSelect() {
    Configuration conf = new Configuration().configure();
    conf.addResource("map.hbm.xml");
    StandardServiceRegistryBuilder sb =
      new StandardServiceRegistryBuilder();
    sb.applySettings(conf.getProperties());
    ServiceRegistry sr = sb.build();
    SessionFactory sf = conf.buildSessionFactory(sr);
    Session ses = sf.openSession();
    @SuppressWarnings("unchecked")
    List<MyMapping> list =
      ses.createCriteria(MyMapping.class).list();
    ses.close();
    return list;
  }
}

