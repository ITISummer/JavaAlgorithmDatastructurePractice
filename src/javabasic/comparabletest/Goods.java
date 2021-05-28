package javabasic.comparabletest;

/**
 * 商品
 */
public class Goods implements Comparable<Goods>{
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * 从低到高排序 - 自然排序
     * @param goods
     * @return
     */
    @Override
    public int compareTo(Goods goods) {
        // 方式一：
        if (this.price > goods.price) {
           return 1;
        } else if (this.price < goods.price) {
            return -1;
        }
        return 0;
        // 价格相同情况下比较名字
//        return this.name.compareTo(goods.name);
        // 方式二：
//        return Double.compare(this.price,goods.price);
    }

}
