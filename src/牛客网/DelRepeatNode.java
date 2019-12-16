package 牛客网;

import java.util.List;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 重复的数据怎么去计算呢?主要的逻辑是?
 *
 *
 * */
/**
 *
 * if(node.next != node){
 *     需要知道第一个的标记是多少的意思啊.要不然指针不知道指向哪里的!
 *     int flag = -1;用什么来去标记那个后面的值呢?很多的数啊.怎么
 *
 * }
 * 怎么确定的是初始的点的情况  的问题.
 * nan'dnan'diode temp= head.next;
 * int val;
 * while(node.value == temp.value){
 *     temp = temp.next;
 * }
 * if(tmp != val){
 *     tmp.next =
 * }
 * */
public class DelRepeatNode {
    /*
  public class ListNode {
     int val;
     ListNode next = null;
     ListNode(int val) {
         this.val = val;
     }
 }
 */
    public static void main(String[] args) {

    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        //如果没有元素或者只有一个元素则可以直接返回,也就是迭代结束的标志
        if(pHead==null||pHead.next==null)
        {
            return pHead;
        }
        //迭代过程中处理重复的内容，然后继续迭代，参数是删除重复后的后一个节点
        //首先判断是否有重复
        if(pHead.val==pHead.next.val)
        {
            //有重复的话一直判断，是否有连续多个相同的重复
            ListNode node=pHead.next;
            //将所有重复的点忽略，直接连接到没有重复的点，也就是node
            while(node!=null&&node.val==pHead.val)
            {
                node=node.next;
        }
            //在循环当中，一直在调用node.next所以，再次迭代中的参数就是已经删除重复的指针
            return deleteDuplication(node);
        }else
        {
            //zhehi 对于有重复的时候/要是没有的胡直接去实现所有的就好了.
           //如果没有重复的数字，那么我就让pHead的下一个节点继续迭代.
            //指向去除重复的下一个节点
            //值得注意的是，题目中说返回链表的头指针，那么如何实现呢？
            //第一次执行的时候pHead确实是链表的头指针，但是以后的迭代过程中就不是了
            pHead.next=deleteDuplication(pHead.next);
            return pHead;
        }
    }


}

