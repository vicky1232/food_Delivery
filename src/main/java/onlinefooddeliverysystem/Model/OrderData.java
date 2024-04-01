package onlinefooddeliverysystem.Model;

import onlinefooddeliverysystem.Entity.Order;

import java.util.List;

public class OrderData {
    private String code;
    private String msg;
    private List<Order> orderList;

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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
