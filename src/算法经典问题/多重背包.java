package 算法经典问题;

public class 多重背包 {

    public static void main(String[] args) {

        int[] weigh = {2,3,4,5,9};
        int[] value = {3,4,5,8,10};
        int capacity = 18;
        System.out.println(dp_knapsack(weigh,value,capacity));
    }


    /*
    *
    *多重背包：
    *   有n件物品，每件物品有相应的重量和价值
    * 有一固定容量的背包，装入物品中的总价值最大为多少
    *
    *
    *
    * */
    public static int dp_knapsack(int[] weigh,int[] value,int capcity){
        //构造二维数组存储中间数据
        int row = weigh.length+1;//行
        int col = capcity+1;//列
        int[][] state = new int[weigh.length+1][capcity+1];
        for (int i = 0; i < col; i++) {
            state[0][i] = 0;
        }
        for (int i = 0; i < row; i++) {
            state[i][0]=0;
        }


        for (int i = 1; i < row; i++) {
            for (int currentCap = 1; currentCap < col; currentCap++) {
                if(weigh[i-1] > currentCap){//若当前物品重量大于当前剩余背包容量，则直接选择不拿该物品的方案
                    state[i][currentCap] = state[i-1][currentCap];
                }else{
                    int value1 = state[i-1][currentCap - weigh[i-1]] + value[i-1];//拿第i个物品的方案：i-1，背包容量-第i个物品的重量，价值+第i件物品的价值
                    int value2 = state[i-1][currentCap];//不拿第i个物品的方案

                    if(value1 > value2){
                        state[i][currentCap] = value1;
                    }else state[i][currentCap] = value2;
                }
            }
        }

        return state[row-1][col-1];


    }





}
