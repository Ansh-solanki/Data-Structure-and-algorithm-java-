import java.util.*;

public class DSAarrays {
    public static void printArray(int[] arr){
        for (int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int  majorityEle(int[] nums){
        int count=0,candidate=0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;

            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
    public static void trappingRainWater(int[] arr){
        int[] leftMax=new int[arr.length];
        int[] rightMax=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            leftMax[i]=(i==0)?arr[i]:Math.max(arr[i],leftMax[i-1]);
        }for(int j=arr.length-1;j>=0;j--){
            rightMax[j]=(j==arr.length-1)?arr[j]:Math.max(arr[j],rightMax[j+1]);
        }int waterTrapped=0;
        for(int i=0;i<=arr.length-1;i++){
            waterTrapped+=Math.min(leftMax[i],rightMax[i])-arr[i];
        }
        System.out.println(waterTrapped);
    }
    //Optimal solution for trapping rain water
    public static int trapping(int[] arr){
        int leftMax=0,rightMax=0,total=0;
        int left=0,right=arr.length-1;
        while(left<right){
            if(arr[left]<=arr[right]){
                if(arr[left]<leftMax){
                    total+=leftMax-arr[left];
                }else{
                    leftMax=arr[left];
                }left++;
            }else{
                if(arr[right]<rightMax){
                    total+=rightMax-arr[right];
                }else{
                    rightMax=arr[right];
                }right--;
            }
        }return total;
    } 
    public static void buyAndSellStock(int[] arr){
        int costPrice=arr[0];
        int sellingPrice=0;
        int profit=0;
        for(int i=1;i<arr.length;i++){
            sellingPrice=arr[i];
            profit=Math.max(profit,costPrice-sellingPrice);
            
        }
    }
//    Question 189
    public static void rotateArray(int[] arr, int k){
        int n=0;
        while(n<k){
            int temp=arr[0];
            arr[0]=arr[arr.length-1];
            for(int i=arr.length-2;i>0;i--){
                arr[i+1]=arr[i];
            }arr[1]=temp;
            n++;
        }printArray(arr);
    }
//    Question 268
    public static int missingNumber(int[] nums) {
        int n=nums.length;
        int totalSum=n*(n-1);
        int currSum=0;
        for(int val:nums) currSum += val;
        return totalSum-currSum;
    }
    public static int longestConsecutiveSubsequence(int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        for(int num:arr){
            list.add(num);
        }int count=1;
        int max=1;
        for(int num:list){
            if(list.contains(num+1)){
                count++;
                max=Math.max(max,count);
            }else{
                count=1;
            }
        }return max;
    }
//    Question 15(LeetCode)
    public static List<List<Integer>> threeSum(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i>0&&arr[i]==arr[i-1]) continue;
            int start =i+1,end=arr.length-1;
            while(start<end){
                 int sum=arr[i]+arr[start]+arr[end];
                 if(sum==0) {
                     res.add(Arrays.asList(arr[i], arr[start], arr[end]));
                     start++;
                     end--;
                     while (start < end && arr[start] == arr[start - 1]) start++;// To skip the duplicates from left.
                     while (start < end && arr[end] == arr[end + 1]) end--;      // To skip the duplicates from right.
                 }else if(sum<0){
                     start++;
                 }else{
                     end--;
                 }
             }
        }
        return res;
    }
//    Question 18(LeetCode)
    public static List<List<Integer>> fourSum(int[] arr,int target){
        Arrays.sort(arr);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i>0&&arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<arr.length;j++) {
                if(j>i+1&&arr[j]==arr[j-1]) continue;
                int start =j+1,end=arr.length-1;
                while (start < end) {
                    int sum = arr[i] + arr[j] + arr[start] + arr[end];
                    if (sum == target) {
                        res.add(Arrays.asList(arr[i],arr[j], arr[start], arr[end]));
                        start++;
                        end--;
                        while (start < end && arr[start] == arr[start - 1]) start++;// To skip the duplicates from left.
                        while (start < end && arr[end] == arr[end + 1])end--; // To skip the duplicates from right.
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }
// Question: Union of two sorted array
    public static List<Integer> union(int[] arr1,int arr2[]){
        ArrayList<Integer>arr=new ArrayList<>();
        int i=0,j=0;
        int n=arr1.length-1;
        int m=arr2.length-1;
        while(i<=n&&j<=m){
            while(i>0&&arr1[i]==arr1[i-1]) i++;
            while (j>0&& arr2[j]==arr2[j-1]) j++;
            if(arr1[i]<arr2[j]){
                arr.add(arr1[i]);
                i++;
            }else if(arr2[j]<arr1[i]){
                arr.add(arr2[j]);
                j++;
            }else{
                arr.add(arr1[i]);
                i++;
                j++;
            }
        }while(i<n){
            while(i>0&&arr1[i]==arr1[i-1]) i++;
            arr.add(arr1[i]);
        }
        while(j<m){
            while (j>0&& arr2[j]==arr2[j-1]) j++;
            arr.add(arr2[j]);
        }
        return arr;
    }
// Question (73 Leetcode): set matrix zero
    public static void setZero(int[][] matrix){
        int n=matrix.length,m=matrix[0].length;
        int col0=1;
        // Setting row and column zero
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0){
                        matrix[0][j]=0;
                    }else{
                        col0=0;
                    }
                }
            }
        }for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]!=0){
                    if(matrix[i][0]==0||matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }if(matrix[0][0]==0){
            for(int j=0;j<m;j++) matrix[0][j]=0;
        }if(col0==0){
            for(int i=0;i<n;i++) matrix[i][0]=0;
        }
    }
