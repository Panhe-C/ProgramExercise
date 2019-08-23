package test;

public class 字符串反转 {
    public static void main(String[] args) {
        String s = "abc";
//        StringBuffer sb = s;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <s.length(); i++) {
            stringBuffer.append(s.charAt(i));
        }

        System.out.println(stringBuffer.reverse());


    }

}
