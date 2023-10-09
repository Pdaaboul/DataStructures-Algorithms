public class InsertionSort {
       
public static void main (String[] args){
 InsertionSort s = new InsertionSort();
 int[] i = {4,9,42,2,7,44,1,5,3,6,8};
 s.Sort(i);
 for (int j = 0; j < i.length;j++){
    System.out.print(" " + i[j]);
}
}
private void Sort(int [] arr){
    for (int i = 1; i < arr.length; i++) {  
        int j = i;
        while (j > 0 && arr[j] < arr[j - 1]) { 
            int temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
            j--;
        }
    }
}

}
