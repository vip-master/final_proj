package services;

import DAO.DAOPassengers;
import model.Passenger;
import org.apache.log4j.Logger;
import web.HelloServletJava;

import java.sql.SQLException;
import java.util.List;

public class PassengerService {
    private static final Logger LOGGER =Logger.getLogger(HelloServletJava.class);
    private final DAOPassengers dao=new DAOPassengers();

    public Passenger getOne(String login,String password){
        try{
            return dao.getOne(login,password);
        }catch (SQLException e) {
            LOGGER.error("Unable get passenger by login and password");
            tracing(LOGGER,e);
            return null;
        }
    }

    public List<Passenger> getAll(){
        try{
            return dao.getAll();
        }catch (SQLException e) {
            LOGGER.error("Unable get all passengers");
            tracing(LOGGER,e);
            return null;
        }
    }

    public void change(int id, Passenger passenger){
        try{
            dao.update(id, passenger);
        }catch (SQLException e) {
            LOGGER.error("Unable change passenger");
            tracing(LOGGER,e);
        }
    }

    public void delete(int id){
        try{
            dao.delete(id);
        }catch (SQLException e) {
            LOGGER.error("Unable delete passenger");
            tracing(LOGGER,e);
        }
    }

    private void tracing(Logger LOGGER,SQLException e){
        LOGGER.info(e.getSQLState());
        for (StackTraceElement s: e.getStackTrace()) LOGGER.trace(s);
    }
}
