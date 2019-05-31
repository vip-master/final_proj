package commands;

import model.Ticket;
import services.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Client implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return (new Login()).doClient(request);
    }
}
