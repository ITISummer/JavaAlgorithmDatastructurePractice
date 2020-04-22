package datastructure.hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);

        Emp emp1 = new Emp(1, "summer1");
        Emp emp2 = new Emp(2, "summer2");
        Emp emp3 = new Emp(3, "summer3");

        //添加
        hashTab.add(emp1);
        hashTab.add(emp2);
        hashTab.add(emp3);

        //遍历输出
//        hashTab.visit();

        //遍历查找
        Emp emp = hashTab.findEmpById(2);
        System.out.println(emp);

        //遍历删除
        boolean isDelete = hashTab.deleteEmpById(2);
        System.out.println(isDelete);

        //删除后再输出查看是否真的被删除
        hashTab.visit();

    }//end main()

}
