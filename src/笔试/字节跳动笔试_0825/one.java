package 笔试.字节跳动笔试_0825;


/*
3
0 4 0
4 0 0
0 0 0
2

3
0 4 0
4 0 6
0 6 0
1
* */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class one {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[][] times = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                times[i][j] = s.nextInt();
            }
        }

        int result = 0;

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                if(times[i][j] >= 3){
                    map.put(i,j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(times[i][j]==0) count++;
            }
            if (count == 3) result++;
        }

        if (map.size()==1){
            System.out.println(++result);
            return;
        }

        int[] keys = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()){
            keys[i] = key;
            i++;
        }
        for (int j = 0; j < keys.length-1; j++) {
            if((keys[j + 1] - keys[j]) != 1){
                result++;
            }
        }

        System.out.println(++result);
    }
}
