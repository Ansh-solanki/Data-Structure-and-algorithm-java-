import java.util.Scanner;

public class Patterns {
    //pattern 1
    static void p1(int n){
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //pattern 2
    static void p2(int n){
        for (int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //pattern 3
    static void p3(int n){
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    //pattern 5
    static void p5(int n){
        for (int i=n;i>0;i--){
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //pattern 6
    static void p6(int n){
        for (int i=n;i>0;i--){
            for (int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    //pattern 7
    static void p7(int n){
        for (int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }for (int j=0;j<(2*i)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //pattern 8
    static void p8(int n){
        for (int i=n;i>0;i--){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }for (int j=0;j<(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //pattern 9
    static void p9(int n){
        for (int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print("  ");
            }for (int j=0;j<(2*i)+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i=n;i>0;i--){
            for(int j=0;j<n-i;j++){
                System.out.print("  ");
            }for (int j=0;j<(2*i)-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    //pattern 10
    static void p10(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            int star;
            if (i < n) {
                star = i + 1; // Increasing part
            } else {
                star = 2 * n - 1 - i; // Decreasing part
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hollowRec(int row ,int col){
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                if ((i==1)||(i==row)||(j==1)||(j==col)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void floydTriangle(int n){
        int count=0;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                count+=1;
                System.out.print(count+" ");
            }
            System.out.println();
        }
    }

    public static void zeroOneTriangle(int n){
        for (int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j) % 2 == 0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
    public static void butterfly(int n){
//        for upper half
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print("* ");
            }for(int j=1;j<=2*(n-i);j++){
                System.out.print("  ");
            }for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
//        for lower half
        for (int i=n;i>=1;i--){
            for (int j=1;j<=i;j++){
                System.out.print("* ");
            }for(int j=1;j<=2*(n-i);j++){
                System.out.print("  " );
            }for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void rhombus(int n){
        for (int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }for (int j=1;j<=n;j++){
                if((i==1)||(j==1)||(i==n)||(j==n)){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
//    Pattern 20.
    public static void pattern20(int n){
        
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n=input.nextInt();
//        p1(n);//calling p1
//        p2(n);//calling p2
//        p3(n);//calling p3
//        p5(n);
//        p6(n);
//        p7(n);
//        p8(n);
        p9(n);
//        p10(n);
//        System.out.print("Enter the values of row and column");
//        int row=input.nextInt();
//        int col=input.nextInt();
//        hollowRec(row,col);
//        floydTriangle(n);
//        zeroOneTriangle(n);
//        butterfly(n);
//        rhombus(n);
    }
}
