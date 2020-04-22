package datastructure.generictest;

/**
 * 自定义泛型类
 */
public class Order<T> {
    String orderName;
    int orderId;

    //类的内部结构可以使用类的泛型
    T orderT;
    public Order() {};

    public Order(String orderName,int orderId,T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
}
