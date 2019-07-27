package Java面试宝典.传递与引用;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 输入输出流 {


    /*
    * */
    static class InputData{
        static private String s = "";
        static public void input() {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                try {
                    s = input.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


        static public int getInt(){
            input();
            return Integer.parseInt(s);
        }
    }

    static class Reslut{
        void print(int d){
            System.out.println(d + "的平方：" + d*d);
            System.out.println(d + "的立方：" + d*d*d);
        }
    }

    public static void main(String[] args) {
        Reslut reslut = new Reslut();
        System.out.println("请输入一个整数：");
        int a = InputData.getInt();
        reslut.print(a);

    }

}
