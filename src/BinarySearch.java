import java.util.*;

public class BinarySearch {
    public static class pair{
        double first;
        int second;
        pair(double first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static int binarySearch(int[] arr,int left,int right,int target){
        if(left>right) return -1;
        int mid=(left+right)/2;
        if(arr[mid]==target) return mid;
        else if(arr[mid]>target) return binarySearch(arr,left,mid-1,target);
        else return binarySearch(arr,mid+1,right,target);
    }
//  Function to found lower bound
    public static int lowerBound(int[] arr,int x){
        int low=0,high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }return ans;
    }
//    Function to implement upper bound
    public static int upperBound(int[] arr,int x){
        int low=0,high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }return ans;
    }
//    Function to Search insert position
    public static int searchInsert(int[] arr, int target) {
        int low =0,high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }return ans;
    }
//    Function to find floor and ceil in sorted array
    public static int[] floorAndCeil(int[] arr,int x){
        int low=0,high=arr.length-1;
        int floor=-1,ceil=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
                floor=x;
                ceil=x;
                break;
            }else if (arr[mid]>x){
                ceil=arr[mid];
                high=mid-1;
            }else{
                floor=arr[mid];
                low=mid+1;
            }
        }return new int[] {floor,ceil};
    }
//    Function to find first position
    public static int findFirst(int[] arr,int target){
        int start=0,end=arr.length-1;
        int first=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==target){
                first=mid;
                end=mid-1;
            } else if (arr[mid]<target) {
                start=mid+1;
            }else{
                end=mid-1;
            }
        }return first;
    }
//    Function to find last position
    public static int findLast(int[] arr,int target) {
        int start = 0, end = arr.length - 1;
        int last = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                last = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return last;
    }
//    Function to find first and last position
    public static int[] findFirstAndLast(int[] arr,int target){
        int first=findFirst(arr,target);
        int last=findLast(arr,target);
        return new int[]{first,last};
    }
//    Function to count occurrences in a sorted array
    public static int countOccurrences(int[] arr,int target){
        int first=findFirst(arr,target);
        int last=findLast(arr,target);
        return last-first+1;
    }
//    Function to find out Minimum in a rotated array
    public static int findMin(int[] arr) {
        int start=0,end=arr.length-1;
        int min=Integer.MAX_VALUE;
        while(start<=end){
            if(arr[start]<arr[end]){
                min=Math.min(min,arr[start]);
                break;
            }
            int mid=(start+end)/2;
            if(arr[mid]>=arr[start]){
                min=Math.min(min,arr[start]);
                start=mid+1;
            }
            else{
                min=Math.min(min,arr[mid]);
                end=mid-1;
            }
        }return min;
    }
//    Function to find out how many times an array has been rotated
    public static int noOfRotation(int[] arr) {
        int start=0,end=arr.length-1;
        int min=Integer.MAX_VALUE;
        int index=-1;
        while(start<=end){
            if(arr[start]<arr[end]){
                min=arr[start];
                index=start;
                break;
            }
            int mid=(start+end)/2;
            if(arr[mid]>=arr[start]){
                if(arr[start]<min){
                    min=arr[start];
                    index=start;
                }
                start=mid+1;
            }
            else{
                if(arr[mid]<min){
                    min=arr[mid];
                    index=mid;
                }
                end=mid-1;
            }
        }return index;
    }

    
//  Binary search on Answers

// Function to find square root of a number
    public static int squareRoot(int n){
        int start=1,end=n;
        int ans=0;
        while(start<=end){
            int mid=(start+end)/2;
            if(mid*mid<=n){
                ans=mid;
                start=mid+1;
            }
            if(mid*mid>n){
                end=mid-1;
            } 
        }
        return ans;
    }
//  Function to find nth root of a number
    public static int nthRoot(int n,int m){
        int ans=-1;
        int start=1,end=m;
         while(start<=end){
            int mid=(start+end)/2;
            if(Math.pow(n,mid)==m) ans=mid;
            if(Math.pow(n,mid)>m) end=mid-1;
            else start=mid+1;
         }
        return ans;
    }
// Function to find maximum of an array
    public static int maxArray(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            max=Math.max(max,i);
        }
        return max;
    }
// Function to calculate total hours
    public static int calculateTotalHours(int[] arr,int k){
        int hrs=0;
        for(int i:arr){
            hrs+=Math.ceil((double)(i)/(double)(k));
        }return hrs;
    }
