public class BubbleSort {
    

public static void main(String[] args){
    int[] arr = {34,14,48,3,11,54,2,97,78,24,1,99};
    BubbleSort s = new BubbleSort();
    s.Sort(arr);
    for (int i=0; i < arr.length; i ++){
        System.out.print(" " + arr[i]);
    }
}
public void Sort(int [] arr){
    int n = arr.length;
    for (int i = 0; i < n-1; i ++){
        for (int j =0; j < n-1;j ++){
            if(arr[j+1]<arr[j]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

}
