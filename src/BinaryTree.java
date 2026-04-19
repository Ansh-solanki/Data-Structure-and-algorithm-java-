import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class BinaryTree {
// Question(102:LeetCode): Binary tree level order traversal
    // public static List<List<Integer>> levelorderTraversal(Node root){
    //     List<List<Integer>> list=new ArrayList<>();
    //     if(root==null) return list;
    //     Queue<Node> q=new LinkedList<>();
    //     q.add(root);
    //     while(!q.isEmpty()){
    //         int size=q.size();
    //         List<Integer> l=new ArrayList<>();
    //         for(int i=0;i<size;i++){
    //             Node curr=q.poll();
    //             l.add(curr.data);
    //             if(curr.left!=null) q.add(curr.left);
    //             if(curr.right!=null) q.add(curr.right);
    //         }list.add(l);
    //     }return list;
    // }
//  Inorder 
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
//  Serialization and deserialization
    public static Node construct(int[]inorder,int[] preorder,Map<Integer,Integer> map,int pre,int start ,int end){
        if(start>end) return null;
        int val=preorder[pre++];
        Node root=new Node(val);
        int mid=map.get(val);
        root.left=construct(inorder, preorder,map, pre, start,mid-1);
        root.right=construct(inorder, preorder, map, pre, mid+1, end);
        return root;
    }
    public static Node buildTree(int[] inorder,int[] preorder){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }return construct(inorder,preorder,map,0,0,inorder.length-1);
    }
// Insertion in binary tree
    public static Node creation(Node root){
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        if(data==-1) return root;
        root=new Node(data);
        root.left=creation(root.left);
        root.right=creation(root.right);
        return root;
    }
    public static void main(String[] args){
        Node root=null;
        root=creation(root);
        inorder(root);
    }
}
