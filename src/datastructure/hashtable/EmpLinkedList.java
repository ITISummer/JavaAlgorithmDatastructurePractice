package datastructure.hashtable;

/**
 * 表示雇员链表
 */
public class EmpLinkedList {

    Emp head = null;
    /**
     * 链表初始化
     */
    public EmpLinkedList() {
        head = new Emp(0,null);
    }

    /**
     * 将员工信息添加到链表中 - 尾插法
     * 输出顺序与插入顺序相同
     * @param emp
     */
    public void add(Emp emp) {
        Emp last = this.head;
        while (last.next != null) {
            last = last.next;
        }
        //将emp添加到链表最后
        emp.next = last.next;
        last.next = emp;
    } //end add()

    /**
     * 遍历链表
     */
    public void visit() {
        Emp index = this.head.next;
        while (index != null) {
            System.out.println(index);
            index = index.next;
        } //end while
    } //end visit()

    /**
     * 通过id查找员工信息-假设id不重复
     * @param id
     * @return
     */
    public Emp findEmpById(int id) {
        Emp index = this.head.next;
        while (index != null) {
            if (index.id == id) {
                return index;
            }
            index = index.next;
        } //end while
        return null;
    } //end findEmpById()

    /**
     * 根据id对节点进行删除
     * @param id
     * @return
     */
    public boolean delete(int id) {
        Emp pre = this.head;
        Emp cur = pre.next;
        while (cur != null) {
            if (cur.id == id) {
                //删除操作
                pre.next = cur.next;
                cur = null;
                //找到后就返回true直接退出，不需要继续查找
                return true;
            } //end if
            pre = pre.next;
            cur = pre.next;
        } //end while
        return false;
    } //end delete()

//    public static void main(String[] args) {
//        Emp emp1 = new Emp(1,"summer1");
//        Emp emp2 = new Emp(2,"summer2");
//        Emp emp3 = new Emp(3,"summer3");
//
//        EmpLinkedList empLinkedList = new EmpLinkedList();
//        empLinkedList.add(emp1);
//        empLinkedList.add(emp2);
//        empLinkedList.add(emp3);
//
//        empLinkedList.visit();
//    }
} //end EmpLinkedList
