public class Exercise4 {
/*

- Merge Sort has a time complexity of O(n log n).
- Binary Search have a time complexity of O(log n)
- The twoSum Method has a time complexity of O(n log n) for the merge sort,
and n times O(log n) for n binary searches, giving a total time complexity of O(n log n).
-The overall time complexity of the entire algorithm is therefore O(n log n).
 */


    public static void main(String args[]) {
        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};
        Exercise4 ex = new Exercise4();
        System.out.println(ex.twoSum(array,10));
    }

    // Total runtime: O(n log n)
    private boolean twoSum(int[] arr,int k){
        mergeSort(arr);  // Runtime: O(n log n)
        for (int i = 0; i < arr.length; i++) {  // Loop runs n times
            int temp = k - arr[i];
            if(binarySearch(arr,temp)) {  // Runtime: O(log n)
                return true;
            };
        }
        return false;
    }

    // Total runtime: O(n log n)
    private void mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) return;
        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        for(int i = 0; i < length; i++) {  // Loop runs n times
            if(i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[i - middle] = array[i];
            }
        }
        mergeSort(leftArray);  // Recursive call 1: O(n log n)
        mergeSort(rightArray); // Recursive call 2: O(n log n)
        merge(leftArray, rightArray, array);  // Merge operation: O(n)
    }

    // Runtime: O(n)
    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int i = 0, l = 0, r = 0;
        while(l < leftArray.length && r < rightArray.length) {  // Loop runs n times
            if(leftArray[l] < rightArray[r]) {
                array[i++] = leftArray[l++];
            } else {
                array[i++] = rightArray[r++];
            }
        }
        while(l < leftArray.length) { array[i++] = leftArray[l++]; }
        while(r < rightArray.length) { array[i++] = rightArray[r++]; }
    }


    //O(log n)
    private boolean binarySearch(int[] arr, int key) {
        return binarySearchHelper(arr, 0, arr.length / 2, arr.length - 1, key); //O(log n)
    }


  // O(log n)
    private boolean binarySearchHelper(int[] arr, int start, int mid, int end, int key) {
        if (end <= start) {
            return key == arr[end];
        }
        if (arr[mid] == key) {
            return true;
        }
        if (key > arr[mid]) {
            return binarySearchHelper(arr, mid + 1, (end + mid) / 2, end, key);
        } else {
            return binarySearchHelper(arr, start, (start + mid) / 2, mid - 1, key);
        }
    }
}
