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

// (Leetcode 733) Flood Fill
    static void flood(int[][] image, boolean[][] arr,int val , int i,int j, int color){
        image[i][j]=color;
        arr[i][j]=true;
        
        if(i>0 && image[i-1][j]==val && !arr[i-1][j]) flood(image, arr,val, i-1, j, color);
        if(i<image.length-1 && image[i+1][j]==val && !arr[i+1][j]) flood(image, arr,val, i+1, j, color);
        if(j>0 && image[i][j-1]==val && !arr[i][j-1]) flood(image, arr,val, i, j-1, color);
        if(j<image[0].length-1 && image[i][j+1]==val && !arr[i][j+1]) flood(image, arr,val, i, j+1, color);
        return;
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n= image.length;
        boolean[][] arr=new boolean[n][image[0].length];
        int val=image[sr][sc];
        flood(image, arr, val, sr, sc, color);
        return image;
    }
    public static void main(String[] args) {
        int[][] arr={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr));
    }
}
