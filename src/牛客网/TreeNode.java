package 牛客网;


import design.Transfer;
/**jdk 1.5的实现。
 * 　　add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * 　　remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
 * 　　element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
 * 　　offer       添加一个元素并返回true       如果队列已满，则返回false
 * 　　poll         移除并返问队列头部的元素    如果队列为空，则返回null
 * 　　peek       返回队列头部的元素             如果队列为空，则返回null
 * 　　put         添加一个元素                      如果队列满，则阻塞
 * 　　take        移除并返回队列头部的元素     如果队列为空，则阻塞
 * */

import java.util.*;

/*对于队列的不熟悉，不知道怎么去实现，怎么去队列？
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 自己没有实现出怎么去添加节点呢！@{2019/11/18}
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {

    }
    public List<Integer> infixOrder(){
        List<Integer> list = new ArrayList<>();
        if(this.left == null){
        }else{
            list.add(this.left.val);
            this.left.infixOrder();
        }
        list.add(this.val);
        if(this.left == null){

        }else{
            list.add(this.right.val);
            this.right.infixOrder();
        }
        return list;
    }
}

/**
 * poll()
 * offer()
 *
 * */
//层次遍历的思想
class Print {

//    构建出了一个树了
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> aLists=new ArrayList<>();
        //如果根节点不存在，则返回null
        if (pRoot==null) {
            return aLists;
        }/** {@Queue}的使用是什么?他的使用是偏少的,今天的{@任务}*/
        //层次遍历,队列
        Queue<TreeNode> queue=new LinkedList<>();//这是一个有指针的link的list.
        Stack<TreeNode> stack=new Stack<>();
        int depth=1;//默认根为第一层，为单层
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> blList=new ArrayList<>();
            if (depth%2==0) {//层数为双
                int size=queue.size();
                //下面的都是对数据的存入stack中去实现的是倒序的输出的意思.queue的是什么？怎么使用？还有说的是
                for (int i = 0; i < size; i++) {
                    TreeNode node=queue.poll();//弹出当前树节点
                    stack.push(node);  //对于树的弹出节点的使用.用stack来存储他的value
                    if (i==size-1) {//栈的队列的判断是什么？还有的是说i==size-1;
                        while (!stack.empty()) {//栈判断为空的条件和队列判断为空的条件是不一样的，
                            blList.add(stack.pop().val);
                        }
                    }
                    if (node.left!=null) {
                        queue.offer(node.left);
                    }
                    if (node.right!=null) {
                        queue.offer(node.right);
                    }

                }
            }else {//层数为单
                int size=queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node=queue.poll();//弹出当前树节点
                    blList.add(node.val);
                    if (node.left!=null) {
                        queue.offer(node.left);
                    }
                    if (node.right!=null) {
                        queue.offer(node.right);//删除节点的意思.有不同的就是说
                    }
                }
            }

            aLists.add(blList);
            depth++;
        }
        return aLists;
    }
/**问题在于怎么去实现的问题啊。*/
    public static void printSameLevel(TreeNode pRoot){
        //实现的是对数据的同一层的左-->右的输出,
        if(pRoot==null){
            return ;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();//作用是是什么?可以切出来?
        //条件是什么会停止  树的左右段的是什么的情况?会有什么的联系?
        queue.offer(pRoot);
//        System.out.println(queue.poll());
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();//是检索,不会删除的.这里是把所有的数据都加入进去 了，需要的不同是对数字的分层啊。
                if (i!=0){

                    System.out.print(node.val+"\t");
                }else {
                    System.out.println(node.val);
                }

                if (node.left!=null) {
                    queue.offer(node.left);//是删除.继续去检索的意思。不是说的是。
                }
                if (node.right!=null) {
                    queue.offer(node.right);//删除节点的意思.有不同的就是说
                }
            }
            depth++;
        }
    }

    public static ArrayList<ArrayList<Integer>> printO(TreeNode pRoot){
        Queue<TreeNode> queue=new LinkedList<>();//这是一个有指针的link的list.
        ArrayList<Integer> blList=new ArrayList<>();
        ArrayList<ArrayList<Integer>> aLists=new ArrayList<>();
        int depth = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();//弹出当前树节点，就是移除的意思了。添加到其他的队列中去。
                blList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);//删除节点的意思.有不同的就是说
                }
            }
            depth++;
            aLists.add(blList);
        }
        return aLists;

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> aLists=new ArrayList<>();

        TreeNode root = new TreeNode(7);
        TreeNode left1 = new TreeNode(6);
        root.left = left1;
        TreeNode right1= new TreeNode(8);
        TreeNode right12= new TreeNode(9);
        TreeNode right11= new TreeNode(5);
        right1.right = right12;
        right1.left = right11;
        root.right = right1;

        aLists = printO(root);//需要的是2层的遍历的实现的。因为是list中嵌套着小的list
        for(int i=0; i<aLists.size(); i++){
            for(int j=0; j<aLists.get(i).size(); j++){
                System.out.print(aLists.get(i).get(j)+"\t");
            }
        }

    }

}

