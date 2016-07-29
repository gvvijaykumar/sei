//package com.practice.algorithms;

/**
 ** Created by vijaygolla on 7/29/2016.
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * @author Vijay Golla
 *         This class has3 different implementations for the given problem stament to remove duplicate elements from an unsorted array.
 *         This Implementations has used Arrays class methods for best performance where necessary.
 */
public class RemoveDuplicateIntegers {

    public int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3,
            20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19,
            13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};

    /**
     * Main method which invokes 3 different methods of solution for the problem statement.
     */
    public static void main(String[] args) {
        try {
            RemoveDuplicateIntegers removeDuplicateIntegers = new RemoveDuplicateIntegers();
            System.out.println("\n");
            removeDuplicateIntegers.removeAllDuplicatesAndMaintainOrder();
            System.out.println("\n");
            removeDuplicateIntegers.removeAllDuplicates();
            System.out.println("\n");
            removeDuplicateIntegers.removeAllDuplicatesAndSort();
        } catch (Exception e) {
            System.out.println("Exception Occurred while removing the duplicate integers :");
            e.printStackTrace();
        }
    }

    /**
     * Solution: 1
     * Achieves the goal in O(n) efficiency and Maintains the order of elements
     *
     */

    /**
     * @return int[]
     * @throws Exception
     */
    private int[] removeAllDuplicatesAndMaintainOrder() throws Exception {
        int[] original = randomIntegers;
        System.out.println("Original Array =                 " + Arrays.toString(original));
        Set<Integer> uniqueSet = new HashSet<Integer>();
        int[] finalArray = new int[original.length];
        int i = 0;

        for (int element : original) {
            if (uniqueSet.add(element)) {
                finalArray[i++] = element;
            }
        }
        // finalArray will be the original size with default values
        // So, we can copy to a new array
        original = Arrays.copyOf(finalArray, i);
        System.out.print("Solution 1: Final Unique Elements =                  " + Arrays.toString(original));
        return original;
    }

    /**
     * Solution  2
     * This solution could be used when order is not a requirement.
     * Very simple implementation, but order is not guaranteed
     *
     */

    /**
     * @return Object[]
     * @throws Exception
     */
    private Object[] removeAllDuplicates() throws Exception {
        int[] orgArray = randomIntegers;
        System.out.println("Original Array =                 " + Arrays.toString(orgArray));
        Set<Integer> finalSet = new HashSet<Integer>();

        for (int originalArray : orgArray) {
            finalSet.add(originalArray);
        }
        System.out.print("Solution 2: Final Unique Elements =                   " + finalSet.toString());
        return finalSet.toArray();
    }

    /**
     * Solution 3
     * Implemented Sorting approach and is done with O(logn) efficiency. O(n) is the final efficiency
     * Order of the elements is not maintained as sorting is done before hand.
     *
     */

    /**
     * @return int[]
     * @throws Exception
     */
    private int[] removeAllDuplicatesAndSort() throws Exception {
        int[] orgArray = randomIntegers;
        System.out.println("Original Array =                 " + Arrays.toString(orgArray));
        // Sort the array so that duplicate removal would be quicker.
        // Typically this is faster than traditional (one-pivot) Quicksort implementations as per Java API.
        Arrays.sort(orgArray);

        final int[] uniqueInt = new int[orgArray.length];
        int prev = orgArray[0];
        uniqueInt[0] = prev;
        int count = 1;
        for (int i = 1; i < orgArray.length; ++i) {
            if (orgArray[i] != prev) {
                uniqueInt[count++] = orgArray[i];
            }
            prev = orgArray[i];
        }
        final int[] finalArray = new int[count];
        System.arraycopy(uniqueInt, 0, finalArray, 0, count);
        System.out.print("Solution 3: Final Unique Elements =                   " + Arrays.toString(finalArray));
        return finalArray;
    }
}

