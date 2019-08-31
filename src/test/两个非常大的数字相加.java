package test;

public class 两个非常大的数字相加 {


    public static void main(String[] args) {
        String a = "1234253684759046";
        String b = "2353564545746564";
        //3,587,818,230,505,610
        System.out.println(Integer.valueOf(a.substring(0,1)));
        System.out.println(Integer.valueOf(String.valueOf(a.charAt(0))));

        System.out.println(add(a,b));
    }


    /*
    *
    * 大数用String类来保存。大数的每个位分别相加，保留每个位的进位给下一位，最后结果依然保存在String类中。

     */

    public static String add(String a,String b){
        String res = "";
        int lenA = a.length();
        int lenB = b.length();

        int maxLen = Math.max(lenA,lenB);
        int minLen = Math.min(lenA,lenB);

        StringBuilder stringBuilder = new StringBuilder();

        //保证两个数位数相同，小的数前面补零
        for (int i = 0; i < maxLen - minLen; i++) {
            stringBuilder.append(0);
        }
        if(minLen == lenA) {
            stringBuilder.append(a);
            a = stringBuilder.toString();
        }
        else {
            stringBuilder.append(b);
            b = stringBuilder.toString();
        }

        stringBuilder = new StringBuilder();

        int tempA,tempB,result;
        int sc = 0;//进位
        for (int i = maxLen-1; i >= 0; i--) {

            //字符要转换成字符串才能被正确解析出其真正的整数值
            tempA = Integer.valueOf(String.valueOf(a.charAt(i)));
            tempB = Integer.valueOf(String.valueOf(b.charAt(i)));

            result = tempA + tempB +sc;
            sc = result/10;
            result = result%10;
            stringBuilder.append(result);
        }

        //最高位仍有进位，则在前面加一
        if(sc == 1) stringBuilder.append(1);

        res = stringBuilder.reverse().toString();
        return res;
    }
}
