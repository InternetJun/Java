package 牛客网;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

/**给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。*/

//不能动态的完成那个滑动的窗口吧。
public class SlideWindow {
    public static void main(String[] args) {
        int[] arr = {2,3,4,2,6,2,5,1};
        int[] arr_n = getMaxInWindow(arr, 3);
//        System.out.println(Arrays.toString(arr_n));
        for (int i=0;i<arr_n.length;i++){
            System.out.print(arr_n[i]+"\t");
        }
    }
    public static int[] getMaxInWindow(int[] arr, int size){
        //需要的是index去处理的，是可以重复利用的。最后的清除的实现。
        int[] newArr = new int[arr.length-size+1];
        int[] mid = new int[size];
        //z这里也是写死了。。。
//        int t = 0;
//        int index = 0;
        int index1 = 0;
/*难点在于怎么去实现的滑动串口？*/
        for(int i=0; i<arr.length-size+1; i++){
            //表示的在窗口最大的数，可能是很多数之间的比较的时候呢？数组外的没有考虑进去啊。。。。
            for(int index = 0;index<size;index++){
                //在这里的赋值的时候出错了，是动态的赋值的情况。
                mid[index] = arr[i];
                i++;//这里出问题了，对i值的控制
            }
            i -= size;
            //也需要对i的初始化，
/**对于动态的数据数组的保存的时候是需要的初始化数据的！！
 * 今天完成对网页的实现，动态和静态的结合
 * regex的固定的格式是:
 *  String regex = ***;
 *  pattern.compile();
 *  pattern.matcher();这是最后获取的匹配字符床 的东
 * */
            int max = mid[0];
            for(int j=0;j<size;j++){
                max = max>mid[j]?max:mid[j];
                mid[j] = 0;//每比较一次，就出现了清零的情况了。
            }
//            mid =new  int[size];
            //最后是需要初始化的。arr.length-size+1
           if (index1<arr.length-size+1){
                newArr[index1] = max;
            }
             index1++;
        }
        return newArr;
    }
}
