import java.util.*;
public class slidingWindow {
// Question (03 LeetCode): Longest Substring without repeating character
    public static int LongestSubstring(String s){
        Set<Character> set=new HashSet< >();
        int max=Integer.MIN_VALUE;
        int i=0;
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            if(set.contains(ch)){
                while(set.contains(ch)){
                    set.remove(s.charAt(i));
                    i++;
                }
            }set.add(ch);
            max=Math.max(max,j-i+1);
        }return max;
    }
// Question (1004 LeetCode): Max Consecutive ones III
    public static int maxConsecutiveOnes(int[] arr,int k){
        int max=Integer.MIN_VALUE;
        int left=0,zero=0;
        for(int right=0;right<arr.length;right++){
            if(arr[right]==0){
                zero++;
            }if(zero>k){
                if(arr[left]==0) zero--;
                left++;
            }max=Math.max(max, right-left+1);
        }return max;
    }
// Question: Fruit into basket
    public static int  fruitIntoBasket(int[] arr,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        int left=0;
        for(int right=0;right<arr.length;right++){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            if(map.size()>2){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0) map.remove(arr[left]);
                left++;
            }max=Math.max(max, right-left+1);
        }return max;
    }
// Question(424 LeetCode): Longest Repeating character Replacement
    public static int longestRepeatingCharReplacement(String s,int k){
        int a=0,b=0;
        int max=Integer.MIN_VALUE;
        int left=0;
        int[] arr=new int[26];
        int maxFre=Integer.MIN_VALUE;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            arr[ch-'A']++;
            maxFre=Math.max(maxFre, arr[ch-'A']);
            if(((right-left+1)-maxFre)>k){
                arr[s.charAt(left)-'A']--;
                left++;
            }
            max=Math.max(max, right-left+1);
        }return max;
    }
// Question (930 LeetCode): Binary Subarray with sum
    // Function to count subarrays less than and equal to sum
    public static int count(int[] arr,int goal){
        if(goal<0) return 0;
        int n=arr.length;
        int left=0,right=0;
        int sum=0;
        int count=0;
        while(right<n){        
            sum+=arr[right];
            while(sum>goal){
                sum-=arr[left];
                left++;
            }count=count+(right-left+1);
            right++;
        }
        
        return count;
    }
    public static int numSubarraysWithSum(int[] arr, int goal) {
        return (count(arr, goal)-count(arr, goal-1)); 
    }
// Question(1248 LeetCode): count Numeber of nice subarrays
    // Function to count nice Sub array
    public static int count1(int[] arr,int goal){
        if(goal<0) return 0;
        int n=arr.length;
        int left=0,right=0;
        int sum=0;
        int count=0;
        while(right<n){        
            sum+=arr[right]%2;
            while(sum>goal){
                sum-=arr[left]%2;
                left++;
            }count=count+(right-left+1);
            right++;
        }
        return count;
    }
    public static int niceSubarray(int[] arr, int goal) {
        return (count1(arr, goal)-count1(arr, goal-1)); 
    
    }
// Question(1358 LeetCode): Number of Substrings containinf all three characters
    public static int numberOfSubstrings(String s) {
         int[] arr=new int[3];
         int count=0;
         int left=0;
         for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            arr[ch-'a']++;
            while(arr[0]>0 &&arr[1]>0 &&arr[2]>0){
                count+=(s.length()-i);
                arr[s.charAt(left)-'a']--;
                left++;
            }
         }return count;
    }
// Question(1423 LeetCode): Maximum points you can obtain from cards
    public static int maxScore(int[] arr, int k) {
        int leftSum=0,rightSum=0,maxSum=0,n=arr.length;
        for(int i=0;i<k;i++){
            leftSum+=arr[i];
        }maxSum=leftSum;
        int right=n-1;
        for(int i=k-1;i>=0;i--){
            leftSum-=arr[i];
            rightSum+=arr[right];
            right--;
            maxSum=Math.max(maxSum,leftSum+rightSum);
        }return maxSum;        
    }
// Question: Longest SubString atmost k distinct character
    public static int longSub(String s,int k){
        HashMap<Character ,Integer> map=new HashMap<>();
        int left=0,max=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0) map.remove(s.charAt(left));
                left++;
            }max=Math.max(max,right-left+1);
        }return max;
    }
// Question (992 LeetCode): Subarrays with k Different integers
    // Function  to find number of subarrays <=k
    public static int findSub(int[] arr,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0,count=0;
        for(int right=0;right<arr.length;right++){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            while(map.size()>k){
                map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left])==0) map.remove(arr[left]);
                left++;
            }
            count+=(right-left+1);
        }return count;
    }
    public static int goodSubArray(int[] arr,int k){
        return (findSub(arr,k)-findSub(arr,k-1));
    }
// Question(76 LeetCode): Minimum window substring]
    public static String minWindow(String s,String t){
        int n=s.length(),m=t.length();
        int[] arr=new int[128];
        for(char ch:t.toCharArray()){
            arr[ch]++;
        }
        int left=0,start=0,len=Integer.MAX_VALUE,count=0;
        for(int right=0;right<n;right++){
            char r=s.charAt(right);
            if(arr[r]>0) count++;
            arr[r]--;
            while(count==m){
                if((right-left+1)<len){
                    start=left;
                    len=right-left+1;
                }char l=s.charAt(left);
                arr[l]++;
                if(arr[l]>0) count--;
                left++;
            }
        }return (len==Integer.MAX_VALUE)?"":s.substring(start,(start+len));
    }
    public static void main(String[] args){
        int[] arr={1,2,1,2,3};
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow(s, t));
    }
}
