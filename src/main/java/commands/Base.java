package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Base implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/login.jsp";
    }
}
