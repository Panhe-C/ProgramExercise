package 笔试.华为笔试_0821;


import java.util.*;

/*
* 有m个群，其中一个人把一条消息转发到他自己所在的所有群里，这些群里面的每个人又把消息再次转发到他所有的群里。
* 请问所有群的所有人都转发一次后。最后几个人收到该消息（包括发消息的人）？
*
* 输入：
*   发第一条消息的人民
*   群组个数
*   群组1的成员人名列表
*   群组2的成员人名列表
*   .
*   .
*   .
*   (人名是英文字符串，包含英文字符和空格，
*   群组人员列表包含1至多个人民，人名间用逗号分隔
*   )
* 输出：
*   以十进制输出最后能收到消息的人数
*
* 输入：
Jack
3
Jack,Tom,Anny,Lucy
Tom,Danny
Jack,Lily
* 输出：
*   6
*
* */
public class three {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String firstName = s.nextLine();
        int num = s.nextInt();
        s.nextLine();

        String[] group = new String[num];
        for (int i = 0; i < num; i++) {
            group[i] = s.nextLine();
        }


        Queue<String> queue = new LinkedList<>();
        queue.offer(firstName);

        List<String> seen = new ArrayList<>();//放入已经看过消息的人
        seen.add(firstName);

        while(queue.peek()!=null) {
            String name = queue.poll();//提取不同的人
            for (int j = 0; j < num; j++) {
                if (group[j].contains(name)) {//寻找所在的群组
                    String[] str = group[j].split(",");
                    for (String sr : str) {
                        if (!seen.contains(sr)) {//判断是否已经看过消息
                            queue.offer(sr);//将群组里的其他人放入队列
                            seen.add(sr);
                        }
                    }
                }
            }
        }

        System.out.println(seen.size());
    }
}
