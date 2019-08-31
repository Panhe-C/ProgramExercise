package test;

public class String类和常量池 {
    public static void main(String[] args) {



        //=============字符串创建===================
        String str1 = "ancd";//在常量池拿对象
        String str2 = new String("abcd");//直接在堆内存空间创建新对象

        System.out.println(str1 == str2);//false




    }

    public static void tets(){
        //=============字符串拼接============================
        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2;//在堆上创建的对象

        String str5 = "string";//常量池中的对象

        System.out.println(str3 == str4);//flase
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
    }
}
