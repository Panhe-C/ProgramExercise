package 笔试.笔试中的问题集中;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 输入问题 {

    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();

        //在java中，next()方法是不接收空格的，
        // 在接收到有效数据前，所有的空格或者tab键等输入被忽略，若有有效数据，则遇到这些键退出。nextLine()可以接收空格或者tab键，其输入应该以enter键结束。
        sc.nextLine();



        System.out.println("请输入你的姓名：");
        String name = sc.nextLine();
        System.out.println("请输入你的工资：");
        float salary = sc.nextFloat();
        System.out.println("你的信息如下：");
        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);

    }

    /*
    * 一行输入
    *
    * */





    /*
    *
    *
    * */


    /*
    *
    *
    * */


}
class 多行输入_数组知道长度{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));
    }
}
class 知道多少行{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<String> list = new ArrayList<>();
        while(n-->0){
            list.add(scanner.next());
        }
        System.out.println(list);

    }
}

class 多行输入_数组不知道长度{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine();

        String[] s = scanner.nextLine().trim().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }

        System.out.println(Arrays.toString(arr));
    }

}
