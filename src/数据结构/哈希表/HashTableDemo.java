package 数据结构.哈希表;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        //一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            key = scanner.next();
            Employee employee = new Employee();
            switch(key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();

                    //创建雇员

                    employee.setId(id);
                    employee.setName(name);
                    hashTab.add(employee);
                    break;

                case "list":
                    hashTab.list();
                    break;
                case "find":
                    int findId = scanner.nextInt();
                    employee = hashTab.findEmpById(findId);
                    System.out.println("雇员id为："+employee.getId()+"；"+"雇员名字为："+employee.getName());
                    break;

                case "delete":
                    System.out.println("输入需要删除的雇员id：");
                    int deletId = scanner.nextInt();
                    System.out.println("输入需要删除的雇员姓名：");
                    String deletName = scanner.next();
                    hashTab.delete(deletId,deletName);
                    break;

                case "exit":
                    scanner.close();
                    System.exit(0);

                default:
                    break;

            }
        }
    }



}


//创建hashTab 管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;//标识有多少条链表

    public HashTab(int size) {
        this.size = size;
        //初始化
        this.empLinkedListArray = new EmpLinkedList[size];


        //要记得初始化每条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加
    public void add(Employee employee){
        int empLinkedListNo = hashFun(employee.getId());
        empLinkedListArray[empLinkedListNo].add(employee);
    }

    //遍历所有链表,遍历hashtab
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据id查找雇员
    //找到返回emp，没找到返回无
    public Employee findEmpById(int id){
        int index = hashFun(id);

        Employee byId = empLinkedListArray[index].findById(id);
        return byId;
    }

    //根据id删除雇员
    public void delete(int id,String name){
        int index = hashFun(id);
        empLinkedListArray[index].delete(id,name);
        System.out.println("删除成功");
    }


    //编写散列函数，取模法
    public int hashFun(int id){
        return id % size;
    }



}
