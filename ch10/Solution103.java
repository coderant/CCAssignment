package ch10;

import java.util.*;

public class Solution103 {

    public static int searchInRotated(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] >= array[start]) {
                if (target >= array[start] && target <= array[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target >= array[mid] && target <= array[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (array[start] == target) {
            return start;
        }

        if (array[end] == target) {
            return end;
        }
        return -1;
    }

    // Test Method Below

    public static void main(String[] args) {
        test();
        test();
        test();
        test();
        test();
        test();
        test();
        test();
        test();
        test();
        test();
    }

    private static void test() {
        Random generator = new Random();

        int[] list = generateList(1231, generator.nextInt(30) + 1);
        int shift = generator.nextInt(list.length);
        list = shiftArray(list, shift);
        int index = generator.nextInt(list.length);


        System.out.println(Arrays.toString(list));
        System.out.println("The target number is " + list[index] + " at index[" + index + "]");
        System.out.println("searched result is : " + searchInRotated(list, list[index]));
    }

    private static int[] generateList(int maximum, int length) {
        Random generator = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = generator.nextInt(maximum);
        }
        Arrays.sort(result);
        return result;
    }

    private static int[] shiftArray(int[] array, int shift) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[(i+shift) % array.length];
        }
        return newArray;
    }

}
