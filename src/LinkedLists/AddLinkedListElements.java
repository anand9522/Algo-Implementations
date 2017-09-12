package LinkedLists;

import java.util.LinkedList;

/**
 * Created by anand on 12/09/17.
 */
public class AddLinkedListElements {
    private static class LLNode<T>{
        T data;
        LLNode next;
        public LLNode(T data,LLNode next){
            this.data=data;
            this.next=next;
        }

    }
    LLNode<Integer> getSumOfLists(LLNode<Integer> A, LLNode<Integer> B){
        LLNode<Integer> dummyHead=new LLNode<>(0,null);
        LLNode<Integer> currentNode=dummyHead;
        int carry=0;
        while (A!=null && B!=null){
            int sum=A.data+B.data+carry;
            carry=0;
            currentNode.next=new LLNode(sum%10,null);
            currentNode=currentNode.next;
            if (sum>9){
                carry=1;
            }
        }

        while (A!=null){
            int sum=A.data+carry;
            carry=0;
            currentNode.next=new LLNode(sum%10,null);
            currentNode=currentNode.next;
            if (sum>9){
                carry=1;
            }
        }

        while (B!=null){
            int sum=B.data+carry;
            carry=0;
            currentNode.next=new LLNode(sum%10,null);
            currentNode=currentNode.next;
            if (sum>9){
                carry=1;
            }
        }
        return dummyHead;
    }
}
