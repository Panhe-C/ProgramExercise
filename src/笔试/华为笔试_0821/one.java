package 笔试.华为笔试_0821;

/*
* 实现报文转义功能。报文中出现0x0A,转义为2个字节 0x12 0x34,如果出现0x0B,转义为2个字节0xAB 0xCD，其他报文保持不变
*
* 输入：
*   1.输入报文为16进制，输入报文长度不超过127，输入的报文第一个字节为报文长度，第一个字节算正式报文的一部分，但是不不参与转义
*   2.输入的报文每个字节用空格隔开
*
* 输出：
*   1.输出为转义后的报文，转移后的报文长度也不超过255.输出的报文第一个字节算正式报文的一部分，为转义后的报文长度
*   2.输出的报文内容为大写的16进制，输出报文为16进制，前不带0x前缀
*
*
* 输入：
*   8 1 2 3 4 5 6 A
* 输出：
*   9 1 2 3 4 5 6 12 34
*
* 输入：8为报文长度
* 输出：9为输出报文长度，12 34为输入报文中的A转义后的报文
*
*
* */


import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        String[] content = new String[length-1];
        for (int i = 0; i < length - 1; i++) {
            content[i] = scanner.next();
        }


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < content.length; i++) {
            if(content[i].equals("A")){
                result.append("12 ");
                result.append("34 ");

            }
            else if(content[i].equals("B")){
                result.append("AB ");
                result.append("CD ");
            }

            else result.append(content[i]+" ");
        }


        String[] s = result.toString().split(" ");
        System.out.print(s.length+1+" ");

        for (int i = 0; i < s.length; i++) {
            if(i<result.length()-1){
                System.out.print(s[i] + " ");
            }else System.out.print(s[i]);
        }
    }
}
