package 牛客网;

import java.util.List;
import java.util.Stack;

/**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
     * （注意：这两个序列的长度是相等的）
 *
 * @最好的思路是: 对stack的栈顶的pop的使用,还有判断的实现.    * */
public class StackOfTwoList {

    static Stack stack= new Stack();

    public static void main(String[] args) {
        stack.push(1);
        stack.push(3);
        stack.push(2);
        while (!stack.empty()){

            System.out.println(stack.pop());//pop就是输出数字.没有说输出的意思.
        }
    }

    public static boolean isEqual(int[] list, int list1){
        for(int i=0; i<list.length; i++){
            stack.push(list[i]);
        }
        //对每个的输出的数字进行比较.有什么好的比较方法吗?
        return false;
    }
}
