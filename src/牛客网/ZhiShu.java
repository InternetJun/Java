package 牛客网;



public class ZhiShu {
/**把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 怎么去求出质数的问题?什么是质数的求解内容啊?
 * {@N=根号N*根号N
 * N的因数除了根号N，其他都是成对存在的，且必定一个大于根号N一个小于根号N
 * 假设N不是质数，有个因数大于根号N（不是N本身）
 * 则N必定有一个与之对应的小于根号N的因数
 * 也就是说，如果2到根号N都没有N的因数，那么对应的根号N到N-1都没有N的因数，N就是个质数
 * 希望能帮到你}
 *
 * */
/*质数的定义是只有自己和1可以被整除的数。  Prime number质数
* 怎么用语言去表示？
* */

/*
* 有的是for(i=1; i<sqrt(n); i++){
*   表示的是他的倍数,首先的是质数.
*  for(int j=i*i; j<n; j+=i){
*   这里的怎么表示出是质数?
* }
* }
* */

//利用逆向思维去处理  逆否命题的使用
public static void main(String[] args) {
    test4(20);
}

    public static void test4(int n){
        long start = System.currentTimeMillis();    //取开始时间
        //素数总和
        int sum = 0;
        //1000万以内的所有素数
        //用数组将1000万以内的数分为两大派系，素数用0代替数值，合数用1代替数值；
        //一开始默认全部为素数，所以值全部为0，等到开始筛选的时候再把为合数的赋值为1
        int num[] = new int[n];
        num[0] = 1;          //由于1规定不是素数，所以要提前用1标值
        //根据埃氏筛法的结论，要得到自然数  N 以内的全部素数，必须把不大于" 二次根号  N "的所有素数的倍数剔除，剩下的就是素数
        /**这是基本的规定!*/
        double prescription = Math.sqrt(n);/**因数都是成对的存在的,还需要去去除 n^2的数去除,其他的就是对质数了.*/
        for (int i = 2; i <= prescription; i++) {
            //开始把所有素数的倍数剔除，剩下的就是素数
            for (int j = i*i; j <= n; j+=i) {//表示的是i的倍数的实现,去除所有的倍数的东西.
                //从i*i开始去除，因为比i*i小的倍数，已经在前面去除过了
                //例如：i=5 这里的就是表现的质数
                //5的2倍（10），3倍（15），在i=2的时候，已经去除过了

                num[j-1] = 1;   //把素数的倍数剔除，也就是赋值为1，不是素数就是合数
            }
        }
        //遍历数组，把值为0的数全部统计出来，得到素数之和
        for (int i = 0; i < num.length; i++) {
            if(num[i]==0)
//                System.out.println(num[i]+"\t");
                sum++;//对于是0数字标记为是素数的意思了。
        }
        System.out.println(n+"以内的素数有"+sum+"个");
        long end = System.currentTimeMillis();
        System.out.println("The time cost is " + (end - start));
        System.out.println("");
    }

}
