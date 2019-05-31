package services;

import DAO.DAOPassengers;
import DAO.DAOSchedule;
import model.Ticket;
import org.apache.log4j.Logger;
import web.HelloServletJava;

import java.sql.SQLException;
import java.util.List;

public class TicketService {
    private static final Logger LOGGER =Logger.getLogger(HelloServletJava.class);
    private final DAOSchedule dao=new DAOSchedule();

    public List<Ticket> getAll(){
        try {
            return dao.getAll();
        }catch (SQLException e) {
            LOGGER.error("Unable get all tickets");
            LOGGER.info(e.getSQLState());
            for (StackTraceElement s: e.getStackTrace()) LOGGER.error(s);
            return null;
        }
    }
}
