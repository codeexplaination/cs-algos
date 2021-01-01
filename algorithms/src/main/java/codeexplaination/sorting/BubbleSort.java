package codeexplaination.sorting;

import java.util.Arrays;

/**
 * Class explaining bubble sort algorithm
 *
 */
public class BubbleSort
{
    public static void sort(int[] input){

        int size = input.length;

        printHelper("Input array is: ", input);
        for(int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                if(input[i] < input[j]){
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        printHelper("Sorted array is: ", input);
    }

    private static void printHelper(String s, int[] input) {
        System.out.print(s);
        for(int i : input){
            System.out.print(" " + i);
        }
        System.out.println("");
    }

    public static void main( String[] args )
    {
        int[] input = {4, 2, 3, -1, 8, 5};
        sort(input);
    }
}
