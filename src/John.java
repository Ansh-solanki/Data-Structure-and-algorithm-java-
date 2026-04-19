import java.util.*;
import java.util.LinkedList;

import javax.management.ListenerNotFoundException;
public class John {
    static class Qel{
        int val;
        int i;
        int j;
        public Qel(int val,int i,int j){
            this.val=val;
            this.i=i;
            this.j=j;
        }
    }
    static class Node{
        String data;
        Node next;
        public Node(String data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    static class El{
        boolean t;
        boolean b;
        boolean l;
        boolean r;
        public El(boolean t, boolean b, boolean l,boolean r){
            this.t=t;
            this.b=b;
            this.l=l;
            this.r=r;
        }
    }
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static void print(Node head){
        if(head==null){
            System.out.println("Null");
            return;
        }Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    // Question 1
    // static Node delEven(Node head){
    //     if(head==null) return head;
    //     while(head.data%2==0){
    //         head=head.next;
    //         if(head==null) return head;
    //     }Node temp=head;
    //     while(temp!=null&&temp.next!=null){
    //         if(temp.next.data%2==0){
    //             temp.next=temp.next.next;
    //         }if(temp.next!=null){
    //             if(temp.next.data%2!=0) temp=temp.next;
    //         }
    //     }return head;
    // }

    // Question 2;
    static Node Question2(Node head){
        Node temp=head;
        while(temp!=null ){
            if(temp.data.equals("1")){
                Node el=temp;
                int count=0;
                while(el!=null && el.data.equals("1")){
                    count++;
                    el=el.next;
                }temp.data=Integer.toString(count);
                temp.next=el;
            }temp=temp.next;
        }
        return head;
    }
    // Question 3;
    static int maxSum=Integer.MIN_VALUE;
    static boolean flag=true;
    static int Question3(TreeNode root,int sum){
        if(root==null) return 0;
        if(flag==true) sum+=root.data;
        flag=!flag;    
        int left=Question3(root.left,sum);
        int right=Question3(root.right, sum);
        maxSum=Math.max(maxSum,sum);
        return maxSum;
    }
    static void print(List<int[]> list){
        for(int[] arr: list){
            System.out.println(arr[0]+", " +arr[1]);
        }
    }
    static void mazeSolve(El[][] maze,List<int[]> list,boolean[][] visit, int i,int j,int n){
        if(i==n-1 && j==n-1){
            list.add(new int[]{i,j});
            print(list);
            return;
        }
        if(i<0 || j<0 || i>=n || j>=n || visit[i][j]) return;
        list.add(new int[]{i,j});
        visit[i][j]=true;
        if(maze[i][j].t) mazeSolve(maze, list, visit, i-1, j, n);
        if(maze[i][j].b) mazeSolve(maze, list, visit, i+1, j, n);
        if(maze[i][j].l) mazeSolve(maze, list, visit, i, j-1, n);
        if(maze[i][j].r) mazeSolve(maze, list, visit, i, j+1, n);
        visit[i][j]=false;
    }
    
    static int gold(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            dp[i][m-1]=grid[i][m-1];
        }for(int j=m-2;j>=0;j--){
            for(int i=0;i<n;i++){
                if(i==0) dp[i][j]=grid[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                else if(i==n-1) dp[i][j]=grid[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                else dp[i][j]=grid[i][j] + Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]));
            }
        }int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max, dp[i][0]);
        }return max;
        
    }

//  Binary search Tree
    static void printTree(TreeNode root){
        if(root==null) return;
        System.out.print(root.data+" ");
        printTree(root.left);
        printTree(root.right);
    }
    static TreeNode insert(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }if(val<root.data){
            root.left=insert(root.left, val);
        }if(val>root.data){
            root.right=insert(root.right, val);
        }return root;
    }

    static TreeNode searchP(TreeNode root,int val){
        if(root==null) return null;
        if((root.left != null && root.left.data == val) || (root.right != null && root.right.data == val))return root;
        TreeNode left=searchP(root.left, val);
        TreeNode right=searchP(root.right, val);
        return left==null ? right:left;
    }

    static TreeNode successor(TreeNode root){
        TreeNode temp=root.left;
        TreeNode pre=root;
        while(temp.right!=null){
            pre=temp;
            temp=temp.right;
        }
        if(pre==root) pre.left=temp.left;
        else pre.right=temp.left;
        return temp;
    }
    static TreeNode delete(TreeNode root,int el){
        if(root.data==el){
            if(root.left==null) return root.right;
            TreeNode temp=successor(root);
            TreeNode curr=root;
            temp.left=root.left;
            temp.right=root.right;
            curr=null;
            return temp;
        }else{
            TreeNode parent=searchP(root, el);
            boolean left=(parent.left.data==el)? true : false;
            TreeNode node = null;
            if(left) node = parent.left;
            else node = parent.right;
            if(node.left==null){
                if(left) parent.left=node.right;
                else parent.right=node.right;
            }else{
                TreeNode temp=successor(node);
                TreeNode curr=node;
                if(left) parent.left=temp;
                else parent.right=temp;
                if(node.left!=temp) temp.left=node.left;
                if(node.right!=temp) temp.right=node.right;
                curr=null;
            }
        }return root;
    }
    static void leftView(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                if(i==0) System.out.print(curr.data+" ");
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
    }

    static void rightView(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                if(i==n-1) System.out.print(curr.data+" ");
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
    }

    static class  Nel {
        TreeNode node;
        int col;
        int row;
        public Nel(TreeNode node,int row,int col){
            this.node=node;
            this.col=col;
            this.row=row;
        }        
    }
    static void topView(TreeNode root){
        if(root==null) return;
        TreeMap<Integer,List<Integer>> map=new TreeMap<>();
        Queue<Nel> q=new LinkedList<>();
        q.offer(new Nel(root, 0,0));
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Nel p=q.poll();
                TreeNode curr=p.node;
                int row=p.row;
                int col=p.col;
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(curr.data);
                if(curr.left!=null) q.offer(new Nel(curr.left, row+1, col-1));
                if(curr.right!=null) q.offer(new Nel(curr.right,row+1,col+1));
            }
        }for(int val:map.keySet()){
            System.out.print(map.get(val).get(0)+" ");
        }
    }
    public static void main(String[] args){
        int[] arr={20,8,4,12,10,14,22,25};
        TreeNode root=null;
        for(int val:arr){
            root=insert(root, val);
        }
        root=delete(root, 20);
        // printTree(root);
        leftView(root);
        System.out.println();
        rightView(root);
        System.out.println();
        topView(root);
    }
}
