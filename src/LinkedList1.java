import java.util.Arrays;
import java.util.List;

class Node{
    int data;
    Node next;
    Node(int data1,Node next1){
        this.data=data1;
        this.next=next1;
    }
    Node(int data1){
        this.data=data1;
        this.next=null;
    }
}
public class LinkedList {
    public static void printLinkedList(Node head){
        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
//    function to convert a array into a linked list
    public static Node convertArrayIntoLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node prev=head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null);
            prev.next=temp;
            prev=temp;
        }
        return head;
    }
    public static Node insetHead(Node head,int val){
        Node temp=new Node(val ,head);
        return temp;
    }
    public static Node insertAtMiddle(Node head,int data,int val){
        Node temp=head;
        while (temp.data!=val){
            temp=temp.next;
        }
        temp.next=new Node(data,temp.next);
        return temp;
    }
//  Question 876 Middle of the Linked List(Striver linked list-01)
    public static Node middleOfLinkedList(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null&& fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }return slow;
    }
//  Question 206 reverse linked list
    public static Node reverseLL(Node head){
        if(head==null|| head.next==null) return head;
        Node newHead=reverseLL(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return head;
    }
//    Function to merge to sorted array
    public static Node mergeTwoSortedLL(Node head1,Node head2){
        if(head1==null) return head1;
        if(head2==null) return head2;
        Node head3;
        if(head1.data<head2.data){
            head3=head1;
            head1=head1.next;
        }else{
            head3=head2;
            head2=head2.next;
        }
        Node t3=head3;
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                t3.next=head1;
                head1=head1.next;
            }else{
                t3.next=head2;
                head2=head2.next;
            }t3=t3.next;
        }
        if(head1!=null) t3.next=head1;
        if(head2!=null) t3.next=head2;
        return head3;
    }
//    Function to find middle of the linked list
    public static Node findMiddle(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }return slow;
    }
//    Function to sort a linked list(Question 148)
    public static Node sortLL(Node head){
        if(head==null||head.next==null) return head;
        Node middle=findMiddle(head);
        Node left=head,right=middle.next;
        middle.next=null;
        left=sortLL(left);
        right=sortLL(right);
        return mergeTwoSortedLL(left,right);
    }
//    function to find length of the loop in a linked list
    public static int lengthOfLoop(Node head){
        Node slow=head,fast=head;
        int count=0;
        while(fast!=null||fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                fast=fast.next;
                count++;
                while(fast!=slow){
                    count++;
                }return count;
            }
        }return count;
    }
//    function to sort a linked list of 0's, 1's and 2's;
    public static Node sortLL012(Node head){
        Node zeroH=new Node(0),oneH=new Node(0),twoH=new Node(0);
        Node zero=zeroH,one=oneH,two=twoH;
        Node temp=head;
        while(temp!=null){
            if (temp.data==0){
                zero.next=temp;
                zero=zero.next;
            } else if (temp.data==1) {
                one.next=temp;
                one=one.next;
            }else{
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }zero.next=(oneH.next!=null)?oneH.next:twoH.next;
        one.next=twoH.next;
        two.next=null;
        return zeroH.next;
    }
//  Function to update node k times
    public static Node updateK(Node temp, int k){
        Node kh=temp;
        k--;
        while(k>0&&kh!=null){
            kh=kh.next;
            k--;
        }
        return kh;
    }
//  Function to reverse nodes in k-groups
    public static Node reverseNodeInK_Groups(Node head, int k){
        Node temp=head;
        Node next=null,prev=null;
        while(temp!=null){
            Node kh=updateK(temp,k);
            if(kh==null){
                if(prev!=null) prev.next=temp;
                break;
            }
            next=kh.next;
            kh.next=null;
            reverseLL(temp);
            if(temp==head){
                head=kh;
            }else{
                prev.next=kh;
            }prev=temp;
            temp=next;
        }
        return head;
    }
// Question(92 LeetCode): Reverse linked list II
    // Function to reverse the portion of linked list
    static Node successor=null;
    public static Node rev(Node head,int n){
        if(n==0){
            successor=head.next;
            return head;
        }
        Node newNode=rev(head.next, n-1);
        head.next.next=head;
        head.next=successor;
        return newNode;
    }
    public static Node revII(Node head,int left,int right){
        int n=right-left;
        if(n==0) return head;
        Node temp=head;
        int i=1;
        while(i<left-1){
            temp=temp.next;
            i++;
        }temp.next=rev(temp.next, n);
        return head;
    }
    public static void main(String[] args) {
//        List<Integer> arr= Arrays.asList(12,8,9,10,4,5);
//        Node head=new Node(arr.get(0));
//        head.next=new Node(arr.get(1));
//        head.next.next=new Node(arr.get(2));
//        head.next.next.next=new Node(arr.get(3));
////        head.next.next.next.next=new Node(arr.get(4));
////      Inserting head
//        head=insetHead(head,arr.get(4));
//        insertAtMiddle(head,arr.get(5),arr.get(2));
        int[] arr1={1,2,3,4,5};
        // int[] arr2={1,2,3,4,5,6,7,8,9,10};
//        Node head1=convertArrayIntoLinkedList(arr1);
        Node head2=convertArrayIntoLinkedList(arr1);
        Node head3 =revII(head2,2,4);
        printLinkedList(head3);
    }
}
