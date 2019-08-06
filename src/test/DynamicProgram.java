package test;

public class DynamicProgram {

    public static void main(String[] args) {

        /*第一个问题*/
        int[] arr = {4,1,1,9,1};
        System.out.println("递归方法求得最大和：" + rec_opt(arr,arr.length-1));
        System.out.println("非递归方法求得最大和" + dp_opt(arr));


        /*第二个问题*/
//        int[] arr1 = {3,34,4,12,5,2};
        int[] arr1 = {3,34,4,12,5,2};
        System.out.println(rec_subset(arr1,19,arr1.length-1));
        System.out.println(dp_subset(arr1,19));
    }




    /*
    * 一组数组，求不相邻数相加的最大值
    *
    *
    * */

    //递归
    public static int rec_opt(int[] arr,int index) {
        if(index==0){
            return arr[0];
        }else if (index==1){
            return arr[1]>arr[0] ? arr[1] : arr[0];
        }

        if(rec_opt(arr,index-2)+arr[index] > rec_opt(arr,index-1)){//向前评估选和不选当前元素时得两种方案的最大值
            return rec_opt(arr,index-2)+arr[index];
        }else{
            return rec_opt(arr,index-1);
        }
    }

    //非递归
    public static int dp_opt(int[] arr){
        int[] opt = new int[arr.length];

        opt[0] = arr[0];
        opt[1] = arr[1]>arr[0] ? arr[1] : arr[0];

        for (int i = 2; i < arr.length; i++) {//一步步从前往后算出每一步得最大值
            int a = opt[i-2] + arr[i];
            int b = opt[i-1];

            opt[i] = a > b ? a : b;
        }

        return opt[arr.length-1];
    }


    //=====================================================================================================================


    /*
    * 一组数组，是否存在方案，使得数组中的某几个数之和等于指定的数
    *
    * */
    public static boolean rec_subset(int[] arr,int target,int index){

        //递归有三个出口

        if(target == 0) return true;

        if(index == 0) return arr[0] == target;

        if(arr[index] > target){//当arr[index]大于此时的目标数时，则直接判断不选择该元素的情况
            return rec_subset(arr,target,index-1);
        }else return rec_subset(arr,target-arr[index],index-1) || rec_subset(arr,target,index-1);


//        if(target==0){return true;}
//        if(index<0 || target<0) return false;
//
//
//        if (rec_subset(arr,target-arr[index],index-1) || rec_subset(arr,target,index-1)){
//            return true;
//        }else return false;

    }


    //非递归用数组保存中间状态
    public static boolean dp_subset(int[] arr,int target){
        boolean[][] subset = new boolean[arr.length][target+1];


        for (int i = 0; i < arr.length; i++) {
            subset[i][0] = true;
        }
        for (int i = 0; i < target+1; i++) {
            subset[0][i] = false;
        }
        subset[0][arr[0]] = true;


        //用subset来记录中间的状态，从前往后记录；根据出口判断添加了添加中间表subset的记录的内容
        for (int i = 1; i < subset.length; i++) {
            for (int j = 1; j < subset[0].length; j++) {
                if(arr[i] > j){
                    subset[i][j] = subset[i-1][j];
                }else{
                    boolean a = subset[i-1][j-arr[i]];
                    boolean b = subset[i-1][j];
                    subset[i][j] = a || b;
                }
            }
        }

        return subset[arr.length-1][target];
    }








//    public static boolean rec_subset(int[] arr,int i,int s) {
//        if(s == 0) return true;
//        else if (i==0) return arr[0] == s;
//        else if (arr[i]>s) return rec_subset(arr, i-1, s);
//        else {
//            boolean a = rec_subset(arr, i-1, s-arr[i]);
//            boolean b = rec_subset(arr, i-1, s);
//            if(a || b) return true;
//        }
//        return false;
//
//    }
//
//    public static boolean dp_subset(int[] arr, int S) {
//        boolean[][] subset = new boolean[arr.length][S+1];
//        for(int i = 0;i<arr.length;i++) {
//            subset[i][0] = true;
//        }
//        for(int i = 0;i<S+1;i++) {
//            subset[0][i] = false;
//        }
//        if(S>=arr[0]) {
//            subset[0][arr[0]]=true;
//        }
//        for(int i = 1;i<arr.length;i++) {
//            for(int s=1;s<S+1;s++) {
//                if(arr[i] >s){
//                    subset[i][s] = subset[i-1][s];
//                }
//                else {
//                    boolean a = subset[i-1][s-arr[i]];
//                    boolean b = subset[i-1][s];
//                    subset[i][s] = a||b;
//                }
//            }
//        }
//        return subset[arr.length-1][S];
//    }




}
