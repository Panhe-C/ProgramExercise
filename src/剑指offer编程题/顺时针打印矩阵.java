package 剑指offer编程题;


/*
*输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
* 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
*
*  1  2  3  4
*  5  6  7  8
*  9  10 11 12
*  13 14 15 16
* 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
*
* */

import java.util.ArrayList;

public class 顺时针打印矩阵 {



    /*
    * 解题思路：
    * 将矩阵的四个边界点设为变量并赋初值；
    * 按顺时针设定循环寻值，第一圈循环完，把边界值往里面缩小一圈在循环；
    *
    * 注意：循环的条件设定，要考虑只有一列或只有一行或只有一个元素的二维数组的情况；
    * 考虑到最后一个值是否重复或者遗失
    *
    * */


    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        if(matrix == null || matrix.length == 0){
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        int startRow = 0;
        int startCol = 0;
        int rowEnd = matrix.length - 1;//行
        int colEnd = matrix[0].length - 1;//列


        while (startRow <= rowEnd && startCol <= colEnd){

            //第一行从左到右
            for (int i = startCol; i <= colEnd-1; i++) {
                arrayList.add(matrix[startRow][i]);
            }

            //最后一列从上到下
            for (int i = startRow; i <= rowEnd; i++) {
                arrayList.add(matrix[i][colEnd]);
            }

            //最后一行从右到左
            //这里需要加上一个if判断，防止出现只有一行或一列或只有一个元素的二维数组的重复排序
            if(startRow != rowEnd){
                for (int i = colEnd-1; i >= startCol; i--) {
                    arrayList.add(matrix[rowEnd][i]);
                }}

            //第一列从下到上
            if(startCol != colEnd){
                for (int i = rowEnd-1; i > startRow; i--) {
                    arrayList.add(matrix[i][startCol]);
                }}

            startRow++;
            rowEnd--;

            startCol++;
            colEnd--;
        }
        return arrayList;
    }


    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{1}};
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(printMatrix(matrix));
    }
}
