package datastructure.comparetest;

/**
 * 商品
 */
public class Goods implements Comparable{
    private String name;
    private int price;

    public Goods() {

    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Object o) {
        Goods goods = null;
        if (o instanceof Goods) {
            goods = (Goods)o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                return 0;
            } //end if...else
        }
        //方式二：
//        return Double.compare(this.price,goods.price);
        throw new RuntimeException("传入的数据类型不一致！");
    } //end compareTo()
}
