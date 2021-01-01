package codeexplaination.sorting;

/**
 * Class explaining insertion sort algorithm
 */
public class InsertionSort {
    public static void sort(int[] input) {

        printHelper("Input array is: ", input);
        int size = input.length;
        for (int i = 1; i < size; ++i) {
            int key = input[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
        printHelper("Sorted array is: ", input);
    }

    private static void printHelper(String s, int[] input) {
        System.out.print(s);
        for (int i : input) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] input = {4, 2, 3, -1, 8, 5};
        sort(input);
    }
}
