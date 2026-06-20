import java.util.*;
public class Leaders {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int no=sc.nextInt();
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList<?>[no];
        for(int i=0;i<no;i++){
            arr[i]=new ArrayList<>();
            int ind=sc.nextInt(); 
            for(int j=0;j<ind;j++){
                int inp=sc.nextInt();
                arr[i].add(inp);
            }
        }for(int i=0;i<no;i++){
            int n=arr[i].size();
            int max=arr[i].get(n-1);
            for(int j=n-1;j>=0;j--){
                if(arr[i].get(j)>=max){
                    max=arr[i].get(j);
                    System.out.print(max);
                }
            }System.out.println();
        }
    }
}
