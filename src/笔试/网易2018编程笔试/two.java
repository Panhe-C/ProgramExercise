package 笔试.网易2018编程笔试;

import org.junit.Test;

import java.util.Scanner;

public class two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ori = n;

        Integer i = n;
        String s = i.toString();
        int l = s.length();
        int[] newInt = new int[l];
        for (int j = l-1; j >=0 ; j--) {
            newInt[j] = (int) Math.floor(n/(Math.pow(10.0,(double)j)));
            n-=Math.pow(10.0,(double)j)*newInt[j];
        }

        int ne = 0;
        for (int j = 0; j <l; j++) {
            ne+=Math.pow(10.0,(double)(l-j-1))*newInt[j];
        }

        System.out.println(ori+ne);


//
//        char[] newInt = new char[s.length()];
//        for (int j = 0; j < s.length(); j++) {
//            newInt[s.length()-j] = s.charAt(j);
//        }
//        String re = newInt.toString();
//        Integer rs = re;

    }


/*
*
*
* int -> Strin
    int i=12345;
    String s="";
    第一种方法：s=i+"";
    第二种方法：s=String.valueOf(i);
    *
第一种方法：s=i+"";  //会产生两个String对象
第二种方法：s=String.valueOf(i); //直接使用String类的静态方法，只产生一个对象

第一种方法：i=Integer.parseInt(s);//直接使用静态方法，不会产生多余的对象，但会抛出异常
第二种方法：i=Integer.valueOf(s).intValue();//Integer.valueOf(s) 相当于 new Integer(Integer.parseInt(s))，也会抛异常，但会多产生一个对象


* */
@Test
public void int2String(){

    int n = 10;
    String s = "";
    String s1;
    s = n+"";
    s1 = String.valueOf(10);
    System.out.println(s);
    System.out.println(s1);

}



    /*
    * 超级简单
    *
    * */
    @Test
    public void simple(){
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();

        String s = "10";

        StringBuilder sb = new StringBuilder(s);
        System.out.println(Integer.parseInt(sb.reverse().toString()) + Integer.parseInt(s));

    }
}
