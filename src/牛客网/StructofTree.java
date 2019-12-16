package 牛客网;

public class StructofTree {
//    输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public boolean HasSubtree(TreeNode1 root1,TreeNode1 root2) {
        /**思路是什么?
         * 需要对小的东西进行查找数据,后比较东西.对树的左右的循环的实现的问题.
         * */
        if(root1 == null || root2 == null){
            return false;
        }else{
//            对数据的一次的遍历出来,还是用的说回溯法.
            return true;
        }
    }

    public boolean search(TreeNode1 node1, TreeNode1 root){
        //对数据的查找函数,要是查到了,返回的?第几个元素?那个位置的确定的东西!有的是知道了位置了,还有左右,就一次次的去比较
        boolean res = false;
       if(node1 != null && root != null){
           if(node1.val == root.val){
               res = search(node1, root);
           }

        }
        return res;
    }

    }

class TreeNode1 {
    int val = 0;
    TreeNode1 left;
    TreeNode1 right;

    public TreeNode1(int val) {
        this.val = val;

    }

}
