public class QuickSort {
    private int exchangeCounter = 0;
    private  void quickSort(int[] array, int start, int end) {

        if(end <= start) return;

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    private  int partition(int[] array, int start, int end) {

        int pivot = array[end];
        int i = start - 1;

        for(int j = start; j <= end; j++) {
            if(array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                exchangeCounter++;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        exchangeCounter++;

        return i;
    }
    public int getExchangeCounter() {
        return exchangeCounter;
    }
}

