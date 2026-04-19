import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void swap(int[]arr, int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void printArray(int[] arr){
        for (int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int binarySearch(int[] arr,int key){
        int start=0,end=arr.length-1;
        int mid=0;
        while(start<=end){
            mid=(start+end)/2;
            if (mid==key){
                return mid;
            } else if (mid>key) {
                end=mid-1;
            }else {
                start=mid+1;
            }
        }return -1;
    }
    public static void reverseArray(int[] arr){
        int start=0,end=arr.length-1;
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void subArray(int[] arr){
        for (int i=0; i<=arr.length-1;i++){
            for (int j=i;j<=arr.length-1;j++){
                System.out.print("{");
                for (int k=i;k<=j;k++){
                    System.out.print(arr[k]+",");
                }
                System.out.print("} ");
            }
            System.out.println();
        }
    }
    public static void sumOfSubArray(int[] arr){
        int max=0;
        for (int i=0; i<=arr.length-1;i++){
            for (int j=i;j<=arr.length-1;j++){
                int sum=0;
                for (int k=i;k<=j;k++) {
                    sum+=arr[k];
                }
                if (sum>max) max=sum;
                System.out.print(sum+" ");
            }
            System.out.println();
        }
    }
//    brute force approach for MAXIMUM SUBARRAY SUM
    public static void maxSubArraySum(int[] arr){
        int max=0;
        for (int i=0; i<=arr.length-1;i++){
            for (int j=i;j<=arr.length-1;j++){
                int sum=0;
                for (int k=i;k<=j;k++) {
                    sum+=arr[k];
                }
                if (sum>max) max=sum;
            }

        }
        System.out.println(max);
    }
//    Optimal approach for MAX SUBARRAY SUM
    public static void maxSub(int[] arr){
        int[] prefix=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        int sum=0,max=0;
        for (int i=0;i<=arr.length-1;i++){
            for (int j=i;j<=arr.length-1;j++){
                if(i==0) sum=prefix[j];
                else sum=(prefix[j]-prefix[i-1]);
                if(max<sum) max=sum;
            }
        }
        System.out.println(max);
    }
//    kadane algorithm best solution for MAX SUBARRAY AUM
    public static void kadane(int[] arr){
        int currSum=0,maxSum=Integer.MIN_VALUE;
        for (int i=0;i<=arr.length;i++){
            if(currSum+arr[i]>0){
                currSum+=arr[i];
            }maxSum= Math.max(maxSum, currSum);
        }
        System.out.println(maxSum);
    }

//    2d Array....................................

//    Spiral matrix
    public static void spiralMatrix(int[][] matrix){
        int startRow=0;
        int startCol=0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;
        while(startRow<=endRow&&startCol<=endCol){
//            .................top
            for(int j=0;j<=endCol;j++){
                System.out.print(matrix[startRow][j]+" ");
            }startRow++;
//            right
            for(int i=startRow;i<=endRow;i++){
                System.out.print(matrix[i][endCol]+" ");
            }endCol--;
//            bottom
            for(int j=endCol;j>=startCol;j--){
                System.out.print(matrix[endRow][j]+" ");
            }endRow--;
//            left
            for(int i=endRow;i>=startRow;i--){
                System.out.print(matrix[i][startCol]+" ");
            }startCol++;
        }
    }

//    Diagonal sum
    public static void diagonalSum(int[][] matrix){
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==j) sum+=matrix[i][j];
                if(i+j==matrix.length-1) sum+=matrix[i][j];
                if(i==j&&i+j==matrix.length-1) sum-=matrix[i][j];
            }
        }
        System.out.println("The sum of primary and secondary diagonal is: "+sum);
    }
//  Function to check weather the bit is set or not 
    public static boolean setBit(int n,int k){
        int bit=1;
        if((n&(bit<<k))==0) return false;
        return true;
    }
// Quick sort
    public static int  sort(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low+1,j=high;
        while(i<=j){
            while(i<=high && arr[i]<=pivot) i++;
            while(arr[j]>pivot) j--;
            if(i<j) swap(arr, i, j);
        }swap(arr, low, j);
        return j;
    }
    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int part=sort(arr,low,high);
            quickSort(arr, low, part-1);
            quickSort(arr, part+1, high);
        }return;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={4,6,2,5,7,9,1,3};
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}
