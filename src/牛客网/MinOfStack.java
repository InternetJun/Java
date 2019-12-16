package 牛客网;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Stack;

public class MinOfStack {
    /**定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为{@O（1））}
     * 复杂度是说的是只有一个循环的情况.fu
     * 对于时间的负载度是说的有在循环中就运行的时候没有另外的循环了.
     * @Nov/14th  {@不会,不知道题目的意思}
     * 加入辅stack的使用,进行比较
     * */
//    栈的数据的结构是什么?找min一下就找到了?
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        int res = getMin1(stack);
        System.out.println("结果是:"+res);
    }

    public static int getMin(Stack stack){
        //必须要一个stack
        /**1.sort
         * 这样去写没有出现的对stack的循环的,有点问题!
         * */
        int i = (int)stack.peek();
        if (!stack.empty()){
//            return swap();出栈了的情况了.
           int tmp = (int)stack.pop();
           int tmp2 = (int)stack.pop();
           i=swap(tmp, tmp2);
           stack.push(i);

        }
        return i;
    }
//需要对全部栈元素的比较,这样的只是跑上面的2个数据.
    public static int getMin1(Stack stack){
        //必须要一个stack
        /**1.sort
         *
         * */
        int i = (int)stack.peek();
        if (!stack.empty()){
//            return swap();出栈了的情况了.   getMin1(stack);
            int tmp = (int)stack.pop();
            int tmp2 = (int)stack.pop();
            i=swap(tmp, tmp2);
            stack.push(i);

        }
        return i;
    }

    public static int swap(int i, int j){
        return i > j ? j : i;
    }

}
