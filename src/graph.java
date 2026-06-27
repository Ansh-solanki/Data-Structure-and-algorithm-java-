import java.util.*;
public class graph {

//(Leetcode 547) Number of Provinces
    static void findCircle(int[][] grid,Set<Integer> set,int n){
        set.add(n);
        for(int i=0;i<grid[0].length;i++){
            if(grid[n][i]==1 && !set.contains(i)){
                findCircle(grid,set, i);
            }
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int ans=0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n; i++){
            if(!set.contains(i)){
                findCircle(isConnected, set, i);
                ans++;
            }
        }return ans;
    }
    
    public static void main(String[] args) {
        int[][] arr={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr));
    }
}
