package onlinefooddeliverysystem.Model;

import onlinefooddeliverysystem.Entity.User;

import java.util.List;

public class UserData {
    private String code;
    private String msg;
    private List<User> userList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
