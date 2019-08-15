package 笔试.拼多多笔试_08_11;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        double[] arr = new double[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextDouble();
        }

        double var = Double.MAX_VALUE;

        for (int i = 0; i < num; i++) {
            for (int j = i+1; j < num; j++) {
                for (int k = j+1; k < num; k++) {
                    double[] temp = {arr[i],arr[j],arr[k]};
                    double variance = varianceImperative(temp);
                    if(variance < var){
                        var=variance;
                    }
                }
            }
        }

        System.out.printf("%.2f",var);




//        int[] arry = {-1,0,1};
//        double[] array = {-1.0,0.0,1.0};
//        System.out.println(simpleVariance(arry));
//        System.out.println(varianceImperative(array));




    }


    public static double simpleVariance(int[] arr){
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        double avg = (double)sum/arr.length;

        double var = 0.0;
        for (int i = 0; i < arr.length; i++) {
            var += (arr[i]-avg) * (arr[i]-avg);
        }

        return var;
    }

    //计算方差
    public static double varianceImperative(double[] population) {
        double average = 0.0;
        for (double p : population) {
            average += p;
        }
        average /= population.length;

        double variance = 0.0;
        for (double p : population) {
            variance += (p - average) * (p - average);
        }
        return variance / population.length;
    }
}
