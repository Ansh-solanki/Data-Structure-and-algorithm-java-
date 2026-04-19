import java.util.Scanner;

public class Main {
    public static boolean isPrime(int n) {
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                return false;

            }
        }return true;
    }
    public static int prime(int a, int b){
        if (a>b) prime(b,a);
        for (int i=a;i<=b;i++){
            if (isPrime(i)){
                System.out.print(i+" ");
            }
        }return 0;
    }
    public static int binaryToDecimal(int n){
        int r=0,i=0;
        while(n!=0){
            if((n%10!=1)&&(n%10!=0)){
                System.out.println("Entered number is not binary");
                return 0;
            }if(n%10==1){
                r+=(int)Math.pow(2,i);
            }n/=10;
            i++;
        }return r;
    }
    public static int decTobin(int n){
        int res=0;
        int i=0;
        while(n!=0){
            int rem=(n%2);
            res=(res+rem*(int)Math.pow(10,i));
            i++;
            n/=2;
        }return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        System.out.print("Enter any number: ");
//        int n=sc.nextInt();
//        System.out.println(isPrime(n));                             //calling isPrime for a single variable
//        System.out.print("Enter the range to find prime number in between:");
//        int a= sc.nextInt();
//        int b=sc.nextInt();
//        prime(a,b);                                                 //Calling prime function in a given range
//        System.out.print("Enter a binary number:");
//        int bin= sc.nextInt();
//        System.out.println(binaryToDecimal(bin));
        System.out.print("Enter a decimal:");
        int dec=sc.nextInt();
        System.out.println(decTobin(dec));
    }
}