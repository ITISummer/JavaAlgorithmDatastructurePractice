package datastructure.hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTable hashTable = new HashTable(7);

        Emp emp1 = new Emp(1, "summer1");
        Emp emp2 = new Emp(2, "summer2");
        Emp emp3 = new Emp(3, "summer3");

        //添加
        hashTable.add(emp1);
        hashTable.add(emp2);
        hashTable.add(emp3);

        //遍历输出
//        hashTable.visit();

        //遍历查找
        Emp emp = hashTable.findEmpById(2);
        System.out.println(emp);

        //遍历删除
        boolean isDelete = hashTable.deleteEmpById(2);
        System.out.println(isDelete);

        //删除后再输出查看是否真的被删除
        hashTable.visit();

    }

}
