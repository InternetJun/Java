package 牛客网;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ropecut {
/**给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 1 1 6 , 1 2 5, 1 3 4, 2 2 4 , 2 3 3,先获取所有的情况,最后利用动态背包 去解决问题.  怎么获取所有的情况?
 *
 * 生成随机数m-n的数
 * * * 　3.获取一个任意范围（n~m）之间的随机整数（int型）
 * * 　　int num = (int)(Math.random()*(m-n+1)+m);
 * * 　　注：一定要大数减去小数
 * */
/**
 *
 * @time Nov/11th{@没有出来对数的拆分出来所有的结果。}
 *
 * */

    public static void main(String[] args) {
        int num = (int)(Math.random()*1+1);
        List<int[]> arrs = getMulti(3,8);
        for(int i=0; i<arrs.size(); i++){
            //得到了所有的内在数组
            int len = arrs.get(i).length;
            for(int j=0; j<len; j++){
                System.out.print(arrs.get(i)[j]+"\t");
            }
            System.out.println();

        }
    }
    public static  List<int[]> getMulti(int m, int n){
//        Random random = new Random();
        //先获取到所有的情况,最后去比较大小
        //
        // ?还是什么思路?t贪心算法的使用, 怎么去表示的问题,
/*只是获取到了一种的情况，还需要去完善*/
        List<int[]> list = new ArrayList<>();
        int[] arr= new int[m];
        for(int i=0; i<m; i++){
            while(n >= 1){
                int num = (int)(Math.random()*n+1);//第一个数的实现, 还要对2个数据处理
                n -= num;
                for(int index=0; index<m; index++){
                    arr[index] = num;

                }
                list.add(arr);//可以把所有的数据都放入在一个list中.
                arr[i] = 0;


            }
        }
        return list;

    }
}
































