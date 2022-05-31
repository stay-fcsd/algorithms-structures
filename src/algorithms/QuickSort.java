package algorithms;

/*
Time Complexity
Best	O(n*log n)
Worst	O(n2)
Average	O(n*log n)
Space Complexity	O(log n)
Stability	No
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] sorted = quickSort(new int[]{1, 33, 22, 10, 11, 34, 88, 77});

        for (int i : sorted) System.out.println(i);
    }

    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left >= right) return arr;

        int pivot = arr[(left + right) / 2];
        int index = partition(arr, left, right, pivot);
        quickSort(arr, left, index -1);
        quickSort(arr, index, right);

        return arr;
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            // find element greater than pivot starting from the left
            while (arr[left] < pivot) {
                left++;
            }
            // find element less than pivot starting from the right
            while (arr[right] > pivot) {
                right--;
            }
            // swap values if index from left and right don't overlap
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


}
