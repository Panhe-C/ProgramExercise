package 笔试.顺丰笔试_0829;


/*
*
3 3 2
2 3
3 1
* */
import java.util.*;

public class one {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int people = s.nextInt();
        int languages = s.nextInt();
        int k = s.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(s.nextInt(),s.nextInt());
        }


        Map<Integer, List<Integer>> newMap = new HashMap();//存储会语言i的人
        for (int i = 0; i <languages; i++) {
            List<Integer> list = new LinkedList<>();
            for (int key : map.keySet()){//key是人
                if(map.get(key) == i) list.add(key);//如果某个人会第i种语言则放入list
            }

            newMap.put(i,list);
        }



        System.out.println(2);



    }
}
