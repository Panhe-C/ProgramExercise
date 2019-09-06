package 笔试.当当笔试_0902;


/*
11011
* */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        String s1 = stringBuilder.append(str).reverse().toString();

        char[] chars = s1.toCharArray();
        Map<Integer,String> alboToChinese = new HashMap<>();

        alboToChinese.put(0,"零");
        alboToChinese.put(1,"壹");
        alboToChinese.put(2,"贰");
        alboToChinese.put(3,"叁");
        alboToChinese.put(4,"肆");
        alboToChinese.put(5,"伍");
        alboToChinese.put(6,"陆");
        alboToChinese.put(7,"柒");
        alboToChinese.put(8,"捌");
        alboToChinese.put(9,"玖");

        Map<Integer,String> units = new HashMap<>();
        units.put(1,"元");
        units.put(2,"拾");
        units.put(3,"佰");
        units.put(4,"仟");
        units.put(5,"万");
        units.put(9,"亿");

        for (int i = chars.length-1; i >=0 ; i--) {
            int num = Integer.valueOf(String.valueOf(chars[i]));
            if(i >= 4 && i <=7 ){
                System.out.print(alboToChinese.get(num));
                if(num != 0 && i!=4)
                    System.out.print(units.get(i-3));
                if(i == 4)
                    System.out.print(units.get(5));
            }else {
                System.out.print(alboToChinese.get(num));
                if (num != 0)
                    System.out.print(units.get(i + 1));
            }
        }
        System.out.print("整");
    }
}
