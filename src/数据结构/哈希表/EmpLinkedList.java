package 数据结构.哈希表;


import java.util.Calendar;

/*标识一条链表*/
public class EmpLinkedList {


    //头指针，指向当前链表的第一个雇员
    private Employee head;//默认null

    //相关对雇员的操作
    //add
    //添加雇员到链表
        //1.假定，添加雇员，id是自增的；所以将雇员直接加入到本链表的最后即可
    public void add(Employee employee){
        //如果是第一个雇员
        if(head == null){
            head = employee;
            return;
        }
        //若不是第一个雇员，则使用一个辅助指针定位到最后
        Employee curEmp = head;
        while (true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;//后移
        }
        curEmp.next = employee;
    }

    //list
    //遍历链表的雇员信息
    public void list(int no){
        if(head == null){
            System.out.println("第"+no+"链表为空");
            return;
        }
        System.out.println("第"+no+"链表信息为：");
        Employee curEmp = head;//辅助指针
        while (true){
            System.out.printf("=> id=%d name=%s\t", curEmp.getId(), curEmp.getName());
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }

        System.out.println();
    }

    //find
    public Employee findById(int id){
        if(head == null){
            System.out.println("该链表为空");
            return null;
        }
        Employee curEmp = head;//辅助指针
        while (true) {
            if (curEmp.getId() == id) {
                break;
            }

            if(curEmp.next==null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;


    }

    //del
    public void delete(int id,String name){
        if(head == null){
            System.out.println("该链表为空");
            return;
        }
        Employee curEmp = head;//辅助指针
        if(curEmp.getName().equals(name)){
            head = curEmp.next;
        }
        while (curEmp.next!=null) {
            if ( curEmp.next.getId()==id && curEmp.next.getName().equals(name)) {
                curEmp.next = curEmp.next.next;
            }
            curEmp = curEmp.next;
        }
    }
}
