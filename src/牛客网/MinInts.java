package 牛客网;

import java.util.ArrayList;
import java.util.List;

public class MinInts {
/*输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。我想思考找出最小的元素呢？min取出*/
    public static List<Integer> getMins(List<Integer> arr, int k){//对数字进行排序后取出数据。
        //关键的问题是找几个最小的数，需要遍历的实现出对最小的数的弹出的问题。更新好list的元素。动态的删除
        int len = arr.size();
//        List<Integer> list = new ArrayList<>()
        int[] arrmin = new int[k];
        int index=0;
        for(int i=0; i<len; i++){
            int min = arr.get(0);//考虑一中极端的情况，他就是最小的数呢？对吧，
            min = arr.get(i)>min?min:arr.get(i);
            arrmin[index] = min;//只是对一个数据的加入，需要对数据的动态的生成。


//            index++;
        }
        return null;
    }
}
