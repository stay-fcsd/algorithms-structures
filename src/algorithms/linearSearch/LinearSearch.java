package algorithms.linearSearch;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 10, 8, 7};

        boolean found = selectionSort(arr, 80);

        System.out.println(found);
    }

    public static boolean selectionSort(int[] arr, int value) {
        for (int number : arr) {
            if (number == value) return true;
        }return false;
    }

}
