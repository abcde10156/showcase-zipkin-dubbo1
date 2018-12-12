package com.luotao.showcase.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author luotao-work
 * date   2015-08-25 15:58
 */
public class Jetty_ClientWeb {
    public static void startup(String path, String appName, int port) throws Exception {
        Server server = new Server(port);
        WebAppContext webapp = new WebAppContext(path, appName);
        server.setHandler(webapp);
        server.start();
        server.join();
    }//D:\JavaProject\teacher-web\src\test\java\com.noriental\Jetty_Teacher.java

    public static void main(String[] args) throws Exception {
        startup("E:\\work\\project\\showcase\\client-web\\src\\main\\webapp", "/", 8089);
    }
}
