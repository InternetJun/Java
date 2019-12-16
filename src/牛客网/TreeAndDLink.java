package 牛客网;
/**@transient 关键字的作用是什么?
 * 将不需要序列化的属性前添加关键字transient,序列化对象的时候,这个属性就不会被序列化。 概念也很好理解,下面使用代码去验证...*/
import test.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 1.先遍历的时候是不行的
 * 2.先去找到所有的遍历,把left 复制一份,node.left = leftNode
 * leftNode.left = node
 * 这样化的话，就很棒了.
 * */
//@RequestMapping
public class TreeAndDLink {
/**对一个双向 的；链表来说有2个节点，需要互相去指向。*/
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        ConvertSub(pRootOfTree.left);
        /**做了几件事
         * 1.初始化给了root节点。
         * 2realhead 是root节点
         * 3.对于需要双向的话，直接复制，
         * 4.重新给head 后去代表指针的意思。
         * */
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
    /*思路是什么嘛>
    * 1.对于这个是需要的要中序遍历的实现.
    * 2.root.left的指针去变相
    * 3.root.right一样的处理.
    * */

    /*public static void main(String[] args) {
        TreeAndDLink p = new TreeAndDLink();
        System.out.println(p.Permutation("abc").toString());
    }

    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList)res;
    }

    public void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i+1, list);
                swap(cs, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
//==================================================================================
    public void LeftchgType(TreeNode root){
        List<Integer> list = new ArrayList<>();

        TreeNode tmp = root;
        while(tmp.left != null || tmp.right != null){//就是空滤嗷嗷嗷叶子节点的问题i=
            //吧一个节点的东西换成2个方向的实现,应该是很简单的的宋熙了,不是吗/?还有要考虑的是叶子节点的问题啊对吧.
            *//*需要另外一个变量去存储他的制指针的!*//*
            if (tmp.left != null){
                tmp.left.left = tmp.left;
            }
            if (tmp.right != null){
                tmp.right.right = tmp.right;
            }
            tmp = tmp.left;

        }
    }

    public void rightchgType(TreeNode root){
        List<Integer> list = new ArrayList<>();

        TreeNode tmp = root;
        while(tmp.left != null || tmp.right != null){//就是空滤嗷嗷嗷叶子节点的问题i=
            //吧一个节点的东西换成2个方向的实现,应该是很简单的的宋熙了,不是吗/?还有要考虑的是叶子节点的问题啊对吧.
            *//*需要另外一个变量去存储他的制指针的!*//*
            if (tmp.left != null){
                tmp.left.left = tmp.left;
            }
            if (tmp.right != null){
                tmp.right.right = tmp.right;
            }
            tmp = tmp.right;

        }
    }*/


}


