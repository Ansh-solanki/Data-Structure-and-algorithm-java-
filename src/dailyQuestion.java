import java.util.*;
public class dailyQuestion {
// Question (2048 leetcode): Next Greater Numerically Balanced Number
    public static boolean count(int n){
        int[] arr=new int[10];
        int temp=n;
        while(temp>0){
            arr[temp%10]++;
            temp/=10;
        }temp=n;
        while(temp>0){
            int d=temp%10;
            if(arr[d]!=d) return false;
            temp/=10;
        }return true;
    }
    public static int nextBeautifulNumber(int n){
        while(true){
            n=n+1;
            if(count(n)) break;
        }return n;
    }
// Question(20 LeetCode): Valid Parentheses
    public static boolean validPar(String s){
        Stack<Character> stack =new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='[') stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                char top=stack.pop();
                if((ch==')' && top!='(')||
                (ch=='}' && top!='{')||
                (ch==']' && top!='[')){
                    return false;
                }
            }
        }return true;
    }
// Question(2025 LeetCode): Number of laser beams in a bank;
    public static int laserBeams(String[] bank){
        int prev=0;
        int beam=0;
        for(String s:bank){
            int count=0;
            for(char ch:s.toCharArray()){
                if((ch-'0')==1) count++;
            }if(count==0) continue;
            if(prev>0) beam+=prev*count;
            prev=count;
        
        }return beam;
    }
// Question (3354 LeetCode): Make Array element equal to zero
    public static boolean satisfy(int[] temp,int curr,int dir){
        int[] arr=temp.clone();
        while(curr>=0&&curr<arr.length){
            if(arr[curr]==0){
                curr+=dir;
            }else{
                arr[curr]--;
                dir*=-1;
                curr+=dir;
            }
        }for(int val:arr){
            if(val!=0) return false;
        }return true;
    }
    // function for Make Array element equal to zero
    public static int countValidSelections(int[] arr){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                if(satisfy(arr, i,1)) ans++;
                if(satisfy(arr, i, -1)) ans++;
            }
        }return ans;
    }
    public static int maximizeExpressionOfThree(int[] nums) {
        int min=Integer.MAX_VALUE;
        int a=-1,b=-1;
        for( int val:nums){
            if(val<min){
                min=val;
                continue;
            }if(val>a){
                b=a;
                a=val;
            }if(val>b&&val<a){
                b=val;
            }
        }return (a+b-min);
    }
    public static int minLengthAfterRemovals(String s) {
        int count=0;
        for(int r=0; r<s.length();r++){
            char ch=s.charAt(r);
            if(ch=='a') count++;
            if(ch=='b') count--;
        }return Math.abs(count);
    }
    public static int minimumFlips(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            sb.append(n%2);
            n=n/2;
        }String ori=sb.toString();
        String s=sb.reverse().toString();
        int count=0;
        for(int i=0;i<sb.length();i++){
            char c=ori.charAt(i);
            char ch=s.charAt(i);
            if(c!=ch) count++;
        }return count;
    }

//  function
    public static int check(String s){
        if(s.length()<3)return 0;
        int count=0;
        for(int i=1;i<s.length()-1;i++){
            char ch=s.charAt(i);
            if(s.charAt(i-1)<ch&&s.charAt(i+1)<ch) count++;
            if(s.charAt(i-1)>ch&&s.charAt(i+1)>ch) count++;
        }return count;
    }
    public static int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++){
            count+=check(String.valueOf(i));
        }return count;
    }
    public static long sumAndMultiply(int n) {
        long num=0;
        long sum=0;
        int i=1;
        while(n>0){
            if(n%10!=0){
                num=num+((n%10)*i);
                sum+=(n%10);
                i*=10;
            }
            n/=10;
        }return sum*num;
    }
    
