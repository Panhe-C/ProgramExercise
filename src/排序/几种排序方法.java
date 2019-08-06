package 排序;

import org.junit.Test;

import java.util.Arrays;

public class 几种排序方法 {

    public static void main(String[] args) {
        int[] arr = {3,1,5,2,4};
//        arr = bubbleSort(arr);
//        arr = selectionSort(arr);
//        arr = insertSort(arr);

//        arr = shellSort(arr);
//        arr = mergeSort(arr);

        arr = quickSort(arr);




        System.out.println(Arrays.toString(arr));


    }



    /*
    *
    * 冒泡排序：
    *   它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
    *
    * 步骤：
    *   比较相邻的元素。如果第一个比第二个大，就交换它们两个；
        对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
        针对所有的元素重复以上的步骤，除了最后一个；
        重复步骤1~3，直到排序完成。
        *
        *
      算法分析：
      *     最好情况：T(n)=O(n)   最坏情况：T(n) = O(n2)  平均：T(n) = O(n2)
    * */

    public static int[] bubbleSort(int[] array){
        if(array.length==0){return array;}


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i -1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }


    /*
    * 选择排序
    *   表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了。
    * 工作原理：
    *   首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
    *   然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
    *算法分析：
    *   最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
    * */

    public static int[] selectionSort(int[] array){
        if(array.length==0){return array;}

        for (int i = 0; i < array.length; i++) {

            int minIndex=i;

            for (int j = i; j < array.length; j++) {
                if(array[j] < array[minIndex]){//找出最小的数
                    minIndex = j;//保存更小的数的索引
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }



    /*
    * 插入排序：
    *   通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
    *   插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，
    *   需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间
    * 步骤：
           1. 从第一个元素开始，该元素可以认为已经被排序；
           2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
           3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
           4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
           5. 将新元素插入到该位置后；
           6. 重复步骤2~5。
    *算法分析：
    *   最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
    *
    * */
    public static int[] insertSort(int[] array){
        if(array.length==0){return array;}

        for (int i = 0; i < array.length-1; i++) {
            int current = array[i+1];
            int preIndex = i;

            while(preIndex>=0 && current < array[preIndex]){
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
        return array;
    }





    /*
    *希尔排序
    *   希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，
    *   它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
    *
    *   希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；
    *   随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
    *
    *   例：
    *          数组：[8 9 1 7 2 3 5 4 6 0]
    *       1. 初始增量gap=length/2=5;分为5组：[8 3][9 5][1 4][7 6][2 0]
    *               每小组插入排序后：[3 5 1 6 0 8 9 4 7 2]
    *       2.缩小增量gap=5/2=2;分为两组：[3 1 0 9 7][5 6 8 4 2]
    *           分别进行插入排序：[0 2 1 4 3 5 7 6 9 8]
    *       3.缩小增量gap=2/2=1,整个数组为一组[0 2 1 4 3 5 7 6 9 8]
    *           排序后：[0 1 2 3 4 5 6 7 8 9]
    *
    * 算法分析：
    *   最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)
     *
    * */
    public static int[] shellSort(int[] array){
            int length = array.length;
            int gap = length/2;

            while (gap>0){
                for (int i = 0; i < length-gap; i++) {
                    int current = array[i + gap];
                    int preIndex = i;
                    while(preIndex>=0 && current<array[preIndex]){
                        array[preIndex+gap] = array[preIndex];
                        preIndex-=gap;
                    }
                    array[preIndex+gap]=current;
                }
                gap=gap/2;
            }

            return array;
    }




    /*
    * 归并排序：
    *   归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。

    *   法是采用分治法（Divide and Conquer）的一个非常典型的应用。
    *   归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；
    *   即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
    *
    * 算法描述：
    *   把长度为n的输入序列分成两个长度为n/2的子序列；
        对这两个子序列分别采用归并排序；
        将两个排序好的子序列合并成一个最终的排序序列。

      算法分析：
     *     最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
     * */


    public static int[] mergeSort(int[] array){
        int length = array.length;
        if(length<2){return array;}
        int mid = length/2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,length);

        return merge(mergeSort(left),mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        for (int index=0,i = 0,j=0; index < result.length; index++) {
            if(i>=left.length){
                 result[index] = right[j++];//左边加完，加右边
            }
            else if(j >= right.length){//说明right很多数比left大，先把right中的很多数加入了结果中，之后则从left中按顺序加入（记住：left和right都是排序好了的数组）
                result[index]=left[i++];
            }
            else if(left[i]>right[j]){
                result[index] = right[j++];//最后递归到最小则为两个数，若左大于右，则把大的先放到结果中，即可以实现排序。
            }
            else{
                result[index] = left[i++];//若排序正确则依序从左数组返回
            }
        }
        return result;
    }



    /*
    * 快速排序：
    *   通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
    *
    * 算法描述：
    *   快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
            1.从数列中挑出一个元素，称为 “基准”（pivot）；
            2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
              在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
            3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
    *
    *
    * */

    public static int[] quickSort(int[] array) {
        if(array.length==1 || array.length==0){return array;}
        int pivot = array[0];
        int temp = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < pivot) {
                temp = array[i];
                index = pivot;
            }
        }

        array[index] = pivot;
        array[0] = temp;

        quickSort(Arrays.copyOfRange(array, 0, index));
        quickSort(Arrays.copyOfRange(array, index, array.length));

        return array;
    }
}
