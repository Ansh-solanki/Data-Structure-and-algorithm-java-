import java.util.*;
public class DoublyLinkedList {
    static class Node{
        int data;
        Node next;
        Node back;

        Node(int data1,Node back,Node next){
            this.data=data1;
            this.next=next;
            this.back=back;
        }
        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }

    }
//    Function to Convert Array into Doubly linked list
    public static Node convertArrayIntoDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], prev, null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
//    Function to Insert a node at head
    public static Node insertHead(Node head,int val){
        Node temp=new Node(val,null,head);
        head.back=temp;
        head=temp;
        return head;
    }
//    Function to insert node at end
    public static Node insertAtEnd(Node head,int val){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(val,temp,null);
        return head;
    }
//   Function to delete Head node
    public static Node deleteHead(Node head){
        Node temp=head;
        head=head.next;
        temp.next=null;
        head.back=null;
        return head;
    }
//    Function to delete the last Node
    public static Node deleteLastNode(Node head){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }temp.next.back=null;
        temp.next=null;
        return head;
    }
//   Function to reverse doubly linked list
    public static void reverseDLL(Node head){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.back;
        }

    }
//    Function to print linked list
    public static void printLinkedList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
    }
//  Function to delete all occurrences of a key in DLL
    public static Node deleteKey(Node head,int key){
        if (head==null) return null;
        Node temp=head;
        while(temp!=null){
            if (temp.data==key){
                if (temp==head){
                    head=head.next;
                    if(head!=null) head.back=null;
                }else{
                    if(temp.back!=null) temp.back.next=temp.next;
                    if(temp.next!=null) temp.next.back=temp.back;
                }
            }temp=temp.next;
        }return head;
    }
//   Function to find pairs with given sum
    public static  List<List<Integer>> findPairsWithGivenSum(Node head, int target){
        List<List<Integer>> res=new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            Node p=temp;
            if(target>temp.data) {
                int comp=target-temp.data;
                while(p!=null){
                    if(p.data==comp){
                        res.add(Arrays.asList(temp.data,comp));
                    }p=p.next;
                }
            }else break;
            temp=temp.next;
        }return res;
    }
//    Another approach for the same question
public static  List<List<Integer>> findPairsWithGivenSum2(Node head, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Node left = head, right = head;
    while (right.next != null) {
        right = right.next;
    }while (left!=null && left.data<right.data && left!=right && right!=null){
        int sum=left.data+right.data;
        if(sum==target){
            res.add(Arrays.asList(left.data,right.data));
            left=left.next;
            right=right.back;
        }
        else if (sum<target) left=left.next;
        else right=right.back;
    }return res;
}
// Function to remove duplicates form sorted DLL
    public static Node removeDuplicates(Node head){
        Node temp=head.next;
        while(temp!=null){
            if(temp.data==temp.back.data){
                temp.back.next=temp.next;
                if(temp.next!=null) temp.next.back=temp.back;
            }temp=temp.next;
        }return head;
    }

    public static void main(String[] args) {
        int[] arr={1,1,3,3,4,5};
        Node head=convertArrayIntoDLL(arr);
//        head=insertHead(head,0);
//        head=insertAtEnd(head,7);
//        head=deleteHead(head);
//        head=deleteLastNode(head);
//        printLinkedList(head);
//        System.out.println();
//        reverseDLL(head);
        head=removeDuplicates(head);
        printLinkedList(head);
    }
}