//  Complete prime number 
    public static boolean prime(int n){
        if(n==1||n==2||n==3) return true;
        for(int i=2;i<=n/2;i++){
            if((n%i)==0) return false;
        }return true;
    }public static boolean comPrime(int n){
        String s=Integer.toString(n);
        for(int i=1;i<s.length();i++){
            int pre=Integer.parseInt(s.substring(0,i));
            if(!prime(pre)) return false;
        }for(int i=1;i<s.length();i++){
            int suff=Integer.parseInt(s.substring(s.length()-i));
            if(!prime(suff)) return false;
        }return true;
    }
// Question : Minimum operations to make a binary palindrome
    public static int binary(int n){
        int bin=0;
        while(n!=0){
            bin=(bin*10)+(n%2);
            n=n/10;
        }return bin;
    }public static boolean palindrome(int n){
        int rev=0;
        int pre=n;
        while(n!=0){
            rev+=n%10;
            n=n/10;
        }if(rev==pre) return true;
        return false;
    }
    // public static int[] minO(int[] arr){
    //     for(int val:arr){
    //         int count=0;
    //         int bin=binary(val);
            
            
    //     }
    // }
// Question (3583LeetCode): Count Special triplets
    // Function to find i, j and k
    public static int findIJK(int[] arr,int ind,int ele){
        int i=0,j=0;
        for(int p=0;p<arr.length;p++){
            if(arr[p]==(ele*2)){
                if(p<ind) i++;
                else j++; 
            }
        }return i*j;
    }
    public static int specialTri(int[] arr){
        int count=0;
        for(int p=1;p<arr.length-1;p++){
            count+=findIJK(arr, p, arr[p]);
        }return count;
    }
    // Another approach
    public static int specialTri2(int[] arr){
        final long mod=1_000_000_007L;
        long ans=0L;
        HashMap<Integer,Integer> left=new HashMap<>();
        HashMap<Integer,Integer> right=new HashMap<>();
        for(int x:arr){
            right.put(x, right.getOrDefault(x, 0)+1);
        }for(int i=0;i<arr.length;i++){
            int x=arr[i];
            right.put(x, right.get(x)-1); 
            if(right.get(x)==0) right.remove(x);
            int target=2*x;
            long lcount=left.getOrDefault(target, 0);
            long rcount=right.getOrDefault(target, 0);
            ans=(ans+(lcount*rcount)%mod)%mod;
            left.put(x, left.getOrDefault(x, 0)+1);
        }return (int)ans;
    }
//    Question:Absolute Difference Between Maximum and Minimum K Elements
    public static  int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int largest=0,smallest=0;
        for(int i=0;i<k;i++){
            smallest+=nums[i];
            largest+=nums[nums.length-i-1];
        }return Math.abs(largest-smallest);
    }
    public  static  String checkVowel(String s,int k){
        StringBuilder sb=new StringBuilder(s);
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') count++;
        }if(count!=k) return s;
        return sb.reverse().toString();
    }
    public static String reverseWords(String s) {
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch==' ') break;
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') count++;
        }String[] arr=s.split(" ");
        for(int i=1;i<arr.length;i++){
            arr[i]=checkVowel(arr[i],count);
        }String sb=String.join(" ",arr);
        return sb;
    }

    public static long minMoves(int[] balance) {
        int pos=0,neg=0;
        for(int val:balance){
            if(val<0) neg+=val;
            else pos+=val;
        }if(pos>neg) return neg;
        return -1;
    }

//    (20-12-2025):1:Minimum Number of Operations to Have Distinct Elements
    public static boolean isDup(List<Integer> list){
        HashSet<Integer> set=new HashSet<>();
        for(int val:list){
            set.add(val);
        }return (set.size()!=list.size())?true:false;
    }
    public static int minOperations(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int val:arr){
            list.add(val);
        }int count=0;
        while(list.size()>0){
            if(isDup(list)){
                for(int i=0;i<3;i++){
                    list.remove(0);
                }count++;
            }else break;
        }return count;
    }
