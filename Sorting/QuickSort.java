public class QuickSort {
    
    public static void main (String[] arg){
        int[] arr = {34,14,48,3,11,54,2,97,78,24,1,99};
        QuickSort s = new QuickSort();
        s.Sort(arr);
        for (int i = 0; i < arr.length; i ++){
            System.out.print(" " + arr[i]);
        }
       
    }
    public void Sort(int[] arr){
        SortHelper(arr,0,arr.length-1);
    }
    public void SortHelper(int[] arr,int start, int end){
        if (start>=end){
            return;
        }
        int pivot = Partition(arr, start, end);
        SortHelper(arr,start,pivot-1);
        SortHelper(arr, pivot +1, end);
    }
    public int Partition(int[] arr, int start, int end){
      int pivotIndex =  end ;
      int i = start -1;
      
      for (int j = start; j <= pivotIndex; j++){
        if (arr[j] <= arr[pivotIndex]){
            i++;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
    return i;


    }
}
