package test;



/*
* 123 输出321 -123输出-321 2100输出12
* */
public class 整数保留符号反转 {
    public static void main(String[] args) {
        int n = -123;
//        int n = 2700;
        System.out.println(reverseInteger(n));

    }
    public static int reverseInteger(int num){
        if(num == 0) return num;

        long l = num;

        String s = new StringBuffer(Math.abs(num)+"").reverse().toString();//如果不加"",则会认为是初始化StringBuffe的capacity


//        StringBuffer stringBuffer = new StringBuffer();
//        String s = stringBuffer.append(Math.abs(num)).reverse().toString();


        long newValue = Long.parseLong(s);
        long newValue1 = Long.valueOf(s);

        if(num>0){
            if(newValue > Integer.MAX_VALUE) return 0;
            else return (int) newValue;
        }
        else {
            if(newValue < Integer.MIN_VALUE) return 0;
            else return (int) -newValue;
        }

    }
}
