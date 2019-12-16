package 牛客网;

import test.Tree;
/*
*       3
*   5       6
* 7   8  10   9
* */

public class SameDepthOutTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(6);
        TreeNode left2 = new TreeNode(7);
        TreeNode right2 = new TreeNode(8);
        TreeNode left3 = new TreeNode(10);
        TreeNode right4 = new TreeNode(9);
        root.right = right;
        root.left = left;
        left.left = left2;
        left.right = right2;
        right.right = right4;
        right.left = left3;
        System.out.println(root.val);
        out(root);

    }

    public static void out(TreeNode root){
        int depth = 0;//System.out.println(root.val);me有考虑到root的节点的东西！！
//加上分集的东西，更加可观怎么去实现呢>?对的就是这么做 的!!
        int index = 1;
        outInOneNode(root,index);
              if(root.left != null){
            index++;
            outInOneNode(root.left,index);;

        }
        if (root.right != null){
            outInOneNode(root.right,index);;
        }

    }

    private static void outInOneNode(TreeNode node, int depth){
        for(int i=0; i<depth; i++){
            System.out.print("--");
        }
        if(node.left != null){
            System.out.print(node.left.val+"\t");
        }if(node.right != null){
            System.out.print(node.right.val+"\n");
        }
//        System.out.println();
    }
}