// Function of (KOKO eating bananas)
    public static int kokoEatingBananas(int[] arr, int h){
        int k=0;
        int start=1,end=maxArray(arr);
        while (start<=end) {
            int mid=(start+end)/2;
            if(calculateTotalHours(arr, mid)<=h){
                k=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return k;
    }
// Function to find total sum after division by the divisor
    public static boolean div(int[] arr, int k,int threshold){
        int th=0;
        for (int i: arr){
            th+=(i+k-1)/k; //to find ceil value
        }if(th<=threshold) return true;
        return false;
    }
//  Function to find smallest divisor
    public static int smallestDivisor(int[] arr,int limit){
        int start=1,end=maxArray(arr);
        int ans=0;
        while(start<=end){
            int mid=(start+end)/2;
            if(div(arr, mid,limit)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }return ans;
    }

// Question find minimum number of days to make a bouquets
    // Function to find number of days to bloom enough floweres to make bouquets
    public static boolean isSatisfy(int[] arr,int mid,int m,int k){
        int count=0;
        int bouquets=0;
        for(int val:arr){
            if(mid>=val){
                count++;
                if(count==k){
                    bouquets++;
                    count=0;
                }
            }else count=0;
            if(bouquets>=m) return true;
        }return false;
    }
    // Function to find minimum number 
    public static int minDaysForBouquets(int[] arr,int m,int k){
        if ((long) m * k > arr.length) return -1;
        int start=1,end=1000000;
        int ans=-1;
        while(start<=end) {
            int mid=(start+end)/2;
            if(isSatisfy(arr, mid, m,k)){
                ans=mid;
                end=mid-1;
            }else start=mid+1;
        }return ans;
    }
// Question (1011 leetcode): Capacity to ship packages within d days
    // Function to find weight
    public static boolean findWeight(int[] arr,int mid,int days){
        int load=0,day=1;
        for(int val:arr){
            if(val+load<=mid){
                load+=val;
            }else{
                load=val;
                day+=1;
            }
        }if(day<=days) return true;
        return false;
    }
    // Function to apply binary search 
    public static int capacity(int[] arr,int days){
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int val:arr){
            high+=val;
            low=Math.max(low,val);
        }while (low<=high) {
            int mid=(low + high )/2;
            if(findWeight(arr,mid,days)){
                high=mid-1;
            }else low=mid+1;
        }
        return low;
    }
// Question (1539 leetcode): Kth missing positive number
    public static int findKthPositive(int[] arr, int k) {
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            int missing=arr[mid]-mid-1;
            if(missing<k) start=mid+1;
            else end=mid-1;
        }return k+end+1;
    }
// Question: Aggressive cows
    // Function to find appropriate distance
    public static boolean cows(int[] arr,int mid,int cows){
        int cow=1,stall=arr[0];
        for(int i=1;i<arr.length;i++){
            if((arr[i]-stall)>=mid){
                cow+=1;
                stall=arr[i];
            }
        }if(cow>=cows) return true;
        return false;
    }
    // Function to apply binary search 
    public static int aggressiveCows(int[] arr,int cows){
        Arrays.sort(arr);
        int n=arr.length;
        int low=1,high=arr[n-1]-arr[0];
        while(low<=high){
            int mid=(low+high)/2;
            if(cows(arr, mid, cows)) low=mid+1;
            else high=mid-1;
        }
        return high;
    }
// Question: Allocate minimum numebr of pages
    // Function to find appropriate number of pages
    public static boolean pages(int[] arr,int page,int m){
        int prev=0,stu=1;
        for(int val:arr){
            if((prev+val)<=page){
                prev+=val;
            }else{
                prev=val;
                stu+=1;
            }
        }if(stu<=m) return true;
        return false;
    }
    // logic for binary search
    public static int minimumNoOfPages(int[] arr,int m){
        int low=Integer.MIN_VALUE,high=0;
        for(int val:arr){
            low=Math.max(low,val);
            high+=val;
        }while(low<=high){
            int mid=(low+high)/2;
            if(pages(arr, mid, m)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
// Question: Minimize the maximum distance
    // Better Approach
    public static double minmizeMaxDis(int[] arr, int k){
        int n=arr.length;
        int[] howMany=new int[n-1];
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.first,a.first));
        for(int i=0;i<n-1;i++){
            pq.add(new pair(arr[i+1]-arr[i], i));
        }
        for(int gs=0;gs<k;gs++){
            pair tq=pq.poll();
            int secInd=tq.second;
            howMany[secInd]++;
            double iniDiff=arr[secInd+1] -arr[secInd];
            double secLength=iniDiff/(double)(howMany[secInd]+1);
            pq.add(new pair(secLength, secInd));
        }return pq.peek().first;
    }
    // Optimal Approach
    // Function to find required gas Station for a particular distance
    public static double gasStationRequired(double dist,int[] arr){
        int n=arr.length;
        int count=0;
        for(int i=1;i<n;i++){
            int noInBetween=(int)((arr[i]-arr[i-1])/dist);
            if((arr[i]-arr[i-1])==dist*noInBetween){
                noInBetween--;
            }count+=noInBetween;
        }return count;
    }
    // Logic for binary search for this Question
    public static double minMaxDist(int[] arr,int k){
        int n=arr.length;
        double start=0;
        double end=0;
        for(int i=0;i<n-1;i++){
            end=Math.max(end,(double)(arr[i+1]-arr[i]));
        }double diff=1e-6;
        while(end-start>diff){
            double mid=(start+end)/2.0;
            if(gasStationRequired(mid, arr)>k) start=mid;
            else end=mid;
        }return end;
    }
// Question(04 Leetcode): Median of two sorted array
    // Optimal approach
    public static double medianOfTwoSortedArray(int[] arr1,int[] arr2){
        int n1=arr1.length,n2=arr2.length;
        if(n2>n1) return medianOfTwoSortedArray(arr2, arr1);
        int n=n1+n2;
        int low=0,high=n1;
        int leftEl=(n1+n2+1)/2;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=leftEl-mid1;
            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2=(mid2>0)?arr2[mid2-1]:Integer.MIN_VALUE;
            int r1=(mid1<n1)?arr1[mid1]:Integer.MAX_VALUE;
            int r2=(mid2<n2)?arr2[mid2]:Integer.MAX_VALUE;
            if(l1<=r2&&l2<=r1){
                if(n%2==1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0; 
            }else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr1={25,46,28,49,24};
        
        System.out.println(minimumNoOfPages(arr1,4));

    }
}
