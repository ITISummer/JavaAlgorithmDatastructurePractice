package datastructure.hashtable;

/**
 * 表示一个雇员实体信息
 */
public class Emp {
    public int id;
    public String name;
    public Emp next; //默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
        this.next = null;
    } //end Emp()

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    } //end toString()
} //end Emp
