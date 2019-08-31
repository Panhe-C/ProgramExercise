package 笔试.字节跳动笔试_0825;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
        int[] keys = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()){
            keys[i] = key;
            i++;
        }
        System.out.println(Arrays.toString(keys));
    }
}
