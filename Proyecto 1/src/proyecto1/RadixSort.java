
package proyecto1;

public class RadixSort {
    public void radixString(String texto){
        
        String arr2[] = texto.split(",");
        int arr[] = new int [arr2.length];
        
        //Aun no arreglar
        System.out.println("text" +  texto);
        System.out.println("arr2[0]=" + arr2[0]);
        //-1 del "arr2.length" genera problemas preguntar al maestro
        for(int i = 0; i < arr2.length -1; i++){
            System.out.println("arr2[i]" + arr2[i]);
            arr[i] = Integer.parseInt(arr2[i]);
        }
        radixx(arr);
    }
    public void radixx(int[] arr){
        
        int n = arr.length, i, j, temp=0, valor=0;
        
        int q0[]=new int[n];
        int q1[]=new int[n];
        int q2[]=new int[n];
        int q3[]=new int[n];
        int q4[]=new int[n];
        int q5[]=new int[n];
        int q6[]=new int[n];
        int q7[]=new int[n];
        int q8[]=new int[n];
        int q9[]=new int[n];
        
        sort(arr,q0,q1,q2,q3,q4,q5,q6,q7,q8,q9, 1);
        sort(arr,q0,q1,q2,q3,q4,q5,q6,q7,q8,q9, 2);
        sort(arr,q0,q1,q2,q3,q4,q5,q6,q7,q8,q9, 3);
        sort(arr,q0,q1,q2,q3,q4,q5,q6,q7,q8,q9, 4);
       
    }
    public void sort(int[] arr, int[] q0, int[] q1,int[] q2,int[] q3
            ,int[] q4,int[] q5,int[] q6,int[] q7,int[] q8,int[] q9, int key){
        
        int temp, valor, i, n = arr.length;
        int c0=0,c1= 0, c2=0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0, cx=0;
        
        for( i = 0; i < n; i++){
            temp = arr[i];
            valor = posicion(key, temp);
            switch (valor) {
                case 0:
                    q0[c0] = arr[i];
                    c0 += 1;
                    break;
                case 1:
                    q1[c1] = arr[i];
                    c1 += 1;
                    break;
                case 2:
                    q2[c2] = arr[i];
                    c2 += 1;
                    break;
                case 3:
                    q3[c3] = arr[i];
                    c3 += 1;
                    break;
                case 4:
                    q4[c4] = arr[i];
                    c4 += 1;
                    break;
                case 5:
                    q5[c5] = arr[i];
                    c5 += 1;
                    break;
                case 6:
                    q6[c6] = arr[i];
                    c6 += 1;
                    break;
                case 7:
                    q7[c7] = arr[i];
                    c7 += 1;
                    break;
                case 8:
                    q8[c8] = arr[i];
                    c8 += 1;
                    break;
                case 9:
                    q9[c9] = arr[i];
                    c9 += 1;
                    break;
            }
        }
        for(i=0;i<n;i++){
          
            if (q1[i] != 0) {
                arr[cx] = q1[i];
                cx += 1;
            }
        }
        for(i=0;i<n;i++){
          
            if (q2[i] != 0) {
                arr[cx] = q2[i];
                cx += 1;
            }
        }
        for(i=0;i<n;i++){
          
            if (q3[i] != 0) {
                arr[cx] = q3[i];
                cx += 1;
            }
        }
        for(i=0;i<n;i++){
          
            if (q4[i] != 0) {
                arr[cx] = q4[i];
                cx += 1;
            }
        }
        for(i=0;i<n;i++){
          
            if (q5[i] != 0) {
                arr[cx] = q5[i];
                cx += 1;
            }
        }
        for(i=0;i<n;i++){
          
            if (q6[i] != 0) {
                arr[cx] = q6[i];
                cx += 1;
            }
        }
        for(i=0;i<n;i++){
          
            if (q7[i] != 0) {
                arr[cx] = q7[i];
                cx += 1;
            }
        }
        for(i=0;i<n;i++){
          
            if (q8[i] != 0) {
                arr[cx] = q8[i];
                cx += 1;
            }
        }
        for(i=0;i<n;i++){
          
            if (q9[i] != 0) {
                arr[cx] = q9[i];
                cx += 1;
            }
        }
        
        System.out.println("iteracion");
        System.out.println("Colas auxiliares:");
        System.out.println("q0=");
        printArrayint(q0);
        System.out.println("q1=");
        printArrayint(q1);
        System.out.println("q2=");
        printArrayint(q2);
        System.out.println("q3=");
        printArrayint(q3);
        System.out.println("q4=");
        printArrayint(q4);
        System.out.println("q5=");
        printArrayint(q5);
        System.out.println("q6=");
        printArrayint(q6);
        System.out.println("q7=");
        printArrayint(q7);
        System.out.println("q8=");
        printArrayint(q8);
        System.out.println("q9=");
        printArrayint(q9);
        System.out.println("Arreglo=");
        printArrayint(arr);
        //reiniciar variables
        cero(q0);
        cero(q1);
        cero(q2);
        cero(q3);
        cero(q4);
        cero(q5);
        cero(q6);
        cero(q7);
        cero(q8);
        cero(q9);
        //c1=c2=c3=c4=c5=c6=c7=c8=c9=cx=0;
    }
    public int posicion (int key, int tempV){
        
        int res = 0;
        switch(key){
            case 1:
                res = (tempV%10);
                break;
            case 2:
                res = (tempV%100)/10;
                break;
            case 3:
                res = (tempV%1000)/100;
                break;
            case 4:
                res = (tempV%10000)/1000;
                break;
        }
        
        return res;
    }
    public  void printArrayint(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public void cero(int q[]) {
        int n = q.length, i;
        for (i = 0; i < n; i++) {
            q[i] = 0;
        }
    }
}
