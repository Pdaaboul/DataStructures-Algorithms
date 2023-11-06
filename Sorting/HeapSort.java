public  class HeapSort{
public static void main (String[] args){
int[] arr = {0,5, 10,1000, 15, 20, 25, 30, 35, 40,4,9,16};
HeapSort s = new HeapSort();
s.Sort(arr);
for (int i = 0; i < arr.length; i ++){
    System.out.print( " " + arr[i]);
}

}



public void Heapify (int[] arr){
for (int i = ((arr.length)/2 ); i >0 ; i --){
    Sink(arr,i,arr.length-1);
}}
public void Sort(int[] arr){
    Heapify(arr);
    
    int counter = arr.length - 1;
    
    while (counter > 0){
        int temp = arr[counter];
        arr[counter] = arr[1];
        arr[1] = temp;
        counter --;
        Sink(arr,1,counter);
    }
}





public void Sink(int[] arr, int i, int n){
  
    int left = 2 * i;
    int right = 2 * i + 1;


    if (left > n || i > n) return;

    int largest = i;

    if (left <= n && arr[left] > arr[largest]) {
        largest = left;
    }

    if (right <= n && arr[right] > arr[largest]) {
        largest = right;
    }

    if (largest == i) return;

    int temp = arr[i];
    arr[i] = arr[largest];
    arr[largest] = temp;

    Sink(arr, largest, n);
    
    
}
public void Swim(int[] arr, int i ){

if (i/2 == 0 || arr[i] <= arr[i/2] ){
    return;
}
else if ( arr[i/2] < arr[i]){
    int temp = arr[i];
    arr[i] = arr[i/2];
    arr[i/2] = temp;
    Swim(arr, i /2);
}
}



}