package 笔试.三六零_0831;

import java.util.Scanner;

public class 第二题 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int times = input.nextInt();
        int[] steps = new int[times];
        for (int i = 0; i < times; i++) {
            steps[i] = input.nextInt();
        }
        //ans
        int count = 0;
        //统计轴上的每一个点
        for (int cur = 0; cur < length; cur++) {
            if (can(cur, steps, times - 1, length)) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * @param cur    当前的位置
     * @param steps  步数记录
     * @param index  步数记录的index
     * @param length 轨道长度
     */
    public static boolean can(int cur, int[] steps, int index, int length) {
        if (index == 0) {
            return (0 <= cur && cur < length);
        } else {
            return (0 <= cur && cur < length) &&
                    ((can(cur - steps[index], steps, index - 1, length)
                            || can(cur + steps[index], steps, index - 1, length)));
        }

    }
}
