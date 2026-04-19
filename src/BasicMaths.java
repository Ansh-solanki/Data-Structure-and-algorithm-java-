import java.util.ArrayList;
import java.util.Scanner;

public class BasicMaths {
    static int countDigit(int n){
        int count=0;
        while(n!=0){
            n/=10;
            count++;
        }return count;
    }
    static int reverse(int n){
        int rev=0;
        while(n!=0){
            rev=rev*10+(n%10);
            n/=10;
        }return rev;
    }
    public static int fib(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1)+fib(n-2);
    }

    public static int right(ArrayList<Integer> arr){
        if(arr.size()==1) return arr.get(0);
        for(int i=arr.size()-1;i>=0;i=i-2){
            arr.remove(i);
        }return left(arr);
    }
    public static int left(ArrayList<Integer> arr){
        if(arr.size()==1) return arr.get(0);
        for(int i=0;i<arr.size();i=i+1){
            arr.remove(i);
        }return right(arr);
    }
    
    public static int lastRem(int n){
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }return left(arr);
    }
    // Another Approach
    public static int lastRem2(int n){
        int head=1;
        int step=1;
        boolean left=true;
        while(n>1){
            if(left||n%2==1){
                head+=step;
            }n/=2;
            step*=2;
            left=!left;
        }return head;
    }
    public static void main(String[] args) {
       
        System.out.println(lastRem2(9));
    }
}
