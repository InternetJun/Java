package 牛客网;
/**他的逻辑是什么？对字符e 的判读，是
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 需要去复习的是怎么表示质数.?
 * @time Nov、12th
 * @first 不知道什么的思路。
 * 满足条件的不是数。逆否命题的使用。
 * 什么的情况是满足的呢?还有的是说.
 * 还是有问题 的逻辑,不是很清楚该去什么的思维问题了.
 * 还是需要大牛来引导我的意思了。
 * 正负号的表示？全部的字符？
 * 对于多个小数点的判断.isDigit
 *
 *
 * @12/2 char的表示是ascii码?
 * */
public class IsDigital {
    //Q:怎么样的通用的形式表示的是一个数字的字符串呢?
    //有什么的属性?
    /*1.小数  字符.只能出现一次，必须在对的位置
    * 2.整数
    * 3.负数  只有-号，
    * 4.指数  对于后面必须要加上数据。（-1,1）
    *
    * 逆否命题有。+-
    * 对于数字的判断有点难受.
    * */

    public static void main(String[] args) {
        //类型只有相等。不是说的是equals();你首先知道的是不能取什么要什么的效果啊。
//        char[] chars = {'1a3.14'};
    }

    public boolean isNumeric(char[] str) {
        // 如果这个数使用科学计数法表示，将数字分成两部分判断
        int posE = -1;
/**
 java中负数是用补码表示的，非负数用原码表示
 -1这个数的补码我算给你看
 补码=绝对值的原码的反码+1
 -1的绝对值是1，其原码是：
 0000 0000 0000 0000 0000 0000 0000 0001
 其反码是：
 1111 1111 1111 1111 1111 1111 1111 1110
 再加1得
 1111 1111 1111 1111 1111 1111 1111 1111
 也就是说32个1就是-1 */
        if (contains(str, 'E') || contains(str, 'e')) {
            for (int i = 0; i < str.length; i++) {
                if (str[i] == 'E' || str[i] == 'e') {
                    posE = i;//记录位置
                    break;
                }
            }
            // 如果 'E' || 'e'在开始与结尾的位置，说明错误
            if (posE == 0 || posE == str.length - 1) {
                return false;
            }
//对于pose的位置问题了,需要的是什么?
            char[] left = new char[posE];
            char[] right = new char[str.length - posE - 1];
            left = subChars(str, 0, posE);//切割字符的作用.左边,还有右边.
            right = subChars(str, posE + 1, str.length);
            // left判断与非科学计数法一样

            // right判断必须为整数
            if (starWith(right, '-') || starWith(right, '+')) {
                right = subChars(right, 1, right.length);
            }
            return isDecimal(left) && isDigit(right);
        } else {
            return isDecimal(str);
        }
    }
//截取字符串的东西.method.
    private char[] subChars(char[] str, int startIndex, int endIndex) {
        char[] ret = new char[endIndex - startIndex];
        for (int i = startIndex; i < endIndex; i++) {
            ret[i - startIndex] = str[i];
        }
        return ret;//截取字符串的东西吗？

    }
//开头的字符是什么意思 method
    public boolean starWith(char[] str, char ch) {
        if (str[0] == ch)
            return true;
        return false;
    }
//合法数值
    public boolean isDecimal(char[] str) {
        //判断是否是一个小数的函数
        if (starWith(str, '-') || starWith(str, '+')) {
            str = subChars(str, 1, str.length);//就是说不管是+或者是-的意思。
        }
        if (contains(str, '.')) {// 如果是小数
            int posE = -1;
            for (int i = 0; i < str.length; i++) {
                if (str[i] == '.') {
                    posE = i;
                    break;
                }
            }
            if (posE == 0 || posE == str.length - 1) {
                return true;
            }
            char[] left = new char[posE];
            char[] right = new char[str.length - posE - 1];
            left = subChars(str, 0, posE);
            right = subChars(str, posE + 1, str.length);//小数的情况是要的是不能有2个小输掉的情况。值去判断一个的情况，
            return isDigit(left) && isDigit(right);

        } else {// 如果不是小数
            return isDigit(str);
        }
    }
//数字？
    public boolean isDigit(char[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] < '0' || num[i] > '9') {//表示的是????
                return false;
            }
        }
        return true;
    }
//包含？
    public boolean contains(char[] str, char ch) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ch) {
                return true;
            }
        }
        return false;
    }






}
