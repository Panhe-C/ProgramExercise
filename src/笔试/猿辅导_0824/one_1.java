import java.util.*;

public class one_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int maxRepet = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else map.put(nums[i],1);
        }

        Map<Integer,Integer> newMap = new HashMap<>();
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
