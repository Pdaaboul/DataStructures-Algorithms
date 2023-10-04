import java.util.Random;

public class QuickSort {
    private int exchangeCounter = 0;


    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();


        int[] reversedArray = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sorter.quickSort(reversedArray, 0, reversedArray.length - 1);
        System.out.println("Exchanges in reversed array: " + sorter.getExchangeCounter());
        sorter.resetExchangeCounter();
        //Exchanges in reversed array: 109


        int[] arrayForSmallestPivot = {45, 23, 11, 89, 77, 98, 4, 28, 65, 97, 12, 35, 64, 56, 21, 79, 10, 93, 51, 3};
        sorter.quickSort(arrayForSmallestPivot, 0, arrayForSmallestPivot.length - 1);
        System.out.println("Exchanges with smallest pivot: " + sorter.getExchangeCounter());
        sorter.resetExchangeCounter();
        //Exchanges with the smallest pivot: 41



        int[] arrayForGreatestPivot = {18, 3, 21, 42, 9, 27, 53, 66, 12, 4, 19, 56, 31, 10, 8, 33, 47, 55, 29, 67};

        sorter.quickSort(arrayForGreatestPivot, 0, arrayForGreatestPivot.length - 1);
        System.out.println("Exchanges with greatest pivot: " + sorter.getExchangeCounter());
        sorter.resetExchangeCounter();
        //Exchanges with the greatest pivot: 66



        Random rand = new Random();
        int[] randomArray = new int[20];
        for (int i = 0; i < 20; i++) {
            randomArray[i] = rand.nextInt(50);
        }
        sorter.quickSort(randomArray, 0, randomArray.length - 1);
        System.out.println("Exchanges in randomly sorted array: " + sorter.getExchangeCounter());
        sorter.resetExchangeCounter();


        //Exchanges in randomly sorted array: 50
    }


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
//                System.out.println("Exchange 1: Swapping array[" + i + "]=" + array[i] + " with array[" + j + "]=" + array[j]);
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
    private int getExchangeCounter() {
        return exchangeCounter;
    }
    private void resetExchangeCounter() {
        exchangeCounter = 0;
    }

}