//  (21-12-2025):1: Mirror distance of integer
    public static int mirrorDistance(int n) {
        String s=String.valueOf(n);
        String revStr=new StringBuilder(s).reverse().toString();
        int rev=Integer.parseInt(revStr);
        return Math.abs(n-rev);

    }

    // 28-12-2025 (Que 1) Maximum score of a split
    public static  long maximumScore(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Long> prefix = new HashMap<>();
        HashMap<Integer, Long> suffixMin = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix.put(i, sum);
        }
        long minVal = Long.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            minVal = Math.min(minVal, nums[i]);
            suffixMin.put(i, minVal);
        }

        long maxScore = Long.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            long score = prefix.get(i) - suffixMin.get(i + 1);
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }

    public static int[] bestTower(int[][] towers, int[] center, int radius) {
        int x=0,y=0,q=-1;
        int r=radius*radius;
        for(int i=0;i<towers.length;i++){
            int dx=(towers[i][0]-center[0]);
            int dy=(towers[i][1]-center[1]);
            int sum=dx*dx + dy*dy;
            if(sum<=r){
                if(towers[i][2]>q||
                    (towers[i][2]==q&&
                        (towers[i][0]<x||
                            (towers[i][0]==x&&towers[i][1]<y)))){
                    x=towers[i][0];
                    y=towers[i][1];
                    q=towers[i][2];
                }
            }
        }
        return new int[]{x,y};
    }
    public static int computePolyValue(int[] arr,int n,int x){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int val=arr[i]*(int)(Math.pow(x, n-i));
            sum+=val;
        }return sum;
    }public static void antiDiagonal(int[][] matrix){
        int n=matrix.length-1;
        for(int i=n,j=0;i>=0&&j<=n;i--,j++){
            System.out.print(matrix[i][j]+" ");
        }
    }

    public static int avg(int[] nums,int i){
        int sum=0;
        int len=nums.length-i;
        while(i<nums.length){
            sum+=nums[i];
        }return sum/len;
    }
    public static int dominantIndices(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>avg(nums,i+1)) count++;
        }return count;
    }
//  Find Score difference in a game
    public static int scoreDifference(int[] nums) {
        boolean first = true;
        boolean second = false;
        int firstPoint = 0;
        int secondPoint = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0||i==6){
                first=!first;
                second=!second;
            }if(first) firstPoint+=nums[i];
            else secondPoint+=nums[i];
        }return firstPoint-secondPoint;
    }
// Q3. Minimum XOR Path in a Grid©leetcode
    // static int min=Integer.MAX_VALUE;
    static int minimumXOR(int[][] grid,int i,int j,int m,int n,int el,int[][] dp){
        if(i==m-1 && j==n-1){
            return el;
        }if(dp[i][j]!=-1) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        if(i!=m-1){
            ans=Math.min(ans,minimumXOR(grid, i+1, j, m, n, el^grid[i+1][j],dp));
        }if(j!=n-1){
            // el^=grid[i][j+1];
            ans=Math.min(ans,minimumXOR(grid, i, j+1, m, n, el^grid[i][j+1],dp));
        }dp[i][j]= ans;
        return ans;
    }
    // Dynamic programming solution
    static int minimumXOR2(int[][] grid,int[][]dp){
        int m=grid.length;
        int n=grid[0].length;
        int min=dp[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[0][0]=grid[0][0];
                    continue;
                }if(i==0){
                    dp[i][j]=grid[i][j]^dp[i][j-1];
                }else if(j==0){
                    dp[i][j]=grid[i][j]^dp[i-1][j];
                }else{
                    dp[i][j]=grid[i][j]^Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] arr={{1,2},{3,4}};
        int[][] dp=new int[arr.length][arr[0].length];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        // System.out.println(minimumXOR(arr, 0, 0, arr.length, arr[0].length,arr[0][0],dp));
        System.out.println(minimumXOR2(arr,dp));
    }
}
