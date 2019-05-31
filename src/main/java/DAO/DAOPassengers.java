package DAO;

import model.Passenger;
import web.DBPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPassengers extends AbstractDAO {

    public Passenger getOne(String login,String password) throws SQLException {
        connection = DBPool.getInstance().getConnection();
        statement = connection.prepareStatement("SELECT * FROM passangers WHERE `login`=? AND `password`=?;");
        statement.setString(1, login);
        statement.setString(2, password);
        return gettingOne();
    }

    public List<Passenger> getAll() throws SQLException {
        connection = DBPool.getInstance().getConnection();
        statement = connection.prepareStatement("SELECT * FROM passangers;");
        answer = statement.executeQuery();

        List<Passenger> result = new ArrayList<>();

        while (answer.next()) result.add(new Passenger(answer.getInt(1),
                answer.getString(2), answer.getString(3), answer.getInt(4)));

        close();

        return result;
    }

    public void update(int id, Passenger passenger) throws SQLException {

        if (passenger == null) throw new IllegalArgumentException();

        if (getOne(id) == null) {
            insert(passenger);
        } else {
            connection = DBPool.getInstance().getConnection();
            statement = connection.prepareStatement
                    ("UPDATE `final_proj`.`passangers` SET `id`=?, `login`=?, `password`=?, `id_ticket`=? WHERE `id`=?;\n");
            fillingStat(passenger);
            statement.setInt(5, id);
            statement.executeUpdate();
            close();
        }

    }

    public void delete(int id) throws SQLException {
        connection = DBPool.getInstance().getConnection();
        statement = connection.prepareStatement("DELETE FROM `final_proj`.`passangers` WHERE `id`=?;");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    private Passenger getOne(int id) throws SQLException {
        connection = DBPool.getInstance().getConnection();
        statement = connection.prepareStatement("SELECT * FROM passangers WHERE `id`=?;");
        statement.setInt(1, id);
        return gettingOne();
    }

    private void insert(Passenger passenger) throws SQLException {
        if (passenger == null) throw new IllegalArgumentException();
        connection = DBPool.getInstance().getConnection();

        //if(getOne(passenger.getId())!=null) return false;

        statement = connection.prepareStatement
                ("INSERT INTO `passangers` (`id`, `login`, `password`, `id_ticket`) VALUES (?,?,?,?);");
        fillingStat(passenger);
        statement.executeUpdate();

    }

    private void fillingStat(Passenger passenger) throws SQLException {
        statement.setInt(1, passenger.getId());
        statement.setString(2, passenger.getLogin());
        statement.setString(3, passenger.getPassword());
        statement.setInt(4, passenger.getId_trip());
    }

    private Passenger gettingOne() throws SQLException {
        answer = statement.executeQuery();

        Passenger result = null;

        if (answer.next()) result = new Passenger(answer.getInt(1),
                answer.getString(2), answer.getString(3), answer.getInt(4));

        if (answer.next()) throw new SQLException("Too much elements");

        close();

        return result;
    }
}
