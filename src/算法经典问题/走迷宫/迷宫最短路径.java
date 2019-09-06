package 算法经典问题.走迷宫;

/*
* 给定一个迷宫，指明起点和终点，找出从起点出发到终点的有效可行路径，就是迷宫问题（maze problem）。

迷宫可以以二维数组来存储表示。0表示通路，1表示障碍。注意这里规定移动可以从上、下、左、右四方方向移动。坐标以行和列表示，均从0开始，给定起点（0,0）和终点（4,4），迷宫表示如下：

int maze[5][5]={
    {0,0,0,0,0},
    {0,1,0,1,0},
    {0,1,1,0,0},
    {0,1,1,0,1},
    {0,0,0,0,0}
};
*
*
*
* */

import com.sun.corba.se.internal.Interceptors.PIORB;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 迷宫最短路径 {

    public static void main(String[] args) {
        int[][] tab = {
                {0,0,0,0,0},
                {0,1,0,1,0},
                {0,1,1,0,0},
                {0,1,1,0,1},
                {0,0,0,0,0}
        };

//        int[][] t = new int[4][5];
//        System.out.println(t.length);//行
//        System.out.println(t[0].length);//列
        int steps = bfs(tab);
        System.out.println(steps);
    }

    public static int bfs(int[][] maze){
        //记录走到该坐标需要的最短步数
        int[][] distance = new int[maze.length][maze[0].length];

        //记录移动的四个方位
        int[] dx = {1,0,-1,0},dy = {0,1,0,-1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));

        while (!queue.isEmpty()){
            Point p = queue.poll();

            //到达终点
            if(p.getX() == maze[0].length-1 && p.getY() == maze.length-1){
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = p.getX() + dx[i];
                int y = p.getY() + dy[i];

                //越界判断，障碍判断，是否走过判断
                if(x >= 0 && y >= 0 && x < maze[0].length && y < maze.length
                        && maze[x][y] != 1 && distance[x][y] == 0){
                        queue.add(new Point(x,y));
                        distance[x][y] = distance[p.getX()][p.getY()] + 1;
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println(Arrays.toString(distance[i]));
        }

        return distance[maze.length-1][maze[0].length-1];
    }
}
//点类，存储坐标xy
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}