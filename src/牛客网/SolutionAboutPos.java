package 牛客网;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionAboutPos {
    public static void main(String[] args) {
        SolutionAboutPos p = new SolutionAboutPos();
        System.out.println(p.Permutation("abc").toString());
    }

    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);//0到最后的实现的意思了.
            Collections.sort(res);//进行了排列 的操作 二点,对可读性很好的
        }
        return (ArrayList)res;
    }

    public void PermutationHelper(char[] cs, int i, List<String> list) {
        //这里 的才对数据的重复性质进行登录pan'du
        if (i == cs.length - 1) {//长度是最后一个，添加。
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);//交换字母的意思是什么？
                PermutationHelper(cs, i+1, list);//对最后的一个字母作为比较的意思,要是不相同的就加入进去的意思了!
                /*
                *
                * */
                swap(cs, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

}
