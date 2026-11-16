import java.util.Scanner;

/**********************
Name(s): Jordan Lu, Joanna Li

Responsibilities Descriptions: 

Sources you used:

***********************/
public class ComparisonSort {
    public static void main(){
        Scanner scanner = new Scanner(System.in);
        int capacity;
        //TODO: ask user to enter the capacity
        System.out.print("Enter the array capacity");
        capacity = scanner.nextInt();

        //TODO: call the method createRandom and pass capacity
        int[] unsortedList = createRandom(capacity);

        //TODO: call methods of sort algorithm you implemented and Arrays.sort()
        // by passing sorted and unsorted arrays


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
            int randomNum = (int)(Math.random() * capacity);
            for (int i = 0; i <= result.length; i++){
                result[i] = randomNum;
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
        if (list.length > 0){
            for (int i = list.length-1; i>= 0; i--){
                if (list[i] < list[i-1]){
                    int temp = list[i-1];
                    list[i-1] = list[i];
                    list[i] = temp;
                }
            }
        }
        return 0;
    }
    /**
     * create merge sort using the given integer array
     * @ param: int[]
     * @ return: int number of comparison
     */
    public static int mergeSort (int[] list) {
        //TODO: implement
        return 0;
    }
}
