package 笔试.当当笔试_0902;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        str.replace(" ","");
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            if(c != ' '){
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else
                    map.put(c, 1);
            }
        }

        int times = 0;
        for(char c : map.keySet()){
            if(map.get(c) > times)
                times = map.get(c);
        }
        System.out.println(times);
    }
}
