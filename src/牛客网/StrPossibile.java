package 牛客网;

import java.util.*;

/**对于那个可能的情况的问题是怎么构建出所有的情况呢？
 * 对于语言该怎么去实现的、？
 * 1.每个不能重复
 * permutation 排列的意思。
 * */
/*输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
可以使用的是什么东西求出所有的东西。
*/
public class StrPossibile {
    static Random random = new Random();
/**@思路 {@对所有的情况遍历的意思}
 * @第一次  没有相处很好的公式。*/

    public static void main(String[] args) {
       /* Random random = new Random();
        int i = random.nextInt(6)+1;//1-7的生成的数
        System.out.println(i);*/
       String s = "abc";
        permutation(s);
        System.out.println(s);
    }

    public static List<char[]> getall(char[] chars){
        int len = chars.length;
        List<char[]> list = new ArrayList<>();
        char[] middle = new char[len];
        //对于结果的保存的使用的。是什么的情况，需要的是
        for (int i=0; i<len; i++){
            //对于数据的比较，需要加上的是
            for(int index=0; index<len; index++){
                middle[index] = chars[random.nextInt(len)];
                //对于len需要去减的。还有比较。
//                if(!isSame(middle, ))
                i++;
            }
        }
        return null;
    }

    public static boolean isSame(char a, char b){
        if(a==b){
            return true;
        }
        return false;
    }

    public static ArrayList<String> permutation(String str){
        ArrayList<String> list = new ArrayList<>();
        if(str==null||str.length()==0){
            return list;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> tmpRes = new TreeSet<>();
        permutationcore(chars,tmpRes,0);
        list.addAll(tmpRes);
        return list;

    }

    public static  void core(char[] chars, int loc){
        //1.
        for(int i = loc; i<chars.length; i++){
            swap(chars, i, loc);
            //进行的操作。
            //后面有换回里的意思的操作
        }
    }

    private static void permutationcore(char[] chars, TreeSet<String> tmpRes, int loc) {
        /**
         * 固定第一个字符，递归取得首位后面的各种字符串组合；
 *      * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
 *      *递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
         *      duiyu loc+1也是对loc 的低价的过程的，还是有的是第一个后面的所有的字符的东西了，还有的是
         * */
        for(int i = loc; i<chars.length; i++){
            swap(chars,i,loc);//将第一个字符与后面的字符交换  第一个交换玩后再去实现的是有的是
            /**其实这里处理的bc的情况的，不是说对于a的处理了，因为是同一个的操作，才会需要这么写的*/
            permutationcore(chars,tmpRes,loc+1);//对后面所有的字符进行全排列也要很多表的，从loc +1 +2...
            swap(chars,i,loc);//再将之前交换的字符交换回来，以便第一个字符再与其他字符交换
            /*第二个swap用以使得字符数组的顺序回到进入递归前的状态，这样才不会影响外部的遍历顺序。因为在第一次交换后进入递归运算的时候，
                字符数组的顺序改变了，例如“abc”， i = 0时对应‘a’，j = 1时对应 'b'，进行一次交换，此时的字符数组的顺序为 "bac"，
                从递归返回时，顺序依然是“bac”，则进行第二次交换使得 “bac” -> “abc”，这样在后续才可以进行'a'与'c'的交换，不会落下某一种情况。*/
        }

    }

    public static void swap(char[] chars, int i, int j){
        char  temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        //想实现的是对第一次字符放在最后，去实现。
    }

    }


