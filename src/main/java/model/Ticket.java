package model;

import java.sql.Date;

public class Ticket {
    private int id;
    private String target;
    private Date time;

    public Ticket(int id, String target, Date time) {
        this.id = id;
        this.target = target;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public String getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "Ticket #" + id + " : target: " + target + " time: " + time;
    }
}
