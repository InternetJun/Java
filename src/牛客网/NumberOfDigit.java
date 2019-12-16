package 牛客网;

import java.util.Scanner;

public class NumberOfDigit {
    //一种思路,还有可以对数字转换位String类型再去实现的问题.最好的办法就是转为string,对于运算容易出现问题.
    public static void main(String[] args) {
        System.out.println(1/10);
        System.out.println("输入一个任意位数的正数");
        Scanner sc = new Scanner(System.in);

        int in = sc.nextInt();
        //定义一个变量存储各个位数之和
        int sum= 0;
        //定义一个变量用来存储中间商的值
        int result = in;
        while(result != 0)
        {
            int num = result % 10;
            result = result / 10;
            sum += num;
        }

        System.out.println(sum);
    }
}