// Question : Count Inversion
    // Function for merge
    public static int merge(int[] arr,int low,int mid, int high){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low,right=mid+1;
        int count=0;
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                count+=(mid-left+1);
                right++;
            }
        }while (left<=mid) {
            temp.add(arr[left]);
            left++;
        }while (right<=high) {
            temp.add(arr[right]);
            right++;
        }for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
        return count;
    }
    // Function for mergesort
    public static int mergeSort(int[] arr,int low, int high){
        int count=0;
        if(low>=high) return count;
        int mid=(low+high)/2;
        count+=mergeSort(arr, low, mid);
        count+=mergeSort(arr, mid+1, high);
        count+=merge(arr, low, mid, high);
        return count;
    }
    // Function for count inversion
    public static int countInversion(int[] arr){
        return mergeSort(arr, 0, arr.length-1);
    }
// Question (493 LeetCode): Reverse Pairs
    // Function for calculating count between two sorted array
    public static int  countRP(int[] arr,int low,int high,int mid){
        int count =0,right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high&&arr[i]>(2*arr[right])) right++;
            count=count+(right-(mid+1));
        }return count;
    }
    // Function for merge
    public static void mergeRP(int[] arr,int low,int mid, int high){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low,right=mid+1;
        int count=0;
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }while (left<=mid) {
            temp.add(arr[left]);
            left++;
        }while (right<=high) {
            temp.add(arr[right]);
            right++;
        }for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
    }
    // Function for mergesort
    public static int  mergeSortRP(int[] arr,int low, int high){
        int count=0;
        if(low>=high) return count;
        int mid=(low+high)/2;
        count+=mergeSortRP(arr, low, mid);
        count+=mergeSortRP(arr, mid+1, high);
        count+=countRP(arr, low, high, mid);
        mergeRP(arr, low, mid, high);
        
        return count;
    }
    // Function for Reverse Pairs
    public static int reversePairs(int[] arr){
        int count=mergeSortRP(arr, 0, arr.length-1);
        return count;
    }
// Question : Find the repeating and missing numbers
    public static int[] findRepeatingAndMissing(int[] arr){
        long s1=0,s2=0,n=arr.length;
        long s1n=(long)(n*(n+1))/2;
        long s2n=(long)(n*(n+1)*(2*n+1))/6;
        for(int num:arr){
            s1+=num;
            s2+=(long)(num*num);
        }long val1=s1-s1n;
        long val2=s2-s2n;
        val2=val2/val1;
        long x=(val1+val2)/2;
        long y=x-val1;
        return new int[]{(int)x,(int)y};
    }
    // Another approach using bit manipulation 
    public static int[] findRM2(int[] arr){
        int xor=0;
        for(int i=0;i<arr.length;i++){
            xor=xor^arr[i];
            xor=xor^(i+1);
        }int bit=0;
        while(true){
            if((xor&(1<<bit))!=0) break;
            bit++;
        }int zero=0;
        int one=0;
        for(int i=0;i<arr.length;i++){
            if((arr[i]&(1<<bit))!=0) one=one^arr[i];
            else zero=zero^arr[i];
        }for(int i=1;i<=arr.length;i++){
            if((i&(1<<bit))!=0) one=one^i;
            else zero=zero^i;
        }int count=0;
        for(int num:arr){
            if(zero==num) count++;
        }if(count==2) return new int[]{zero,one};
        return new int[]{one,zero};
    }
// Question: Longest SubArray with the given sum k
    // Using HashMap 
    public static int longestSubArrayEqualsK(int[] arr, int k){
        int sum=0;
        int maxLen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k) maxLen=Math.max(maxLen, i+1);
            int rem=sum-k;
            if(map.containsKey(rem)){
                maxLen=Math.max(maxLen, i-map.get(rem));
            }if(!map.containsKey(sum)) map.put(sum,i);
        }return maxLen;
    }
    public static void main(String[] args) {
        int[] arr={2,0,0,3};
        System.out.println(longestSubArrayEqualsK(arr,3));
    }
}
