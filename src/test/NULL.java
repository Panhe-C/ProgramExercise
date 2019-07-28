package test;

public class NULL {
    public static void haha(){
        System.out.println("haha");
    }

    public static void main(String[] args) {
        ((NULL)null).haha();
        //null可以强制转换为任何Java类型；但null强制转换后是无效对象，返回值还是为null；
        //而static方法的调用是和类名绑定的，不借助对象进行访问，所以能正常输出。
    }
}
