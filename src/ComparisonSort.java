import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


/**********************
Name(s): Jordan Lu, Joanna Li

Responsibilities Descriptions: 

Sources you used: partner 

***********************/
public class ComparisonSort {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        int capacity;
        //TODO: ask user to enter the capacity
        System.out.print("Enter the array capacity: ");
        capacity = scanner.nextInt();

        //TODO: call the method createRandom and pass capacity
        int[] unsortedList = createRandom(capacity);
        if (unsortedList == null) {
            System.out.println("Capacity must be 0 or more.");
            return;
        }
        //TODO: call methods of sort algorithm you implemented and Arrays.sort()
        // by passing sorted and unsorted arrays
        int[] sortedList = Arrays.copyOf(unsortedList, unsortedList.length);
        Arrays.sort(sortedList);

        System.out.println("\n--- Unsorted list (size " + capacity + ") ---");
        runSorts(unsortedList);

        System.out.println("\n--- Sorted list (size " + capacity + ") ---");
        runSorts(sortedList);
    }

    public static void runSorts(int[] og) {
        int[] arr1 = Arrays.copyOf(og, og.length);
        int[] arr2 = Arrays.copyOf(og, og.length);
        int[] arr3 = Arrays.copyOf(og, og.length);

        long start = System.nanoTime();
        int insertionComparisons = insertionSort(arr1);
        long end = System.nanoTime();
        System.out.println("Insertion sort: " + insertionComparisons
                + " comparisons, " + (end - start) / 1_000_000_000.0 + " seconds");

        start = System.nanoTime();
        int mergeComparisons = mergeSort(arr2);
        end = System.nanoTime();
        System.out.println("Merge sort:     " + mergeComparisons
                + " comparisons, " + (end - start) / 1_000_000_000.0 + " seconds");

        start = System.nanoTime();
        Arrays.sort(arr3);
        end = System.nanoTime();
        System.out.println("Arrays.sort:    " + (end - start) / 1_000_000_000.0 + " seconds");
    }


    /**
    * create an array of size capacity with random integer values.
     * @ param: int capacity
     * @ return: int[capacity]
     */
    public static int[] createRandom (int capacity) {
        //TODO: implement
        if (capacity >= 0) {
            int[] result = new int[capacity];
            Random random = new Random();
            for (int i = 0; i < result.length; i++){
                result[i] = random.nextInt();
            }
            return result;
        }
        return null;
    }
    /**
     * create insertion sort using the given integer array
     * @ param: int[]
     * @ return: int number of comparison
     */
    public static int insertionSort (int[] list) {
        //TODO: implement
        int comparisons = 0;
        if (list.length > 0){
            for (int i = 1; i < list.length; i++){
                int temp = list[i];
                for (int j = i-1; j>=0; j--){
                    comparisons++;
                    if (temp < list[j]){
                        list[j+1] = list[j];
                        list[j] = temp;
                    }else{
                        break;
                    }
                }

            }
        }
        return comparisons;
    }
    /**
     * create merge sort using the given integer array
     * @ param: int[]
     * @ return: int number of comparison
     */
    public static int mergeSort (int[] list) {
        //TODO: implement


        if (list.length <= 1) {return 0;}
        int middle = list.length/2;
        int comparisons = 0;
        int[] arr1 = Arrays.copyOfRange(list, 0, middle);
        int[] arr2 = Arrays.copyOfRange(list, middle, list.length);

        comparisons += mergeSort(arr1);
        comparisons += mergeSort(arr2);
        comparisons += merge(list, arr1, arr2);
        return comparisons;
    }
    public static int merge(int[] list, int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0, comparisons = 0;

        while (arr1.length > i && arr2.length > j) {
            comparisons++;
            if (arr1[i] <= arr2[j]) {
                list[k] = arr1[i];
                i++;
            } else {
                list[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (arr1.length > i) {
            list[k] = arr1[i];
            i++;
            k++;
        }

        while (arr2.length > j) {
            list[k] = arr2[j];
            j++;
            k++;
        }
        return comparisons;
    }
}
