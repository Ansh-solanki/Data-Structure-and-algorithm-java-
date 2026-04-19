import java.util.*;
public class Hashing {
    public static void toCountChar(String s,int q){
        Scanner sc=new Scanner(System.in);
        int[] hash=new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        while(q>0){
            char ch=sc.nextLine().charAt(0);
            System.out.println(hash[ch-'a']);
            q--;
        }
    }
    public static int majorityElement(int[] arr){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>arr.length/2){
                return num;
            }
        }throw new IllegalArgumentException("No majority element found");

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={1,1,1,2,2,1};
//        System.out.print("Enter a string: ");
//        String s=sc.nextLine();
//        System.out.println();
//        System.out.print("Enter the number of turns: ");
//        int q=sc.nextInt();
//        toCountChar(s,q);
        System.out.println(majorityElement(arr));
    }
}
