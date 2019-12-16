package 牛客网;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsistSum {
    /*HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
    常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
    并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
    连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)*/

    /**
    * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
    * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
    * @(思路是对每一个元素都取出所有的各个位数，在里面去判断有1？ {@+1})
    * */
    public static void main(String[] args) {
        int a = 11;
        char b = (char) a;

//        System.out.println("请输入2个数区间：");
//        Scanner sc = new Scanner(System.in);
//        int start = sc.nextInt();
//        int end = sc.nextInt();
//        List<Integer> list = new ArrayList<>();
//        for(int i=start;i<=end; i++){
//            list.add(i);
//        }
//        int sum = getAll(list);
//        sc.close();
//        System.out.println("在这里面的区间数包含1的个数有"+sum+"个");
    }

    public static int getAll(List<Integer> list){
        //对数字n全部的遍历出来数字，要是有在获取的时候就index+1 没有就不处理。
        int index=0;
        //需要对数据都遍历出来啊,最后对每一个数据进行判断的实现.每一个数的位数的数取出的实现 n是什么情况一直循环?
        int n = 11;
//        while(true){
//            int gewei = n%10;
//            int qita = n/10;
//        }

        return 0;
    }

}
