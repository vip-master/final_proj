package commands;

import model.Passenger;
import services.PassengerService;
import services.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Admin implements Command {
    PassengerService pservice = new PassengerService();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String s=request.getRequestURI().substring(0,request.getRequestURI().lastIndexOf("/"));
        s=request.getRequestURI().substring(s.lastIndexOf("/"),request.getRequestURI().lastIndexOf("/"));

        if(s.equals("/change")){
            int id;
            String login;
            String pass;
            int id_t;
            try{
                id=Integer.parseInt(request.getParameter("id"));
                login=request.getParameter("login");
                pass=request.getParameter("password");
                String id_T=request.getParameter("id_trip");
                if(id_T!=null) id_t=Integer.parseInt(id_T);
                else id_t=0;
            }catch (NumberFormatException e){
                return cycle(request);
            }
            pservice.change(id,new Passenger(id,login,pass,id_t));
            return cycle(request);
        }
        else if(s.equals("/delete")){
            int id;
            try{
                id=Integer.parseInt(request.getParameter("id"));
            }catch (NumberFormatException e){
                return cycle(request);
            }
            pservice.delete(id);
            return cycle(request);
        }
        else return "/sqlerror.jsp";
    }

    private String cycle(HttpServletRequest request){
        return (new Login()).doAdmin(request);
    }

}
