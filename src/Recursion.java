import java.util.*;

public class Recursion {
    public static void nNumbers(int i,int n){
        if(i>n) return;
        System.out.println(i);
        nNumbers(i+1,n);
    }
    public static void name(String s,int n,int i){
        if(i>n) return;
        System.out.println(s);
        name(s, n, i+1);
    }
// Question(51 Leetcode): N-Queen
    // List<List<String>> ans=new ArrayList<>();
    // char[][] board;

    // boolean isSafe(int row,int col,int n){
    //     //for column
    //     for(int i=0;i<row;i++){
    //         if(board[i][col]=='Q') return false;
    //     }
    //     // left diagonal
    //     for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
    //         if(board[i][j]=='Q') return false;
    //     }
    //     // Right Diagonal
    //     for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
    //         if(board[i][j]=='Q') return false;
    //     }return true;
    // }
    // public List<String> construct(){
    //     List<String> res=new ArrayList<>();
    //     for(char[] row: board){
    //         res.add(new String(row));
    //     }return res;
    // }
    // void backtrack(int row,int n){
    //     if(row==n){
    //         ans.add(construct());
    //         return;
    //     }for(int col=0;col<n;col++){
    //         if(isSafe(row,col,n)){
    //             board[row][col]='Q';
    //             backtrack(row+1, n);
    //             board[row][col]='.';// backtracking 
    //         }
    //     }
    // }
    // public  List<List<String>> nQueen(int n){
    //     board=new char[n][n];
    //     for(int i=0;i<n;i++){
    //         Arrays.fill(board[i],'.');
    //     }backtrack(0,n);
    //     return ans;
    // } 


// Question: Generate all binary Strings
    public static void generate(int n,String curr,List<String> list){
        if(curr.length()==n){
            list.add(curr);
            return;
        }generate(n,curr+ "0", list);
        if(curr.isEmpty()||curr.charAt(curr.length()-1)!='1'){
            generate(n, curr+"1", list);
        }
    }
// Question(LeetCode 22): Generate Parenthesis
    public static int countChar(String s,int i,char t){
        if(i==s.length()) return 0;
        int count=(s.charAt(i)==t)?1:0;
        return count+countChar(s,i+1,t);
    }
    public static void generateParenthesis(int n,String s,int a,int b,List<String>list){
        if(s.length()==n*2){
            list.add(s);
            return;
        }
        if(a<n){
            generateParenthesis(n,s+"(",a+1,b,list);
        }if((b<a)){
            generateParenthesis(n, s+")",a,b+1, list);
        }
    }

// Question: Sum of Subsequences
    public static void generateSum(int[] nums,List<List<Integer>> list,List<Integer> arr,int sum,int count,int i){
        if(count==sum){
            list.add(new ArrayList<>(arr));
            return;
        }arr.add(nums[i]);
        generateSum(nums, list, arr, sum, count+arr.get(arr.size()-1), i+1);
        arr.remove(arr.size()-1);
        generateSum(nums, list, arr, sum, count, i+1);
    }
    public static List<List<Integer>> sumSub(int [] arr,int sum){
        List<List<Integer>> list=new ArrayList<>();
        generateSum(arr,list,new ArrayList<>(),sum,0,0);
        return list;
    }

// Question(LeetCode 39): Combination sum
    public static void combination(int[] nums,List<List<Integer>> list,List<Integer> arr,int sum,int count,int i){
        if(count==sum){
            list.add(new ArrayList<>(arr));
            return;
        }if(i==nums.length||count>sum) return;
        arr.add(nums[i]);
        combination(nums, list, arr, sum, count+nums[i], i);
        arr.remove(arr.size()-1);
        combination(nums, list, arr, sum, count, i+1);
    }
    public static List<List<Integer>> combinationSum(int [] arr,int sum){
        List<List<Integer>> list=new ArrayList<>();
        combination(arr,list,new ArrayList<>(),sum,0,0);
        return list;
    }

// // Question (LeetCode 40): Combination sum II
//     public static void combinationII(int[] arr,List<List<Integer>> list,List<Integer> nums,int target)
//     public static List<List<Integer>> combinationSumII(int[] arr,int target){
//         List<List<Integer>> list=new ArrayList<>();
//         combinationII(arr, list);
//         return list;
//     }
//   N Queens
    static char[][] board;
    static List<List<String>> list=new ArrayList<>();  

    static boolean isSafe(int i,int j,int n){
        if(i==0) return true;
        //  check vertically
        for(int k=0;k<i;k++){
            if(board[k][j]=='Q') return false;
        }
        // check diagonally
        for(int row=i-1,col=j-1;row>=0 && col>=0;row--,col--){
            if(board[row][col]=='Q') return false;
        }
        for(int row=i-1,col=j+1;row>=0 && col<n;row--,col++){
            if(board[row][col]=='Q') return false;
        }return true;
    }
    static List<String> construct(){
        List<String> ans=new ArrayList<>();
        for(char[] arr: board){
            ans.add(new String(arr));
        }return ans;
    }
    static void backTrack(int n,int row){
        if(row>=n){
            list.add(construct());
            return;
        }
        for(int j=0;j<n;j++){
            if(isSafe(row,j,n)){
                board[row][j]='Q';
                backTrack(n, row+1);
                board[row][j]='.';
            }
        }
    }
    static List<List<String>> queen(int n){
        board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }backTrack(n, 0);
        return list;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // List<String> list=new ArrayList<>();
        // generateParenthesis(3, "",0,0 ,list);
        // for(String s:list){
        //     System.out.print(s+" ");
        // }
        int[] arr={2,3,6,7};
        System.out.println(queen(4));
    }
}
