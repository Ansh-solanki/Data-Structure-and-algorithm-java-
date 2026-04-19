import java.util.*;
public class GFG160 {
    public static void printArray(int[] arr){
        for (int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }
//    question 1
    public static int secondLargest(int[] arr){
        int largest=Integer.MIN_VALUE;
        int secLargest=Integer.MIN_VALUE;
        for(int num:arr){
            if(num>largest){
                secLargest=largest;
                largest=num;
            }else if(num>secLargest&&num!=largest){
                secLargest=num;
            }
        }return (secLargest==Integer.MIN_VALUE)?-1:secLargest;
    }
//    question 2
    public static void moveZeroToEnd(int[] arr){
        int i=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=0){
                if(i!=j){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }i++;
            }
        }printArray(arr);
    }
//    Question 3
    public static void reverseArray(int[] arr,int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
//    Question 4
    public static void rotateArray(int[] arr,int k){
        k%=arr.length;
        reverseArray(arr,0,arr.length-1);
        reverseArray(arr,0,k-1);;
        reverseArray(arr,k,arr.length-1);
    }
//    Question 5
    public static void nextPermutation(int[] arr){
        int pivot=-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                pivot=i;
                break;
            }
        }if (pivot == -1){
            reverseArray(arr,0,arr.length-1);
        }else{
            for (int i = arr.length - 1; i > pivot; i--) {
                if (arr[i] > arr[pivot]) {
                    // Swap
                    int temp = arr[i];
                    arr[i] = arr[pivot];
                    arr[pivot] = temp;
                    break;
                }
            }
            reverseArray(arr,pivot+1,arr.length-1);
        }printArray(arr);
    }
    //    Question 7
    public static int sellAndBuy(int[] arr){
        int cp=arr[0];
        int profit=0;
        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1) {
                if (arr[i + 1] >= arr[i]) {
                    continue;
                }else{
                    profit+=arr[i]-cp;
                    cp=arr[i+1];
                }
            }else{
                profit+=arr[i]-cp;
            }
        }return profit;
    }
    //    Another approach
    public static int calculateMaxProfit(int[] prices) {
        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit;
    }
//    Question 8
    public static int selAndBuy(int[] arr){
        int cp=arr[0];
        int  profit=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<cp){
                cp=arr[i];
            }if(arr[i]>cp){
                profit=Math.max(arr[i]-cp,profit);
            }
        }return profit;
    }
//    Question 9, This is a local approach not a global one.
    public static int minimizeHeight(int[] arr,int k){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int height=0;
        for(int i=0;i<arr.length;i++){
            if((arr[i]-k)<=0){
                arr[i]+=k;
            }else{
                arr[i]-=k;
            }min=Math.min(min,arr[i]);
             max=Math.max(arr[i],max);
        }height=max-min;
        return height;
    }
//  Another approach
    public static void minHeight(int[] arr,int k){
        Arrays.sort(arr);
        int small=arr[0]+k;
        int big=arr[arr.length-1]-k;
        if(small>big){
            int temp=small;
            small=big;
            big=temp;
        }for(int i=1;i<arr.length-1;i++){

        }
    }

    public static void main(String[] args) {
        int[] arr={3,9,12,16,20};
//        System.out.println(secondLargest(arr));
//        moveZeroToEnd(arr);
//        nextPermutation(arr);
//        System.out.println(sellAndBuy(arr));
//        System.out.println(calculateMaxProfit(arr));
        System.out.println(minimizeHeight(arr,3));
    }
}
