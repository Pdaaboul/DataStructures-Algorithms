class SelectionSort{
   
    private void Sort(int[] arr){
        for (int i =0; i < arr.length ; i ++){
            int min = i;
            for (int j = i + 1; j <arr.length;j ++){
                if( arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = min;
            arr[min] = arr[i];
            arr[i] = arr[temp];
            
        }
    }
    public static void main (String[] args){
        SelectionSort s = new SelectionSort();
        int[] i = {4,9,42,2,7,44,1,5,3,6,8};
        s.Sort(i);
        for (int j = 0; j < i.length;j++){
            System.out.print(" " + i[j]);
        }
    }
}