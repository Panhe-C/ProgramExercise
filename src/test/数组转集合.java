package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;


/*
* Arrays.asList()是泛型方法，传入的对象必须是对象数组
* */

public class 数组转集合 {
    public static void main(String[] args) {
        stillArray();

        test();

    }


    /*
    * 当传入一个原生数据类型数组时，Arrays.asList()真正得到的参数不是数组中的元素，而是数组对象本身。list的唯一元素就是这个数组
    * 、
    * 使用集合的add(),remove(),clear()会抛出异常
    * */
    public static void stillArray(){
        int[] myArray = {1,2,3};
        List list = asList(myArray);
        System.out.println(list.size());//1
        System.out.println(list.get(0));//数组地址值
//        System.out.println(list.get(1));//报错


        System.out.println(list.getClass().getName());



        //数组转list
        List list1 = new ArrayList<>(Arrays.asList(myArray));

        //使用stream
        Integer[] arr = {1,2,3};
        List list2 = Arrays.stream(arr).collect(Collectors.toList());
        int[] arr1 = {1,2,3};
        List list3 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
    }

    public static void test(){
        String[] myArray = {"apple","banana","orange"};
        List<String> list = Arrays.asList(myArray);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }

    //将数组转换为ArrayList
    //自己构造方法
    public static <T> List<T> ArrayToList(final T[] array){
        final List<T> l = new ArrayList<T>(array.length);

        for (final T t : array){
            l.add(t);
        }

        return l;
    }


}
