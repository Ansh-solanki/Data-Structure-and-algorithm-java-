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
class el{
    int col;
    Node node;
    el(int col,Node node){
        this.col=col;
        this.node=node;
    }
}
class Nel{
    int row;
    int col;
    Node node;
    Nel(int row,int col,Node node){
        this.row=row;
        this.col=col;
        this.node=node;
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

// Top view of Binary Tree
    static void top(el curr,TreeMap<Integer,Integer> map){
        int col=curr.col;
        Node node=curr.node;
        if(node==null) return;
        if(!map.containsKey(col)){
            map.put(col,node.data);
        }
        top(new el(col-1, node.left),map);
        top(new el(col+1, node.right),map);
    }
    static void topView(Node root){
        if(root==null) return;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        top(new el(0, root),map);
        for(int val:map.values()){
            System.out.print(val+" ");
        }
    }

// Boottom view of a Binary Tree
    static void bottomView(Node root){
        if(root==null) return;
        TreeMap<Integer,ArrayList<int[]>> map=new TreeMap<>();
        Queue<Nel> q=new java.util.LinkedList<>();
        q.offer(new Nel(0, 0, root));
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Nel curr=q.poll();
                Node node=curr.node;
                int col=curr.col;
                int row=curr.row;
                map.putIfAbsent(col, new ArrayList<>());
                if(map.get(col).isEmpty()){
                    map.get(col).add(new int[]{node.data,row});
                }else{
                    if(map.get(col).get(0)[1]==row){
                        map.get(col).add(new int[]{node.data,row});
                    }
                    else{
                        map.get(col).clear();
                        map.get(col).add(new int[]{node.data,row});    
                    }
                }
                if(node.left!=null) q.offer(new Nel(row+1, col-1, node.left));
                if(node.right!=null) q.offer(new Nel(row+1,col+1,node.right));
            }
        }
        for(List<int[]> list:map.values()){
            for(int[] arr:list){
                System.out.print(arr[0]+" ");
            }
        }
    }
    public static void main(String[] args){
        Integer[] arr={1,2,3,4,10,9,11,null,5};
        Node root=creation(arr);
        bottomView(root);
   }
}
