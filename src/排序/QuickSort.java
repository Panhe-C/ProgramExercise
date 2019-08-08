//package 排序;
//
//
//
//public class QuickSort {
//
//    /**
//     * 快速排序
//     *
//     * 分析：
//     * 		//自顶向下
//     * 		顶部(2+2)： 对arr[l...r]的范围进行排序
//     * 			截止条件
//     * 			调用partition	得到基准点p
//     * 			递归调用[l,p-1]
//     * 			递归调用[p+1, r]
//     * 		partition (3+3)
//     * 			基准点v=arr[l]
//     * 			定义j=l 	(j是基准点的临时索引)
//     * 			循环 i=[l+1,r]
//     * 				//左半部分定义：arr[l+1..j]<v 左半部分arr[j+1..i)>v
//     * 				//i j的初始值让左右区间初始区间都为空
//     * 				判断
//     * 					如果当前元素arr[i]>v  则不处理，i++
//     * 					如果当前元素arr[i]<v  则 交换arr[i]和arr[j+1] j++,i++ //破环了元素的相对顺序，所以是不稳定的
//     * 			全部数据[l+1,r]排序好后，交换l和j处的值
//     *
//     * 性能评价：
//     * 		O(nlogn)算法
//     * 		不适用于 近似有序的数据。会退化成O(n.^2)的算法
//     * 		不适用于大量重复数据的数据，会退化成O(n.^2)的算法
//     *
//     */
//    private QuickSort(){}
//
//    // 对arr[l...r]部分进行partition操作
//    // 定义:返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
//    private static int partition(Comparable[] arr, int l, int r){
//
//        Comparable v = arr[l];		//比较的标准，p的前身
//
//
//
//        //迭代更新的准则(以j为界):  arr[l+1...j] < v ; arr[j+1...i) > v
//        int j = l;
//        for( int i = l + 1 ; i <= r ; i ++ )
//            if( arr[i].compareTo(v) < 0 ){
//                j ++;
//                swap(arr, j, i);
//            }
//
//        swap(arr, l, j);
//
//        return j;
//    }
//
//    // 递归使用快速排序,对arr[l...r]的范围进行排序
//    private static void sort(Comparable[] arr, int l, int r){
//
//        if( l >= r )
//            return;
//
//        int p = partition(arr, l, r);
//        sort(arr, l, p-1 );	//不包括p
//        sort(arr, p+1, r);  //不包括p
//    }
//
//    public static void sort(Comparable[] arr){
//
//        int n = arr.length;
//        sort(arr, 0, n-1);
//    }
//
//    private static void swap(Object[] arr, int i, int j) {
//        Object t = arr[i];
//        arr[i] = arr[j];
//        arr[j] = t;
//    }
//
//    // 测试 QuickSort
//    public static void main(String[] args) {
//
//        // Quick Sort也是一个O(nlogn)复杂度的算法
//        // 可以在1秒之内轻松处理100万数量级的数据
//        int N = 1000000;		//百万级别
//        int N2 = 10000;
//        Integer[] arr2 = SortTestHelper.generateNearlyOrderedArray(N2,100);	//应对近乎有序的数组的情况非常不好！！
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
//        SortTestHelper.testSort("com.haomiao.chapters.sortadvance.QuickSort", arr2);
//
//        return;
//    }
//}
