package 笔试.笔试中的问题集中;

import java.text.DecimalFormat;

public class 保留小数点_四舍五入 {

    public static void main(String[] args) {
        double d = 3.14159265359;
        System.out.printf("使用printf保留六位小数"+"%.6f",d);
        System.out.println();


        double d1 = 2/(double)3;
        System.out.println(2/3);//0
        System.out.println((double)2/3);//0.6666666666666666
        System.out.println(2/(double)3);//0.6666666666666666
        DecimalFormat df = new DecimalFormat("#.000000");
//        df.format(d);//返回的是String
        System.out.println("使用DecimalFormat保留六位小数："+df.format(d1));



        double d2 = 3.14159265359;
        System.out.println("使用String的format保留六位小数：" + String.format("%.6f",d2));
    }

}
