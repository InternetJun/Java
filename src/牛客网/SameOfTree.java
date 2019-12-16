package 牛客网;

import test.Tree;

import java.net.BindException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameOfTree {
    /**输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)每一个有2个路径的,所有要*2的,哟lsit保存
     * 什么的意思?有2个节点 啊怎么去表示出
     * @11/20 题目都不懂.
     *      2
     *  1       5
     * 1  4   1     5
     * 需要一个函数
     * silu shi 没有错的,需要去完善一下的意思.
     *
     * */
    public static void main(String[] args) {
        //对数据的测试问题.
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        TreeNode root4 = new TreeNode(2);
        root.left = root2;
        root.right = root4;
        root1.left = root1;
        List<TreeNode> list = new ArrayList<>();
        List<int[]> listArrs = new ArrayList<>();
        list = getAllVal(root);
        listArrs = Compare(4, list);
        for (int i=0; i<listArrs.size();i++){
            System.out.println(Arrays.toString(listArrs.get(i)));//没有进来数据

        }
    }

    //对数据的比较后,添加
    public static List<int[]> Compare(int val, List<TreeNode> list){
        int[] tmp = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            tmp[i] = list.get(i).val;
        }
        //比较数据的时候象加
        List<int[]> listArrs = new ArrayList<>();
        int[] cunchu = new  int[2];
        while(val > 0){
            for(int ind = 0; ind<list.size(); ind++){
                /**zhli 出错了,不是这样 */
                val -= tmp[ind];//对数据的减去的时候寻找其他的数据
                cunchu[0] = tmp[ind];
                tmp[ind] = 0;
//                tmp = tmp//需要的是在剩下 的所有中有没有其他的元素
                //动态 的规划的问题 了不知道是谁啊,需要知道的事情.
                for(int index = 0; ind<list.size(); index++) {
                    if (val == tmp[index]) {
                        cunchu[1] = tmp[index];
                    } else {
                        cunchu[0] = 0;
                        cunchu[1] = 0;
                    }
                }
            }
            listArrs.add(cunchu);
        }
        return listArrs;
    }

    //对值的获取
    public static List<TreeNode> getAllVal(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        if (root != null){
            list.add(root);

        }  if (root.left != null){
            return getAllVal(root.left);

        }  if (root.right != null){
            return getAllVal(root.right);

        }
        return list;
    }
}


