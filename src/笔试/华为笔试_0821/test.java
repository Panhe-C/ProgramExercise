package 笔试.华为笔试_0821;

public class test {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        s.append("1");
        s.append("2");
        s.append("34");

        String str = "1.2.34";
        String[] st = str.split(" ");

        System.out.println(s.toString());

        for (String ss : st){
            System.out.print(ss + " ");
        }
    }
}
