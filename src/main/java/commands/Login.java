package commands;

import model.Passenger;
import model.Ticket;
import services.PassengerService;
import services.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Login implements Command {
    PassengerService pservice = new PassengerService();
    TicketService tservice = new TicketService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (login.equals("admin") & pass.equals("root")) return doAdmin(request);
        if (pservice.getOne(login, pass) != null) return doClient(request);
        return "/login.jsp";
    }

    String doAdmin(HttpServletRequest request) {
        List<Passenger> list = pservice.getAll();
        if (list == null) {
            return "/sqlerror.jsp";
        } else request.getSession().setAttribute("passangers", list);
        return "/admin.jsp";
    }

    String doClient(HttpServletRequest request) {
        List<Ticket> list = tservice.getAll();
        if (list == null) {
            return "/sqlerror.jsp";
        } else request.getSession().setAttribute("tickets", list);
        return "/client.jsp";
    }
}
