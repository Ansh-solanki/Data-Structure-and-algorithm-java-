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
public class BTpractice {

// Creation of Binary tree
    static Node creation(Integer[] arr){
        if(arr.length==0 || arr[0] == null) return null;

        Node root=new Node(arr[0]);
        Queue<Node> q=new java.util.LinkedList<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty() && i<arr.length){
            Node curr=q.poll();
            if(i<arr.length && arr[i]!=null){
                curr.left=new Node(arr[i]);
                q.offer(curr.left);
            }i++;

            if(i<arr.length&& arr[i]!=null){
                curr.right=new Node(arr[i]);
                q.offer(curr.right);
            }i++;
        }
        return root;
    }

//  Inorder traversal
    static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
// Level Order Traversal
    static void  levelorderTraversal(Node root){
        if(root==null) return ;
        Queue<Node> q=new java.util.LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                System.out.println(curr.data+" ");
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }
// Maximum depth of  a binary tree
    static int height(Node root){
        if(root==null) return 0;
        return Math.max(height(root.left), height(root.right))+1;
    }

// Balanced Binary tree
    static boolean isBalanced(Node root){
        if(root==null) return true;
        int left=height(root.left);
        int right=height(root.right);
        if(Math.abs(left-right)>1) return false;
        return (isBalanced(root.left) && isBalanced(root.right));
    }
// Diameter of a binary tree
    static int diameter(Node root){
        if(root==null) return 0;
        int d=height(root.left)+height(root.right);
        int left=diameter(root.left);
        int right=diameter(root.right);
        return Math.max(d,Math.max(left,right));
    }

// Binary Tree Maximum Path Sum
    static int maxPath=Integer.MIN_VALUE;
    static int DFS(Node root){
        if(root==null) return 0;
        int left=Math.max(0,DFS(root.left));
        int right=Math.max(0,DFS(root.right));
        maxPath=Math.max(maxPath,left+right+root.data);
        return root.data+Math.max(left,right);
    }
    static int maxPathSum(Node root){
        DFS(root);
        return maxPath;
    }
    public static void main(String[] args){
        Integer[] arr={9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6};
        Node root=creation(arr);
        System.out.println(maxPathSum(root));
    }
}
