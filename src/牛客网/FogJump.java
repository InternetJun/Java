package 牛客网;

import org.junit.Test;

import java.util.*;


public class FogJump {




    public class A{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
//1作为入 2作为出的实现
    public void push(int node) {
        int a2 = stack2.pop();
        stack1.push(a2);
    }

    public int pop() {
      return 0;

    }

}
//对于1 2 总共是n,求解法的总数  一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
//    在内部类中需要的是static的使用的
public static class fog{
    public static void main(String[] args) {
        int s = JumpFloor(4);
        System.out.println(s);
    }
    //这是一个递归的过程,
    public static int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }

        if(target ==2){
            return 2;
        }

        return JumpFloor(target-1)+JumpFloor(target-2);

    }
}
//可以挑任意的阶数的青蛙.问一共几种的可能.n阶的可能是1---n的阶数可能.
//    分析是对情况的讨论的。数学分析的菲波齐纳
public static class Abnormalfog{
    public static void main(String[] args) {
        int s = JumpFloor(5);
        System.out.println(s);
    }
    public static int JumpFloor(int target) {
        if(target<1){
            return 0;
        }
        if(target ==1){
            return 1;
        }
        if(target ==2){
            return 2;
        }
        return 2*JumpFloor(target-1);
    }
}
//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    public static class rect{
//    @Test
        public static int getsoulution(int n){
            if(n==1){
                return 1;
            }
            if(n==2){
                return 2;
            }
            return getsoulution(n-1)+getsoulution(n-2);
        }
    }

//1+2+3+...+n,不使用* & / 用条件的语句的使用 while case a:b?:....
    public static class Solution1 {
        public static void main(String[] args) {
        int sum = Sum_Solution(4);
        System.out.println(sum);
        }
        public static int Sum_Solution(int n) {
            boolean UselessFlag = n!=0 && (n += Sum_Solution(n-1))!=0;//到1的时候是停止计算的实现的意思
            return n;//满足了条件才会去执行的意思了.对数据满足条件并去实行的语句.很漂亮的语句啊.

        }
    }
/**请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 *     模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *     在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *     不是很懂那个意思是什么,不知改怎么去处理他.
 *     */
     public static class match{
         public static boolean matchstr(String string){

             return false;
      }

}
    public static class Robot {
        public static void main(String[] args) {

        }
         public static int movingCount(int threshold, int rows, int cols)
        {
            int num1 = 0;
            int meddile1 = rows/10;
            int meddile2 = cols/10;
            while(meddile1 != 0){
                int gewei = rows%10;
                num1 +=gewei;
                rows = rows-gewei;
            }
            return 0;
//          动态的数组  利用一个数组来接受计算得到的值,对数据的转换?
//            s = ;//代表的是对数据的个位数之和的实现,但是需要怎么表达任位数字呢?
        }
    }

}
