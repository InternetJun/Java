package 牛客网;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。*/
public class ComposeLink {
    public static void main(String[] args) {

    }

    public static void compose(){

    }
}

class Linklist{
//    Link link;
    List<Link> list = new ArrayList<>();
//    list.add(new Link(2));
//    list.add(new Link(3));
//    list.add(new Link(5));
//    list.add(new Link(4));
//    list.add(new Link(6));
//    Link root = new Link(3);
//    public void add(){
//        for(int i=0; i<list.size(); i++)
//        root.add();
    }

//还需要的是去构造出一个list出来的，这下面只是对link节点的基本的定义，还有的是其他的东西啊!
class Link{
    Link next = null;
    int val;

    public Link(int i) {
        this.val = val;
    }

    public void add(Link link){
        if(this.val>link.val){
            link.next = this;
        }else {
            this.next = link;
        }
    }

    @Override
    public String toString() {
        return "Link{" +
                "val=" + val +
                '}';
    }
}
