
package Polifase;


public class BubbleSort {
    public int[] bubbleSort(int []A){
        int size=A.length;
        for (int i = 0; i < size-1; i++) {
            boolean intercambio=true;
            for (int j = 0; j < size-i-1; j++) {
                if(A[j]>A[j+1]){
                    int temp=A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                    
                    intercambio=false;
                }
                
            }
         if(intercambio==true){
             break;
         }
        }
        return A;
    }
}
