package 牛客网;

import test.conTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChgPos {
    //实现的是对数组中的奇数和偶数。是一个动态的数组，需要确定指针的位置。关键的地方在于怎么确定那个index的位置呢？

    /**
     * 关键的地方是什么、？一次的利用？
     * 他的思路是对于数据的重新的排列问题，不是说的什么，
     * 1.从前往后遍历，第一个元素如果是偶数，记住这个偶数的角标位。如果不是偶数，啥也不干。
     * <p>
     * 2.当遇到偶数的时候，判断这是不是第一个偶数，如果是 记住角标位。
     * <p>
     * 3.当遇到奇数的时候，判断其前面有没有偶数，如果有，则将前面的连续的多个偶数，顺序往后移动一位，然后将奇数插入第一个偶数位置。
     */
    public static void main(String[] args) {
        int[] arrs = {1, 2, 4, 5, 6, 7, 8, 9};
        reOrderArray2(arrs);
        System.out.println("变换后的数据：");
        System.out.println(Arrays.toString(arrs));
    }

    public static void reOrderArray2(int[] array) {
        int i = 0;
        int j = array.length;
        int index = -1;
        if (array.length == 0) {  //数组为空，啥也不干！
            return;
        }
        while (i < j) {
            if ((array[i] & 1) == 1) {//&是按位与，是转换为2进制码后去实现的！对于奇数是这么做的！
                if (index >= 0) {
                    //和index位置元素交换
                    int ss = array[i];
                    for (int in = i; in > index; in--)
                        array[in] = array[in - 1];//后移一位的操作。需要的是什么？
                    array[index] = ss;
                    index++;
                }
                i++;
                continue;
            } else {
                //这里很关键，需要记住从左边开始的第一个偶数的位置，如果第一个元素就是偶数，这个临界值一定要考虑到。
                //如果第一个元素不是偶数，那当遍历到第一个偶数的时候，开始记住其角标。
                if (i == 0)
                    index = 0;
                if (index < 0)
                    index = i;//不能变的，
                i++;
                continue;
            }
        }

//    public void getRealPos(int[] arrs){
//        int index = 0;
//        List<Integer> list = new ArrayList<>();
//        for(int i=0; i<arrs.length; i++){
//            if(arrs[i]%2==0){
//                list.add(arrs[i]);
//                final int tmp = i;//要记录的是第一个的位置，不是说全部的记录下来的!!
//            }
//
//            if(arrs[i]%2!=0){
//                //判断前面的数据有没有偶数，
//
//            }
//        }
//
//
//    }
    }
}
