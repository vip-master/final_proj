package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import factories.Factory;
import org.apache.log4j.Logger;

public class HelloServletJava extends HttpServlet {
    private static final Logger LOGGER =Logger.getLogger(HelloServletJava.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
       // resp.getWriter().print("Server"+resp.getContentType());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String action = request.getRequestURI()
                .substring(request.getRequestURI().lastIndexOf("/"));
        LOGGER.info(action);
        LOGGER.info(request.getRequestURI());
        request.getRequestDispatcher(Factory.getCommand(action).execute(request,response))
                .forward(request, response);
    }
}
