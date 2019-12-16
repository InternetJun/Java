package 牛客网;

import java.util.List;
public class LinkOfCircle {
    /**给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     * 需要知道的是val和下一个指针.
     * 链表的入口是什么?
     *
     * @question 对
     * @thinking 对于node.val == node1.val?
     * if(flag){
     *
     * }
     * */
    //环的形成是什么呢?首尾是相同的.有{val, point}

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null){
            return null;
        }
        // 1.判断链表中有环  表示的是第一个的的节点的意思。还有需要的是
        ListNode l=pHead,r=pHead;
        boolean flag = false;
        while(r != null && r.next!=null){
            l=l.next;
            r=r.next.next;
            if(l==r){
                flag=true;
                break;
            }
        }
        if(!flag){
            return null;
        }else{
            // 2.得到环中节点的数目,没有找到就是return null 啊，
            int n=1;
            r=r.next;
            while(l!=r){
                r=r.next;
                n++;
            }
            // 3.找到环中的入口节点，不算是第一个？不用出现对l，r的操作吗？
            l=r=pHead;
            for(int i=0;i<n;i++){
                r=r.next;
            }
            while(l!=r){
                l=l.next;
                r=r.next;
            }
            return l;
        }

    }

     public class 链表中环的入口结点 {
        //找到一快一慢指针相遇处的节点，相遇的节点一定是在环中
        public  ListNode meetingNode(ListNode head) {
            if(head==null)
                return null;

            ListNode slow = head.next;
            if(slow==null)
                return null;

            ListNode fast = slow.next;
            while (slow != null && fast != null) {
                if(slow==fast){
                    return fast;
                }
                slow=slow.next;
                fast=fast.next;

                if(fast!=slow){
                    fast=fast.next;
                }
            }
            return null;
        }
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            ListNode meetingNode=meetingNode(pHead);
            if(meetingNode==null)
                return null;
//      得到环中的节点个数
            int nodesInLoop=1;
            ListNode p1=meetingNode;
            while(p1.next!=meetingNode){
                p1=p1.next;
                ++nodesInLoop;
            }
//      移动p1
            p1=pHead;
            for(int i=0;i<nodesInLoop;i++){
                p1=p1.next;
            }
//      移动p1，p2
            ListNode p2=pHead;
            while(p1!=p2){
                p1=p1.next;
                p2=p2.next;
            }
            return p1;
        }
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}








