package 笔试.猿辅导_0824;

import java.util.*;


/*
老师在直播课上让同学们在聊天区报学号，每报一次可获得一份礼物，但是老师不给报数次数超过一定的次数的同学发礼物；
规定当发现某个数大于m次，则认为报数过多，需要去除这些学生的报数后的报数数列


输入：
    第一行，两个数，学生报数总个数n,和允许的最大重复个数m，以空格分隔
    第二行：n个整数，表示学生所有报数数列，空格分隔；范围：-2147483648~2147483648
输出：
    一行，去除超过m次的报数数字后的报数数列，该数列不改变原报数顺序
* */

/*
7 2
4 3 3 3 1 5 5
*
* */
public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int maxRepet = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Map<Integer,Integer> map = new HashMap<>();//用map记录报数的每个数的重复次数
        for (int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else map.put(nums[i],1);
        }

        Map<Integer,Integer> newMap = new HashMap<>();//用另一个map存储重复次数超过m次的数
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            if(entry.getValue() > maxRepet){
                newMap.put(entry.getKey(),entry.getValue());
            }
        }

        for (int i = 0; i < n; i++) {
            if(!newMap.containsKey(nums[i])){
                System.out.print(nums[i] + " ");
            }
        }

    }

}
