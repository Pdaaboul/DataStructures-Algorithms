public class MergeSort {
    public static void main (String[] args){
        int[] arr = {12, 11, 13, 5, 6, 7,3,5,6,7,1,3,6,9};
        MergeSort s = new MergeSort();
        s.Sort(arr);
        for(int i = 0 ; i < arr.length ; i ++){
            System.out.print(" " + arr[i]);
        }
       
    }

    public void Sort(int[] arr){
        if (arr.length == 1){
            return;
        }
        int mid = arr.length / 2;
        int[] arr1 = new int[mid];
        int[] arr2 = new int[arr.length - mid]; 
        

        for (int i = 0; i < mid; i++) {
            arr1[i] = arr[i];
        }
        
     
        int counter = 0;
        for (int i = mid; i < arr.length; i++) {
            arr2[counter] = arr[i];
            counter++;
        }
        Sort(arr1);
        Sort(arr2);
        merge(arr,arr1,arr2);

}
    
    
    
    public void merge(int[]arr, int[] arr1, int [] arr2){
        int c1 = 0;
        int c2 = 0;
        int i = 0;
        while (c1 < arr1.length && c2 < arr2.length) {
            if (arr1[c1] < arr2[c2]) {
                arr[i] = arr1[c1];
                c1++;
            } else {
                arr[i] = arr2[c2];
                c2++;
            }
            i++;
        }

        while (c1 < arr1.length) {
            arr[i] = arr1[c1];
            c1++;
            i++;
        }

        while (c2 < arr2.length) {
            arr[i] = arr2[c2];
            c2++;
            i++;
        }
    }
}