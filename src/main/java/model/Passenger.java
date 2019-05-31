package model;

public class Passenger {
    private int id;
    private String login;
    private String password;
    private int id_trip;

    public Passenger(int id, String login, String password, int id_trip) {
        this.id = id;
        this.id_trip = id_trip;
        this.login = login;
        this.password = password;
    }

    public Passenger copy() {
        return new Passenger(id, login, password, id_trip);
    }

    public int getId() {
        return id;
    }

    public int getId_trip() {
        return id_trip;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Passanger #" + id + ": login: " + login + " password: " + password;
    }
}
