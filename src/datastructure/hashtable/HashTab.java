package datastructure.hashtable;
class HashTab {

    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        empLinkedListArray = new EmpLinkedList[size];
        this.size = size;
        //记得初始化链表数组中每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    } //end HashTab()

    /**
     * 添加员工信息
     *
     * @param emp
     */
    public void add(Emp emp) {
        //根据员工id得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);

    } //end add()

    /**
     * 遍历hash表
     */
    public void visit() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].visit();
        } //end for
    } //end visit()

    /**
     * 根据id查找雇员信息-假设id不重复
     * @param id
     * @return
     */
    public Emp findEmpById(int id) {
        //根据员工id得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(id);
        return empLinkedListArray[empLinkedListNo].findEmpById(id);
    } //end findEmpById()

    /**
     * 通过指定id来删除员工信息
     * @param id
     */
    public boolean deleteEmpById(int id) {
        int empLinkedListNo = hashFun(id);
        return empLinkedListArray[empLinkedListNo].delete(id);
    } //end deleteEmpById()

    /**
     * 计算hashcode
     * @param id
     * @return
     */
    public int hashFun(int id) {
        return id % size;
    } //end hashFun()

}
