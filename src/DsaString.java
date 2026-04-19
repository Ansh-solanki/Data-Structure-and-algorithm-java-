import java.util.*;

public class DsaString {
//    Question 1021 Remove outermost parenthesis
    public static String removeOutermostParenthesis(String s){
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                if(count>0) sb.append(c);
                count++;
            }else{
                count--;
                if(count>0) sb.append(c);
            }
        }return sb.toString();
    }
//    Question 151 Reverse words of string
    public static String reverse(String s){
            String[] arr=s.split(" ");
            int start=0,end=arr.length-1;
            while(start<end){
                String temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }String res=String.join(" ",arr);
            return res;
    }
//    Question 1903 largest odd number in string
    public static String  largestOdd(String s){

        for(int i=s.length()-1;i>=0;i--){
            int temp=s.charAt(i)-'0';
            if(temp%2!=0) return s.substring(0,i+1);
        }return "";
    }
//    Question 14 Longest Common prefix
    public static String longestCommonPrefix(String[] arr){
        String pre=arr[0];
        for(int i=1;i<arr.length;i++){
            while(arr[i].indexOf(pre)!=0){
                pre=pre.substring(0,pre.length()-1);
                if(pre.isEmpty()) return "";
            }
        }return pre;
    }
//    Question 205 Isomorphic strings
    public static boolean isomorphicStrings(String s,String t){
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> mapst=new HashMap<>();
        HashMap<Character,Character> mapts=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char chs=s.charAt(i);
            char cht=t.charAt(i);
//          checking s to t
            if(mapst.containsKey(chs)){
                if(mapst.get(chs)!=cht) return false;
            }else{
                mapst.put(chs,cht);
            }
//            checking t to s
            if(mapts.containsKey(cht)){
                if(mapts.get(cht)!=chs) return false;
            }else{
                mapts.put(cht,chs);
            }
        }return true;

    }
//    Question 451 Sort Character by frequency
//    public static String rotateString(String s ){
//        HashMap<Character,Integer> map=new HashMap<>();
//        HashMap<Character,Integer> freq=new HashMap<>();
//        for(char ch:s.toCharArray()){
//            map.put(ch,map.getOrDefault(ch,0)+1);
//        }
//    }
//    Question 1781 Sum of Beauty of all substrings
    public static int sumOfBeautyOfAllSubstring(String s){
        int beauty=0;
        for(int i=0;i<s.length();i++){
            int[] arr=new int[26];
            for(int j=i;j<s.length();j++){
//                int[] arr=new int[26];
                char ch=s.charAt(j);
                arr[ch-'a']++;
                int max=0,min=s.length()+1;
                for(int k=0;k<26;k++){
                    if(arr[k]>0){
                        max=Math.max(max,arr[k]);
                        min=Math.min(min,arr[k]);
                    }
                }beauty+=(max-min);
            }
        }

        return beauty;
    }
//    Question 451 Sort character by frequency
    public static String sortCharacterByFrequency(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }List<Character>[] bucket=new List[s.length()+1];
        for(char c:map.keySet()){
            int freq=map.get(c);
            if(bucket[freq]==null) bucket[freq]=new ArrayList<>();
            bucket[freq].add(c);
        }
//        now iterate on decreasing order of frequency
        StringBuilder sb=new StringBuilder();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(char c:bucket[i]){
                    for(int j=0;j<i;j++){
                        sb.append(c);
                    }
                }
            }
        }return sb.toString();
    }
//    Question 13 Roman to integer
    public static int romanToInteger(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int total=0;
        for (int i=0;i<s.length();i++){
            int ch=map.get(s.charAt(i));
            if(i+1<s.length() && ch<map.get(s.charAt(i+1))){
                total-=ch;
            }else{
                total+=ch;
            }
        }return total;

    }
//    Question 8 String to atoi
    public static int stringToAtoi(String s){
        s=s.trim();
        if(s.length()==0) return 0;
        int i=0,sign=1,result=0;
        if(s.charAt(i)=='-'){
            sign=(s.charAt(i)=='-')?-1:1;
            i++;
        }while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';
            if(result>(Integer.MAX_VALUE-digit)/10){
                return (sign==1)?Integer.MAX_VALUE:Integer.MAX_VALUE;
            }result=result*10+digit;
            i++;
        }return sign*result;
    }
//  Question(Leetcode 3461). Check If Digits Are Equal in String After Operations 
    public static boolean equalStrings(String s){
        while(s.length()>2){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length()-1;i++){
                int a=s.charAt(i)-'0';
                int b=s.charAt(i+1)-'0';
                int sum=(a+b)%10;
                sb.append(sum);
            }s=sb.toString(); 
        }return s.charAt(0)==s.charAt(1);
    }
    public static void main(String[] args) {
    String s="3902";
//    String t="egg";
//    String[] arr={"flower","flow","flight"};
    System.out.println(equalStrings(s));


    }
}
