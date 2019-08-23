package 笔试.贝壳_0823;

public class test1 {
    public static void main(String[] args) {
        String s = "abacab";
        System.out.println(s.substring(0,2));
        System.out.println(s.split(s.substring(0,2)).length);
    }
}
