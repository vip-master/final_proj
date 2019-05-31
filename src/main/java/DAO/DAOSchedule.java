package DAO;

import model.Passenger;
import model.Ticket;
import web.DBPool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOSchedule extends AbstractDAO {

    public List<Ticket> getAll() throws SQLException {
        connection = DBPool.getInstance().getConnection();
        statement = connection.prepareStatement("SELECT * FROM passangers;");
        answer = statement.executeQuery();

        List<Ticket> result = new ArrayList<>();

        while (answer.next()) result.add(new Ticket(answer.getInt(1),
                answer.getString(2),
                answer.getDate(3)));

        close();

        return result;
    }
}
