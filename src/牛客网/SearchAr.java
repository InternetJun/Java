package 牛客网;

//import static jdk.nashorn.internal.objects.NativeString.search;

import java.util.ArrayList;
import java.util.List;

public class SearchAr {
    /*数组中有一个数字出现的次数超过数组长度的一半，
    请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0*/
    public static void main(String[] args) {
        int[] arr = {1,3,3,3,3,3,5,4,2};
//        int len = arr.length;
        int res = search( arr);
        if(res !=0){
            System.out.printf("有数字%d出现的次数过多了。需要注意一下"+"\t",res);//是数组内的数字不是自己制定的。
        }else{
            System.out.printf("不存在！！%d \t",res);
        }
    }
    public static int search( int[] arr) {
        //是需要统计出所有的数字出现的次数，不是说具体某一个的意思了。
        int index=0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int des = arr[i];//保存的是动态的数据,后面也是对数据的循环,不是这么表述的
            for(int j=0; j<arr.length; j++) {
                if (arr[j] == des) {
                    index++;
                    if (index > arr.length / 2) {
                        list.add(des);
                        return des;

                    }
                }
            }
        }
            index = 0;
            return 0;

    }


}