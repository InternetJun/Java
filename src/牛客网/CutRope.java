package 牛客网;



public class CutRope {
    //解法1.动态规划 2.

/**还有质数sqrt（n）？因为的是n^2的情况 出现，
 * 质数的判断有<sqrt(n) <,>2中情况，
 * 对于树都是成对的存在的。有一个小于的，必有一个是大于的，所有对于sqrt（n）据可以了。
 * 贪心算法，还有回溯？
 * 1.慢慢求解出来， 动态
 * 他的意思用的是前一状态推出下一个状态。
 *思路是什么？
 * */
public static void main(String[] args) {
    int max = test(8);
    System.out.println(max);
}

    public static int test(int target){
        if (target < 2) {
            return 0;
        }
        if (target == 2) {//1 1 0
            return 1;
        }
        if (target == 3) {//1 2 0
            return 2;
        }
        //动态的情况问题。只有1,开始的情况。
        int[] products = new int[target + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i <= target; i++) {
            int max = 0;
/**对于这样的取值才能保障的是对集合内的数据都有效,要不然会出现问题的. */
            for (int j = 1; j <= i / 2; j++) {//为什么是i/2，对于一半的数字呢？j=1，j<=target因为有的是i和n-i的情况。
                int product = products[j] * products[i - j];//就是求出所有的乘积的操作。是对称的？，对于不是说3段的吗。怎么
                max = Math.max(max, product);
            }
            products[i] = max;
        }
        return products[target];
    }

    /**用的是数学分析，对于这样的算法没有max==3
     * 2.greedy algorithm 贪婪算法。
     *thinking是对数据中3的个数尽量的多。用的是数学的知识。
     * */
    public static int test2(int target){
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        // 尽可能多地减去长度为3的绳子段
        int timesOf3 = target / 3;
        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。
        // 此时更好的方法是把绳子剪成长度为2的两段，因为2*2 > 3*1。
        if (target - timesOf3 * 3 == 1) {
            timesOf3--;//xuyao d shi 对2*2不会说3*1的情况的意思了。还有的是说对问题进行数学建模，对问题进行分析，写出程序。
        }
        int timesOf2 = (target - timesOf3 * 3) / 2;
        int result = (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
        return result;
    }



}