package org.vwvm.agent;

import java.io.*;

import javax.servlet.*;

public class HelloWorldServlet extends GenericServlet {

           public void service(ServletRequest request,
                               ServletResponse response)throws IOException{
                               PrintWriter out = response.getWriter();
                                out.print("Hello World");
              }
}