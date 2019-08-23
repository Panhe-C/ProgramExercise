package test;

public class 判断完全平方数 {
    public static void main(String[] args) {
        int a = 121;

        int s = (int) Math.sqrt(a);

        if(a == s*s){
            System.out.println(s);
        }else System.out.println("不是完全平方数");
    }
}
