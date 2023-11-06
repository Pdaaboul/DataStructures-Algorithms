public class ShellSort {
    public static void main (String[] args){
        ShellSort s = new ShellSort();
        int[] i = {4,9,42,2,7,44,1,5,3,6,8};
        s.Sort(i);
        for (int j = 0; j < i.length;j++){
           System.out.print(" " + i[j]);
       }
    }
    private void Sort(int [] arr){

        int gap = 1;
        int N = arr.length;
        while (gap<(N/3)) gap = 3*gap + 1;
        while (gap >=1){

            for (int i = gap; i<N; i ++){
                int j = i;
                while (j >=gap && arr[j] < arr[j - gap]){
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    j-= gap;
                }
            }
            gap = gap/3;
        }

    }
}
