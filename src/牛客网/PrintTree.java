package 牛客网;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
//对于嵌套的list怎么遍历出来数据呢？还有要使用的东西。
    public static void main(String[] args) {
        Node root = new Node(4);
        Node left1 = new Node(2);
        left1 = root.leftNode;
        Node left11 = new Node(1);
        left11 = left1.leftNode;
        Node left12 = new Node(22);
        left11 = left1.rightNode;
        print(root);
//        System.out.println(Arrays.toString());
    }

    //利用的是queue类去打印出东西,但是该怎么使用?
    public static ArrayList<ArrayList<Integer>> print(Node root) {//去表示的是根节点.
        ArrayList<ArrayList<Integer>> aLists = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList();
        int depth = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> blList = new ArrayList<>();
            int size = queue.size();

            Node node = queue.poll();//弹出当前树节点
            blList.add(node.val);//  输出很多的val的东西.
            //对于树的弹出节点的使用.用stack来存储他的value
            if (node.leftNode != null) {
                queue.offer(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.offer(node.rightNode);
            }

            aLists.add(blList);
            depth++;

        }
        return aLists;


    }
}
 class Node {
     Node leftNode;
     Node rightNode;
     int val;

     public Node(int val) {
         this.val = val;
     }

     @Override
     public String toString() {
         return "Node{" +
                 "val=" + val +
                 '}';
     }
 }

