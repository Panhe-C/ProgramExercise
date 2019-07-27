package 剑指offer编程题;



/*
*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
* 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
* 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
* */

public class 调整数组顺序使奇数位于偶数前面_代码完整性 {

    public static void reOrderArray(int [] array) {



            for(int i= 0;i<array.length-1;i++){
                //已经循环遍i，说明有i个偶数被换到最后的i个了，所以最后的i个就不用再循环了
                for(int j=0;j<array.length-1-i;j++){
                    if(array[j]%2==0&&array[j+1]%2==1){
                        int t = array[j];
                        array[j]=array[j+1];
                        array[j+1]=t;
                    }
                }
            }


        System.out.println(array);


    }

/*
    链接：https://www.nowcoder.com/questionTerminal/beb5aa231adc45b2a5dcc5b62c93f593
    来源：牛客网
    插入排序思想
    */

    public void reOrderArray1(int [] array) {
        //相对位置不变，稳定性
        //插入排序的思想
        int m = array.length;
        int k = 0;//记录已经摆好位置的奇数的个数
        for (int i = 0; i < m; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                while (j > k) {//j >= k+1
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                k++;
            }
        }
    }

    public static void swap(int a ,int b){
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {

        int[] array = new int[]{3,4,5,7,9};
//        System.out.println(array);
        reOrderArray(array);


    }
}
