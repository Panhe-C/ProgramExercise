package 笔试.三六零_0831;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        if(str.length() == 0) return;

        Map<Character,Integer> oneMap = new HashMap();

        for (int i = 0; i < str.length(); i++) {
            if(!oneMap.containsKey(str.charAt(i))){
                oneMap.put(str.charAt(i),1);
            }else oneMap.put(str.charAt(i),oneMap.get(str.charAt(i))+1);
        }

        int max = 0;
        char m = 0;
        for (char c : oneMap.keySet()) {
            if(oneMap.get(c) > max){
                max = oneMap.get(c);
                m = c;
            }
        }

        System.out.println(m);

    }
}
