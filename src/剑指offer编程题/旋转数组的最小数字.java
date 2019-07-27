package 剑指offer编程题;


/*
*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
* 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
* 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
*  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
* */

public class 旋转数组的最小数字 {

    /*
    * 解题思路：非减序排列的数据，所以原数组是后一个元素要么大于前一个，要么等于前一个；
    * 所以旋转后的数组，一旦后一个比前一个要小，那么后一个就是最小的。
    * */
    public int minNumberInRotateArray(int [] array) {
        if(array == null){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }

        for(int i=0;i<array.length;i++){
            if(array[i]>array[i+1]){
                return array[i+1];
            }
        }

        return array[0];
    }
}
