package Java面试宝典.传递与引用;

import org.junit.Test;

import java.io.RandomAccessFile;

public class 传值与传引用 {




    /*StringBuffer是产生一块内存空间，相关的增删改操作都在其中进行*/
    public void test1(StringBuffer str){
        str.append(",world!");
    }
    @Test
    public void main1(){
        StringBuffer string = new StringBuffer("Hello");
        //这里string是一个引用，Java对于引用形式传递对象类型的变量时，实际上是将引用作为一个副本传进方法函数的。
        test1(string);
        System.out.println(string);
    }


    /*
    * 执行str=world时，：首先系统会自动生成一个新的String对象，并把其值设为“world”。
    * 然后把这个对象的引用赋给str；
    * 当函数结束，str作用消失，原来的内存地址上的内容并未改变。
    *
    * */
    public void test2(String str){
        str="World";
    }
    @Test
    public void main2(){
        String str = "Hello";
        test2(str);
        System.out.println(str);
    }

    /*==================================================================================*/

    public static void main(String argv[]) {
        System.out.println(argv.length);

    }
}
