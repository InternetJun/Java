package 牛客网;

public class DoubleLink {
    /**输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
     * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * @Q:怎么去复制节点的问题啊,还有的是怎么间接去实现出各自的剪切的问题.
     * 双节点的不改变的条件是什么？
     * 1. 有的是 a.next =
     *
     * */
    //怎么实现?不能引入?复制的链表怎么间接的拆分?还有的是界定的copy?只要对一个姐节点去实现就好,其他的一样的
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;//这样的表示就是一个指针的意思了,即使java的特性的.
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;//
            currentNode = currentNode.next.next;//这里的表示是老节点的意思,
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        /**自己会怎么实现出这款的逻辑呢/?怎么就有新的和旧的节点呢?对吧*/
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            //就是对数据 的依次的遍历起来的,还有的是说先走谁后走谁很重要的!
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
