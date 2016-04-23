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

public class PojoApp {
  private static final long serialVersionUID = 1L;

  public static void main(String[] args) {
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
    for (Object obj: list) {
      MyMapping mm = (MyMapping) obj;
      System.out.println(mm.getId() + ":" + mm.getName() + ":"
        + mm.getMemo());
    }
    ses.close();
  }
}

