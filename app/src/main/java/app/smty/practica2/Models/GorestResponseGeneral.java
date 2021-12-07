package app.smty.practica2.Models;

import java.util.List;

public class GorestResponseGeneral {
    List<User> data;

    public GorestResponseGeneral() {
    }

    public GorestResponseGeneral(List<User> userList) {
        this.data = userList;
    }

    public List<User> getUserList() {
        return data;
    }

    public void setUserList(List<User> userList) {
        this.data = userList;
    }
}
