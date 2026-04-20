import java.util.*;
public class DynamicProgramming {
//  Question 1: frog jump   
    //  recurssion part 
    public static int solve1(int[] arr,int ind){
        if(ind==0) return 0;
        int left=solve1(arr,ind-1)+Math.abs(arr[ind]-arr[ind-1]);
        int right=Integer.MAX_VALUE;
        if(ind>1) right=solve1(arr,ind-2)+Math.abs(arr[ind]-arr[ind-2]);
        return Math.min(left,right);
    }
    // Memoization part
    public static int solve2(int[] arr,int[] nums,int ind){
        if(ind ==0){
            return 0;
        }if(nums[ind]!=-1) return nums[ind];
        int left=solve2(arr, nums, ind-1)+Math.abs(arr[ind]-arr[ind-1]);
        int right=Integer.MAX_VALUE;
        if(ind>1) right=solve2(arr, nums, ind-2)+Math.abs(arr[ind]-arr[ind-2]);
        nums[ind]=Math.min(left,right); 
        return nums[ind];
    }
    // Optimized dp solution 
    public static int solve3(int[] arr){
        int n1=0;
        int n2=-1;
        for(int i=1;i<arr.length;i++){
            int left=n1+Math.abs(arr[i]-arr[i-1]);
            int right=Integer.MAX_VALUE;
            if(i>1){
                right=n2+Math.abs(arr[i]-arr[i-2]);
            }n2=n1;
            n1=Math.min(left,right);
        }return n1;
    }
    public static int frogJump(int[] arr){
        // int n=arr.length;
        // int[] nums=new int[n];
        // Arrays.fill(nums,-1);
        return solve3(arr);
    }

//  Question 198: House robber
    static int house(int[] arr,int i,int[] dp){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int left=arr[i]+house(arr, i+2,dp);
        int skip=house(arr,i+1,dp);
        dp[i]= Math.max(skip,left);
        return dp[i];
    }
    static int houseRoober(int[] arr,int[] dp){
        return house(arr, 0,dp);
    }

    static int knight(int[][] arr,int i,int j,int m,int n){
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1){
            return Math.max(1, 1-arr[i][j]);
        }
        int right=knight(arr, i, j+1, m, n);
        int down=knight(arr, i+1, j, m, n);
        int min= Math.min(right,down);
        return Math.max(1,min-arr[i][j]);
    }
    
// DP on subsecquences
    // using Recurssion
    static boolean can1(int[] nums,int target,int i){
        if(target==0) return true;
        if(i==0) return (nums[0]==target);
        boolean skip=can1(nums, target, i-1);
        boolean take=false;
        if(target>=nums[i]){
            take=can1(nums, target-nums[i], i-1);
        }return take||skip;
    }
    // memoization
    static boolean can2(int[] nums,Boolean[][] dp, int target,int i){
        if(target==0) return true;
        if(i==0) return (nums[0]==target);
        if(dp[i][target]!= null) return dp[i][target];
        boolean skip=can2(nums,dp, target, i-1);
        boolean take=false;
        if(target>=nums[i]){
            take=can2(nums,dp, target-nums[i], i-1);
        }return dp[i][target] = take||skip;
    }
    static boolean can3(int[] nums,int target){
        int n=nums.length;
        boolean[] prev=new boolean[target+1];
        prev[0]=true;
        if(nums[0]<target) prev[nums[0]]=true;
        for(int i=1;i<n;i++){
            boolean[] curr=new boolean[target+1];
            curr[0]=true;
            for(int t=1;t<=target;t++){
                boolean skip=prev[t];
                boolean take=false;
                if(nums[i]<=t){
                    take=prev[t-nums[i]];
                }curr[t]= skip || take;
            }prev=curr;
        }return prev[target];
    }
    static boolean canPartition(int[] nums){
        if(nums.length<2) return false;
        int n=nums.length;
        int sum=0;
        for(int val:nums){
            sum+=val;
        }if(sum%2!=0) return false;
        sum/=2;
        // Boolean[][] dp=new Boolean[n][sum+1];
        return can3(nums, sum);
    } 
    public static void main(String[] args){
        int[] arr={1,2,3,5};
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(canPartition(arr));
    }
}
