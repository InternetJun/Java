package 牛客网;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶结点所经过的结点形成一条路径。
 * qianxu :中 左右
 * 中序 左中有
 * 后续 左右中
 * 对于路他的要求是什么?需要的是?
 * 还有的是说的是怎么保证出从根节点开始遍历的?对对于经过的jie'din怎么保证在路径中？
 *
 *if(val1=val2){
 *     list.add();
 *}else{
 *     遍历去操作method,都是对粒化的元素的操作.
 *}
 * 3中情况
 * 1. l.null r.null
 * 2. !null-->输入提示
 * 3.
 *
 * */
import java.util.Stack;

/**
 * @author Lejun
 * @data Nov/26
 * 2015年8月5日他的思想是什么?对于这样的操作问题.还有的是
 * 对于值相同的时候添加路径进去吗?
 */

public class E25PathInTree {
    public void findPath(TreeNode root,int k){
        if(root == null)
            return;
        Stack<Integer> stack = new Stack<Integer>();//用一个stack的处理了.
        findPath(root,k,stack);
    }

    public void findPath(TreeNode root,int k,Stack<Integer> path){
        //对于值相同的就出树,不是说那么复杂的思想
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(root.val == k){//是需要的是值要一样的时候才可以输出，要不然是不需要的。
                System.out.println("路径开始");
                for(int i :path)
                    System.out.print(i+",");//先进后出的是新了.可以对树很好的估计了.很棒的思路
                System.out.print(root.val);//这是自己的节点的值,最后的输出
            }
        }
        else{
            //有先进后出的实现,就是栈的知识了.怎么就想不到呢,对吧 ,不相同的话.项进的是root.val
            path.push(root.val);
            findPath(root.left,k-root.val,path);
            findPath(root.right,k-root.val,path);
//            path.pop();
        }
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode();
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();
        TreeNode node6 = new TreeNode();
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        root1.val = 8;
        node1.val = 8;
        node2.val = 7;
        node3.val = 9;
        node4.val = 2;
        node5.val = 4;
        node6.val = 7;
        E25PathInTree test = new E25PathInTree();
        test.findPath(root1, 25);
    }
}
