<%@page pageEncoding="UTF-8"
  contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="org.hibernate.*" %>
<%@page import="org.hibernate.boot.registry.*" %>
<%@page import="org.hibernate.service.*" %>
<%@page import="org.hibernate.cfg.Configuration" %>
<%@page import="com.bwtakacy.hibernate.*" %>
<html>
<head>
<meta http-equiv="Contest-Type"
  content="text/html;charset=UTF-8" />
<title>Hibernate Sample</title>
<style>
body { font-size:14pt; }
table tr th { padding:5px 10px; background:#666; color:white; }
table tr td { padding:5px 10px; background:#dde; color:#333; }
</style>
</head>
<body>
  <h1>Index page</h1>
  <table border="0">
    <tr><th>ID</th><th>NAME</th><th>MEMO</th></tr>
    <%
    Configuration conf = new Configuration().configure();
    conf.addResource("map.hbm.xml");
    StandardServiceRegistryBuilder sb = new
      StandardServiceRegistryBuilder();
    sb.applySettings(conf.getProperties());
    ServiceRegistry sr = sb.build();
    SessionFactory sf = conf.buildSessionFactory(sr);
    org.hibernate.Session ses = sf.openSession();
    Criteria cr = ses.createCriteria(MyMapping.class);
    List<MyMapping> list = cr.list();
    for (Object obj: list) {
      MyMapping mm = (MyMapping) obj;
    %>
    <tr>
      <td><%=mm.getId()%></td>
      <td><%=mm.getName()%></td>
      <td><%=mm.getMemo()%></td>
    </tr>
    <%
      }
      ses.close();
    %>
  </table>
</body>
</html>
