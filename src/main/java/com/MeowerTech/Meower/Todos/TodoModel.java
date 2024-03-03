package com.MeowerTech.Meower.Todos;

import java.util.Date;

public class TodoModel {
    private long id;
    private String desc;
    private Date date;
    private boolean done;


    protected TodoModel () {}

    public TodoModel(long id, String desc, Date date, boolean done) {
        this.id = id;
        this.desc = desc;
        this.date = date;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    @Override
    public String toString() {
        return "TodoModel{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", date=" + date +
                ", done=" + done +
                '}';
    }
}
