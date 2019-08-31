package 笔试.滴滴笔试_0827;


/*
*
6
3 + 2 + 1 + -4 * -5 + 1
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] a=scanner.nextLine().trim().split(" ");
        Map<Integer,StringBuffer> map  = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();

        int index = 0;
        for (int i = 0; i < (n+n-1); i+=2) {
            stringBuffer.append(Math.abs(Integer.valueOf(a[i])));
            if(i<2*n-2) {
                if (a[i + 1].equals("*") || a[i + 1].equals("/")) {
                    map.put(index, stringBuffer);
                    index++;
                    stringBuffer.delete(0, stringBuffer.length());
                }
            }else map.put(index, stringBuffer);
        }

        String s = new String();
        for (int i = 0; i < index; i++) {
            s.concat(map.get(index).toString());
        }

        StringBuffer s1 = new StringBuffer();
        for (int i = 1; i < (n+n+1); i+=2) {
            s1.append(a[i]);
        }

        for (int i = 0; i < n; i++) {
            if(i<n-1){
            System.out.print(s.charAt(i) + " ");
            System.out.print(s1.toString().charAt(i) + " ");
            }else System.out.println(s.charAt(i));
        }

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
