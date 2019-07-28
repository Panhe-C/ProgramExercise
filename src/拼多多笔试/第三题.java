package 拼多多笔试;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
* 有N个任务，每个任务需要花费Pi时间。任务之间可能会有依赖关系，比如任务1可能依赖任务2和任务3，那么任务1必须在任务2和任务3都执行完成后才能执行；
*
* 一人只能同时执行一个任务，且，任务完成之前不能暂停切换去执行其他任务。
* 希望最小化任务的平均返回时长，一个任务的返回时长定义为任务执行完成时刻减去平台接收到该任务的时刻。
* 在零时间，所有N个任务都已被平台接收。
*
* 安排下任务执行顺序，使的平均返回时长最小。
*
* 输入描述：
*   第一行包含两个正整数N,M，分别表示任务数量和M个任务依赖关系；
*   第二行包含N个正整数，第i个数表示第i个任务的处理时间Pi；
*
*   接下来的M行，每行表示一个依赖关系，。每行包括两个整数Ai,Bi,表示第Bi个任务依赖于第Ai个任务。数据保证不会出现循环依赖的情况；
*
* 例子：
*   输入：
*   5，6
*   1,2,1,1,1
*   1,2
*   1,3
*   1,4
*   2,5
*   3,5
*   4,5
*
*   输出：
*       1 3 4 2 5
*
* */
public class 第三题 {


    /*优先队列，分别按时间和下标排序，一遍ac
    *
    * 优先队列 耗时短且依赖为0的先出
    * */
//
//    作者：sugarheart
//    链接：https://www.nowcoder.com/discuss/212297
//    来源：牛客网

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        int dep = sc.nextInt();
        int[] time = new int[task + 1];
        for(int i = 1; i < time.length; i++){
            time[i] = sc.nextInt();
        }
        int[][] tmp = new int[dep][2];
        for(int i = 0; i < dep; i++){
            for(int j = 0; j < 2; j++){
                tmp[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int[] nums = new int[task + 1];
        for(int[] num : tmp){
            nums[num[1]]++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2)-> time[e1] - time[e2]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            list.add(cur);
            for(int[] p : tmp){
                if(p[0] == cur){
                    nums[p[1]]--;
                    if(nums[p[1]] == 0){
                        queue.offer(p[1]);
                    }
                }
            }
        }
        if(list.size() == task){
            for(int i = 0; i < list.size(); i++){
                if(i == list.size() -1){
                    System.out.println(list.get(i));
                    break;
                }
                System.out.print(list.get(i) + " ");
            }
        }

    }

}
