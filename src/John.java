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
    public static void main(String[] args){
        El[][] maze=new El[3][3];
        maze[0][0]=new El(false,true,false,false);
        maze[0][1]=new El(false,false,false,false);
        maze[0][2]=new El(false,false,false,false);
        maze[1][0]=new El(true,true,false,false);
        maze[1][1]=new El(false,true,false,true);
        maze[1][2]=new El(false,true,true,false);
        maze[2][0]=new El(true,true,false,true);
        maze[2][1]=new El(true,true,true,false);
        maze[2][2]=new El(true,true,false,true);
        List<int[]> list=new ArrayList<>();
        boolean[][] visit=new boolean[3][3];
        mazeSolve(maze, list, visit, 0, 0, 3);
        int[][] grid={{2,7,3,4,5},{3,1,5,1,1},{4,2,8,3,3},{1,1,1,2,2},{2,4,4,2,6}};
        System.out.println(gold(grid));
    }
}
