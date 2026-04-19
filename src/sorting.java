import java.util.Scanner;

public class sorting {
    public static void printArray(int[] arr){
        for (int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }
    // public static void bubbleSort(int[] arr) {
    //     for(int i=0;i<arr.length-1;i++){
    //         for(int j=0;j<arr.length-1-i;j++){
    //             if (arr[j] > arr[j+1]) {
    //                 int temp=arr[j];
    //                 arr[j]=arr[j+1];
    //                 arr[j+1]=temp;
    //             }
    //         }
    //     }printArray(arr);
    // }
    // public static void selectionSort(int[] arr){
    //     int minIndex;
    //     for(int i=0;i<arr.length-1;i++){
    //         minIndex=i;
    //         for(int j=i+1;j<arr.length;j++){
    //             if(arr[j]<arr[minIndex]) minIndex=j;
    //         }int temp=arr[minIndex];
    //         arr[minIndex]=arr[i];
    //         arr[i]=temp;
    //     }printArray(arr);
    // }

// //    public static void insertionSort(int[] arr) {
// //        for(int i=0;i<arr.length;i++){
// //            for(int j=i+1;j>0;j--){
// //                if (arr[j]<arr[j-1]){
// //                    int temp=arr[j];
// //                    arr[j]=arr[j-1];
// //                    arr[j-1]=temp;
// //                }
// //            }
// //        }printArray(arr);
// //    }
//     public static void insertionSort(int[] arr){
//         for(int i=1;i<arr.length;i++){
//             int prev=i-1;
//             while(prev>=0){
//                 if(arr[prev+1]<arr[prev]){
//                     int temp=arr[prev+1];
//                     arr[prev+1]=arr[prev];
//                     arr[prev]=temp;
//                 }
//                 prev--;
//             }
//         }printArray(arr);
//     }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

// Bubble sort
    // Repeatedly swap adjacent elements if they are in the wrong order.
    public static void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }printArray(arr);
    }

// Selection sort
    // Find the minimum element and put it in the correct position.
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]) min=j;
            }swap(arr, i, min);
        }printArray(arr);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={5,4,1,3,2};
//        int n= sc.nextInt();
//        int[] arr=new int[n];
//        System.out.print("Enter the elements of array");
//        for(int i=0;i<n;i++){
//            arr[i]=sc.nextInt();
//        }
//        bubbleSort(arr);
//        selectionSort(arr);
        selectionSort(arr);
    }
}
