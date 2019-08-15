//package 笔试.拼多多笔试_08_11;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//
///*
//*
//* 一串长度为L的珍珠项链，上面有N颗珍珠，分布在0到L-1的位置上；
//* 想把所有珍珠移动到一起，并想让所有蒸煮移动的距离总和尽可能小
//* 所有珍珠可以看作在一个环上，珍珠可以向相邻的没有珍珠的位置移动；
//* 请给出最优的方案下，所有珍珠移动的距离的总和
//*
//* 输入：
//*
//*   第一行L,N
//*   第二行N个整数，表示每个珍珠所在的位置，题目保证所有珍珠的位置都各不相同
//*
//*
//* 输入：
//*       1000 4
//*       1  4  998  995
//* 输出：
//*       8
//*
//* */
//
//
//public class two {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int L = scanner.nextInt();
//        int N = scanner.nextInt();
//
//        int[] jwelLoc = new int[N];
//        for (int i = 0; i < N; i++) {
//            jwelLoc[i] = scanner.nextInt();
//        }
//
//        Arrays.sort(jwelLoc);
//        int[] distance = new int[N];
//        distance[0] = jwelLoc[1]-jwelLoc[0];
//        distance[N-1] = jwelLoc[0] + L - jwelLoc[N-1] - 1;
//        for (int i = 1; i < N-1; i++) {
//            distance[i] = jwelLoc[i+1]-jwelLoc[i]-1;
//        }
//
//        int min = distance[0];
//        int max = distance[0];
//        int minIndex = 0;
//        int maxIndex = 0;
//        for (int i = 1; i < distance.length; i++) {
//            if(distance[i]<min){
//                min = distance[i];
//                minIndex = i;
//            }
//            if(distance[i] > max){
//                max = distance[i];
//                maxIndex = i;
//            }
//        }
//
//        int sum = 0;
//
//        if(minIndex < maxIndex){
//            for (int i = minIndex-1; i >=0; i--) {
//                sum += distance[i] + distance[i+1]-1;
//            }
//            for (int i = minIndex; i < maxIndex; i++) {
//                sum += distance[minIndex+1] +
//            }
//
//
//
//        }
//
//        Arrays.sort(distance);
//
//
//        int dist = distance[0];
//        for (int i = 1; i < distance.length-1; i++) {
//            dist +=  distance[i] + distance[i-1];
//        }
//
//
//        System.out.println(dist);
//
//    }
//}
