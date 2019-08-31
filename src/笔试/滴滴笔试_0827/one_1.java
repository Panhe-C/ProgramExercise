package 笔试.滴滴笔试_0827;

/*
*
6
3 + 2 + 1 + -4 * -5 + 1
*
* */

import java.util.Arrays;
import java.util.Scanner;

public class one_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        String[] str = new String[n-1];
        for (int i = 0; i < n; i++) {
            if(i < n-1) {
                nums[i] = scanner.nextInt();
                str[i] = scanner.next();
            }else nums[i] = scanner.nextInt();
        }

        StringBuffer stringBuffer = new StringBuffer();
        String result1 = new String();
        for (int i = 0; i < n; i++) {

            if(i < n-1) {
                if (str[i].equals("*") || str[i].equals("/")) {
                    result1 = result1.concat(cowLine(stringBuffer.toString()));
                    stringBuffer.delete(0, stringBuffer.length());
                    for (int j = 0; j < result1.length(); j++) {
                        System.out.print(result1.charAt(i) + " ");
                    }

                    System.out.print(str[i] + " ");
                }
            }
            stringBuffer.append(Math.abs(nums[i]));
        }
//        for (int i = 0; i < result1.length(); i++) {
//            if(i < result1.length()-1) {
//                System.out.print(result1.charAt(i) + " ");
//                System.out.print(str[i] + " ");
//            }else System.out.println(result1.charAt(i));
//        }
    }
    public static String cowLine(String s) {
        char[] chs = new char[s.length()];
        char[] dest = new char[s.length()];
        s.getChars(0, s.length(), chs, 0);
        int start = 0, end = s.length() - 1;
        while(start <= end) {
            boolean isLeft = false;
            for(int i=0; i <= end - start; i++) {
                if(chs[start + i] < chs[end - i]) {
                    isLeft = true;
                    break;
                } else if(chs[start + i] > chs[end - i]) {
                    isLeft = false;
                    break;
                }
            }
            if(isLeft) {
                dest[s.length() - (end - start + 1)] = chs[start ++];
            } else {
                dest[s.length() - (end - start + 1)] = chs[end --];
            }
        }
        return new String(dest);
    }

}
