import java.util.*;
public class revision {
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void removeDuplicates(int[] arr){
        int i=0;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]!=arr[i]){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }printArr(arr);
    }

    static int moveAllZero(int[] arr){
        int i=0;
        int k=0;
        for(int j=0;j<arr.length;j++){
            if(i!=j){
                if(arr[i]!=arr[j]){
                    if(arr[i]==0){
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }i++;
                }
            }
        }printArr(arr);
        return i;
    }

    static int maxConsecutiveOnes(int[] arr){
        int count=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                max=Math.max(max, ++count);
            }else count=0;
        }return max;
    }

    static int longestSubarrayWithSumK(int[] arr,int k){
        int max=Integer.MIN_VALUE;
        int left=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            while(sum>k){
                sum-=arr[left];
                left++;
            }if(sum==k){
                max=Math.max(i-left+1,max);
            }
        }return max;
    }

    static int longestSubarrayWithSumKPrefix(int[] arr,int k){
        int sum=0;
        int len=Integer.MIN_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int x=sum-k;
            if(sum==k) len=i+1;
            if(map.containsKey(x)){
                len=Math.max(len,i-map.get(x));
            }
            if(!map.containsKey(sum)) map.put(sum,i);
        }return len;
    }

    static int[] twoSum(int[] arr, int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int comp=target-arr[i];
            if(map.containsKey(comp)) return new int[]{i,map.get(comp)};
            map.put(arr[i],i);
        }return new int[]{-1,-1};
    }

    static void sortArray012(int[] arr){
        int mid=0,low=0,high=arr.length-1;
        while(mid<high){
            if(arr[mid]==1) mid++;
            if(arr[mid]==0){
                swap(arr, mid, low);
                low++;
            }if(arr[mid]==2){
                swap(arr, mid, high);
                high--;
            }
        }printArr(arr);
    }
// Recurssion
    static void generateAllBinaryStirngs(int n, ArrayList<String> list,String s){
        if(n<=0){
            list.add(s);
            return;
        }n--;
        generateAllBinaryStirngs(n, list, s+'0');
        if(s.length()==0 || s.charAt(s.length()-1)=='0'){
            generateAllBinaryStirngs(n, list, s+'1');
        }
    }

    static void generateParenthesis(int n,List<String> list,String s,int o,int c){
        if(s.length()==2*n){
            list.add(s);
            return;
        }
        if(o<n){
            generateParenthesis(n, list, s+'(', o+1, c);
        }if(c<o){
            generateParenthesis(n, list, s+')', o, c+1);
        }
    }

    static void subsequences(String s,StringBuilder curr,List<String> list,int i){
        if(i==s.length()){
            list.add(curr.toString());
            return;
        }
        subsequences(s, curr.append(s.charAt(i)), list, i+1);
        curr.deleteCharAt(curr.length()-1);
        subsequences(s, curr, list, i+1);
    }

    static void subsequencesWithSumK(int[] arr,int k,List<List<Integer>> res ,List<Integer> list,int i){
        if(k==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(k<0 || i>=arr.length) return;
        list.add(arr[i]);
        subsequencesWithSumK(arr, k-arr[i], res, list, i+1);
        list.remove(list.size()-1);
        subsequencesWithSumK(arr, k, res, list, i+1);
    }
    static int generateSum(int[] nums,List<Integer> arr,int sum,int count,int i){
        if(count==sum){
            // list.add(new ArrayList<>(arr));
            return 1;
        }if(count>sum || i>=nums.length) return 0;
        arr.add(nums[i]);
        int x=generateSum(nums, arr, sum, count+arr.get(arr.size()-1), i+1);
        arr.remove(arr.size()-1);
        int y=generateSum(nums, arr, sum, count, i+1);
        return x+y;
    }
   
    static boolean generateSum2(int[] nums,int k,int i){
        if(i==nums.length){
            return k==0;
        }
        boolean x=generateSum2(nums, k-nums[i], i+1);
        boolean y=generateSum2(nums, k, i+1);
        return x || y;
    }
    
    static void candidateSum(int[] nums,List<List<Integer>> list,List<Integer> arr,int target,int i){
        if(target==0){
            list.add(new ArrayList<>(arr));
            return;
        }
        if(target<0 || i>=nums.length) return;
        if(target>0){
            arr.add(nums[i]);
            candidateSum(nums, list, arr, target-nums[i], i);
            arr.remove(arr.size()-1);
        }
        candidateSum(nums, list, arr, target, i+1);
    }
 
    
    public static void main(String[] args){
        int[] arr={2,3,6,7};
        int k=7;
        String s="ABC";
        List<List<Integer>> res=new ArrayList<>();
        candidateSum(arr, res,new ArrayList<>(), k, 0);
        System.out.println(res);
    }    
}
