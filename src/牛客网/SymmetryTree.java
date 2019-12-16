package 牛客网;

//程序都是粒度的,考虑其中一个就好了.

import test.Node;
import test.Tree;
import test.conTree;

public class SymmetryTree {
    //判断是否是对称的树.镜像相同.
    /**关键在于镜像的树怎么表示?
     * 镜像的怎么去表示呢?也是需要的算法是?
     * 有的是怎吗写
     * 对称的东西，怎么表示呢？
     * */
    public static void main(String[] args) {
        int[] arr = new int[]{6,4,8,5,9,10};
        conTree con = new conTree();

        for (int i=0; i<arr.length; i++){
            con.add(new test.Node(arr[i]));
        }
        con.infixOrder();//一颗普通的树了，需要对左右的节点怎么去判断呢?用的还是依次的递归的实现问题了。对root进行判定，最后对

    }
    /*用的是遍历*/
    public void Mirror(TreeNode root){
//        判断出是否是一个对称的树？变换的函数实现思想是没有错的
        if(root == null){
            return;
        }else {
            //什么的调价是终止？对于子节点是空的情况
            change(root);//hui 依次的遍历
            if (root.left != null){
                change(root.left);
            } if (root.right != null){
                change(root.right);
            }
        }
    }

    public void change(TreeNode root){
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

    }




}

