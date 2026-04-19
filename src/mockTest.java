import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class mockTest {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(TreeNode left,int val,TreeNode right){
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }
    static void preOrder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    static int index=0;
    static TreeNode insert(int[] arr){
        // Scanner sc=new Scanner(System.in);
        if(index>=arr.length || arr[index]==-1){
            index++;
            return null;
        } 
        int data=arr[index];
        TreeNode root=new TreeNode(null, data, null);
        index++;
        root.left=insert(arr);
        root.right=insert(arr);
        return root;
        
    }

    static int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }

    static void levelOrder(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                System.out.print(curr.val+" ");
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }System.out.println();
        }
    }

    static boolean checkBalance(TreeNode root){
        if(root==null) return true;
        int right=maxDepth(root.right);
        int left=maxDepth(root.left);
        if(Math.abs(left-right)>1) return false;
        return checkBalance(root.left) && checkBalance(root.right);
    }

    static int diameter(TreeNode root){
        if(root==null) return 0;
        int dia=maxDepth(root.left)+maxDepth(root.right)+1;
        int left=diameter(root.left);
        int right=diameter(root.right);
        return Math.max(dia,Math.max(left, right));
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,-1,-1,5,-1,-1,3,-1,-1};
        TreeNode root=null;
        root=insert(arr);
        // levelOrder(root);
        System.out.println(diameter(root));
    }
}

